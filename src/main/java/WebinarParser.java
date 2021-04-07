import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class WebinarParser extends Thread {
    URL obj;
    @Override
    public void run() {
        try {
            Main.connection = (HttpURLConnection) obj.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Main.connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        Main.connection.setRequestProperty("x-auth-token", "b540bd407852678c0af5b11105dcde14");
        Main.connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        try {
            Main.in = new BufferedReader(new InputStreamReader(Main.connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.response = new StringBuffer();
        while (true) {
            try {
                if (!((Main.inputLine = Main.in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            Main.response.append(Main.inputLine);
        }
        try {
            Main.in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void connectionStream(String url) throws IOException {
        obj = new URL(url);
        this.start();
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
