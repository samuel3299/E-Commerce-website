package com.example.supplychain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class HelloApplication extends Application {
    public static Connector connect;
    public static Group root;
    public static String emailId;
    public static  Header head;
    public void start(Stage stage) throws IOException, SQLException {
        emailId = "";
       connect = new Connector();
       root = new Group();
      head = new Header();
       ProductPage product = new ProductPage();
        ListView<HBox> productzList = product.showProducts();
        AnchorPane ProductPane = new AnchorPane();
        ProductPane.setLayoutX(50);
        ProductPane.setLayoutY(70);
        productzList.setPrefWidth(400);
        ProductPane.getChildren().add(productzList);
       root.getChildren().addAll(head.root,ProductPane);
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Supply Chain");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e ->{
            try{
                connect.con.close();
//                System.out.println("Connection is close");
            }
            catch(Exception ec){
                ec.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}