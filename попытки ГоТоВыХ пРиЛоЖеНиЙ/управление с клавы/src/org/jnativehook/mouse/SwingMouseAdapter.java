package org.jnativehook.mouse;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.jnativehook.AbstractSwingInputAdapter;

public class SwingMouseAdapter
  extends AbstractSwingInputAdapter
  implements NativeMouseListener, MouseListener
{
  public void nativeMouseClicked(NativeMouseEvent paramNativeMouseEvent)
  {
    mouseClicked(getJavaKeyEvent(paramNativeMouseEvent));
  }
  
  public void nativeMousePressed(NativeMouseEvent paramNativeMouseEvent)
  {
    mousePressed(getJavaKeyEvent(paramNativeMouseEvent));
  }
  
  public void nativeMouseReleased(NativeMouseEvent paramNativeMouseEvent)
  {
    mousePressed(getJavaKeyEvent(paramNativeMouseEvent));
  }
  
  public void mouseClicked(MouseEvent paramMouseEvent) {}
  
  public void mousePressed(MouseEvent paramMouseEvent) {}
  
  public void mouseReleased(MouseEvent paramMouseEvent) {}
  
  public void mouseEntered(MouseEvent paramMouseEvent) {}
  
  public void mouseExited(MouseEvent paramMouseEvent) {}
  
  protected MouseEvent getJavaKeyEvent(NativeMouseEvent paramNativeMouseEvent)
  {
    return new MouseEvent(this, paramNativeMouseEvent.getID() - 0, System.currentTimeMillis(), getJavaModifiers(paramNativeMouseEvent.getModifiers()), paramNativeMouseEvent.getX(), paramNativeMouseEvent.getY(), paramNativeMouseEvent.getClickCount(), false, paramNativeMouseEvent.getButton());
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\mouse\SwingMouseAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */