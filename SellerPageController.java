package com.example.supplychain;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerPageController {
    @FXML
    TextField Name;
    @FXML
    TextField Price;
    @FXML
    TextField SellerId;
    @FXML
    public void Add(MouseEvent mouseEvent) throws SQLException {
        ResultSet res = HelloApplication.connect.executeQuery("Select max(ProductId) from product");
        int id =0;
        if(res.next()) {
            id = res.getInt("max(ProductId)") +1;
        }
        String query = String.format("Insert Into Product values(%s,'%s',%s,'%s')",id,Name.getText(),Price.getText(),SellerId.getText());
        int answer = HelloApplication.connect.UpdateQuery(query);
        System.out.println("Product is added");
        if(answer > 0){
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Product details");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("New Product "+Name.getText()+" is added");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
        }
    }
