package Assignment;

/**
 * السؤال 10: حذف العناصر المكررة من قائمة مزدوجة (Doubly Linked List).
 * يتم الحفاظ على أول ظهور لكل قيمة، ويتم حذف العقد المتكررة.
 */
public class Question10 {
    static class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يحذف العناصر المكررة من القائمة ويعيد رأس القائمة بعد التنظيف.
     * @param head رأس القائمة (قد تكون null)
     * @return رأس القائمة بعد إزالة التكرارات
     */
    public static Node removeDuplicates(Node head) {
        if (head == null) return null;
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();
        Node cur = head;
        while (cur != null) {
            if (seen.contains(cur.data)) {
                // حذف العقدة الحالية
                Node prevNode = cur.prev;
                Node nextNode = cur.next;
                if (prevNode != null) prevNode.next = nextNode;
                if (nextNode != null) nextNode.prev = prevNode;
                // إذا كانت العقدة هي الرأس، نعيد الرأس إلى التالي
                if (cur == head) head = nextNode;
            } else {
                seen.add(cur.data);
            }
            cur = cur.next;
        }
        return head;
    }

    // مثال للاختبار
    public static void main(String[] args) {
        // إنشاء القائمة: 1 <-> 2 <-> 2 <-> 3 <-> 1
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        Node n5 = new Node(1);
        // ربط العقد
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;
        n4.next = n5; n5.prev = n4;
        // حذف التكرارات
        Node cleaned = removeDuplicates(n1);
        // طباعة القائمة بعد التنظيف
        System.out.print("القائمة بعد حذف التكرارات: ");
        for (Node cur = cleaned; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
    }
}
