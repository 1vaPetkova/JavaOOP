package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;
    private Map<Integer, Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new LinkedHashMap<>();
        this.components = new LinkedHashMap<>();
        this.peripherals = new LinkedHashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        checkIfAlreadyInMap(id);
        Computer computer;
        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        computers.put(id, computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        checkIfComputerNotPresent(computerId);
        if (peripherals.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
        Peripheral peripheral = null;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        peripherals.put(id, peripheral);
        computers.get(computerId).addPeripheral(peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        checkIfComputerNotPresent(computerId);
        Peripheral peripheralToRemove = peripherals.values()
                .stream()
                .filter(c -> c.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .orElse(null);
        computers.get(computerId).removePeripheral(peripheralType);
        if (peripheralToRemove != null) {
            components.remove(peripheralToRemove.getId());
            return String.format(REMOVED_PERIPHERAL, peripheralType, peripheralToRemove.getId());
        }
        return null;
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        checkIfComputerNotPresent(computerId);
        if (components.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
        Component component = null;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }
        components.put(id, component);
        computers.get(computerId).addComponent(component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        checkIfComputerNotPresent(computerId);
        Component componentToRemove = components.values()
                .stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .orElse(null);
        computers.get(computerId).removeComponent(componentType);
        if (componentToRemove != null) {
            components.remove(componentToRemove.getId());
            return String.format(REMOVED_COMPONENT, componentType, componentToRemove.getId());
        }
        return null;
    }

    @Override
    public String buyComputer(int id) {
        checkIfComputerNotPresent(id);
        Computer removed = computers.get(id);
        computers.remove(id);
        return removed.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computerToBuy = computers.values().stream().sorted(Comparator.comparing(Computer::getOverallPerformance).reversed()
                        .thenComparing(Comparator.comparing(Computer::getPrice)))
                .filter(c -> c.getPrice() <= budget).findFirst().orElse(null);
        if (computerToBuy == null) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        this.computers.remove(computerToBuy.getId());
        return computerToBuy.toString();
    }

    @Override
    public String getComputerData(int id) {
        checkIfComputerNotPresent(id);
        Computer computer = this.computers.get(id);
        return computer.toString();
    }


    private void checkIfAlreadyInMap(int id) {
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
    }

    private void checkIfComputerNotPresent(int id) {
        if (!computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }

}
