package io.silverspoon.bulldog.core.mocks;

import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.base.AbstractDigitalOutput;
import io.silverspoon.bulldog.core.pin.Pin;

public class MockedDigitalOutput extends AbstractDigitalOutput {

	public MockedDigitalOutput(Pin pin) {
		super(pin);
	}

	@Override
	protected void setupImpl() {
	}

	@Override
	protected void teardownImpl() {
	}

	@Override
	protected void applySignalImpl(Signal signal) {
	}

}
