/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.datasiswa;

/**
 *
 * @author lenovo
 */
public class DataSiswa {
    private String ID;
    private int NIS;
    private String Nama;
    private String Kelas;
    
    public DataSiswa(String ID,int NIS,String Nama,String Kelas){
        this.ID = ID;
        this.Kelas = Kelas;
        this.Nama = Nama;
        this.NIS = NIS;
    }

    DataSiswa() {
    }
    
    public String getID(){
        return ID;
    }
    public int getNIS(){
        return NIS;
    }
    public String getNama(){
        return Nama;
    }
    public String getKelas(){
        return Kelas;
    }
    
}

