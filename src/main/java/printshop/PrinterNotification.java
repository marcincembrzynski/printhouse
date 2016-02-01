package printshop;

import java.util.Date;

/**
 * Represents Printer Notification Event.  
 * Occurs every 30 seconds when printer is idle or just after printer finished printing.
 */
public class PrinterNotification extends Event {

    private PriorityQueue<PrintJob> printQueue;
    private PrintConfiguration printConfiguration;
    private Enum status;   

    public enum PrinterStatus {
        IDLE, IDLE_PRINTING_COMPLETED
    }

    public PrinterNotification(PrintConfiguration printConfiguration, Enum status, Date time) {
        super(time);
        this.printConfiguration = printConfiguration;
        this.status = status;
    }
    
    /**
     * Checks for new PrintJob in PrintQueue with the same PrintConfiguration.
     * If PrintJob exists, removes it and adds new PrintNotification to SimulationsQueue with time increased by print duration relatively to previous PrinterNotification event 
     * If PrintJob does not exist, adds new PrintNotification to SimulationQueue with time increased by 30 seconds relatively to previous PrinterNotification event.
     * @param simulator 
     */
    @Override
    public void process(PrintShopSimulator simulator) {

        printQueue = simulator.getPrintQueueByConfiguration(printConfiguration);
        PrinterNotification printerNotification;

        if (printQueue.isEmpty()) {            
            printerNotification = new PrinterNotification(this.printConfiguration, PrinterStatus.IDLE, PrintShopSimulator.addSeconds(this.getTime(), 30));
          
        } else {
            
            PrintJob printJob = printQueue.poll();
              
            long next = this.getTime().getTime() + printJob.getPrintConfiguration().getPrinterSpeed().duration();         
            printerNotification = new PrinterNotification(this.printConfiguration, PrinterStatus.IDLE_PRINTING_COMPLETED, new Date(next));

        }       
        simulator.addEvent(printerNotification);
    }
   
    public void setPrintConfiguration(PrintConfiguration printConfiguration) {
        this.printConfiguration = printConfiguration;
    }

    @Override
    public String toString() {
        return "PrinterNotification{" + "status=" + status + '}';
    }
}