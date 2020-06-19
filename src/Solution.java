import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test1 = {"bob", "dan", "john"};
		
		Solution o  = new Solution();
		System.out.println(o.ContainsDuplicate(test1));
		

	}

	public boolean ContainsDuplicate(String[] input) {

		Set<String> set = new HashSet<String>();
		for (String s : input) {
			if (set.contains(s))
				return true;
			set.add(s);
		}
		return false;
	}

}
