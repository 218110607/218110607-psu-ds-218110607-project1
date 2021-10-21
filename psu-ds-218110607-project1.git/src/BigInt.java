/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class BigInt {
      public boolean positive;
    public static final int blockSize=3;
    public List list;
    public BigInt() {
        this.positive = true;
        this.list=new List();         
    }
    public BigInt(String num) {      
        if(num.charAt(0) == '-')
        {
             this.positive=false;
             num=num.substring(1, num.length());            
        }else{
            this.positive=true;
        }                
        this.list=new List(num);        
    }

   
    public  BigInt add (BigInt bigInt){
        BigInt bigInt3 =new BigInt(); 
        bigInt3.list=new List();                   
        int carry=0;
        Node current1 =this.list.head;
        Node current2 = bigInt.list.head;
        while( current1!= null || current2!= null )
        {
            int step =0 ;
            int block1=0;
            int block2=0;
            int block3=0;
               
            while(step < this.blockSize)
            { 
                if(current1 != null) {
                    block1=  (block1 + current1.digit * (int)Math.pow(10, step));
                    current1=current1.next;
                }                              
                if(current2 != null){
                    block2=  (block2 + current2.digit * (int) Math.pow(10, step));               
                    current2=current2.next;
                }                        
                step++;              
            }
            block3 = block1 + block2 + carry;
            carry = block3 / ((int)Math.pow(10,this.blockSize)); 
          
            block3 = block3 % ((int)Math.pow(10,this.blockSize));        
            bigInt3.list.addBlock(block3,blockSize);         
        }
        if (carry>0)
        {
            bigInt3.list.addBlock(carry,blockSize);
        }
      return bigInt3;
    
    }
    public BigInt subtract(BigInt bigInt){    
        BigInt bigInt3 =new BigInt(); 
        bigInt3.list=new List();       
            
        Node current1 = this.list.head;
        Node current2 = bigInt.list.head;
        int carry=0;
        while( current1!= null || current2!= null)
        {
            int step =0 ;
            int block1=0;
            int block2=0;
            int block3=0;           
            while(step < blockSize){
                if(current1 != null) {
                    block1=  (block1 + current1.digit * (int)Math.pow(10, step));
                    current1=current1.next;
                }                              
                if(current2 != null){
                    block2=  (block2 + current2.digit * (int) Math.pow(10, step));               
                    current2=current2.next;
                }                        
                step++; 
            }
            block3 = block1 - block2;
            if(block3 < 0){
                carry = 1;
            }else{
                carry = 0;
            }                    
            bigInt3.list.addBlock(block3,blockSize);                  
        }  
        if(carry == 1){
            bigInt3.positive=false;
        }
        return bigInt3;
    }
    public int compare(BigInt bigInt)  
    {                       
        if(this.list.size == bigInt.list.size){
            Node current1 = this.list.head;
            Node current2 = bigInt.list.head;
            while( current1!= null && current2!= null){
                    if(current1.digit > current2.digit){
                        return 1;
                    }else if(current1.digit < current2.digit){
                        return -1;
                    }
            }
            return 0;
        }else{
            if(this.list.size > bigInt.list.size){
                return 1;
            }else{
                return -1;
            }
        }
    }
    @Override
    public String toString(){
        String number="";
        if(!this.positive){
            number="-";
        }
        number+=this.list.toString();
        return number;
    }
    
    
}
