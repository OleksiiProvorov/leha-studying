package collections;

public class User {
    private String name;
    private String age;
    private String height;
    private String weight;


    public User(String name){
        this.name = name;
    }

    public String getName(){
        return "name" + name;
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, String age, String height, String weight) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + "\n" + "Age: " + age + "\n" + "Height: " +
                height + "\n" + "Weight: " + weight + "\n");
    }

    @Override
    public String toString() {
        return "name: " + name + "\n" +
                "age: " + age + "\n" +
                "height: " + height + "\n" +
                "weight: " + weight + "\n" + "\n";
    }

    public String toText() {
        return name + ";" + age + ";" + height + ";" + weight;
    }

    public static User from(String text) {
        String[] split = text.split(";");
        String name = split[0];
        String age = split[1];
        String height = split[2];
        String weight = split[3];
        return new User(name, age, height, weight);
    }
}