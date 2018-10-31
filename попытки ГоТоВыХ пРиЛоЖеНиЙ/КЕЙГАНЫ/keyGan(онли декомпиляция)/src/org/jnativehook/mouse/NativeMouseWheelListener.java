package org.jnativehook.mouse;

import java.util.EventListener;

public abstract interface NativeMouseWheelListener
  extends EventListener
{
  public abstract void nativeMouseWheelMoved(NativeMouseWheelEvent paramNativeMouseWheelEvent);
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\mouse\NativeMouseWheelListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */