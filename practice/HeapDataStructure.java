package practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HeapDataStructure<T extends Comparable<T>> implements Heap
{
	private T[] elements;
	private int size;
	private int capacity;

	public HeapDataStructure()
	{
		this(10);
	}

	public HeapDataStructure(int capacity)
	{
		this.capacity = capacity;
		size = 0;
		elements = (T[]) new Comparable[this.capacity];
	}
	
	public HeapDataStructure(T[] hT)
	{
		this.capacity = hT.length;
		size = 0;
		heapify(hT, size);
		elements = hT;
	}
	
	@Override
	public int size()
    {
        return size;
    }

	@Override
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
	@Override
	public void insert(Comparable item)
	{
        if(size() >= capacity)
        {
    		System.out.println("Heap is full");
    		expand();
        }
        elements[size++] = (T) item;
        bubbleUp();
		
	}

	public void expand() 
	{
		//create the temp array of size tempSize  
		T[] temp = (T[]) Array.newInstance(elements[0].getClass(), elements.length * 2);
		System.arraycopy(elements, 0, temp, 0, elements.length);
		elements = temp;
	}
	
	@Override
    public String toString()
    {
         return Arrays.stream(elements)
                 .filter(element -> element != null)
                 .collect(Collectors.toList()).toString();
    }
	
	private void bubbleUp()
    {
        int child = size() - 1;
        int parent = (child-1)/2;

        while(parent >= 0 && elements[child].compareTo(elements[parent]) < 0)
        {
            swap(child, parent);
            child = parent;
            parent = (child-1)/2;
        }
    }
    
	@Override
	public Comparable deleteMin()
	{
		if(isEmpty()) System.out.println("Empty heap");
        T root = elements[0];
        swap(size()-1, 0);
        elements[size()-1] = null;
        size--;
        bubbleDown();
        return root;
	}

	private void bubbleDown()
    {
		int parent = 0;
        int leftChild = 2*parent + 1;
        int rightChild = 2*parent + 2;

        int choice = compareAndPick(leftChild, rightChild);

        while(choice != -1)
        {
            swap(choice, parent);
            parent = choice;
            choice = compareAndPick(2*choice+1, 2*choice+2);
        }
    }
	
	 private int compareAndPick(int leftChild, int rightChild)
	    {
	        if(leftChild >= capacity || elements[leftChild] == null) return -1;
	       if((elements[leftChild].compareTo(elements[rightChild]) <= 0)|| (elements[rightChild] == null))
	            return leftChild;
	        return rightChild;
	    }
	
    private void swap(int child, int parent)
    {
        T t = elements[child];
        elements[child] = elements[parent];
        elements[parent] = t;
    }
    
    void heapify(T[] hT, int i)
    {
        int size = hT.length;
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && hT[l].compareTo(hT[largest]) > 1)
          largest = l;
        if (r < size && hT[r].compareTo(hT[largest]) > 1)
          largest = r;

        if (largest != i)
        {
          T temp = hT[largest];
          hT[largest] = hT[i];
          hT[i] = temp;

          heapify(hT, largest);
        }
    }
    
    void printHeap() 
    { 
        for (int i=0; i<elements.length; ++i)
        {
        	System.out.println(elements[i].toString());
        }
    }
}
