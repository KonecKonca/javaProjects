package org.jnativehook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.CodeSource;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import java.util.logging.Logger;

public class DefaultLibraryLocator
  implements NativeLibraryLocator
{
  private static Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
  
  public Iterator<File> getLibraries()
  {
    ArrayList localArrayList = new ArrayList(1);
    String str1 = System.getProperty("jnativehook.lib.name", "JNativeHook");
    String str2 = GlobalScreen.class.getPackage().getName().replace('.', '/');
    String str3 = System.mapLibraryName(str1);
    str3 = str3.replaceAll("\\.jnilib$", "\\.dylib");
    int i = str3.lastIndexOf('.');
    String str4 = str3.substring(0, i) + '-';
    String str5 = NativeSystem.getArchitecture().toString().toLowerCase();
    String str6 = '.' + str5 + str3.substring(i);
    Object localObject1 = null;
    StringBuilder localStringBuilder = new StringBuilder("/");
    localStringBuilder.append(str2).append("/lib/");
    localStringBuilder.append(NativeSystem.getFamily().toString().toLowerCase()).append('/');
    localStringBuilder.append(str5).append('/');
    localStringBuilder.append(str3);
    InputStream localInputStream = GlobalScreen.class.getResourceAsStream(localStringBuilder.toString());
    if (localInputStream != null)
    {
      Object localObject3;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      try
      {
        URL localURL = GlobalScreen.class.getProtectionDomain().getCodeSource().getLocation();
        localObject3 = new JarInputStream(localURL.openStream());
        Manifest localManifest = ((JarInputStream)localObject3).getManifest();
        if (localManifest != null)
        {
          localObject4 = localManifest.getAttributes(str2);
          if (localObject4 != null)
          {
            localObject5 = ((Attributes)localObject4).getValue("Specification-Version");
            localObject6 = ((Attributes)localObject4).getValue("Implementation-Version");
            localObject1 = (String)localObject5 + '.' + (String)localObject6;
          }
          else
          {
            logger.warning("Invalid library manifest!\n");
          }
        }
        else
        {
          logger.warning("Cannot find library manifest!\n");
        }
        ((JarInputStream)localObject3).close();
      }
      catch (IOException localIOException1)
      {
        logger.severe(localIOException1.getMessage());
      }
      Object localObject2 = null;
      if (localObject1 != null)
      {
        localObject2 = new File(System.getProperty("java.io.tmpdir"), str4 + (String)localObject1 + str6);
        if (((File)localObject2).exists()) {
          localArrayList.add(localObject2);
        }
      }
      if (localArrayList.isEmpty()) {
        try
        {
          if (localObject2 == null) {
            localObject2 = File.createTempFile(str4, str6);
          }
          localObject3 = new byte['က'];
          localObject4 = new FileOutputStream((File)localObject2);
          localObject5 = MessageDigest.getInstance("SHA-1");
          localObject6 = new DigestInputStream(localInputStream, (MessageDigest)localObject5);
          int j;
          while ((j = ((DigestInputStream)localObject6).read((byte[])localObject3)) != -1) {
            ((FileOutputStream)localObject4).write((byte[])localObject3, 0, j);
          }
          ((DigestInputStream)localObject6).close();
          localInputStream.close();
          ((FileOutputStream)localObject4).close();
          String str7 = new BigInteger(1, ((MessageDigest)localObject5).digest()).toString(16).toUpperCase();
          if (localObject1 == null)
          {
            localObject1 = str7;
            File localFile = new File(System.getProperty("java.io.tmpdir"), str4 + (String)localObject1 + str6);
            if (((File)localObject2).renameTo(localFile)) {
              localObject2 = localFile;
            }
          }
          System.setProperty("jnativehook.lib.version", (String)localObject1);
          localArrayList.add(localObject2);
          logger.info("Library extracted successfully: " + ((File)localObject2).getPath() + " (0x" + str7 + ").\n");
        }
        catch (IOException localIOException2)
        {
          throw new IllegalStateException(localIOException2.getMessage(), localIOException2);
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          throw new IllegalStateException(localNoSuchAlgorithmException.getMessage(), localNoSuchAlgorithmException);
        }
      }
    }
    else
    {
      logger.severe("Unable to extract the native library " + localStringBuilder.toString() + "!\n");
    }
    return localArrayList.iterator();
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\DefaultLibraryLocator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */