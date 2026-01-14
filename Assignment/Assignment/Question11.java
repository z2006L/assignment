package Assignment;

/**
 * السؤال 11: اجتياز قائمة مزدوجة (Doubly Linked List) بالعكس وطباعة جميع عناصرها.
 */
public class Question11 {
    static class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يطبع عناصر القائمة من النهاية إلى البداية.
     * @param head رأس القائمة (قد تكون null)
     */
    public static void printReverse(Node head) {
        if (head == null) {
            System.out.println("القائمة فارغة");
            return;
        }
        // الانتقال إلى آخر عقدة
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        // الطباعة من النهاية إلى البداية
        System.out.print("القائمة بالعكس: ");
        for (Node cur = tail; cur != null; cur = cur.prev) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    // مثال للاختبار
    public static void main(String[] args) {
        // إنشاء القائمة: 1 <-> 2 <-> 3
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        printReverse(n1);
    }
}
