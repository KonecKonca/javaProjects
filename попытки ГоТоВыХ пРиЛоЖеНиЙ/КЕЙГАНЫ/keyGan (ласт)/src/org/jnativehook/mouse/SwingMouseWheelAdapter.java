package org.jnativehook.mouse;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class SwingMouseWheelAdapter
  extends SwingMouseAdapter
  implements NativeMouseWheelListener, MouseWheelListener
{
  public void nativeMouseWheelMoved(NativeMouseWheelEvent paramNativeMouseWheelEvent)
  {
    mouseWheelMoved(getJavaMouseWheelEvent(paramNativeMouseWheelEvent));
  }
  
  public void mouseWheelMoved(MouseWheelEvent paramMouseWheelEvent) {}
  
  protected MouseWheelEvent getJavaMouseWheelEvent(NativeMouseWheelEvent paramNativeMouseWheelEvent)
  {
    int i = 0;
    if (paramNativeMouseWheelEvent.getScrollType() == 2) {
      i = 1;
    }
    return new MouseWheelEvent(this, paramNativeMouseWheelEvent.getID() - 0, System.currentTimeMillis(), getJavaModifiers(paramNativeMouseWheelEvent.getModifiers()), paramNativeMouseWheelEvent.getX(), paramNativeMouseWheelEvent.getY(), paramNativeMouseWheelEvent.getClickCount(), false, i, paramNativeMouseWheelEvent.getScrollAmount(), paramNativeMouseWheelEvent.getWheelRotation());
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\mouse\SwingMouseWheelAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */