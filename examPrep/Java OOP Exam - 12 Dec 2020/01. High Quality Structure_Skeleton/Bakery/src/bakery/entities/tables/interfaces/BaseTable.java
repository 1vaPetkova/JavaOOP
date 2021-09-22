package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        this.setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        isReserved = false;
    }

    private void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.tableNumber;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        this.isReserved = true;
        this.setNumberOfPeople(numberOfPeople);
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double sumFood = this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum();
        double sumBeverages = this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum();
        this.price = this.numberOfPeople * this.pricePerPerson + sumFood + sumBeverages;
        return this.price;
    }

    @Override
    public void clear() {
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.isReserved = false;
        this.numberOfPeople = 0;
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Table: ")
                .append(this.tableNumber)
                .append(System.lineSeparator())
                .append("Type: ")
                .append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Capacity: ")
                .append(this.capacity)
                .append(System.lineSeparator())
                .append("Price per Person: ")
                .append(String.format("%.2f", this.pricePerPerson));
        return sb.toString();
    }
}
