package io.silverspoon.bulldog.core.event;

public interface ValueChangedListener<T> {

   void valueChanged(T oldValue, T newValue);
}
