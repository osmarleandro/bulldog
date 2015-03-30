package io.silverspoon.bulldog.linux.sysfs;

import io.silverspoon.bulldog.core.Signal;
import io.silverspoon.bulldog.core.util.BulldogUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SysFsPin {

   private String directory = "/sys/class/gpio";
   private int pin = 0;

   public SysFsPin(int pin) {
      this.pin = pin;
   }

   public boolean isExported() {
      return Files.exists(getPinDirectory());
   }

   public void exportIfNecessary() {
      if (!isExported()) {
         echoToFile(getPinString(), Paths.get(directory, "/export"));
         
         long startTime = System.currentTimeMillis();
         while (!Files.exists(getValueFilePath())) {
            BulldogUtil.sleepMs(10);
            if ((System.currentTimeMillis() - startTime) >= 10000) {
               throw new RuntimeException("Could not create pin - waited 10 seconds. Aborting.");
            }
         }
      }
   }

   public void unexport() {
      if (isExported()) {
         echoToFile(getPinString(), Paths.get(directory, "/unexport"));
      }
   }

   public void setEdge(String edge) {
      echoToFile(edge, Paths.get(getPinDirectory() + "/edge"));
   }

   public void setDirection(String direction) {
      echoToFile(direction, Paths.get(getPinDirectory() + "/direction"));
   }

   public Path getPinDirectory() {
      return Paths.get(directory, "/gpio", getPinString());
   }

   public Path getValueFilePath() {
      return Paths.get(getPinDirectory() + "/value");
   }

   private String getPinString() {
      return String.valueOf(pin);
   }

   public String getBaseDirectory() {
      return directory;
   }

   public Signal getValue() {
      try {
         return Signal.fromString(new String(Files.readAllBytes(getValueFilePath())));
      } catch (IOException e) {
         System.err.format("IOException: %s%n", e);
      }
      return null;
   }

   public void setValue(Signal signal) {
      echoToFile(String.valueOf(signal.getNumericValue()), getPinDirectory());
   }

   private void echoToFile(String value, Path file) {
      try (BufferedWriter writer = Files.newBufferedWriter(file, Charset.forName("UTF-8"), StandardOpenOption.TRUNCATE_EXISTING)) {
         writer.write(value);
      } catch (IOException x) {
         System.err.format("IOException: %s%n", x);
      }
   }
}
