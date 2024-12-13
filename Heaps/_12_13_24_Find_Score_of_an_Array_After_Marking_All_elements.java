import java.util.*;
public class _12_13_24_Find_Score_of_an_Array_After_Marking_All_elements
{
    static class Element implements Comparable<Element>
    {
        int num;
        int idx;

        Element(int num,int idx)
        {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Element e2)
        {
            if(this.num == e2.num)
            {
                return Integer.compare(this.idx,e2.idx);
            }           
            return Integer.compare(this.num,e2.num);
        }
    }

    public static long findScore(int[] nums) 
    {
        PriorityQueue<Element> pq = new PriorityQueue<>();
        boolean[] mark = new boolean[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            pq.add(new Element(nums[i],i));
        }

        long score = 0;
        while(!pq.isEmpty())
        {
            Element e = pq.poll();
            int idx = e.idx;

            if(!mark[idx])
            {
                score += e.num;                      

                mark[idx] = true;

                if(idx == 0 && nums.length >1)
                    mark[1] = true;
                else if(idx == nums.length-1 && nums.length >1)
                    mark[idx-1] = true;
                else
                {
                    if(nums.length >1)
                    {
                        mark[idx+1] = true;
                        mark[idx-1] = true;
                    }                    
                }         
            }
        }

        return score;

        
    }
    public static void main(String [] args)
    {
        int[] nums = {2,1,3,4,5,2};
        System.out.println(findScore(nums)); 
    }
}