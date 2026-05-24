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
    public ListNode reverseKGroup(ListNode head, int k) {

        // when k is 1, the list remains as is even after the reversal.
        if (k == 1) {
            return head;
        }

        int count = 0;
        ListNode nodePrev, nodeNext, revHead, revTail, temp;
        nodePrev = nodeNext = temp = revHead = revTail = null;

        // assign a dummy node, prev to head
        nodePrev = new ListNode(-1);
        nodePrev.next = head;

        temp = head;
        while (temp != null) {

            count++;

            if (count == k) {
 
                // detach the current group, and reverse it.
                nodeNext = temp.next;
                temp.next = null;
                ListNode reversed[] = reverse(nodePrev.next);

                // to memorize the head, after the reversal.
                if (nodePrev.next == head) {        
                    head = reversed[0];
                }

                // attach the reversed group, to the existing list.
                nodePrev.next = reversed[0];
                reversed[1].next = nodeNext;
                nodePrev = reversed[1];
                temp = nodeNext;
                count = 0;

            } else {
                temp = temp.next;
            }

        }

        return head;
        
    }

    /**
     * method to reverse the list
     * returns the array of ListNode, of size 2
     * 0 -> contains the head of the reversed list
     * 1 -> contains the tail of the reversed list
     */
    private static ListNode[] reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode[] res = new ListNode[2];

        while(curr != null) {

            ListNode temp = curr.next;
            curr.next = prev;

            // keeps track of the revTail.
            if (prev == null) {
                res[1] = curr;
            }

            prev = curr;
            curr = temp;

        }

        res[0] = prev;
        return res;
    }
}