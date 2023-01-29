package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Mailer {

	public static void main(String[] args) {
		String result = "";
		try {
			URL url = new URL("http://10.73.122.151:8080/MailService/mailgen/mailService/sendMail");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/plain");

			String data = "{\"fromMail\":\"neha46@infosys.com\",\"toMail\":\"neha46@infosys.com\",\"subject\":\"Test Mail\",\"body\":\"Testing\"}";

			OutputStream os = conn.getOutputStream();
			os.write(data.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				System.out.println(
						"Error in executeRestAPI method for HttpURLConnection response is :" + conn.getResponseCode());
				//throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;

			// System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			// System.out.println(result);
			conn.disconnect();
		} catch (Exception e) {
		}

		System.out.println(result); 

	}

}
