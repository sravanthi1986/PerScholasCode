package org.perscholas;
public class SinglyLinkedList
{
    Node head; // head of list
    
    // Linked list Node. 
    // This inner class is made static 
    // so that main() can access it 
    static class Node 
    { 
  
        int data; 
        Node nextNode; 
  
        // Constructor 
        Node(int d) 
        { 
            data = d; 
            nextNode = null; 
        } 
    } 
    public static void main(String[] args)
    {
         /* Start with the empty list. */
        SinglyLinkedList list = new SinglyLinkedList(); 
        
        // Insert the values 
        list = insertnode(list, 1);
        list = insertnode(list, 4); 
            
            
    } //main method 
    
    // Method to insert a new node 
    public static SinglyLinkedList insertnode(SinglyLinkedList list, int data) 
    { 
        // Create a new node with given data 
        Node new_node = new Node(data); 
        new_node.nextNode = null;  
  
        // If the Linked List is empty, 
        // then make the new node as head 
        if (list.head == null)
        { 
            list.head = new_node; 
        } 
        else 
        { 
            // Else traverse till the last node 
            // and insert the new_node there 
            Node last = list.head; 
            while (last.nextNode != null)
            { 
                last = last.nextNode; 
            } 
  
            // Insert the new_node at last node 
            last.nextNode = new_node; 
        } 
  
       // Node currNode = list.head; 
        
        
        // Print the data to verify 
        System.out.println("data " + new_node.data + " ");
   
        // Return the list by head 
        return list; 
    } 
    
    
    
    
} //SinglyLinkedList
