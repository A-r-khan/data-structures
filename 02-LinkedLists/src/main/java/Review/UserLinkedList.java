package Review;

public class UserLinkedList {
    UserNode head;
    UserNode tail;
    int size;

    public UserLinkedList() {
        this.size = 0;
    }

    boolean isEmpty(){
        return head==null;
    }

    void insertLastPosition(UserNode node){
        if(isEmpty()) head=tail=node;  // list is empty
        else{   // list is not empty
            tail.next = node;
            tail = node;
        }
        size++;
    }

    void printLinkedList(){
        UserNode current = head;
        while (current!=null){
            System.out.print(current.name + "->");
            current = current.next;
            if(current==null) System.out.println("null");
        }
    }

    void deleteByName(String name){
        if(isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        UserNode prev = head;
        UserNode current = head;
        while(current!=null){
            if(current.name.equals(name)){
                // 1. node is head
                if(current==head){
                    if(head==tail) tail = null;
                    head = current.next; //if one element, this will assign null to next
                    current.next = null; // garbage collection
                } else if(current==tail){
                    //2. node to be deleted is tail
                    prev.next = null;
                    tail = prev;
                } else {
                    prev.next = current.next;
                    current.next = null;
                }
            }
            // move to next one
            prev = current;
            current = current.next;
        }
    }
}
