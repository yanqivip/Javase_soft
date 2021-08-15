import java.io.*;

public class MyReadFile {
	public static void main(String args[]){
		try{
			File inFile = new File("c:/work/test.txt") ;
			File outFile = new File("c:/work/test1.txt") ;
			
			FileInputStream fis = new FileInputStream(inFile) ;
			FileOutputStream fos = new FileOutputStream(outFile) ;
			
			int length = fis.available() ;
			for (int i = 0; i < length ; i ++ ) {
				fos.write(fis.read()) ;
			}
		}catch(Exception e){}
	}
}