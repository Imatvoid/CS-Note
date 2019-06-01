package summary.sort;

public class QuickSort {

    /**
     * 递归版本
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSortNoRecursion(int[] arr, int start, int end) {

    }


    /**
     * 递归版本
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);
    }

    /**
     * 单边循环法
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] arr, int start, int end) {

        int mark = start;
        int pivot = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < pivot) {
                mark++;
                int temp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = temp;
            }
        }

        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 7, 5, 6, 2, 8, 1};
        quickSort(arr, 0, 7);
        System.out.println();
    }
}
