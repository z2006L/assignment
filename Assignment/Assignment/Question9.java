package Assignment;

/**
 * السؤال 9: حذف عنصر من موقع محدد في قائمة مرتبطة أحادية.
 */
public class Question9 {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يحذف العقدة الموجودة في الفهرس المحدد (0‑based).
     * إذا كان الفهرس خارج نطاق القائمة، تُرجع القائمة كما هي.
     */
    public static Node deleteAt(Node head, int index) {
        if (head == null || index < 0) return head;
        if (index == 0) {
            return head.next; // حذف الرأس
        }
        Node prev = head;
        for (int i = 0; i < index - 1 && prev.next != null; i++) {
            prev = prev.next;
        }
        if (prev.next != null) {
            prev.next = prev.next.next; // تخطي العقدة المحذوفة
        }
        return head;
    }

    // مثال للاختبار
    public static void main(String[] args) {
        // إنشاء القائمة: 1 -> 2 -> 3 -> 4
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2; n2.next = n3; n3.next = n4;
        // حذف العنصر في الفهرس 2 (القيمة 3)
        Node newHead = deleteAt(n1, 2);
        System.out.print("القائمة بعد الحذف: ");
        for (Node cur = newHead; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
    }
}
