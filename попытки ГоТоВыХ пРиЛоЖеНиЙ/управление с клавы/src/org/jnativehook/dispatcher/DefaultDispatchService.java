package org.jnativehook.dispatcher;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DefaultDispatchService
  extends ThreadPoolExecutor
{
  public DefaultDispatchService()
  {
    super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        Thread localThread = new Thread(paramAnonymousRunnable);
        localThread.setName("JNativeHook Dispatch Thread");
        localThread.setDaemon(true);
        return localThread;
      }
    });
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\dispatcher\DefaultDispatchService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */