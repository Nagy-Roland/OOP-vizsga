/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Laptop
 */
package ro.umfst.vizsga;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    
    public static List<JsonStructure.Intake> getIntakeList() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
        
        InputStream input = JsonReader.class.getResourceAsStream("/VizsgaJson.json");
        JsonStructure data = objectMapper.readValue(input, JsonStructure.class);
        return data.getIntakes(); 
    } catch (InvalidFormatException e){
        e.printStackTrace();
        return new ArrayList<>();
    
    } catch (IOException e) {
        e.printStackTrace();
        return new ArrayList<>(); 
    }
}
}

