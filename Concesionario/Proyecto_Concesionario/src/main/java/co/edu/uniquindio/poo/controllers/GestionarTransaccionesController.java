package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.Sesion.Rol;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.TipoTransaccion;
import co.edu.uniquindio.poo.model.Transaccion;
import co.edu.uniquindio.poo.model.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GestionarTransaccionesController {

        private Concesionario concesionario = Concesionario.getInstancia();

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TextField busquedaCampo;

        @FXML
        private Pagination paginacionTabla;

        @FXML
        private VBox alquilarPanel;

        @FXML
        private TextField ClienteIDCampo;

        @FXML
        private Button eliminarBoton;

        @FXML
        private ComboBox<TipoTransaccion> tipoTransaccionCombo;

        @FXML
        private TableColumn<Transaccion, String> diasColumna;

        @FXML
        private DatePicker fechaCompraFecha;

        @FXML
        private TextField valorCompraCampo;

        @FXML
        private ComboBox<String> revisionTecnicaCombo;

        @FXML
        private TableColumn<Transaccion, String> valorColumna;

        @FXML
        private Button crearTransaccionBoton;

        @FXML
        private TableColumn<Transaccion, String> tipoTransaccionColumna;

        @FXML
        private TableColumn<Transaccion, String> clienteColumna;

        @FXML
        private TableView<Transaccion> transaccionesDelEmpleadoTabla;

        @FXML
        private TableColumn<Transaccion, String> fechaColumna;

        @FXML
        private TableColumn<Transaccion, String> placaVehiculoColumna;

        @FXML
        private VBox compraPanel;

        @FXML
        private Button buscarBoton;

        @FXML
        private TextField diasCampo;

        @FXML
        private TextField matriculaCampo;

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
                                return;
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
        void crearTransaccionAccion(ActionEvent event) {

                if (tipoTransaccionCombo.getValue().equals(TipoTransaccion.ALQUILER)) {
                        if (RegistrarAdministradorController.validarTextFields(diasCampo, matriculaCampo,
                                        ClienteIDCampo) && fechaCompraFecha.getValue() != null) {
                                if (concesionario.buscarVehiculo(matriculaCampo.getText()) != null) {
                                        Vehiculo vehiculo = concesionario.buscarVehiculo(matriculaCampo.getText());
                                        Empleado empleado = concesionario.buscarEmpleado(Sesion.getId());
                                        empleado.alquilarVehiculo(vehiculo, Integer.parseInt(diasCampo.getText()),
                                                        new Cliente(ClienteIDCampo.getText(), null, null),
                                                        fechaCompraFecha.getValue());
                                } else {
                                        InicioSesionController.mostrarAlerta("Alerta", "No se encontró");
                                }
                        } else {
                                InicioSesionController.mostrarAlerta("ALerta", "Debe llenar todos los campos");
                        }
                }
                if (tipoTransaccionCombo.getValue().equals(TipoTransaccion.COMPRA)) {
                        InicioSesionController.mostrarAlertaInfo("para comprar un vehiculo, primero debe registrarlo en el sistema");
                        if (RegistrarAdministradorController.validarTextFields(valorCompraCampo, matriculaCampo,
                                        ClienteIDCampo) && fechaCompraFecha.getValue() != null) {
                                if (concesionario.buscarVehiculo(matriculaCampo.getText()) != null) {
                                        boolean revision = false;
                                        if (revisionTecnicaCombo.getValue().equals("TIENE REVISIÓN TECNICA")) {
                                                revision = true;
                                        }
                                        Vehiculo vehiculo = concesionario.buscarVehiculo(matriculaCampo.getText());
                                        Empleado empleado = concesionario.buscarEmpleado(Sesion.getId());
                                        empleado.comprarVehiculo(vehiculo,
                                                        new Cliente(ClienteIDCampo.getText(), null, null),
                                                        fechaCompraFecha.getValue(),
                                                        Double.parseDouble(valorCompraCampo.getText()), revision);
                                } else {
                                        InicioSesionController.mostrarAlerta("Alerta", "No se encontró");
                                }
                        } else {
                                InicioSesionController.mostrarAlerta("ALerta", "Debe llenar todos los campos");
                        }
                } else {
                        if (RegistrarAdministradorController.validarTextFields(matriculaCampo, ClienteIDCampo)
                                        && fechaCompraFecha.getValue() != null) {
                                if (concesionario.buscarVehiculo(matriculaCampo.getText()) != null) {
                                        Vehiculo vehiculo = concesionario.buscarVehiculo(matriculaCampo.getText());
                                        Empleado empleado = concesionario.buscarEmpleado(Sesion.getId());
                                        empleado.venderVehiculo(vehiculo,
                                                        new Cliente(ClienteIDCampo.getText(), null, null),
                                                        fechaCompraFecha.getValue());
                                } else {
                                        InicioSesionController.mostrarAlerta("Alerta", "No se encontró");
                                }
                        } else {
                                InicioSesionController.mostrarAlerta("ALerta", "Debe llenar todos los campos");
                        }
                }
                limpiarCampos();
                cargarTabla();
        }

        @FXML
        void buscarAccion(ActionEvent event) {
                if (busquedaCampo != null) {
                        String busqueda = busquedaCampo.getText();
                        Empleado empleado = concesionario.buscarEmpleado(Sesion.getId());
                        LinkedList<Transaccion> resultados = new LinkedList<>();

                        for (Transaccion cliente : empleado.getListaTransacciones()) {
                                if (cliente.getVehiculo().getMatricula().equalsIgnoreCase(busqueda)) {
                                        resultados.add(cliente);
                                }
                        }

                        if (resultados.isEmpty()) {
                                InicioSesionController.mostrarAlertaInfo("No se encontró");
                        } else {
                                transaccionesDelEmpleadoTabla.getItems().setAll(resultados);
                        }
                }
                limpiarCampos();
        }

        @FXML
        void eliminarAccion(ActionEvent event) {
                Transaccion empleadoSeleccionado = transaccionesDelEmpleadoTabla.getSelectionModel().getSelectedItem();

                if (empleadoSeleccionado == null) {
                        InicioSesionController.mostrarAlerta("Alerta", "Debe seleccionar un empleado");
                        return;
                }

                concesionario.buscarEmpleado(Sesion.getId()).eliminarTransaccion(empleadoSeleccionado);
                InicioSesionController.mostrarAlertaInfo("Eliminado con exito");
                cargarTabla();
        }

        @FXML
        private Button recargarBoton;

        @FXML
        void recargarAccion(ActionEvent event) {
                cargarTabla();
        }

        private void cargarTabla() {
                transaccionesDelEmpleadoTabla.getItems()
                                .setAll(concesionario.buscarEmpleado(Sesion.getId()).getListaTransacciones());
        }

        private void limpiarCampos() {
                ClienteIDCampo.clear();
                matriculaCampo.clear();
                valorCompraCampo.clear();
                diasCampo.clear();
                busquedaCampo.clear();
        }

        // Método para actualizar la visibilidad de los paneles
        private void actualizarVisibilidadPaneles(TipoTransaccion seleccion) {
                compraPanel.setVisible(seleccion.equals(TipoTransaccion.COMPRA));
                alquilarPanel.setVisible(seleccion.equals(TipoTransaccion.ALQUILER));
        }

        @FXML
        void initialize() {
                cargarTabla();
                tipoTransaccionCombo.getItems().setAll(TipoTransaccion.values());
                tipoTransaccionCombo.setValue(TipoTransaccion.VENTA);
                revisionTecnicaCombo.getItems().setAll("TIENE REVISIÓN TECNICA", "NO TIENE REVISIÓN TECNICA");
                revisionTecnicaCombo.setValue("REVISIÓN TECNICA");
                actualizarVisibilidadPaneles(tipoTransaccionCombo.getValue());

                // Agregar el ChangeListener para el ComboBox
                tipoTransaccionCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
                        // Actualizar la visibilidad de los paneles cuando cambia la selección
                        actualizarVisibilidadPaneles(newValue);
                });

                valorColumna.setCellValueFactory(new PropertyValueFactory<>("valor"));
                tipoTransaccionColumna.setCellValueFactory(new PropertyValueFactory<>("tipo"));
                clienteColumna.setCellValueFactory(new PropertyValueFactory<>("cliente"));
                fechaColumna.setCellValueFactory(new PropertyValueFactory<>("fecha"));
                placaVehiculoColumna.setCellValueFactory(new PropertyValueFactory<>("matricula"));
                diasColumna.setCellValueFactory(new PropertyValueFactory<>("empleado"));
                
                assert recargarBoton != null
                                : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'reportesView.fxml'.";
                assert busquedaCampo != null
                                : "fx:id=\"busquedaCampo\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert paginacionTabla != null
                                : "fx:id=\"paginacionTabla\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert alquilarPanel != null
                                : "fx:id=\"alquilarPanel\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";

                assert ClienteIDCampo != null
                                : "fx:id=\"ClienteIDCampo\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert eliminarBoton != null
                                : "fx:id=\"eliminarBoton\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert tipoTransaccionCombo != null
                                : "fx:id=\"tipoTransaccionCombo\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert diasColumna != null
                                : "fx:id=\"diasColumna\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert fechaCompraFecha != null
                                : "fx:id=\"fechaCompraFecha\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert valorCompraCampo != null
                                : "fx:id=\"valorCompraCampo\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert revisionTecnicaCombo != null
                                : "fx:id=\"revisionTecnicaCombo\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert valorColumna != null
                                : "fx:id=\"valorColumna\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert crearTransaccionBoton != null
                                : "fx:id=\"crearTransaccionBoton\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert tipoTransaccionColumna != null
                                : "fx:id=\"tipoTransaccionColumna\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert clienteColumna != null
                                : "fx:id=\"clienteColumna\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert transaccionesDelEmpleadoTabla != null
                                : "fx:id=\"transaccionesDelEmpleadoTabla\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert fechaColumna != null
                                : "fx:id=\"fechaColumna\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert placaVehiculoColumna != null
                                : "fx:id=\"placaVehiculoColumna\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert compraPanel != null
                                : "fx:id=\"compraPanel\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert buscarBoton != null
                                : "fx:id=\"buscarBoton\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert diasCampo != null
                                : "fx:id=\"diasCampo\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";
                assert matriculaCampo != null
                                : "fx:id=\"matriculaCampo\" was not injected: check your FXML file 'gestionarTransaccionesView.fxml'.";

        }
}
