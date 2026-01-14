package Assignment;

/**
 * السؤال 15: البحث عن عنصر في قائمة دائرية (Circular Linked List).
 */
public class Question15 {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يبحث عن القيمة {@code target} في القائمة الدائرية.
     * @param head رأس القائمة (قد تكون null)
     * @param target القيمة المطلوبة
     * @return الفهرس (0‑based) إذا وُجدت القيمة، أو -1 إذا لم توجد.
     */
    public static int search(Node head, int target) {
        if (head == null) return -1;
        Node cur = head;
        int index = 0;
        do {
            if (cur.data == target) return index;
            cur = cur.next;
            index++;
        } while (cur != head);
        return -1;
    }

    // مثال للاختبار
    public static void main(String[] args) {
        // إنشاء قائمة دائرية: 5 -> 8 -> 2 -> (back to 5)
        Node n1 = new Node(5);
        Node n2 = new Node(8);
        Node n3 = new Node(2);
        n1.next = n2; n2.next = n3; n3.next = n1;
        System.out.println("موقع 8 هو: " + search(n1, 8)); // 1
        System.out.println("موقع 7 هو: " + search(n1, 7)); // -1
    }
}
