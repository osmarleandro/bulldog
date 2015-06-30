package io.silverspoon.bulldog.raspberrypi;

import io.silverspoon.bulldog.core.platform.Board;
import io.silverspoon.bulldog.core.platform.BoardFactory;
import io.silverspoon.bulldog.linux.sysinfo.CpuInfo;
import io.silverspoon.bulldog.linux.util.LinuxLibraryLoader;

public class RaspberryPiBoardFactory implements BoardFactory {

   @Override
   public boolean isCompatibleWithPlatform() {
      // if broadcom chip is present
      return CpuInfo.getHardware().contains("BCM");
   }

   @Override
   public Board createBoard() {
      LinuxLibraryLoader.loadNativeLibrary("raspberrypi");
      return new RaspberryPi();
   }
}
