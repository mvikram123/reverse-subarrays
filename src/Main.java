
class reverseSubarray{
    static int[] reverseSubarrays(int arr[],int n,int k)
    {
        for(int i=0; i<n; i+=k){

            int left=i;
            int right=Math.min(i+k-1,n-1);
            while(left<right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;

            }
        }
        return arr;
    }
}


public class Main {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        int n=arr.length;
        int k=3;
        reverseSubarray.reverseSubarrays(arr, n, k);
for(int i=0; i<n; i++) {
    System.out.print(arr[i]+" ");//Output: [3, 2, 1, 6, 5, 4, 8, 7]
}
    }
}



//another way
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    // Function to reverse a sub-array within the array
    private void reverseSubarray(ArrayList<Integer> arr, int start, int end) {
        while (start < end) {
            Collections.swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Function to reverse every sub-array group of size k.
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // Traverse through the array and reverse sub-arrays of size k
        for (int i = 0; i < n; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1); // Handle the last group with size less than k
            reverseSubarray(arr, left, right);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        int n = arr.size();
        int k = 3;

        Solution solution = new Solution();
        solution.reverseInGroups(arr, n, k);
        System.out.println(arr); // Output: [3, 2, 1, 6, 5, 4, 8, 7]
    }
}
