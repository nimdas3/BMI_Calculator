/**
 * Final Project
 * BMI List
 * CS 108-4
 * 5/14/2020
 * @author Nimi Das
 * Contains sample data used to calculate user's bmi percentile
 */
import java.util.Stack;

public class BmiList<E> extends MyAbstractList<E> {
    Stack<Double> myList = new Stack<>();
    int searchIndex;

    public BmiList() {
        // Just 5 sample data used to estimate bmi percentile
        myList.add(0, new User(5,11,160).calcBMI()); // normal
        myList.add(1, new User(5,7,110).calcBMI()); //underweight
        myList.add(2, new User(6,3,220).calcBMI()); // overweight
        myList.add(3, new User(5,3,190).calcBMI()); // obese
        myList.add(4, new User(4,11,150).calcBMI()); //obese
        size = 5;
    }

    public void printData() { //iteration - prints out the sample data
        System.out.println("");
        System.out.println("The calculation of BMI Percentile is based on below data:-");
        System.out.println("=========================");
        System.out.println("Sr. NO |  BMI    ");
        int i = 1;
        for (double num : myList) {
            System.out.print("  "+i+ "    |  ");
            System.out.printf("%.2f",num);
            System.out.println("");
            i++;
        }
        System.out.println("=========================");
    }

    @Override
    public boolean add(E data) {
        if(myList.contains((User) data)) { //avoids adding the user data twice
            return false;
        }
        else {
            User newUser = new User((User) data);
            myList.add(newUser.calcBMI());
            size++;
            return true;
        }

    }


    public void sortIt() { //used insertion sort
        double key;
        int j;
        for(int i = 1; i < myList.size(); ++i) {
                key = myList.get(i);
                j = i - 1;
                while (j >= 0 && myList.get(j) > key)
                {
                    myList.set(j + 1,myList.get(j));
                    j = j - 1;
                }
                myList.set(j + 1, key);
            }
        }

        public int binarySearch(Stack<Double> sortedList, double key, int high, int low) {
            int mid = (high + low) / 2; //the mid value gets closer to the index holding the key after every recursion
            int finalval = -1;

                if(sortedList.get(mid) == key){
                finalval = mid;
                return finalval;
                }
                else if (sortedList.get(mid) < key) {
                    low = mid + 1;
                   finalval =  binarySearch(sortedList, key, high, low);
                }
                else if (sortedList.get(mid) > key) {
                    high = mid - 1;
                    finalval = binarySearch(sortedList, key, high, low);
                }

                return finalval;

    }

}
