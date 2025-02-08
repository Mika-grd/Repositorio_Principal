package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.Sesion.Rol;
import co.edu.uniquindio.poo.model.Bus;
import co.edu.uniquindio.poo.model.Camiones;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Deportivo;
import co.edu.uniquindio.poo.model.PickUp;
import co.edu.uniquindio.poo.model.SUV;
import co.edu.uniquindio.poo.model.Sedan;
import co.edu.uniquindio.poo.model.Van;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GestionarVehiculosController {

    private Concesionario concesionario = Concesionario.getInstancia();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pagination paginacionTabla;

    @FXML
    private TextField buscarEnTablaCampo;

    @FXML
    private Button eliminarVehiculoBoton;

    @FXML
    private Hyperlink registrarVehiculoLink;

    @FXML
    private TableColumn<Vehiculo, String> modeloColumna;

    @FXML
    private ImageView imagenVehiculo1;

    @FXML
    private TableColumn<Vehiculo, Double> precioColumna;

    @FXML
    private ImageView imagenVehiculo2;

    @FXML
    private Button imagenSiguienteBoton;

    @FXML
    private TableView<Vehiculo> vehiculosTabla;

    @FXML
    private TableColumn<Vehiculo, String> marcaColumna;

    @FXML
    private ImageView imagenVehiculo3;

    @FXML
    private Text informacionAdicionalText;

    @FXML
    private TableColumn<Vehiculo, String> matriculaColumna;

    @FXML
    private Button buscarBoton;

    @FXML
    private TableColumn<Vehiculo, Double> precioporDiaColumna;

    @FXML
    private Button imagenAnteriorBoton;

    @FXML
    private Button atrasButton;

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

    @FXML
    void buscarAccion(ActionEvent event) {
        if (buscarEnTablaCampo != null) {
            String busqueda = buscarEnTablaCampo.getText();
            LinkedList<Vehiculo> resultados = new LinkedList<>();

            for (Vehiculo vehiculo : concesionario.getListaVehiculos()) {
                if (vehiculo.getMatricula().equalsIgnoreCase(busqueda) ||
                        vehiculo.getMarca().equalsIgnoreCase(busqueda)
                        || vehiculo.getModelo().equalsIgnoreCase(busqueda)) {
                    resultados.add(vehiculo);
                }
            }

            if (resultados.isEmpty()) {
                InicioSesionController.mostrarAlertaInfo("No se encontró");
            } else {
                vehiculosTabla.getItems().setAll(resultados);
            }
        }
    }

    private void mostrarInfoAdicional(Vehiculo vehiculoSeleccionado) {
        if (vehiculoSeleccionado == null) {
            return;
        }
        String infoAdicional = "";

        // Verificar el tipo de vehículo y llamar a toString()
        if (vehiculoSeleccionado instanceof Sedan) {
            infoAdicional = ((Sedan) vehiculoSeleccionado).toString();
        } else if (vehiculoSeleccionado instanceof SUV) {
            infoAdicional = ((SUV) vehiculoSeleccionado).toString();
        } else if (vehiculoSeleccionado instanceof Deportivo) {
            infoAdicional = ((Deportivo) vehiculoSeleccionado).toString();
        } else if (vehiculoSeleccionado instanceof PickUp) {
            infoAdicional = ((PickUp) vehiculoSeleccionado).toString();
        } else if (vehiculoSeleccionado instanceof Camiones) {
            infoAdicional = ((Camiones) vehiculoSeleccionado).toString();
        } else if (vehiculoSeleccionado instanceof Van) {
            infoAdicional = ((Van) vehiculoSeleccionado).toString();
        } else if (vehiculoSeleccionado instanceof Bus) {
            infoAdicional = ((Bus) vehiculoSeleccionado).toString();
        }

        informacionAdicionalText.setText(infoAdicional);
    }

    @FXML
    void ImagenAnteriorAccion(ActionEvent event) {

    }

    @FXML
    void ImagenSiguienteAccion(ActionEvent event) {

    }

    @FXML
    void registrarVehiculoAccion(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/co/edu/uniquindio/poo/registrarVehiculoView.fxml"));
        try {
            Parent root = loader.load();
            Stage stage = App.getStage();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestion Vehiculo");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void eliminarVehiculoAccion(ActionEvent event) {
        Vehiculo vehiculoSelecconado = vehiculosTabla.getSelectionModel().getSelectedItem();

        if (vehiculoSelecconado == null) {
            InicioSesionController.mostrarAlerta("Alerta", "Debe seleccionar un empleado");
            return;
        }

        concesionario.eliminarVehiculo(vehiculoSelecconado);
        InicioSesionController.mostrarAlertaInfo("Eliminado con exito");
        cargarTabla();
    }

    private void cargarTabla() {

        vehiculosTabla.getItems().setAll(concesionario.getListaVehiculos());
    }

    @FXML
    void recargarAccion(ActionEvent event) {
        cargarTabla();
    }

    @FXML
    void initialize() {
        cargarTabla();
        matriculaColumna.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        marcaColumna.setCellValueFactory(new PropertyValueFactory<>("marca"));
        modeloColumna.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        precioporDiaColumna.setCellValueFactory(new PropertyValueFactory<>("precio por dia"));
        precioColumna.setCellValueFactory(new PropertyValueFactory<>("precio"));

        vehiculosTabla.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                mostrarInfoAdicional(newValue);
            }
        });

        assert atrasButton != null
                : "fx:id=\"atrasButton\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert buscarBoton != null
                : "fx:id=\"buscarBoton\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert buscarEnTablaCampo != null
                : "fx:id=\"buscarEnTablaCampo\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert eliminarVehiculoBoton != null
                : "fx:id=\"eliminarVehiculoBoton\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert imagenAnteriorBoton != null
                : "fx:id=\"imagenAnteriorBoton\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert imagenSiguienteBoton != null
                : "fx:id=\"imagenSiguienteBoton\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert imagenVehiculo1 != null
                : "fx:id=\"imagenVehiculo1\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert imagenVehiculo2 != null
                : "fx:id=\"imagenVehiculo2\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert imagenVehiculo3 != null
                : "fx:id=\"imagenVehiculo3\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert informacionAdicionalText != null
                : "fx:id=\"informacionAdicionalTexto\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert marcaColumna != null
                : "fx:id=\"marcaColumna\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert matriculaColumna != null
                : "fx:id=\"matriculaColumna\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert modeloColumna != null
                : "fx:id=\"modeloColumna\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert paginacionTabla != null
                : "fx:id=\"paginacionTabla\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert precioColumna != null
                : "fx:id=\"precioColumna\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert precioporDiaColumna != null
                : "fx:id=\"precioporDiaColumna\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert registrarVehiculoLink != null
                : "fx:id=\"registrarVehiculoLink\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";
        assert vehiculosTabla != null
                : "fx:id=\"vehiculosTabla\" was not injected: check your FXML file 'gestionarVehiculosView.fxml'.";

    }

}
