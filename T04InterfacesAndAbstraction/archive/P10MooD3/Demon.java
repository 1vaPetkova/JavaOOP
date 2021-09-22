package T04InterfacesAndAbstraction.archive.P10MooD3;

public class Demon extends GameObject {
    private double energy;

    public Demon(String username, int level, double energy) {
        super(username, level);
        this.energy = energy;
    }

    @Override
    public void setHashedPassword() {
        int pass = super.getUsername().length() * 217;
        this.hashedPassword = String.valueOf(pass);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append(this.getLevel() * this.energy);
        return sb.toString();
    }
}
