package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.Fresh;
import restaurant.entities.drinks.Smoothie;
import restaurant.entities.healthyFoods.Salad;
import restaurant.entities.healthyFoods.VeganBiscuits;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.tables.InGarden;
import restaurant.entities.tables.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalMoney;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository,
                          BeverageRepository<Beverages> beverageRepository,
                          TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food;
        if (type.equals("Salad")) {
            food = new Salad(name, price);
            return addFoodToRepository(name, food);
        } else if (type.equals("VeganBiscuits")) {
            food = new VeganBiscuits(name, price);
            return addFoodToRepository(name, food);
        }
        return null;
    }

    private String addFoodToRepository(String name, HealthyFood food) {
        if (healthFoodRepository.foodByName(name) == null) {
            healthFoodRepository.add(food);
            return String.format(FOOD_ADDED, name);
        } else {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage;
        if (type.equals("Smoothie")) {
            beverage = new Smoothie(name, counter, brand);
            return addDrinkToRepository(name, beverage);
        } else if (type.equals("Fresh")) {
            beverage = new Fresh(name, counter, brand);
            return addDrinkToRepository(name, beverage);
        }
        return null;
    }

    private String addDrinkToRepository(String name, Beverages beverage) {
        if (beverageRepository.beverageByName(name, beverage.getBrand()) == null) {
            beverageRepository.add(beverage);
            return String.format(BEVERAGE_ADDED, beverage.getClass().getSimpleName(), beverage.getBrand());
        } else {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table;
        if (type.equals("Indoors")) {
            table = new Indoors(tableNumber, capacity);
            return addTableToRepository(tableNumber, table);
        } else if (type.equals("InGarden")) {
            table = new InGarden(tableNumber, capacity);
            return addTableToRepository(tableNumber, table);
        }
        return null;
    }

    private String addTableToRepository(int tableNumber, Table table) {
        if (tableRepository.byNumber(tableNumber) == null) {
            tableRepository.add(table);
            return String.format(TABLE_ADDED, tableNumber);
        } else {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, tableNumber));
        }
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table tableToReserve = tableRepository.getAllEntities().stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst().orElse(null);
        if (tableToReserve != null) {
            tableToReserve.reserve(numberOfPeople);
            return String.format(TABLE_RESERVED, tableToReserve.getTableNumber(), numberOfPeople);
        } else {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        if (tableRepository.byNumber(tableNumber) == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        } else {
            if (healthFoodRepository.foodByName(healthyFoodName) == null) {
                return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
            } else {
                Table table = tableRepository.byNumber(tableNumber);
                table.orderHealthy(healthFoodRepository.foodByName(healthyFoodName));
                return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
            }
        }
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        if (tableRepository.byNumber(tableNumber) == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        } else {
            if (beverageRepository.beverageByName(name, brand) == null) {
                return String.format(NON_EXISTENT_DRINK, name, brand);
            } else {
                Table table = tableRepository.byNumber(tableNumber);
                table.orderBeverages(beverageRepository.beverageByName(name, brand));
                return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
            }
        }
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    @Override
    public String closedBill(int tableNumber) {
        double bill = tableRepository.byNumber(tableNumber).bill();
        this.totalMoney += bill;
        tableRepository.byNumber(tableNumber).clear();
        return String.format(BILL, tableNumber, bill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, getTotalMoney());
    }
}
