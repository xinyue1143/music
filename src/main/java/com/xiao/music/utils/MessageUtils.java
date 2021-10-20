package com.xiao.music.utils;/**
 * Description: music
 * Created by 28191 on 2021/10/18
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiao.music.pojo.ResultMessage;

/**
 *@Classname MessageUtils
 *@Description TODO
 *@Author 28191
 *@DATE 2021/10/18 12:21
 *@version 1.0
 */
public class MessageUtils {
    public static String getMessage(boolean isSystemMessage,String fromName,Object message){
        try {
            ResultMessage result = new ResultMessage();
            result.setIsSystem(isSystemMessage);
            result.setMessage(message);
            if(fromName != null){
                result.setFromName(fromName);
            }
            ObjectMapper mapper = new ObjectMapper();

            return mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
