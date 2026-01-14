package Assignment;

/**
 * السؤال 13: إدراج عقدة في موضع محدد في قائمة دائرية (Circular Linked List).
 */
public class Question13 {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يدرج عقدة جديدة بالقيمة {@code data} في الموقع {@code position} (0‑based).
     * إذا كان {@code position} يساوي 0 فإن العقدة تصبح الرأس الجديد.
     * إذا كان {@code position} أكبر من طول القائمة، يتم إدراجها في النهاية.
     */
    public static Node insertAt(Node head, int data, int position) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode; // دائرة ذات عقدة واحدة
            return newNode;
        }
        if (position <= 0) {
            // إدراج قبل الرأس وجعلها الرأس الجديد
            Node tail = head;
            while (tail.next != head) tail = tail.next;
            newNode.next = head;
            tail.next = newNode;
            return newNode;
        }
        // الانتقال إلى العقدة السابقة للموقع المطلوب
        Node prev = head;
        int idx = 0;
        while (idx < position - 1 && prev.next != head) {
            prev = prev.next;
            idx++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }

    // مثال للاختبار
    public static void main(String[] args) {
        // إنشاء قائمة دائرية: 1 -> 2 -> 3 -> (back to 1)
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.next = n3; n3.next = n1;
        // إدراج قيمة 99 في الموضع 0 (تصبح رأس جديد)
        Node head = insertAt(n1, 99, 0);
        // طباعة 5 عناصر لتأكيد الدورية
        System.out.print("القائمة بعد الإدراج: ");
        Node cur = head;
        for (int i = 0; i < 5; i++) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
