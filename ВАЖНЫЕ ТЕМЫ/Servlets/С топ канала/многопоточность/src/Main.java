import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        for (int j = 0; j < 2; j++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        URLConnection urlConnection = new URL("http://localhost:8080/hello").openConnection();
                        urlConnection.getInputStream();

                    }
                    catch (Exception ex){ }
                }
            }.start();
        }
    }
}
