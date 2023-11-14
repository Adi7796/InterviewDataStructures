package DynamicProgramming;

import java.util.Arrays;

/*
In a stock market, there is a product with its infinite stocks.
The stock prices are given for N days, where arr[i] denotes the price of the stock on the ith day.
There is a rule that a customer can buy at most i stock on the ith day.
If the customer has k amount of money initially, find out the maximum number of stocks a customer can buy.

For example, for 3 days the price of a stock is given as 7, 10, 4.
You can buy 1 stock worth 7 rs on day 1, 2 stocks worth 10 rs each on day 2 and 3 stock worth 4 rs each on day 3.
 */
public class MaximumNumberOfStocks {

    static class Pair{
        int cost;
        int day;

        Pair(int cost, int day)
        {
            this.cost = cost;
            this.day = day;
        }
    }

    public static int findMaximum(int[] price, int K)
    {
        int n = price.length;
        Pair[] arr = new Pair[n];
        for(int i=0; i<n; i++){
            arr[i] = new Pair(price[i], i+1);
        }

        Arrays.sort(arr, (p1, p2) -> p1.cost - p2.cost);
        // similar to below without the use of lambdas

//        Arrays.sort(arr, new Comparator<Pair>(){
//            public int compare(Pair p1, Pair p2){
//                return p1.cost - p2.cost;
//            }
//        });

        int total_purchase = 0;
        int purchase;

        for(int i=0;i<n;i++)
        {
            int cost = arr[i].cost;
            int maxStocksThatCanBeBought = arr[i].day;
            purchase = Math.min(maxStocksThatCanBeBought, (K/cost));    // We need to find the min between the number of stocks that can be bought that day
                                                                        // and the number of stocks that can be bought with the remaining amount at the cost on that day
            total_purchase += purchase;                               // adding the purchase on that day to the total purchase count

            K = K - (purchase*cost);                                  // reducing the remaining amount by the amount that was bought
        }

        return total_purchase;
    }
    public static void main(String[] args) {
        int [] price = {10, 7, 19};
        int K = 45;

        System.out.println("Maximum number of stocks : "+ findMaximum(price, K));
    }

}
