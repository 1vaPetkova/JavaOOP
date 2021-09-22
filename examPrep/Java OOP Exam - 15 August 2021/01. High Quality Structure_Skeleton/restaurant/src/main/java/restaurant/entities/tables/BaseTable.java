package restaurant.entities.tables;

import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        isReservedTable = false;
    }

    public void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.allPeople;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReservedTable = true;
        this.setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double sumFood = this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double sumBeverages = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();
        this.allPeople = this.numberOfPeople * this.pricePerPerson + sumFood + sumBeverages;
        return this.allPeople;
    }

    @Override
    public void clear() {
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.isReservedTable = false;
        this.numberOfPeople = 0;
        this.allPeople = 0;
    }

    @Override
    public String tableInformation() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Table - ")
                .append(this.number)
                .append(System.lineSeparator())
                .append("Size - ")
                .append(this.size)
                .append(System.lineSeparator())
                .append("Type - ")
                .append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("All price - ")
                .append(String.format("%.2f", this.pricePerPerson))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
