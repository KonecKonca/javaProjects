package org.jnativehook.keyboard;

import java.util.EventListener;

public abstract interface NativeKeyListener
  extends EventListener
{
  public abstract void nativeKeyTyped(NativeKeyEvent paramNativeKeyEvent);
  
  public abstract void nativeKeyPressed(NativeKeyEvent paramNativeKeyEvent);
  
  public abstract void nativeKeyReleased(NativeKeyEvent paramNativeKeyEvent);
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\keyboard\NativeKeyListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */