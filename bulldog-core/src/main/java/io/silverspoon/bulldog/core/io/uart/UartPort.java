package io.silverspoon.bulldog.core.io.uart;

import io.silverspoon.bulldog.core.io.serial.SerialPort;
import io.silverspoon.bulldog.core.pin.Pin;

public interface UartPort extends SerialPort {

   public Pin getRx();

   public Pin getTx();

}
