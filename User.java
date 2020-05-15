/**
 * Final Project
 * User
 * CS 108-4
 * 5/14/2020
 * @author Nimi Das
 * Store's user's height and weight to calculate the Body Mass Index
 */
public class User {
    protected int heightFt;
    protected int heightIn;
    public int weightLb;
    protected double bmi;


    public User(int feet, int inches, int pounds) {
        heightFt = feet;
        heightIn = inches;
        this.weightLb = pounds;
    }
    public User(User data) {
        heightFt = data.heightFt;
        heightIn = data.heightIn;
        this.weightLb = data.weightLb;
    }


    public double calcBMI() {
        //the input is converted to metric units then plugged into the formula kg/m^2
        bmi = (weightLb * 0.454) / (((heightIn + heightFt*12)*.0254)*((heightIn + heightFt*12)*.0254));
        return bmi;
    }

}
