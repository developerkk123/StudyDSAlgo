package StringProblem;

public class GeneralConcept {
    public static void main(String[] args) {
        String s ="abcdefgh";
        char ch = 'd';
        System.out.println(s.charAt(0)-0);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ch){
                System.out.println("index = "+ i);
                int j = i;
                while(j > 0){
                    System.out.println("i dec = "+ j);
                    j--;
                }
            }
        }
    }
}