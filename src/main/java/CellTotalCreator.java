import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*public class CellTotalCreator extends Thread {
    @Override
    public void run() {
        Main.courseList.getData().forEach(x -> {
            if (x.isPublish())
                Main.requestsById.add(finalUrl + x.getId());
        });
        for (var elem:requestsById) {
            Main.connectionStream(elem);
            System.out.println(response.toString());
            courses.add(g.fromJson(response.toString(), Course.class));
        }
    }
    public void connectionStream(String url) throws IOException {
        obj = new URL(url);
        connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("x-auth-token", "b540bd407852678c0af5b11105dcde14");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
    }
}*/
