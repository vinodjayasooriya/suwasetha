package lk.ijse.suwasetha.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.ijse.suwasetha.bo.BOFactory;
import lk.ijse.suwasetha.bo.custom.DoctorBO;
import lk.ijse.suwasetha.dto.DoctorDTO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class AppointmentFormController {
    public AnchorPane window;
    public TextField txtappid;
    public JFXDatePicker txtdate;
    public JFXComboBox colpatient;
    public TextField txtpatientname;
    public TextField txtpatientemail;
    public JFXComboBox coldoctor;
    public TextField txtdoctornae;
    public TextField txtxtdoctoremail;
    public ImageView imgview;
    public JFXTimePicker txttotime;
    public JFXTimePicker txtfromtime;
    public Label txtstate;


    DoctorBO bo= BOFactory.getInstance().
            getBo(BOFactory.BOType.DOCTOR);

    public void initialize() throws SQLException, ClassNotFoundException {
        loadAllDoctorID();
        loadAllPatient();
    }

    private void loadAllPatient() {

    }

    private void loadAllDoctorID() throws SQLException, ClassNotFoundException {
        List<DoctorDTO> allDoctors = bo.getAllDoctors();
        for (DoctorDTO temp : allDoctors) {
            coldoctor.getItems().add(
                    temp.getId()
            );
        }
    }


    public void btnBacToHom(ActionEvent actionEvent) throws IOException {
        Stage stage =
                (Stage) this.window.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(
                this.getClass().getResource(
                        "/lk/ijse/suwasetha/view/MainForm.fxml")
        )));
    }

    public void btnOpenPaymentForm(ActionEvent actionEvent) throws IOException {
        //1
        URL url =
                this.getClass().
                        getResource("/lk/ijse/suwasetha/view/PaymentForm.fxml");
        //2
        Parent load = FXMLLoader.load(url);
        //3
        Stage stage = new Stage();
        //4
        Scene scene = new Scene(load);
        //5
        stage.setScene(scene);
/*        //6
        stage.initStyle(StageStyle.UNDECORATED);*/
        //7
        stage.show();
    }

    public void btnCheckAvailable(ActionEvent actionEvent) {
    }

    public void btnNew(ActionEvent actionEvent) {
    }
}
