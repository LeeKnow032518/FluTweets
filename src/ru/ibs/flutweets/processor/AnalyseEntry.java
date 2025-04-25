package ru.ibs.flutweets.processor;

/*  args[0] = text / json
*   args[1] = flu_tweets.json / .txt
*   args[2] = states.csv
*   args[3] = log.txt
* */

import java.io.IOException;
import java.nio.file.*;

public class AnalyseEntry {
    public static void argsCheck(String[] args) throws IllegalArgumentException{

        if(args.length != 4){
            throw new IllegalArgumentException("Wrong number of arguments");
        }


        if(!args[0].equalsIgnoreCase("text") && !args[0].equalsIgnoreCase("json")){
            throw new IllegalArgumentException("Wrong file format");
        }

        String format = args[1].split("\\.")[1];
        if((format.equals("txt") && args[0].equalsIgnoreCase("json"))
        || (format.equals("json") && args[0].equalsIgnoreCase("text"))){
            throw new IllegalArgumentException("Wrong file extention");
        }

        Path path = Paths.get(args[1]);
        if(!Files.exists(path) || !Files.isReadable(path)){
            throw new IllegalArgumentException("Cannot open file " + path.toString());
        }

        path = Paths.get(args[2]);
        if(!Files.exists(path) || !Files.isReadable(path)){
            throw new IllegalArgumentException("Cannot open file" + path.toString());
        }

        createLog(args[3]);
    }

    public static void createLog(String name){
        Path path = Paths.get(name);
        //Path path = Paths.get("src/".concat(name));
        if(!Files.exists(path)){
            try{
                Files.createFile(path);
            }catch (IOException e){
                System.out.println(e.toString());
            }
        }
    }
}
