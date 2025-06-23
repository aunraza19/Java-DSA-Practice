import java.util.Arrays;

public class sorting {
    static void BubbleSort(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <arr.length-i ; j++) {
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
    }
    static void SelectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last=arr.length-i-1;
           int maxindex= Maximum(arr,0,last);
            swap(arr,maxindex,last);
        }

    }
    static void InsertionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
    static void CyclicSort(int[]arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if (arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }
            else {
                i++;
            }
        }
    }
    static void swap(int[] arr,int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    static int Maximum(int[]arr, int start, int end){
        int max=start;
        for (int i = start; i <=end; i++) {
            if (arr[max]<arr[i]){
                max=i;
            }


        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr={3,2,1,4};
      CyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
