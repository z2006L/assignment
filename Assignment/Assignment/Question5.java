package Assignment;

/**
 * السؤال 5: دمج قائمتين مرتبطتين (Singly Linked List).
 * يعرّف البرنامج طريقة لدمج قائمتين وإرجاع رأس القائمة المدمجة.
 */
public class Question5 {
    /**
     * تعريف عقدة القائمة المرتبطة.
     */
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يدمج القائمة الثانية في نهاية القائمة الأولى.
     * @param head1 رأس القائمة الأولى (قد تكون null)
     * @param head2 رأس القائمة الثانية (قد تكون null)
     * @return رأس القائمة المدمجة
     */
    public static Node concatenate(Node head1, Node head2) {
        if (head1 == null) return head2;
        Node cur = head1;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head2;
        return head1;
    }

    // مثال للاختبار
    public static void main(String[] args) {
        // إنشاء القائمة الأولى: 1 -> 2
        Node a1 = new Node(1);
        Node a2 = new Node(2);
        a1.next = a2;
        // إنشاء القائمة الثانية: 3 -> 4
        Node b1 = new Node(3);
        Node b2 = new Node(4);
        b1.next = b2;
        // دمج القائمتين
        Node merged = concatenate(a1, b1);
        // طباعة القائمة المدمجة
        System.out.print("القائمة المدمجة: ");
        for (Node cur = merged; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
    }
}
