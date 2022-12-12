package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final int DEFAULT = 0;

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public void printMachineCoins(Map<Coin, Integer> coins) {
        System.out.printf("%d원 - %d개\n", Coin.COIN_500.getAmount(), coins.getOrDefault(Coin.COIN_500, DEFAULT));
        System.out.printf("%d원 - %d개\n", Coin.COIN_100.getAmount(), coins.getOrDefault(Coin.COIN_100, DEFAULT));
        System.out.printf("%d원 - %d개\n", Coin.COIN_50.getAmount(), coins.getOrDefault(Coin.COIN_50, DEFAULT));
        System.out.printf("%d원 - %d개\n\n", Coin.COIN_10.getAmount(), coins.getOrDefault(Coin.COIN_10, DEFAULT));
    }
}
