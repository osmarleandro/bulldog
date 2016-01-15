package io.silverspoon.bulldog.cubieboard.gpio;

import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.base.AbstractDigitalOutput;
import io.silverspoon.bulldog.core.pin.Pin;

public class CubieboardDigitalOutput extends AbstractDigitalOutput {

   private final CubieboardGpioMemory gpioMemory;
   private final int pinIndex;
   private final int portIndex;

   public CubieboardDigitalOutput(Pin pin, CubieboardGpioMemory gpioMemory, int portIndex) {
      super(pin);

      this.gpioMemory = gpioMemory;
      this.pinIndex = pin.getIndexOnPort();
      this.portIndex = portIndex;
   }

   @Override protected void setupImpl() {
      gpioMemory.setPinDirection(portIndex, pinIndex, 1);
      int res = gpioMemory.getPinValue(portIndex, pinIndex);
      if (res != 0) {
         setSignal(Signal.High);
      } else {
         setSignal(Signal.Low);
      }

   }

   @Override protected void teardownImpl() {
   }

   @Override
   protected void applySignalImpl(Signal signal) {
      gpioMemory.setPinValue(portIndex, pinIndex, signal.getNumericValue());
   }
}
