package LinkedList;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2021/12/30 10:48
 */


public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode n = null;
        while(node!=null){
            ListNode next = node.next;
            node.next=n;
            n=node;
            node=next;
        }
        return n;
    }
    public boolean hasCycle(ListNode head) {
        ListNode k= head;
        ListNode m =head;
        while(k!=null&&k.next!=null){
            k=k.next.next;
            m=m.next;
            if(k==m){
                return true;
            }
        }
        return false;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        // start 先走几步 步为 要删除的倒数个数
        while(n != 0) {
            start = start.next;
            n--;
        }
        // start 已经先走 start 的下一步为空 则 end 刚好是要删除的 节点的前一个
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }
    public ListNode middleNode(ListNode head) {

        ListNode k =head;
        ListNode m =head;
        while(k!=null&&k.next!=null){
            k=k.next.next;
            m=m.next;
        }

        return m;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum =new ListNode(-1);
        ListNode pre =dum;
        while (l1 != null&&l2 != null) {
            if (l1.val>l2.val) {
                pre.next = l2;
                l2=l2.next;
            }else {
                pre.next = l1;
                l1=l1.next;
            }
            pre=pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return dum;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);

        ListNode head1 = new ListNode(1);
        head1.next=new ListNode(2);
        head1.next.next=new ListNode(3);
        head1.next.next.next=new ListNode(4);
        mergeTwoLists(head,head1);
    }

}

