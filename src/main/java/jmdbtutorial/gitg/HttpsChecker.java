package jmdbtutorial.gitg;

public class HttpsChecker {
	
	public static String check(String tag) {
		if (tag.contains("https")) {
			return "Tag contains a secure URL";			
		}
		return "Tag does not contain a secure URL";
	}
	

}
