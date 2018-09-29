package org.jnativehook;

public class NativeHookException
  extends Exception
{
  private static final long serialVersionUID = 8952825837670265527L;
  private int code = 0;
  public static final int UNSPECIFIED_FAILURE = 0;
  public static final int HOOK_FAILURE = 1;
  public static final int X11_OPEN_DISPLAY = 32;
  public static final int X11_RECORD_NOT_FOUND = 33;
  public static final int X11_RECORD_ALLOC_RANGE = 34;
  public static final int X11_RECORD_CREATE_CONTEXT = 35;
  public static final int X11_RECORD_ENABLE_CONTEXT = 36;
  public static final int X11_RECORD_GET_CONTEXT = 37;
  public static final int WIN_SET_HOOK = 48;
  public static final int DARWIN_AXAPI_DISABLED = 64;
  public static final int DARWIN_CREATE_EVENT_PORT = 65;
  public static final int DARWIN_CREATE_RUN_LOOP_SOURCE = 66;
  public static final int DARWIN_GET_RUNLOOP = 67;
  public static final int DARWIN_CREATE_OBSERVER = 68;
  
  public NativeHookException() {}
  
  public NativeHookException(int paramInt)
  {
    this.code = paramInt;
  }
  
  public NativeHookException(String paramString)
  {
    super(paramString);
  }
  
  public NativeHookException(int paramInt, String paramString)
  {
    super(paramString);
    this.code = paramInt;
  }
  
  public NativeHookException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public NativeHookException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.code = paramInt;
  }
  
  public NativeHookException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public NativeHookException(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.code = paramInt;
  }
  
  public int getCode()
  {
    return this.code;
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\NativeHookException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */