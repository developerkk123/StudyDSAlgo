package ArrayProblem;

import java.util.Arrays;

public class CustomSorting {
    public static void main(String[] args) {
        PersonObject[] people = {
            new PersonObject("Kundan", 29),
            new PersonObject("Prabhat", 21),
            new PersonObject("Pravesh", 20),
            new PersonObject("Ambika", 28),
        };
        Arrays.sort(people, (a, b)-> Integer.compare(a.age, b.age));
        System.out.print(Arrays.toString(people));
    }
}
