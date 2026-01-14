package Assignment;

/**
 * السؤال 7: البحث عن عنصر في قائمة مرتبطة أحادية وإرجاع موقعه (0‑based).
 */
public class Question7 {
    /**
     * تعريف عقدة القائمة المرتبطة.
     */
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يبحث عن القيمة ويعيد فهرسها أو -1 إذا لم توجد.
     * @param head رأس القائمة (قد تكون null)
     * @param target القيمة المطلوبة
     * @return الفهرس (0‑based) أو -1 إذا لم توجد
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
        Node n1 = new Node(5);
        Node n2 = new Node(10);
        Node n3 = new Node(15);
        n1.next = n2; n2.next = n3;
        System.out.println("موقع 10 هو: " + search(n1, 10)); // يجب أن يطبع 1
        System.out.println("موقع 7 هو: " + search(n1, 7));   // يجب أن يطبع -1
    }
}
