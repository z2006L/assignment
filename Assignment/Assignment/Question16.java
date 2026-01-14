package Assignment;

/**
 * السؤال 16: تقسيم قائمة دائرية إلى نصفين.
 * تُعيد الدالة مصفوفة من رأسين تمثل النصفين الأول والثاني.
 * إذا كان عدد العقد فرديًا، يحصل النصف الأول على العقدة الإضافية.
 */
public class Question16 {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    /**
     * يقسم القائمة الدائرية إلى نصفين.
     * @param head رأس القائمة الدائرية (قد تكون null)
     * @return مصفوفة من رأسين: [headFirstHalf, headSecondHalf]
     */
    public static Node[] splitList(Node head) {
        if (head == null) return new Node[]{null, null};
        // استخدام مؤشرات بطيئة وسريعة للعثور على منتصف القائمة
        Node slow = head;
        Node fast = head;
        // يتحرك fast بمقدار خطوتين، slow بمقدار خطوة واحدة
        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // الآن slow يقع في منتصف القائمة (أو العنصر قبل المنتصف إذا عدد العقد زوجي)
        Node head1 = head;
        Node head2 = slow.next;
        // قطع الدوائر لتكوين قائمتين منفصلتين
        fast = fast.next; // fast الآن في آخر عقدة
        fast.next = head2; // ربط آخر عقدة بالنصف الثاني
        slow.next = head1; // ربط منتصف القائمة بالنصف الأول لتكوين دائرة ثانية
        return new Node[]{head1, head2};
    }

    // مثال للاختبار
    public static void main(String[] args) {
        // إنشاء قائمة دائرية: 1 -> 2 -> 3 -> 4 -> 5 -> (back to 1)
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n1;
        Node[] halves = splitList(n1);
        // طباعة نصف الأول (3 عناصر)
        System.out.print("النصف الأول: ");
        Node cur = halves[0];
        do {
            System.out.print(cur.data + " ");
            cur = cur.next;
        } while (cur != halves[0]);
        System.out.println();
        // طباعة نصف الثاني (2 عناصر)
        System.out.print("النصف الثاني: ");
        cur = halves[1];
        do {
            System.out.print(cur.data + " ");
            cur = cur.next;
        } while (cur != halves[1]);
        System.out.println();
    }
}
