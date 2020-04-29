package ku.opensrcsw._MidTerm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Scanner;

public class Parse {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the keyword you are looking for: ");
			String search = in.nextLine();
			
			FileReader file = new FileReader("./midterm.json");
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(file);
			JSONArray infoArray = (JSONArray) jsonObject.get("poem");
			
			for(int i =0; i<infoArray.size(); i++) {
				JSONObject itemObject = (JSONObject) infoArray.get(i);
				String mystring = (String) itemObject.get("item");
				if(mystring.indexOf(search)!=-1) {
					System.out.println("item "+i+": "+itemObject.get("item"));
				}
			}

			in.close();
			
		} catch (IOException e) {
			System.out.println("파일을 열 수 없습니다.");
			
		} catch (ParseException h) {
			
			
		} finally {
		}
		
	}

}
