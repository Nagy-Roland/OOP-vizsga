/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ro.umfst.vizsga;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
/**
 *
 * @author Laptop
 */
public class Vizsga {

   public static void main(String[] args) {

        Thread SetupThread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<JsonStructure.Intake> intakes = JsonReader.getIntakeList();
                JsonWriter.writeIntakesToFile(intakes,"C:\\Users\\Laptop\\Documents\\NetBeansProjects\\vizsga\\Output.txt");    
                
                
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new VizsgaFrame();
                        System.out.println("Gui started");
                    }
                });
            }
        });
        SetupThread.start();
    }
}
