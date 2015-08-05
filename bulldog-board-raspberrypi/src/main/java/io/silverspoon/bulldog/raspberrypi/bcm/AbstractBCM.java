package io.silverspoon.bulldog.raspberrypi.bcm;

import io.silverspoon.bulldog.linux.io.mmap.MemoryMap;

/**
 * Representation of BCM
 * Class holds common functionality for BCM
 */
public abstract class AbstractBCM {

   private MemoryMap gpioMemory;
   private MemoryMap pwmMemory;
   private MemoryMap clockMemory;

   public abstract int getBCMPeriBase();

   public abstract int getGPIOBase();

   public abstract int getPWMBase();

   public abstract int getClockBase();

   public abstract int getPWMClkCntl();

   public abstract int getPWMClkDiv();

   public abstract int getPWMCtl();

   public abstract int getPWMRng1();

   public abstract int getPWMDat1();

   public abstract int getGPIOSet();

   public abstract int getGPIOClear();

   public MemoryMap getGpioMemory() {
      if (gpioMemory == null) {
         gpioMemory = new MemoryMap("/dev/mem", this.getGPIOBase(), 4096, 0);
      }

      return gpioMemory;
   }

   public MemoryMap getPwmMemory() {
      if (pwmMemory == null) {
         pwmMemory = new MemoryMap("/dev/mem", this.getPWMBase(), 4096, 0);
      }

      return pwmMemory;
   }

   public MemoryMap getClockMemory() {
      if (clockMemory == null) {
         clockMemory = new MemoryMap("/dev/mem", this.getClockBase(), 4096, 0);
      }

      return clockMemory;
   }

   public void cleanup() {
      if (gpioMemory != null) {
         gpioMemory.closeMap();
      }
      if (pwmMemory != null) {
         pwmMemory.closeMap();
      }
      if (clockMemory != null) {
         clockMemory.closeMap();
      }
   }

   public void configureAsInput(int gpio) {
      long address = (gpio / 10) * 4;
      int value = this.getGpioMemory().getIntValueAt(address);
      value &= ~(7 << getGpioRegisterOffset(gpio));
      this.getGpioMemory().setIntValue(address, value);
   }

   public void configureAsOutput(int gpio) {
      long address = (gpio / 10) * 4;
      int value = this.getGpioMemory().getIntValueAt(address);
      value |= (1 << getGpioRegisterOffset(gpio));
      this.getGpioMemory().setIntValue(address, value);
   }

   public void configureAlternateFunction(int gpio, int alt) {
      long address = (gpio / 10) * 4;
      int value = this.getGpioMemory().getIntValueAt(address);
      value |= (((alt) <= 3 ? (alt) + 4 : (alt) == 4 ? 3 : 2) << (gpio % 10) * 3);
      this.getGpioMemory().setIntValue(address, value);
   }

   public int getGpioRegisterOffset(int gpio) {
      return (gpio % 10) * 3;
   }
}

