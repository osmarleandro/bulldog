package io.silverspoon.bulldog.core.io.serial;

import io.silverspoon.bulldog.core.Parity;
import io.silverspoon.bulldog.core.io.IOPort;

public interface SerialPort extends IOPort {

   int getBaudRate();

   void setBaudRate(int baudRate);

   Parity getParity();

   void setParity(Parity parity);

   int getDataBits();

   void setDataBits(int dataBits);

   int getStopBits();

   void setStopBits(int stopBits);

   void setBlocking(boolean blocking);

   boolean getBlocking();

   void addListener(SerialDataListener listener);

   void removeListener(SerialDataListener listener);
}
