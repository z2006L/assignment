package Assignment;

/**
 * السؤال 4: عكس ترتيب عناصر مصفوفة.
 * يعرّف البرنامج طريقة لعكس المصفوفة وإرجاع نسخة معكوسة.
 */
import java.util.Arrays;

public class Question4 {
    /**
     * يعكس المصفوفة ويعيد نسخة جديدة.
     * @param arr المصفوفة الأصلية
     * @return مصفوفة معكوسة
     */
    public static int[] reverseArray(int[] arr) {
        if (arr == null) return null;
        int[] rev = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rev[i] = arr[arr.length - 1 - i];
        }
        return rev;
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        System.out.println("المصفوفة الأصلية: " + Arrays.toString(original));
        System.out.println("المصفوفة المعكوسة: " + Arrays.toString(reverseArray(original)));
    }
}
