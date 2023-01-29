package practice;

public class OrderedLinkedList<E>
{
	private LinkedListNode<E> head_of_list = null;
	private int count = 0;
	
	public boolean add(E e)
	{
		LinkedListNode<E> newnode = new LinkedListNode();
		newnode.obj = e;

		
		/* Special case for the head end */
        if (head_of_list == null || ((head_of_list.obj.toString()).compareTo(newnode.obj.toString())) > 1)
        { 
            newnode.next = head_of_list; 
            head_of_list = newnode; 
        } 
        else 
        { 
        	LinkedListNode current = head_of_list; 
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.obj.toString().compareTo(newnode.obj.toString()) < 1)  
            { 
                current = current.next; 
            } 
            newnode.next = current.next; 
            current.next = newnode; 
        } 
		
		return false;
	}

	public int size()
	{
		LinkedListNode<E> first = head_of_list;
		int count = 0;
		while (first != null)  
        { 
			count++;
			first = first.next; 
        }
		return count;
	}
	
	public E get(int index)
	{
		LinkedListNode<E> first = head_of_list;
		int curr_index = 0;
		 while (first != null)  
		 {
			 if(index == curr_index)
			 {
				 return first.obj;
			 }
			 else
			 {
				 first = first.next; 
			 }
			 curr_index++;
		 }
		 //throw exception if no match found for given index
		 throw new IndexOutOfBoundsException();
	}
	
	public static void main(String[] args)
    {
		OrderedLinkedList<String> linked = new OrderedLinkedList<>();
        /** A list of most popular north american men names according to some website */
                
        linked.add("James");
        linked.add("David");
        linked.add("Christopher");
        linked.add("George");
        linked.add("Ronald");
        linked.add("John");
        linked.add("Richard");
        linked.add("Daniel");
        linked.add("Kenneth");
        linked.add("Anthony");
        linked.add("Robert");
        linked.add("Charles");
        linked.add("Paul");
        linked.add("Steven");
        linked.add("Kevin");
        linked.add("Michael");
        linked.add("Joseph");
        linked.add("Mark");
        linked.add("Edward");
        linked.add("Jason");
        linked.add("William");
        linked.add("Thomas");
        linked.add("Donald");
        linked.add("Brian");
        linked.add("Jeff");
        
        /** A list of most popular north american women names according to some website */
        
        linked.add("Mary");
        linked.add("Jennifer"); 
        linked.add("Lisa");
        linked.add("Sandra");   
        linked.add("Michelle");
        linked.add("Patricia");
        linked.add("Maria");
        linked.add("Nancy");    
        linked.add("Donna");    
        linked.add("Laura");
        linked.add("Linda");
        linked.add("Susan");
        linked.add("Karen");
        linked.add("Carol");
        linked.add("Sarah");
        linked.add("Barbara");               
        linked.add("Margaret");
        linked.add("Betty");
        linked.add("Ruth");
        linked.add("Kimberly");
        linked.add("Elizabeth");
        linked.add("Dorothy");
        linked.add("Helen");
        linked.add("Sharon");
        linked.add("Deborah");

        /* print the names. Should come out as alphabetical */
        
        for( int i=0; i<linked.size(); i++ )
            System.out.println( i + "\t" + linked.get(i) );
    }
}

class LinkedListNode<E> {
	  
public E obj;
public LinkedListNode<E> next;
}
