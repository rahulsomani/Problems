import java.util.*;

public class Solution0322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1, 2, 5};
		int amount = 11;
		
		Solution0322 o = new Solution0322();
		Map<Integer,Integer> amountDict = new HashMap<Integer,Integer>();
		System.out.println(o.coinChange(coins, amount, amountDict));

	}

	
    public int coinChange(int[] coins, int amount, Map<Integer,Integer> amountDict) {
        if(amount==0)
            return 0;
        if(amountDict.containsKey(amount))
            return amountDict.get(amount);
        int n = amount+1;
        for(int coin : coins) {
            int curr = 0;
            if (amount >= coin) {
                int next = coinChange(coins, amount-coin, amountDict);
                if(next >= 0)
                    curr = 1+next;
            }
            if(curr > 0)
                n = Math.min(n,curr);
        }
        int finalCount = (n==amount+1) ? -1 : n;
        amountDict.put(amount,finalCount);
        return finalCount;
    }
}
