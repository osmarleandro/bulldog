package io.silverspoon.bulldog.core.io.bus.i2c;

import io.silverspoon.bulldog.core.io.bus.Bus;
import io.silverspoon.bulldog.core.pin.Pin;

import java.io.IOException;

public interface I2cBus extends Bus {

   Pin getSDA();

   Pin getSCL();

   int getFrequency();

   void writeByteToRegister(int register, int b) throws IOException;

   void writeBytesToRegister(int register, byte[] bytes) throws IOException;

   byte readByteFromRegister(int register) throws IOException;

   int readBytesFromRegister(int register, byte[] buffer) throws IOException;

   I2cConnection createI2cConnection(int address);
}
