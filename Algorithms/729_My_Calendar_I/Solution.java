import java.util.*;

class MyCalendar {
    private final List<int[]> booked = new ArrayList<>(1000);

    public boolean book(int start, int end) {
        int pos = Collections.binarySearch(booked, new int[]{start, end}, Comparator.comparingInt(a -> a[0]));
        if (pos < 0) {
            pos = -pos - 1;
            int prevEnd = pos > 0 ? booked.get(pos - 1)[1] : -1;
            int nextStart = booked.size() >= pos + 1 ? booked.get(pos)[0] : Integer.MAX_VALUE;
            if (prevEnd <= start && end <= nextStart) {
                booked.add(pos, new int[]{start, end});
                return true;
            }
        }
        return false;
    }
}

/**
* Your MyCalendar object will be instantiated and called as such:
* MyCalendar obj = new MyCalendar();
* boolean param_1 = obj.book(start,end);
*/
