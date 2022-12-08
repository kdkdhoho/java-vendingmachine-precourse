package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

public class OutputView {

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printVendingMachineCoins(Map<Coin, Integer> coins) {
        System.out.println("자판기가 보유한 동전");
        System.out.printf("%d원 - %d개\n", Coin.COIN_500.getAmount(), coins.getOrDefault(Coin.COIN_500, 0));
        System.out.printf("%d원 - %d개\n", Coin.COIN_100.getAmount(), coins.getOrDefault(Coin.COIN_100, 0));
        System.out.printf("%d원 - %d개\n", Coin.COIN_50.getAmount(), coins.getOrDefault(Coin.COIN_50, 0));
        System.out.printf("%d원 - %d개\n", Coin.COIN_10.getAmount(), coins.getOrDefault(Coin.COIN_10, 0));
    }

    public void printRemainMoney(int remainMoney) {
        System.out.printf("\n투입 금액: %d원\n", remainMoney);
    }

    public void printChanges(Map<Coin, Integer> exchange) {
        System.out.println("잔돈");
        Coin[] values = Coin.values();
        for (Coin coin : values) {
            if (exchange.get(coin) != 0) {
                System.out.printf("%d원 - %d개\n", coin.getAmount(), exchange.get(coin));
            }
        }
    }
}
