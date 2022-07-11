package helpers;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public abstract class OpenNotifyAPI {

    private static final String API_LINK = "http://api.open-notify.org/iss-now.json";


    /**
     * fetches json from api source
     * @return String
     */
    public static String fetchData() {
        Scanner apiScanner = getSourceData(getUrl());
        String apiData = "";

        while (apiScanner.hasNext()) {
            apiData += apiScanner.nextLine();
        }

        apiScanner.close();

        return apiData;
    }

    /**
     * scanner for url stream
     * @param url URL
     * @return Scanner
     */
    private static Scanner getSourceData(URL url) {
        try {
            return new Scanner(url.openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * creates URL Object from API-Link String
     * @return URL
     */
    private static URL getUrl() {
        try {
            return new URL(API_LINK);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
