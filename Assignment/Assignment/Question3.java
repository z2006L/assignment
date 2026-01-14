package Assignment;

/**
 * السؤال 3: حذف عنصر محدد من مصفوفة.
 * يزيل البرنامج أول ظهور للعنصر المحدد من المصفوفة ويعيد مصفوفة جديدة.
 */
import java.util.Arrays;

public class Question3 {
    /**
     * يحذف أول ظهور للعنصر المحدد من المصفوفة.
     * @param arr المصفوفة الأصلية
     * @param value القيمة المراد حذفها
     * @return مصفوفة جديدة بعد حذف العنصر (أو نفس المصفوفة إذا لم توجد القيمة)
     */
    public static int[] removeElement(int[] arr, int value) {
        if (arr == null) return null;
        // إيجاد الفهرس الأول للقيمة
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) { index = i; break; }
        }
        if (index == -1) return arr; // القيمة غير موجودة
        int[] result = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == index) continue;
            result[j++] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] original = {5, 3, 7, 3, 9};
        int[] after = removeElement(original, 3);
        System.out.println("بعد حذف العنصر 3: " + Arrays.toString(after));
    }
}
