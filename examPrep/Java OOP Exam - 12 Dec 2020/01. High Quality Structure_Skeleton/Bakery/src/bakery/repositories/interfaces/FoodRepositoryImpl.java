package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private Collection<BakedFood> bakedFoods;

    public FoodRepositoryImpl() {
        this.bakedFoods = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        return bakedFoods.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Collection<BakedFood> getAll() {
        return Collections.unmodifiableCollection(bakedFoods);
    }

    @Override
    public void add(BakedFood bakedFood) {
        this.bakedFoods.add(bakedFood);
    }
}
