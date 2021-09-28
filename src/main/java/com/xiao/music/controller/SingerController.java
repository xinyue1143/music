package com.xiao.music.controller;/**
 * Description: music
 * Created by 28191 on 2021/9/28
 */

import com.xiao.music.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Classname SingerController
 *@Description TODO
 *@Author 28191
 *@DATE 2021/9/28 9:42
 *@version 1.0
 */
@RestController
public class SingerController {

    @Autowired
    private SingerService singerService;


}
