package lesson5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Request implements Comparable<Request>{
    private String userName;
    private LocalDateTime timestamp;
    private int priority;

    public Request(String userName, int priority) {
        this.userName = userName;
        this.priority = priority;
        this.timestamp = LocalDateTime.now();
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Request other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("%s [%d] в %s", userName, priority, timestamp.format(formatter));
    }
}
