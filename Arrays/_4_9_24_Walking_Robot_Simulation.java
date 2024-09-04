import java.util.HashSet;

public class _4_9_24_Walking_Robot_Simulation 
{
    public static int robotSim(int[] commands, int[][] obstacles) 
    {
        int x = 0, y = 0; 
        int direction = 0;  
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  

        HashSet<String> obstacleSet = new HashSet<>();  
        for (int[] obstacle : obstacles) 
        {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int maxDist = 0;  

         
        for (int command : commands) 
        {
            if (command == -1) 
            {
                direction = (direction + 1) % 4; 
            } 
            else if (command == -2) 
            {
                direction = (direction + 3) % 4; 
            } 
            else 
            {
                int dx = dirs[direction][0];
                int dy = dirs[direction][1];
                for (int i = 0; i < command; i++) 
                {
                    if (!obstacleSet.contains((x + dx) + "," + (y + dy))) 
                    {
                        x += dx;
                        y += dy;
                    } 
                    else 
                    {
                        break; 
                    }
                }
                maxDist = Math.max(maxDist, x * x + y * y);
            }
        }

        return maxDist; 
    }

    public static void main(String[] args) 
    {
        // int[] commands = {-2,8,3,7,-1};
        // int[][]obstacles = {{-4,-1},{1,-1},{1,4},{5,0},{4,5},{-2,-1},{2,-5},{5,1},{-3,-1},{5,-3}};
        // int[] commands = {4,-1,4,-2,4};
        // int[][] obstacles = {{2,4}};

        int[] commands = {7,-2,-2,7,5};
        int[][] obstacles = {{-3,2},{-2,1},{0,1},{-2,4},{-1,0},{-2,-3},{0,-3},{4,4},{-3,3},{2,2}};
        System.out.println(robotSim(commands, obstacles));
        //robotSim(commands, obstacles);

    }
    
}
