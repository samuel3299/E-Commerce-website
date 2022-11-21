package com.example.supplychain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginPageController {
    @FXML
    TextField UserID;
    @FXML
    PasswordField Password;
    @FXML
    public void loginNow(MouseEvent Event) throws SQLException, IOException {
       String query = String.format("Select * from usertable where emailId = '%s' and pass = '%s'", UserID.getText(), Password.getText());
        ResultSet res = HelloApplication.connect.executeQuery(query);
        if(res.next()){
            HelloApplication.emailId = res.getString("emailId");
            String userType = res.getString("userType");
            if(userType.equals("Seller")) {
                AnchorPane buyerPage = FXMLLoader.load(getClass().getResource("SellerPage.fxml"));
                HelloApplication.root.getChildren().add(buyerPage);
            }
            else{
                ProductPage product = new ProductPage();
                Header header = new Header();
                System.out.println("Logged in as Buyer");
                ListView<HBox> productzList = product.showProducts();
                AnchorPane ProductPane = new AnchorPane();
//                ProductPane.setMinWidth(120);
                ProductPane.setLayoutX(50);
                ProductPane.setLayoutY(70);
                productzList.setPrefWidth(400);
                ProductPane.getChildren().add(productzList);
                HelloApplication.root.getChildren().clear();
                HelloApplication.root.getChildren().addAll(header.root, ProductPane);
            }
        }
        else{
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Product details");
            ButtonType type = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.setContentText("Error!! check Login details");
            dialog.getDialogPane().getButtonTypes().add(type);
            dialog.showAndWait();
        }
    }
}
