package readVariableDiffClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropConfigParam {
	
	String url;
	String name;
	String pwd;
	
	public void readProperty(){
	File file=new File("D:\\Padhai\\SeleniumPractice\\SeleniumRebirth\\src\\package2016\\dataFile.properties");
	FileInputStream fin=null;
	try{
		fin=new FileInputStream(file);
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	Properties prop=new Properties();
	try{
		prop.load(fin);
	}catch(IOException ioe){
		ioe.printStackTrace();
	}
	url=prop.getProperty("url");
	name=prop.getProperty("username");
	pwd=prop.getProperty("password");
	
}
}
