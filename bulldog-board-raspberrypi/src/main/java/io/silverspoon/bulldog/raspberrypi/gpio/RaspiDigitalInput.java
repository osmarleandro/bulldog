package io.silverspoon.bulldog.raspberrypi.gpio;

import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.Pin;
import io.silverspoon.bulldog.linux.gpio.LinuxDigitalInput;
import io.silverspoon.bulldog.linux.io.LinuxEpollListener;

public class RaspiDigitalInput extends LinuxDigitalInput implements LinuxEpollListener {

   public RaspiDigitalInput(Pin pin) {
      super(pin);
   }

   public Signal read() {
      return getSysFsPin().getValue();
   }

   public void setup() {
      super.setup();
   }

}

