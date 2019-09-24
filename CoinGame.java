/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 9-19-19
 **************************************************************************** */

public class CoinGame {
    public static void main(String[] args) {
        System.out.println("This program returns the number of winnable strategies for the Coin Game.");
        while(true){
            System.out.println("Number of coins?");
            int c = StdIn.readInt();
            System.out.println("Number of winning strategies is " + play(c, true) + ".");
            if(winner(c,true)){
                System.out.println("The first to pick will win.");
            } else {
                System.out.println("The second to pick will win.");
            }
            System.out.println("");
        }
    }

    //returns winner of the game (true means picker 1 won)
    public static boolean winner(int coinCount, boolean picker1){
        if(coinCount % 3 ==0){
            return false;
        }
        else return true;
    }

    //returns number of winnalbe strategies
    public static int play(int coinCount, boolean picker1){
        if(coinCount<0){
            return 0;
        } else {
            if (coinCount == 0)
                return 1;
            else {
                if ((coinCount - 1) % 3 == 0) {
                    //both of these result in a multiple of 3
                    return play(coinCount - 1, !picker1) + play(coinCount - 4, !picker1);
                } else if ((coinCount - 2) % 3 == 0) {
                    return play(coinCount - 2, !picker1);
                } else {
                    // All other cases
                    return play(coinCount - 1, !picker1) + play(coinCount - 2, !picker1) + play(coinCount - 4, !picker1);
                }
            }
        }
    }
}
