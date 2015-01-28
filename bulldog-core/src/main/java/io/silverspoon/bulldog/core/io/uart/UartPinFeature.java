package io.silverspoon.bulldog.core.io.uart;

import io.silverspoon.bulldog.core.gpio.PinFeature;

public interface UartPinFeature extends PinFeature {

	public UartPort getPort();
}
