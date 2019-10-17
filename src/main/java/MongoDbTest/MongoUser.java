package MongoDbTest;

public class MongoUser {
    private String name;
    private String age;

    public MongoUser(String name, String age) {
        this.name = name;
        this.age = age;
    }



    public String getMongoName() {
        return name;
    }

    public String getMongoAge() {
        return age;
    }

    public void displayInfo(){
        System.out.println("Name: " + name + "\n"
                               + "Age: " + age);
    }
}
