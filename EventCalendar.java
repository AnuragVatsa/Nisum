import java.util.*;
class Event {
    String title, time, description;
    public Event(String title, String time, String description) {
        this.title = title;
        this.time = time;
        this.description = description;
    }
    public String toString() {
        return time + " - " + title + ": " + description;
    }
}
public class EventCalendar {
    TreeMap<String, List<Event>> calendar = new TreeMap<>();
    public void addEvent(String date, Event event) {
        calendar.putIfAbsent(date, new ArrayList<>());
        calendar.get(date).add(event);
    }
    public void removeEvent(String date, String title) {
        if (calendar.containsKey(date)) {
            calendar.get(date).removeIf(e -> e.title.equalsIgnoreCase(title));
        }
    }
    public void showEventsOn(String date) {
        System.out.println("Events on " + date + ":");
        if (calendar.containsKey(date)) {
            for (Event e : calendar.get(date)) {
                System.out.println(e);
            }
        } else {
            System.out.println("No events found.");
        }
    }
    public void listAllEvents() {
        for (Map.Entry<String, List<Event>> entry : calendar.entrySet()) {
            System.out.println(entry.getKey());
            for (Event e : entry.getValue()) {
                System.out.println("  " + e);
            }
        }
    }
    public static void main(String[] args) {
        EventCalendar ec = new EventCalendar();
        ec.addEvent("2025-05-15", new Event("Meeting", "10:00", "Team sync"));
        ec.addEvent("2025-05-15", new Event("Lunch", "12:30", "With client"));
        ec.addEvent("2025-05-16", new Event("Webinar", "15:00", "Java Tips"));
        ec.listAllEvents();
        ec.showEventsOn("2025-05-15");
    }
}
