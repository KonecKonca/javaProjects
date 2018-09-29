package org.jnativehook.mouse;

import java.util.EventListener;

public abstract interface NativeMouseMotionListener
  extends EventListener
{
  public abstract void nativeMouseMoved(NativeMouseEvent paramNativeMouseEvent);
  
  public abstract void nativeMouseDragged(NativeMouseEvent paramNativeMouseEvent);
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\mouse\NativeMouseMotionListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */