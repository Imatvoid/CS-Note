package leetcode.sort;

public class KthLargestElementInAnArray {


    public int findKthLargest(int[] nums, int k) {


        int start = 0;
        int end = nums.length - 1;
        // 此步可以省略
        // k = nums.length - (k - 1);
        while (true) {
            int pivotIndex = partition(nums, start, end);

            if (pivotIndex == k - 1) {
                return nums[k - 1];
            }

            if (pivotIndex < k - 1) {
                start = pivotIndex + 1;
            } else {
                end = pivotIndex - 1;
            }
        }


    }

    /**
     * 单指针法
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int mark = start;
        // 这里的start+1 和<=要小心
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] > pivot) {
                // if (arr[i] < pivot) {
                mark++;
                int tmp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = tmp;
            }
        }

        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;


    }


    public static void main(String[] args) {
        new KthLargestElementInAnArray().partition(new int[]{3, 2, 1, 5, 6, 4}, 0, 5);

        int res = new KthLargestElementInAnArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 4);
        System.out.println(res);
    }


}
