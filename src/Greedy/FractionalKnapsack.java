package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
The weight of N items and their corresponding values are given.
We have to put these items in a knapsack of weight W such that the total value obtained is maximized.

Note: We can either take the item as a whole or break it into smaller units.

Example:

Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.

Output: 240.00

Explanation: The first and second items  are taken as a whole
while only 20 units of the third item is taken.
Total value = 100 + 60 + 80 = 240.00

Approach:

The greedy method to maximize our answer will be to pick up
the items with higher values. Since it is possible to break the items as
well we should focus on picking up items having higher value /weight first.
To achieve this, items should be sorted in decreasing order with respect to
their value /weight. Once the items are sorted we can iterate.
Pick up items with weight lesser than or equal to the current capacity of the knapsack.
In the end, if the weight of an item becomes more than what we can carry,
break the item into smaller units. Calculate its value according to our current
capacity and add this new value to our answer.

Let's understand with an example:-

N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.

The value/weight of item 1 is (100/20) = 5,for item 2 is (60/10) = 6 and for item 3 is (120/30) = 4.

Sorting them in decreasing order of value/weight we have
 */
public class FractionalKnapsack {
    static class Item
    {
        int value;
        int weight;

        Item(int value, int weight)
        {
            this.value = value;
            this.weight = weight;
        }
    }

    static class ItemComparator implements Comparator<Item>
    {
        public int compare(Item i1, Item i2)
        {
            // calculate the value by weight ratio for all items
            // and sort them in descending order of value by weight ratios
            double r1 = (double)(i1.value)/(double)(i1.weight);
            double r2 = (double)(i2.value)/(double)(i2.weight);

            if(r1 > r2) return -1;
            else if(r1 == r2) return 0;
            else return 1;
        }
    }
    public static void main(String[] args) {
//        List<Integer> val = List.of(60, 100, 120);
//        List<Integer> wt = List.of(10, 20, 30);
//        int capacity = 50;

        List<Integer> val = List.of(1, 5, 7, 2, 7, 10);
        List<Integer> wt = List.of(4, 9, 6, 3, 7, 3);
        int capacity = 24;

        System.out.println(fractionalKnapsack(val, wt, capacity));
    }

    static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        List<Item> itemList = new ArrayList<>();
        for(int  i= 0; i<val.size(); i++)
        {
            itemList.add(new Item(val.get(i), wt.get(i)));
        }

        // sorting the item list in the descending order of value by weight ratios
        // to get the max value
        Collections.sort(itemList, new ItemComparator());
        double maxValue = 0.0;
        for(int i = 0; i<itemList.size(); i++)
        {
            // greedily choose the max value by weight item
            // and subtract the current weight from the remaining capacity
            Item currItem = itemList.get(i);
            if(capacity >= currItem.weight)
            {
                capacity = capacity - currItem.weight;
                maxValue += currItem.value;
            }

            // if the remaining capacty is less than the curr wt of the curr item
            // calculate the value by weight for a unit weight and then multiply it with the
            // remaining capacity
            // since we have used the entre capacity, we break from there
            else
            {
                double unitValue = (double)(currItem.value)/(double)(currItem.weight);
                double totalValue = (double)(capacity) * (double)(unitValue);
                maxValue += totalValue;
                break;
            }
        }
        return maxValue;
    }
}

/*
Time Complexity: O(n log n + n). O(n log n) to sort the items and O(n)
to iterate through all the items for calculating the answer.

Space Complexity: O(1), no additional data structure has been used.
 */