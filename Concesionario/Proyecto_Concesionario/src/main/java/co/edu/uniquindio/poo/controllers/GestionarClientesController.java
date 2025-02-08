package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.Sesion.Rol;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GestionarClientesController {
    private Concesionario concesionario = Concesionario.getInstancia();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button añadirClienteBoton;

    @FXML
    private TableView<Cliente> vehiculosTabla;

    @FXML
    private TextField clienteContactoCampo;

    @FXML
    private TableColumn<Cliente, String> iDColumna;

    @FXML
    private TextField clienteCedulaCampo;

    @FXML
    private Button eliminarBoton;

    @FXML
    private TableColumn<Cliente, String> nombreColumna;

    @FXML
    private Button buscarBoton;

    @FXML
    private TextField busquedaNombreOrIDCampo;

    @FXML
    private TableColumn<Cliente, String> contactoColumna;

    @FXML
    private TextField clienteNombreCampo;

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

    private void cargarTablaClientes() {
        vehiculosTabla.getItems().setAll(concesionario.getListaClientes());
    }

    private void limpiarCampos() {
        clienteNombreCampo.clear();
        clienteCedulaCampo.clear();
        clienteContactoCampo.clear();
    }

    @FXML
    void añadirClienteAccion(ActionEvent event) {
        if (RegistrarAdministradorController.validarTextFields(clienteCedulaCampo, clienteContactoCampo,
                clienteNombreCampo)) {
            Cliente cliente = new Cliente(clienteCedulaCampo.getText(), clienteNombreCampo.getText(),
                    clienteContactoCampo.getText());
            concesionario.añadirCliente(cliente);
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Alerta");
            alerta.setContentText("Creado con exito");
            alerta.showAndWait();
        } else {
            InicioSesionController.mostrarAlerta("Alerta", "Llene todos los campos");
        }
        limpiarCampos();
        cargarTablaClientes();
    }

    @FXML
    void buscarAccion(ActionEvent event) {
        String textoBusqueda = busquedaNombreOrIDCampo.getText().toLowerCase().trim();

        if (textoBusqueda.isEmpty()) {
            cargarTablaClientes();
            return;
        }

        ObservableList<Cliente> clientesFiltrados = FXCollections.observableArrayList();
        for (Cliente cliente : concesionario.getListaClientes()) {
            if (cliente.getIdCliente().toLowerCase().contains(textoBusqueda) ||
                    cliente.getNombre().toLowerCase().contains(textoBusqueda)) {
                clientesFiltrados.add(cliente);
            }
        }

        vehiculosTabla.setItems(FXCollections.observableArrayList(concesionario.getListaClientes())); // Convierte a
                                                                                                      // ObservableList
        vehiculosTabla.getSelectionModel().clearSelection(); // Limpia la selección previa

        if (!clientesFiltrados.isEmpty()) {
            for (Cliente cliente : clientesFiltrados) {
                for (int i = 0; i < vehiculosTabla.getItems().size(); i++) {
                    if (vehiculosTabla.getItems().get(i).equals(cliente)) {
                        vehiculosTabla.getSelectionModel().select(i);
                        break;
                    }
                }
            }
        }
    }

    @FXML
    void eliminarAccion(ActionEvent event) {
        Cliente clienteSeleccionado = (Cliente) vehiculosTabla.getSelectionModel().getSelectedItem();

        if (clienteSeleccionado == null) {
            InicioSesionController.mostrarAlerta("Alerta", "Debe seleccionar un cliente");
            return;
        }

        Concesionario.getInstancia().getListaClientes().remove(clienteSeleccionado);
        System.out.println("Cliente eliminado exitosamente.");
        cargarTablaClientes();
    }

    @FXML
    private Button recargarBoton;

@FXML
    void recargarAccion(ActionEvent event) {
        cargarTablaClientes();
    }


    @FXML
    void initialize() {
        cargarTablaClientes();
        iDColumna.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        nombreColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        contactoColumna.setCellValueFactory(new PropertyValueFactory<>("contacto"));
        assert recargarBoton != null : "fx:id=\"recargarBoton\" was not injected: check your FXML file 'reportesView.fxml'.";
        assert añadirClienteBoton != null
                : "fx:id=\"añadirClienteBoton\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";
        assert vehiculosTabla != null
                : "fx:id=\"vehiculosTabla\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";
        assert clienteContactoCampo != null
                : "fx:id=\"clienteEmailCampo\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";
        assert iDColumna != null
                : "fx:id=\"iDColumna\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";
        assert clienteCedulaCampo != null
                : "fx:id=\"clienteCedulaCampo\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";
        assert eliminarBoton != null
                : "fx:id=\"eliminarBoton\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";
        assert nombreColumna != null
                : "fx:id=\"nombreColumna\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";
        assert buscarBoton != null
                : "fx:id=\"buscarBoton\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";
        assert busquedaNombreOrIDCampo != null
                : "fx:id=\"busquedaNombreOrIDCampo\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";
        assert contactoColumna != null
                : "fx:id=\"contactoColumna\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";
        assert clienteNombreCampo != null
                : "fx:id=\"clienteNombreCampo\" was not injected: check your FXML file 'gestionarClientesView.fxml'.";

    }
}
