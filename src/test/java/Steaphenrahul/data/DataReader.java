package Steaphenrahul.data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

	@SuppressWarnings("deprecation")
	public static List<HashMap<String, String>> getJsonDataToMap() throws IOException {
	
		File file = new File(System.getProperty("user.dir")+"//src//test//java//Steaphenrahul//data//purchaseOrder.json");
	    //Reading Json to string
		String JsonData = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		
		//String JsonData = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Steaphenrahul//data//purchaseOrder.json").StandardCharsets.UTF_8);
		//Convert Json to Hashmap
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(JsonData,new TypeReference<List<HashMap<String, String>>>(){
			
		}); return data ;
	}
}
