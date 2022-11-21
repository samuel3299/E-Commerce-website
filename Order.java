package com.example.supplychain;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
    void PlaceOrder(String ProductId) throws SQLException {
        ResultSet res = HelloApplication.connect.executeQuery("Select max(orderId) from orders");
        int orderId = 0;
        if(res.next())
            orderId = res.getInt("max(orderId)") +1;
        String query = String.format("Insert into orders values(%s,%s,'%s')", orderId,ProductId,HelloApplication.emailId);
        int response = HelloApplication.connect.UpdateQuery(query);
        if(response>0){
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Order Details");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Your Order is placed TQ!!");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
            System.out.println("Order is Placed");
        }
    }
}
