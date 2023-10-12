package demo111.demo20;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        Truck truck = new Truck();
        for (int i = 0; i < num; i++) {
            int type = scanner.nextInt();
            double weight = scanner.nextDouble();

            switch (type) {
                case 1:
                    truck.addAppliance(new TV(weight));
                    break;
                case 2:
                    truck.addAppliance(new WashMachine(weight));
                    break;
                case 3:
                    truck.addAppliance(new AirConditioner(weight));
                    break;
                default:
                    break;
            }
        }

        double totalWeight = truck.getTotalWeight();
        System.out.println((int) totalWeight);
    }
}

class Truck {
    private List<Appliance> appliances;

    public Truck() {
        appliances = new ArrayList<>();
    }

    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Appliance appliance : appliances) {
            totalWeight += appliance.getWeight();
        }
        return totalWeight;
    }
}

interface Appliance{
    double getWeight();
}

class TV implements Appliance{
    private double weight;

    public TV() {
    }

    public TV(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

class WashMachine implements Appliance{

    private double weight;

    public WashMachine() {
    }

    public WashMachine(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

class AirConditioner implements Appliance{

    private double weight;

    public AirConditioner() {
    }

    public AirConditioner(double weight) {
        this.weight = weight;
    }


    @Override
    public double getWeight() {
        return weight;
    }
}

