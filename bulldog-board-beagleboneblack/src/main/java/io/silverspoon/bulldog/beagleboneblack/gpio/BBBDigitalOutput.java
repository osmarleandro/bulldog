package io.silverspoon.bulldog.beagleboneblack.gpio;

import io.silverspoon.bulldog.beagleboneblack.BeagleBonePin;
import io.silverspoon.bulldog.beagleboneblack.jni.NativeGpio;
import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.base.AbstractDigitalOutput;
import io.silverspoon.bulldog.core.pin.Pin;

public class BBBDigitalOutput extends AbstractDigitalOutput {

   public BBBDigitalOutput(Pin pin) {
      super(pin);
   }

   protected void setupImpl() {
      BeagleBonePin bbbPin = (BeagleBonePin) getPin();
      NativeGpio.pinMode(bbbPin.getPortNumeric(), bbbPin.getIndexOnPort(), NativeGpio.DIRECTION_OUT);
      int res = NativeGpio.digitalRead(bbbPin.getPortNumeric(), bbbPin.getIndexOnPort());
      setSignal((res != 0) ? Signal.High : Signal.Low);
   }

   protected void teardownImpl() {
   }

   @Override
   protected void applySignalImpl(Signal signal) {
      BeagleBonePin bbbPin = (BeagleBonePin) getPin();
      NativeGpio.digitalWrite(bbbPin.getPortNumeric(), bbbPin.getIndexOnPort(), signal == Signal.High ? NativeGpio.HIGH : NativeGpio.LOW);
   }

}
