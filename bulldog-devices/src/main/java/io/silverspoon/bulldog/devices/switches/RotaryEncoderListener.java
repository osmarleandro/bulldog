package io.silverspoon.bulldog.devices.switches;

import io.silverspoon.bulldog.core.gpio.event.ValueChangedListener;

public interface RotaryEncoderListener extends ValueChangedListener<Integer> {

	void turnedClockwise();

	void turnedCounterclockwise();

}
