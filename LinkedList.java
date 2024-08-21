// ********************Linked List Implementation**************//

import java.util.*;

// LinkedList Class
public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Insert/Add a Node
    public static LinkedList insert(LinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    //Reverse Linked List
    public static LinkedList reverseList(LinkedList list) {
        Node curr = list.head, prev = null, next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        list.head = prev;
        return list;
    }

    //Print the List
    public static void printList(LinkedList list) {
        Node current = list.head;

        System.out.println("Linked list implementation using class");

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Remove Head Node
    public static LinkedList removeHead(LinkedList list_1) {
        Node head = list_1.head;
        Node temp = head.next;
        head.next = null;
        list_1.head = temp;
        return list_1;
    }

    //Insert a node at Nth position
    public static LinkedList insertatNpos(LinkedList list, int pos, int val) {
        Node new_node = new Node(val);
        if (pos == 0) {
            new_node.next = list.head;
            list.head = new_node;
            return list;
        }
        Node curr = list.head;
        int len = 0;

        while (curr != null && len < pos - 1) {
            curr = curr.next;
            len++;
        }
        if (curr == null) {
            System.out.println("Invalid Position " + pos);
        }
        new_node.next = curr.next;
        curr.next = new_node;

        return list;
    }

    //Remove Tail Node
    public static LinkedList removeTail(LinkedList list) {
        Node head = list.head;
        Node curr = head;
        if (head == null || head.next == null) {
            return null;

        }
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return list;

    }

    //Remove a node at Nth position
    public static LinkedList removeNpos(LinkedList list, int pos) {
        int len = 0;
        Node curr = list.head;

        if (pos == 0) {
            Node temp = list.head.next;
            list.head.next = null;
            list.head = temp;

            return list;
        }

        while (len < pos - 1 && curr != null) {
            curr = curr.next;
            len++;
        }

        Node r = curr.next;
        list.head.next = r;
        return list;


    }

    //Remove a node and print
    public static void removeValueAndPrint(LinkedList list, int value) {
        // If the head node itself holds the value to be deleted
        if (list.head != null && list.head.data == value) {
            list.head = list.head.next; // Changed head
        } else {
            // Search for the value to be deleted
            Node current = list.head;
            Node prev = null;

            while (current != null && current.data != value) {
                prev = current;
                current = current.next;
            }

            // If value was not present in the list
            if (current == null) {
                System.out.println("Value " + value + " not found in the list.");
                return;
            }

            // Unlink the node from the linked list
            prev.next = current.next;
        }

        // Print the updated list
        Node node = list.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }


    public static LinkedList removeNval(LinkedList list, int data) {
        Node curr = list.head;
        if (curr.data == data) {
            Node temp = curr.next;
            curr.next = null;
            list.head = temp;
            return list;
        }
        Node prev = null;
        while (curr != null && curr.data != data) {

            prev = curr;
            curr = curr.next;

        }
        prev.next = curr.next;

        return list;
    }

    //Make Tail node as Head Node
    public static LinkedList maketailasHead(LinkedList list) {
        Node curr = list.head;
//        curr.next=null;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        Node l = curr.next;

        curr.next = null;

        l.next = list.head;
        list.head = l;

        return list;
    }

    //Remove Middle node
    public static Node middleNode(LinkedList list) {
        int len = 0;
        Node curr = list.head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int mid = 0 + (len - 0) / 2;
        Node op = list.head;

        for (int i = 0; i < mid; i++) {
            op = op.next;
        }
        //op=op.next;
        return op;
    }

//Remove a node from nth place from end

    public static LinkedList removeNthend(LinkedList list, int r) {

        int len = 0;
        Node temp = list.head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (r > len) {
            return list;
        } else if (r == len) {
            Node c = list.head.next;
            ;
            list.head = list.head.next;
        } else {
            int d = len - r;
            Node prev = null;
            Node curr = list.head;
            for (int i = 0; i < d; i++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = curr.next;
        }
        return list;
    }

    //Detect Loop
    public static boolean detectloop(LinkedList list) {
        Node head = list.head;
        HashSet<Node> hs = new HashSet<Node>();
        while (head != null) {
            if (hs.contains(head))
                return true;
            else
                hs.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList list_1 = new LinkedList();
        list_1 = insert(list_1, 87);

        list_1 = insert(list_1, 89);
        list_1 = insert(list_1, 7);
        list_1 = insert(list_1, 12);
        list_1 = insert(list_1, 34);
        list_1 = insert(list_1, 50);

        printList(list_1);

        System.out.println();
        LinkedList list_2 = new LinkedList();
        list_2 = insert(list_2, 54);
        list_2 = insert(list_2, 4);
        list_2 = insert(list_2, 16);
        list_2 = insert(list_2, 7);
        list_2 = insert(list_2, 78);
        list_2 = insert(list_2, 67);
        printList(list_2);

        System.out.println("Reverse list");
        printList(list_2);
        list_2.head.next.next.next.next.next = list_2.head.next.next;
        System.out.println(detectloop(list_2));
        System.out.println("List 1");
        printList(list_1);
        System.out.println("After removing tail");
        list_1 = removeTail(list_1);
        printList(list_1);

        Node output = middleNode(list_1);
        System.out.println("Output is - " + output.data);
        removeNthend(list_2, 2);
        printList(list_2);
        maketailasHead(list_2);
        printList(list_2);
        insertatNpos(list_1, 0, 789);
        printList(list_1);
        removeNpos(list_1, 2);
        printList(list_1);
        LinkedList l3 = new LinkedList();
        l3 = insert(l3, 10);
        l3 = insert(l3, 20);
        removeValueAndPrint(l3, 30);
        printList(l3);
    }
}


