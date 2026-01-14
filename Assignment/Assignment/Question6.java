package Assignment;

/**
 * السؤال 6: تدوير قائمة مرتبطة أحادية إلى اليمين بمقدار k مواضع.
 * إذا كان k أكبر من طول القائمة، يتم أخذ باقي القسمة على الطول.
 */
public class Question6 {
    /**
     * تعريف عقدة القائمة المرتبطة.
     */
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يدور القائمة إلى اليمين k مواضع.
     * @param head رأس القائمة (قد تكون null)
     * @param k عدد المواضع للدوران (غير سالب)
     * @return رأس القائمة بعد الدوران
     */
    public static Node rotateRight(Node head, int k) {
        if (head == null || k == 0) return head;
        // حساب طول القائمة
        Node cur = head;
        int len = 1;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        // ربط آخر عنصر بالرأس لتشكيل دائرة
        cur.next = head;
        // k قد يكون أكبر من الطول
        k = k % len;
        int stepsToNewHead = len - k;
        Node newTail = cur;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null; // قطع الدائرة
        return newHead;
    }

    // مثال للاختبار
    public static void main(String[] args) {
        // إنشاء القائمة: 1 -> 2 -> 3 -> 4 -> 5
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
        Node rotated = rotateRight(n1, 2);
        System.out.print("القائمة بعد الدوران: ");
        for (Node cur = rotated; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
    }
}
