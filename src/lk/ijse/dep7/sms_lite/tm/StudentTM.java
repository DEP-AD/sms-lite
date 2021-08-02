package lk.ijse.dep7.sms_lite.tm;

import javafx.scene.control.Button;

public class StudentTM {
    private String id;
    private String name;
    private Button btnDelete;

    public StudentTM() {
    }

    public StudentTM(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public StudentTM(String id, String name, Button btnDelete) {
        this.id = id;
        this.name = name;
        this.btnDelete = btnDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", btnDelete=" + btnDelete +
                '}';
    }
}
