package leetcode.add;

public class AddStrings {

    public String addStrings(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();

        int i = len1 - 1, j = len2 - 1;

        int over = 0;


        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = a + b + over;
            sb.append(sum % 10);
            over = sum / 10;
        }



        return over==1 ? sb.append(1).reverse().toString() : sb.reverse().toString();

    }







    public static void main(String[] args) {
        System.out.println( new AddStrings().addStrings("584","18"));
    }
}
