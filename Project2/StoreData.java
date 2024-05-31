
// class used to dtore data in a hashMap

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class StoreData{


    private String file;
    private String securityName;
    private Double price;

    StoreData(String filePath){

        this.file = filePath;
    }

    public StoreData(String securityName, Double price) {
        this.securityName = securityName;
        this.price = price;
    }


    public void storeInHashMap(){


        ConcurrentHashMap<String,StoreData> data = new ConcurrentHashMap<>();

        try {

            // path for file
            File file = new File(this.file);

            // scanner to read from the file

            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();

                String[] fields = line.split(",");

                String symbol = fields[0];
                String securityName = fields[1];

                double currentPrice = Double.parseDouble(fields[6]);

                StoreData value = new StoreData(securityName, currentPrice);

                data.put(symbol, value);

            }



            
        } catch (Exception e) {
            e.printStackTrace();
        }


        // printData(data);
    }


    @Override
    public String toString() {
        return "StoreData [securityName=" + securityName + ", price=" + price + "]";
    }

    public void printData(ConcurrentHashMap<String,StoreData> data){

        for(Map.Entry<String, StoreData> entry : data.entrySet()){

            System.out.println("Key : " + entry.getKey() + "\tValues" + entry.getValue());

        }


    }



}