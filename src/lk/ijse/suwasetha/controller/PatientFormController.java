package lk.ijse.suwasetha.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PatientFormController {
    public AnchorPane window;
    public TextField txtsearch;
    public TableView tbl;
    public TableColumn colid;
    public TableColumn colname;
    public TableColumn coladdress;
    public TableColumn colemail;
    public TableColumn colcontact;
    public TableColumn colage;
    public TableColumn coloperate;
    public JFXButton btnsave;
    public JFXTextField txtage;
    public JFXTextField txtname;
    public JFXTextField txtnic;
    public JFXTextField txtcontact;
    public JFXComboBox colgender;
    public JFXTextField txtemail;
    public JFXTextField txtaddress;

    public void initialize() {
      /*  ObservableList<String> list =
                FXCollections.observableArrayList();
        list.add("MALE");
        list.add("FEMALE");
        list.add("OTHER");
        colgender.setItems(list);*/

      //second way
        colgender.getItems().addAll(
                "MALE",
                "FEMALE",
                "OTHER"
        );

    }

    public void btnBacToHome(ActionEvent actionEvent) throws IOException {
        Stage stage =
                (Stage) this.window.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(
                this.getClass().getResource(
                        "/lk/ijse/suwasetha/view/MainForm.fxml")
        )));
    }

    public void btnnew(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }
}
