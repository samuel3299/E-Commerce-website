package com.example.supplychain;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.SQLException;


public class HeaderController {
     static AnchorPane loginpage;
    @FXML
    Button Loginbtn;
    @FXML
    Button Searched;
    @FXML
    TextField Searchtxt;
    @FXML
    Button Logoutoff;
    @FXML
    Label email;
    public void initialize(){
    if(!HelloApplication.emailId.equals("")){
        Loginbtn.setOpacity(0);
        email.setText(HelloApplication.emailId);
    }
    }

    @FXML
    public void login(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Searchtxt.setOpacity(0);
        Searched.setOpacity(0);
         loginpage = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        HelloApplication.root.getChildren().add(loginpage);
    }
    @FXML

    public void Search(MouseEvent mouseEvent) throws SQLException, IOException {
        if(Searched.getOpacity() == 1) {
            ProductPage pg = new ProductPage();
            Header header = new Header();
            AnchorPane anc = new AnchorPane();
            anc.setLayoutY(50);
            anc.setLayoutY(70);
            ListView<HBox> productzList = pg.showProductNames(Searchtxt.getText());
            productzList.setLayoutX(50);
            productzList.setPrefWidth(400);
            anc.getChildren().add(productzList);
            HelloApplication.root.getChildren().clear();
            HelloApplication.root.getChildren().addAll(header.root, anc);
        }
    }
    @FXML
    public void logout(MouseEvent mouseEvent) throws IOException, SQLException {
        if(Logoutoff.getOpacity() == 1) {
            Logoutoff.setOpacity(0);
            HelloApplication.emailId = "";
            Header head = new Header();
            ProductPage product = new ProductPage();
            ListView<HBox> productzList = product.showProducts();
            AnchorPane ProductPane = new AnchorPane();
            ProductPane.setLayoutX(50);
            ProductPane.setLayoutY(70);
            productzList.setPrefWidth(400);
            ProductPane.getChildren().add(productzList);
            HelloApplication.root.getChildren().clear();
            HelloApplication.root.getChildren().addAll(head.root,ProductPane);
        }
    }
    @FXML
    public void Logoutappear(MouseEvent mouseEvent) {
        if(Logoutoff.getOpacity() == 0){
            Logoutoff.setOpacity(1);
        }
        else{
            Logoutoff.setOpacity(0);
        }
    }
}
