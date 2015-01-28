package io.silverspoon.bulldog.beagleboneblack.gpio;

import io.silverspoon.bulldog.beagleboneblack.jni.NativeGpio;
import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.Pin;
import io.silverspoon.bulldog.core.gpio.base.AbstractDigitalOutput;

import io.silverspoon.bulldog.beagleboneblack.BeagleBonePin;

public class BBBDigitalOutput extends AbstractDigitalOutput {

	public BBBDigitalOutput(Pin pin) {
		super(pin);
	}

	protected void setupImpl() {
		BeagleBonePin bbbPin = (BeagleBonePin)getPin();
		NativeGpio.pinMode(bbbPin.getPortNumeric(), bbbPin.getIndexOnPort(), NativeGpio.DIRECTION_OUT);
		applySignal(getAppliedSignal());
	}

	protected void teardownImpl() {
	}

	@Override
	protected void applySignalImpl(Signal signal) {
		BeagleBonePin bbbPin = (BeagleBonePin)getPin();
		NativeGpio.digitalWrite(bbbPin.getPortNumeric(), bbbPin.getIndexOnPort(), signal == Signal.High ? NativeGpio.HIGH : NativeGpio.LOW);
	}

}
