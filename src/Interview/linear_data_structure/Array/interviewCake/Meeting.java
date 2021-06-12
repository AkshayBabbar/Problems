package Interview.linear_data_structure.Array.interviewCake;

/**
 * Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times in a day when everyone is available.
 * A meeting is stored as an object of a Meeting class with integer variables startTime and endTime.
 * These integers represent the number of 30-minute blocks past 9:00am.
 * <p>
 * new Meeting(2, 3);  // meeting from 10:00 – 10:30 am
 * new Meeting(6, 9);  // meeting from 12:00 – 1:30 pm
 * <p>
 * For example, given:
 * <p>
 * [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]
 * <p>
 * your method would return:
 * <p>
 * [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
 * <p>
 * URL:https://www.interviewcake.com/question/java/merging-ranges?course=fc1&section=array-and-string-manipulation
 * Code By : Akshay Babbar
 * Dated: 28/01/2021
 */
public class Meeting {
    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

//    public Meeting[] mergeRanges(Meeting[] meetings) {
//        if (meetings.length == 0) {
//            return null;
//        }
//        Stack<Meeting> stack = new Stack<Meeting>();
//
//        Arrays.sort(meetings, new Comparator<Meeting>() {
//            @Override
//            public int compare(Meeting o1, Meeting o2) {
//                return o1.getStartTime() - o2.getStartTime();
//            }
//        });
//        stack.push(meetings[0]);
//
//
//        for (int i = 0; i < meetings.length; i++) {
//            int startingPosition = meetings[i].getStartTime();
//            int endingPosition = meetings[i].getEndTime();
//        }
//    }
}
