package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;


import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {
        if (components.isEmpty()) {
            return super.getOverallPerformance();
        }
        double componentsAverage = components.stream()
                .mapToDouble(Component::getOverallPerformance)
                .average()
                .orElse(0.00);
        return super.getOverallPerformance() + componentsAverage;
    }

    @Override
    public double getPrice() {
        double componentsPrice = components.stream()
                .mapToDouble(Component::getPrice)
                .sum();
        double peripheralsPrice = peripherals.stream()
                .mapToDouble(Peripheral::getPrice)
                .sum();
        return super.getPrice() + componentsPrice + peripheralsPrice;
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if (components.stream().anyMatch(c -> c.getClass().getSimpleName().equals(component.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(),
                    this.getClass().getSimpleName(), this.getId()));
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component componentToRemove = components
                .stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType))
                .findFirst().orElse(null);
        if (components.isEmpty() ||
                componentToRemove == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType,
                    this.getClass().getSimpleName(), this.getId()));
        }
        components.remove(componentToRemove);
        return componentToRemove;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.stream().anyMatch(c -> c.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(),
                    this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheralToRemove = peripherals
                .stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType))
                .findFirst().orElse(null);
        if (peripherals.isEmpty() || peripheralToRemove == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType,
                    this.getClass().getSimpleName(), this.getId()));
        }
        peripherals.remove(peripheralToRemove);
        return peripheralToRemove;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb
                .append(System.lineSeparator())
                .append(" ")
                .append(String.format(COMPUTER_COMPONENTS_TO_STRING, this.components.size()))
                .append(System.lineSeparator());
        for (Component component : components) {
            sb
                    .append("  ")
                    .append(component.toString())
                    .append(System.lineSeparator());
        }
        double avg = peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0.00);
        sb
                .append(" ")
                .append(String.format(COMPUTER_PERIPHERALS_TO_STRING, this.peripherals.size(), avg));
        sb.append(System.lineSeparator());
        for (Peripheral peripheral : peripherals) {
            sb
                    .append("  ")
                    .append(peripheral.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
