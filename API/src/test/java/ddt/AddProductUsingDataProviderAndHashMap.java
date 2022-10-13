package ddt;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.ExcelUtility;

import static io.restassured.RestAssured.*;

public class AddProductUsingDataProviderAndHashMap {
	
	ExcelUtility eLib=new ExcelUtility();
	LinkedHashMap m;
	
	@Test(dataProvider="getDataFromMap")
	public void addProduct() {
	
		
		
	}
	
	@DataProvider
	public  LinkedHashMap getDataFromMap() throws EncryptedDocumentException, IOException {
		LinkedHashMap map=new LinkedHashMap();
		map.put(eLib.getDataFromExcel("Sheet3", 0, 0), eLib.getDataFromExcel("Sheet3", 1, 0));
		map.put(eLib.getDataFromExcel("Sheet3", 0, 1), eLib.getDataFromExcel("Sheet3", 1, 1));
		map.put(eLib.getDataFromExcel("Sheet3", 0, 2), eLib.getDataFromExcel("Sheet3", 1, 2));
		map.put(eLib.getDataFromExcel("Sheet3", 0, 3), eLib.getIntDataFromExcel("Sheet3", 1, 3));
		
		return map;
	}
		
		
		
		
	}


