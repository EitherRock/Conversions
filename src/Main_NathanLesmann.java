
import java.io.IOException;

public class Main_NathanLesmann {
    public static void main(String[] args) throws IOException {

        var dao = new CurrencyDAO_NathanLesmann();
        var list = dao.getConverted();

        var amount = ConsoleUtil_NathanLesmann.getValidAmount("Enter the amount to be converted: ");
        var type = ConsoleUtil_NathanLesmann.validCode("Enter currency code: ", list);
        var exchange = ConsoleUtil_NathanLesmann.getAmountFromType(type, list);

        // displays amount entered by user,
        // the exchange rate that was in the website file
        // the new amount which was amount multiplied by the exchange rate
        // the valid beginning and end dates for the exchange rate
        System.out.println("**********************************");
        System.out.printf("Amount: $%.2f%n", amount);
        System.out.printf("Exchange Rate: $%.2f%n", exchange);
        System.out.printf("Converted Amount: $%.2f%n", amount * exchange);
        System.out.printf("Beginning Date: %s%n", ConsoleUtil_NathanLesmann.displayStartDate(type, list));
        System.out.printf("End Date: %s", ConsoleUtil_NathanLesmann.displayEndDate(type, list));

    }
}
