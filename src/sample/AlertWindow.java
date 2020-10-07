package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Optional;

public class AlertWindow {

    public void errorAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Управление СТО");
        alert.setContentText(message);
        Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("img/car.png"));
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public void infoAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Управление СТО");
        alert.setContentText(message);
        Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("img/car.png"));
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public boolean confirmationAlert(String objNameToDelete, String objBriefInfo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Управление СТО");
        Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("img/car.png"));
        alert.setContentText(String.format("Удалить " + objNameToDelete + " (%s)?", objBriefInfo));
        alert.setHeaderText(null);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (ButtonType.OK.equals(buttonType.get()))
            return true;
        return false;
    }
}
