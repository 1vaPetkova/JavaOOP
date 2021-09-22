package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.Bread;
import bakery.entities.bakedFoods.interfaces.Cake;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.drinks.interfaces.Tea;
import bakery.entities.drinks.interfaces.Water;
import bakery.entities.tables.interfaces.InsideTable;
import bakery.entities.tables.interfaces.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.util.List;
import java.util.stream.Collectors;

import static bakery.common.ExceptionMessages.*;
import static bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
    }


    @Override
    public String addFood(String type, String name, double price) {
        if (foodRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        BakedFood food = null;
        if (type.equals("Bread")) {
            food = new Bread(name, price);
        } else if (type.equals("Cake")) {
            food = new Cake(name, price);
        }
        this.foodRepository.add(food);
        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        if (drinkRepository.getByNameAndBrand(name, brand) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        Drink drink = null;
        if (type.equals("Tea")) {
            drink = new Tea(name, portion, brand);
        } else if (type.equals("Water")) {
            drink = new Water(name, portion, brand);
        }
        this.drinkRepository.add(drink);
        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        if (tableRepository.getByNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }
        Table table = null;
        if (type.equals("InsideTable")) {
            table = new InsideTable(tableNumber, capacity);
        } else if (type.equals("OutsideTable")) {
            table = new OutsideTable(tableNumber, capacity);
        }
        tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table tableToReserve = tableRepository.getAll().stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);
        if (tableToReserve != null) {
            tableToReserve.reserve(numberOfPeople);
            return String.format(TABLE_RESERVED, tableToReserve.getTableNumber(), numberOfPeople);
        }
        return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (table == null || !table.isReserved()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        BakedFood orderedFood = foodRepository.getByName(foodName);
        if (orderedFood == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }
        table.orderFood(orderedFood);
        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (table == null || !table.isReserved()) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        Drink drink = drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        if (drink == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }
        table.orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table table = tableRepository.getByNumber(tableNumber);
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        double bill = table.getBill();
        this.totalIncome += bill;
        table.clear();
        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        List<Table> freeTables = tableRepository.getAll().stream().filter(t -> !t.isReserved())
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        freeTables.forEach(t -> sb.append(t.getFreeTableInfo()).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(TOTAL_INCOME, this.totalIncome);
    }
}
