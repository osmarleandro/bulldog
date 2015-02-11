package io.silverspoon.bulldog.beagleboneblack.io;

import io.silverspoon.bulldog.core.platform.Board;
import io.silverspoon.bulldog.linux.io.LinuxSpiBus;

public class BBBSpiBus extends LinuxSpiBus {

   public BBBSpiBus(String name, String deviceFilePath, Board board) {
      super(name, deviceFilePath, board);
   }

}
