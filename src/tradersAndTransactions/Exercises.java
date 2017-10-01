package tradersAndTransactions;

import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Exercises {

    public static void main(String... args) {
        Trader raoul = new TraderBase("Raoul", "Cambridge");
        Trader mario = new TraderBase("Mario", "Milan");
        Trader alan = new TraderBase("Alan", "Cambridge");
        Trader brian = new TraderBase("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new TransactionBase(brian, 2011, 300),
                new TransactionBase(raoul, 2012, 1000),
                new TransactionBase(raoul, 2011, 400),
                new TransactionBase(mario, 2012, 710),
                new TransactionBase(mario, 2012, 700),
                new TransactionBase(alan, 2012, 950)
        );

        // 5.1 Find all transactions in 2011 and sort them by value.
        List<Transaction> tr2011 = transactions.stream()
                .filter(t -> t.year() == 2011)
                .sorted(comparingInt(Transaction::value))
                .collect(toList());

        // 5.2 What are all the unique cities that the traders work at?
        List<String> cities =
                transactions.stream()
                        .map(Transaction::trader)
                        .map(Trader::city)
                        .distinct()
                        .collect(toList());

        // 5.3 Find all traders from Cambridge and sort them by name.
        List<Trader> traderFromCambridge =
                transactions.stream()
                        .map(Transaction::trader)
                        .filter(t -> t.city().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::name))
                        .collect(toList());

        // 5.4 Traders name sorted
        String tradersNames =
                transactions.stream()
                        .map(Transaction::trader)
                        .map(Trader::name)
                        .distinct()
                        .sorted()
                        .collect(joining(", ", "Traders:[", "]"));

        // 5.5 Are any traders based in Milan
        Boolean anyTradersInMilan =
                transactions.stream()
                        .map(Transaction::trader)
                        .anyMatch(trader ->
                                trader.city().equals("Milan"));

        // 5.6 Print all transaction values from traders in Cambridge.
        transactions.stream()
                .filter(transaction -> transaction.trader().city().equals("Cambridge"))
                .map(Transaction::value)
                .forEach(System.out::println);

        // 5.7 What's the highest value of all transactions?
        Optional<Integer> highestValueOfTransaction =
                transactions.stream()
                        .map(Transaction::value)
                        .reduce(Integer::max);

        // 5.8 Find the transaction with the smallest value.
        Optional<Integer> lowestValueOfTransaction =
                transactions.stream()
                        .map(Transaction::value)
                        .reduce(Integer::min);


        tr2011.forEach(System.out::println);
        cities.forEach(System.out::println);
        traderFromCambridge.forEach(System.out::println);
        System.out.println(tradersNames);
        System.out.println("Any traders based in Milan? " + (anyTradersInMilan ? "yes" : "no"));
        System.out.println("Highest value transaction: $" + highestValueOfTransaction.orElse(0));
        System.out.println("Smallest value transaction: $" + lowestValueOfTransaction.orElse(0));
    }
}
