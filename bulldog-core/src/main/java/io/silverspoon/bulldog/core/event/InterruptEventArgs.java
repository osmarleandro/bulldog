package io.silverspoon.bulldog.core.event;

import io.silverspoon.bulldog.core.Edge;
import io.silverspoon.bulldog.core.pin.Pin;

public class InterruptEventArgs {

   private Edge edge;

   public InterruptEventArgs(Pin pin, Edge edge) {
      this.edge = edge;
   }

   public Edge getEdge() {
      return edge;
   }

}
