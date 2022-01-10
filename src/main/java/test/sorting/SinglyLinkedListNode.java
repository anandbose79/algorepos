package test.sorting;

import java.util.List;

public class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
    public static void main(String args[])
    {

    }
    public static SinglyLinkedListNode merge_k_lists(List<SinglyLinkedListNode> lists) {
        int i = 0;
        int k=lists.size();
        while (lists.size() > 1)
        {
            merge(lists);
        }
        return lists.get(0);
    }
    static void merge(List<SinglyLinkedListNode> lists)
    {
        SinglyLinkedListNode LeftList = lists.get(0);
        SinglyLinkedListNode head = lists.get(0);
        SinglyLinkedListNode rightList = lists.get(1);
        //merge left and right , remove 1th element form lists
        SinglyLinkedListNode prev = LeftList;
        while (LeftList!=null && rightList!=null )
        {
            prev = LeftList;
            if (LeftList.data <= rightList.data)
            {
                LeftList = LeftList.next;
            }
            else
            {
                //insert right data into the list
                SinglyLinkedListNode n = new SinglyLinkedListNode(rightList.data);
                //n.data = ;
                n.next = LeftList;
                System.out.println("n::");printList(n);

                //where to insert
                if (head == LeftList)
                {
                    System.out.println("in head == leftlist::");
                    head = n;
                    prev= n;

                }
                else
                {
                    System.out.println("in head != leftlist::");
                    System.out.println("Previous::");printList(prev);
                    System.out.println("n::");printList(n);


                    prev.next = n;
                    System.out.println("Previous::");printList(prev);
                    System.out.println("head::");printList(head);
                }
                rightList = rightList.next;

                System.out.println("n::");printList(n);

            }
            System.out.println("head::");printList(head);
            System.out.println("Previous::");printList(prev);
            System.out.println("LeftLisst::");printList(LeftList);
            System.out.println("RightList::");printList(rightList);



        }
        while (rightList !=null)
        {
            LeftList.next = rightList;
            rightList = rightList.next;
        }
        while (LeftList != null)
        {
            LeftList = LeftList.next;
        }


        lists.set(0,head); lists.remove(1);

    }
    static void  printList(SinglyLinkedListNode list)
    {
        SinglyLinkedListNode head = list;
        System.out.print("[ ");
        while (head != null)
        {
            System.out.print(head.data+" "); head = head.next;
        }
        System.out.print(" ]");


    }
}
