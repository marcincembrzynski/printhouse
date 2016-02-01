package printshop;
import java.util.Date;

public class Test {

    public static void main(String[] args) { 
        PrintShopSimulator simulator = new PrintShopSimulator(5);  
        Date now = new Date();
        //runs printshop for 10 hours        
        simulator.simulate(now, PrintShopSimulator.addMinutes(now, 600));            
    }
}