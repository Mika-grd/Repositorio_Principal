package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.Sesion.Rol;
import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Pagination;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class GestionarEmpleadosController {
    private Concesionario concesionario = Concesionario.getInstancia();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Empleado, Boolean> estadoColumna;

    @FXML
    private TextField busquedaCampo;

    @FXML
    private Button añadirEmpleadoBoton;

    @FXML
    private Button añadirAdministradorBoton;

    @FXML
    private TableColumn<Empleado, String> emailColumna;

    @FXML
    private Pagination paginacionTabla;

    @FXML
    private TableColumn<Empleado, String> iDColumna;

    @FXML
    private ComboBox<String> atributoABuscarCombo;

    @FXML
    private Button eliminarBoton;

    @FXML
    private TextField EmpleadoCedulaCampo;

    @FXML
    private TextField EmpleadoEmailCampo;

    @FXML
    private TableColumn<Empleado, String> usuarioColumna;

    @FXML
    private Button desbloquearBoton;

    @FXML
    private TextField EmpleadoNombreCampo;

    @FXML
    private TextField EmpleadoUsuarioCampo;

    @FXML
    private TableColumn<Empleado, String> nombreColumna;

    @FXML
    private Button buscarBoton;

    @FXML
    private TableView<Empleado> empleadosTabla;

    @FXML
    private PasswordField EmpleadoContraseñaCampo;

    @FXML
    private Button bloquearBoton;

    @FXML
    private Button atrasButton;

    @FXML
    void añadirAdministradorAccion(ActionEvent event) {

        if (RegistrarAdministradorController.validarTextFields(EmpleadoCedulaCampo, EmpleadoContraseñaCampo,
                EmpleadoEmailCampo, EmpleadoNombreCampo, EmpleadoUsuarioCampo)) {
            Administrador empleado = new Administrador(EmpleadoCedulaCampo.getText(), EmpleadoNombreCampo.getText(),
                    true,
                    EmpleadoEmailCampo.getText(), EmpleadoUsuarioCampo.getText(), EmpleadoContraseñaCampo.getText());
            concesionario.añadirEmpleado(empleado);
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Alerta");
            alerta.setContentText("Creado con exito");
            alerta.showAndWait();
        } else {
            InicioSesionController.mostrarAlerta("Alerta", "Llene todos los campos");
        }
        limpiarCampos();
        cargarTabla();

    }

    @FXML
    void atrasAccion(ActionEvent event) {

        if (Rol.ADMIN.equals(Sesion.getRol())) {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/uniquindio/poo/administradorView.fxml"));
            try {
                Parent root = loader.load();
                Stage stage = App.getStage();
                stage.setScene(new Scene(root));
                stage.setTitle("Vista Administrador");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/co/edu/uniquindio/poo/empleadoView.fxml"));
            try {
                Parent root = loader.load();
                Stage stage = App.getStage();
                stage.setScene(new Scene(root));
                stage.setTitle("Vista Empleado");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void cargarTabla() {
        empleadosTabla.getItems().setAll(concesionario.getListaEmpleados());
    }

    private void limpiarCampos() {
        EmpleadoCedulaCampo.clear();
        EmpleadoContraseñaCampo.clear();
        EmpleadoEmailCampo.clear();
        EmpleadoNombreCampo.clear();
        EmpleadoUsuarioCampo.clear();
    }

    @FXML
    void añadirEmpleadoAccion(ActionEvent event) {

        if (RegistrarAdministradorController.validarTextFields(EmpleadoCedulaCampo, EmpleadoContraseñaCampo,
                EmpleadoEmailCampo, EmpleadoNombreCampo, EmpleadoUsuarioCampo)) {
            Empleado empleado = new Empleado(EmpleadoCedulaCampo.getText(), EmpleadoNombreCampo.getText(), true,
                    EmpleadoEmailCampo.getText(), EmpleadoUsuarioCampo.getText(), EmpleadoContraseñaCampo.getText());
            concesionario.añadirEmpleado(empleado);
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Alerta");
            alerta.setContentText("Creado con exito");
            alerta.showAndWait();
        } else {
            InicioSesionController.mostrarAlerta("Alerta", "Llene todos los campos");
        }
        limpiarCampos();
        cargarTabla();

    }

    @FXML
    void buscarAccion(ActionEvent event) {
        if (busquedaCampo != null) {
            String busqueda = busquedaCampo.getText();
            LinkedList<Empleado> resultados = new LinkedList<>();

            for (Empleado cliente : concesionario.getListaEmpleados()) {
                if (cliente.getId().equalsIgnoreCase(busqueda) ||
                        cliente.getNombre().equalsIgnoreCase(busqueda)) {
                    resultados.add(cliente);
                }
            }

            if (resultados.isEmpty()) {
                InicioSesionController.mostrarAlertaInfo("No se encontró");
            } else {
                empleadosTabla.getItems().setAll(resultados);
            }
        }
    }

    @FXML
    void bloquearAccion(ActionEvent event) {
        Empleado empleadoSeleccionado = (Empleado) empleadosTabla.getSelectionModel().getSelectedItem();
        if (empleadoSeleccionado == null) {
            InicioSesionController.mostrarAlerta("Alerta", "Debe seleccionar un empleado");
            return;
        }
        concesionario.buscarEmpleado(empleadoSeleccionado.getId()).setActivo(false);
        InicioSesionController.mostrarAlertaInfo("Bloqueado con exito");
        cargarTabla();
    }

    @FXML
    void desbloquearAccion(ActionEvent event) {

        Empleado empleadoSeleccionado = (Empleado) empleadosTabla.getSelectionModel().getSelectedItem();
        if (empleadoSeleccionado == null) {
            InicioSesionController.mostrarAlerta("Alerta", "Debe seleccionar un empleado");
            return;
        }
        if (empleadoSeleccionado.isActivo()) {
            InicioSesionController.mostrarAlertaInfo("Ya está activo");
            return;
        }
        concesionario.buscarEmpleado(empleadoSeleccionado.getId()).setActivo(true);
        InicioSesionController.mostrarAlertaInfo("Desbloqueado con exito");
        cargarTabla();
    }

    @FXML
    void eliminarAccion(ActionEvent event) {

        Empleado empleadoSeleccionado = (Empleado) empleadosTabla.getSelectionModel().getSelectedItem();

        if (empleadoSeleccionado == null) {
            InicioSesionController.mostrarAlerta("Alerta", "Debe seleccionar un empleado");
            return;
        }

        concesionario.eliminarEmpleado(empleadoSeleccionado);
        InicioSesionController.mostrarAlertaInfo("Eliminado con exito");
        cargarTabla();
    }

    @FXML
    private Button recargarBoton;

    @FXML
    void recargarAccion(ActionEvent event) {
        cargarTabla();
    }

    @FXML
    void initialize() {
        cargarTabla();
        emailColumna.setCellValueFactory(new PropertyValueFactory<>("email"));
        usuarioColumna.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        iDColumna.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        estadoColumna.setCellValueFactory(new PropertyValueFactory<>("activo"));
        estadoColumna.setCellFactory(column -> {
            return new TableCell<Empleado, Boolean>() {
                @Override
                protected void updateItem(Boolean item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item ? "Activo" : "Inactivo");
                    }
                }
            };
        });
        assert recargarBoton != null
                : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'reportesView.fxml'.";

        assert estadoColumna != null
                : "fx:id=\"estadoColumna\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert busquedaCampo != null
                : "fx:id=\"busquedaCampo\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert añadirEmpleadoBoton != null
                : "fx:id=\"añadirEmpleadoBoton\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert emailColumna != null
                : "fx:id=\"emailColumna\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert paginacionTabla != null
                : "fx:id=\"paginacionTabla\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert iDColumna != null
                : "fx:id=\"iDColumna\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert atributoABuscarCombo != null
                : "fx:id=\"atributoABuscarCombo\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert eliminarBoton != null
                : "fx:id=\"eliminarBoton\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert EmpleadoCedulaCampo != null
                : "fx:id=\"EmpleadoCedulaCampo\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert EmpleadoEmailCampo != null
                : "fx:id=\"EmpleadoEmailCampo\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert usuarioColumna != null
                : "fx:id=\"usuarioColumna\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert desbloquearBoton != null
                : "fx:id=\"desbloquearBoton\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert EmpleadoNombreCampo != null
                : "fx:id=\"EmpleadoNombreCampo\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert EmpleadoUsuarioCampo != null
                : "fx:id=\"EmpleadoUsuarioCampo\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert nombreColumna != null
                : "fx:id=\"nombreColumna\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert buscarBoton != null
                : "fx:id=\"buscarBoton\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert empleadosTabla != null
                : "fx:id=\"empleadosTabla\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert EmpleadoContraseñaCampo != null
                : "fx:id=\"EmpleadoContraseñaCampo\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";
        assert bloquearBoton != null
                : "fx:id=\"bloquearBoton\" was not injected: check your FXML file 'gestionarEmpleadosView.fxml'.";

    }
}
