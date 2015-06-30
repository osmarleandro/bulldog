package io.silverspoon.bulldog.linux.sysinfo;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class CpuInfo {

   private static Logger LOG = Logger.getLogger(CpuInfo.class);

   private static final String CPU_REVISION = "CPU revision";
   private static final String HW = "Hardware";

   private static HashMap<String, String> properties = new HashMap<String, String>();

   static {
      String cpuInfo = readFile("/proc/cpuinfo");
      String[] infos = cpuInfo.split("\n");
      for (String info : infos) {
         String[] tokens = info.split(":");
         if (tokens.length >= 2) {
            properties.put(tokens[0].trim(), tokens[1].trim());
         }
      }
   }

   public static String getCPURevision() {
      return properties.get(CPU_REVISION);
   }

   public static String getHardware() {
      return properties.get(HW);
   }

   private static String readFile(String path) {
      try {
         byte[] encoded = Files.readAllBytes(Paths.get(path));
         return new String(encoded, Charset.defaultCharset());
      } catch (IOException e) {
         LOG.error("Cannot read file " + path, e);
      }

      return "";
   }
}
