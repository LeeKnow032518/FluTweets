package ru.ibs.flutweets.processor;

import ru.ibs.flutweets.data.FluTweet;
import ru.ibs.flutweets.data.State;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AnalyseTweets {
    public static Map<String, String> findFlu(List<FluTweet> tweets, List<State> states){

        // key = tweet's text, value = state
        Map<String, String> found = tweets.stream().filter(s -> Pattern.compile("\\b(flu|#flu)[^a-z]*\\b").matcher(s.getText().toLowerCase()).find())
                .collect(Collectors.toMap(FluTweet::getText, s -> findState(s, states)));

        return found;
    }

    public static String findState(FluTweet ft, List<State> states){
        Optional<String> result = states.stream().sorted((s, l) -> euclidianDistance(ft, s).compareTo(euclidianDistance(ft, l)))
                .limit(1).map(State::getName).findFirst();

        String name = null;
        if(result.isPresent()){
            name = result.get();
        }
        return name;
    }

    public static BigDecimal euclidianDistance(FluTweet tweet, State state){
        BigDecimal subLat = tweet.getLatitude().subtract(state.getLatitude());
        BigDecimal subLon = tweet.getLongitude().subtract(state.getLongitude());
        MathContext mc = new MathContext(10);

        return subLon.multiply(subLon).add(subLat.multiply(subLat)).sqrt(mc);
    }
}
