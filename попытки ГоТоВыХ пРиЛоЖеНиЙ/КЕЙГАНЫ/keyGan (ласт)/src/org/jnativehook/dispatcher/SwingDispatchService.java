package org.jnativehook.dispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;

public class SwingDispatchService
  extends AbstractExecutorService
{
  private boolean running = false;
  
  public void shutdown()
  {
    this.running = false;
  }
  
  public List<Runnable> shutdownNow()
  {
    this.running = false;
    return new ArrayList(0);
  }
  
  public boolean isShutdown()
  {
    return !this.running;
  }
  
  public boolean isTerminated()
  {
    return !this.running;
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return true;
  }
  
  public void execute(Runnable paramRunnable)
  {
    SwingUtilities.invokeLater(paramRunnable);
  }
}


/* Location:              D:\Time\jnativehook-2.1.0.jar!\org\jnativehook\dispatcher\SwingDispatchService.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */