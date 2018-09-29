import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MainClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(AnyAction::doing)
                .thenAccept( (res) -> System.out.println("our result: " + res))
                .thenAccept( (res) -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("work");
                })
                .thenRun(() -> System.out.println("All is good"));
        future.get();

        System.out.println("--------------------------------------------------------");

        CompletableFuture<Integer> initial = CompletableFuture.supplyAsync(AnyAction::getValue);
        CompletableFuture<Integer> future1 = initial.thenApply(AnyAction::increment);  // thenApplyAsync -- что бы футуры раотали в отдельных потоках
        CompletableFuture<Integer> future2 =initial.thenApply(AnyAction::increment);  // thenApplyAsync
        CompletableFuture<Integer> future3 = future1.thenCombine(future2, (x, y) -> x + y);

        for(int i = 0; i < 10; i++){  // в это же време выполняется наша ассинхронаая херь
            Thread.sleep(1100);
            System.out.println("In time of computing async activities");  // если это закомментить, то ждать следующую строчку прийдётся гораздо дольше
        }


        System.out.println("result: " + future3.get());
        System.out.println("!!!!!!!");
    }
}

class AnyAction{
    public static int doing(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Any work!!!");
        return 1;
    }

    public static int getValue(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
    public static int increment(int value){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ++value;
    }

}
