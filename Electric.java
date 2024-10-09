public class Electric extends Vehicle{

private int battery_capacity;
private int battery_charge_time;

public Electric (String make, String model, int year, int number_of_doors, int
range, int capacity, int charge_time){
super(make, model, year, number_of_doors, range);
battery_capacity = capacity;
battery_charge_time = charge_time;
}

public int getBatteryCapacity(){
return battery_capacity;
}

public int getBatteryChargeTime(){
return battery_charge_time;
}

public double calcMPG(int extra_load){
return (driving_range / fuel_tank_capacity) - ((driving_range * extra_load *
0.01) / (fuel_tank_capacity * 100));
}

}