import java.util.Scanner;

public final class ConsoleUtil_NathanLesmann
{
    /**
     * gets the currency code to so the program can find the exchange rate.
     * checks if ints and doubles are used and prompts the user to enter a valid input until one is received.
     * @param prompt create prompt asking for the currency code
     * @return returns the valid code to be used
     */
    public static String getType(String prompt){
        var scan = new Scanner(System.in);
        System.out.print(prompt);

        // checks if an int is entered and tells the user to try again if there is one
        while(scan.hasNextInt()){
            System.out.println("Invalid entry, try again.");
            System.out.print(prompt);
            scan.next();
        }
        // checks if a double is entered and tells the user to try again if there is one
        while(scan.hasNextDouble()){
            System.out.print("Invalid entry, try again.\n");
            System.out.print(prompt);
            scan.next();
        }
        return scan.next();
    }


    /**
     * retrieves the double entered from the user. checks to see if its valid then returns the double
     * @param prompt created prompt to ask for the amount to be converted
     * @return valid double amount
     */
    public static double getAmount(String prompt){

        System.out.print(prompt);
        var scan = new Scanner(System.in);

        while(!scan.hasNextDouble()){
            System.out.println("Invalid, please try again.");
            scan.nextLine();
            System.out.print(prompt);
        }
        return scan.nextDouble();
    }

    /**
     * checks for negative numbers
     * @param prompt asks user for amount
     * @return the amount entered by user if the amount is valid
     */
    public static double getValidAmount(String prompt){
        var amount = getAmount(prompt);
        while(amount < 0.0){
            System.out.println("Amount cannot be less than 0.");
            amount = getAmount(prompt);
        }
        return amount;
    }

    /**
     * checks if the code entered by the user is a valid code from the currency list
     * @param prompt asks the user to enter a valid type
     * @param list currency list that holds currency information
     * @return a valid code to be used
     */
    public static String validCode(String prompt, CurrencyList_NathanLesmann list){

        var code = getType(prompt);
        var valid = false;
        while(!valid) {
            for (var count = 0; count < list.getSize(); count++) {
                if (code.equalsIgnoreCase(list.getCurrencyType(count))) {
                    valid = true;
                }
            }
            if(!valid) {
                System.out.println("Invalid code, try again");
                code = getType(prompt);
            }
        }
        return code;
    }


    /**
     * uses the currency code entered by the user and uses that to find the exchange rate associated with the code
     * @param type currency type to be looked up
     * @param list list of Currency_NathanLesmann objects
     * @return the exchange rate from Currency_NathanLesmann list
     */
    public static double getAmountFromType(String type, CurrencyList_NathanLesmann list){

        var exchange = 0.0;

        // iterates through the currency list for currency types
        for(var count = 0; count < list.getSize(); count++){
            // get the exchange rate if the type is matched with a code
            if (type.equalsIgnoreCase(list.getCurrencyType(count))){
                exchange =  list.getExchangeRate(count);
            }
        }
        return exchange;
    }

    /**
     * uses the type entered by the user and matches to an element in a currency list. once there's a match,
     * the start date will be returned
     * @param type currency code entered in by the user
     * @param list currency list which holds currency info
     * @return the a string version of the exchange rates valid start date
     */
    public static String displayStartDate(String type, CurrencyList_NathanLesmann list){

        var startDate = " ";

        for( var count = 0; count < list.getSize(); count++){
            // sets startDate to the start date retrieved
            if(type.equalsIgnoreCase(list.getCurrencyType(count))){
                startDate = list.getStartDate(count);
            }
        }
        return startDate;
    }

    /**
     * retrieves the valid end date for exchange rate
     * @param type currency type entered by the user to find stats
     * @param list list of currency informtation
     * @return A string version of the valid enddate
     */
    public static String displayEndDate(String type, CurrencyList_NathanLesmann list){

        var endDate = " ";

        for( var count = 0; count < list.getSize(); count++){
            // sets startDate to the start date retrieved
            if(type.equalsIgnoreCase(list.getCurrencyType(count))){
                endDate = list.getEndDate(count);
            }
        }
        return endDate;
    }
}
