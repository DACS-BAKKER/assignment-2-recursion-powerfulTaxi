/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 9-19-19
 **************************************************************************** */
public class EveryVoteCounts {
    public static void main(String[] args) {
        int[] a = {4,2,7,4};
        System.out.println(CountCriticalVotes(a,1));
    }

    //returns number of cases where the block at the block Index is the critical vote
    private static int CountCriticalVotes(int [] blocks, int blockIndex){
        return CountCriticalVotesWrapper(modArray(blocks, blockIndex), 0, votesNeeded(blocks));
    }

    private static int CountCriticalVotesWrapper(int [] blocks, int blockIndex, int votesNeeded){
        if(sumOfArray(blocks) + blocks[blockIndex] > votesNeeded){
            int total = 0;
            for (int i =0; i < blocks.length-1 ; i ++){
                total += CountCriticalVotesWrapper(modArray(blocks, i), i, votesNeeded(blocks));
            }
            return 2 * total;
        }else if(sumOfArray(blocks) + blockIndex <= votesNeeded(blocks)){
            int total = 0;
            for (int i =0; i < blocks.length-1 ; i ++){
                total += CountCriticalVotesWrapper(modArray(blocks, i), i, votesNeeded(blocks));
            }
            return 2 * total;
        }else{
            return 2;
        }
    }


    //returns an array identical to a, but without the specified index. Length will be one smaller.
    private static int[] modArray(int [] a, int index){
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
