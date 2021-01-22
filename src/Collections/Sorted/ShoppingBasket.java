package Collections.Sorted;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public ShoppingBasket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if((item != null) && (quantity > 0)){
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return -1;
    }

    public Map<StockItem, Integer> items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\n\tShopping basket " + name + " contains " + list.size() + " items\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem, Integer> item : list.entrySet()){
            s = s + "  " + item.getKey() + ". " + item.getValue() + " purchased.\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        s = s + "  ----------------------------------------\n";
        return s + "\tTotal cost " + String.format("%.2f", totalCost) + "\n\n";
    }
}
