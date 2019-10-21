package JsonApp;

public class JsonUser {
    private String name;
    private String age;

    public JsonUser() {

    }

    public JsonUser(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
