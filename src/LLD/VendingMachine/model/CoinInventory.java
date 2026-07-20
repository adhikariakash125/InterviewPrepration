package LLD.VendingMachine.model;

import LLD.VendingMachine.enums.Coin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinInventory {
    private final HashMap<Coin, Integer> coinInventory;

    public CoinInventory() {
        this.coinInventory = new HashMap<>();
    }

    public void addCoin(Coin coin, int quantity) {
        coinInventory.put(coin, coinInventory.getOrDefault(coin, 0) + quantity);
    }

    public void addCoins(Map<Coin, Integer> coins) {
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            addCoin(entry.getKey(), entry.getValue());
        }
    }

    public void decrementCoin(Coin coin, int quantity) {
        if (!coinInventory.containsKey(coin)) {
            System.out.println("No coin found");
            return;
        }
        if (coinInventory.get(coin) <= 0) {
            System.out.println("Coin inventory is already 0....nothing to decrement");
            return;
        }
        Integer coinQuantity = coinInventory.get(coin)-quantity;
        coinInventory.put(coin,coinQuantity);
    }

    public HashMap<Coin, Integer> getCoinInventory() {
        return coinInventory;
    }

    public Map<Coin, Integer> getChange(int amount, Map<Coin, Integer> extraCoins) {
        HashMap<Coin, Integer> availableCoins = new HashMap<>(coinInventory);
        for (Map.Entry<Coin, Integer> entry : extraCoins.entrySet()) {
            availableCoins.put(entry.getKey(), availableCoins.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }

        HashMap<Coin, Integer> change = new HashMap<>();
        int remainingAmount = amount;

        List<Coin> coins = new ArrayList<>(availableCoins.keySet());
        coins.sort(Comparator.comparingInt(Coin::getValue).reversed());

        for (Coin coin : coins) {
            int requiredCoins = remainingAmount / coin.getValue();
            int availableQuantity = availableCoins.getOrDefault(coin, 0);
            int coinsToUse = Math.min(requiredCoins, availableQuantity);

            if (coinsToUse > 0) {
                change.put(coin, coinsToUse);
                remainingAmount -= coinsToUse * coin.getValue();
            }
        }

        if (remainingAmount != 0) {
            return null;
        }

        return change;
    }

    public void decrementCoins(Map<Coin, Integer> coins) {
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            decrementCoin(entry.getKey(), entry.getValue());
        }
    }
}
