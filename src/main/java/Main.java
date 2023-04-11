import model.ExchangeRatesSeries;
import model.Rate;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Utilities utilities = new Utilities();

        System.out.println();
        System.out.println("Aplikacja pobiera serię kursów pojedynczej waluty, dla określonego");
        System.out.println("typu tabeli oraz symbolu waluty.");
        System.out.println();

        boolean flag = true;
        char sign;
        do {
            System.out.println();
            System.out.println("Wybierz: \n" +
                    " a) Tabela A kursów średnich walut obcych\n" +
                    " b) Tabela C kursów kupna i sprzedaży walut obcych\n" +
                    " q) wyjście");
            System.out.println();

            sign = utilities.getChar('a', 'b', 'q');
            switch (sign) {
                case 'a' :
                    System.out.println("Tabela A kursów średnich walut obcych.");
                    String requestURL_A = "http://api.nbp.pl/api/exchangerates/rates/" + "a" + "/" + "usd" + "/" + "2023-03-01" + "/" + "2023-03-31" + "/?format=" + "json";
                    String apiContent = utilities.loadApiContentFromURL(requestURL_A);
                    System.out.println(apiContent);

                    System.out.println();
                    ExchangeRatesSeries exchangeRatesSeries = utilities.getExchangeRatesSeriesFromString_apiContentByGSON(apiContent);
                    List<Rate> rateList = exchangeRatesSeries.getRates();
                    rateList.forEach(System.out::println);
                    break;
                case 'b' :
                    System.out.println("Tabela A kursów średnich walut obcych.");
                    String requestURL_B = "http://api.nbp.pl/api/exchangerates/rates/" + "c" + "/" + "usd" + "/" + "2023-03-01" + "/" + "2023-03-31" + "/?format=" + "json";
                    String apiContent_B = utilities.loadApiContentFromURL(requestURL_B);
                    System.out.println(apiContent_B);

                    System.out.println();
                    ExchangeRatesSeries exchangeRatesSeries_B = utilities.getExchangeRatesSeriesFromString_apiContentByGSON(apiContent_B);
                    List<Rate> rateList_B = exchangeRatesSeries_B.getRates();
                    rateList_B.forEach(System.out::println);
                    break;
                case 'q' :
                    flag = false;
            }
        }while (flag);
    }
}
