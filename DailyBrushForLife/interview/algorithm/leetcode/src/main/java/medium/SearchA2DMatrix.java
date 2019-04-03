package medium;

public class SearchA2DMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {

       int m = matrix.length;
       int n = matrix[0].length;
       if(m == 0){
        return  false;
       }

       int index = -1;
       for(int i =1 ;i<m; i++){
           if(matrix[i][0] >= target ){
               index = i-1;
           }
       }
       if(index != -1){
           for(int i =0 ;i<n; i++){
               if(target == matrix[index][i]){
                  return true;
               }
           }

       }
       return  false;

    }

    public static void main(String[] args) {

    }
}
