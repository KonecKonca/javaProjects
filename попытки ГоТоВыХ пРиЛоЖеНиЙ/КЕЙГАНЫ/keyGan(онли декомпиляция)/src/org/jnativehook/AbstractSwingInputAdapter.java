package org.jnativehook;

import java.awt.Component;

public abstract class AbstractSwingInputAdapter
  extends Component
{
  protected int getJavaModifiers(int paramInt)
  {
    int i = 0;
    if ((paramInt & 0x11) != 0)
    {
      i |= 0x1;
      i |= 0x40;
    }
    if ((paramInt & 0x44) != 0)
    {
      i |= 0x4;
      i |= 0x100;
    }
    if ((paramInt & 0x44) != 0)
    {
      i |= 0x2;
      i |= 0x80;
    }
    if ((paramInt & 0x88) != 0)
    {
      i |= 0x8;
      i |= 0x200;
    }
    if ((paramInt & 0x100) != 0)
    {
      i |= 0x10;
      i |= 0x400;
    }
    if ((paramInt & 0x200) != 0)
    {
      i |= 0x8;
      i |= 0x800;
    }
    if ((paramInt & 0x400) != 0)
    {
      i |= 0x4;
      i |= 0x1000;
    }
    return i;
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\AbstractSwingInputAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */