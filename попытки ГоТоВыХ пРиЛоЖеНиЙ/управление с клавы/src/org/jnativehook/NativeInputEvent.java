package org.jnativehook;

import java.awt.Toolkit;
import java.util.EventObject;

public class NativeInputEvent
  extends EventObject
{
  private static final long serialVersionUID = 2306729722565226621L;
  private int id;
  private long when;
  private int modifiers;
  private short reserved;
  public static final int SHIFT_L_MASK = 1;
  public static final int CTRL_L_MASK = 2;
  public static final int META_L_MASK = 4;
  public static final int ALT_L_MASK = 8;
  public static final int SHIFT_R_MASK = 16;
  public static final int CTRL_R_MASK = 32;
  public static final int META_R_MASK = 64;
  public static final int ALT_R_MASK = 128;
  public static final int SHIFT_MASK = 17;
  public static final int CTRL_MASK = 34;
  public static final int META_MASK = 68;
  public static final int ALT_MASK = 136;
  public static final int BUTTON1_MASK = 256;
  public static final int BUTTON2_MASK = 512;
  public static final int BUTTON3_MASK = 1024;
  public static final int BUTTON4_MASK = 2048;
  public static final int BUTTON5_MASK = 4096;
  public static final int NUM_LOCK_MASK = 8192;
  public static final int CAPS_LOCK_MASK = 16384;
  public static final int SCROLL_LOCK_MASK = 32768;
  
  public NativeInputEvent(Class<GlobalScreen> paramClass, int paramInt1, int paramInt2)
  {
    super(paramClass);
    this.id = paramInt1;
    this.when = 0L;
    this.modifiers = paramInt2;
    this.reserved = 0;
  }
  
  public int getID()
  {
    return this.id;
  }
  
  public long getWhen()
  {
    return this.when;
  }
  
  public int getModifiers()
  {
    return this.modifiers;
  }
  
  public void setModifiers(int paramInt)
  {
    this.modifiers = paramInt;
  }
  
  private void setReserved(short paramShort)
  {
    this.reserved = paramShort;
  }
  
  public static String getModifiersText(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(255);
    if ((paramInt & 0x11) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.shift", "Shift"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x22) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.control", "Ctrl"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x44) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.meta", "Meta"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x88) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.alt", "Alt"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x100) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.button1", "Button1"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x200) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.button2", "Button2"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x400) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.button3", "Button3"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x800) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.button4", "Button4"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x1000) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.button5", "Button5"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x2000) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.numLock", "Num Lock"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x4000) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.capsLock", "Caps Lock"));
      localStringBuilder.append('+');
    }
    if ((paramInt & 0x8000) != 0)
    {
      localStringBuilder.append(Toolkit.getProperty("AWT.scrollLock", "Scroll Lock"));
      localStringBuilder.append('+');
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  public String paramString()
  {
    StringBuilder localStringBuilder = new StringBuilder(255);
    localStringBuilder.append("id=");
    localStringBuilder.append(getID());
    localStringBuilder.append(',');
    localStringBuilder.append("when=");
    localStringBuilder.append(getWhen());
    localStringBuilder.append(',');
    localStringBuilder.append("mask=");
    localStringBuilder.append(Integer.toBinaryString(getModifiers()));
    localStringBuilder.append(',');
    localStringBuilder.append("modifiers=");
    localStringBuilder.append(getModifiersText(getModifiers()));
    return localStringBuilder.toString();
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\NativeInputEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */