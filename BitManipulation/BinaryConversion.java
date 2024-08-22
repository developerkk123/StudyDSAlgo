package BitManipulation;

public class BinaryConversion {
    public static String convertToBinary(int n){
        String s="";
        while (n > 0) {
            if(n%2 == 1){
                s += "1";
            }else{
                s += "0";
            }
            n=n/2;
        }
        return new StringBuilder(s).reverse().toString();
    }
    public static int convertToDecimal(String s){
        int n = s.length();
        int pow = 1;
        int num = 0;
        for(int i=n-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == '1'){
                num += pow;
            }
            pow = pow*2;
        }
        return num;
    }
    public static void main(String[] args) {
        int n = 13;
        String binary = convertToBinary(n);
        System.out.println(binary);
        System.out.println(convertToDecimal(binary));
        System.out.println(13/14);
    }
}
