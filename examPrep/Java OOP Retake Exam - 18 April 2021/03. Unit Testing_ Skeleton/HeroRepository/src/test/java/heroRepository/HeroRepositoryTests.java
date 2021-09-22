package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HeroRepositoryTests {


    private HeroRepository heroRepository;

    @Before
    public void setUp(){
        heroRepository = new HeroRepository();
    }


    @Test(expected = NullPointerException.class)
    public void testCreateShouldThrowIfHeroEmpty(){
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShouldThrowIfHeroAlreadyInRepository(){
        heroRepository.create(new Hero("Pesho",100));
        heroRepository.create(new Hero("Pesho",100));
    }

    @Test
    public void testGetCountShouldReturnTheCorrectAmountOfHeroes(){
        heroRepository.create(new Hero("Pesho",100));
        heroRepository.create(new Hero("Gosho",120));
       assertEquals(2,heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveShouldThrowIfNameEmpty() {
        heroRepository.create(new Hero("Pesho",100));
        heroRepository.create(new Hero("Gosho",120));
        heroRepository.remove("");
    }

    @Test
    public void testRemoveShouldReturnFalseIfHeroNotInRepository() {
        heroRepository.create(new Hero("Pesho",100));
        heroRepository.create(new Hero("Gosho",120));
        Assert.assertFalse(heroRepository.remove("Kiro"));
    }

    @Test
    public void testRemoveShouldReturnTrueIfHerInRepository() {
        heroRepository.create(new Hero("Pesho",100));
        heroRepository.create(new Hero("Gosho",120));
        Assert.assertTrue(heroRepository.remove("Pesho"));
    }


    @Test
    public void testGetHeroWithHighestLevelReturnsTheCorrectHero() {
        heroRepository.create(new Hero("Pesho",100));
        heroRepository.create(new Hero("Gosho",120));
        heroRepository.create(new Hero("Sasho",180));
        Hero expected = new Hero("Sasho",180);
       assertEquals(expected.getName(),heroRepository.getHeroWithHighestLevel().getName());
       assertEquals(expected.getLevel(),heroRepository.getHeroWithHighestLevel().getLevel());
    }

    @Test
    public void testGetHeroReturnsTheCorrectHero() {
        heroRepository.create(new Hero("Pesho",100));
        heroRepository.create(new Hero("Gosho",120));
        heroRepository.create(new Hero("Sasho",180));
        Hero expected = new Hero("Gosho",120);
        assertEquals(expected.getName(),heroRepository.getHero("Gosho").getName());
        assertEquals(expected.getLevel(),heroRepository.getHero("Gosho").getLevel());
    }

    @Test
    public void testGetHeroesReturnsTheCorrectCollection() {
        List<Hero> expected = new ArrayList<>();
        expected.add(new Hero("Pesho",100));
        expected.add(new Hero("Gosho",120));
        expected.add(new Hero("Sasho",180));
        for (Hero h : expected) {
            heroRepository.create(h);
        }
        int index =0;
        for (Hero hero : heroRepository.getHeroes()) {
            assertEquals(expected.get(index++),hero);
        }
    }
}
