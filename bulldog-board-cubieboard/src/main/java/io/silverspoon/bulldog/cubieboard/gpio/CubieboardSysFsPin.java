package io.silverspoon.bulldog.cubieboard.gpio;

import io.silverspoon.bulldog.linux.sysfs.SysFsPin;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CubieboardSysFsPin extends SysFsPin {
   private static final String directory = "/sys/class/gpio";

   private String fsName;
   private boolean interrupt;

   public CubieboardSysFsPin(int pin, String fsName, boolean interrupt) {
      super(pin);
      this.fsName = fsName;
      this.interrupt = interrupt;
   }

   @Override
   public Path getPinDirectory() {
      return Paths.get(directory, "/gpio" + fsName + "/");
   }

   @Override
   public void setEdge(String edge) {
      if (interrupt) {
         super.setEdge(edge);
      }
   }
}
