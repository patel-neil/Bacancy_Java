package Evaluation2;

import java.util.Scanner;

public class mainDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the id of the vehicle: ");
        int n = sc.nextInt();
        System.out.println();
        System.out.print("Enter the brand: ");
        String s = sc.next();
        System.out.println();
        System.out.print("Enter the mileage: ");
        int m = sc.nextInt();
        System.out.println();

        Vehicle truck = new Truck(n,s,m);

        truck.start();

        Truck.checkmileage(m);

        Landskill landskill = () -> {
            System.out.println("Coordinates are: ");
            System.out.println("Latitude: 1234567");
            System.out.println("Longitude: 7654321");
        };

        landskill.gps();

        System.out.print("Enter the id of the aeroplane: ");
        int r = sc.nextInt();
        System.out.println();
        System.out.print("Enter the brand: ");
        String t = sc.next();
        System.out.println();
        System.out.print("Enter the Height: ");
        int h = sc.nextInt();
        System.out.println();

        Vehicle aeroplane = new Aeroplane(r,t,h);

        aeroplane.start();

        Aeroplane.checkheight(m);

        aeroplane.stop();

        Airskill airskill = () -> {
            System.out.println("This is altimeter function");
        };

        airskill.altimeter();
    }
}
