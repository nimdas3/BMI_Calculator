/**
 * Final Project
 * UnitTests
 * CS 108-4
 * 5/14/2020
 * @author Nimi Das
 * Tests user's Body Mass Index (BMI) and its population percentile estimation
 */
import java.util.Scanner;

public class UnitTests {

    static User user1;


    public static void main(String[] args) {
         int feet;
         int inches;

        Scanner height = new Scanner(System.in);
        System.out.println("Enter height in feet space inches");
        feet = height.nextInt();
        inches = height.nextInt();
        Scanner weight = new Scanner(System.in);
        System.out.println("Enter weight in lbs");
        int lbs;
        lbs = weight.nextInt();
        printDataTest();
        user1 = new User(feet, inches, lbs); // made sure the same information is added to each test without asking for input multiple times
        calcBMItest();
        user1 = new User(feet, inches, lbs);
        addTest();
        user1 = new User(feet, inches, lbs);
        sortTest();
        user1 = new User(feet, inches, lbs);
        binarySearchTest();
        user1 = new User(feet, inches, lbs);
        percentileTest();


    }

    public static void calcBMItest() {
        //the input is converted to metric units then plugged into the formula kg/m^2
        if(user1.calcBMI() == (user1.weightLb * 0.454) / (((user1.heightIn + user1.heightFt*12)*.0254)*((user1.heightIn + user1.heightFt*12)*.0254))) {
            System.out.println("SUCCESS in calculating BMI");
        }
        else {
            System.out.println("FAILURE in calculating BMI");
        }
        System.out.print("BMI: ");
        System.out.printf("%.2f", user1.calcBMI()); //rounds the double to 2 decimal places
        System.out.println(" ");
    }

    public static void addTest() {
        BmiList someList = new BmiList();
        boolean check = someList.add(user1); // add method from bmiList is boolean type
        if(check) {
            System.out.println("SUCCESS to add BmiList");
        }
        else {
            System.out.println("Already added to BmiList");
        }
    }

    public static void sortTest() {
        BmiList someList = new BmiList();
        someList.add(user1);
        someList.sortIt();
        double smallval = (double) someList.myList.get(0);
        for(int i = 1; i < someList.size; i++) {
            if(smallval > (double) someList.myList.get(i)) {
                smallval = (double) someList.myList.get(i);
            }
        }
        if(smallval == (double) someList.myList.get(0)){ // makes sure the smallest value is in the front of the sorted stack
            System.out.println("SUCCESS Sort");
        }
        else {
            System.out.println("FAILED Sort");
        }

    }
    public static void binarySearchTest() {
        BmiList someList = new BmiList();
        someList.add(user1);
        someList.sortIt();
        int actualval = someList.binarySearch(someList.myList, user1.calcBMI(), someList.myList.size() - 1, 0); // recursive binary test w high and low values changing
        double val = user1.calcBMI();
        int index = 0;
        for(int i = 1; i < someList.size; i++) {
            if(val == (double) someList.myList.get(i)) { //sequential search
                index = i;
            }
        }
        if(index == actualval){ // compares output of sequential search w binary
            System.out.println("SUCCESS Binary Search");
        }
        else {
            System.out.println("FAILED Binary Search");
        }
    }

    public static void percentileTest() {
        PercentileCalculator calc = new PercentileCalculator(user1);
        calc.percentile(user1);
        BmiList someList = new BmiList();
        someList.add(user1);
        someList.sortIt();
        //the index of the binary search is used to calculate the percentile, index*100/sample size
        if(calc.percentile(user1) !=  (someList.binarySearch(someList.myList, user1.calcBMI(), someList.myList.size() - 1, 0))*100/someList.myList.size()) {
            System.out.println("FAILED to calculate percentile");
        }
        else {
            System.out.println("SUCCESS to calculate percentile");
        }
        System.out.println( "BMI percentile estimated: "+ calc.percentile(user1) + "%");

    }

    public static void printDataTest() {
        BmiList someList = new BmiList();
        someList.printData();
        System.out.println("SUCCESS in printing sample data");
    }



}
