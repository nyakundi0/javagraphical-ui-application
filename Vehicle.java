public class Vehicle implements Traits{
private String make;
private String model;
private int year;
private int number_of_doors;
protected double fuel_tank_capacity;
protected int driving_range;
public Vehicle(String vehicle_make, String vehicle_model, int vehicle_year,
               int vehicle_number_of_doors, double fuel_capacity, 
               int range) {

make = vehicle_make;
model = vehicle_model;
year = vehicle_year;
number_of_doors = vehicle_number_of_doors;
fuel_tank_capacity = fuel_capacity;
driving_range = range;
}


//get methods
public String getMake(){
return make;
}
public String getModel(){
return model;
}
public int getYear(){
return year;
}
public int getNumberOfDoors(){
return number_of_doors;
}
public double getFuelCapacity (){
return fuel_tank_capacity;
}

public int getRange (){
return driving_range;
}
public double calcMPG(){
return driving_range / fuel_tank_capacity;
}
public double calcMPG(int extra_load){
return (driving_range / fuel_tank_capacity) - ((driving_range * extra_load *
0.02) / (fuel_tank_capacity * 100));
}
}