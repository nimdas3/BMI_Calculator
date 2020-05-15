/**
 * Final Project
 * Percentile Calculator
 * CS 108-4
 * 5/14/2020
 * @author Nimi Das
 * Estimates user's Body Mass Index (BMI)  percentile from sample data
 */

public class PercentileCalculator extends BmiList {
    int percentile;
    public PercentileCalculator() {
        int percentile = 0;
    }

    BmiList newList = new BmiList();

    public PercentileCalculator(User var){
        newList.add(var);
    }

    public int percentile(User var) {
        Double bmi = var.calcBMI();
        newList.sortIt();
        int value = newList.binarySearch(newList.myList, bmi, size, 0); // gets the bmi ranking in the sample
        int percent = (value)*100/newList.myList.size();
        return percent;
    }

}
