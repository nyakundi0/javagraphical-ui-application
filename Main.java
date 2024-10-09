class Main {
public static void main(String[] args) {
Vehicle car = new Vehicle("Ford","Mustang",2023,2,15,390);
Truck truck = new Truck("Ford","F150",2023,4,20,500,8350,2764);
System.out.println("Make: " + car.getMake());
System.out.println("Model: " + car.getModel());
System.out.println("Year: " + car.getYear());
System.out.println("Number of Doors: " + car.getNumberOfDoors());
System.out.println("Fuel Tank Capacity: " + car.getFuelCapacity());
System.out.println("Driving Range: " + car.getRange());
System.out.println("MPG (without extra load): " + car.calcMPG());
System.out.println("MPG (with extra load): " + car.calcMPG(100));
System.out.println("\n");
System.out.println("Make: " + truck.getMake());
System.out.println("Model: " + truck.getModel());
System.out.println("Year: " + truck.getYear());
System.out.println("Number of Doors: " + truck.getNumberOfDoors());
System.out.println("Fuel Tank Capacity: " + truck.getFuelCapacity());
System.out.println("Driving Range: " + truck.getRange());
System.out.println("Towing Capacity: " + truck.getTowingCapacity());
System.out.println("Payload Capacity: " + truck.getPayloadCapacity());
System.out.println("MPG (without extra load): " + truck.calcMPG());
System.out.println("MPG (with extra load): " + truck.calcMPG(100));

System.out.println("\n");
}
}