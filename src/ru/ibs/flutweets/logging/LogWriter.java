package ru.ibs.flutweets.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LogWriter {
    public static void logWriting(Map<String, String> data, String pathName){
        try(FileWriter fw = new FileWriter(pathName)){
            for(String key : data.keySet()){
                fw.write(data.get(key) + "\t" + key + "\n");
            }
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
