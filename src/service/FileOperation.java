package service;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileOperation {
	
	public void saveData(Object obj){
		
		try{
			File file=new File("localityInfo.txt");
			FileWriter fw=new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw= new BufferedWriter(fw);
			bw.write(obj.toString());
			bw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
