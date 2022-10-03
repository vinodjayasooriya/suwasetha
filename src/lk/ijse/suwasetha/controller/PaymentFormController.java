package lk.ijse.suwasetha.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PaymentFormController {
    public AnchorPane window;
    public TextField txtinvoice;
    public TextField txtappid;
    public TextField txtcost;
    public TextField txtdate;
    public TextField txttime;
    public JFXComboBox colmethod;
    public TextField txtcash;
    public TextField txtbalance;

    public void initialize() {
        colmethod.getItems().addAll("CARD", "CASH");
    }

    public void btnpay(ActionEvent actionEvent) {
    }

    public void btncancel(ActionEvent actionEvent) {
    }
}
