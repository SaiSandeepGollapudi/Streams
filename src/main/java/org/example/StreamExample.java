package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        //        List<Integer> numList=List.of(1,2,3,4,5,6,7,8,9,10);
//
//
//       List<Integer> squaredList = numList.stream().map(StreamExample::squareIt).collect(Collectors.toList());
//
//       for(Integer i: squaredList){
//           System.out.println(i);
//       }

        TradeDAO tradeDAO= new TradeDAO();
List<Trade> trades= tradeDAO.getLastYearTrades();//

List<Trade> profitTrades= new ArrayList<>();

        // filtering the trades with result > 0. StreamExample::isTradeProfitable in this method we are defining the condition the filter should do
        profitTrades = trades.stream().filter(StreamExample::isTradeProfitable).collect(Collectors.toList());
        profitTrades= trades.stream().filter(x-> x.getResult() > 0).collect(Collectors.toList());

        for(Trade trade:profitTrades){
            System.out.println(trade);
        }



        Set<String> profitTradesSymbols=new HashSet<>();

        for(Trade trade:trades){
            // filtering the trades with result > 0 and extracing a part of trade i.e. symbol and putting it to different collection.
            if(trade.getResult()> 0){
                profitTradesSymbols.add(trade.getSymbol());
            }
        }

        for(String symbol:profitTradesSymbols){
            System.out.println(symbol);
        }

        System.out.println("with streams");

        profitTradesSymbols = trades.stream().filter(x -> x.getResult()>0).map(x -> x.getSymbol()).collect(Collectors.toSet());

        for(String symbol:profitTradesSymbols){
            System.out.println(symbol);
        }

        Map<String,List<Trade>> tradeMap = new HashMap<>();

        for(Trade trade:trades){

            if(tradeMap.containsKey(trade.getSymbol())){
                tradeMap.get(trade.getSymbol()).add(trade);
            }else{
                List<Trade> tradeList = new ArrayList<>();
                tradeList.add(trade);
                tradeMap.put(trade.getSymbol(),tradeList);
            }
        }

        tradeMap = trades.stream().collect(Collectors.groupingBy(x -> x.getSymbol()));
        tradeMap = trades.stream().collect(Collectors.groupingBy(Trade::getSymbol));





    }
//:: operator in Java is called the method reference operator. It is used to refer to a method without invoking it.
    public static  boolean isTradeProfitable(Trade x){
        return x.getResult()>0;
    }


}
