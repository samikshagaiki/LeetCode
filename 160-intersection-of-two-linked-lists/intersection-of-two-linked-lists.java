/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        // If either list is null, no intersection is possible
        if (headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // Traverse both lists. When one reaches the end, start at the head of the other.
        // If there is an intersection, they will meet at that node.
        // If not, both will eventually be null.
        while (ptrA != ptrB) {
            ptrA = (ptrA != null) ? ptrA.next : headB;
            ptrB = (ptrB != null) ? ptrB.next : headA;
        }

        return ptrA; // Either the intersection node or null
    }
}

