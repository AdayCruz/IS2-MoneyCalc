package moneycalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExchangeRateLoaderCSV implements ExchangeRateLoader {
    
    Number rate;
    
    @Override
    public ExchangeRate load(Currency input, Currency output, String URL) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(URL)));
            while (true){
                String line = reader.readLine();
                if (line == null) break;
                if (line.split(";")[0].equals(input.getCode())||line.split(";")[0].equals(output.getCode())){
                    if (input.getCode().equals("EUR"))
                        rate = new Number(Double.parseDouble(line.split(";")[1]));
                    else if (output.getCode().equals("EUR"))
                        rate = new Number(Double.parseDouble(line.split(";")[2]));
                }
            }
        }
        catch (FileNotFoundException e) {
        } 
        catch (IOException ex) {
        }
        return new ExchangeRate(input,output,rate);
    }

}
