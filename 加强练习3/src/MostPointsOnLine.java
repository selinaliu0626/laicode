import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Point {
  public int x;
  public int y;
  public Point(int x, int y) {
      this.x = x;
      this.y = y;
  }
}
public class MostPointsOnLine {

    public int most(Point[] points) {
        // Write your solution here
        int res =0;
        for (int i = 0; i < points.length; i++) {
            Point seed =points[i];
            int most =0;
            int same = 1;
            int sameX = 0;
            Map<Double,Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(i ==j) continue;;

                if (seed.x == points[j].x && seed.y == points[j].y) {
                    same++;
                } else if (points[j].x == seed.x ) {
                    sameX++;
                } else {
                    double a = Double.valueOf((points[j].y - seed.y) / (points[j].x - seed.x));
                    if (!map.containsKey(a)){
                    map.put(a, 1);
                    }else{
                        map.put(a,map.get(a)+1);
                    }
                    most = Math.max(most, map.get(a));
                }
            }
            most = Math.max(most,sameX)+same;
            res =Math.max(res,most);
        }

        return res;
    }




    public static void main(String[] args) {
        MostPointsOnLine ms =new MostPointsOnLine();
        Point a = new Point(1,1);
        Point b = new Point(2,3);

        Point c = new Point(1,1);


        Point d = new Point(2,3);
        Point e = new Point(1,1);
        Point f = new Point(2,2);
        Point g = new Point(3,4);
        Point h = new Point(9,10);


        Point[]points ={a,b,c,d,e,f,g,h};
        int max = ms.most(points);
        System.out.println(max);
    }
}
