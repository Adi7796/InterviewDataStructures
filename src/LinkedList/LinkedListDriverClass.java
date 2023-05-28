package LinkedList;

class Node1 {
    int data;
    Node1 next;
}

class InsertNewElement {
    public Node1 getNewNode(int data)
    {
        Node1 node = new Node1();
        node.data=data;
        node.next=null;

        return node;
    }

    public Node1 insertNode(int data, Node1 node)
    {
        if(node==null) {
            return getNewNode(data);
        }
        else{
            Node1 firstNode = node;
            while(node.next!=null)
                node=node.next;
            Node1 newNode = getNewNode(data);
            node.next=newNode;
            return firstNode;
        }
    }

    public Node1 insertAtBeginning(int data, Node1 head)
    {
        if(head==null)
            return getNewNode(data);
        else{
            Node1 newNode = getNewNode(data);
            newNode.next = head;
            return newNode;
        }
    }

    public Node1 insertAtEnd(int data, Node1 head)
    {
        if(head==null)
            return getNewNode(data);
        else
        {
            Node1 node = head;
            while(node.next!=null)
            {
                node=node.next;
            }
            Node1 newNode = getNewNode(data);
            node.next=newNode;

            return head;
        }
    }

    public Node1 insertAtPosition(int data, int pos, Node1 head)
    {
        if(head==null)
            return getNewNode(data);
        else if(pos<1){
            System.out.println("Position cannot be less than 1");
            return head;
        }
        else if(pos == 1)
        {
            Node1 node = insertAtBeginning(data,head);
            return node;
        }


        else if(head==null && pos >1)
        {
            System.out.println("Position greater than number of elements");
            return head;
        }

        else if(pos>=2){
               Node1 node = head;
               Node1 prevNode = null;
               Node1 newNode = getNewNode(data);
               while(pos-- > 1)
               {
                   prevNode=node;
                   node=node.next;
               }
               prevNode.next=newNode;
               newNode.next=node;
               return head;
        }
        return head;
    }

    public void printList(Node1 head)
    {
        if(head==null)
            return;
        else{
            Node1 node = head;
            while(node!=null)
            {
                System.out.print(node.data +"->");
                node=node.next;
            }
        }
    }

}

public class LinkedListDriverClass{
    public static void main(String[] args)
    {
        InsertNewElement obj = new InsertNewElement();
        Node1 head = null;
        head = obj.insertNode(12,head);
        head = obj.insertNode(23,head);
        head = obj.insertNode(45,head);
        head = obj.insertAtBeginning(5,head);
        head=obj.insertAtEnd(77,head);
        head=obj.insertAtPosition(99,1,head);
        obj.printList(head);

    }
}
