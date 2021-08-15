import java.io.*;

public class MyReadFile {
	public static void main(String args[]){
		try{
			File f = new File("c:/work/test.txt") ;
			
			FileInputStream fis = new FileInputStream(f) ;
			
			int length = fis.available() ;
			for (int i = 0; i < length ; i ++ ) {
				System.out.print((char)fis.read()) ;
			}
		}catch(Exception e){}
	}
}