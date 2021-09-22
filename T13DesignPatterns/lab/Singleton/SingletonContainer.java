package T13DesignPatterns.lab.Singleton;

public interface SingletonContainer {

    int getPopulation( String name);
    void addPopulation( String capital,int amount);
    void subtractPopulation( String capital,int amount);
}


