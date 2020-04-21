
public class Solution0983 {
	public static void main(String[] args) {
		Solution0983 o = new Solution0983();
		int[] daysTest1 = {1,4,6,7,8,20};
		int[] costsTest1 = {2,7,15};
		System.out.println(o.mincostTickets(daysTest1, costsTest1));
	}
	
	public int mincostTickets(int[] days, int[] costs) {
		int lastDay = days[days.length - 1];
		
		int[] minCost = new int[lastDay + 1];
        boolean[] dayIncluded = new boolean[366];
        for (int day : days) {
            dayIncluded[day] = true;
        }
        
        minCost[0] = 0;
        for (int day = 1; day < minCost.length; day++) {
            if (!dayIncluded[day]) {
                minCost[day] = minCost[day-1];
                continue;
            }
            int min;
            min = minCost[day-1] + costs[0];
            min =Math.min(min, minCost[Math.max(0, day-7)] + costs[1]);
            min = Math.min(min, minCost[Math.max(0, day-30)] + costs[2]);
            minCost[day] = min;
        }

        return minCost[minCost.length - 1];

    }
}
