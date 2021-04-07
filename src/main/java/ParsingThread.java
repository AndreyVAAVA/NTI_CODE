import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class ParsingThread extends Thread {
    URL obj;
    public StringBuffer response;
    @Override
    public void run() {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) obj.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        connection.setRequestProperty("x-auth-token", "b540bd407852678c0af5b11105dcde14");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        response = new StringBuffer();
        Object inputLine = null;
        while (true) {
            try {
                if (!((inputLine = in.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            response.append(inputLine);
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * By variable "connection"
     * This method sets the values of the "response" variable that we receive from the server.
     * @param url
     * @throws IOException
     */
    public StringBuffer connectionStream(String url) throws IOException {
        this.obj = new URL(url);
        this.run();
        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

}
