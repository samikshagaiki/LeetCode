/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode prev = head;
        ListNode curr = head;

        while(curr !=null && curr.next !=null){
            curr = curr.next.next;
            prev = prev.next;


        }

        return prev;
    }
}