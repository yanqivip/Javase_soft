/***************************
 * 加密
 **************************/
import java.io.*;

public class MyEncryp {

	public static void main(String[] args) {
		try {
			//读密钥文件
			int key[] = new int[128] ;
			File keyFile = new File("c:/work/key.key") ;
			
			FileInputStream keyFis = new FileInputStream(keyFile) ;
			
			for (int i = 0; i < 128; i++) {
				key[i] = keyFis.read() ;
			}
			
			//加密
			File inFile = new File("c:/work/test.txt") ;
			File outFile = new File("c:/work/test1.txt") ;
			
			FileInputStream fis = new FileInputStream(inFile) ;
			FileOutputStream fos = new FileOutputStream(outFile) ;
			
			int length = fis.available() ;
			for (int i = 0; i < length; i++) {
				fos.write(fis.read()+key[i%128]) ;
			}
		} catch (Exception e) {}
	}
}