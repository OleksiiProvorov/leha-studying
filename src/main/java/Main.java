public class Main {
    public static void main(String[] args) {
        int[] array = new int[7];

        for (int i = 1; i < 7; i++) {
            array[i] = i;
        }

        for (int i = 0; i < array.length; i++) {
            int y = array[i];
            if (y % 2 == 0) {
                System.out.println(i);
            } else {
                System.out.println("нечётное");
            }

        }
    }
}
