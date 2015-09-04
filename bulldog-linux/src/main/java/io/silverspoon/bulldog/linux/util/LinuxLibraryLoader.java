package io.silverspoon.bulldog.linux.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class LinuxLibraryLoader {

   public static final String LIB_NAME = System.getProperty("bulldog.native",
         "bulldog-linux-native");
   public static final String ARCH = System.getProperty("bulldog.arch",
         "hardfp");

   private static void loadLibraryFromSystem() {
      System.loadLibrary(LIB_NAME);
   }

   private static void loadLibraryFromClasspath(String path) throws IOException {
      File targetFile = File.createTempFile(LIB_NAME, ".so");
      targetFile.deleteOnExit();
      try (InputStream source = LinuxLibraryLoader.class.getResourceAsStream(path)) {
         if (source == null) {
            throw new FileNotFoundException("File " + path + " was not found in classpath.");
         }
         Files.copy(source, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
      }
      // Finally, load the library
      System.load(targetFile.getAbsolutePath());
   }

   public static void loadNativeLibrary(String board) {
      //Construct name of native library
      String libName = LIB_NAME + "-" + board;
      // First, try to load library from classpath
      try {
         loadLibraryFromClasspath("/lib/" + libName + ".so");
      } catch (IOException e) {
         // If we cannot, try system library
         e.printStackTrace();
         loadLibraryFromSystem();
      }
   }
}
