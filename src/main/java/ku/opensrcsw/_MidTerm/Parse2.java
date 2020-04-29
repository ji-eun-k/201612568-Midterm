package ku.opensrcsw._MidTerm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Scanner;
import midterm.problem2.RegularExpression;

public class Parse2 {

	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the keyword you are looking for: ");
			String search = in.nextLine();
			String search1 = search.substring(0,search.indexOf("|")-1);
			String search2 = search.substring(search.indexOf("|")+1);
			
			FileReader file = new FileReader("./midterm.json");
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(file);
			JSONArray infoArray = (JSONArray) jsonObject.get("poem");
			RegularExpression re = new RegularExpression();
			
			for(int i =0; i<infoArray.size(); i++) {
				JSONObject itemObject = (JSONObject) infoArray.get(i);
				String mystring = (String) itemObject.get("item");
				if(re.check(mystring, search1) || re.check(mystring, search2)) {
					System.out.println("item "+i+": "+itemObject.get("item"));
				}
			}

			in.close();
			
		} catch (IOException e) {
			System.out.println("파일을 열 수 없습니다.");
			
		} catch (ParseException h) {
			System.out.println("파싱을 할 수 없습니다.");
		} 
	}

}