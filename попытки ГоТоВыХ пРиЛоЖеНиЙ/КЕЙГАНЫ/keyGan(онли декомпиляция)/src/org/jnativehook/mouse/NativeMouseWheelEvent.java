package org.jnativehook.mouse;

public class NativeMouseWheelEvent
  extends NativeMouseEvent
{
  private static final long serialVersionUID = 2112217673594181259L;
  public static final int WHEEL_UNIT_SCROLL = 1;
  public static final int WHEEL_BLOCK_SCROLL = 2;
  public static final int WHEEL_VERTICAL_DIRECTION = 3;
  public static final int WHEEL_HORIZONTAL_DIRECTION = 4;
  private int scrollAmount;
  private int scrollType;
  private int wheelRotation;
  private int wheelDirection;
  
  public NativeMouseWheelEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, 3);
  }
  
  public NativeMouseWheelEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    this.scrollType = paramInt6;
    this.scrollAmount = paramInt7;
    this.wheelRotation = paramInt8;
    this.wheelDirection = paramInt9;
  }
  
  public int getScrollAmount()
  {
    return this.scrollAmount;
  }
  
  public int getScrollType()
  {
    return this.scrollType;
  }
  
  public int getWheelRotation()
  {
    return this.wheelRotation;
  }
  
  public int getWheelDirection()
  {
    return this.wheelDirection;
  }
  
  public String paramString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.paramString());
    localStringBuilder.append(",scrollType=");
    switch (getScrollType())
    {
    case 1: 
      localStringBuilder.append("WHEEL_UNIT_SCROLL");
      break;
    case 2: 
      localStringBuilder.append("WHEEL_BLOCK_SCROLL");
      break;
    default: 
      localStringBuilder.append("unknown scroll type");
    }
    localStringBuilder.append(",scrollAmount=");
    localStringBuilder.append(getScrollAmount());
    localStringBuilder.append(",wheelRotation=");
    localStringBuilder.append(getWheelRotation());
    localStringBuilder.append(",wheelDirection=");
    switch (getWheelDirection())
    {
    case 3: 
      localStringBuilder.append("WHEEL_VERTICAL_DIRECTION");
      break;
    case 4: 
      localStringBuilder.append("WHEEL_HORIZONTAL_DIRECTION");
      break;
    default: 
      localStringBuilder.append("unknown scroll direction");
    }
    return localStringBuilder.toString();
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\mouse\NativeMouseWheelEvent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */