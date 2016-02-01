package printshop;

import java.util.Date;

/**
 * Parent class for all events in print shop.
 */
public abstract class Event implements Comparable<Event> {

    private Date time;

    public Event(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public abstract void process(PrintShopSimulator simulator);

    @Override
    public int compareTo(Event event) {
        return this.getTime().compareTo(event.getTime());
    }
}