package 剑指offer;

public class _剑指Offer_05_替换空格 {
	public static String replaceSpace(String s) {
		/*StringBuilder sb = new StringBuilder(s);
		for (int i =  0; i < sb.length(); i++) {		
			if (sb.charAt(i) == ' ') {
				sb.replace(i, i + 1, "%20");
				i = i + 2;
			}
		}		
		return sb.toString();*/
		int length = s.length();
		char[] array = new char[length * 3];
		int size = 0;
		for (int i = 0; i < length; i++) {
			char c= s.charAt(i);
			if (c == ' ') {
				array[size++] = '%';
				array[size++] = '2';
				array[size++] = '0';
			} else {
				array[size++] = c;
			}
		}
		String newStr = new String(array, 0, size);
		return newStr;
	}	
}
