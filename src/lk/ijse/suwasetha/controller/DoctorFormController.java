package lk.ijse.suwasetha.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lk.ijse.suwasetha.bo.BOFactory;
import lk.ijse.suwasetha.bo.CustomQueryBO;
import lk.ijse.suwasetha.bo.custom.DoctorBO;
import lk.ijse.suwasetha.dto.DoctorDTO;
import lk.ijse.suwasetha.tm.DoctorTM;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class DoctorFormController {
    public AnchorPane window;
    public JFXTextField txtdoctorid;
    public JFXTextField txtname;
    public JFXTextField txtcontact;
    public JFXTextField txtemail;
    public JFXTextField txtaddress;
    public JFXButton btnsave;
    public TextField txtsearch;
    public TableView<DoctorTM> tbl;
    public TableColumn colid;
    public TableColumn colname;
    public TableColumn coladdress;
    public TableColumn colemail;
    public TableColumn colcontact;
    public TableColumn coloperate;
    public ImageView imageView;
    private String imagePath;

    DoctorBO bo = BOFactory.getInstance().getBo(BOFactory.BOType.DOCTOR);
    CustomQueryBO querybo = BOFactory.getInstance().getBo(BOFactory.BOType.QUERY);

    public void initialize() {

        //listners------------------

        tbl.getSelectionModel().
                selectedItemProperty().
                addListener((
                        observable,
                        oldValue,
                        newValue) -> {

                   /* System.out.println("new Value"+newValue);
                    System.out.println("Old Value"+oldValue);*/

                    loadData(newValue);
                });


        txtsearch.textProperty().addListener
                ((observable, oldValue, newValue) -> {

                    try {
                        List<DoctorDTO> selectedDoctors = querybo.getSelectedDoctors(newValue);

                        //code

                        ObservableList<DoctorTM> list = FXCollections.observableArrayList();


                        List<DoctorDTO> allDoctors = querybo.getSelectedDoctors(newValue);

                        for (DoctorDTO Doctor : allDoctors) {
                            JFXButton btn = new JFXButton("Delete");
                            DoctorTM tm = new DoctorTM(
                                    Doctor.getId(),
                                    Doctor.getName(),
                                    Doctor.getAddress(),
                                    Doctor.getEmail(),
                                    Doctor.getContact(),
                                    btn
                            );
                            btn.setOnAction(event -> {

                                Alert alert =
                                        new Alert(Alert.AlertType.CONFIRMATION,
                                                "are You sure whether " +
                                                        "you want to delete this Doctor ?",
                                                ButtonType.YES, ButtonType.NO);

                                Optional<ButtonType> buttonType = alert.showAndWait();
                                if (buttonType.get() == ButtonType.YES) {

                                    for (DoctorDTO temp : allDoctors) {
                                        if (temp.getId().equals(tm.getId())) {
                                            System.out.println(tm.getId());
                                            //delete code===============

                                            try {
                                                boolean isDelete = bo.deleteDoctor(tm.getId());
                                                if (isDelete) loadAllDoctors();
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            } catch (ClassNotFoundException e) {
                                                e.printStackTrace();
                                            }

                                            //delete code===============
                                        }
                                    }


                                }


                            });
                            list.add(tm);
                        }
                        tbl.setItems(list);


                        //code


                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });


        //listners------------------


        colid.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colcontact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        coloperate.setCellValueFactory(new PropertyValueFactory<>("btn"));

        try {
            loadAllDoctors();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadData(DoctorTM newValue) {
        txtemail.setText(newValue.getEmail());
        txtcontact.setText(newValue.getContact());
        txtaddress.setText(newValue.getAddress());
        txtname.setText(newValue.getName());
        txtdoctorid.setText(newValue.getId());

        btnsave.setText("update");
    }


    private void loadAllDoctors() throws ClassNotFoundException, SQLException {
        ObservableList<DoctorTM> list = FXCollections.observableArrayList();


        List<DoctorDTO> allDoctors = bo.getAllDoctors();

        for (DoctorDTO Doctor : allDoctors) {
            JFXButton btn = new JFXButton("Delete");
            DoctorTM tm = new DoctorTM(
                    Doctor.getId(),
                    Doctor.getName(),
                    Doctor.getAddress(),
                    Doctor.getEmail(),
                    Doctor.getContact(),
                    btn
            );
            btn.setOnAction(event -> {

                Alert alert =
                        new Alert(Alert.AlertType.CONFIRMATION,
                                "are You sure whether " +
                                        "you want to delete this Doctor ?",
                                ButtonType.YES, ButtonType.NO);

                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get() == ButtonType.YES) {

                    for (DoctorDTO temp : allDoctors) {
                        if (temp.getId().equals(tm.getId())) {
                            System.out.println(tm.getId());
                            //delete code===============

                            try {
                                boolean isDelete = bo.deleteDoctor(tm.getId());
                                if (isDelete) loadAllDoctors();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            //delete code===============
                        }
                    }


                }


            });
            list.add(tm);
        }
        tbl.setItems(list);
    }


    public void btnBacToHome(MouseEvent mouseEvent) throws IOException {
        Stage stage =
                (Stage) this.window.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(
                this.getClass().getResource(
                        "/lk/ijse/suwasetha/view/MainForm.fxml")
        )));
    }

    public void btnNewOnaction(ActionEvent actionEvent) {

        btnsave.setText("Save");
        clearAll();

    }

    private void clearAll() {
        txtdoctorid.clear();
        txtname.clear();
        txtaddress.clear();
        txtemail.clear();
        txtcontact.clear();
    }

    public void btnBrowse(ActionEvent actionEvent) throws MalformedURLException {
        //1
        FileChooser chooser = new FileChooser();
        //2
        chooser.setTitle("Open Image");
        //3
        chooser.setInitialDirectory(
                new File(System.getProperty("user.home")));
        //4
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter
                        ("Image Files",
                                "*.jpg",
                                "*.png",
                                "*.bmp",
                                "*.jif")
        );
        //5
        File file = chooser.showOpenDialog(new Stage());

        if (null != file) {
            //6
            imagePath = file.toURI().toURL().toString();
            //7
            System.out.println("image path: " + imagePath);
            //8
            Image image = new Image(imagePath);
            //9
            imageView.setImage(image);
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Please Select a File");
            alert.show();
        }

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        if (Pattern.matches("[a-zA-Z]{3,5}",
                txtname.getText())){

            if (Pattern.matches("[0-9]{3}[-]{1}[0-9]{7}",txtcontact.getText())){
                //save
            }else{
                new Alert(Alert.AlertType.WARNING,
                        "Wrong Contact",ButtonType.CANCEL)
                        .show();
            }

        }else{
          new Alert(Alert.AlertType.WARNING,
                  "Wrong Name",ButtonType.CANCEL)
                  .show();
        }

        // "[12]{1}[0-9]{5}"

        if (btnsave.getText().
                equalsIgnoreCase(
                        "Save")) {
            //save
            try {
                boolean isSaved = bo.saveDoctor(
                        new DoctorDTO(
                                txtdoctorid.getText(),
                                txtname.getText(),
                                txtaddress.getText(),
                                txtcontact.getText(),
                                txtemail.getText(),
                                imagePath
                        ));

                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            "Done",
                            ButtonType.OK).show();
                    loadAllDoctors();

                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {

            //update

            try {
                boolean isUpdate = bo.updateDoctor(
                        new DoctorDTO(
                                txtdoctorid.getText(),
                                txtname.getText(),
                                txtaddress.getText(),
                                txtcontact.getText(),
                                txtemail.getText(),
                                imagePath
                        ));
                if (isUpdate) {
                    new Alert(Alert.AlertType.CONFIRMATION,
                            "Done",
                            ButtonType.OK).show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void printAll(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, JRException {

        List<DoctorDTO> all = bo.getAllDoctors();

        JasperReport jasperReport= (JasperReport)
                JRLoader.loadObject(
                this.getClass().
                getResourceAsStream(
                "/lk/ijse/suwasetha/report/Customer.jasper")
        );
        Map<String,Object> params= new HashMap<>();
        for (DoctorDTO dto : all) {
            params.put("id",dto.getId());
            params.put("name",dto.getName());
            params.put("address",dto.getAddress());
            params.put("contact",dto.getContact());
            params.put("email",dto.getEmail());
        }
        JasperPrint jasperPrint= JasperFillManager.fillReport(
                jasperReport,params,new JREmptyDataSource()
        );
        JasperViewer.viewReport(jasperPrint);


    }
}
