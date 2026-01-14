package Assignment;

/**
 * السؤال 12: البحث عن عنصر في قائمة مزدوجة (Doubly Linked List).
 */
public class Question12 {
    static class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يبحث عن القيمة في القائمة ويعيد الفهرس (0‑based) أو -1 إذا لم توجد.
     */
    public static int search(Node head, int target) {
        int index = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data == target) return index;
            index++;
        }
        return -1;
    }

    // مثال للاختبار
    public static void main(String[] args) {
        // إنشاء القائمة: 4 <-> 7 <-> 2
        Node n1 = new Node(4);
        Node n2 = new Node(7);
        Node n3 = new Node(2);
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        System.out.println("موقع 7 هو: " + search(n1, 7)); // 1
        System.out.println("موقع 5 هو: " + search(n1, 5)); // -1
    }
}
