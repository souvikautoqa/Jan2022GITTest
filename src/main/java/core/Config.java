package core;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	
	private static Properties prop;
	private static FileInputStream fs;
    public static String ENV = System.getenv("env");
    private static final String path = "src/test/resources/config";
    
    public static void initProperties(String envName) {
		try {
			prop = new Properties();
			fs = new FileInputStream(new File(path+"/"+envName.toLowerCase()+".properties"));
			prop.load(fs);
			System.out.println();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    
    public static String getProperty(String key) {
		if(prop.containsKey(key)) {
			return prop.getProperty(key);
		}
		return null;
	}
    
}
