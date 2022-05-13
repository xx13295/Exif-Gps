package plus.ojbk.exif;

import plus.ojbk.exif.domain.Location;
import plus.ojbk.exif.service.ExifProcess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Objects;

public class IndexController {

    @FXML
    private TextField longitude;
    @FXML
    private TextField latitude;
    @FXML
    private ChoiceBox<String> longitudeRef;
    @FXML
    private ChoiceBox<String> latitudeRef;
    @FXML
    private TextField altitude;
    @FXML
    private TextField altitudeRef;

    @FXML
    private TextField subLocation;
    @FXML
    private TextField country;
    @FXML
    private TextField province;
    @FXML
    private TextField city;

    @FXML
    private Label filePath;

    private static File chooseFile = null;

    private static final String text = "请选择文件";
    private static final String title = "温馨提示";

    @FXML
    protected void onHelloButtonClick() {
        if (chooseFile == null) {
            alert(Alert.AlertType.ERROR, text);
            return;
        }
        Location location = buildLocation();
        try {
            ExifProcess.exec(location);
        } catch (Exception e) {
            alert(Alert.AlertType.ERROR, e.getMessage());
            return;
        }
        alert(Alert.AlertType.INFORMATION, "success");
    }

    public Location buildLocation(){
        String lon = longitude.getText();
        String lat = latitude.getText();
        String lonRef = longitudeRef.getValue();
        String latRef = latitudeRef.getValue();
        String alt = altitude.getText();
        String altRef = altitudeRef.getText();
        String sub = subLocation.getText();
        String cty = country.getText();
        String pve = province.getText();
        String ct = city.getText();
        return new Location(lon, lat, lonRef, latRef, alt, altRef, sub, cty, pve, ct, chooseFile.getPath());
    }

    public void getPicPath(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            filePath.setText(file.getName());
            chooseFile = file;
        } else {
            filePath.setText(text);
            chooseFile = null;
        }

    }

    void alert(Alert.AlertType type, String text) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(text);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(Objects.requireNonNull(IndexController.class.getResourceAsStream("/logo/logo.png")))) ;
        alert.showAndWait();
    }
}
