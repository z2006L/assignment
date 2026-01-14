package Assignment;

/**
 * السؤال 14: حذف عقدة من موقع محدد في قائمة دائرية (Circular Linked List).
 */
public class Question14 {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يحذف العقدة الموجودة في الموضع {@code position} (0‑based).
     * إذا كان {@code position} يساوي 0 فإن الرأس يتم حذفه وتصبح الرأس الجديدة هي العنصر التالي.
     * إذا كان {@code position} خارج نطاق القائمة، تُرجع القائمة كما هي.
     */
    public static Node deleteAt(Node head, int position) {
        if (head == null) return null;
        // حساب طول القائمة
        int len = 1;
        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
            len++;
        }
        if (position < 0 || position >= len) return head; // خارج النطاق
        if (position == 0) {
            // حذف الرأس
            if (len == 1) return null; // قائمة ذات عنصر واحد تصبح فارغة
            tail.next = head.next; // ربط الذيل بالرأس الجديد
            return head.next;
        }
        // الانتقال إلى العقدة السابقة للموقع المطلوب
        Node prev = head;
        for (int i = 0; i < position - 1; i++) {
            prev = prev.next;
        }
        // حذف العقدة التالية لـ prev
        prev.next = prev.next.next;
        return head;
    }

    // مثال للاختبار
    public static void main(String[] args) {
        // إنشاء قائمة دائرية: 1 -> 2 -> 3 -> (back to 1)
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.next = n3; n3.next = n1;
        // حذف العنصر في الموضع 1 (القيمة 2)
        Node newHead = deleteAt(n1, 1);
        // طباعة 4 عناصر لتأكيد الدورية بعد الحذف
        System.out.print("القائمة بعد الحذف: ");
        Node cur = newHead;
        for (int i = 0; i < 4; i++) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
