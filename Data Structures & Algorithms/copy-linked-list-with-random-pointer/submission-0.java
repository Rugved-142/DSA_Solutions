/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> ref = new HashMap<>();
        Node temp = head;

        while(temp !=null){
            ref.put(temp,new Node(temp.val));
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node newCopy = ref.get(temp);
            newCopy.next = ref.get(temp.next);
            newCopy.random = ref.get(temp.random);
            temp=temp.next;
        }

        return ref.get(head);
    }
}
