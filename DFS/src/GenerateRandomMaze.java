import java.util.Arrays;

//218 generate random maze
public class GenerateRandomMaze {
    enum Dir{
        NORTH(-1,0),SOUTH(1,0),WEST(0,-1),EAST(0,1);
        int deltaX;
        int deltaY;
        Dir(int x,int y){
            this.deltaX =x;
            this.deltaY =y;
        }
        public int moveX(int x, int times){
            return x+times*deltaX;
        }
        public int moveY(int y,int times){
            return y+times*deltaY;
        }
    }
    public int[][] maze(int n){
        int[][] maze = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(i ==0 &&j ==0){
                    maze[i][j] =0;
                }else{
                    maze[i][j] =1;
                }
            }
        }
        generate(maze,0,0);
        return maze;
    }

    private void generate(int[][] maze, int x, int y) {
        Dir[] dirs = Dir.values();
        shuffle(dirs);
        for(Dir dir:dirs){
            int nextX = dir.moveX(x,2);
            int nextY = dir.moveY(y,2);
            if(isValidWall(maze,nextX,nextY)){
                //only if the cell is a wall means we have not visited before
                //we break the walls through to make is corridors
                maze[dir.moveX(x,1)][dir.moveY(y,1)] =0;
                maze[nextX][nextY] =0;
                generate(maze,nextX,nextY);
            }
        }
    }

    // check if the position(x,y) is within the maze and it is a wall
    private boolean isValidWall(int[][] maze, int x, int y) {
        return x>=0 && x< maze.length && y>=0 && y<maze[0].length && maze[x][y] ==1;
    }

    //get a random order of the directions
    private void shuffle(Dir[] dirs) {
        for(int i = 0;i<dirs.length;i++){
            int index =(int)(Math.random() *(dirs.length-i));
            Dir tmp = dirs[i];
            dirs[i] =dirs[i+index];
            dirs[i+index]=tmp;
        }
    }
    public static void print2D(int mat[][]) {
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

    public static void main(String[] args) {
        GenerateRandomMaze gm = new GenerateRandomMaze();
        int[][] maze=gm.maze(5);
        print2D(maze);
    }
}
