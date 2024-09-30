public class _9_30_24_Design_a_Stack_With_Increment_Operation
{
    int maxSize;
    int []stack;
    int i = 0;

    public _9_30_24_Design_a_Stack_With_Increment_Operation(int maxSize) 
    {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    
    public void push(int x) 
    {
        if(i < maxSize)
        {
            stack[i] = x;
            i++;
        }        
    }
    
    public int pop() 
    {
        int val = -1;
        if(i>0)
        {
            val = stack[i-1];
            stack[i-1] = 0;
            i--;
        }
        else if(i == 0)
        {
            return -1;
        }
        return val;
    }
    
    public void increment(int k, int val) 
    {
        if(k>=maxSize)
        {
            for(int j=0;j<stack.length;j++)
            {
                stack[j] += val;
            }
        }
        else
        {
            for(int j=0;j<k;j++)
            {
                stack[j] += val;
            }
        }
    }
    public static void main(String [] args)
    {
        _9_30_24_Design_a_Stack_With_Increment_Operation stk = new _9_30_24_Design_a_Stack_With_Increment_Operation(3); // Stack is Empty []
        stk.push(1);                          // stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        System.out.println(stk.pop());                            // return 2 --> Return top of the stack 2, stack becomes [1]
        stk.push(2);                          // stack becomes [1, 2]
        stk.push(3);                          // stack becomes [1, 2, 3]
        stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
        stk.increment(5, 100);                // stack becomes [101, 102, 103]
        stk.increment(2, 100);                // stack becomes [201, 202, 103]
        System.out.println(stk.pop());                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        System.out.println(stk.pop());                            // return 202 --> Return top of the stack 202, stack becomes [201]
        System.out.println(stk.pop());                            // return 201 --> Return top of the stack 201, stack becomes []
        System.out.println(stk.pop());                            // return -1 --> Stack is empty return -1.
         
    }
}