import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        fetchGoogleHomepage();
    }
    
    public static void fetchGoogleHomepage() {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
    
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
    
            if (responseCode == 200) {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder response = new StringBuilder();
                while (scanner.hasNext()) {
                    response.append(scanner.nextLine());
                }
                scanner.close();
                System.out.println("Google Homepage Content:");
                System.out.println(response.toString());
            } else {
                System.out.println("Failed to fetch the homepage.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

