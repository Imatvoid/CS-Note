import java.util.*;

import static java.util.Arrays.copyOf;

public class temp {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return;
        }

        boolean row10 = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row10 = true;
                break;
            }


        }
        boolean col10 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col10 = true;
                break;
            }

        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

        }


        if (row10) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (col10) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }


    }


    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) return new int[][]{};

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a1, int[] a2) {
//                return a1[0] - a2[0];
//            }
//        });


        ArrayList<int[]> res = new ArrayList<>();
        int[] prev = new int[]{0, 0};
        prev = intervals[0];
        int i = 1;
        while(i < intervals.length){
            int[] cur = intervals[i];
            if(prev[1] <  cur[0]){
                res.add(prev);
                prev = cur;
                i++;
            }else{
                //int[] newCur = new int[]{Math.min(cur[0], prev[0]), Math.max(cur[1], prev[1])};

                prev[1] = Math.max(prev[1], cur[1]);
                // prev = newCur;
                i++;
            }
        }
        res.add(prev);

        return res.toArray(new int[res.size()][2]);
    }



    public int trap(int[] height) {
        Stack<Integer> st = new Stack();
        int i = 0, res = 0, n = height.length;
        while (i < n) {
            if (st.isEmpty() || height[i] <= height[st.peek()]) {
                st.push(i++);
            } else {
                int t = st.peek(); st.pop();
                if (st.isEmpty()) continue;
                res += (Math.min(height[i], height[st.peek()]) - height[t]) * (i - st.peek() - 1);
            }
        }
        return res;

    }
    public int trapTimeLimited(int[] height) {
        if(height==null || height.length <2){
            return 0;
        }


        int res = 0;


       int  []copy = Arrays.copyOf(height,height.length);
       Arrays.sort(copy);
       int pre = copy[copy.length-2];

        for (int i = 1; i <=pre ; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < height.length; j++) {
                if(height[j]>=i){
                    list.add(j);
                }
            }
            if(list.size()>=2){
                for (int k = 1; k < list.size(); k++) {
                    res += list.get(k)-list.get(k-1)-1;
                }
            }
        }

        return res;

    }



    public static void main(String[] args) {
        new temp().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});

        Random random = new Random();
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
           res.add(new int[]{random.nextInt(100),random.nextInt(100)});
        }
        Long start = System.nanoTime();
        new temp().merge(res.toArray(new int[res.size()][2]));
        System.out.println(System.nanoTime()-start);

        res.clear();
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            res.add(new int[]{random.nextInt(1000),random.nextInt(1000)});
        }
        System.out.println(System.nanoTime()-start);

        res.clear();
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            res.add(new int[]{random.nextInt(10000),random.nextInt(10000)});
        }
        System.out.println(System.nanoTime()-start);


//        1793296   64771817
//        1401815    1086015
//        2606232    2481080


    }
}
