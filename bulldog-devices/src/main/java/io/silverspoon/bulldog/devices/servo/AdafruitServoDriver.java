package io.silverspoon.bulldog.devices.servo;

import io.silverspoon.bulldog.core.io.bus.i2c.I2cBus;
import io.silverspoon.bulldog.core.io.bus.i2c.I2cConnection;
import io.silverspoon.bulldog.devices.pwmdriver.PCA9685;

public class AdafruitServoDriver extends PCA9685 {

   private static final String NAME = "ADAFRUIT 16-CHANNEL 12-BIT PWM/SERVO DRIVER - I2C INTERFACE";

   public AdafruitServoDriver(I2cConnection connection) {
      super(connection);
      setName(NAME);
   }

   public AdafruitServoDriver(I2cBus bus, int address) {
      this(bus.createI2cConnection(address));
   }
}
