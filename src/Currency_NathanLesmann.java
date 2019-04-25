import java.util.Objects;

public final class Currency_NathanLesmann {

    private double exchangeRate;
    private String currencyType;
    private String startDate;
    private String endDate;

    /**
     * Constructor for Currency_NathanLesmann
     * @param exchangeRate  number used for converting from currency information
     * @param currencyType currency code from website
     * @param startDate start date for the exchange rate
     * @param endDate end date for the exchange rate
     */
    public Currency_NathanLesmann(double exchangeRate, String currencyType, String startDate, String endDate){
        this.setExchangeRate(exchangeRate);
        this.setCurrencyType(currencyType);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

    /**
     * retrieves the exchange rate and displays it
     * @return exchange rate
     */
    public double getExchangeRate(){
        return this.exchangeRate;
    }

    /**
     * sets the variable exchange rate to exchange rate
     * @param exchangeRate value entered into constructor
     */
    private void setExchangeRate(double exchangeRate ){
        if(Double.compare(exchangeRate, 0.0) < 0) {
            throw new IllegalArgumentException("Invalid amount, must be Q >= 0.0");
        }
        //else amount is fine doNothing()

        this.exchangeRate = exchangeRate ;
    }

    /**
     * gets the currency type to be used
     * @return a currency type in String format
     */
    public String getCurrencyType(){
        return this.currencyType;
    }

    /**
     * sets the variable currencyType to the entered value for currency type
     * @param currencyType entered Currency_NathanLesmann type
     */
    private void setCurrencyType(String currencyType){
        Objects.requireNonNull(currencyType, "Currency_NathanLesmann type cannot be null");
        if(currencyType.length() == 0){
            throw new IllegalArgumentException("Currency_NathanLesmann type cannot be empty.");
        }
        this.currencyType = currencyType;
    }

    /**
     * gets the start date for a valid currency type
     * @return a string version of the valid start date
     */
    public String getStartDate(){
        return this.startDate;
    }

    /**
     * Sets the variable for start date with a valid start date from the url
     * @param startDate date from the url file
     */
    private void setStartDate(String startDate){
        Objects.requireNonNull(startDate, "start date cannot be null");
        if(startDate.length() == 0){
            throw new IllegalArgumentException("start date cannot be null");
        }
        this.startDate = startDate;
    }

    /**
     * gets the end date to be used elsewhere
     * @return a string version of the valid end date
     */
    public String getEndDate(){
        return endDate;
    }
    private void setEndDate(String endDate){
        Objects.requireNonNull(endDate, "start date cannot be null");
        if(endDate.length() == 0){
            throw new IllegalArgumentException("start date cannot be null");
        }
        this.endDate = endDate;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public String toString(){
        return String.format("%s | %.2f | %s | %s",
                            this.currencyType, this.exchangeRate, this.startDate, this.endDate);
    }
    /**
     * {@inheritDoc}
     */
     @Override
    public int hashCode(){
        return Objects.hash(this.currencyType, this.exchangeRate,
                                        this.startDate, this.endDate);
     }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Currency_NathanLesmann)) return false;
        var that = (Currency_NathanLesmann) obj;
        return  Objects.equals(this.exchangeRate, that.exchangeRate) &&
                Objects.equals(this.currencyType, that.currencyType) &&
                Objects.equals(this.startDate, that.startDate) &&
                Objects.equals(this.endDate, that.endDate);
    }
}
