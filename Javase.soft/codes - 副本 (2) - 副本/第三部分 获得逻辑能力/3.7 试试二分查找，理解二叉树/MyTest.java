import java.util.*;

public class MyTest {
	public static void main(String[] args) {
		//产生1000个从0到2000之间的随机数
		HashSet<Integer> hs = new HashSet<Integer>() ;
		
		while(hs.size()<1000){
			int value = (int)(Math.random()*2000) ;//生成随机数
			hs.add(value) ;
		}
		
		ArrayList<Integer> al = new ArrayList<Integer>(hs) ;
		
		//排序
		int sort[] = new int[2000] ;
		for(int v : al){
			sort[v] = v ;
 		}
		
		al.clear() ;
		for(int v : sort){
			if(v>0){
				al.add(v) ;
			}
		}
		if(al.size()<1000){
			al.add(0,0) ;
		}
		
		//二分查找
		int des = 876 ;
		
		int minIndex = 0;
		int maxIndex = 999;
		while(true) {
			//计算中间下标值
			int midIndex = (minIndex + maxIndex)/2;
			//找到了
			if(des == al.get(midIndex)) {
				System.out.println("找到了，第"+midIndex+"个数") ;
				break ;
			}
			//找到的值大
			if(des <al.get(midIndex)) {
				maxIndex = midIndex - 1;
			}
			//找到的值小
			if(des > al.get(midIndex)){
				minIndex = midIndex + 1;
			}
			//没找到
			if(minIndex>maxIndex){
				System.out.println("没找到") ;
				break ;
			}
		}
	}
}