package com.design.singeleton.controller;


import com.design.singeleton.service.SystemInfoManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class singeletonController {






    @RequestMapping(value = "/getInfo")
    public static String getInfo(String[] args) {

        long start;
        long end;

        start=System.currentTimeMillis();
        SystemInfoManager manager = SystemInfoManager.getSystemInfoManager();
        String info=manager.getSystemInfoList();
        end=System.currentTimeMillis();

        System.out.println(manager);
        System.out.println(end-start);
        return info;
    }


}
