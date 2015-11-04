package io.silverspoon.bulldog.raspberrypi.gpio;

import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.Pin;
import io.silverspoon.bulldog.linux.gpio.LinuxDigitalInput;
import io.silverspoon.bulldog.linux.io.LinuxEpollListener;
import io.silverspoon.bulldog.raspberrypi.RaspberryPiPin;
import io.silverspoon.bulldog.raspberrypi.bcm.AbstractBCM;
import io.silverspoon.bulldog.raspberrypi.bcm.BCMFactory;

public class RaspiDigitalInput extends LinuxDigitalInput implements LinuxEpollListener {

   public static final AbstractBCM BCM = BCMFactory.getBCM();

   public RaspiDigitalInput(Pin pin) {
      super(pin);
   }

   @Override
   protected void setupImpl() {
      super.setupImpl();
      RaspberryPiPin pin = getRaspiPin();
      BCM.configureAsInput(pin.getGpioNumber());
      BCM.configureAsOutput(pin.getGpioNumber());

   }

   public Signal read() {
      int address = 1 << getRaspiPin().getGpioNumber();
      return Signal.fromNumericValue(BCM.getGpioMemory().getIntValueAt(address));
   }

   public void setup() {
      super.setup();
   }

   private RaspberryPiPin getRaspiPin() {
      RaspberryPiPin pin = (RaspberryPiPin) getPin();
      return pin;
   }
}

