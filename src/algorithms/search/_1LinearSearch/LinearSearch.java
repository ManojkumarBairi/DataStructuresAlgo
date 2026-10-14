package algorithms.search._1LinearSearch;
public class LinearSearch {
    public static void main(String args[]){
        int x =10;
        int[] array = {1,2,3,4,5,6,7,8,9,10,12,14,145};
        int ret = linearSearch(x, array);
        System.out.println(ret);
    }

    public static int linearSearch(int x,int[] array) {
        for(int i=0;i<array.length;i++){
            if(array[i] == x){
                return i;
            }
        }
        return -1;
    }
}
