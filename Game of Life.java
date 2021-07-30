import java.util.Scanner; 
public class GameOfLife
{
    public static void main(String[] args)
    {
        int x, y, i, j;   
        Scanner sc=new Scanner(System.in);   
        System.out.print("Enter the number of rows: ");   
        x = sc.nextInt();   
        System.out.print("Enter the number of columns: ");   
        y = sc.nextInt();   
        int grid[][] = new int[x][y]; 
        //Please Enter 0 and 1 where 0’s representing the dead cells and 1’s representing alive cells
        System.out.println("Enter the elements of the array: ");   
        for (i = 0; i < x; i++)   
        {
         for (j = 0; j < y; j++)   
             grid[i][j] = sc.nextInt();      
        }
        System.out.println("Original Generation");
        for (i = 0; i < x; i++)
        {
            for (j = 0; j < y; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, x, y);
    }
    static void nextGeneration(int grid[][], int x, int y)
    {
        int[][] t = new int[x][y];
  
        for (int l = 1; l < x- 1; l++)
        {
            for (int m = 1; m < y - 1; m++)
            {
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];
  
                
                aliveNeighbours -= grid[l][x];
  
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    t[l][m] = 0;
  

                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    t[l][m] = 0;
  
        
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    t[l][m] = 1;
  
                else
                    t[l][m] = grid[l][m];
            }
        }
  
        System.out.println("Next Generation");
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                if (t[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
