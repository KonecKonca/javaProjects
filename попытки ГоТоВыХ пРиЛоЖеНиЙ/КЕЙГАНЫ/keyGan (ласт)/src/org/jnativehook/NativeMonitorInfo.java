package org.jnativehook;

public class NativeMonitorInfo
{
  private short number;
  private int x;
  private int y;
  private short width;
  private short height;
  
  public NativeMonitorInfo(short paramShort1, int paramInt1, int paramInt2, short paramShort2, short paramShort3)
  {
    this.number = paramShort1;
    this.x = paramInt1;
    this.y = paramInt2;
    this.width = paramShort2;
    this.height = paramShort3;
  }
  
  public short getNumber()
  {
    return this.number;
  }
  
  public void setNumber(short paramShort)
  {
    this.number = paramShort;
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public void setX(int paramInt)
  {
    this.x = paramInt;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public void setY(int paramInt)
  {
    this.y = paramInt;
  }
  
  public short getWidth()
  {
    return this.width;
  }
  
  public void setWidth(short paramShort)
  {
    this.width = paramShort;
  }
  
  public short getHeight()
  {
    return this.height;
  }
  
  public void setHeight(short paramShort)
  {
    this.height = paramShort;
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\NativeMonitorInfo.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */