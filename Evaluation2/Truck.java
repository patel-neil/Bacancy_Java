package Evaluation2;

public class Truck implements Vehicle{

    public int vin;
    public String brand;
    public int mileage;
    public static int thresholdMileage = 10000;

    public Truck(int vin, String brand, int mileage) {
        this.vin = vin;
        this.brand = brand;
        this.mileage = mileage;
    }

    @Override
    public void start()
    {
        System.out.println("Truck started successfully!");
    }

    @Override
    public void stop()
    {
        System.out.println("Truck stopped successfully!");
    }


    public static void checkmileage(int mileage)
    {

        System.out.print("Mileage should be less than: " + thresholdMileage);
        System.out.println();

        if(mileage <= thresholdMileage)
        {
            System.out.println("Truck is safe!!");
        }
        else{
            System.out.println("Warning. Not safe to start the truck.");
        }
    }

}
