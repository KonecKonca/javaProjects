package org.jnativehook.keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.jnativehook.AbstractSwingInputAdapter;

public class SwingKeyAdapter
  extends AbstractSwingInputAdapter
  implements NativeKeyListener, KeyListener
{
  public void nativeKeyTyped(NativeKeyEvent paramNativeKeyEvent)
  {
    keyTyped(getJavaKeyEvent(paramNativeKeyEvent));
  }
  
  public void nativeKeyPressed(NativeKeyEvent paramNativeKeyEvent)
  {
    keyPressed(getJavaKeyEvent(paramNativeKeyEvent));
  }
  
  public void nativeKeyReleased(NativeKeyEvent paramNativeKeyEvent)
  {
    keyReleased(getJavaKeyEvent(paramNativeKeyEvent));
  }
  
  public void keyTyped(KeyEvent paramKeyEvent) {}
  
  public void keyPressed(KeyEvent paramKeyEvent) {}
  
  public void keyReleased(KeyEvent paramKeyEvent) {}
  
  protected KeyEvent getJavaKeyEvent(NativeKeyEvent paramNativeKeyEvent)
  {
    int i = 0;
    switch (paramNativeKeyEvent.getKeyLocation())
    {
    case 1: 
      i = 1;
      break;
    case 4: 
      i = 4;
      break;
    case 2: 
      i = 1;
      break;
    case 3: 
      i = 3;
    }
    int j = 0;
    switch (paramNativeKeyEvent.getKeyCode())
    {
    case 1: 
      j = 27;
      break;
    case 59: 
      j = 112;
      break;
    case 60: 
      j = 113;
      break;
    case 61: 
      j = 114;
      break;
    case 62: 
      j = 115;
      break;
    case 63: 
      j = 116;
      break;
    case 64: 
      j = 117;
      break;
    case 65: 
      j = 118;
      break;
    case 66: 
      j = 119;
      break;
    case 67: 
      j = 120;
      break;
    case 68: 
      j = 121;
      break;
    case 87: 
      j = 122;
      break;
    case 88: 
      j = 123;
      break;
    case 91: 
      j = 61440;
      break;
    case 92: 
      j = 61441;
      break;
    case 93: 
      j = 61442;
      break;
    case 99: 
      j = 61443;
      break;
    case 100: 
      j = 61444;
      break;
    case 101: 
      j = 61445;
      break;
    case 102: 
      j = 61446;
      break;
    case 103: 
      j = 61447;
      break;
    case 104: 
      j = 61448;
      break;
    case 105: 
      j = 61449;
      break;
    case 106: 
      j = 61450;
      break;
    case 107: 
      j = 61451;
      break;
    case 41: 
      j = 192;
      break;
    case 2: 
      j = 49;
      break;
    case 3: 
      j = 50;
      break;
    case 4: 
      j = 51;
      break;
    case 5: 
      j = 52;
      break;
    case 6: 
      j = 53;
      break;
    case 7: 
      j = 54;
      break;
    case 8: 
      j = 55;
      break;
    case 9: 
      j = 56;
      break;
    case 10: 
      j = 57;
      break;
    case 11: 
      j = 48;
      break;
    case 12: 
      j = 45;
      break;
    case 13: 
      j = 61;
      break;
    case 14: 
      j = 8;
      break;
    case 15: 
      j = 9;
      break;
    case 58: 
      j = 20;
      break;
    case 30: 
      j = 65;
      break;
    case 48: 
      j = 66;
      break;
    case 46: 
      j = 67;
      break;
    case 32: 
      j = 68;
      break;
    case 18: 
      j = 69;
      break;
    case 33: 
      j = 70;
      break;
    case 34: 
      j = 71;
      break;
    case 35: 
      j = 72;
      break;
    case 23: 
      j = 73;
      break;
    case 36: 
      j = 74;
      break;
    case 37: 
      j = 75;
      break;
    case 38: 
      j = 76;
      break;
    case 50: 
      j = 77;
      break;
    case 49: 
      j = 78;
      break;
    case 24: 
      j = 79;
      break;
    case 25: 
      j = 80;
      break;
    case 16: 
      j = 81;
      break;
    case 19: 
      j = 82;
      break;
    case 31: 
      j = 83;
      break;
    case 20: 
      j = 84;
      break;
    case 22: 
      j = 85;
      break;
    case 47: 
      j = 86;
      break;
    case 17: 
      j = 87;
      break;
    case 45: 
      j = 88;
      break;
    case 21: 
      j = 89;
      break;
    case 44: 
      j = 90;
      break;
    case 26: 
      j = 91;
      break;
    case 27: 
      j = 93;
      break;
    case 43: 
      j = 92;
      break;
    case 39: 
      j = 59;
      break;
    case 40: 
      j = 222;
      break;
    case 28: 
      j = 10;
      break;
    case 51: 
      j = 44;
      break;
    case 52: 
      j = 46;
      break;
    case 53: 
      j = 47;
      break;
    case 57: 
      j = 32;
      break;
    case 3639: 
      j = 154;
      break;
    case 70: 
      j = 145;
      break;
    case 3653: 
      j = 19;
      break;
    case 3666: 
      j = 155;
      break;
    case 3667: 
      j = 127;
      break;
    case 3655: 
      j = 36;
      break;
    case 3663: 
      j = 35;
      break;
    case 3657: 
      j = 33;
      break;
    case 3665: 
      j = 34;
      break;
    case 57416: 
      j = 38;
      break;
    case 57419: 
      j = 37;
      break;
    case 57420: 
      j = 12;
      break;
    case 57421: 
      j = 39;
      break;
    case 57424: 
      j = 40;
      break;
    case 69: 
      j = 144;
      break;
    case 83: 
      j = 108;
      break;
    case 42: 
      j = 16;
      break;
    case 29: 
      j = 17;
      break;
    case 56: 
      j = 18;
      break;
    case 3675: 
      j = 157;
      break;
    case 3677: 
      j = 525;
      break;
    case 112: 
      j = 241;
      break;
    case 115: 
      j = 523;
      break;
    case 121: 
      j = 25;
      break;
    case 123: 
      j = 242;
      break;
    case 65397: 
      j = 156;
      break;
    case 65400: 
      j = 65480;
      break;
    case 65398: 
      j = 65482;
      break;
    case 65406: 
      j = 65488;
      break;
    case 65401: 
      j = 65481;
      break;
    case 65404: 
      j = 65485;
      break;
    case 65403: 
      j = 65489;
    }
    return new KeyEvent(this, paramNativeKeyEvent.getID() - 2000, System.currentTimeMillis(), getJavaModifiers(paramNativeKeyEvent.getModifiers()), j, paramNativeKeyEvent.getKeyChar(), i);
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\keyboard\SwingKeyAdapter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */