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
		
		//冒泡排序
		boolean change = true ;
		while(change){
			//如果下面的交换没有执行，change就是false，循环结束
			change = false ;
			for(int i = 0 ; i < al.size()-1 ; i ++){
				if(al.get(i)>al.get(i+1)){
					//交换
					int tmp = al.get(i) ;
					al.set(i, al.get(i+1)) ;
					al.set(i+1, tmp) ;
					//因为有交换了，所以还要再循环一遍
					change = true ;
				}
			}
		}
		//验证
		for(int v : al){
			System.out.print(v+"\t") ;
 		}
	}
}