import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 假设停车场是一个2d的坐标系
//x,y存储了n个汽车的x轴和y轴的坐标
//fuel cost =abs(x2-x1)+abs(y2-y1)
//x2,y2表示停好车的位置
//所有的车必须停成一条直线平行于x轴
//求最少的燃油消耗
//example x=[1,4],y=[1,4]  return 5;
public class MinimumCostForParking {
    public long  leastFuel(List<Integer>x, List<Integer> y){
        //sort first
        Collections.sort(x);
        Collections.sort(y);

        int size=x.size();
        int mid =size/2;
        int medianY=y.get(mid);
        long cost=0;
        for(int i =0;i<size;i++){
            cost+=Math.abs(y.get(i)-medianY);
            //X is different
            x.set(i,x.get(i)-i);
        }
        Collections.sort(x);
        int medianX=x.get(mid);
        for(int i =0;i<size;i++){
            cost+=Math.abs(x.get(i)-medianX);
        }
        return cost;
    }

    public static void main(String[] args) {
        MinimumCostForParking mf = new MinimumCostForParking();
        List<Integer> x = new ArrayList<>();
        x.add(4);
        x.add(6);
        x.add(4);
        x.add(-4);
        x.add(1);
        List<Integer> y = new ArrayList<>();
        y.add(-1);
        y.add(1);
        y.add(-5);
        y.add(-4);
        y.add(5);
        long res =mf.leastFuel(x,y);
        System.out.println(res);
    }
}
