package ArrayProblem;

public class PersonObject {
    String name;
    int age;

    public PersonObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

