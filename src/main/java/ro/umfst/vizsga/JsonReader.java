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
    List<JsonStructure.Intake> validIntakes = new ArrayList<>();

    try (InputStream input = JsonReader.class.getResourceAsStream("/VizsgaJson.json")) {

        
        Map<?, ?> root = objectMapper.readValue(input, Map.class);
        List<?> intakesRaw = (List<?>) root.get("intakes");

        if (intakesRaw != null) {
            for (Object rawObj : intakesRaw) {
                try {
                   
                    String intakeJson = objectMapper.writeValueAsString(rawObj);
                    JsonStructure.Intake intake = objectMapper.readValue(intakeJson, JsonStructure.Intake.class);
                    validIntakes.add(intake);
                } catch (Exception e) {
                    System.out.println("Skipping invalid intake: " + rawObj);
                }
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    return validIntakes;
}

}

