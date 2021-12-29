package LinkedList;

/**
 * Describe:
 * Author: 九霄道长
 * CreateTime: 2021/12/29 13:37
 */

public class ReverseLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
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
    }
}
