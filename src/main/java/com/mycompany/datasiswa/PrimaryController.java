package com.mycompany.datasiswa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;
import java.util.List;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

/*
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
*/
    @FXML
    private Label txtID;
    @FXML
    private Label txtNIS;
    @FXML
    private Label txtNama;
    @FXML
    private Label txtKelas;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfNIS;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfKelas;
    @FXML
    private TableView<DataSiswa> tvSiswa;
    
    private ObservableList<DataSiswa> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<DataSiswa, String> colID;
    @FXML
    private TableColumn<DataSiswa, Integer> colNIS;
    @FXML
    private TableColumn<DataSiswa, String> colNama;
    @FXML
    private TableColumn<DataSiswa, String> colKelas;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnSave;
    
    public void siswa(String ID, int NIS, String Nama,String Kelas){
        
        ID = tfID.getText();
        NIS = Integer.parseInt(tfNIS.getText());
        Nama = tfNama.getText();
        Kelas = tfKelas.getText();
        
        
        tvSiswa.getItems().add(new DataSiswa(ID, NIS,Nama,Kelas));
        
        //Reset Nilai Input setelah menambahkan data
        tfID.clear();
        tfNIS.clear();
        tfNama.clear();
        tfKelas.clear();
    }
    
    private void handleMouseAction(ActionEvent event) {
        if(event.getSource() == btnInsert){
            insertButton(event);
        }
    }    
    public void initialize(URL url, ResourceBundle rb){
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colNIS.setCellValueFactory(new PropertyValueFactory<>("NIS"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        colKelas.setCellValueFactory(new PropertyValueFactory<>("Kelas"));
        
        //Menghubungkan data ke tabel
        tvSiswa.setItems(data);
        //load Data
        loadDataFromFile();
    }
    
    
    @FXML
    public void insertButton(ActionEvent event){
        showDataSiswa();
        
        String ID = tfID.getText();
        int NIS = Integer.parseInt(tfNIS.getText());
        String Nama = tfNama.getText();
        String Kelas = tfKelas.getText();

    DataSiswa newData = new DataSiswa(ID,NIS,Nama,Kelas);
    data.add(newData);

    // Bersihkan teks field setelah menambahkan data
        ID = tfID.getText();
        NIS = Integer.parseInt(tfNIS.getText());
        Nama = tfNama.getText();
        Kelas = tfKelas.getText();
    }
    
    @FXML
    public void deleteButton(ActionEvent event){
     // Dapatkan item terpilih dari tabel
    DataSiswa selectedSiswa = tvSiswa.getSelectionModel().getSelectedItem();

    // Periksa apakah ada item terpilih sebelum menghapus
    if (selectedSiswa != null) {
        // Hapus item dari ObservableList
        data.remove(selectedSiswa);
    } else {
        // Tampilkan pesan atau berikan umpan balik bahwa tidak ada item terpilih
        System.out.println("Tidak ada data terpilih untuk dihapus.");
    }
    }
    
    
    @FXML
    public void saveButton(ActionEvent event){
        saveDataToFile();
    }
    
    
        // Metode untuk menyimpan data ke dalam file
    public void saveDataToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.dat"))) {
            out.writeObject(new ArrayList<>(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        // Metode untuk membaca data dari file
    public void loadDataFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.dat"))) {
            List<DataSiswa> savedData = (List<DataSiswa>) in.readObject();
            data.setAll(savedData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        
        
        
    /*
    @FXML
    public void insertButton(ActionEvent event){
        
        String query = "INSERT INTO DataSiswa VALUES (" + tfID.getText() + ",'" + tfNIS.getText() + "','" +
                tfNama.getText() + "'," + tfKelas.getText() + ")";
        executeQuery(query);
        showDataSiswa();
    }
    
    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeQuery(query);
        }catch(Exception ex){
            ex.printStackTrace();
    }}
        */


    /*
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_datasiswa", "root","");
            return conn;
        }catch(Exception ex){
            System.out.print("Error: " + ex.getMessage());
            return null;
        }
        
    }
    /*
    public ObservableList<DataSiswa> getDataList(){
        ObservableList<DataSiswa> dataList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM tb_datasiswa";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            DataSiswa DataSiswa;
            while(rs.next()){
                DataSiswa = new DataSiswa(rs.getString("ID"), rs.getInt("NIS"), rs.getString("Nama"), rs.getString("Kelas"));
                dataList.add(DataSiswa);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dataList;
    }
    */
    public void showDataSiswa(){
        //ObservableList<DataSiswa> List = getDataList();
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colNIS.setCellValueFactory(new PropertyValueFactory<>("NIS"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("Nama"));
        colKelas.setCellValueFactory(new PropertyValueFactory<>("Kelas"));
        
        //Menghubungkan data ke tabel
        tvSiswa.setItems(data);
    }
    public void saveData (){
        //ObservableList<DataSiswa> data = tvSiswa.getItems();
        
        //baru
        ObservableList<DataSiswa> data = tvSiswa.getItems();
        List<DataSiswa> dataList = new ArrayList<>(data);

         try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.dat"))){
             out.writeObject(dataList);
         }catch (IOException e){
             e.printStackTrace();
         }        
    }
    
    public void readData(){
        
        File file = new File("data.dat");
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("data.dat"))){
            
            //List<DataSiswa> data = (List<DataSiswa>) input.readObject();
            List<DataSiswa> data = new ArrayList<>(tvSiswa.getItems());
            tvSiswa.getItems().setAll(data);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
    }




}
