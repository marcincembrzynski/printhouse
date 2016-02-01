package printshop;

import java.util.Random;

/**
 * Represents print configuration used by PrintRequest, PrintJob, PrinterNotification and PrintConfigurationChange.
 */
public class PrintConfiguration {

    private final PaperColour paperColour;
    private final PaperSize paperSize;
    private final PrinterSpeed printerSpeed;

    public enum PaperColour { WHITE, YELLOW, RED    }

    public enum PaperSize {  SMALL, MEDIUM, LARGE    }

    public enum PrinterSpeed {  
        STANDARD (1000 * 60 * 4), FAST (1000 * 60 * 2);
        
        private final long duration;
        
        PrinterSpeed(long duration){
            this.duration = duration;
        }
        
        public long duration(){
            return duration;
        }
    }

    public PrintConfiguration(PaperColour paperColour, PaperSize paperSize, PrinterSpeed printerSpeed) {
        this.paperColour = paperColour;
        this.paperSize = paperSize;
        this.printerSpeed = printerSpeed;
    }

    public PaperColour getPaperColour() {
        return paperColour;
    }

    public PaperSize getPaperSize() {
        return paperSize;
    }

    public PrinterSpeed getPrinterSpeed() {
        return printerSpeed;
    }

    public static PrintConfiguration getRandomPrintConfiguration() {
        Random random = new Random();
        return new PrintConfiguration(PaperColour.values()[random.nextInt(3)], PaperSize.values()[random.nextInt(3)], PrinterSpeed.values()[random.nextInt(2)]);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }        
        final PrintConfiguration pc = (PrintConfiguration) obj;
        return this.paperColour.equals(pc.paperColour) && this.paperSize.equals(pc.paperSize) && this.printerSpeed.equals(pc.printerSpeed);
  
    }

   

    @Override
    public String toString() {
        return "PrintConfiguration{" + "paperColour=" + paperColour + ", paperSize=" + paperSize + ", printerSpeed=" + printerSpeed + '}';
    } 
}