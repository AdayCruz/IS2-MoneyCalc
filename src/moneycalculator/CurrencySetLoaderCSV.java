package moneycalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CurrencySetLoaderCSV implements CurrencySetLoader{

    @Override
    public void load(String URL) {
        CurrencySet instance = CurrencySet.getInstance();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(URL)));
            while (true){
                String line = reader.readLine();
                if (line == null) break;
                if (!line.endsWith(";")){
                instance.add(
                        new Currency(line.split(";")[0],line.split(";")[1],line.split(";")[2]));
                }else{
                instance.add(
                        new Currency(line.split(";")[0],line.split(";")[1]));
                }
            }
        }
        catch (FileNotFoundException e) {
        } 
        catch (IOException ex) {
        }
    }

}
