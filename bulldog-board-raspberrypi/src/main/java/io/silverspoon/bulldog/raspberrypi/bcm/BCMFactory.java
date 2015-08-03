package io.silverspoon.bulldog.raspberrypi.bcm;

import io.silverspoon.bulldog.linux.sysinfo.CpuInfo;


public class BCMFactory {

    public static final String BCM2708_NAME = "BCM2708";
    public static final String BCM2709_NAME = "BCM2709";

    private static AbstractBCM instance = null;

    public static AbstractBCM getBCM() {
        if (instance == null) {
            String name = CpuInfo.getHardware();
            if (name.contains(BCM2708_NAME)) {
                instance = new BCM2835();
            } else if (name.contains(BCM2709_NAME)) {
                instance = new BCM2836();
            } else {
                throw new IllegalArgumentException(name);
            }
        }

        return instance;
    }
}
