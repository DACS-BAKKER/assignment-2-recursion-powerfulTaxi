/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 9-19-19
 *
 *
 * This program will print out all the combinations in which the specified block
 * will be the critical vote.
 *
 *
 **************************************************************************** */
public class EveryVoteCounts {
    public static void main(String[] args) {
        //int[] a = {4,2,7,4};
        int [] a = {2,4};
        System.out.println("Total: " + CountCriticalVotes(a,1));
    }

    //returns number of cases where the block at the block Index is the critical vote
    private static int CountCriticalVotes(int [] blocks, int blockIndex){
        int [] a = modArray(blocks, blockIndex);
        return CountCriticalVotesWrapper(modArray(blocks, blockIndex), blocks[blockIndex], votesNeeded(blocks));
    }

    private static int CountCriticalVotesWrapper(int [] blocks, int blockVal, int votesNeeded){
        //base case
        if(sumOfArray(blocks) + blockVal < votesNeeded){
            //not neccessary to break up
            return 0;
        }
        //break it up if too big
        else if(sumOfArray(blocks) >= votesNeeded) {
            int total = 0;
            for (int i =0; i < blocks.length ; i ++) {
                total += CountCriticalVotesWrapper(modArray(blocks, i), blockVal, votesNeeded);
            }
            return total;
        } else if (sumOfArray(blocks) + blockVal >= votesNeeded && sumOfArray(blocks) < votesNeeded ){
            int total = 0;
            for (int i =0; i < blocks.length-1 ; i ++){
                total += CountCriticalVotesWrapper(modArray(blocks, i), blockVal, votesNeeded);
            }
            for(int i =0; i<blocks.length; i++){
                System.out.println(blocks[i]);
            }System.out.println("");
            return 1 + total;
        }
        return 0;
    }


    //returns an array identical to a, but without the specified index. Length will be one smaller.
    private static int[] modArray(int [] a, int index){
        if(a.length==1){
            return new int[0];
        }
        int[] modA = new int[a.length-1];
        for(int i = 0; i < modA.length; i++){
            if(i >= index)
                modA[i] = a[i+1];
            else{
                modA[i] = a[i];
            }
        }
        return modA;
    }


    //returns votes needed in order to win
    private static int votesNeeded(int [] a){
        return sumOfArray(a) / 2 + 1;
    }

    //returns sum of an array
    private static int sumOfArray(int [] a){
        int sum = 0;
        for(int i = 0; i< a.length; i++){
            sum += a[i];
        }
        return sum;
    }
}
