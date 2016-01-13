package io.silverspoon.bulldog.raspberrypi.io;

import io.silverspoon.bulldog.core.io.bus.i2c.AbstractI2cPinFeature;
import io.silverspoon.bulldog.core.io.bus.i2c.I2cBus;
import io.silverspoon.bulldog.core.io.bus.i2c.I2cSignalType;
import io.silverspoon.bulldog.core.pin.Pin;

public class RaspberryPiI2cPinFeature extends AbstractI2cPinFeature {

   public RaspberryPiI2cPinFeature(I2cBus bus, Pin pin, I2cSignalType signalType) {
      super(pin, signalType);
   }

   @Override
   public boolean isBlocking() {
      return false;
   }

   @Override
   protected void setupImpl() {
   }

   @Override
   protected void teardownImpl() {
   }

   @Override
   public I2cBus getI2cBus() {
      return null;
   }

}
