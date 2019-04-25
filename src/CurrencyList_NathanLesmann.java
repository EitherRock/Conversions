import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CurrencyList_NathanLesmann {
    private List<Currency_NathanLesmann> currencies = new ArrayList<>();

    /**
     * adds an element to the currencies list
     * @param currencyNathanLesmann the object to be removed.
     */
    public void addCurrencyInfo(Currency_NathanLesmann currencyNathanLesmann){
        Objects.requireNonNull(currencyNathanLesmann, "Currency_NathanLesmann cannot be null.");
        this.currencies.add(currencyNathanLesmann);
    }

    /**
     * removes an element from the currencies list
     * @param currencyNathanLesmann the object to be removed.
     */
    public void removeCurrencyInfo(Currency_NathanLesmann currencyNathanLesmann){
        Objects.requireNonNull(currencyNathanLesmann, "Currency_NathanLesmann cannot be null");
        this.currencies.remove(currencyNathanLesmann);
    }

    /**
     * gets an exchange rate from the list to be used
     * @param index the location of the exchange rate in the list
     * @return a number amount for the exchange rate selected
     */
    public double getExchangeRate(int index){
        return currencies.get(index).getExchangeRate();
    }

    /**
     * gets a valid start date for currency exchange rate
     * @param index location of the start date that needs to be returned
     * @return a string version of valid start date
     */
    public String getStartDate(int index){
        return currencies.get(index).getStartDate();
    }

    /**
     * gets a valid end date for currency exchange rate
     * @param index the location of the end date that needs to be returned
     * @return a string version of valid end date
     */
    public String getEndDate(int index){
        return currencies.get(index).getEndDate();
    }

    /**
     * gets the currency type from the list to be used
     * @param index the location of the currency type that needs to be returned
     * @return a string version of the currency type
     */
    public String getCurrencyType(int index){
        return currencies.get(index).getCurrencyType();
    }

    /**
     * gets the number of elements in the currency list to show the size
     * @return the number of elements
     */
    public int getSize(){
        return currencies.size();
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public String toString(){
        return String.format("%s", this.currencies);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof CurrencyList_NathanLesmann)) return false;
        var that = (CurrencyList_NathanLesmann) obj;
        return Objects.equals(this.currencies, that.currencies);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public int hashCode(){
        return Objects.hash(this.currencies);
    }

}
