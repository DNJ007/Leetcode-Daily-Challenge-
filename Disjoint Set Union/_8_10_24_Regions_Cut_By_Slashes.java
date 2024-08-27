public class _8_10_24_Regions_Cut_By_Slashes
{
    static class DSU
    {
        int[] root;
        int count;

        public DSU(int n)
        {
            root = new int[(n+1)*(n+1)];
            count = 1;

            for(int i=0;i<=n;i++)
            {
                for(int j=0;j<=n;j++)
                {
                    int num = i * (n + 1) + j;

                    if(i == 0 || j == 0 || i == n || j == n)
                    {
                        root[num] = 0;
                    }
                    else
                    {
                        root[num] = num;
                    }
                }
            }
        }    

        public int find(int x)
        {
            if(root[x] != x)
            {
                root[x] = find(root[x]);
            }
            return root[x];
        }

        public void union(int x,int y)
        {
            int rootX = find(x);
            int rootY = find(y);

            if(rootX == rootY)
            {
                count++;
                return;

            }
            root[rootY] = rootX;
        }
    }
    
    
    public static int regionsBySlashes(String[] grid) 
    {
        int n = grid.length;
        DSU dsu = new DSU(n);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                char c = grid[i].charAt(j);

                if(c == '/')
                {
                    int x = i * (n + 1) + j + 1;
                    int y = (i + 1) * (n + 1) + j;

                    dsu.union(x,y);
                }
                else if(c == '\\')
                {
                    int x = i * (n + 1) + j;
                    int y = (i + 1) * (n + 1) + j + 1;

                    dsu.union(x,y);
                }
            }            
        }
        return dsu.count;
    }
    public static void main(String [] args)
    {
        String[] grid = {"/\\","\\/"};
        System.out.println(regionsBySlashes(grid)); 
    }
}
