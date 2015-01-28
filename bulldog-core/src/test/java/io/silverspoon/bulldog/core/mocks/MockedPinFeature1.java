package io.silverspoon.bulldog.core.mocks;

import io.silverspoon.bulldog.core.gpio.Pin;
import io.silverspoon.bulldog.core.gpio.base.AbstractPinFeature;

public class MockedPinFeature1 extends AbstractPinFeature {

	public MockedPinFeature1(Pin pin) {
		super(pin);
	
	}

	@Override
	public String getName() {
		return "Mocked Feature";
	}

	@Override
	protected void setupImpl() {
	}

	@Override
	protected void teardownImpl() {
	}
}
