import java.io.*;

public class MyReadFile {
	public static void main(String args[]){
		try{
			File inFile = new File("C:/Java/jdk1.6.0/src.zip") ;
			File outFile = new File("c:/work/src.zip") ;
			
			FileInputStream fis = new FileInputStream(inFile) ;
			FileOutputStream fos = new FileOutputStream(outFile) ;
			
			byte[] tmp = new byte[8192] ;
			//����󲿷�����
			int length = fis.available()/8192 ;
			for (int i = 0; i < length ; i ++ ) {
				fis.read(tmp) ;
				fos.write(tmp) ;
			}
			//�������ʣ�µ�����
			int size = fis.read(tmp) ;
			fos.write(tmp, 0, size) ;
		}catch(Exception e){}
	}
}