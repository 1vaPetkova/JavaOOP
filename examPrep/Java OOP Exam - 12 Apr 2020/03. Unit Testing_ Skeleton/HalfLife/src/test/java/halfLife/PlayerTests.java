package halfLife;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {

    @Test(expected = NullPointerException.class)
    public void testSetUsernameThrowsIfNameNull() {
        new Player(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetUsernameThrowsIfNameWhitespace() {
        new Player(" ", 10);
    }

    @Test
    public void testSetUsernameCreatesTheCorrectPlayer() {
        Player gosho = new Player("Gosho", 15);
        Assert.assertEquals("Gosho", gosho.getUsername());
        Assert.assertEquals(15, gosho.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetHealthThrowsIfHealthBelowZero() {
        new Player("Kiro", -2);
    }


    @Test
    public void testGetGunsReturnTheCorrectAmountOfItems() {
        Player gosho = new Player("Gosho", 15);
        List<Gun> expected = new ArrayList<>();
        Gun gun_1 = new Gun("gun_1", 15);
        Gun gun_2 = new Gun("gun_2", 28);
        Gun gun_3 = new Gun("gun_3", 16);
        expected.add(gun_1);
        gosho.addGun(gun_1);
        expected.add(gun_2);
        gosho.addGun(gun_2);
        expected.add(gun_3);
        gosho.addGun(gun_3);
        Assert.assertEquals(expected.size(),gosho.getGuns().size());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrowsIfHealthBelowZeroOrZero(){
        Player gosho = new Player("Gosho", 15);
        gosho.takeDamage(16);
        gosho.takeDamage(10);
    }

    @Test
    public void testTakeDamageSetsHealthZeroIfDamageMoreThanHealth(){
        Player gosho = new Player("Gosho", 15);
        gosho.takeDamage(16);
      Assert.assertEquals(0,gosho.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunShouldThrowIfGunNull(){
        Player gosho = new Player("Gosho", 15);
        gosho.addGun(null);
    }
    @Test
    public void testTakeDamageReducesHealth(){
        Player gosho = new Player("Gosho", 15);
        gosho.takeDamage(10);
        Assert.assertEquals(5,gosho.getHealth());
    }

    @Test
    public void testRemoveGunReturnsTrueWhenGunPresent(){
        Player gosho = new Player("Gosho", 15);
        Gun gun_1 = new Gun("gun_1", 15);
        Gun gun_2 = new Gun("gun_2", 28);
        Gun gun_3 = new Gun("gun_3", 16);
        gosho.addGun(gun_1);
        gosho.addGun(gun_2);
        gosho.addGun(gun_3);
        Assert.assertTrue(gosho.removeGun(gun_2));
    }
    @Test
    public void testRemoveGunReturnsFalseWhenGunPresent(){
        Player gosho = new Player("Gosho", 15);
        Gun gun_1 = new Gun("gun_1", 15);
        Gun gun_2 = new Gun("gun_2", 28);
        Gun gun_3 = new Gun("gun_3", 16);
        Gun gun_4 = new Gun("gun_4", 7);
        gosho.addGun(gun_1);
        gosho.addGun(gun_2);
        gosho.addGun(gun_3);
        Assert.assertFalse(gosho.removeGun(gun_4));
    }
    @Test
    public void testGetGunReturnsTheCorrectGun(){
        Player gosho = new Player("Gosho", 15);
        Gun gun_1 = new Gun("gun_1", 15);
        Gun gun_2 = new Gun("gun_2", 28);
        Gun gun_3 = new Gun("gun_3", 16);

        gosho.addGun(gun_1);
        gosho.addGun(gun_2);
        gosho.addGun(gun_3);
        Assert.assertEquals(gun_2,gosho.getGun("gun_2"));
    }

    @Test
    public void testGetBulletsReturnsTheCorrectCount() {
        Player gosho = new Player("Gosho", 15);
        Gun gun_1 = new Gun("gun_1", 15);
        Gun gun_2 = new Gun("gun_2", 28);
        gosho.addGun(gun_1);
        gosho.addGun(gun_2);
        Assert.assertEquals(28,gosho.getGun("gun_2").getBullets());
    }
}
