import java.util.*;

public class Scheduler {

	public static DateTime StartDayTime = new DateTime(0,0,0, 7, 0);
	public static DateTime EndDayTime = new DateTime(0,0,0, 23, 0);
	
	/* For Testing
	 * public static void main(String args[]) {
		DateTime dt1 = new DateTime(2017, 2, 19, 12, 30);
		DateTime dt2 = new DateTime(2017, 2, 19, 12, 55);
		DateTime dt3 = new DateTime(2017, 2, 19, 12, 35);
		DateTime dt4 = new DateTime(2017, 2, 19, 13, 0);
		DateTime dt5 = new DateTime(2017, 2, 19, 14, 0);
		DateTime dt6 = new DateTime(2017, 2, 19, 14, 15);
		
		Event e1 = new Event(dt1, dt2);
		Event e2 = new Event(dt3, dt4);
		Event e3 = new Event(dt5, dt6);
		Event e4 = new Event(dt1, dt3);
		Event e5 = new Event(dt1, dt4);
		Event e6 = new Event(dt6, dt4);
		Event span = new Event(new DateTime(2017, 2, 19, 12, 30), new DateTime(2017, 2, 19, 15, 30));
		
		ArrayList<Event> busy = new ArrayList<Event>();
		busy.add(e1);
		busy.add(e2);
		busy.add(e3);
		//busy.add(e4);
		//busy.add(e5);
		//busy.add(e6);
		ArrayList<Event> answer = Scheduler.schedule(busy, 60, span);
		
		for(Event e: answer) {
			System.out.println("Start: " + e.start.printMe());
			System.out.println("Finish: " + e.finish.printMe());
		}
		
	}
	 */
	public static ArrayList<Event> schedule(ArrayList<Event> busy, int durationInMinutes, Event timeSpan) {
		ArrayList<Event> possibilities = new ArrayList<Event>();
		DateTime current = timeSpan.start;
		double opening;
		for( Event e : busy ) {
			opening = e.start.diffMin(current);
			if( opening >= durationInMinutes) {
				possibilities.add(new Event(current, e.start));	
			}
			opening = (e.finish.diffMin(current));
			if (opening > 0) {
				current = e.finish;
			}
		}
		opening = timeSpan.finish.diffMin(current);
		if( opening >= durationInMinutes) {
			possibilities.add(new Event(current, timeSpan.finish));	
		}
		return possibilities;
	}
}

class DateTime implements Comparable<DateTime>{
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private double totalDateTime;
	
	public DateTime(int nYear, int nMonth, int nDay, int nHour, int nMinute) {
		year = nYear;
		month = nMonth;
		day = nDay;
		hour = nHour;
		minute = nMinute;
		totalDateTime = (minute * 0.0001) + (hour * 0.01) + (day) + (month * 100) + (year * 10000);
	}

	@Override
	public int compareTo(DateTime dt) {
		return (int)(diffMin(dt));
	}
	
	public double diffMin(DateTime dt) {
		double answer = 0;
		answer += (year - dt.year)*525600;
		answer += (month - dt.month)*43800;
		answer += (day - dt.day)*1440;
		answer += (hour - dt.hour)*60;
		answer += minute - dt.minute;		
		return answer;
	}
	public int compareDayTo(DateTime dt) {
		return (int)(Math.floor(totalDateTime) - Math.floor(dt.totalDateTime));
	}
	
	public String printMe() {
		return year + "/" + month + "/" + day + " " + hour + ":" + minute;
	}
}

class Event {	
	DateTime start;
	DateTime finish;
	
	public Event(DateTime s, DateTime f) {
		start = s;
		finish = f;
	}
}
