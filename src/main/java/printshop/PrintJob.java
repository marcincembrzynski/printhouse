package printshop;

public class PrintJob  implements Comparable<PrintJob>{
    
    private Integer urgency;  
    private PrintConfiguration printConfiguration;
    private PrintRequest printRequest;
    

    public PrintJob(PrintRequest printRequest) {
        this.printRequest = printRequest;
        this.printConfiguration = printRequest.getPrintConfiguration();
        this.urgency = printRequest.getPrice() * -1;
    } 
    
    public Integer getUrgency() {
        return urgency;
    }

    public PrintConfiguration getPrintConfiguration() {
        return printConfiguration;
    }    
    
    @Override
    public int compareTo(PrintJob o) {
        return this.urgency.compareTo(o.getUrgency());
    }
}