package T04InterfacesAndAbstraction.archive.P10MooD3;

public abstract class GameObject implements Functionalities {
    private String username;
    protected String hashedPassword;
    private int level;

    public GameObject(String username, int level) {
        this.username = username;
        this.level = level;
        setHashedPassword();
    }

    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s", this.username, this.hashedPassword, this.getClass().getSimpleName());
    }
}
