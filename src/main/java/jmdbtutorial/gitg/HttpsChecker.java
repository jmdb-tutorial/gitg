package jmdbtutorial.gitg;

public class HttpsChecker {
	
	public static String check() {
		return "Tag contains a secure URL";
	}

	public static String check(String tag) {
		if (tag.contains("https")) {
			return check();			
		}
		return "Tag does not contain a secure URL";
	}
	

}
