package StringProblem;

import java.util.HashMap;

public class GeneralConcept {
    public static void main(String[] args) {
        /**
         * print alphabet just like integer 
         * initialize char = a;
         * use increment operator ch++;
         */
        // char ch = 'a';
        // int i=0;
        // while(i < 26){
        //     System.out.print(ch++ + " ");
        //     i++;
        // }

        String s = "is2 sentence4 This1 a3";
        String[] str = s.split(" ");
        HashMap<Integer,String> map = new HashMap<>();
        for(int i=0; i<str.length; i++){
            String st= str[i];
            String temp = st.substring(0, st.length()-1);
            int t = Integer.parseInt(st.substring(st.length()-1, st.length()));
            System.out.println(temp + " "+ t);
            map.put(t, temp);
        }
       System.out.println(map.get(1));

    }
}