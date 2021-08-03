package lk.ijse.dep7.sms_lite.controller;

import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import lk.ijse.dep7.sms_lite.tm.StudentTM;

public class MainFormController {
    public TextField txtID;
    public TextField txtName;
    public TextField txtContact;
    public ListView<String> lstPhone;
    public TableView<StudentTM> tblStudent;
    public Button btnRemove;
    public Button btnSave;
    public Button btnNew;


    public void initialize() {
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<StudentTM, Button> colDelete = (TableColumn<StudentTM, Button>) tblStudent.getColumns().get(2);

        colDelete.setCellValueFactory(param -> { //callBack
            Button btnDelete = new Button("Delete");
            return new ReadOnlyObjectWrapper<>(btnDelete);
        });



        ChangeListener<String> listener = (observable, oldValue, newValue) -> {
            String id = txtID.getText();
            String name = txtName.getText();

            btnSave.setDisable(!(id.matches("S\\d{4}") &&
                    name.matches("[A-Za-z ]{3,}")));
        };

        txtID.textProperty().addListener(listener);
        txtName.textProperty().addListener(listener);

        btnSave.setDisable(true);
        btnRemove.setDisable(true);
    }


    public void btnRemove_OnAction(ActionEvent actionEvent) {
    }

    public void btnSave_OnAction(ActionEvent actionEvent) {
        String id = txtID.getText();
        String name = txtName.getText();

        if (true) {
            tblStudent.getItems().add(new StudentTM(id, name));
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to save the customer!").show();
        }

    }

    public void btnNew_OnAction(ActionEvent actionEvent) {
        txtID.clear();
        txtName.clear();
        txtContact.clear();
        txtID.requestFocus();
    }
}
