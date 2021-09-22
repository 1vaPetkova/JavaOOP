package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int CAPACITY = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int BULLETS_PER_SHOT = 1;

    public Pistol(String name) {
        super(name, CAPACITY, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() == 0
                && getTotalBullets() >= BULLETS_PER_SHOT) {
            reload();
        }
        if (this.getBulletsPerBarrel() >= BULLETS_PER_SHOT) {
            this.setBulletsPerBarrel(this.getBulletsPerBarrel() - BULLETS_PER_SHOT);
        }
        return BULLETS_PER_SHOT;
    }

    private void reload() {
        this.setTotalBullets(this.getTotalBullets() - CAPACITY);
        this.setBulletsPerBarrel(CAPACITY);
    }

}
