package printshop;

import java.util.Date;
import printshop.PrintConfiguration.*;
import printshop.PrinterNotification.PrinterStatus;

/**
 * Simulator maintains a queue of events sorted by the simulated time the should
 * occur. Simulator maintains priority queues of print jobs.
 */
public class PrintShopSimulator {

    private PriorityQueue<Event> simulationQueue;
    private PriorityQueue<PrintQueue> printQueues;
    private Date simulationTime;
    private int printersCount;

    public PrintShopSimulator(int printersCount) {
        this.simulationQueue = new LinkedList<>();
        this.printersCount = printersCount;
        this.initializePrintQueues();
    }

    /**
     * Starts simulation of the print shop. Initializes Simulations queue with
     * PrintRequest, PrintConfiguration and PrinterNotifications events. Reads
     * the SimulationQueue and process events.
     *
     * @param start
     * @param end
     */
    public void simulate(Date start, Date end) {

        simulationTime = start;

        addEvent(new PrintRequest(PrintConfiguration.getRandomPrintConfiguration(), 100, simulationTime));
        addEvent(new PrinterConfigurationChange(PrintShopSimulator.addMinutes(simulationTime, 60)));

        for (int i = 0; i < printersCount; i++) {
            PrinterNotification printerNotification = new PrinterNotification(PrintConfiguration.getRandomPrintConfiguration(), PrinterStatus.IDLE, PrintShopSimulator.addSeconds(simulationTime, 10));
            addEvent(printerNotification);
        }

        while (simulationQueue.length() > 0 && simulationTime.getTime() <= end.getTime()) {

            Event event = simulationQueue.poll();
            simulationTime = event.getTime();
            event.process(this);
            System.out.println(event.getTime() + " - " + event);  
        }
    }

    public void addEvent(Event event) {
        simulationQueue.enqueue(event);
    }

    public static Date addMinutes(Date date, long minutes) {
        return new Date(date.getTime() + 60 * 1000 * minutes);
    }

    public static Date addSeconds(Date date, long seconds) {
        return new Date(date.getTime() + 1000 * seconds);
    }

    public void initializePrintQueues() {

        printQueues = new LinkedList<>();

        for (PaperColour paperColour : PaperColour.values()) {
            for (PaperSize paperSize : PaperSize.values()) {
                for (PrinterSpeed printerSpeed : PrinterSpeed.values()) {
                    printQueues.enqueue(new PrintQueue(new PrintConfiguration(paperColour, paperSize, printerSpeed)));
                }
            }
        }
    }

    public PrintQueue getPrintQueueByConfiguration(PrintConfiguration printConfiguration) {
        for (PrintQueue pq : printQueues) {
            if (pq.getPrintConfiguration().equals(printConfiguration)) {
                return pq;
            }
        }
        return null;
    }

    public PriorityQueue<PrintQueue> getPrintQueues() {
        return printQueues;
    }

    public PriorityQueue<Event> getSimulationQueue() {
        return simulationQueue;
    }
}
