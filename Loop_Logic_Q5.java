import java.util.Scanner;

public class Loop_Logic_Q5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of terms:");

        int n = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter the number for divisibility: ");

        int divisor = sc.nextInt();

        System.out.println("Terms which are not divisible by " + divisor + " are: ");
        for(int i=1; i<=n; i++)
        {
            if(i % divisor ==0)
            {
                continue;
            }
            System.out.println(i);
        }
    }    
}
