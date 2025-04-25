package ru.ibs.flutweets;

import ru.ibs.flutweets.data.State;
import ru.ibs.flutweets.datamanagement.JsonFileReading;
import ru.ibs.flutweets.datamanagement.StatesFileReading;
import ru.ibs.flutweets.processor.AnalyseEntry;
import ru.ibs.flutweets.datamanagement.TxtFileReading;
import ru.ibs.flutweets.data.FluTweet;
import ru.ibs.flutweets.processor.AnalyseTweets;
import ru.ibs.flutweets.logging.LogWriter;
import ru.ibs.flutweets.ui.Printer;

import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //args = new String[]{"text", "src/flu_tweets.txt", "src/states.csv", "src/log.txt"};
        try {
            AnalyseEntry.argsCheck(args);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        List<FluTweet> ft = (args[0].equalsIgnoreCase("text")) ? TxtFileReading.getTxtData(args[1])
                : JsonFileReading.getJsonData(args[1]);
        List<State> states = StatesFileReading.getStatesData(args[2]);

        Map<String, String> statistic = AnalyseTweets.findFlu(ft, states);
        LogWriter.logWriting(statistic, args[3]);

        Printer.printStatistic(statistic);
    }
}