package vendingmachine.service;

import vendingmachine.domain.Coin;

import java.util.Map;

public class MainService {

    public Map<Coin, Integer> changeCoins(int money) {
        return Coin.change(money);
    }
}
