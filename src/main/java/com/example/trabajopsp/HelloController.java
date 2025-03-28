package com.example.trabajopsp;


import com.example.trabajopsp.Enumerados.Estado;
import com.example.trabajopsp.Modelo.Correo;
import com.example.trabajopsp.Servicio.EmailReader;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private TableView<Correo> tableEmails;
    @FXML
    private TableColumn<Correo, String> colEnunciado;
    @FXML
    private TableColumn<Correo, String> colContenido;
    @FXML
    private TableColumn<Correo, String> colEstado;

    private ObservableList<Correo> listaCorreos;

    @FXML
    public void initialize() {
        EmailReader emailReader = new EmailReader();
        List<Correo> emails = emailReader.EmailReader();
        listaCorreos = FXCollections.observableArrayList();
        for (Correo correo : emails) {
            listaCorreos.add(correo);
        }
        // Vincular los datos a las columnas de la tabla
        colEnunciado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEnunciado()));
        colContenido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContenido()));
        colEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEstado()));

        // Cargar los correos en la tabla
        tableEmails.setItems(listaCorreos);
    }

}
