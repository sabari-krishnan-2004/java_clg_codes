public class mergedSort {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * @param arr
     * @param si
     * @param mid
     * @param ei
     */
    public static void conqour(int arr[],int si,int mid,int ei){
        int merged[]=new int[ei-si+1];

        int indx1 = si;
        int indx2 = mid+1;
        int x = 0;

        while(indx1<=mid && indx2<=ei){
            if(arr[indx1]<=arr[indx2]){
                merged[x]=arr[indx1];
                x++;indx1++;
            }
            else{
                merged[x]=arr[indx2];
                indx2++;x++;
            }
        }
        while(indx1<=mid){
            merged[x]=arr[indx1];
            x++;indx1++;

        }
        while(indx2<=ei){
            merged[x]=arr[indx2];
            indx2++;x++;
        }
        for(int i=0 ,j=si;i<merged.length;i++,j++){
            arr[j]=merged[i];
        }
   
    }

    public static void divide(int arr[], int si, int ei) {
        if(si>=ei){
            return; 
        }
        int mid = (si + ei) / 2;
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conqour(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int arr[] = { 4, 6, 7, 8, 5, 2 };
        int n = arr.length;
        divide(arr,0,n-1);
        printArray(arr);
    }
}
