class Solution {
    
    
  public String addBinary(String a, String b) {

        int temp = 0;
        int la= a.length();
        int lb= b.length();


        if (la > lb) {

            for (int i = 0; i < la - lb; i++)
                b = "0" + b;
        }

        if (la < lb) {
            for (int i = 0; i < lb- la; i++)
                a = "0" + a;

        }

        String s = "";
        for (int i = a.length()-1; i >= 0; i--) {
            int res = a.charAt(i) - 48 + b.charAt(i) - 48 + temp;
            if (res >= 2) {
                temp = 1;
            } else {
                temp = 0;
            }
            s = (res & 1) + "" + s;
        }

        if(temp == 1){

            s = "1" + s;
        }
        return s;


    }


}