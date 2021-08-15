import java.io.*;

public class MyReadFile {
	public static void main(String args[]){
		try{
			File inFile = new File("C:/work/test.txt") ;
			File outFile = new File("c:/work/test1.txt") ;
			
			FileReader fr = new FileReader(inFile) ;
			BufferedReader br = new BufferedReader(fr) ;
			
			FileWriter fw = new FileWriter(outFile) ;
			PrintWriter pw = new PrintWriter(fw) ;
			
			while(br.ready()){
				pw.println(br.readLine()) ;
			}
			
			pw.close() ;
		}catch(Exception e){}
	}
}