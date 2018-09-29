package org.jnativehook;

import java.io.File;
import java.util.Iterator;

public abstract interface NativeLibraryLocator
{
  public abstract Iterator<File> getLibraries();
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\NativeLibraryLocator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */