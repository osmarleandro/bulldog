package io.silverspoon.bulldog.core.io.uart;

import io.silverspoon.bulldog.core.gpio.Pin;
import io.silverspoon.bulldog.core.io.serial.SerialPort;

public interface UartPort extends SerialPort {

   public Pin getRx();

   public Pin getTx();

}
