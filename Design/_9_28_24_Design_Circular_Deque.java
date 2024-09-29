public class _9_28_24_Design_Circular_Deque
{
    int maxsize;
    int size = 0;
    int front = 0;
    int[] deque;

    public _9_28_24_Design_Circular_Deque(int k) 
    {
        deque = new int[k];
        maxsize = k;
    }
    
    public boolean insertFront(int value) 
    {
        if(!isFull())
        {
            front = (front-1+maxsize) % maxsize;
            deque[front] = value;
            size++;  
            return true;
        }    
        return false;         
    }
    
    public boolean insertLast(int value) 
    {
         if(!isFull())
        {
            int rear = (front + size) % maxsize;
            deque[rear] = value;
            size++;  
            return true;
        }    
        return false;
    }
    
    public boolean deleteFront() 
    {
        if(!isEmpty())
        {
            front = (front + 1) % maxsize;
            size--;
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() 
    {
        if(!isEmpty())
        {
            size--;
            return true;
        }
        return false;
    }
    
    public int getFront() 
    {
        if(!isEmpty())
        {
            return deque[front];            
        }
        return -1;
    }
    
    public int getRear() 
    {
        if(!isEmpty())
        {
            return deque[(front+size-1) % maxsize];            
        }
        return -1;
    }
    
    public boolean isEmpty() 
    {
        return size == 0;
    }
    
    public boolean isFull() 
    {
        return size == maxsize;        
    }
    public static void main(String [] args)
    {
         _9_28_24_Design_Circular_Deque circularDq = new _9_28_24_Design_Circular_Deque(3);
         System.out.println(circularDq.insertLast(1));
         System.out.println(circularDq.insertLast(2));
         System.out.println(circularDq.insertFront(3));
         System.out.println(circularDq.insertFront(4));
         System.out.println(circularDq.getRear());
         System.out.println(circularDq.isFull());
         System.out.println(circularDq.deleteLast());
         System.out.println(circularDq.insertFront(4));
         System.out.println(circularDq.getFront());
    }
}