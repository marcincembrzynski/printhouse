package printshop;

import java.util.Date;
import java.util.Random;

/**
 * Represents print request made by customer. Contains information about requested print configuration and price.
 */
public class PrintRequest extends Event {

    private PrintConfiguration printConfiguration;
    private Integer price;

    public PrintRequest(Date time) {
        super(time);
    }

    public PrintRequest(PrintConfiguration printConfiguration, Integer price, Date time) {
        super(time);
        this.printConfiguration = printConfiguration;
        this.price = price;
    }

    public PrintConfiguration getPrintConfiguration() {
        return printConfiguration;
    }

    public Integer getPrice() {
        return price;
    }   

    /**
     * Inserts new PrintJob to corresponding PrintQueue
     * Inserts new PrintRequest to SimulationQueue
     * @param simulator
     */
    @Override
    public void process(PrintShopSimulator simulator) {
        simulator.getPrintQueueByConfiguration(printConfiguration).enqueue(new PrintJob(this));
        Long next = this.getTime().getTime() + 60 * 1000;
        simulator.addEvent(new PrintRequest(PrintConfiguration.getRandomPrintConfiguration(), new Random().nextInt(1000), new Date(next)));
    }

    @Override
    public String toString() {
        return "PrintRequest{" + "printConfiguration=" + printConfiguration + ", price=" + price + '}';
    }    
}