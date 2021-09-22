package aquarium;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AquariumTests {

    private static final String NAME = "Fishy fishy";
    private static final int CAPACITY = 5;
    private Aquarium aquarium;

    @Before
    public void setUp() {
        this.aquarium = new Aquarium(NAME, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsIfNameNull() {
        aquarium = new Aquarium(null, 6);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsIfNameEmpty() {
        aquarium = new Aquarium(" ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsIfCapacityNegative() {
        aquarium = new Aquarium("Gosho", -2);
    }

    @Test
    public void testConstructorCreatesCorrectElement() {
        assertEquals(NAME, aquarium.getName());
        assertEquals(CAPACITY, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowsIfAquariumFull() {
        aquarium = new Aquarium("Aqui", 3);
        setFish();
        aquarium.add(new Fish("Tsetsa"));
    }

    @Test
    public void testGetCount() {
        List<Fish> list = setFish();
        assertEquals(list.size(), aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowsIfFishNotInAquarium() {
        setFish();
        aquarium.remove("Sashko");
    }

    @Test
    public void testRemoveReturnsTheRemovedFish() {
        Fish expected = new Fish("Choco");
        aquarium.add(expected);
        aquarium.remove("Choco");
        assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishThrowsIfFishNotInAquarium() {
        setFish();
        aquarium.sellFish("Sashko");
    }

    @Test
    public void testSellFishReturnsTheCorrectFish() {
        Fish expected = new Fish("Sashko");
        aquarium.add(expected);
        assertEquals(expected, aquarium.sellFish("Sashko"));
    }

    @Test
    public void testReportReturnsTheCorrectOutput() {
        List<Fish> fish = setFish();
        List<String> names = fish.stream().map(Fish::getName).collect(Collectors.toList());
        assertEquals(String.format("Fish available at %s: %s",NAME,String.join(", ",names)),
                aquarium.report());
    }
    @Test
    public void testSellFishChangesFishAvailability() {
        Fish expected = new Fish("Sashko");
        aquarium.add(expected);
        Fish sold = aquarium.sellFish("Sashko");
        assertFalse(sold.isAvailable());
    }

    private List<Fish> setFish() {
        List<Fish> list = Arrays.asList(
                new Fish("Kiki"),
                new Fish("Choco"),
                new Fish("Pepi")
        );
        for (Fish fish : list) {
            aquarium.add(fish);
        }
        return list;
    }
}

