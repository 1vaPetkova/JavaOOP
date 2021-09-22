package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp() {
        shop = new Shop();
    }

    @Test
    public void testConstructorCreatesTheCorrectShelves() {
        int index = 1;
        for (String shelfNumber : shop.getShelves().keySet()) {
            assertEquals("Shelves" + index++,shelfNumber);
        }

        for (Goods good : shop.getShelves().values()) {
           assertNull(good);
        }
    }

    @Test
    public void testGetShelvesReturnsTheCorrectAmountOfShelvesInShop() {
        assertEquals(12, shop.getShelves().size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsThrowsIfShelfNotInShop() throws OperationNotSupportedException {
        Goods banana = new Goods("banana", "155");
        shop.addGoods("Shelf 5", banana);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddGoodsThrowsIfShelfNotEmpty() throws OperationNotSupportedException {
        Goods banana = new Goods("banana", "155");
        Goods apple = new Goods("apple", "100");
        shop.addGoods("Shelves1", banana);
        shop.addGoods("Shelves1", apple);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddGoodsThrowsIfGoodIsAlreadyInShelf() throws OperationNotSupportedException {
        Goods banana = new Goods("banana", "155");
        shop.addGoods("Shelves1", banana);
        shop.addGoods("Shelves2", banana);
    }

    @Test
    public void testAddGoodsAddsTheCorrectProduct() throws OperationNotSupportedException {
        Goods banana = new Goods("banana", "155");
        shop.addGoods("Shelves1", banana);
        assertEquals(banana, shop.getShelves().get("Shelves1"));
        assertEquals("banana", shop.getShelves().get("Shelves1").getName());
        assertEquals("155", shop.getShelves().get("Shelves1").getGoodsCode());
    }

    @Test
    public void testAddReturnsTheCorrectMessage() throws OperationNotSupportedException {
        Goods banana = new Goods("banana", "155");
        assertEquals("Goods: 155 is placed successfully!",
                shop.addGoods("Shelves1", banana));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsThrowsIfShelfNotInStore() {
        Goods banana = new Goods("banana", "155");
        shop.removeGoods("Shelves15", banana);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveGoodsThrowsIfGoodNotInShelfGiven() throws OperationNotSupportedException {
        Goods banana = new Goods("banana", "155");
        Goods apple = new Goods("apple", "100");
        shop.addGoods("Shelves1", banana);
        shop.addGoods("Shelves2", apple);
        shop.removeGoods("Shelves1", apple);
    }

    @Test
    public void testRemoveGoodsEmptiesTheShelf() throws OperationNotSupportedException {
        Goods banana = new Goods("banana", "155");
        Goods apple = new Goods("apple", "100");
        shop.addGoods("Shelves1", banana);
        shop.addGoods("Shelves2", apple);
        shop.removeGoods("Shelves1", banana);
        assertNull(shop.getShelves().get("Shelves1"));
    }

    @Test
    public void testRemoveReturnsTheCorrectMessage() throws OperationNotSupportedException {
        Goods banana = new Goods("banana", "155");
        Goods apple = new Goods("apple", "100");
        shop.addGoods("Shelves1", banana);
        shop.addGoods("Shelves2", apple);
        assertEquals("Goods: 155 is removed successfully!",
                shop.removeGoods("Shelves1", banana));
    }
}