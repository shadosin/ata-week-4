package solution;

//Copy this into a StringLengthComparator class to run
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
    //no properties

    @Override
    public int compare(String o1, String o2) {

        if(o1.length() < o2.length()) {
            //less than -1
            return -1;
        }
        else if (o1.length() == o2.length()) {
            //if equal, then do alphabetic
            return o1.compareTo(o2);
        }
        else {
            //greater than 1
            return 1;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("This", "is", "an", "alphabetic", "test", "string"));
        StringLengthComparator strLenComp = new StringLengthComparator();

        Collections.sort(wordList,strLenComp);

        System.out.println(wordList);
    }


}
