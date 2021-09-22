package computers;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ComputerManagerTests {

    private ComputerManager computerManager;

    @Before
    public void setUp() {
        this.computerManager = new ComputerManager();
    }

    @Test
    public void testGetCountReturnsTheCorrectAmountOfComputers() {
        List<Computer> computers = stubUp();
        assertEquals(computers.size(), computerManager.getCount());
    }

    @Test
    public void testGetComputersReturnTheCorrectCollection() {
        List<Computer> computers = stubUp();
        assertEquals(computers, computerManager.getComputers());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerThrowsIfComputerExists() {
        stubUp();
        computerManager.addComputer(new Computer("manufact_1", "model_1", 1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowsWhenManufacturerNull() {
        stubUp();
        computerManager.getComputer(null, "model_1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowsWhenManufacturerEmpty() {
        stubUp();
        computerManager.getComputer("", "model_1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowsWhenModelEmpty() {
        stubUp();
        computerManager.getComputer("manufact_1", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowsWhenModelNull() {
        stubUp();
        computerManager.getComputer("manufact_1", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerThrowsWhenComputerNotPresent() {
        stubUp();
        computerManager.getComputer("manufact_1", "model_5");
    }

    @Test
    public void testGetComputerReturnsCorrectComputer() {
        stubUp();
        Computer expected = new Computer("manufact_4", "model_4", 1050);
        computerManager.addComputer(expected);
        assertEquals(expected, computerManager.getComputer("manufact_4", "model_4"));
    }

    @Test
    public void testRemoveReturnsCorrectComputer() {
        stubUp();
        Computer expected = new Computer("manufact_4", "model_4", 1050);
        computerManager.addComputer(expected);
        assertEquals(expected, computerManager.removeComputer("manufact_4", "model_4"));
    }

    @Test
    public void testGetComputersByManufacturerReturnsTheCorrectComputers() {
        List<Computer> expected = stubUp()
                .stream()
                .filter(c -> c.getManufacturer().equals("manufact_2"))
                .collect(Collectors.toList());
        assertEquals(expected, computerManager.getComputersByManufacturer("manufact_2"));
    }

    @Test
    public void testGetComputerPriceReturnsTheCorrectValue() {
        this.computerManager.addComputer(new Computer("manufact_2", "model_2", 1800));
        assertEquals(1800,
                computerManager.getComputer("manufact_2", "model_2").getPrice(), 0.00);
    }

    private List<Computer> stubUp() {
        List<Computer> computers = Arrays.asList(
                new Computer("manufact_1", "model_1", 1200),
                new Computer("manufact_2", "model_2", 1800),
                new Computer("manufact_3", "model_3", 2200),
                new Computer("manufact_3", "model_35", 2200),
                new Computer("manufact_2", "model_33", 1500),
                new Computer("manufact_2", "model_34", 1950)
        );
        for (Computer computer : computers) {
            computerManager.addComputer(computer);
        }
        return computers;
    }

}