import com.google.gson.Gson;
import model.ExchangeRatesSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Utilities {

    private static final Gson GSON = new Gson();
    private Scanner scanner = new Scanner(System.in);

    char getChar(Character ...args) {
        List<Character> characters = new ArrayList<>(Arrays.asList(args));
        boolean flag = true;
        char sign;
        do {
            System.out.println("Enter your choice: " + characters + " ?");
            sign = scanner.next().charAt(0);
            if (characters.contains(sign)) {
                flag = false;
            } else {
                System.err.println("Bad choice.");
            }
        } while (flag);
        return sign;
    }

    String loadApiContentFromURL(String requestURL) {
        final StringBuilder stringBuilder = new StringBuilder();
        String apiContent = null;
        try {
            URL url = new URL(requestURL);
            try {
                InputStream inputStream = url.openStream();
                try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                    bufferedReader.lines().forEach(stringBuilder::append);
                    apiContent = stringBuilder.toString();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return apiContent;
    }

    ExchangeRatesSeries getExchangeRatesSeriesFromString_apiContentByGSON(String apiContent) {
        return GSON.fromJson(apiContent, ExchangeRatesSeries.class);
    }
}
