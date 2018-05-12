/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotificationUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author tmp-sda-1160
 */
public final class SendMessage {

    public static void sendSMS(String msg) throws java.io.IOException {

        try {
            // Construct data
            String apiKey = "apikey=" + "WchKIXTicRw-x1HI1C6VesrboYoQhrLw8gSJYe7ozY";
            String message = "&message=" + msg;
            String sender = "&sender=" + "Task Reminder";
            String numbers = "&numbers=" + "46727646456";

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                final StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = rd.readLine()) != null) {
                    stringBuffer.append(line);
                }
            }
            System.out.println("SMS notification sent successfully");

        } catch (IOException e) {
            System.out.println("Error SMS " + e);

        }
    }

}
