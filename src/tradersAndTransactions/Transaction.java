package tradersAndTransactions;

public interface Transaction {
    Trader trader();

    int year();

    int value();
}
