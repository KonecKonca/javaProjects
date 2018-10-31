public class MainClass {
    public static void main(String[] args)throws Exception {
        Process sleeper = Runtime.getRuntime().exec("sleep 1h");
        System.out.println("current process id " + ProcessHandle.current().pid());
        System.out.println("sleeper id " + sleeper.pid());

        ProcessHandle processHandle = ProcessHandle.of(sleeper.pid()).orElseThrow(IllegalAccessError::new);
        processHandle.onExit().thenRun(() -> System.out.println("process has been closed"));
        System.out.println(processHandle.info().user().orElse("no user"));
        System.out.println(processHandle.info().commandLine().orElse("empty"));

        processHandle.destroy();
        Thread.sleep(100);
    }
}
