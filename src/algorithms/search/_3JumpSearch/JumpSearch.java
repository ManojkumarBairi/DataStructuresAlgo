package algorithms.search._3JumpSearch;

public class JumpSearch {
    public static void main(String args[]){
        int x =9;
        int[] array  = {1,3,4,5,8,9,10,12,15,16,18};
        int ret = jumpSearch(x,array);
        System.out.println(ret);
    }

    public static int jumpSearch(int x, int[] array){
        int length = array.length;
        int blockSize = (int)Math.sqrt(length);
        int limit = blockSize;

        while(limit < length && x > array[limit]){
            limit +=blockSize;
        }
        for(int i =limit-blockSize; i <=limit && i <length; i++){
            if(array[i] == x){
                return i;
            }
        }
        return -1;
}
}
