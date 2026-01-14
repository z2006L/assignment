package Assignment;

/**
 * السؤال 2: حذف عنصر عشوائي من مصفوفة.
 * يختار البرنامج فهرسًا عشوائيًا ثم يزيل العنصر في ذلك الفهرس.
 */
import java.util.Random;
import java.util.Arrays;

public class Question2 {
    /**
     * يحذف عنصراً عشوائياً من المصفوفة.
     * @param arr المصفوفة الأصلية
     * @return مصفوفة جديدة بعد حذف العنصر العشوائي
     */
    public static int[] removeRandom(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        Random rand = new Random();
        int index = rand.nextInt(arr.length);
        int[] result = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == index) continue; // تخطي العنصر العشوائي
            result[j++] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50};
        int[] after = removeRandom(original);
        System.out.print("بعد حذف عنصر عشوائي: ");
        System.out.println(Arrays.toString(after));
    }
}
