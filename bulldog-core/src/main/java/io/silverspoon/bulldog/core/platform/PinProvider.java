package io.silverspoon.bulldog.core.platform;

import java.util.List;

import io.silverspoon.bulldog.core.gpio.Pin;

public interface PinProvider {

   List<Pin> getPins();

   Pin getPinByAlias(String alias);

   Pin getPin(int address);

   Pin getPin(String name);

   Pin getPin(String port, int indexOnPort);

}
