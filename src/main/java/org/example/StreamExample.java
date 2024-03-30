package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        //       Concept Practice
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

        /**
         * create a key value collection where key is symbol and value is list of trade.
         * Tcs -> List<Trades> of symbol TCS only.
         * */

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


// using reduce method to calc sum of profit(getResult variable is profit in this case)

        Double totalResult = 0.0;

        for(Trade trade: trades){
            totalResult= totalResult+ trade.getResult();
        }

        trades.stream().map(x->x.getResult()).reduce(0.0,Double::sum);
        trades.stream().map(x -> x.getResult()).reduce(0.0,(x,y) -> x+y);

        trades.stream().mapToDouble(x-> x.getResult()).sum();
        trades.stream().mapToDouble(x-> x.getResult()).max();


        Stream<Double> a = trades.stream().map(x -> x.getResult());
        DoubleStream b=  trades.stream().mapToDouble(x-> x.getResult());



        trades.stream().map(Trade::getSymbol).peek(System.out::println).collect(Collectors.toList());



        /***
         * match
         *
         * */

        for(Trade trade:trades) {
            if (trade.getSymbol().equals("RELIANCE")) {
                // 10 lines of code

            }

            if (trades.stream().anyMatch(x -> x.getSymbol().equals("RELIANCE"))) {
                // 10 lines of code
            }

            if (trades.stream().noneMatch(x -> x.getSymbol().equals("RELIANCE"))) {
                // 10 lines of code
            }
            if (trades.stream().allMatch(x -> x.getResult() != 0)) {
                // 10 lines of code
            }





            /***
             * OPTIONAL concept of java8   - It's used to handle null pointer exceptions
             * */

            Person person = getMyPerson2();//This method returns null as seen in the method getMyPerson2, so it is null pointer exception as it's an unchecked exception
            if (person != null) {
                System.out.println(person.getName());
            }
            Optional<Person> optionalPerson = getMyPerson();
            if (optionalPerson != null && optionalPerson.isPresent()) {
                Person p = optionalPerson.get();
            }
            if (optionalPerson != null && optionalPerson.isEmpty()) {
                Person p = new Person("john", 20);
            }
            if (optionalPerson != null) {
                Person p = optionalPerson.orElse(new Person("john", 20));
            }

        }}
//'::' Scope operator in Java is called the method reference operator. It is used to refer to a method without invoking it.
    public static  boolean isTradeProfitable(Trade x){
        return x.getResult()>0;
    }

        public static Integer squareIt(Integer x){
            return x*x;
        }

    private static Optional<Person> getMyPerson() {

        return null;
    }

    private  static  Person getMyPerson2(){
        return null;
    }



        /***
         1. there is a stream of Integers from numList
         2. map -> we want to take an action on the items flowing the stream. Action here is : calling a squareIt method
         3. collecting the return of the SquareIt into a different list and assigning it back to SquaredList.
         * */


        /**
         * Stream functions
         *
         * 1. Filter -> filters the items based on the conditions provided in form predicate.
         * 2. Map -> Covert/map the item into the another data type or object that is required.
         * 3. Flatmap -> opens a small stream for every item in the main stream and converts it into a new stream.
         * */


    }
