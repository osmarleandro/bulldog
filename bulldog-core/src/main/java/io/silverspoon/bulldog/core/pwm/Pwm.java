package io.silverspoon.bulldog.core.pwm;

import io.silverspoon.bulldog.core.pin.PinFeature;

public interface Pwm extends PinFeature {

   void enable();

   void disable();

   boolean isEnabled();

   void setDuty(double duty);

   double getDuty();

   void setFrequency(double frequency);

   double getFrequency();
}