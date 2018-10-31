package org.jnativehook;

import java.util.Locale;

public class NativeSystem
{
  protected static final Locale ROOT_LOCALE = new Locale("", "", "");
  
  public static Family getFamily()
  {
    String str = System.getProperty("os.name");
    Family localFamily;
    if (str.equalsIgnoreCase("freebsd")) {
      localFamily = Family.FREEBSD;
    } else if (str.equalsIgnoreCase("openbsd")) {
      localFamily = Family.OPENBSD;
    } else if (str.equalsIgnoreCase("mac os x")) {
      localFamily = Family.DARWIN;
    } else if ((str.equalsIgnoreCase("solaris")) || (str.equalsIgnoreCase("sunos"))) {
      localFamily = Family.SOLARIS;
    } else if (str.equalsIgnoreCase("linux")) {
      localFamily = Family.LINUX;
    } else if (str.toLowerCase(ROOT_LOCALE).startsWith("windows")) {
      localFamily = Family.WINDOWS;
    } else {
      localFamily = Family.UNSUPPORTED;
    }
    return localFamily;
  }
  
  public static Arch getArchitecture()
  {
    String str = System.getProperty("os.arch");
    Arch localArch;
    if (str.equalsIgnoreCase("arm")) {
      localArch = Arch.ARM;
    } else if (str.equalsIgnoreCase("sparc")) {
      localArch = Arch.SPARC;
    } else if (str.equalsIgnoreCase("sparc64")) {
      localArch = Arch.SPARC64;
    } else if ((str.equalsIgnoreCase("ppc")) || (str.equalsIgnoreCase("powerpc"))) {
      localArch = Arch.PPC;
    } else if ((str.equalsIgnoreCase("ppc64")) || (str.equalsIgnoreCase("powerpc64"))) {
      localArch = Arch.PPC64;
    } else if ((str.equalsIgnoreCase("x86")) || (str.equalsIgnoreCase("i386")) || (str.equalsIgnoreCase("i486")) || (str.equalsIgnoreCase("i586")) || (str.equalsIgnoreCase("i686"))) {
      localArch = Arch.x86;
    } else if ((str.equalsIgnoreCase("x86_64")) || (str.equalsIgnoreCase("amd64")) || (str.equalsIgnoreCase("k8"))) {
      localArch = Arch.x86_64;
    } else {
      localArch = Arch.UNSUPPORTED;
    }
    return localArch;
  }
  
  public static enum Arch
  {
    ARM,  SPARC,  SPARC64,  PPC,  PPC64,  x86,  x86_64,  UNSUPPORTED;
    
    private Arch() {}
    
    public String toString()
    {
      return super.toString().toLowerCase(NativeSystem.ROOT_LOCALE);
    }
  }
  
  public static enum Family
  {
    FREEBSD,  OPENBSD,  DARWIN,  SOLARIS,  LINUX,  WINDOWS,  UNSUPPORTED;
    
    private Family() {}
    
    public String toString()
    {
      return super.toString().toLowerCase(NativeSystem.ROOT_LOCALE);
    }
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\NativeSystem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */