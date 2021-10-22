package com.xiao.music.controller;/**
 * Description: music
 * Created by 28191 on 2021/10/20
 */

import com.alibaba.fastjson.JSONObject;
import com.xiao.music.pojo.Rank;
import com.xiao.music.pojo.Record;
import com.xiao.music.service.RecordService;
import com.xiao.music.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *@Classname RecordController
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/20 11:08
 *@version 1.0
 */
@RestController
public class RecordController {

    @Autowired
    RecordService recordService;

    /**
     * 新增聊天记录
     */
    @RequestMapping(value = "/record/add",method = RequestMethod.POST)
    public Object add(HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        String fromName = request.getParameter("fromName");
        String toName = request.getParameter("toName");
        String message = request.getParameter("message");

        Record record = new Record();
        record.setFromName(fromName);
        record.setToName(toName);
        record.setMessage(message);
        boolean flag = recordService.insert(record);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"发送成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE,0);
        jsonObject.put(Consts.MSG,"发送失败");
        return jsonObject;
    }

    /**
     * 查询聊天信息
     */
    @RequestMapping(value = "/record/detail",method = RequestMethod.GET)
    public Object allSinger(HttpServletRequest request){
        String firstUser = request.getParameter("firstUser");
        String secondUser = request.getParameter("secondUser");
        return recordService.selectRecordByUsers(firstUser,secondUser);
    }
}
