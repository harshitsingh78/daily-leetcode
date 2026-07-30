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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        ListNode current = head;
        while(current != null){
            res.add(current.val);
            current= current.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode point = dummy;
        for(int i = res.size() - 1;i>=0;i--){
            point.next = new ListNode(res.get(i));
            point= point.next;
        }
        return dummy.next;
    }
}