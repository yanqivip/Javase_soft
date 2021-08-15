import java.util.*;

public class MyTest {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>() ;
		
		//虽然明确1000个值，但是不能用for循环，
		//因为一旦有重复值就会浪费一次循环，
		//所以很有可能循环次数大于1000
		while(al.size()<1000){
			int value = (int)(Math.random()*2000) ;//生成随机数
			//多次使用的判断有没有的算法
			boolean b = true ;
			for(int v : al){//用这个循环方便多了
				if(value==v){
					b = false ;
					break ;
				}
			}
			if(b){
				al.add(value) ;
			}
		}
		
		//验证
		for(int v : al){
			System.out.print(v+"\t") ;
 		}
	}
}