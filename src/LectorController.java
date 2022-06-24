import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LectorController {
    ArrayList<CuerpoDeAgua> datosIngresados = new ArrayList<>();

    //TextField
    @FXML private TextField tfNombre;
    @FXML private TextField tfId;
    @FXML private TextField tfIdBusqueda;
    @FXML private TextField tfMunicipio;
    @FXML private TextField tfTipoCuerpo;
    @FXML private TextField tfTipoAgua;
    @FXML private TextField tfIrca;
    @FXML private TextArea tfIngresos;
    @FXML private TextArea tfSalidas;
    @FXML private TextField tfSalidas1;
    @FXML private TextField tfSalidas2;
    @FXML private TextField tfSalidas3;
    @FXML private TextField tfHabitantes;


    //Button
    @FXML private Button bIngresar;
    @FXML private Button bProcesar;
    @FXML private Button btPoblacion;

    @FXML void AccionIngresar(ActionEvent event) {
        CuerpoDeAgua cuerpoDeAgua = new CuerpoDeAgua();
        cuerpoDeAgua.guardarDatos(tfNombre.getText(), Integer.parseInt(tfId.getText()), tfMunicipio.getText(), tfTipoCuerpo.getText(), tfTipoAgua.getText(), Double.parseDouble(tfIrca.getText()), Integer.parseInt(tfHabitantes.getText()));
        datosIngresados.add(cuerpoDeAgua);
        
        if (tfNombre.getText().equals("") || tfId.getText().equals("") || tfMunicipio.getText().equals("") || tfTipoCuerpo.getText().equals("") || tfTipoAgua.getText().equals("") || tfIrca.getText().equals("")) {
            tfIngresos.setText("Faltan datos");
        } else {
            String[] datos = cuerpoDeAgua.consultarDatos();
            tfIngresos.appendText(datos[0] + " " + datos[1] + " " + datos[2] + " " + datos[3] + " " + datos[4] + " " + datos[5] + " " + datos[6] + "\n");
        }
        tfNombre.requestFocus();
        limpiar();
    }
    
    @FXML void AccionProcesar(ActionEvent event) {
        CuerpoDeAgua c = new CuerpoDeAgua();
        DecimalFormat formato = new DecimalFormat("0.00");
        int contador = 0;
        int contador2 = 0;
        double menor = 100;
        if(!tfIngresos.getText().equals("")){
            for (CuerpoDeAgua cAgua : datosIngresados) {
                tfSalidas.appendText(cAgua.getNombreCuerpoAgua() + " " + formato.format(cAgua.getIdCuerpoAgua()) + "\n");

                double nivelIRCA = cAgua.getIrca();
                if (c.nivel(nivelIRCA).equals("ALTO")) {
                    contador ++;
                } else if (c.nivel(nivelIRCA).equals("INVIABLEMENTE SANITARIO")) {
                    contador ++;}
                tfSalidas1.setText(formato.format(contador));

                if (c.nivel(nivelIRCA).equals("ALTO")) {
                    tfSalidas2.appendText(cAgua.getMunicipio() + " ");
                } else { contador2 ++;}

                if(contador2 == datosIngresados.size()){
                    tfSalidas2.setText("NA");}

                if (nivelIRCA < menor) {
                    menor = nivelIRCA;}
                    tfSalidas3.setText(c.nivel(menor));
            }
        }
    }

    public void limpiar() {
        tfNombre.setText("");
        tfId.setText("");
        tfMunicipio.setText("");
        tfTipoCuerpo.setText("");
        tfTipoAgua.setText("");
        tfIrca.setText("");
        tfHabitantes.setText("");
    }

    @FXML void AccionDensidad(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("poblacion.fxml"));
        Parent root = fxmlLoader.load(); 
        Scene scene = new Scene(root); 
        Stage stage = new Stage();

        stage.setTitle("Densidad Poblacional");
        stage.setScene(scene);
        stage.show();

    }
}