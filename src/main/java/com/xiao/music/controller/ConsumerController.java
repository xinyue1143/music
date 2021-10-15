package com.xiao.music.controller;/**
 * Description: music
 * Created by 28191 on 2021/9/28
 */


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.music.pojo.Consumer;
import com.xiao.music.service.ConsumerService;
import com.xiao.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


/**
 *@Classname ConsumerController
 *@Description TODO
 *@Author 28191
 *@DATE 2021/9/28 9:42
 *@version 1.0
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;


    /**
     * 添加前端用户
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addConsumer(@RequestBody Consumer consumer){
        JSONObject jsonObject = new JSONObject();
        boolean flag = consumerService.insert(consumer);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"添加成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"添加失败");
        return jsonObject;
    }

    /**
     * 修改前端用户
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateConsumer(@RequestBody Consumer consumer){
        JSONObject jsonObject = new JSONObject();
        boolean flag = consumerService.update(consumer);
        if(flag){   //保存成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"修改成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"修改失败");
        return jsonObject;
    }


    /**
     * 删除前端用户
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteConsumer(HttpServletRequest request){
        String id = request.getParameter("id").trim();          //主键
        boolean flag = consumerService.delete(Integer.parseInt(id));
        return flag;
    }

    /**
     * 根据主键查询整个对象
     */
    @RequestMapping(value = "/selectByPrimaryKey",method = RequestMethod.GET)
    public Object selectByPrimaryKey(HttpServletRequest request){
        String id = request.getParameter("id").trim();          //主键
        return consumerService.selectByPrimaryKey(Integer.parseInt(id));
    }

    /**
     * 查询所有前端用户
     */
    @RequestMapping(value = "/allConsumer",method = RequestMethod.GET)
    public Object allConsumer(HttpServletRequest request){
        return consumerService.allConsumer();
    }


    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param search
     * @return
     */
    @GetMapping("/page")
    public Object findPage(@RequestParam(defaultValue = "2")Integer pageNum,
                              @RequestParam(defaultValue = "5")Integer pageSize,
                              @RequestParam(defaultValue = "")String search ){
        LambdaQueryWrapper<Consumer> wrapper = Wrappers.<Consumer>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Consumer::getUsername, search);
        }

        Page<Consumer> consumerPage = consumerService.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return consumerPage;
    }

    /**
     * 按用户名查询用户
     */
    @GetMapping("/consumerOfName")
    public Object consumerOfName(@RequestParam("username") String username){
        Consumer consumer = consumerService.getByUsername(username);
        JSONObject jsonObject = new JSONObject();
        if (consumer != null){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"该用户名已存在");
        }else {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名不存在，可以使用");
        }
        return jsonObject;
    }


    /**
     * 更新前端用户图片
     */
    @RequestMapping(value = "/updateConsumerPic",method = RequestMethod.POST)
    public Object updateConsumerPic(@RequestParam("file") MultipartFile avatorFile, @RequestParam("id")int id){
        JSONObject jsonObject = new JSONObject();
        if(avatorFile.isEmpty()){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"文件上传失败");
            return jsonObject;
        }
        //文件名=当前时间到毫秒+原来的文件名
        String fileName = System.currentTimeMillis()+avatorFile.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir")+System.getProperty("file.separator")+"avatorImages";
        //如果文件路径不存在，新增该路径
        File file1 = new File(filePath);
        if(!file1.exists()){
            file1.mkdir();
        }
        //实际的文件地址
        File dest = new File(filePath+System.getProperty("file.separator")+fileName);
        //存储到数据库里的相对文件地址
        String storeAvatorPath = "/avatorImages/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Consumer consumer = new Consumer();
            consumer.setId(id);
            consumer.setAvator(storeAvatorPath);
            boolean flag = consumerService.update(consumer);
            if(flag){
                jsonObject.put(Consts.CODE,1);
                jsonObject.put(Consts.MSG,"上传成功");
                jsonObject.put("avator",storeAvatorPath);
                return jsonObject;
            }
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败");
            return jsonObject;
        } catch (IOException e) {
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"上传失败"+e.getMessage());
        }finally {
            return jsonObject;
        }
    }
    /**
     * 前端用户登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String username = request.getParameter("username").trim();     //账号
        String password = request.getParameter("password").trim();     //密码
        if(username==null||username.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名不能为空");
            return jsonObject;
        }
        if(password==null||password.equals("")){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"密码不能为空");
            return jsonObject;
        }

        //保存到前端用户的对象中
        Consumer consumer = new Consumer();
        consumer.setUsername(username);
        consumer.setPassword(password);
        boolean flag = consumerService.verifyPassword(username,password);
        if(flag){   //验证成功
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"登录成功");
            jsonObject.put("userMsg",consumerService.getByUsername(username));
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"用户名或密码错误");
        return jsonObject;
    }

}
