package io.silverspoon.bulldog.core.platform;

import io.silverspoon.bulldog.core.pin.Pin;

import java.util.List;

public interface PinProvider {

   List<Pin> getPins();

   Pin getPinByAlias(String alias);

   Pin getPin(int address);

   Pin getPin(String name);

   Pin getPin(String port, int indexOnPort);

}
