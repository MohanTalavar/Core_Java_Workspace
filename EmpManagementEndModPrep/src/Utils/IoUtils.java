package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.app.core.Emp;

public interface IoUtils {
	
	static void storedEmpDetails(String fileName, Map<String,Emp> emps) throws  IOException {
		
		// java app --> oos ---> fos --> bin file
		try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(fileName))){
			out.writeObject(emps);	
		}
		
	}// serialization success!!1
		
	@SuppressWarnings("unchecked")
	static Map<String,Emp> restoreEmpdetails1(String filename){
		
		// deser strm :  Java app <-- OIs <-- fis <-- bin file
		
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
			// deser
			return (Map<String, Emp>) in.readObject();
			
		}catch (Exception e) {
			System.out.println("err during de-serial "+ e);
			return new HashMap<>();
		}
		
	}// end of api
}
