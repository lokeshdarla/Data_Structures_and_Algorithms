import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinSteps {

  static boolean isValid(int x, int y, boolean[][] visited, int bx, int by) {
    return x >= 0 && x < 8 && y >= 0 && y < 8
        && !visited[x][y]
        && !(x == bx && y == by)
        && !isUnderBishopAttack(x, y, bx, by);
  }

  static int minSteps(int kx, int ky, int bx, int by, int dx, int dy) {
    int [][] knightMoves={
      {1,2},{-1,2},{-1,-2},{1,-2},
      {2,1},{2,-1},{-2,-1},{-2,1}
    }
    boolean [][] visited=new boolean[8][8];
    for(int i=0;i<8;i++){
      Arrays.fill(visited[i],false);
    }

    visited[kx][ky]=true;
    Queue<int []>queue=new LinkedList<>();
    queue.offer({kx,ky,0});
    while(!queue.isEmpty()){
      int []current=queue.poll();
      int x = current[0];
            int y = current[1];
            int steps = current[2];
      if(x==dx&& y==dy){
        return steps;
      }

      for(int move[]:moves){
        int newX=x+move[0];
        int newY=y+move[1];
        if(isValid(newX, newY, visited, bx, by)){
          visited[newX][newY]=true;
          queue.offer({newX,newY,steps+1});
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
