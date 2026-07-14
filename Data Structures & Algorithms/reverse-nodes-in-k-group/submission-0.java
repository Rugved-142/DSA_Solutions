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
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        } 

        if(len < k) return head;

        curr = head;
        ListNode prevTail = null;
        ListNode prev=null;
        for(int i= 0;i<len/k;i++){
            int count = 0;
            ListNode temp;
            ListNode temp1 = curr;
            while(count < k){
                temp= curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
                count++;
            }
            if(prevTail == null) head = prev; else prevTail.next = prev;
            prevTail = temp1;
            temp1.next = curr;
            prev = null;

        }
        return head;
    }
}
