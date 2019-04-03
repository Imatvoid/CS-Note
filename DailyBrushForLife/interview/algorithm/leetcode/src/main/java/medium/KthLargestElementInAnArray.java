package medium;

public class KthLargestElementInAnArray {


    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) return nums[pos];
            else if (pos > k - 1) right = pos - 1;
            else left = pos + 1;
        }


    }

    int partition2(int[] s, int l, int r) {
        int i = l, j = r;
        int x = s[l]; //s[l]即s[i]就是第一个坑
        while (i < j)
        {
            // 从右向左找小于x的数来填s[i]
            while(i < j && s[j] <= x)
                j--;
            if(i < j)
            {
                s[i] = s[j]; //将s[j]填到s[i]中，s[j]就形成了一个新的坑
                i++;
            }

            // 从左向右找大于或等于x的数来填s[j]
            while(i < j && s[i] > x)
                i++;
            if(i < j)
            {
                s[j] = s[i]; //将s[i]填到s[j]中，s[i]就形成了一个新的坑
                j--;
            }
        }
        //退出时，i等于j。将x填到这个坑中。
        s[i] = x;

        return i;

    }
    int partition3(int[] nums, int left, int right) {
        int pivot = nums[left], l = left + 1, r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
                r--;
            }
            while ( l<=r && nums[l] >= pivot) ++l;
            while ( l<=r && nums[r] <= pivot) --r;
        }
        int temp = nums[r];
        nums[r] = nums[left];
        nums[left] = temp;
        return r;
    }

    int partition(int[] nums, int left, int right) {
        int pivot = nums[left], l = left+1, r = right;
        while (l < r) {
            while(l <= r && nums[l] >= pivot)
            {
                ++l;
            }
            while(l <= r && nums[r] <= pivot)
            {
                --r;
            }
            if(l<r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }

        }
        int temp = nums[r];
        nums[r] = nums[left];
        nums[left] = temp;
        return r;
    }




    public static void main(String[] args) {
        new KthLargestElementInAnArray().partition(new int[]{3,2,1,5,6,4}, 0,5);

       int res = new KthLargestElementInAnArray().findKthLargest(new int[]{3,2,1,5,6,4}, 4);
       System.out.println(res);
    }


}
