package io.silverspoon.bulldog.linux.gpio;

import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.base.AbstractDigitalOutput;
import io.silverspoon.bulldog.core.pin.Pin;
import io.silverspoon.bulldog.linux.sysfs.SysFsPin;

public class LinuxDigitalOutput extends AbstractDigitalOutput {

   private SysFsPin sysFsPin;

   public LinuxDigitalOutput(Pin pin) {
      super(pin);
      sysFsPin = createSysFsPin(pin);
   }

   protected SysFsPin createSysFsPin(Pin pin) {
      return new SysFsPin(pin.getAddress());
   }

   @Override
   protected void setupImpl() {
      exportPinIfNecessary();
   }

   @Override
   protected void teardownImpl() {
      unexportPin();
   }

   protected void exportPinIfNecessary() {
      sysFsPin.exportIfNecessary();
      sysFsPin.setDirection("out");
   }

   protected void unexportPin() {
      sysFsPin.unexport();
   }

   @Override
   protected void applySignalImpl(Signal signal) {
      sysFsPin.setValue(signal);
   }

}
