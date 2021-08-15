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
		//循环结束的结果是sort数组中存入了1000个随机数和1000个0
		for(int v : al){
			sort[v] = v ;//利用数组下标的位置性
 		}
		
		al.clear() ;
		for(int v : sort){
			//将0剔除，其余的数字重新存回al
			if(v>0){
				al.add(v) ;
			}
		}
		//万一生成的随机数有0，这个0会被不小心剔除，
	//这样size就不够1000了，我们将0加回去
		if(al.size()<1000){
			al.add(0,0) ;
		}

		//验证
		for(int v : al){
			System.out.print(v+"\t") ;
 		}
	}
}