class MyLinkedList {
    MyLinkedList head;
    MyLinkedList next;
    int val;
    int size;
    public MyLinkedList() {
        head = null;
        next = null;
        val = 0;
        size = 0;
    }
    
    public int get(int index) {
        MyLinkedList temp = head;
        
        if(index < 0 || index >= size){
            return -1;
        }else{
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }

            return temp.val;
        }
    }
    
    public void addAtHead(int val) {
        MyLinkedList newNode = new MyLinkedList();
        newNode.val = val;
        
        newNode.next = head;
        head = newNode;
        
        size++;
    }
    
    public void addAtTail(int val) {
        if(head == null){
            addAtHead(val);
        }else{
            MyLinkedList temp = head;
            MyLinkedList newNode = new MyLinkedList();
            newNode.val = val;
            
            for(int i = 0; i < size - 1; i++){
                temp = temp.next;
            }

            // while(temp.next != null){
            //     temp = temp.next;
            // }

            temp.next = newNode;
            size++;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index == size){
            addAtTail(val);
        }else if(index == 0){
            addAtHead(val);
        }else if(index > 0 && index < size){
            MyLinkedList newNode = new MyLinkedList();
            MyLinkedList temp = head;
            newNode.val = val;
            
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;  
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index == 0){
            head = head.next;
            size--;
        }else if(index > 0 && index < size){
            MyLinkedList temp = head;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            
            MyLinkedList del = temp.next;
            temp.next = del.next;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */