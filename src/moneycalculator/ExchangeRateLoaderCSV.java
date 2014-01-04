package moneycalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExchangeRateLoaderCSV implements ExchangeRateLoader {
    String URL = "C:\\Users\\Aday\\Documents\\NetBeansProjects\\IS2-MoneyCalc\\eur-rates.csv";
    double value1 = 0;
    double value2 = 0;
    boolean valued = false;
    
    @Override
    public ExchangeRate load(Currency input, Currency output) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(URL)));
            while (true){
                String line = reader.readLine();
                if (line == null) break;
                if (input.getCode().equals(output.getCode())) return new ExchangeRate(input,output,new Number(1));
                else if (line.split(";")[0].equals(input.getCode())||line.split(";")[0].equals(output.getCode())){
                    if (input.getCode().equals("EUR"))
                        return new ExchangeRate(input,output,new Number(Double.parseDouble(line.split(";")[1])));
                    else if (output.getCode().equals("EUR"))
                        return new ExchangeRate(input,output,new Number(Double.parseDouble(line.split(";")[2])));
                    else {
                        if (valued){
                            if (input.getCode().equals(line.split(";")[0]))value2=Double.parseDouble(line.split(";")[2]);
                            else value2=Double.parseDouble(line.split(";")[1]);
                            break;
                        }
                        if (input.getCode().equals(line.split(";")[0]))value1=Double.parseDouble(line.split(";")[2]);
                        else value1=Double.parseDouble(line.split(";")[1]);
                        valued=true;
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
        } 
        catch (IOException ex) {
        }
        return new ExchangeRate(input,output,new Number(value1).multiply(new Number(value2)));
    }

}
