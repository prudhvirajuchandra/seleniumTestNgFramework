package prudhvi.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	@SuppressWarnings("deprecation")
	public  List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//json to string
		
		String Jsoncontent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//prudhvi//data/PurchaseOrder.json"));
	
	//String to Hashmap using jackson databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(Jsoncontent, new TypeReference<List<HashMap<String, String>>>(){});
	
		return data ;
	}
	

}
