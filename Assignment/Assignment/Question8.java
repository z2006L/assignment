package Assignment;

/**
 * السؤال 8: إيجاد فهرس قيمة معينة في قائمة مرتبطة أحادية.
 * إذا لم توجد القيمة تُرجع -1.
 */
public class Question8 {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يبحث عن القيمة ويعيد فهرسها (0‑based) أو -1 إذا لم توجد.
     */
    public static int indexOf(Node head, int value) {
        int index = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data == value) return index;
            index++;
        }
        return -1;
    }

    // مثال للاختبار
    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(3);
        Node n3 = new Node(9);
        n1.next = n2; n2.next = n3;
        System.out.println("فهرس 3 هو: " + indexOf(n1, 3)); // 1
        System.out.println("فهرس 5 هو: " + indexOf(n1, 5)); // -1
    }
}
