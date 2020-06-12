package com.elec0021;

public abstract class OrderedList extends List {
    protected abstract int compare(Object obj1, Object obj2);//abstract compare method

    public ListNode find(Object newData) {//find node with data else return null
        ListNode tempNode = this.firstNode;
        while(tempNode != null) {
            if (this.compare(tempNode.data,newData) == 0) {
                return tempNode;
            } else {
                tempNode = tempNode.next;
            }
        }
        return tempNode;
    }

    public boolean insert(Object newData) {//insert node else return false if copy exists
        ListNode newNode = new ListNode();
        if(this.find(newData) != null){
            return false;
        }else{
        if((this.firstNode == null) || (this.compare(newData,this.firstNode.data) < 0)){
            newNode.data = newData;
            newNode.next = this.firstNode;
            firstNode = newNode;
            return true;
        }else{
            ListNode tempNode = new ListNode();
            tempNode = this.firstNode;
            while((tempNode.next != null) && (this.compare(newData,tempNode.next.data) > 0)){
                tempNode = tempNode.next;
            }
            newNode.data = newData;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            return true;
        }
        }
    }
    public ListNode remove(Object remData) {//remove node else return null node if does not exist
        if(find(remData) == null){
            return null;
        }else{
            ListNode tempNode = this.firstNode;
            ListNode prevNode = null;
            ListNode deletedNode = null;
            if(tempNode != null && compare(remData,tempNode.data) == 0){
                deletedNode = this.firstNode;
                this.firstNode = tempNode.next;
                return deletedNode;
            }else{
                while(tempNode != null && this.compare(remData,tempNode.data) != 0){
                    prevNode = tempNode;
                    tempNode = tempNode.next;
                }
                deletedNode = tempNode;
                prevNode.next = tempNode.next;
                return deletedNode;
            }
        }
    }
    public OrderedList(String Olist){
        super(Olist);
    }//constructor sets listname

}

