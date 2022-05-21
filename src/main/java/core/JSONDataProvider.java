package core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static core.Config.ENV;

public class JSONDataProvider {

    private static final String path = "src/test/resources/data";
    private static Reader reader;
    private static Gson gson;   

    public HashMap<String,Map> getAPIData(String testName) throws Exception {
    	Type type = null;    	
		type = new TypeToken<HashMap<String, HashMap<String, Map<String,String>>>>(){}.getType();
        reader = new FileReader(path+"/data.api."+ENV.toLowerCase()+".json");    	
        gson = new Gson();
        Map<String,String> data = gson.fromJson(reader,type);
        return (HashMap<String, Map>) ((HashMap) data).get(testName);
    }
        
    public List<Map<String,String>> getUIData(String testName) throws Exception {
    	reader = new FileReader(path+"/data.ui."+ENV.toLowerCase()+".json"); 
    	gson = new Gson();
        Type type = new TypeToken<HashMap<String, ArrayList<HashMap>>>(){}.getType();
        HashMap<String, ArrayList<HashMap>> testData = gson.fromJson(reader, type);
        ArrayList testDataList = testData.get("testdata");
        for(Object test :  testDataList){
            if(((Map) test).get("testname").equals(testName)){
                return (List<Map<String,String>>) ((Map) test).get("iteration");
            }
        }
        return null;
    }
        
}
