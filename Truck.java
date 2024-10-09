public class Truck extends Vehicle{
private int towing_capacity;
private int payload_capacity;
public Truck (String make, String model, int year, int number_of_doors, double
fuel_capacity, int range, int towing, int payload){
super(make, model, year, number_of_doors, fuel_capacity, range);
towing_capacity = towing;
payload_capacity = payload;
}
public int getTowingCapacity(){
return towing_capacity;
}
public int getPayloadCapacity(){
return payload_capacity;
}
public double calcMPG(int extra_load){
return (driving_range / fuel_tank_capacity) - ((driving_range * extra_load *
0.03) / (fuel_tank_capacity * 100));
}
}