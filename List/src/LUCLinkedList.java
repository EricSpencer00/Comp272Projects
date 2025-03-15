public class LUCLinkedList { //singly linked list
    Node head; //head of list

    public void insert(int data) {
        Node new_node = new Node(data);
        new_node.next = null;
        if(head == null) {
            head = new_node;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
    }

    public void printList() {
        Node currNode = head;
        System.out.print("LinkedList: ");
        while(currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public int addList(){
        Node currNode = head;
        int sum = 0;
        while(currNode != null) {
            sum += currNode.data;
            currNode = currNode.next;
        }
        return sum;
    }

    public int findMax() {
        Node currNode = head;
        int max = 0;
        while(currNode != null) {
            if(max < currNode.data) {
                max = currNode.data;
            }
            currNode = currNode.next;
        }
        return max;
    }

    public void printEven() {
        Node currNode = head;
        int counter = 0;
        while(currNode != null) {
            if(counter % 2 == 0) {
                System.out.print(currNode.data + " ");
            }
            counter++;
            currNode = currNode.next;
        }
    }

    public void removeElement(int element) {
        while (head != null && head.data == element) {
            head = head.next;
        }

        Node currNode = head;
        while(currNode != null && currNode.next != null) {
            if (currNode.next.data == element) {
                currNode = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }
    }

}


