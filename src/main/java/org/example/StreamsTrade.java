package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamsTrade {

    public static void main(String[] args) {

        TradeDAO tradeDAO= new TradeDAO();
List<Trade> trades= tradeDAO.getLastYearTrades();//

List<Trade> profitTrades= new ArrayList<>();

        // filtering the trades with result > 0.

profitTrades= trades.stream().filter(x-> x.getResult() > 0).collect(Collectors.toList());

        for(Trade trade:profitTrades){
            System.out.println(trade);
        }

    }
}
