package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.Sesion.Rol;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Reporte;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ReportesController {

    private Concesionario concesionario = Concesionario.getInstancia();
    private Rol rol = Sesion.getRol();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField EmpleadoNombreCampo;

    @FXML
    private Button añadirEmpleadoBoton;

    @FXML
    private Button buscarBoton;

    @FXML
    private TextField busquedaCampo;

    @FXML
    private Button eliminarBoton;

    @FXML
    private TableColumn<?, ?> emailColumna;

    @FXML
    private TableView<Reporte> empleadosTabla;

    @FXML
    private TableColumn<?, ?> estadoColumna;

    @FXML
    private TableColumn<?, ?> iDColumna;

    @FXML
    private TableColumn<?, ?> nombreColumna;

    @FXML
    private Pagination paginacionTabla;

    @FXML
    private TableColumn<?, ?> usuarioColumna;

    @FXML
    private Button atrasBoton;

    @FXML
    private DatePicker fechaFinDate;

    @FXML
    private DatePicker fechaInicioDate;

    @FXML
    void atrasAccion(ActionEvent event) {

        System.out.println(rol);
        if (Rol.ADMIN.equals(rol)) {
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

    @FXML
    void añadirEmpleadoAccion(ActionEvent event) {

        if (RegistrarAdministradorController.validarTextFields(EmpleadoNombreCampo)) {
            Empleado empleadoActual = concesionario.buscarEmpleado(EmpleadoNombreCampo.getText());
            if (empleadoActual != null) {
                Reporte reporte = new Reporte(EmpleadoNombreCampo.getText(), empleadoActual.getListaTransacciones(), empleadoActual, fechaInicioDate.getValue(), fechaFinDate.getValue());
                concesionario.añadirReporte(reporte);
            }else{
                InicioSesionController.mostrarAlerta("Alerta", "No se encontró el empleado");
            }
            
            InicioSesionController.mostrarAlertaInfo("Creado con exito");
        } else {
            InicioSesionController.mostrarAlerta("Alerta", "Llene todos los campos");
        }
        limpiarCampos();
        cargarTabla();
    }

    private void limpiarCampos(){
        EmpleadoNombreCampo.clear();
    }

    private void cargarTabla(){
        empleadosTabla.getItems().setAll(concesionario.getListaReportes());
    }
        
            @FXML
    void buscarAccion(ActionEvent event) {
        if (busquedaCampo != null) {
            String busqueda = busquedaCampo.getText();
            LinkedList<Reporte> resultados = new LinkedList<>();

            for (Reporte cliente : concesionario.getListaReportes()) {
                if (cliente.getId().equalsIgnoreCase(busqueda)) {
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
    void eliminarAccion(ActionEvent event) {

    }

    @FXML
    void recargarAccion(ActionEvent event) {
        cargarTabla();
    }

    @FXML
    private Button recargarBoton;

    @FXML
    void initialize() {
        assert rol != null : "Rol nulo";
        assert EmpleadoNombreCampo != null : "fx:id=\"EmpleadoNombreCampo\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert atrasBoton != null : "fx:id=\"atrasBoton\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert añadirEmpleadoBoton != null : "fx:id=\"añadirEmpleadoBoton\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert buscarBoton != null : "fx:id=\"buscarBoton\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert busquedaCampo != null : "fx:id=\"busquedaCampo\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert eliminarBoton != null : "fx:id=\"eliminarBoton\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert emailColumna != null : "fx:id=\"emailColumna\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert empleadosTabla != null : "fx:id=\"empleadosTabla\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert estadoColumna != null : "fx:id=\"estadoColumna\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert fechaFinDate != null : "fx:id=\"fechaFinDate\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert fechaInicioDate != null : "fx:id=\"fechaInicioDate\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert iDColumna != null : "fx:id=\"iDColumna\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert nombreColumna != null : "fx:id=\"nombreColumna\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert paginacionTabla != null : "fx:id=\"paginacionTabla\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert usuarioColumna != null : "fx:id=\"usuarioColumna\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert recargarBoton != null : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'reportesView.fxml'.";

    }
}
