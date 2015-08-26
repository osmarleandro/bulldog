package io.silverspoon.bulldog.linux.util;


public class MMapFailedException extends RuntimeException {

   public MMapFailedException() {
      super();
   }

   public MMapFailedException(String message, Throwable cause) {
      super(message, cause);
   }

   public MMapFailedException(Throwable cause) {
      super(cause);
   }

   public MMapFailedException(String message) {
      super(message);
   }
}
