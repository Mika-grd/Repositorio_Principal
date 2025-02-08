package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Concesionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrarAdministradorController {

        private Concesionario concesionario = Concesionario.getInstancia();

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private PasswordField contraseñaCampo;

        @FXML
        private TextField emailCampo;

        @FXML
        private TextField emailField;

        @FXML
        private TextField idCampo;

        @FXML
        private TextField nombreCampo;

        @FXML
        private Button registrarBoton;

        @FXML
        private TextField usuarioCampo;

        @FXML
        void registrarseAccion(ActionEvent event) {
                if (validarTextFields(idCampo, nombreCampo, emailCampo, usuarioCampo, contraseñaCampo)) {

                        Administrador administrador = new Administrador(idCampo.getText(), nombreCampo.getText(), true,
                                        emailCampo.getText(), usuarioCampo.getText(), contraseñaCampo.getText());
                        concesionario.añadirEmpleado(administrador);
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Alertaaaaa");
                        alert.setContentText("Creado con exito");
                        alert.showAndWait();
                        FXMLLoader loader = new FXMLLoader(
                                        getClass().getResource("/co/edu/uniquindio/poo/inicioSesion.fxml"));
                        try {
                                Parent root = loader.load();
                                Stage stage = (Stage) registrarBoton.getScene().getWindow();
                                stage.setScene(new Scene(root));
                                stage.setTitle("inicioSesionController");
                                stage.show();
                        } catch (IOException e) {
                                e.printStackTrace(); // Manejar el error si no se puede cargar la vista
                        }
                } else{
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Alerta");
                        alert.setContentText("Llene todos los datos");
                        alert.showAndWait();
                }
        }

        @FXML
        void initialize() {
                assert contraseñaCampo != null
                                : "fx:id=\"contraseñaCampo\" was not injected: check your FXML file 'registrarAdministradorView.fxml'.";
                assert emailCampo != null
                                : "fx:id=\"emailCampo\" was not injected: check your FXML file 'registrarAdministradorView.fxml'.";
                assert emailField != null
                                : "fx:id=\"emailField\" was not injected: check your FXML file 'registrarAdministradorView.fxml'.";
                assert idCampo != null
                                : "fx:id=\"idCampo\" was not injected: check your FXML file 'registrarAdministradorView.fxml'.";
                assert nombreCampo != null
                                : "fx:id=\"nombreCampo\" was not injected: check your FXML file 'registrarAdministradorView.fxml'.";
                assert registrarBoton != null
                                : "fx:id=\"registrarBoton\" was not injected: check your FXML file 'registrarAdministradorView.fxml'.";
                assert usuarioCampo != null
                                : "fx:id=\"usuarioCampo\" was not injected: check your FXML file 'registrarAdministradorView.fxml'.";

        }

        public static boolean validarTextFields(TextField... campos) {

                for (TextField campo : campos) {
                        if (campo.getText() == null || campo.getText().trim().isEmpty()) {
                                campo.setStyle("-fx-border-color: red;");
                                return false;
                        } else {
                                campo.setStyle("");
                        }
                }
                return true;
        }

}
