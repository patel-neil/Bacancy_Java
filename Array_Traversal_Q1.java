//Question 1: Array Traversal

import java.util.Scanner;

class traversal 
{
    public static void main(String args[])
    {
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

        System.out.println("The array is:");

        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}