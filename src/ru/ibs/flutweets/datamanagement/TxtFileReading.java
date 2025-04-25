package ru.ibs.flutweets.datamanagement;

import ru.ibs.flutweets.data.FluTweet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class TxtFileReading {
    public static List<FluTweet> getTxtData(String pathName){
        List<FluTweet> tweets = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(pathName))){
            String line;
            while((line = br.readLine()) != null){
                String[] readLine = line.split("\t");

                // parse coordinates
                String[] coords = readLine[0].substring(1, readLine[0].length()-1).split(", ");
                BigDecimal latitude = new BigDecimal(coords[0]);
                BigDecimal longitude = new BigDecimal(coords[1]);

                // parse date and time
                String[] dateTime = readLine[2].split(" ");
                String[] date = dateTime[0].split("-");
                String[] time = dateTime[1].split(":");

                LocalDateTime ldt = LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]),
                        Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));

                // create new tweet data
                tweets.add(new FluTweet(latitude, longitude, ldt, readLine[3]));
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        return tweets;
    }
}
