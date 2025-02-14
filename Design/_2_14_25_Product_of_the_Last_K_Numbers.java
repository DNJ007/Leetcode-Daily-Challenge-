import java.util.*;
public class _2_14_25_Product_of_the_Last_K_Numbers 
{
    public List<Integer> Al = new ArrayList<>();
    public int size = 0;
    public _2_14_25_Product_of_the_Last_K_Numbers () 
    {
        this.Al.add(1);
        this.size=0;
    }
    
    public void add(int num) {
        if(num == 0)
        {
            this.Al = new ArrayList<>();
            this.Al.add(1);
            this.size = 0;
        }
        else
        {
            this.Al.add(this.Al.get(size)*num);
            this.size++;
        }
    }
    
    public int getProduct(int k) {
        if(k > this.size) return 0;

        return(this.Al.get(this.size) / this.Al.get(this.size-k));
    }
    public static void main(String[] args) {
        _2_14_25_Product_of_the_Last_K_Numbers productOfNumbers = new _2_14_25_Product_of_the_Last_K_Numbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [0] (resets)
        productOfNumbers.add(2);        // [2]
        productOfNumbers.add(5);        // [2,5]
        productOfNumbers.add(4);        // [2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // 5 * 4 = 20
        System.out.println(productOfNumbers.getProduct(3)); // 2 * 5 * 4 = 40
        System.out.println(productOfNumbers.getProduct(4)); // 0 (since we reset on zero)
        productOfNumbers.add(8);
    }
}
