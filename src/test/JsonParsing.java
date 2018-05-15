package test;

import java.io.File;
import java.io.IOException;

// import org.openqa.selenium.json.Json;

import java.util.HashMap;

import com.jayway.jsonpath.JsonPath;

public class JsonParsing {

	
	public void printObject() {
		
		JsonParsing json = new JsonParsing();
		System.out.println(json);
	}
	
	public static void main(String args[]) throws IOException {
		
		File jsonFile = new File("C://Users//20446583//workspace//test//src//test//objectRepository.json");
		//File jsonFile = new File("C://Users//20446583//DLMProject//src//main//java//resources//objectRepository.json");
		HashMap<String, String> protocolFeature = new HashMap<String, String>();
		protocolFeature = JsonPath.read(jsonFile, "$.");
		System.out.println(protocolFeature);
//		System.out.println(protocolFeature.keySet());
//		System.out.println(protocolFeature.get("name"));
//		System.out.println(protocolFeature.get("id"));
		JsonParsing json = new JsonParsing();
		System.out.println(json);
		json.printObject();
		json.printObject();
		
	}
}
