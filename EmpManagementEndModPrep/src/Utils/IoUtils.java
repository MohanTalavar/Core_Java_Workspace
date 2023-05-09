package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.app.core.Emp;

import CustionException.EmpExcptionHandling;

public interface IoUtils {
	
	static void storedEmpDetails(String fileName, Map<String,Emp> emps) throws  IOException {
		
		// java app --> oos ---> fos --> bin file
		try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(fileName))){
			out.writeObject(emps);	
		}
		
	}// serialization success!!1
	
	@SuppressWarnings("unchecked")
	static Map<String,Emp> restoreEmpdetails(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		
		// java app <-- ois <-- fis <-- bin file
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename) ))
		{
			
			
			return (Map<String, Emp>) ( in.readObject());  // typecast
		}
//		catch(FileNotFoundException f) {
//			throw new EmpExcptionHandling("File Not Found");
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		return null;
	}// deserialization success
	
	

}
