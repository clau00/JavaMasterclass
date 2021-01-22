package Collections.Sorted;

public class StockItemMain {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 7.54, 2);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 36);
        stockList.addStock(temp);

        temp = new StockItem("door", 34.65, 15);
        stockList.addStock(temp);

        temp = new StockItem("chair", 16.99, 100);
        stockList.addStock(temp);

        temp = new StockItem("juice", 1.99 , 142);
        stockList.addStock(temp);

        temp = new StockItem("cup", 1.23, 9);
        stockList.addStock(temp);
        temp = new StockItem("cup", 1.5, 11);
        stockList.addStock(temp);

        temp = new StockItem("table", 47.04, 5);
        stockList.addStock(temp);

        System.out.println(stockList);

        ShoppingBasket me = new ShoppingBasket("Me");
        sellItem(me, "car", 1);
        System.out.println(me);

        sellItem(me, "car", 1);
        System.out.println(me);

        sellItem(me, "car", 1);
        sellItem(me, "spanner", 5);
        System.out.println(me);

        sellItem(me, "juice", 4);
        sellItem(me, "cup", 7);
        sellItem(me, "table", 1000);
        System.out.println(me);

        System.out.println(stockList);
    }

    private static int sellItem(ShoppingBasket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("\t We do not sell " + item);
            return -1;
        }
        if(stockList.sellStock(item, quantity) != -1){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return -1;
    }
}
