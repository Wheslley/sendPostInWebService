package sendpost;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendPost {

    public static void main(String[] args) {

        try {
            
            // Build Url
            URL url;
            HttpURLConnection connection = null;

            String server = "http://192.168.1.87/check";

            StringBuilder parametros = new StringBuilder();
            parametros.append("username=EMAIL&password=SENHA");
            
            url = new URL(server);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Length", "" + Integer.toString(parametros.toString().getBytes().length));

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            // Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(parametros.toString());
            wr.flush();
            wr.close();

            // Response Code
            System.out.println(connection.getResponseCode());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
