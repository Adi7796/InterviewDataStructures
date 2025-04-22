package Greedy;

import java.util.ArrayList;
import java.util.Collections;

/*
There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i])
where S[i] is the start time of meeting i and F[i] is the finish time of meeting i.
The task is to find the maximum number of meetings that can be accommodated in the meeting room.
Print all meeting numbers
 */
public class MaximumMeetingsInOneRoom {

    static class Meeting{
        int start;
        int finish;
        int pos;

        Meeting(int start, int finish, int pos){
            this.start = start;
            this.finish = finish;
            this.pos = pos;
        }
    }

    public static void findMaxMeetings(ArrayList<Meeting> meeting){
        ArrayList<Integer> ans = new ArrayList<>();

        // sort the list in the ascending order of the finish times
        Collections.sort(meeting, (m1, m2) -> m1.finish - m2.finish);

        // add the position of the first meeting
        ans.add(meeting.get(0).pos);
        int intervalTime = meeting.get(0).finish;

        for(int i=1 ; i< meeting.size(); i++){

            // check if the start time of the current meeting is greater than the finish time of the last meeting
            if(meeting.get(i).start > intervalTime){

                // Add selected meeting to the ans list
                ans.add(meeting.get(i).pos);

                // change the interval time to the last meeting's finish time
                intervalTime = meeting.get(i).start;
            }
        }

        for(int j : ans){
            System.out.print(j+1 + " ");
        }
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};

        ArrayList<Meeting> meeting = new ArrayList<>();

        for(int i=0; i<start.length; i++)
        {
            meeting.add(new Meeting(start[i], finish[i], i));
        }

        System.out.println("Maximum meetings that can be conducted : ");
        findMaxMeetings(meeting);
    }
}
