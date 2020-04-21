import java.util.*;

public class Solution0332 {

	public static void main(String[] args) {
		Solution0332 o = new Solution0332();
		List<List<List<String>>> testCases = o.getTestCases();

		for (List<List<String>> test : testCases) {
			System.out.println(o.findItinerary(test));
		}

	}

	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, List<String>> map = new HashMap<>();

		List<String> values;
		for (List<String> test : tickets) {
			values = new ArrayList<String>();
			if (map.containsKey(test.get(0))) {
				values = map.get(test.get(0));
			}
			values.add(test.get(1));
			map.put(test.get(0), values);
		}

		for (String str : map.keySet()) {
			Collections.sort(map.get(str));
		}

		List<String> itinerary = new ArrayList<>();
		findItineraryHelper("JFK", map, itinerary);

		return itinerary;
	}

	public void findItineraryHelper(String source, Map<String, List<String>> map, List<String> itinerary) {

	
		if (map.keySet().size() == 0) {
			itinerary.add(source);
			return;
		}
		if (!map.containsKey(source)) {
			return;
		}

		List<String> destinations = map.get(source);

		 
		for (int i = 0 ; i < destinations.size(); i++) {
			//add it to itinerary
			String to = destinations.get(i);
			itinerary.add(source);
			map.get(source).remove(i);
			
			if (map.get(source).size() == 0) {
				map.remove(source);
			}
			
			findItineraryHelper(to, map, itinerary);
			
			  // restore map
            map.putIfAbsent(source, new ArrayList<String>());
            
            map.get(source).add(i, to);
            
            
		}
	//	itinerary.remove(itinerary.size()-1);

		return;

	}

	private List<List<List<String>>> getTestCases() {
		List<List<List<String>>> testCases = new ArrayList<List<List<String>>>();
		testCases.add(Get1stTestCase());
		testCases.add(Get2ndTestCase());
		return testCases;

	}

	private List<List<String>> Get1stTestCase() {
		List<String> ticket1Test1 = new ArrayList<String>() {
			{
				add("MUC");
				add("LHR");
			}
		};
		List<String> ticket2Test1 = new ArrayList<String>() {
			{
				add("JFK");
				add("MUC");
			}
		};
		List<String> ticket3Test1 = new ArrayList<String>() {
			{
				add("SFO");
				add("SJC");
			}
		};
		List<String> ticket4Test1 = new ArrayList<String>() {
			{
				add("LHR");
				add("SFO");
			}
		};
		List<List<String>> test1 = new ArrayList<List<String>>() {
			;
			{
				add(ticket1Test1);
				add(ticket2Test1);
				add(ticket3Test1);
				add(ticket4Test1);
			}
		};
		return test1;

	}

	private List<List<String>> Get2ndTestCase() {
		List<String> ticket1Test2 = new ArrayList<String>() {
			{
				add("JFK");
				add("SFO");
			}
		};
		List<String> ticket2Test2 = new ArrayList<String>() {
			{
				add("JFK");
				add("ATL");
			}
		};
		List<String> ticket3Test2 = new ArrayList<String>() {
			{
				add("SFO");
				add("ATL");
			}
		};
		List<String> ticket4Test2 = new ArrayList<String>() {
			{
				add("ATL");
				add("JFK");
			}
		};
		List<String> ticket5Test2 = new ArrayList<String>() {
			{
				add("ATL");
				add("SFO");
			}
		};
		List<List<String>> test2 = new ArrayList<List<String>>() {
			;
			{
				add(ticket1Test2);
				add(ticket2Test2);
				add(ticket3Test2);
				add(ticket4Test2);
				add(ticket5Test2);
			}
		};
		return test2;

	}

}
