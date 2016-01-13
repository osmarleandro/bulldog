package io.silverspoon.bulldog.beagleboneblack.gpio;

import io.silverspoon.bulldog.beagleboneblack.BeagleBonePin;
import io.silverspoon.bulldog.beagleboneblack.jni.NativeGpio;
import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.pin.Pin;
import io.silverspoon.bulldog.linux.gpio.LinuxDigitalInput;

public class BBBDigitalInput extends LinuxDigitalInput {

   public BBBDigitalInput(Pin pin) {
      super(pin);
   }

   public Signal read() {
      BeagleBonePin bbbPin = (BeagleBonePin) getPin();
      return Signal.fromNumericValue(NativeGpio.digitalRead(bbbPin.getPortNumeric(), bbbPin.getIndexOnPort()));
   }

   public void setup() {
      super.setup();
      BeagleBonePin bbbPin = (BeagleBonePin) getPin();
      NativeGpio.pinMode(bbbPin.getPortNumeric(), bbbPin.getIndexOnPort(), NativeGpio.DIRECTION_IN);
   }

}
