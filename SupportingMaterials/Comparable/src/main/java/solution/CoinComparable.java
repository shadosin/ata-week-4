package solution;

//copy this code into a CoinComparable.java class to run
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CoinComparable implements Comparable<CoinComparable> {
    private String name;
    private int value;
    private int year;

    //constructor
    public CoinComparable(String name, int value, int year) {
        this.name = name;
        this.value = value;
        this.year = year;
    }

    //methods
    @Override
    public String toString() {
        return "CoinComparable{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(CoinComparable o) {

        // this is an alternative that will work for value comparisons
        // the shortcut is less readable. Also does not have place for the additional year sort
        //return this.value - o.value

        if(this.value < o.value ) {
            //less than -1
            return -1;
        }
        else if(this.value == o.value){
            //now check the date
            if(this.year < o.year){
                return -1;
            }
            else if (this.year == o.year){
                return 0;
            }
            else {
                return 1;
            }
        }
        else {
            //more than 1
            return 1;
        }
    }


    //main method for testing
    public static void main(String[] args) {
        //initialize three coins - nickel, quarter, penny
        CoinComparable nickle = new CoinComparable("nickle", 5,2000 );
        CoinComparable quarter = new CoinComparable("quarter", 25, 1996);
        CoinComparable penny = new CoinComparable("penny", 1, 2022);
        CoinComparable oldPenny = new CoinComparable("wheat penny", 1, 1950);
        CoinComparable olderPenny = new CoinComparable("wheat penny", 1, 1901);

        List<CoinComparable> coinCollection = new ArrayList<>(Arrays.asList(oldPenny, nickle, quarter, penny, olderPenny));

        Collections.sort(coinCollection);

        System.out.println(coinCollection);

    }


}