//Demo of algorithm to set a diagonal in a 2D array
//Copy into MultiArrayDemo.java to run


public class MultiArrayDemo {

    public static void main(String[] args) {
        int[][] multiArray = new int[5][5];
        int SIZE = 5;

        //fill with zeros
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE ; j++) {
                multiArray[i][j] = 0;
            }
        }

        //Option #1 - how many steps?    25 = 5 x 5 or n x n steps
        for (int i = 0; i < SIZE ; i++) {
            for (int j = 0; j < SIZE ; j++) {
                if(i==j){
                    multiArray[i][j]=1;
                }
            }
        }

        //Option #2 =  5 steps (or n)
        int j=0;
        for (int i = 0; i < SIZE; i++) {
            multiArray[i][j] = 2;
            j++;
        }

        //Option #3 = 5/2
        // even though you are doing less iterations, you are still "touching" each index so complexity is still O(n)
        j=0;
        for (int i = 0; i < SIZE/2; i++) {
            multiArray[i][j] = 3;
            int tempi = SIZE-1-i;
            int tempj = SIZE-1-j;
            multiArray[tempi][tempj] = 3;
            j++;
        }




        System.out.println(multiArray);

    }
}
