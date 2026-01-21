import java.util.Scanner;

public class Even_Odd_Q3 {
    public static void main(String[] args) {

        System.out.println("Enter the length of the array: ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine(); // Consume the newline character


        int[] arr = new int[n];

        System.out.println("Enter elements of the array: ");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }

        int even = 0;
        int odd = 0;
        for(int i=0; i<n; i++)
        {
            if(arr[i] % 2 == 0)
            {
                even++;
            }
            else{
                odd++;
            }
        }

        System.out.println("Number of even elements in the array is: " + even);
        System.out.println("Number of odd elements in the array is: " + odd);
    }
}
