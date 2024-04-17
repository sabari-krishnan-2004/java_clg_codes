public class Quicksort {
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void quicksort(int arr[],int low, int high){
        if(low<high){
            int pividx=partition(arr,low,high);
            quicksort(arr,low,pividx-1);
            quicksort(arr,pividx+1,high);
        }
        
      
    }
    public static int partition(int arr[],int low , int high){
        int i = low-1;
        int pivot = arr[high];
        for (int j =low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
            i++;
            int temp = arr[i];
            arr[i]=pivot;
            arr[high]=temp;
            return i;

        
    }
    public static void main(String[] args) {
        int arr[] = {3,4,6,2,5,9};
        int n = arr.length;
        partition(arr, 0, n-1);
        printArray(arr);
    }
}
