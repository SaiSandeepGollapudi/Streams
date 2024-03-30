package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TradeDAO {
    //Data Access Object (DAO),is a design pattern used to abstract the underlying data access logic from the rest of the application
    // All the values needed are declared here
    public List<Trade> getLastYearTrades(){ //

        List<Trade> trades=new ArrayList<>();//new ArrayList named trades that is capable of storing Trade objects.
//add() method, you provide a new instance of the Trade object as an argument. This creates a new Trade object and adds it to the trades list.
// Trade class has a constructor that accepts parameters, you would pass those parameters to initialize the Trade object
        trades.add(new Trade("TCS", LocalDate.of(2022,2,2),
                LocalDate.of(2022,3,2),3800.0,3900.0,500L));
        trades.add(new Trade("Infy", LocalDate.of(2021,11,22),
                LocalDate.of(2022,3,2),1400.0,1350.0,800L));
        trades.add(new Trade("BEL", LocalDate.of(2022,1,5),
                LocalDate.of(2022,1,7),160.0,162.0,400L));
        trades.add(new Trade("HUL", LocalDate.of(2021,11,11),
                LocalDate.of(2021,12,12),1600.0,1616.0,200L));
        trades.add(new Trade("TCS", LocalDate.of(2022,1,1),
                LocalDate.of(2022, 4,11),3850.0,3800.0,100L));
        trades.add(new Trade("ADANIENT", LocalDate.of(2021,7,2),
                LocalDate.of(2021,7,9),2300.0,2700.0,400L));
        trades.add(new Trade("ADANIENT", LocalDate.of(2022,2,2),
                LocalDate.of(2022,4,3),2700.0,2650.0,500L));
        trades.add(new Trade("ADANIPOWER", LocalDate.of(2022,4,1),
                LocalDate.of(2022,4,7),120.0,220.0,400L));
        trades.add(new Trade("WIPRO", LocalDate.of(2022,1,1),
                LocalDate.of(2022,2,22),600.0,600.4,500L));
        trades.add(new Trade("IOC", LocalDate.of(2022,2,2),
                LocalDate.of(2022,3,2),78.0,89.0,1000L));
        trades.add(new Trade("IOC", LocalDate.of(2021,11,1),
                LocalDate.of(2021,12,2),86.0,85.0,5000L));
        trades.add(new Trade("COLPAL", LocalDate.of(2022,2,1),
                LocalDate.of(2022,3,9),4000.0,3800.0,500L));
        trades.add(new Trade("JPPOWER", LocalDate.of(2021,11,1),
                LocalDate.of(2022,3,9),5.0,9.0,50000L));
        trades.add(new Trade("JPPOWER", LocalDate.of(2021,11,1),
                LocalDate.of(2022,3,9),5.0,9.0,50000L));
        return trades;
    }
}