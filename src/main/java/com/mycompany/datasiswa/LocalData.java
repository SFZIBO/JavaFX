/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.datasiswa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author lenovo
 */
public class LocalData extends PrimaryController {
    private final String filePath = "data.txt";
    /*
    
    private void insertData() throws IOException{
        try(BufferedWriter write = new BufferedWriter(new FileWriter(filePath))){
            writer.write(dataInput.getText());
        }catch(IOException e){
            e.printStackTrace();
        }
    }*/
}
