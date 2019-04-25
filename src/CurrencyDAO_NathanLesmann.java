import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class CurrencyDAO_NathanLesmann {
    private static final String CURRENCY_URL = "https://assets.publishing.service.gov.uk/government/uploads/system/uploads/attachment_data/file/793045/exrates-monthly-0419.csv";
    private static final char DELIMITER = ',';

    /**
     * used to parse a url text file. splits a line of the file into an array and
     * then takes the currency amount out of the array list.
     * @param line uses the currency type to find the exchange rate
     * @return the exchange rate
     */
    private Currency_NathanLesmann parseCurrency(String line){

        Objects.requireNonNull(line, "Line cannot be null.");

        // puts the line entered into an array then splits up the array
        var tokens = line.split(Character.toString(DELIMITER));
        // created variables to hold specific elements from the tokens list
        var currencyType = tokens[2];
        var exchangeRate = Double.parseDouble(tokens[3]);
        var startDate = tokens[4];
        var endDate = tokens[5];

        return new Currency_NathanLesmann(exchangeRate, currencyType, startDate, endDate);
    }

    /**
     * Reads from a URL and then puts the info into a Currency_NathanLesmann List
     * @return returns a new currencyist which holds relevant information
     * @throws IOException used to try/ catch for reading a url
     */
    public CurrencyList_NathanLesmann getConverted() throws IOException{

        URL url = new URL(CURRENCY_URL);

        // reads from a url
        try (var input = new Scanner(
                            new BufferedReader(
                                    new InputStreamReader(
                                            url.openStream())))) {
            //takes the next line from the Scanner
            input.nextLine();
            // new currency list to hold url data
            var list = new CurrencyList_NathanLesmann();

            var line = " ";
            // if the url has a line, then the selected information will be added to the list
            while(input.hasNextLine()) {
                line = input.nextLine();
                list.addCurrencyInfo(this.parseCurrency(line));
            }
            return list;

        }
    }
}
