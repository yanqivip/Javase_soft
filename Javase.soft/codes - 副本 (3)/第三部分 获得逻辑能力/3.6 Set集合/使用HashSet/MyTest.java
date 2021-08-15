import java.util.*;

public class MyTest {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>() ;
		
		while(hs.size()<1000){
			int value = (int)(Math.random()*2000) ;//生成随机数
			hs.add(value) ;
		}
		//直接使用hs来创建al
		ArrayList<Integer> al = new ArrayList<Integer>(hs) ;
		
		//验证
		for(int v : al){
			System.out.print(v+"\t") ;
 		}
	}
}