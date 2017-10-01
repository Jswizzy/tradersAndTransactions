package tradersAndTransactions;

public class TransactionBase implements Transaction {

    private Trader trader;
    private int year;
    private int value;

    public TransactionBase(Trader trader, int year, int value)
    {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    @Override
    public Trader trader(){
        return this.trader;
    }

    @Override
    public int year(){
        return this.year;
    }

    @Override
    public int value(){
        return this.value;
    }

    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}
