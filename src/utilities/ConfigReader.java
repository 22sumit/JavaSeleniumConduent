package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ConfigReader {
	
	Properties prop;
	@Test
	public ConfigReader() throws IOException {
		File file=new File("./config.properties");
		FileInputStream fin=new FileInputStream(file);
		prop=new Properties();
		prop.load(fin);
	}
	
	@Test
	public String getChromePath(){
		String path=prop.getProperty("chromedriver");
		return path;
	}

}
