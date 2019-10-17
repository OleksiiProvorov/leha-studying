public class Methods {
    public static void main(String[] args) {
        int size = 12;
        //int[] array = new int[size];

        //fillArray(array, size);
        //printArray(array);
        int[] array = createAndFillArray(size);
        printArray(array);

    }

    static void fillArray(int[] array, int end) {
        for (int i = 0; i < end; i++) {
            array[i] = i;
        }
    }

    static void printArray(int[] array) {
        for (int x : array) {
            System.out.println(x);
        }
    }

    static int[] createAndFillArray(int end) {
        int[] array = new int[end];
        for (int i = 0; i < end; i++) {
            array[i] = i;
        }
        return array;
    }
}
