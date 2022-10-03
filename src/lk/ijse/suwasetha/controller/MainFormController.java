package lk.ijse.suwasetha.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;

public class MainFormController {
    public AnchorPane window;

    public void imgOpennDoctorForm(MouseEvent mouseEvent) throws IOException {
        Stage stage =
                (Stage) this.window.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(
                this.getClass().getResource(
                        "/lk/ijse/suwasetha/view/DoctorForm.fxml")
        )));
    }

    public void btnOpenPatient(MouseEvent mouseEvent) throws IOException {
        Stage stage =
                (Stage) this.window.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(
                this.getClass().getResource(
                        "/lk/ijse/suwasetha/view/PatientForm.fxml")
        )));
    }

    public void imgOpenAppointmentForm(MouseEvent mouseEvent) throws IOException {
        Stage stage =
                (Stage) this.window.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(
                this.getClass().getResource(
                        "/lk/ijse/suwasetha/view/AppointmentForm.fxml")
        )));
    }

    public void imgOpenPaymentHistory(MouseEvent mouseEvent) throws IOException {
        //1
        URL url =
                this.getClass().
                        getResource("/lk/ijse/suwasetha/view/PaymentDetailForm.fxml");
        //2
        Parent load = FXMLLoader.load(url);
        //3
        Stage stage = new Stage();
        //4
        Scene scene = new Scene(load);
        //5
        stage.setScene(scene);
        //6
       // stage.initStyle(StageStyle.UNDECORATED);
        //7
        stage.show();
    }

    public void imgOpenAppointmentDetalForm(MouseEvent mouseEvent) throws IOException {
        //1
        URL url1 =
                this.getClass().
                        getResource("/lk/ijse/suwasetha/view/AppointmentDetailForm.fxml");
        //2
        Parent load1 = FXMLLoader.load(url1);
        //3
        Stage stage1 = new Stage();
        //4
        Scene scene = new Scene(load1);
        //5
        stage1.setScene(scene);
        //6
        // stage.initStyle(StageStyle.UNDECORATED);
        //7
        stage1.show();
    }
}
