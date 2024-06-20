import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        // Input: Take marks obtained (out of 100) in each subject.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of Subjects : ");

        int subj = scan.nextInt();
        int[] marks = new int[subj];
        int totalMarks = 0;

        for(int i = 0; i < subj; i++){
            System.out.println("Enter marks for subject : " + (i + 1) + ":");
            marks[i] = scan.nextInt();
            totalMarks += marks[i];
        }

        // Calculate Average Percentage: Divide the total marks by the total number of
        // subjects to get the average percentage.
        double avrgPerc = (double) totalMarks / (subj * 100) * 100;

        // Display Results: Show the total marks, average percentage, and the
        // corresponding grade to the user
        System.out.println("Result : ");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage:" + avrgPerc + "%");

        String grade = gradeCal(avrgPerc);
        System.out.println("Corresponding Grade: " + grade);
        scan.close();
    }

    // Grade Calculation: Assign grades based on the average percentage achieved.
    public static String gradeCal (double avrgPerc){
        if (avrgPerc >= 90) {
            return "A";
        } else if (avrgPerc >= 80) {
            return "B";
        } else if (avrgPerc >= 70) {
            return "C";
        } else if (avrgPerc >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
