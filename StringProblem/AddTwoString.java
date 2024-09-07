package StringProblem;

public class AddTwoString {
    public static String addStrings(String num1, String num2) {
        StringBuilder ans= new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        //int sum = 0;
        while(i >= 0 || j>=0 || carry >0){
            int n1 = (i>=0) ? num1.charAt(i)-'0' : 0;
            int n2 = (j>=0) ? num2.charAt(j)-'0' : 0;
            int sum =  n1 + n2 + carry;
            carry = sum/10;
            ans.append(sum % 10);
            //sum = sum*10;
            i--;j--;
        }
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        String s1 = "11112";
        String s2 = "23432";
        System.out.println(addStrings(s1, s2));
    }
}
