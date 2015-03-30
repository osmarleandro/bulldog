package io.silverspoon.bulldog.core.io.serial;

import io.silverspoon.bulldog.core.util.BulldogUtil;

public class SerialDataEventArgs {

   private byte[] data;
   private SerialPort port;

   public SerialDataEventArgs(SerialPort port, byte[] data) {
      this.port = port;
      this.data = data;
   }

   public byte[] getData() {
      return data;
   }

   public SerialPort getPort() {
      return port;
   }

   public String getDataAsString() {
      return BulldogUtil.bytesToString(getData());
   }
}
