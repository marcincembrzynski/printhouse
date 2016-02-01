package printshop;

import java.util.Date;

/**
 * Printer configuration change is an event, which occurs every 1 hour.
 */
public class PrinterConfigurationChange extends Event {

    public PrinterConfigurationChange(Date time) {
        super(time);
    }

    /**
     * Changes PrinterNotifications' PrintConfigurations to cope with longest print queues.
     * Adds new PrinterConfigurationChange event to SimulationQueue with time set increased by 1 hour relatively to previous PrintConfigurationChange event.
     * @param simulator
     */
    @Override
    public void process(PrintShopSimulator simulator) {

        PriorityQueue<PrintQueue> tempPrintQueues = new LinkedList<>();

        for (PrintQueue printQueue : simulator.getPrintQueues()) {
            tempPrintQueues.enqueue(printQueue);
        } 

        for (Event event : simulator.getSimulationQueue()) {
            if (event instanceof PrinterNotification) {
                PrinterNotification printerNotification = (PrinterNotification) event;

                PrintQueue longestQueue = tempPrintQueues.poll();
                printerNotification.setPrintConfiguration(longestQueue.getPrintConfiguration());

            }
        }
        simulator.addEvent(new PrinterConfigurationChange(PrintShopSimulator.addMinutes(this.getTime(), 60)));
    }
}
