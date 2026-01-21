import java.util.Scanner;

public class Min_Max_Q2 {
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

        int max = Integer.MIN_VALUE;

        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }

            if(arr[i] < min)
            {
                min = arr[i];
            }
        }

        System.out.println("Maximum element in the array is: " + max);
        System.out.println("Minimum element in the array is: " + min);
    }
}
