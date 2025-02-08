package co.edu.uniquindio.poo.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.app.App;
import co.edu.uniquindio.poo.controllers.Sesion.Rol;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Transmision;
import co.edu.uniquindio.poo.model.Bus;
import co.edu.uniquindio.poo.model.Camiones;
import co.edu.uniquindio.poo.model.Deportivo;
import co.edu.uniquindio.poo.model.PickUp;
import co.edu.uniquindio.poo.model.SUV;
import co.edu.uniquindio.poo.model.Sedan;
import co.edu.uniquindio.poo.model.Van;
import co.edu.uniquindio.poo.model.Combustible;
import co.edu.uniquindio.poo.model.CombustibleElectrico;
import co.edu.uniquindio.poo.model.CombustibleFosil;
import co.edu.uniquindio.poo.model.CombustibleHibrido;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrarVehiculoController {

    private Concesionario concesionario = Concesionario.getInstancia();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> TieneSensoresColisionSedanCombo;

    @FXML
    private ComboBox<String> EsUsadoCombo;

    @FXML
    private TextField TiempoAlcanzar100KmHDeportivoCampo;

    @FXML
    private TextField NumcaballosFuerzaDeportivoCampo;

    @FXML
    private ComboBox<String> TieneSensorTraficoCruzadoSedanCombo;

    @FXML
    private TextField tiempoCargaCampo;

    @FXML
    private TextField NumEjesBusCampo;

    @FXML
    private TextField cilindrajeCampo;

    @FXML
    private ComboBox<String> TieneAbsCarroCombo;

    @FXML
    private ComboBox<String> EsHibridoLigeroCombo;

    @FXML
    private ComboBox<String> EsLindaVanCombo;

    @FXML
    private ComboBox<String> TieneAireAcondicionadoCarroCombo;

    @FXML
    private TextField NumcaballosFuerzaCamionCampo;

    @FXML
    private ComboBox<String> Es4x4PickUpCombo;

    @FXML
    private HBox deportivoPanel;

    @FXML
    private TextField NumPasajerosCarroCampo;

    @FXML
    private ComboBox<String> tipoCombustibleCombo;

    @FXML
    private HBox pickUpPanel;

    @FXML
    private ComboBox<String> TieneVelocidadCruceroSUVCombo;

    @FXML
    private TextField CapacidadMaleteroCarroCampo;

    @FXML
    private ComboBox<String> TieneSensoresColisionSUVCombo;

    @FXML
    private TextField CapacidadCargaPickUpCampo;

    @FXML
    private ComboBox<String> tipoVehiculoCombo;

    @FXML
    private TextField NumBolsasCarroCampo;

    @FXML
    private ComboBox<String> TieneVelocidadCruceroSedanCombo;

    @FXML
    private HBox InformacionAdicionalPanel;

    @FXML
    private ComboBox<String> TieneAsistenciaPermanenciaCarrilSedanCombo;

    @FXML
    private HBox sedanPanel;

    @FXML
    private TextField numeroCambiosCampo;

    @FXML
    private HBox camionPanel;

    @FXML
    private ComboBox<String> TieneSensorTraficoCruzadoSUVCombo;

    @FXML
    private Text TituloInformacionAdicional;

    @FXML
    private Button atrasButton;

    @FXML
    private TextField NumPuertasCarroCampo;

    @FXML
    private HBox carroPanel;

    @FXML
    private TextField marcaCampo;

    @FXML
    private ComboBox<String> TieneAsistenciaPermanenciaCarrilSUVCombo;

    @FXML
    private HBox busPanel;

    @FXML
    private ComboBox<String> esEnchufableCombo;

    @FXML
    private TextField precioDiaAlquilerCampo;

    @FXML
    private TextField matriculaCampo;

    @FXML
    private TextField NumSalidasEmergenciaBusCampo;

    @FXML
    private ComboBox<Transmision> transmisionCombo;

    @FXML
    private ComboBox<String> Es4x4SUVCombo;

    @FXML
    private TextField precioCampo;

    @FXML
    private TextField valocidadMaximaCampo;

    @FXML
    private ComboBox<String> TieneCamaraReversaCarroCombo;

    @FXML
    private HBox VanPanel;

    @FXML
    private VBox combustibleHibridoPanel;

    @FXML
    private Button añadirBoton;

    @FXML
    private VBox combustibleElectricoPanel;

    @FXML
    private TextField autonomiaCampo;

    @FXML
    private HBox SUVPanel;

    @FXML
    private TextField modeloCampo;

    @FXML
    private TextField TiempoAlcanzar100KmHCamionCampo;

    private void desactivarCombustiblePaneles() {
        combustibleElectricoPanel.setVisible(false);
        combustibleHibridoPanel.setVisible(false);
    }

    private void desactivarVehiculosPaneles() {
        sedanPanel.setVisible(false);
        SUVPanel.setVisible(false);
        deportivoPanel.setVisible(false);
        pickUpPanel.setVisible(false);
        camionPanel.setVisible(false);
        VanPanel.setVisible(false);
        busPanel.setVisible(false);
    }

    private void mostrarPanelPorVehiculo(ActionEvent event) {
        desactivarVehiculosPaneles();;
        String tipoVehiculo = tipoVehiculoCombo.getValue();

        switch (tipoVehiculo) {
            case "Sedán":
                sedanPanel.setVisible(true);
                break;
            case "SUV":
                SUVPanel.setVisible(true);
                break;
            case "Deportivo":
                deportivoPanel.setVisible(true);
                break;
            case "PickUp":
                pickUpPanel.setVisible(true);
                break;
            case "Camión":
                camionPanel.setVisible(true);
                break;
            case "Van":
                VanPanel.setVisible(true);
                break;
            case "Bus":
                busPanel.setVisible(true);
                break;
        }
    }

    private void mostrarPanelCombustible(ActionEvent event) {
        desactivarCombustiblePaneles();;
        String tipoCombustible = tipoCombustibleCombo.getValue();
        switch (tipoCombustible) {
            case "Hibrido":
                combustibleHibridoPanel.setVisible(true);
                break;
            case "Electrico":
                combustibleElectricoPanel.setVisible(true);
                break;
            default:
                break;
        }

    }

    private void inicializarComboBoxSiONo(ComboBox<String> comboBox) {
        comboBox.getItems().addAll("Sí", "No");
    }

    private boolean traducirCombo(String comboValue) {
        if (comboValue.equals("Sí")) {
            return true;
        }
        return false;
    }

    private Combustible getCombustible(String combustibleIngresado) {
        if (combustibleIngresado == null) {
            InicioSesionController.mostrarAlerta("Alerta", "TipoCombustibleNulo");
            return null;
        }

        switch (combustibleIngresado) {
            case "Fosil":
                return new CombustibleFosil();
            case "Hibrido":
                boolean esHibridoLigero = traducirCombo(EsHibridoLigeroCombo.getValue());
                return new CombustibleHibrido(traducirCombo(esEnchufableCombo.getValue()), esHibridoLigero);
            case "Electrico":
                return new CombustibleElectrico(
                        Integer.parseInt(autonomiaCampo.getText()),
                        Integer.parseInt(tiempoCargaCampo.getText()));
            default:
                return null;
        }
    }
    
    @FXML
    void añadirAccion(ActionEvent event) {
        String tipoVehiculo = tipoVehiculoCombo.getValue();

        String marca = marcaCampo.getText();
        String modelo = modeloCampo.getText();
        double precio = Double.parseDouble(precioCampo.getText());
        double precioDiaAlquiler = Double.parseDouble(precioDiaAlquilerCampo.getText());
        String matricula = matriculaCampo.getText();
        String cilindraje = cilindrajeCampo.getText();
        Combustible tipoCombustible = getCombustible(tipoCombustibleCombo.getValue());
        Transmision tipo = transmisionCombo.getValue();

        if (tipoVehiculo != null) {
            if (tipoVehiculo.equals("Deportivo")) {
                double tiempo100KmH = Double.parseDouble(TiempoAlcanzar100KmHDeportivoCampo.getText());
                double caballosFuerza = Double.parseDouble(NumcaballosFuerzaDeportivoCampo.getText());
                Deportivo deportivo = new Deportivo(matricula, marca, modelo, false, 0, caballosFuerza, cilindraje,
                        precio, precioDiaAlquiler, true, tipo, tipoCombustible, 0, 0, tiempo100KmH, false, false, 0,
                        false, 0, caballosFuerza);
                concesionario.añadirVehiculo(deportivo);
                limpiarCamposYCombos();

            } else {
                // carros
                int numPuertas = Integer.parseInt(NumPuertasCarroCampo.getText());
                int numPasajeros = Integer.parseInt(NumPasajerosCarroCampo.getText());
                double capacidadDelMaletero = Double.parseDouble(CapacidadMaleteroCarroCampo.getText());// no se

                boolean tieneAireAcondicionado = TieneAireAcondicionadoCarroCombo.getValue().equals("Sí");
                boolean TieneAbsCombo = TieneAbsCarroCombo.getValue().equals("Sí");
                boolean TieneCamaraReversa = TieneCamaraReversaCarroCombo.getValue().equals("si");

                boolean tieneSensoresColision = false;
                boolean tieneSensorTraficoCruzado = false;
                boolean tieneVelocidadCrucero = false;
                boolean tieneAsistenciaCarril = false;
                boolean es4x4 = false;

                if (tipoVehiculo.equals("Sedán")) {
                    tieneSensoresColision = TieneSensoresColisionSedanCombo.getValue().equals("Sí");
                    tieneSensorTraficoCruzado = TieneSensorTraficoCruzadoSedanCombo.getValue().equals("Sí");
                    tieneVelocidadCrucero = TieneVelocidadCruceroSedanCombo.getValue().equals("Sí");
                    tieneAsistenciaCarril = TieneAsistenciaPermanenciaCarrilSedanCombo.getValue().equals("Sí");

                    Sedan sedan = new Sedan(matricula, marca, modelo, es4x4, numPasajeros, capacidadDelMaletero,
                            cilindraje, precio, precioDiaAlquiler, TieneCamaraReversa, tipo, tipoCombustible,
                            numPasajeros, numPuertas, capacidadDelMaletero, tieneAireAcondicionado,
                            tieneSensorTraficoCruzado, numPasajeros, TieneAbsCombo, tieneVelocidadCrucero,
                            tieneSensoresColision, tieneAsistenciaCarril, es4x4);
                    concesionario.añadirVehiculo(sedan);
                    limpiarCamposYCombos();

                } else if (tipoVehiculo.equals("SUV")) {
                    // Atributos específicos para un SUV
                    tieneSensoresColision = TieneSensoresColisionSUVCombo.getValue().equals("Sí");
                    tieneSensorTraficoCruzado = TieneSensorTraficoCruzadoSUVCombo.getValue().equals("Sí");
                    tieneVelocidadCrucero = TieneVelocidadCruceroSUVCombo.getValue().equals("Sí");
                    tieneAsistenciaCarril = TieneAsistenciaPermanenciaCarrilSUVCombo.getValue().equals("Sí");
                    es4x4 = Es4x4SUVCombo.getValue().equals("Sí");

                    SUV suv = new SUV(matricula, marca, modelo, es4x4, numPasajeros, capacidadDelMaletero, cilindraje,
                            precio, precioDiaAlquiler, TieneCamaraReversa, tipo, tipoCombustible, numPasajeros,
                            numPuertas, capacidadDelMaletero, tieneAireAcondicionado, tieneSensorTraficoCruzado,
                            numPasajeros, TieneAbsCombo, tieneVelocidadCrucero, tieneSensoresColision,
                            tieneVelocidadCrucero, tieneAsistenciaCarril, es4x4);
                    concesionario.añadirVehiculo(suv);
                    limpiarCamposYCombos();

                } else if (tipoVehiculo.equals("PickUp")) {
                    double capacidadCarga = Double.parseDouble(CapacidadCargaPickUpCampo.getText());
                    es4x4 = Es4x4PickUpCombo.getValue().equals("Sí");
                    limpiarCamposYCombos();

                    PickUp pickUp = new PickUp(matricula, marca, modelo, tieneSensorTraficoCruzado, numPasajeros,
                            capacidadCarga, cilindraje, precio, precioDiaAlquiler, tieneVelocidadCrucero, tipo,
                            tipoCombustible, numPasajeros, numPuertas, capacidadDelMaletero, tieneAireAcondicionado,
                            tieneAsistenciaCarril, numPasajeros, TieneAbsCombo, es4x4, capacidadCarga);
                    concesionario.añadirVehiculo(pickUp);
                    limpiarCamposYCombos();

                } else if (tipoVehiculo.equals("Camión")) {
                    int numEjes = Integer.parseInt(NumEjesBusCampo.getText());
                    boolean tieneAbs = TieneAbsCarroCombo.getValue().equals("Sí");
                    double tiempoCarga = Double.parseDouble(tiempoCargaCampo.getText());

                    Camiones camion = new Camiones(matricula, marca, modelo, tieneAsistenciaCarril, numEjes,
                            tiempoCarga, cilindraje, precio, precioDiaAlquiler, es4x4, tipo, tipoCombustible,
                            numPasajeros, numPuertas, capacidadDelMaletero, tieneAireAcondicionado, tieneAbs,
                            numPasajeros, tieneAbs, numEjes, tiempoCarga);
                    concesionario.añadirVehiculo(camion);
                    limpiarCamposYCombos();

                } else if (tipoVehiculo.equals("Van")) {
                    boolean esLinda = EsLindaVanCombo.getValue().equals("Sí");

                    Van van = new Van(matricula, marca, modelo, tieneVelocidadCrucero, numPasajeros,
                            capacidadDelMaletero, cilindraje, precio, precioDiaAlquiler, tieneAsistenciaCarril, tipo,
                            tipoCombustible, numPasajeros, numPuertas, capacidadDelMaletero, tieneAireAcondicionado,
                            es4x4, numPasajeros, TieneAbsCombo, esLinda);
                    concesionario.añadirVehiculo(van);
                    limpiarCamposYCombos();

                } else if (tipoVehiculo.equals("Bus")) {

                    int numSalidasEmergencia = Integer.parseInt(NumSalidasEmergenciaBusCampo.getText());
                    int numeroDeEjes = Integer.parseInt(NumEjesBusCampo.getText());

                    Bus bus = new Bus(matricula, marca, modelo, tieneVelocidadCrucero, numeroDeEjes, numeroDeEjes,
                            cilindraje, precio, precioDiaAlquiler, tieneAsistenciaCarril, tipo, tipoCombustible,
                            numPasajeros, numPuertas, capacidadDelMaletero, tieneAireAcondicionado, es4x4,
                            numSalidasEmergencia, TieneAbsCombo, numeroDeEjes, numeroDeEjes);
                    concesionario.añadirVehiculo(bus);
                    limpiarCamposYCombos();

                }
            }
        } else {
            InicioSesionController.mostrarAlerta("Alerta", "Por favor, seleccione un tipo de vehículo.");
        }
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

    public void limpiarCamposYCombos() {
        TieneSensoresColisionSedanCombo.getSelectionModel().clearSelection();
        EsUsadoCombo.getSelectionModel().clearSelection();
        TieneSensorTraficoCruzadoSedanCombo.getSelectionModel().clearSelection();
        TieneAbsCarroCombo.getSelectionModel().clearSelection();
        EsHibridoLigeroCombo.getSelectionModel().clearSelection();
        EsLindaVanCombo.getSelectionModel().clearSelection();
        TieneAireAcondicionadoCarroCombo.getSelectionModel().clearSelection();
        Es4x4PickUpCombo.getSelectionModel().clearSelection();
        tipoCombustibleCombo.getSelectionModel().clearSelection();
        TieneVelocidadCruceroSUVCombo.getSelectionModel().clearSelection();
        TieneSensoresColisionSUVCombo.getSelectionModel().clearSelection();
        tipoVehiculoCombo.getSelectionModel().clearSelection();
        TieneVelocidadCruceroSedanCombo.getSelectionModel().clearSelection();
        TieneAsistenciaPermanenciaCarrilSedanCombo.getSelectionModel().clearSelection();
        TieneSensorTraficoCruzadoSUVCombo.getSelectionModel().clearSelection();
        TieneAsistenciaPermanenciaCarrilSUVCombo.getSelectionModel().clearSelection();
        esEnchufableCombo.getSelectionModel().clearSelection();
        transmisionCombo.getSelectionModel().clearSelection();
        Es4x4SUVCombo.getSelectionModel().clearSelection();
        TieneCamaraReversaCarroCombo.getSelectionModel().clearSelection();
    
        // Limpiar los TextFields (ponerlos vacíos)
        TiempoAlcanzar100KmHDeportivoCampo.clear();
        NumcaballosFuerzaDeportivoCampo.clear();
        tiempoCargaCampo.clear();
        NumEjesBusCampo.clear();
        cilindrajeCampo.clear();
        NumcaballosFuerzaCamionCampo.clear();
        NumPasajerosCarroCampo.clear();
        CapacidadMaleteroCarroCampo.clear();
        CapacidadCargaPickUpCampo.clear();
        NumBolsasCarroCampo.clear();
        numeroCambiosCampo.clear();
        NumPuertasCarroCampo.clear();
        marcaCampo.clear();
        precioDiaAlquilerCampo.clear();
        matriculaCampo.clear();
        NumSalidasEmergenciaBusCampo.clear();
        precioCampo.clear();
        valocidadMaximaCampo.clear();
        autonomiaCampo.clear();
        modeloCampo.clear();
        TiempoAlcanzar100KmHCamionCampo.clear();
    
        deportivoPanel.setVisible(false);
        pickUpPanel.setVisible(false);
        InformacionAdicionalPanel.setVisible(false);
        sedanPanel.setVisible(false);
        camionPanel.setVisible(false);
        carroPanel.setVisible(false);
        busPanel.setVisible(false);
        VanPanel.setVisible(false);
        combustibleHibridoPanel.setVisible(false);
        combustibleElectricoPanel.setVisible(false);
        SUVPanel.setVisible(false);
    }
    

    @FXML
    void initialize() {
        inicializarComboBoxSiONo(TieneSensoresColisionSedanCombo);
        inicializarComboBoxSiONo(EsUsadoCombo);
        inicializarComboBoxSiONo(TieneSensorTraficoCruzadoSedanCombo);
        inicializarComboBoxSiONo(TieneAbsCarroCombo);
        inicializarComboBoxSiONo(EsHibridoLigeroCombo);
        inicializarComboBoxSiONo(EsLindaVanCombo);
        inicializarComboBoxSiONo(TieneAireAcondicionadoCarroCombo);
        inicializarComboBoxSiONo(Es4x4PickUpCombo);
        inicializarComboBoxSiONo(TieneVelocidadCruceroSUVCombo);
        inicializarComboBoxSiONo(TieneSensoresColisionSUVCombo);
        inicializarComboBoxSiONo(TieneVelocidadCruceroSedanCombo);
        inicializarComboBoxSiONo(TieneAsistenciaPermanenciaCarrilSedanCombo);
        inicializarComboBoxSiONo(TieneSensorTraficoCruzadoSUVCombo);
        inicializarComboBoxSiONo(TieneAsistenciaPermanenciaCarrilSUVCombo);
        inicializarComboBoxSiONo(esEnchufableCombo);
        inicializarComboBoxSiONo(Es4x4SUVCombo);
        inicializarComboBoxSiONo(TieneCamaraReversaCarroCombo);
        desactivarCombustiblePaneles();
        desactivarVehiculosPaneles();
        tipoVehiculoCombo.getItems().addAll("Sedán", "SUV", "Deportivo", "PickUp", "Camión", "Van", "Bus");
        tipoCombustibleCombo.getItems().setAll("Fosil", "Hibrido", "Electrico");
        tipoVehiculoCombo.setOnAction(this::mostrarPanelPorVehiculo);
        tipoCombustibleCombo.setOnAction(this::mostrarPanelCombustible);
        transmisionCombo.getItems().setAll(Transmision.values());

        assert TieneSensoresColisionSedanCombo != null
                : "fx:id=\"TieneSensoresColisionSedanCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert EsUsadoCombo != null
                : "fx:id=\"EsUsadoCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TiempoAlcanzar100KmHDeportivoCampo != null
                : "fx:id=\"TiempoAlcanzar100KmHDeportivoCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert NumcaballosFuerzaDeportivoCampo != null
                : "fx:id=\"NumcaballosFuerzaDeportivoCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TieneSensorTraficoCruzadoSedanCombo != null
                : "fx:id=\"TieneSensorTraficoCruzadoSedanCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert tiempoCargaCampo != null
                : "fx:id=\"tiempoCargaCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert NumEjesBusCampo != null
                : "fx:id=\"NumEjesBusCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert cilindrajeCampo != null
                : "fx:id=\"cilindrajeCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TieneAbsCarroCombo != null
                : "fx:id=\"TieneAbsCarroCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert EsHibridoLigeroCombo != null
                : "fx:id=\"EsHibridoLigeroCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert EsLindaVanCombo != null
                : "fx:id=\"EsLindaVanCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TieneAireAcondicionadoCarroCombo != null
                : "fx:id=\"TieneAireAcondicionadoCarroCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert NumcaballosFuerzaCamionCampo != null
                : "fx:id=\"NumcaballosFuerzaCamionCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert Es4x4PickUpCombo != null
                : "fx:id=\"Es4x4PickUpCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert deportivoPanel != null
                : "fx:id=\"deportivoPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert NumPasajerosCarroCampo != null
                : "fx:id=\"NumPasajerosCarroCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert tipoCombustibleCombo != null
                : "fx:id=\"tipoCombustibleCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert pickUpPanel != null
                : "fx:id=\"pickUpPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TieneVelocidadCruceroSUVCombo != null
                : "fx:id=\"TieneVelocidadCruceroSUVCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert CapacidadMaleteroCarroCampo != null
                : "fx:id=\"CapacidadMaleteroCarroCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TieneSensoresColisionSUVCombo != null
                : "fx:id=\"TieneSensoresColisionSUVCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert CapacidadCargaPickUpCampo != null
                : "fx:id=\"CapacidadCargaPickUpCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert tipoVehiculoCombo != null
                : "fx:id=\"tipoVehiculoCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert NumBolsasCarroCampo != null
                : "fx:id=\"NumBolsasCarroCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TieneVelocidadCruceroSedanCombo != null
                : "fx:id=\"TieneVelocidadCruceroSedanCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert InformacionAdicionalPanel != null
                : "fx:id=\"InformacionAdicionalPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TieneAsistenciaPermanenciaCarrilSedanCombo != null
                : "fx:id=\"TieneAsistenciaPermanenciaCarrilSedanCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert sedanPanel != null
                : "fx:id=\"sedanPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert numeroCambiosCampo != null
                : "fx:id=\"numeroCambiosCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert camionPanel != null
                : "fx:id=\"camionPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TieneSensorTraficoCruzadoSUVCombo != null
                : "fx:id=\"TieneSensorTraficoCruzadoSUVCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TituloInformacionAdicional != null
                : "fx:id=\"TituloInformacionAdicional\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert atrasButton != null
                : "fx:id=\"atrasButton\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert NumPuertasCarroCampo != null
                : "fx:id=\"NumPuertasCarroCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert carroPanel != null
                : "fx:id=\"carroPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert marcaCampo != null
                : "fx:id=\"marcaCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TieneAsistenciaPermanenciaCarrilSUVCombo != null
                : "fx:id=\"TieneAsistenciaPermanenciaCarrilSUVCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert busPanel != null
                : "fx:id=\"busPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert esEnchufableCombo != null
                : "fx:id=\"esEnchufableCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert precioDiaAlquilerCampo != null
                : "fx:id=\"precioDiaAlquilerCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert matriculaCampo != null
                : "fx:id=\"matriculaCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert NumSalidasEmergenciaBusCampo != null
                : "fx:id=\"NumSalidasEmergenciaBusCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert transmisionCombo != null
                : "fx:id=\"transmisionCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert Es4x4SUVCombo != null
                : "fx:id=\"Es4x4SUVCombo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert precioCampo != null
                : "fx:id=\"precioCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert valocidadMaximaCampo != null
                : "fx:id=\"valocidadMaximaCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TieneCamaraReversaCarroCombo != null
                : "fx:id=\"TieneCamaraReversa\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert VanPanel != null
                : "fx:id=\"VanPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert combustibleHibridoPanel != null
                : "fx:id=\"combustibleHibridoPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert añadirBoton != null
                : "fx:id=\"añadirBoton\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert combustibleElectricoPanel != null
                : "fx:id=\"combustibleElectricoPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert autonomiaCampo != null
                : "fx:id=\"autonomiaCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert SUVPanel != null
                : "fx:id=\"SUVPanel\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert modeloCampo != null
                : "fx:id=\"modeloCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";
        assert TiempoAlcanzar100KmHCamionCampo != null
                : "fx:id=\"TiempoAlcanzar100KmHCamionCampo\" was not injected: check your FXML file 'registrarVehiculoView.fxml'.";

    }
}
