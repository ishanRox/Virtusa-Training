package com.design.singeleton.service;

public class SystemInfoManager {


    private static volatile SystemInfoManager systemInfoManager;
    private static volatile String systemInfoList;


    private SystemInfoManager() {
        if (systemInfoManager != null) {
            throw new RuntimeException("Please use the get SystemInfo Manager");
        }
    }


    public static SystemInfoManager getSystemInfoManager() {
        if (systemInfoManager == null) {
            synchronized (SystemInfoManager.class) {
                if (systemInfoManager == null) {
                    systemInfoManager = new SystemInfoManager();
                }
            }
        }

        return systemInfoManager;
    }

    public  String getSystemInfoList() {
        if (systemInfoList == null) {
            synchronized (SystemInfoManager.class) {
                if (systemInfoList == null) {

                    systemInfoList = "Operating Sytem :" + System.getProperty("os.name") +
                            "\nDataModel :" + System.getProperty("os.arch.data.model") +
                            "\nVirtual Machine Version :" + System.getProperty("java.vm.version") +
                            "\nOs Architecture :" + System.getProperty("os.arch");
                }
            }
        }

        return systemInfoList;
    }
}
