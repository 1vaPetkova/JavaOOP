package T04InterfacesAndAbstraction.archive.P10MooD3;

public class Archangel extends GameObject {
    private double mana;

    public Archangel(String username, int level, double mana) {
        super(username, level);
        this.mana = mana;
    }

    @Override
    public void setHashedPassword() {
        StringBuilder sb = new StringBuilder(super.getUsername());
        sb.reverse();
        int length = super.getUsername().length() * 21;
        sb.append(length);
        this.hashedPassword = sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format("%.0f",this.getLevel() * this.mana));
        return sb.toString();
    }
}
