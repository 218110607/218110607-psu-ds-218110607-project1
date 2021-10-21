/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class List {
    public Node head;
    public Node tail;
    public int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    //constracture take number as string and buils list of its digits
    public List(String number)
    {        
        for (int i = 0; i < number.length(); i++) {
            char ch=number.charAt(i);
            int digit=0;
            if (Character.isDigit(ch)) 
            { 
                 digit = Character.getNumericValue(ch);
            }                           
            insertFirst(digit);                                   
        }
    }

    public void addBlock(int num,int blockSize)
    {            
        String number= String.valueOf(Math.abs(num));
         if (number.length() < blockSize){            
             int numberOfZero=  - number.length();
             for (int i = 0; i < numberOfZero; i++) {                
                 number="0"+number;
             }
         }
        for (int i = number.length()-1 ; i >= 0; i--) {
            char ch=number.charAt(i);
            int digit=0;
            if (Character.isDigit(ch)) 
            { 
                 digit = Character.getNumericValue(ch);
            }                             
            insertLast(digit);                                   
        }
    }
   
    public void insertFirst(int digit)
    {
        Node tmp= new Node(digit);
        if(size==0){
            this.tail=tmp;
            this.head=tmp;
        }else{
            tmp.next=this.head;
            this.head.prev=tmp;
            this.head=tmp;
        }
      
        size++;
    }
  
    public void insertLast(int digit)
    {
        Node tmp= new Node(digit);
        if(size==0){
            this.tail=tmp;
            this.head=tmp;
        }else{
            tmp.prev=this.tail;
            this.tail.next=tmp;
            this.tail=tmp;
        }
      
        size++;
    }
   
   

    @Override
    public String toString(){
        String number="";
        Node current=this.tail;
        while (current != null) {
            number+=Integer.toString(current.digit);
            current=current.prev;
        }
        return number;        
    }
   
    
}
