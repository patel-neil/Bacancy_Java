package Evaluation2;

public class Aeroplane implements Vehicle{
    public int vin;
    public String brand;
    public int height;
    public static int thresholdHeight = 10000;

    public Aeroplane(int vin, String brand, int height) {
        this.vin = vin;
        this.brand = brand;
        this.height = height;
    }


    @Override
    public void start()
    {
        System.out.println("Aeroplane started successfully");
    }

    @Override
    public void stop()
    {
        System.out.println("Aeroplane stopped successfully!");
    }


    public static void checkheight(int height) {
        if(height < thresholdHeight)
        {
            System.out.println("Safe height");
        }
        else {
            System.out.println("Danger!!");
        }
    }
}
