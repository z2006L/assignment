package Assignment;

/**
 * السؤال 1: استنساخ مصفوفة.
 * يوضح هذا البرنامج طريقة نسخ مصفوفة من نوع int إلى مصفوفة جديدة.
 */
public class Question1 {
    /**
     * تنسخ المصفوفة المدخلة وتعيد نسخة جديدة.
     * @param arr المصفوفة الأصلية
     * @return نسخة من المصفوفة
     */
    public static int[] cloneArray(int[] arr) {
        if (arr == null) return null;
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }

    // مثال بسيط للاختبار
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        int[] cloned = cloneArray(original);
        System.out.print("المصفوفة المستنسخة: ");
        for (int v : cloned) System.out.print(v + " ");
    }
}
