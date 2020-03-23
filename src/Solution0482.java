
public class Solution0482 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		String STest1 = "5F3Z-2e-9-w";
		int KTest1 = 4;

		String STest2 = "2-5g-3-J";
		int KTest2 = 2;
		
		Solution0482 o = new Solution0482();
		
		
		
		System.out.println(o.licenseKeyFormatting(STest1, KTest1)); //"5F3Z-2E9W";
		System.out.println(o.licenseKeyFormatting(STest2, KTest2)); //"2-5G-3J";
		


	}

	public String licenseKeyFormatting(String S, int K) {
		
		
		StringBuilder sb = new StringBuilder();
		
		char[] chars = S.toCharArray();
		
		int counter = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			
			if (chars[i] == '-') {
				continue;
			}
			
			if (K == counter) {
				counter = 0;
				sb.append("-");
			}

			sb.append(Character.toUpperCase(chars[i]));
			//sb.insert(0, Character.toUpperCase(chars[i]));
			counter++;
		}
		return sb.reverse().toString();

	}

}
