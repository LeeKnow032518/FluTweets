package ru.ibs.flutweets.datamanagement;

import ru.ibs.flutweets.data.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class StatesFileReading {
    public static List<State> getStatesData(String pathName) {
        List<State> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(pathName))){
            String line = br.readLine();
            while((line = br.readLine()) != null){
                String[] readLine = line.split(",");
                list.add(new State(new BigDecimal(readLine[1]), new BigDecimal(readLine[2]), readLine[0]));
            }
        }catch (IOException e){
            System.out.println(e.toString());
        }
        return list;
    }
}
