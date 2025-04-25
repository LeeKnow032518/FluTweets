package ru.ibs.flutweets.datamanagement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.ibs.flutweets.data.FluTweet;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

public class JsonFileReading {
    public static List<FluTweet> getJsonData(String pathName){
        List<FluTweet> tweets = new ArrayList<>();

        JSONArray jarray = null;
        try{
            Object obj = new JSONParser().parse(new FileReader(pathName));
            jarray = (JSONArray) obj;
        }catch(IOException | ParseException e){
            System.out.println(e.toString());
        }

        if(jarray != null){
            for(Object o : jarray){
                JSONObject jobj = (JSONObject) o;

                // parse coordinates
                JSONArray jcoords = (JSONArray) jobj.get("location");
                BigDecimal latitude = new BigDecimal(jcoords.get(0).toString());
                BigDecimal longitude = new BigDecimal(jcoords.get(1).toString());

                // parse date and time
                String[] dateTime = jobj.get("time").toString().split(" ");
                String[] date = dateTime[0].split("-");
                String[] time = dateTime[1].split(":");

                LocalDateTime ldt = LocalDateTime.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]),
                        Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));

                // create new tweet data

                tweets.add(new FluTweet(latitude, longitude, ldt, jobj.get("text").toString()));
            }
        }

        return tweets;
    }
}
