//Link:-https://www.codingninjas.com/codestudio/problems/middle-of-linked-list_973250?source=youtube&campaign=Lovebabbarcodestudio_24thJan&leftPanelTab=1


public class Solution {
    public static Node findMiddle(Node head) 
    {
        // Write your code here
        Node slow = head;
        Node fast=head;
        while(fast != null && fast.next != null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
