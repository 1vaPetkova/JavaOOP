package blueOrigin;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SpaceshipTests {

    private static final int CAPACITY = 5;
    private static final String NAME = "Ship";
    private Spaceship spaceship;


    @Before
    public void setUp() {
        this.spaceship = new Spaceship(NAME, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWhenEmpty() {
        Spaceship spaceship = new Spaceship(" ", 15);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameShouldThrowWhenNull() {
        Spaceship spaceship = new Spaceship(null, 15);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityShouldThrowWhenLessThanZero() {
        new Spaceship("Kiro", -2);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfSizeEqualsCapacity() {
        setSpaceShips();
        spaceship.add(new Astronaut("Pepi", 88));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfAstronautExistsInSpaceship() {
        Astronaut gosho = new Astronaut("Gosho", 88);
        spaceship.add(gosho);
        spaceship.add(gosho);
    }

    @Test
    public void testGetCountReturnsCorrectNumberOfAstronauts() {
        List<Astronaut> astronauts = setSpaceShips();
        assertEquals(astronauts.size(), spaceship.getCount());
    }

    @Test
    public void testGetNameReturnsCorrectNameOfTheShip() {
        setSpaceShips();
        assertEquals(NAME, spaceship.getName());
    }

    @Test
    public void testRemoveReturnsFalseWhenAstronautNotPresent() {
        setSpaceShips();
        assertFalse(spaceship.remove("Toni"));
    }

    @Test
    public void testRemoveReturnsTrueWhenAstronautInSpaceShip() {
        setSpaceShips();
        assertTrue(spaceship.remove("Kiro"));
    }

    @Test
    public void testGetOxygenCapacityReturnsTheCorrectValueOfTheAstronaut() {
        Astronaut a = new Astronaut("Gardzhoka", 66);

        assertEquals(66, a.getOxygenInPercentage(), 0);
    }

    private List<Astronaut> setSpaceShips() {
        List<Astronaut> list = Arrays.asList(
                new Astronaut("Gosho", 25),
                new Astronaut("Kiro", 15),
                new Astronaut("Sasho", 12),
                new Astronaut("Ivancho", 7),
                new Astronaut("Pesho", 68));
        list.forEach(a -> spaceship.add(a));
        return list;
    }
}
