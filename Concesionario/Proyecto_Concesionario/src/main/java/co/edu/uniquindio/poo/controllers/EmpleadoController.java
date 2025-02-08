package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EmpleadoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cerrarSesionBoton;

    @FXML
    private Button gestionarClientesBoton;

    @FXML
    private Button gestionarTransaccionesBoton;

    @FXML
    private Button gestionarVehiculosBoton;

    @FXML
    void cerrarSesionAccion(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/co/edu/uniquindio/poo/inicioSesion.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = App.getStage();
            stage.setScene(new Scene(root));
            stage.setTitle("Inicio Sesión");
            stage.show();
            Sesion.setRol(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    void gestionarClientesAccion(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestionarClientesView.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = App.getStage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión clientes");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gestionarTransaccionesAccion(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/co/edu/uniquindio/poo/gestionarTransaccionesView.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = App.getStage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión transacciones");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gestionarVehiculosAccion(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/gestionarVehiculosView.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = App.getStage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión Vehiculos");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert cerrarSesionBoton != null : "fx:id=\"cerrarSesionBoton\" was not injected: check your FXML file 'empleadoView.fxml'.";
        assert gestionarClientesBoton != null : "fx:id=\"gestionarClientesBoton\" was not injected: check your FXML file 'empleadoView.fxml'.";
        assert gestionarTransaccionesBoton != null : "fx:id=\"gestionarTransaccionesBoton\" was not injected: check your FXML file 'empleadoView.fxml'.";
        assert gestionarVehiculosBoton != null : "fx:id=\"gestionarVehiculosBoton\" was not injected: check your FXML file 'empleadoView.fxml'.";

    }

}

