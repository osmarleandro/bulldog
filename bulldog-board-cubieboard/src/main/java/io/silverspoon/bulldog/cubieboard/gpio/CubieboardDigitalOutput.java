package io.silverspoon.bulldog.cubieboard.gpio;

import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.gpio.Pin;
import io.silverspoon.bulldog.linux.gpio.LinuxDigitalOutput;
import io.silverspoon.bulldog.linux.sysfs.SysFsPin;

import io.silverspoon.bulldog.cubieboard.CubieboardPin;

public class CubieboardDigitalOutput extends LinuxDigitalOutput {

    private final CubieboardGpioMemory gpioMemory;
    private final int pinIndex;
    private final int portIndex;

    public CubieboardDigitalOutput(Pin pin, CubieboardGpioMemory gpioMemory, int portIndex) {
		super(pin);

        this.gpioMemory = gpioMemory;
        this.pinIndex = pin.getIndexOnPort();
        this.portIndex = portIndex;
    }

    @Override
    protected SysFsPin createSysFsPin(Pin pin) {
        return new CubieboardSysFsPin(pin.getAddress(), ((CubieboardPin)pin).getFsName(), false);
    }

    @Override
    public void setup() {
        super.setup();
        gpioMemory.setPinDirection(portIndex, pinIndex, 1);
    }

    @Override
    protected void applySignalImpl(Signal signal) {
        gpioMemory.setPinValue(portIndex, pinIndex, signal.getNumericValue());
    }
}
