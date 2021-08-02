package lk.ijse.dep7.sms_lite.controller;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep7.sms_lite.tm.StudentTM;

public class MainFormController {
    public TextField txtID;
    public TextField txtName;
    public TextField txtPhone;
    public ListView<String> lstPhone;
    public TableView<StudentTM> tblStudent;
    public Button btnClear;
    public Button btnRemove;
    public Button btnSave;

    public void initialize() {
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("btnDelete"));

        ChangeListener<String> listener = (observable, oldValue, newValue) -> {
            String id = txtID.getText();
            String name = txtName.getText();

            btnSave.setDisable(!(id.matches("S\\d{4}") &&
                    name.matches("[A-Za-z ]{3,}")));
        };

        txtID.textProperty().addListener(listener);
        txtName.textProperty().addListener(listener);

        btnSave.setDisable(true);
        btnClear.setDisable(true);
        btnRemove.setDisable(true);
    }

    public void btnClear_OnAction(ActionEvent actionEvent) {

    }

    public void btnRemove_OnAction(ActionEvent actionEvent) {
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        String id = txtID.getText();
        String name = txtName.getText();

        if(true){
            tblStudent.getItems().add(new StudentTM(id, name));
        }else {
            new Alert(Alert.AlertType.ERROR, "Failed to save the customer!").show();
        }

    }
}
