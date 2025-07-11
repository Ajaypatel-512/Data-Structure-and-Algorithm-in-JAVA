package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoLinkedLists {
    /**
     * 160. Intersection of Two Linked Lists
     * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
     *
     * For example, the following two linked lists begin to intersect at node c1:
     *
     *
     * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
     *
     * Note that the linked lists must retain their original structure after the function returns.
     *
     * Custom Judge:
     *
     * The inputs to the judge are given as follows (your program is not given these inputs):
     *
     * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
     * listA - The first linked list.
     * listB - The second linked list.
     * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
     * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
     * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * Output: Intersected at '8'
     * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
     * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
     * - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
     * Example 2:
     *
     *
     * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * Output: Intersected at '2'
     * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
     * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
     * Example 3:
     *
     *
     * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * Output: No intersection
     * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
     * Explanation: The two lists do not intersect, so return null.
     *
     *
     * Constraints:
     *
     * The number of nodes of listA is in the m.
     * The number of nodes of listB is in the n.
     * 1 <= m, n <= 3 * 104
     * 1 <= Node.val <= 105
     * 0 <= skipA <= m
     * 0 <= skipB <= n
     * intersectVal is 0 if listA and listB do not intersect.
     * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
     *
     *
     * Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
     * */
    public static void main(String[] args) {

    }

    //Solution 1: Using hashMap
    // Time Complexity: O(m + n), where m and n are the lengths of the two linked lists.
    // Space Complexity: O(m), where m is the length of the first linked list (headA).
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = headA;
        while (temp != null) {
            map.put(temp, 1);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (map.containsKey(temp)) {
                return temp; // Return the intersection node
            }
            temp = temp.next;
        }
        return null; // No intersection found
    }

    //Solution 2: Using traversal
    // Time Complexity: O(n1) + O(n2), where n1 and n2 are the lengths of the two linked lists.
    // Space Complexity: O(1), as we are not using any additional data structures.
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        return collisionPoint(headA, headB);
    }

    private static int getDifference(ListNode head1,ListNode head2) {
        int len1 = 0,len2 = 0;
        while(head1 != null || head2 != null) {
            if(head1 != null) {
                ++len1; head1 = head1.next;
            }
            if(head2 != null) {
                ++len2; head2 = head2.next;
            }

        }
        return len1-len2;
    }

    private static ListNode collisionPoint(ListNode head1, ListNode head2) {
        int diff = getDifference(head1,head2);
        if(diff < 0)
            while(diff++ != 0) head2 = head2.next;
        else while(diff-- != 0) head1 = head1.next;
        while(head1 != null) {
            if(head1 == head2) return head1;
            head2 = head2.next;
            head1 = head1.next;
        }
        return head1;
    }

    //Solution 3: Using two pointers
    // Time Complexity: O(m + n), where m and n are the lengths of the two linked lists.
    // Space Complexity: O(1), as we are not using any additional data structures.
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a.next;
            b = b.next;
            if (a == b) return a; // If they meet, return the intersection node
            if (a == null) a = headB; // Switch to headB when reaching the end of list A
            if (b == null) b = headA; // Switch to headA when reaching the end of list B
        }
        return a; // Either the intersection node or null if no intersection
    }
}
