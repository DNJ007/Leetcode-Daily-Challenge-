import java.util.*;

public class _2_8_25_Design_a_Number_Container_System 
{
    static Map<Integer,TreeSet<Integer>> numberToIndices;
    static Map<Integer,Integer> indexToNumbers;

    public _2_8_25_Design_a_Number_Container_System() 
    {
        numberToIndices = new HashMap<>();
        indexToNumbers = new HashMap<>();
    }
    
    public void change(int index, int number) 
    {
        if(indexToNumbers.containsKey(index))
        {
            int previousNumber = indexToNumbers.get(index);
            numberToIndices.get(previousNumber).remove(index);

            if(numberToIndices.get(previousNumber).isEmpty())
            {
                numberToIndices.remove(previousNumber);
            }
        }

        indexToNumbers.put(index,number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }
    
    public int find(int number) 
    {
        if(numberToIndices.containsKey(number))
        {
            return numberToIndices.get(number).first();
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        _2_8_25_Design_a_Number_Container_System nc = new _2_8_25_Design_a_Number_Container_System();
        System.out.println(nc.find(10)); // There is no index that is filled with number 10. Therefore, we return -1.
        nc.change(2, 10); // Your container at index 2 will be filled with number 10.
        nc.change(1, 10); // Your container at index 1 will be filled with number 10.
        nc.change(3, 10); // Your container at index 3 will be filled with number 10.
        nc.change(5, 10); // Your container at index 5 will be filled with number 10.
        System.out.println(nc.find(10)); // Number 10 is at the indices 1, 2, 3, and 5. Since the smallest index that is filled with 10 is 1, we return 1.
        nc.change(1, 20); // Your container at index 1 will be filled with number 20. Note that index 1 was filled with 10 and then replaced with 20. 
        System.out.println(nc.find(10)); // Number 10 is at the indices 2, 3, and 5. The smallest index that is filled with 10 is 2. Therefore, we return 2.


        
    }
    
}
