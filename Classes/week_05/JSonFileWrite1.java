import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JSonFileWrite1 {
 
public static void main (String args[]) throws JSONException
{
String fileName="test.json";
jsonFileWrite(fileName);
jsonFileRead(fileName);
}
 
//writing JSON
public static void jsonFileWrite(String fileName) throws JSONException {
 
    JSONObject allEmps=new JSONObject();
    JSONArray empArray=new JSONArray();
    JSONObject empObj;
    JSONArray phoneNumbers =null;
    JSONObject phoneObj;
 
    empObj = new JSONObject();
    empObj.put("Name", "ABC");
    empObj.put("Designation", "Manager");
    empObj.put("Pay", "Rs. 60000/-");
 
    phoneNumbers= new JSONArray();
    phoneObj=new JSONObject();
    phoneObj.put("LandLine", "11-2xxxx99");
    phoneObj.put("Mobile", "99xxxxxx11");
    phoneNumbers.put(phoneObj);
 
    empObj.put("PhoneNumbers", phoneNumbers);
    empArray.put(empObj);
 
    empObj = new JSONObject();
    empObj.put("Name", "ABC");
    empObj.put("Designation", "Sr.Manager");
    empObj.put("Pay", "Rs. 60000/-");
 
    phoneNumbers= new JSONArray();
    phoneObj=new JSONObject();
    phoneObj.put("LandLine", "12-2xxxx129");
    phoneObj.put("Mobile", "45xxxxxx11");
    phoneNumbers.put(phoneObj);
 
    empObj.put("PhoneNumbers", phoneNumbers);
    empArray.put(empObj);
    allEmps.put("Employees", empArray);

try {
// Writing to a file
    FileWriter file = new FileWriter(fileName);
    file.write(allEmps.toString());
    file.flush();
    file.close();
 
    System.out.println("JSon file created"); }
    catch (IOException e) {
        e.printStackTrace();
    }
}
//reading JSON
public static void jsonFileRead(String fileName) throws JSONException {
    try {
 
        Scanner scanner = new Scanner( new File(fileName) );
        String jsonString = scanner.useDelimiter("\\A").next();
        scanner.close();
        System.out.println("jsonString =" + jsonString);
        JSONObject empObj = new JSONObject();
        JSONObject phoneObj = new JSONObject();
        JSONObject jsonObject = new JSONObject(jsonString);
 
        JSONArray jsonArray= jsonObject.getJSONArray("Employees");
 
        for (int j=0; j<jsonArray.length();j++) {
            empObj =jsonArray.getJSONObject(j);
            String nameOfCountry = (String) empObj.get("Name");
            System.out.println("Name : "+nameOfCountry);
 
            String population = (String) empObj.get("Designation");
            System.out.println("Designation: "+population);
 
            System.out.println("Phone Numbers are :");
            JSONArray phoneNumbers = (JSONArray) empObj.get("PhoneNumbers");
            for (int i=0; i<phoneNumbers.length();i++) {
                phoneObj=phoneNumbers.getJSONObject(i);
                System.out.println(" Land Line " + phoneObj.get("LandLine"));
                System.out.println(" Mobile " + phoneObj.get("Mobile"));
            }
 
        }
 
    }
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
 
}
 
}