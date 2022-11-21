package com.example.supplychain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductPage {
    ListView<HBox> products;

    ListView<HBox> showProductNames(String search) throws SQLException {
        ObservableList<HBox> productList = FXCollections.observableArrayList();
        ResultSet res = HelloApplication.connect.executeQuery("Select * from product");
        products = new ListView<>();
        Label name = new Label();
        Label price = new Label();
        Label id = new Label();
        Label buy = new Label();
        HBox details = new HBox();

        name.setMinWidth(100);
        price.setMinWidth(100);
        id.setMinWidth(100);
        name.setText("Name");
        price.setText("Price");
        id.setText("ProductId");
        buy.setText("buy");


        details.getChildren().addAll(id,name,price,buy);
        productList.add(details);
        while(res.next()){
            if(res.getString("ProductName").toLowerCase().contains(search.toLowerCase())) {
                Label productName = new Label();
                Label ProductPrice = new Label();
                Label ProductId = new Label();
                Button b1 = new Button();
                HBox ProductDetails = new HBox();

                productName.setMinWidth(100);
                ProductPrice.setMinWidth(100);
                ProductId.setMinWidth(100);
                productName.setText(res.getString("ProductName"));
                ProductPrice.setText(res.getString("Price"));
                ProductId.setText(res.getString("ProductId"));
                b1.setText("buy");

                b1.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if (HelloApplication.emailId.equals("")) {
                            Dialog<String> dialog = new Dialog<>();
                            dialog.setTitle("Login Error");
                            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                            dialog.setContentText("Error!! Login to Place Order");
                            dialog.getDialogPane().getButtonTypes().add(type);
                            dialog.showAndWait();
                        } else {
                            Order ord = new Order();
                            try {
                                ord.PlaceOrder(ProductId.getText());
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });

                ProductDetails.getChildren().addAll(ProductId, productName, ProductPrice, b1);
                productList.add(ProductDetails);
            }
        }
        products.setItems(productList);
        return products;
    }
    ListView<HBox> showProducts() throws SQLException {
        ObservableList<HBox> productList = FXCollections.observableArrayList();
        ResultSet res = HelloApplication.connect.executeQuery("Select * from product");
        products = new ListView<>();
        Label name = new Label();
        Label price = new Label();
        Label id = new Label();
        Label buy = new Label();
        HBox details = new HBox();

        name.setMinWidth(100);
        price.setMinWidth(100);
        id.setMinWidth(100);
       name.setText("Name");
        price.setText("Price");
        id.setText("ProductId");
        buy.setText("buy");


        details.getChildren().addAll(id,name,price,buy);
        productList.add(details);
        while(res.next()){
        Label productName = new Label();
        Label ProductPrice = new Label();
        Label ProductId = new Label();
        Button b1 = new Button();
        HBox ProductDetails = new HBox();

            productName.setMinWidth(100);
            ProductPrice.setMinWidth(100);
            ProductId.setMinWidth(100);
        productName.setText(res.getString("ProductName"));
        ProductPrice.setText(res.getString("Price"));
        ProductId.setText(res.getString("ProductId"));
        b1.setText("buy");

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(HelloApplication.emailId.equals("")){
                    Dialog<String> dialog = new Dialog<>();
                    dialog.setTitle("Login Error");
                    ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    dialog.setContentText("Error!! Login to Place Order");
                    dialog.getDialogPane().getButtonTypes().add(type);
                    dialog.showAndWait();
                }
                else {
                   Order ord = new Order();
                    try {
                        ord.PlaceOrder(ProductId.getText());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        ProductDetails.getChildren().addAll(ProductId,productName,ProductPrice,b1);
        productList.add(ProductDetails);
        }
        products.setItems(productList);
        return products;
    }
}
