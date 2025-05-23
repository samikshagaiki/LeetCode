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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode temp = new ListNode();
        ListNode curr = temp;
        int carry = 0;

        while(l1!=null || l2!=null || carry!=0){
            int v1 = (l1!=null)?l1.val:0;
            int v2 = (l2!=null)?l2.val:0;

            int sum = v1+v2+carry;
            carry = sum/10;

            curr.next = new ListNode(sum%10);
            curr = curr.next;

            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;

        }

        return reverse(temp.next);
    }

    private ListNode reverse(ListNode head){
        
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}