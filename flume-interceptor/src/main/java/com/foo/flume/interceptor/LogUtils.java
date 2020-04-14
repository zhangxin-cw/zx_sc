package com.foo.flume.interceptor;

import org.apache.commons.lang.math.NumberUtils;

public class LogUtils {
    public static boolean validateStart(String log) {
        //切割数据
        String[] logContents = log.split("\\|");

        //校验
        if(logContents.length != 2){
            return false;
        }

        //校验服务器时间
        if(logContents[0].length()!=13 || !NumberUtils.isDigits(logContents[0])){
            return false;
        }

        //校验json
        if(!logContents[1].trim().startsWith("{") || !logContents[1].trim().endsWith("}")){
            return false;
        }
        return true;

    }

    public static boolean validateEvent(String log) {

        if(log == null){
            return false;
        }

        if(!log.trim().startsWith("{") || !log.trim().endsWith("}")){
            return false;
        }

        return true;
    }
}
