package com.hyp.settings.test;

import com.hyp.crm.utils.DateTimeUtil;
import com.hyp.crm.utils.MD5Util;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HYP
 * @create 2020-11-15 22:09
 */
public class Test1 {
    @Test
    public void test01(){
        //验证失效时间
        /* String expireTime = "2019-10-10 10:10:10";
        *//*Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = sdf.format(date);
        System.out.println(str);*//*
        String sysTime = DateTimeUtil.getSysTime();
        int i = expireTime.compareTo(sysTime);
        System.out.println(i);*/
        /*String pwd = "123";
        String md5 = MD5Util.getMD5(pwd);
        System.out.println(md5);*/
    }

}
