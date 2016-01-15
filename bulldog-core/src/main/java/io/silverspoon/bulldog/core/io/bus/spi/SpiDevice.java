package io.silverspoon.bulldog.core.io.bus.spi;

import io.silverspoon.bulldog.core.io.bus.BusDevice;

import java.io.IOException;

public class SpiDevice extends BusDevice {

   public SpiDevice(SpiConnection connection) {
      super(connection);
   }

   public SpiDevice(SpiBus bus, int address) {
      this(bus.createSpiConnection(address));
   }

   public SpiMessage transfer(byte[] bytes) throws IOException {
      return getBusConnection().transfer(bytes);
   }

   public SpiConnection getBusConnection() {
      return (SpiConnection) super.getBusConnection();
   }

}
