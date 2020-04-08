import java.util.*;

public class Solution1170 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] queriesTest1 = {"cbd"};
		String[] wordsTest1 = {"zaaaz"};
				
		String[] queriesTest2 = {"bbb","cc"};
		String[] wordsTest2 = {"a","aa","aaa","aaaa"};
				

		Solution1170 o = new Solution1170();
		
		//System.out.println(o.getFrequencyOfSmallestCharacter("aa"));
		
	    System.out.println(Arrays.toString(o.numSmallerByFrequency(queriesTest1, wordsTest1)));// [1]
		System.out.println(Arrays.toString(o.numSmallerByFrequency(queriesTest2, wordsTest2)));//[1 , 2]
	}

	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		
		TreeMap<Integer, Integer> map = sortedWordsFreq(words);
		int[] queriesFreq = new int[queries.length];
		int freq = 0;
		for (int i = 0; i < queries.length; i++) {
			freq = getFrequencyOfSmallestCharacter(queries[i]);
			Integer key = map.ceilingKey(freq + 1);  //get frequencies greater than this freq
			if(key != null ) {
				queriesFreq[i] =  map.get(key);
			}		
		}

		return queriesFreq;
	}
	private TreeMap<Integer, Integer> sortedWordsFreq(String[] words) {
		int[] wordsFreq = new int[words.length];
		
		for (int i = 0; i < words.length; i++) {
			wordsFreq[i] = getFrequencyOfSmallestCharacter(words[i]);
		}
		Arrays.sort(wordsFreq);
		
		TreeMap<Integer, Integer> TreeMap = new TreeMap<Integer, Integer>();
		int counter = 1;
		
		for (int i = wordsFreq.length - 1; i >= 0 ; i--) {
			TreeMap.put(wordsFreq[i], counter);
			counter++;
		}
		
		return TreeMap;
	}
	
	private int getFrequencyOfSmallestCharacter(String s) {
		
		int[] freq = new int[26];
		
		char[] chars = s.toCharArray();
		
		for (char c : chars) {
			freq[(int)c - 97]++;
		}
		
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0) {
				return freq[i];
			}
		}
		return 0;
		
		
	}

}
