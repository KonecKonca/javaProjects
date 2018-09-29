package org.jnativehook.mouse;

import java.util.EventListener;

public abstract interface NativeMouseListener
  extends EventListener
{
  public abstract void nativeMouseClicked(NativeMouseEvent paramNativeMouseEvent);
  
  public abstract void nativeMousePressed(NativeMouseEvent paramNativeMouseEvent);
  
  public abstract void nativeMouseReleased(NativeMouseEvent paramNativeMouseEvent);
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\mouse\NativeMouseListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */