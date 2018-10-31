package org.jnativehook;

import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;
import org.jnativehook.dispatcher.DefaultDispatchService;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;
import org.jnativehook.mouse.NativeMouseMotionListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class GlobalScreen
{
  protected static Logger log = Logger.getLogger(GlobalScreen.class.getPackage().getName());
  protected static NativeHookThread hookThread;
  protected static ExecutorService eventExecutor = new DefaultDispatchService();
  protected static EventListenerList eventListeners = new EventListenerList();
  
  public static void addNativeKeyListener(NativeKeyListener paramNativeKeyListener)
  {
    if (paramNativeKeyListener != null) {
      eventListeners.add(NativeKeyListener.class, paramNativeKeyListener);
    }
  }
  
  public static void removeNativeKeyListener(NativeKeyListener paramNativeKeyListener)
  {
    if (paramNativeKeyListener != null) {
      eventListeners.remove(NativeKeyListener.class, paramNativeKeyListener);
    }
  }
  
  public static void addNativeMouseListener(NativeMouseListener paramNativeMouseListener)
  {
    if (paramNativeMouseListener != null) {
      eventListeners.add(NativeMouseListener.class, paramNativeMouseListener);
    }
  }
  
  public static void removeNativeMouseListener(NativeMouseListener paramNativeMouseListener)
  {
    if (paramNativeMouseListener != null) {
      eventListeners.remove(NativeMouseListener.class, paramNativeMouseListener);
    }
  }
  
  public static void addNativeMouseMotionListener(NativeMouseMotionListener paramNativeMouseMotionListener)
  {
    if (paramNativeMouseMotionListener != null) {
      eventListeners.add(NativeMouseMotionListener.class, paramNativeMouseMotionListener);
    }
  }
  
  public static void removeNativeMouseMotionListener(NativeMouseMotionListener paramNativeMouseMotionListener)
  {
    if (paramNativeMouseMotionListener != null) {
      eventListeners.remove(NativeMouseMotionListener.class, paramNativeMouseMotionListener);
    }
  }
  
  public static void addNativeMouseWheelListener(NativeMouseWheelListener paramNativeMouseWheelListener)
  {
    if (paramNativeMouseWheelListener != null) {
      eventListeners.add(NativeMouseWheelListener.class, paramNativeMouseWheelListener);
    }
  }
  
  public static void removeNativeMouseWheelListener(NativeMouseWheelListener paramNativeMouseWheelListener)
  {
    if (paramNativeMouseWheelListener != null) {
      eventListeners.remove(NativeMouseWheelListener.class, paramNativeMouseWheelListener);
    }
  }
  
  public static native NativeMonitorInfo[] getNativeMonitors();
  
  public static native Integer getAutoRepeatRate();
  
  public static native Integer getAutoRepeatDelay();
  
  public static native Integer getPointerAccelerationMultiplier();
  
  public static native Integer getPointerAccelerationThreshold();
  
  public static native Integer getPointerSensitivity();
  
  public static native Integer getMultiClickIterval();
  
  public static void registerNativeHook()
    throws NativeHookException
  {
    if ((hookThread == null) || (!hookThread.isAlive()))
    {
      hookThread = new NativeHookThread();
      synchronized (hookThread)
      {
        hookThread.start();
        try
        {
          hookThread.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new NativeHookException(localInterruptedException);
        }
        NativeHookException localNativeHookException = hookThread.getException();
        if (localNativeHookException != null) {
          throw localNativeHookException;
        }
      }
    }
  }
  
  public static void unregisterNativeHook()
    throws NativeHookException
  {
    if (isNativeHookRegistered()) {
      synchronized (hookThread)
      {
        hookThread.disable();
        try
        {
          hookThread.join();
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new NativeHookException(localInterruptedException.getCause());
        }
      }
    }
  }
  
  public static boolean isNativeHookRegistered()
  {
    return (hookThread != null) && (hookThread.isAlive());
  }
  
  public static native void postNativeEvent(NativeInputEvent paramNativeInputEvent);
  
  public static void setEventDispatcher(ExecutorService paramExecutorService)
  {
    if (eventExecutor != null) {
      eventExecutor.shutdown();
    }
    eventExecutor = paramExecutorService;
  }
  
  static
  {
    String str = System.getProperty("jnativehook.lib.name", "JNativeHook");
    try
    {
      System.loadLibrary(str);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Object localObject1 = System.getProperty("jnativehook.lib.locator", "org.jnativehook.DefaultLibraryLocator");
      try
      {
        NativeLibraryLocator localNativeLibraryLocator = (NativeLibraryLocator)Class.forName((String)localObject1).asSubclass(NativeLibraryLocator.class).newInstance();
        Object localObject2 = localNativeLibraryLocator.getLibraries();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (File)((Iterator)localObject2).next();
          if ((((File)localObject3).exists()) && (((File)localObject3).isFile()) && (((File)localObject3).canRead())) {
            System.load(((File)localObject3).getPath());
          }
        }
      }
      catch (Exception localException)
      {
        log.severe(localException.getMessage());
        throw new UnsatisfiedLinkError(localException.getMessage());
      }
    }
    Integer localInteger1 = getAutoRepeatRate();
    if (localInteger1 != null) {
      System.setProperty("jnativehook.key.repeat.rate", localInteger1.toString());
    }
    Object localObject1 = getAutoRepeatDelay();
    if (localObject1 != null) {
      System.setProperty("jnativehook.key.repeat.delay", ((Integer)localObject1).toString());
    }
    Integer localInteger2 = getMultiClickIterval();
    if (localInteger2 != null) {
      System.setProperty("jnativehook.button.multiclick.iterval", localInteger2.toString());
    }
    Object localObject2 = getPointerSensitivity();
    if (localObject2 != null) {
      System.setProperty("jnativehook.pointer.sensitivity", ((Integer)localObject2).toString());
    }
    Object localObject3 = getPointerAccelerationMultiplier();
    if (localObject3 != null) {
      System.setProperty("jnativehook.pointer.acceleration.multiplier", ((Integer)localObject3).toString());
    }
    Integer localInteger3 = getPointerAccelerationThreshold();
    if (localInteger3 != null) {
      System.setProperty("jnativehook.pointer.acceleration.threshold", localInteger3.toString());
    }
  }
  
  private static class EventDispatchTask
    implements Runnable
  {
    private NativeInputEvent event;
    
    public EventDispatchTask(NativeInputEvent paramNativeInputEvent)
    {
      this.event = paramNativeInputEvent;
    }
    
    public void run()
    {
      if ((this.event instanceof NativeKeyEvent)) {
        processKeyEvent((NativeKeyEvent)this.event);
      } else if ((this.event instanceof NativeMouseWheelEvent)) {
        processMouseWheelEvent((NativeMouseWheelEvent)this.event);
      } else if ((this.event instanceof NativeMouseEvent)) {
        switch (this.event.getID())
        {
        case 2500: 
        case 2501: 
        case 2502: 
          processButtonEvent((NativeMouseEvent)this.event);
          break;
        case 2503: 
        case 2504: 
          processMouseEvent((NativeMouseEvent)this.event);
        }
      } else if ((this.event instanceof NativeMouseWheelEvent)) {
        processMouseWheelEvent((NativeMouseWheelEvent)this.event);
      }
    }
    
    private void processKeyEvent(NativeKeyEvent paramNativeKeyEvent)
    {
      NativeKeyListener[] arrayOfNativeKeyListener = (NativeKeyListener[])GlobalScreen.eventListeners.getListeners(NativeKeyListener.class);
      for (int i = 0; i < arrayOfNativeKeyListener.length; i++) {
        switch (paramNativeKeyEvent.getID())
        {
        case 2401: 
          arrayOfNativeKeyListener[i].nativeKeyPressed(paramNativeKeyEvent);
          break;
        case 2400: 
          arrayOfNativeKeyListener[i].nativeKeyTyped(paramNativeKeyEvent);
          break;
        case 2402: 
          arrayOfNativeKeyListener[i].nativeKeyReleased(paramNativeKeyEvent);
        }
      }
    }
    
    private void processButtonEvent(NativeMouseEvent paramNativeMouseEvent)
    {
      NativeMouseListener[] arrayOfNativeMouseListener = (NativeMouseListener[])GlobalScreen.eventListeners.getListeners(NativeMouseListener.class);
      for (int i = 0; i < arrayOfNativeMouseListener.length; i++) {
        switch (paramNativeMouseEvent.getID())
        {
        case 2500: 
          arrayOfNativeMouseListener[i].nativeMouseClicked(paramNativeMouseEvent);
          break;
        case 2501: 
          arrayOfNativeMouseListener[i].nativeMousePressed(paramNativeMouseEvent);
          break;
        case 2502: 
          arrayOfNativeMouseListener[i].nativeMouseReleased(paramNativeMouseEvent);
        }
      }
    }
    
    private void processMouseEvent(NativeMouseEvent paramNativeMouseEvent)
    {
      NativeMouseMotionListener[] arrayOfNativeMouseMotionListener = (NativeMouseMotionListener[])GlobalScreen.eventListeners.getListeners(NativeMouseMotionListener.class);
      for (int i = 0; i < arrayOfNativeMouseMotionListener.length; i++) {
        switch (paramNativeMouseEvent.getID())
        {
        case 2503: 
          arrayOfNativeMouseMotionListener[i].nativeMouseMoved(paramNativeMouseEvent);
          break;
        case 2504: 
          arrayOfNativeMouseMotionListener[i].nativeMouseDragged(paramNativeMouseEvent);
        }
      }
    }
    
    private void processMouseWheelEvent(NativeMouseWheelEvent paramNativeMouseWheelEvent)
    {
      NativeMouseWheelListener[] arrayOfNativeMouseWheelListener = (NativeMouseWheelListener[])GlobalScreen.eventListeners.getListeners(NativeMouseWheelListener.class);
      for (int i = 0; i < arrayOfNativeMouseWheelListener.length; i++) {
        arrayOfNativeMouseWheelListener[i].nativeMouseWheelMoved(paramNativeMouseWheelEvent);
      }
    }
  }
  
  protected static class NativeHookThread
    extends Thread
  {
    protected NativeHookException exception;
    
    public NativeHookThread()
    {
      setName("JNativeHook Hook Thread");
      setDaemon(false);
      setPriority(10);
    }
    
    public void run()
    {
      this.exception = null;
      try
      {
        enable();
      }
      catch (NativeHookException localNativeHookException)
      {
        this.exception = localNativeHookException;
      }
      synchronized (this)
      {
        notifyAll();
      }
    }
    
    public NativeHookException getException()
    {
      return this.exception;
    }
    
    protected native void enable()
      throws NativeHookException;
    
    public native void disable()
      throws NativeHookException;
    
    protected static void dispatchEvent(NativeInputEvent paramNativeInputEvent)
    {
      if (GlobalScreen.eventExecutor != null) {
        GlobalScreen.eventExecutor.execute(new GlobalScreen.EventDispatchTask(paramNativeInputEvent));
      }
    }
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\GlobalScreen.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */