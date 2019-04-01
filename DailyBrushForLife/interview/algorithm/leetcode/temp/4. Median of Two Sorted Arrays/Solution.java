class Solution {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int sum = nums1.length + nums2.length;
        if ((sum) % 2 == 0) {
            return (findNthNum(nums1,0,nums2,0,sum/2)+findNthNum(nums1,0,nums2,0,sum/2+1))/2.0;

        } else {
            return findNthNum(nums1,0,nums2,0,sum/2+1);
        }
    }
    
    private double findNthNum(int[] nums1, int i, int[] nums2, int j, int k) {

         if(i>=nums1.length){
             return  nums2[j+k-1];
         }
         if(j>=nums2.length){
             return  nums1[i+k-1];
         }
         if(k==1){
             return Math.min(nums1[i],nums2[j]);
         }

         int mid1 =  (i+k/2-1 < nums1.length) ? nums1[i+k/2-1]:Integer.MAX_VALUE;
         int mid2 =  (j+(k-k/2)-1 < nums2.length) ? nums2[j+(k-k/2)-1]:Integer.MAX_VALUE;
    
        
         if(mid1 == mid2){
             return nums1[i+(k)/2-1];
         }else
          if(mid1 < mid2){
           return   findNthNum(nums1,i+k/2,nums2,j,k-(k/2));
         }else{
            return findNthNum(nums1,i,nums2,j+(k-k/2),k/2);
         }

        }


//    private double findNthNum(int[] nums1, int i, int[] nums2, int j, int k) {

//          if(i>=nums1.length){
//              return  nums2[j+k-1];
//          }
//          if(j>=nums2.length){
//              return  nums1[i+k-1];
//          }
//          if(k==1){
//              return Math.min(nums1[i],nums2[j]);
//          }

//          int mid1 =  (i+k/2-1 < nums1.length) ? nums1[i+k/2-1]:Integer.MAX_VALUE;
//          int mid2 =  (j+k/2-1 < nums2.length) ? nums2[j+k/2-1]:Integer.MAX_VALUE;
//           if(mid1 < mid2){
//            return   findNthNum(nums1,i+k/2,nums2,j,k-(k/2));
//          }else{
//             return findNthNum(nums1,i,nums2,j+k/2,k-(k/2));
//          }

//         }

}