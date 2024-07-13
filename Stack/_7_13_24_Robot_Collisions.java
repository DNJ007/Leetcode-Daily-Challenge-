import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _7_13_24_Robot_Collisions {
    static class Robot{
        int pos;
        int health;
        char direction;
        int id;

        public Robot(int pos,int health,char direction,int id)
        {
            this.pos = pos;
            this.health = health;
            this.direction = direction;
            this.id = id;
        }
    }
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) 
    {
        Robot[] robots = new Robot[positions.length];

        for(int i = 0;i< robots.length;i++)
        {
            robots[i] = new Robot(positions[i],healths[i],directions.charAt(i),i);
        }

        Arrays.sort(robots,(a,b)->a.pos-b.pos);
        Stack<Robot> s = new Stack<Robot>();

        for(int i=0;i<robots.length;i++)
        {
            Robot curr = robots[i];
            robots[i] = null;

            if(curr.direction == 'L')
            {
                while(!s.isEmpty() && s.peek().direction == 'R' && curr.health > 0)
                {
                    Robot prev = s.pop();
                    int min = Math.min(prev.health, curr.health);
                    if(min != prev.health)
                    {
                        prev.health -= 1;
                        curr.health = 0;
                    }
                    else if(min != curr.health)
                    {
                        curr.health -= 1;
                        prev.health = 0;
                    }
                    else
                    {
                        curr.health = 0;
                        prev.health = 0;
                    }

                    if(prev.health > 0)
                    {
                        s.push(prev);
                    }
                }
            }
            if(curr.health > 0)
            {
                s.push(curr);
            }
        }

        while(!s.isEmpty())
        {
            robots[s.peek().id] = s.pop();
        }

        List<Integer> AL = new ArrayList<Integer>();
        for(int i=0;i<robots.length;i++)
        {
            if(robots[i]!=null)
            {
                AL.add(robots[i].health);
            }
        }

        return AL;
    }

    public static void main(String[] args) {
        int[] positions = {5,4,3,2,1};
        int[] healths = {2,17,9,15,10};
        String directions = "RRRRR";

        System.out.println(survivedRobotsHealths(positions, healths, directions));

    }
}
