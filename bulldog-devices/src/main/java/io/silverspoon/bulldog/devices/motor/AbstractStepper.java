package io.silverspoon.bulldog.devices.motor;

import io.silverspoon.bulldog.devices.actuators.Actuator;
import io.silverspoon.bulldog.devices.actuators.movement.Move;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class AbstractStepper implements Actuator {

   private ExecutorService executor = Executors.newSingleThreadExecutor();
   private Future<?> currentMove = null;

   public abstract void forward();

   public abstract void backward();

   public abstract void stop();

   public void move(Move move) {
      move.execute(this);
   }

   public void moveAsync(final Move move) {
      currentMove = executor.submit(new Runnable() {

         @Override
         public void run() {
            move(move);
         }

      });
   }

   public void awaitMoveCompleted() {
      if (currentMove != null) {
         try {
            currentMove.get();
         } catch (Exception e) {
            throw new RuntimeException(e);
         }
      }
   }

}
