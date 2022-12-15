package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

public class OutputView {
    private static final String PREFIX = "[ERROR] ";

    public void printRemainMoney(int remainMoney) {
        System.out.printf("투입 금액: %d원\n", remainMoney);
    }

    public void printError(String message) {
        System.out.println(PREFIX + message);
    }

    public void printMachineCoins(Map<Coin, Integer> coins) {
        System.out.println("자판기가 보유한 동전");
        printCoins(coins);
    }

    public void printChanges(Map<Coin, Integer> change, int remainMoney) {
        System.out.println();
        printRemainMoney(remainMoney);
        System.out.println("잔돈");
        printCoins(change);
    }

    private void printCoins(Map<Coin, Integer> coins) {
        System.out.printf("%d원 - %d개\n", Coin.COIN_500.getAmount(), coins.getOrDefault(Coin.COIN_500, 0));
        System.out.printf("%d원 - %d개\n", Coin.COIN_100.getAmount(), coins.getOrDefault(Coin.COIN_100, 0));
        System.out.printf("%d원 - %d개\n", Coin.COIN_50.getAmount(), coins.getOrDefault(Coin.COIN_50, 0));
        System.out.printf("%d원 - %d개\n\n", Coin.COIN_10.getAmount(), coins.getOrDefault(Coin.COIN_10, 0));
    }
}
