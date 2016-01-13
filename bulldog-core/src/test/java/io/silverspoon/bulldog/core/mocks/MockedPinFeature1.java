package io.silverspoon.bulldog.core.mocks;

import io.silverspoon.bulldog.core.pin.AbstractPinFeature;
import io.silverspoon.bulldog.core.pin.Pin;

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
