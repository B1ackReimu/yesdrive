import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int n = 0b10000000000000000;
        System.out.println(pad(n));
        System.out.println(pad(n >>> 1));
        n |= n >> 1;
        System.out.println(pad(n));
        System.out.println(pad(n >>> 2));
        n |= n >> 2;
        System.out.println(pad(n));
        System.out.println(pad(n >>> 4));
        n |= n >> 4;
        System.out.println(pad(n));
        System.out.println(pad(n >>> 8));
        n |= n >> 8;
        System.out.println(pad(n));
        System.out.println(pad(n >>> 16));
        n |= n >> 16;
        System.out.println(pad(n));
    }

    public static String pad(int n) {
        StringBuilder s = new StringBuilder(Integer.toBinaryString(n));
        if (s.length() < 32) {
            int a = 32 - s.length();
            for (int i = 0; i < a; i++) {
                s.insert(0, "0");
            }
        }
        return s.toString();
    }

}
