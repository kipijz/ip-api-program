package kipijz;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        getIPCountry();
    }

    public static void getIPCountry() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a URL/IP adress to see the registration country: ");
        String userInput = scanner.next();

        String theURL = "http://ip-api.com/json/" + userInput;
        URL url = new URL(theURL);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder inputData = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            inputData.append(inputLine);
        }

        String IPDataRaw = inputData.toString();
        JSONObject IPObject = new JSONObject(IPDataRaw);

        String registeredCountry = IPObject.get("country").toString();
        System.out.println("The IP you entered is registered in: " + registeredCountry);

    }

}
