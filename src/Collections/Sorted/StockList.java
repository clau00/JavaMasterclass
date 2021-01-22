package Collections.Sorted;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            //check if item exists in list
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if we found an item in list
            if(inStock != item){
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return -1;
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);

        if((inStock != null) && (quantity > 0)){
            if(inStock.quantityInStock() >= quantity) {
                inStock.adjustStock(-quantity);
                return quantity;
            }else{
                System.out.println("\t There is no item " + item +  " in stock");
                return -1;
            }
        }

        return -1;
    }

    public StockItem get(String key){
        return list.get(key);
    }

    public Map<String, StockItem> items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\n\tItems in stock:\n";
        s = s + "  ---------------------------------------------------------------------\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item: list.entrySet()){
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.quantityInStock() * stockItem.getPrice();

            s = s + "  " + stockItem + ". There are " + stockItem.quantityInStock() +
                    " in stock. Value of items: " + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }

        s = s + "  ---------------------------------------------------------------------\n";
        return s + "\tTotal stock value: " + String.format("%.2f", totalCost) + "\n\n";
    }
}
