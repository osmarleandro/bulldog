package io.silverspoon.bulldog.cubieboard;

import io.silverspoon.bulldog.core.platform.Board;
import io.silverspoon.bulldog.core.platform.BoardFactory;
import io.silverspoon.bulldog.linux.sysinfo.CpuInfo;

public class CubieboardBoardFactory implements BoardFactory {

   @Override
   public boolean isCompatibleWithPlatform() {
      return CpuInfo.getHardware().contains("sun7i");
   }

   @Override
   public Board createBoard() {
      return Cubieboard.getInstance();
   }
}