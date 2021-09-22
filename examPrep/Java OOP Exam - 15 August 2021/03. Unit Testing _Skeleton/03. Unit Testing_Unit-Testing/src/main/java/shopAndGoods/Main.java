package shopAndGoods;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {
        Goods banana = new Goods("banana", "100");
        Goods apple = new Goods("apple", "554");
        Goods hazelnut = new Goods("hazelnut", "123");
        Shop shop = new Shop();
        System.out.println(shop.addGoods("Shelves1",banana));
        System.out.println(shop.addGoods("Shelves2",apple));
        System.out.println(shop.addGoods("Shelves3",hazelnut));
    }
}
