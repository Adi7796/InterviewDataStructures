package Greedy;

import java.util.*;
/*
Activity Selection Problem:
Given a set of activities, along with the starting and finishing time of each activity,
find the maximum number of activities performed by a single person assuming
that a person can only work on a single activity at a time.

Input: Following set of activities (1, 4), (3, 5), (0, 6), (5, 7), (3, 8), (5, 9), (6, 10), (8, 11), (8, 12), (2, 13), (12, 14)
Output: (1, 4), (5, 7), (8, 11), (12, 14)
 */
public class ActivitySelection {

    static class Activity {

        final int start;
        final int finish;

        // Private constructor
        private Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        // Factory method
        public static Activity of(int start, int finish) {
            return new Activity(start, finish);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (!(o instanceof Activity)) return false;

            Activity activity = (Activity) o;

            return start == activity.start &&
                    finish == activity.finish;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, finish);
        }

        @Override
        public String toString() {
            return "(" + start + ", " + finish + ")";
        }
    }
    public static Set<Activity> selectActivity(List<Activity> activities) {
        // Write your code here...
        if(activities == null || activities.isEmpty()) return new HashSet<>();
        Collections.sort(activities, new Comparator<Activity>(){
            @Override
            public int compare(Activity a1, Activity a2){
                return a1.finish - a2.finish;
            }

        });

        // Collections.sort(activites, (a1, a2) -> a2.finish - a1.finish);
        // activities.sort((a1, a2) -> a2.finish - a1.finish);

        for(Activity ac : activities)
        {
            System.out.println("("+ ac.start +","+ ac.finish + ")");
        }

        Set<Activity> actSet = new HashSet<>();
        actSet.add(Activity.of(activities.get(0).start, activities.get(0).finish));
        int lastFinishTime = activities.get(0).finish;
        for(int i = 1; i < activities.size(); i++)
        {
            int currStartTime = activities.get(i).start;
            if(currStartTime >= lastFinishTime){
                actSet.add(Activity.of(activities.get(i).start, activities.get(i).finish));
                lastFinishTime = activities.get(i).finish;
            }
        }

        return actSet;
    }

    public static void main(String[] args) {

        List<Activity> activities = Arrays.asList(
                Activity.of(1, 4),
                Activity.of(3, 5),
                Activity.of(0, 6),
                Activity.of(5, 7),
                Activity.of(3, 8),
                Activity.of(5, 9),
                Activity.of(6, 10),
                Activity.of(8, 11),
                Activity.of(8, 12),
                Activity.of(2, 13),
                Activity.of(12, 14)
        );

        Set<Activity> result = selectActivity(activities);

        System.out.println("Selected Activities:");

        for (Activity activity : result) {
            System.out.println(activity);
        }
    }
}
