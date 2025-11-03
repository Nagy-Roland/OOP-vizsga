/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.umfst.vizsga;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Laptop
 */

public class JsonWriter {

    public static void writeIntakesToFile(List<JsonStructure.Intake> intakes, String path) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), intakes);
            System.out.println("Successfully wrote intakes to " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


