import java.io.Console;

public class start {
    public static void main(String[] args) throws Exception{
        Console console = System.console();
        String s = "";
        while(!s.equals("exit")){
            s = console.readLine();
            System.out.println(s);
        }
    }
}

// Так работать можно с терминалом(типо переопределённая консоль от идеи)
// так просто код не выполнится