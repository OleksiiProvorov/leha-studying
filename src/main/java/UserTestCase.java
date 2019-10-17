import collections.User;

public class UserTestCase {
    public static void main(String[] args) {
        User user = new User("nikita", "20");

        System.out.println(user);

        String text = user.toText();

        System.out.println(text);
        //name;20

        User userFromText = User.from(text);

        System.out.println(userFromText);


    }
}
