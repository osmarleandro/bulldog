package io.silverspoon.bulldog.core.io.bus.i2c;

import java.io.IOException;

import io.silverspoon.bulldog.core.gpio.Pin;
import io.silverspoon.bulldog.core.io.bus.Bus;

public interface I2cBus extends Bus {
	
	Pin getSDA();
	Pin getSCL();
	int getFrequency();
	
	void writeByteToRegister(int register, int b) throws IOException;
	void writeBytesToRegister(int register, byte[] bytes) throws IOException;
	
	byte readByteFromRegister(int register) throws IOException;
	int	readBytesFromRegister(int register, byte[] buffer) throws IOException;
	
	I2cConnection createI2cConnection(int address);
}
