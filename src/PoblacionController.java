import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PoblacionController {
    @FXML private Button btIngresar;

    @FXML private TextField tfHabitantes;
    @FXML private TextField tfNivelAfectacion;

    @FXML void AccionIngresar(ActionEvent event) {
        DensidadPoblacional densidadPoblacional = new DensidadPoblacional();
            int poblacion = Integer.parseInt(tfHabitantes.getText());
            densidadPoblacional.afeccion(poblacion);
            tfNivelAfectacion.setText(String.valueOf(densidadPoblacional.afeccion(poblacion)));
        }
    }

