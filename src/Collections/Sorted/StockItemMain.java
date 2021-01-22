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

        temp = new StockItem("table", 47.04, 5);
        stockList.addStock(temp);

        System.out.println(stockList);
    }
}
