//Question 4: Sum & Average

import java.util.Scanner;

public class Sum_Average_Q4 {

    public static class Students
    {
        public int marks;

        public Students(int marks)
        {
            this.marks = marks;
        }
    }

    public static void main(String[] args) {

        System.out.println("Enter the number of students: ");
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine();// Consume the newline character

        Students[] students = new Students[n];

        System.out.println("Enter marks of the students: ");

        for(int i=0; i<n; i++)
        {
            int marks = sc.nextInt();
            students[i] = new Students(marks);
        }

        int sum = 0;
        System.out.print("Sum of marks of the students is: ");

        for(int i=0; i<n; i++)
        {
            sum += students[i].marks;
        }
        System.out.println(sum);

        System.out.print("Average marks of the students is: ");

        float average = (float)sum / n;
        System.out.println(average);
    }
}
