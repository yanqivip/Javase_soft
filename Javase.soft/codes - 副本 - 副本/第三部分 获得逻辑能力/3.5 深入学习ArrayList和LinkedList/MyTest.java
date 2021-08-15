import java.util.*;

public class MyTest {
	public static void main(String[] args) {
		ArrayList al = new ArrayList() ;
		LinkedList ll = new LinkedList() ;
		
		long time = System.currentTimeMillis() ;
		for(int i = 0 ; i < 1000000 ; i ++){
			al.add(i) ;
		}
		time = System.currentTimeMillis() - time ;
		System.out.println("ArrayList添加1000000个值耗时"+time+"毫秒") ;
		
		time = System.currentTimeMillis() ;
		for(int i = 0 ; i < 1000000 ; i ++){
			ll.add(i) ;
		}
		time = System.currentTimeMillis() - time ;
		System.out.println("LinkedList添加1000000个值耗时"+time+"毫秒") ;
		
		//插入1000个值
		time = System.currentTimeMillis() ;
		for(int i = 0 ; i < 1000 ; i ++){
			al.add(1 , i) ;
		}
		time = System.currentTimeMillis() - time ;
		System.out.println("ArrayList插入1000个值耗时"+time+"毫秒") ;
		
		time = System.currentTimeMillis() ;
		for(int i = 0 ; i < 1000 ; i ++){
			ll.add(1 , i) ;
		}
		time = System.currentTimeMillis() - time ;
		System.out.println("LinkedList插入1000个值耗时"+time+"毫秒") ;
	}
}