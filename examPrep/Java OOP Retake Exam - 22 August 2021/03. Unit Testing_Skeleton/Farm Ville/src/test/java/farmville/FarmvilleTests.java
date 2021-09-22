package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class FarmvilleTests {


    private static final String NAME = "Fermichka";
    private static final int CAPACITY = 5;
    private Farm farm;
    private Collection<Animal> animals;

    @Before
    public void setUp() {
        this.farm = new Farm(NAME, CAPACITY);
        this.animals = new ArrayList<>();
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsIfNameEmpty() {
       this.farm=new Farm(" ",6);
    }
    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsIfNameNull() {
        this.farm=new Farm(null,3);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsIfCapacityZeroOrLessThanZero() {
        this.farm=new Farm("MyauMyau",-2);
    }


    @Test
    public void testConstructorCreatesCorrectFarmName() {
        assertEquals(NAME, this.farm.getName());
    }

    @Test
    public void testConstructorCreatesCorrectFarmCapacity() {
        assertEquals(CAPACITY, this.farm.getCapacity());
    }

    @Test
    public void testGetCountReturnsAnimalsCount() {
        List<Animal> animals = stubUp();
        assertEquals(animals.size(), this.farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfCapacityReached() {
        List<Animal> animals = stubUp();
        this.farm.add(new Animal("chicken", 6));
        this.farm.add(new Animal("dog", 17));
        this.farm.add(new Animal("sheep", 22));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddShouldThrowIfAnimalOfThisTypePresent() {
        List<Animal> animals = stubUp();
        this.farm.add(new Animal("chicken", 6));
        this.farm.add(new Animal("chicken", 8));
    }


    @Test
    public void testRemoveReturnsFalseIfAnimalNotPresent(){
        stubUp();
        assertFalse(this.farm.remove("kote"));
    }

    @Test
    public void testRemoveReturnsTrueIfAnimalPresent(){
        stubUp();
      assertTrue(this.farm.remove("cat"));
    }

    private List<Animal> stubUp() {
        List<Animal> list = Arrays.asList(
                new Animal("goat", 12.5),
                new Animal("cat", 10),
                new Animal("cow", 16)
        );
        for (Animal animal : list) {
            this.farm.add(animal);

        }
        return list;
    }




}
