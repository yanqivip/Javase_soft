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
		ArrayList<Integer> sort = new ArrayList<Integer>() ; 
		while(al.size()>0){
			//寻找最小值
			int minValue = 2001 ;
			for(int v : al){
				if(minValue>v){
					minValue = v ;
				}
			}
			//将剩下的最小值存入sort
			sort.add(minValue) ;
			//将取走的值从al中删除掉，由于al.remove方法重载了两次，
			//一个是接收int参数，删除指定下标的值，一个是接收Object
			//参数，删除指定对象，我们遇到的问题，我们的值也是int，
			//直接删除值会被系统误认为提供的是下标，所以将值包装成对象
			al.remove(new Integer(minValue)) ;
		}
		//验证
		for(int v : sort){
			System.out.print(v+"\t") ;
 		}
	}
}