package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {

    private BankVault vault;

    @Before
    public void setUp() {
        this.vault = new BankVault();
    }

    @Test
    public void testCreateBankVaultReturnsTheCorrectAmountOfCells() {
        assertEquals(12, vault.getVaultCells().size());
    }

    @Test
    public void testCreateBankVaultReturnsEmptyCells() {
        Map<String, Item> vaultCells = vault.getVaultCells();
        for (Item value : vaultCells.values()) {
            assertNull(value);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemShouldThrowIfCellNotPresent() throws OperationNotSupportedException {
        this.vault.addItem("D1", new Item("Pesho", "1626"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemShouldThrowIfCellNotEmpty() throws OperationNotSupportedException {
        this.vault.addItem("C1", new Item("Pesho", "1626"));
        this.vault.addItem("C1", new Item("Gosho", "1000"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemShouldThrowIfItemAlreadyInVault() throws OperationNotSupportedException {
        Item pesho = new Item("Pesho", "1626");
        this.vault.addItem("C1", pesho);
        this.vault.addItem("C2", pesho);
    }

    @Test
    public void testAddItemReturnsTheCorrectMessage() throws OperationNotSupportedException {
        Item pesho = new Item("Pesho", "1626");
        assertEquals("Item:1626 saved successfully!", this.vault.addItem("C1", pesho));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldThrowIfCellNotInVault() throws OperationNotSupportedException {
        Item pesho = new Item("Pesho", "1626");
        this.vault.addItem("B1", pesho);
        this.vault.addItem("B2", new Item("Gosho", "1000"));
        this.vault.removeItem("D1", pesho);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemShouldThrowIfItemNotInCell() throws OperationNotSupportedException {
        Item pesho = new Item("Pesho", "1626");
        this.vault.addItem("B1", pesho);
        this.vault.removeItem("B2", pesho);
    }

    @Test
    public void testRemoveItemEmptiesTheCell() throws OperationNotSupportedException {
        Item pesho = new Item("Pesho", "1626");
        this.vault.addItem("B1", pesho);
        this.vault.removeItem("B1", pesho);
        assertNull(this.vault.getVaultCells().get("B1"));
    }

    @Test
    public void testRemoveItemReturnsTheCorrectMessage() throws OperationNotSupportedException {
        Item pesho = new Item("Pesho", "1000");
        this.vault.addItem("B1", pesho);

        assertEquals("Remove item:1000 successfully!", this.vault.removeItem("B1", pesho));

    }
}
