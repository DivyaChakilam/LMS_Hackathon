package lms.hackathon.ui.utilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class FilloExcel {
	
	public static Connection connection;
	
	public FilloExcel() {
	}
	public static List<Map<String,String>> getData(String fileName, String sheetName,String runType) {
		
		List<Map<String,String>> dataMapList = new ArrayList<Map<String,String>>();
		Map<String,String> dataMap = new HashMap<String,String>();
		Fillo fillo = new Fillo();
		//String query = String.format("Select * from %s Where run = '%s'", sheetName, runType);
		String query = String.format("Select * from %s Where run like '%s'", sheetName, runType);

		//String multiRun= "skip%";
		//String query = String.format("Select * from %s Where run like '%s'", sheetName, multiRun);

		try {
			connection = fillo.getConnection(fileName);
			Recordset recordSet = connection.executeQuery(query);

			while(recordSet.next()) {
				dataMap = new HashMap<String,String>();
				for(String field: recordSet.getFieldNames()) {
					dataMap.put(field, recordSet.getField(field));
				}
				dataMapList.add(dataMap);
			}
		}catch(Exception e) {
			System.out.println("Error in FilloExcel\n"+e);
		}	
		return dataMapList;
	}
	public static Map<String,String> getSingleData(String fileName, String sheetName,String runType) {
		Map<String,String> dataMap = new HashMap<String,String>();
		Fillo fillo = new Fillo();
		String query = String.format("Select * from %s Where run = '%s'", sheetName, runType);
		try {
			connection = fillo.getConnection(fileName);
			Recordset recordSet = connection.executeQuery(query);

			while(recordSet.next()) {
				for(String field: recordSet.getFieldNames()) {
					dataMap.put(field, recordSet.getField(field.trim()));
				}
			}
		}catch(Exception e) {
			System.out.println("Error in FilloExcel\n"+e);
		}	
		return dataMap;

		
	}
		
	

}