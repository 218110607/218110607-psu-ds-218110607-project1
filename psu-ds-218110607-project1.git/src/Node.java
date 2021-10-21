/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macbook
 */
public class Node {
     public int digit;
    public Node next;
    public Node prev;

    public Node() {
        this.digit = 0;
        this.next=null;
        this.prev=null;
    }

    public Node(int digit) {
        this.digit = digit;
        this.next=null;
        this.prev=null;
    }
    
}
