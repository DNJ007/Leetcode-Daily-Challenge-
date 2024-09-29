import java.util.*;

class _9_29_24_All_O_one_Data_Structure
{
    class Node{
        int count;
        List<String> keys = new ArrayList<>();

        Node prev;
        Node next;

        Node(int c)
        {
            count = c;
            prev = null;
            next = null;
        }
    };

    HashMap<String,Node> mp;
    Node head;  //head->next will point to min key string
    Node last; // to point max key string

    public _9_29_24_All_O_one_Data_Structure() 
    {
        mp = new HashMap<>();
        head = new Node(0); 
        last = head;       
    }

    void addNode(Node prevNode,int count)
    {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;

        if(newNode.next != null)
        {
            newNode.next.prev = newNode;
        }

        prevNode.next = newNode;
        if(prevNode == last)
        {
            last = newNode;
        }

    }

    void removeNode(Node node)
    {
        node.prev.next = node.next;

        if(node.next != null)
        {
            node.next.prev = node.prev;
        }

        if(last == node)
        {
            last = node.prev;
        }

        //delete node;
    }
    
    
    public void inc(String key) 
    {
        if(!mp.containsKey(key)) // key not exists
        {
            if(head.next == null || head.next.count != 1)
            {
                addNode(head, 1);
            }
            head.next.keys.add(key);
            mp.put(key, head.next);
        }
        else // key exists in map
        {
            Node currNode = mp.get(key);
            int currCount = currNode.count;
            if(currNode.next == null || currNode.next.count != currCount+1)
            {
                addNode(currNode, currCount+1);
            }

            currNode.next.keys.add(key);
            mp.put(key, currNode.next);
            currNode.keys.remove(key);

            if(currNode.keys.isEmpty())
            {
                removeNode(currNode);
            }
        }
    }
    
    public void dec(String key) 
    {
        if (!mp.containsKey(key)) return;

        Node currNode = mp.get(key);
        int currCount = currNode.count;  

        //Remove the key if count becomes zero
        if(currCount == 1)
        {
            mp.remove(key);
        }
        else
        {
            if(currNode.prev.count != currCount-1)
            {
                addNode(currNode.prev, currCount - 1);
            }
            currNode.prev.keys.add(key);
            mp.put(key,currNode.prev);
        }   

        currNode.keys.remove(key);

        if(currNode.keys.isEmpty())
        {
            removeNode(currNode);
        }
    }
    
    public String getMaxKey() 
    {
        if(last == head)
        {
            return "";
        }
        return last.keys.get(0);
    }
    
    public String getMinKey() 
    {
        if(head.next == null)
        {
            return "";
        }

        return head.next.keys.get(0);
        
    }

    public static void main(String[] args) 
    {
        _9_29_24_All_O_one_Data_Structure ds = new _9_29_24_All_O_one_Data_Structure();
        ds.inc("hello");
        ds.inc("hello");
        System.out.println(ds.getMaxKey()); // return "hello"
        System.out.println(ds.getMinKey()); // return "hello"
        ds.inc("leet");
        System.out.println(ds.getMaxKey()); // return "hello"
        System.out.println(ds.getMinKey()); // return "leet"
                
    }
}
