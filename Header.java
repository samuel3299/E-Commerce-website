package com.example.supplychain;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Header {
    public AnchorPane root;
    Header() throws IOException {
        root = FXMLLoader.load(getClass().getResource("header.fxml"));
    }
}
