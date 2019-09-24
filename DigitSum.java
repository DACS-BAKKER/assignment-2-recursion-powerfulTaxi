/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 9-19-19
 **************************************************************************** */

public class DigitSum {
    public static void main(String[] args) {
        System.out.println("This program returns the sum of digits.");
        while(true) {
            System.out.println("value?");
            int value = StdIn.readInt();
            System.out.println(sumOfDigits(value));
        }
    }

    //sum will be negative if n < 0
    private static int sumOfDigits(int n){
        if(n == 0){
            return n;
        }
        //rightmost + sum of the rest
        return (n % 10 + sumOfDigits(n / 10 ));
    }
}
