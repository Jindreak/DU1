/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du1;

import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

/**
 *
 * @author Jindra
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label chybne, spravne, slovo;
    
    @FXML
    private Button hadej, jedna, dva, tri,
                   ctyri, pet, sest;
    private Map<String, String> slovnik;
    private String[] nahodneSlovo;
    
    private int skoreSpravne;
    private int skoreSpatne;
    private int predchoziSlovo;
    
    Random rand = new Random();
    Iterator it;
    
    Alert alertSpravne = new Alert(AlertType.CONFIRMATION, "Správná odpověď", ButtonType.OK);
    Alert alertSpatne = new Alert(AlertType.CONFIRMATION, "Chybná odpověď", ButtonType.OK);
    
   public void inicializuj(){
       
        
        skoreSpravne = 0;
        skoreSpatne = 0;
        predchoziSlovo = 22;
        
   }
    
    
    @FXML
    private void hadejTlacitko() {
        jedna.setDisable(false);
        dva.setDisable(false);
        tri.setDisable(false);
        
        ctyri.setDisable(false);
        pet.setDisable(false);
        sest.setDisable(false);
        
        slovnik = new LinkedHashMap<>();
        
        slovnik.put("Jablko", "Apple");
        slovnik.put("Citrón", "Lemon");
        slovnik.put("Banán", "Banana");
        
        slovnik.put("Brambory", "Potatoes");
        slovnik.put("Zelí", "Cabbage");
        slovnik.put("Rajče", "Tomato");
        
        nahodneSlovo = new String[6];
        
        nahodneSlovo[0] = "Apple";
        nahodneSlovo[1] = "Lemon";
        nahodneSlovo[2] = "Banana";
        
        nahodneSlovo[3] = "Potatoes";
        nahodneSlovo[4] = "Cabbage";
        nahodneSlovo[5] = "Tomato";
        
      /*  System.out.print(rand.nextInt(6));
        
        it = slovnik.entrySet().iterator();
        
        for (int i = 0; i < rand.nextInt(6); i++ ){
            it.next();
        }*/
      
      Integer i = rand.nextInt(6);
      
      while (i == predchoziSlovo){
          
          i = rand.nextInt(6);
      }
      
      predchoziSlovo = i;
      String s = nahodneSlovo[i];
      
      slovo.setText(s);
      
        
        
    }
    
    @FXML
    private void hadaniHandlerJablko(){
      String s = slovo.getText();
      
     hadani(s,"Apple");
      
      }
    
    @FXML
    private void hadaniHandlerBanan(){
      String s = slovo.getText();
      
     hadani(s,"Banana");
      
     }
    
    @FXML
    private void hadaniHandlerZeli(){
      String s = slovo.getText();
      
     hadani(s,"Cabbage");
      
     }
    
    @FXML
    private void hadaniHandlerCitron(){
      String s = slovo.getText();
      
     hadani(s,"Lemon");
      
     }
    
    @FXML
    private void hadaniHandlerBrambor(){
      String s = slovo.getText();
      
     hadani(s,"Potatoes");
      
     }
    
    @FXML
    private void hadaniHandlerRajce(){
      String s = slovo.getText();
      
     hadani(s,"Tomato");
      
     }
    
    private void hadani (String zkoumaneSlovo, String spravneSlovo){
        
        if (zkoumaneSlovo.equals(spravneSlovo)){
          
          alertSpravne.showAndWait();
          skoreSpravne ++;
          spravne.setText("Počet správně: "+skoreSpravne);
          hadejTlacitko();
          
      }else{
          
          alertSpatne.showAndWait();
          skoreSpatne ++;
          chybne.setText("Počet chybně: "+skoreSpatne);
          
      }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
