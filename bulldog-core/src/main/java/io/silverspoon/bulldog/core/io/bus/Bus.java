package io.silverspoon.bulldog.core.io.bus;

import io.silverspoon.bulldog.core.io.IOPort;

import java.io.IOException;

public interface Bus extends IOPort {

   public void selectSlave(int address) throws IOException;

   public boolean isSlaveSelected(int address);

   public BusConnection createConnection(int address);
}
