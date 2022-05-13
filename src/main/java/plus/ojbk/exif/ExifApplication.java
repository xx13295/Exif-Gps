package plus.ojbk.exif;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ExifApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ExifApplication.class.getResource("/fxml/index.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.getIcons().add(new Image(Objects.requireNonNull(ExifApplication.class.getResourceAsStream("/logo/logo.png")))) ;
        stage.setTitle("Exif自定义修改GPS（IPTC中文不太友好）");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
