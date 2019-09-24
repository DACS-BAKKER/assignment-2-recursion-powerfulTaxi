/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 9-19-19
 **************************************************************************** */

public class humanPyramid {
    public static void main(String[] args) {
        System.out.println("This program finds the weight on the back of a person in a human pyramid.");
        while(true) {
            System.out.println("row?");
            int r = StdIn.readInt();
            System.out.println("col?");
            int c = StdIn.readInt();
            System.out.println("The weight on the back of person in row " + r + " col " + c + " is " + weightOnBackOfWithMem(r, c));
        }
    }

    private static double weightOnBackOfWithMem(int row, int col){
        return weightOnBackOfWithMemWrapper(row, col, new double[row + 1][col + 1]);
    }

    private static double weightOnBackOfWithMemWrapper(int row, int col, double weights[][]){
        final int bodyWeight = 200;
        if (row <= 0)
            return 0;
        else if (col == 0 && weights[row][col] == 0) {
            weights[row][col] =  0.5 * bodyWeight + 0.5 * weightOnBackOfWithMemWrapper(row - 1, col, weights);
        } else if (col == row && weights[row][col] == 0) {
            weights[row][col] = 0.5 * bodyWeight + 0.5 * weightOnBackOfWithMemWrapper(row - 1, col - 1, weights);
        } else if (weights[row][col] == 0) {
            return 0.5 * bodyWeight + 0.5 * weightOnBackOfWithMemWrapper(row - 1, col - 1, weights) + 0.5 * bodyWeight + 0.5 * weightOnBackOfWithMemWrapper(row - 1, col, weights);
        } return weights[row][col];
    }

    private static double weightOnBackOf(int row, int col){
        final int bodyWeight = 200;
        if (row <= 0)
            return 0;
        else if (col == 0) {
            return 0.5 * bodyWeight + 0.5 * weightOnBackOf(row - 1, col);
        } else if (row == col) {
            return 0.5 * bodyWeight + 0.5 * weightOnBackOf(row - 1, col - 1);
        } else {
            return 0.5 * bodyWeight + 0.5 * weightOnBackOf(row - 1, col - 1) + 0.5 * bodyWeight + 0.5 * weightOnBackOf(row - 1, col);
        }
    }
}
