package io.silverspoon.bulldog.devices.portexpander;

import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.base.AbstractDigitalOutput;
import io.silverspoon.bulldog.core.pin.Pin;
import io.silverspoon.bulldog.core.util.BitMagic;

public class PCF8574DigitalOutput extends AbstractDigitalOutput {

   private PCF8574 expander;

   public PCF8574DigitalOutput(Pin pin, PCF8574 expander) {
      super(pin);
      this.expander = expander;
   }

   @Override
   protected void setupImpl() {
   }

   @Override
   protected void teardownImpl() {
   }

   @Override
   protected void applySignalImpl(Signal signal) {
      byte state = expander.getState();
      byte newState = BitMagic.setBit(state, getPin().getAddress(), signal.getNumericValue());
      expander.writeState(newState);
   }

   @Override
   public Signal getAppliedSignal() {
      return Signal.fromNumericValue(BitMagic.getBit(expander.getState(), getPin().getAddress()));
   }

}
