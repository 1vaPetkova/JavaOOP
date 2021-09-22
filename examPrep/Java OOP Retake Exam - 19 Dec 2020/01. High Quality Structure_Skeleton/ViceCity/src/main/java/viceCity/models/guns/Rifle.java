package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int CAPACITY = 50;
    private static final int TOTAL_BULLETS = 500;
    private static final int BULLETS_PER_SHOT = 5;

    public Rifle(String name) {
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
