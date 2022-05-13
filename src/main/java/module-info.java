module plus.ojbk.fxdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;


    opens plus.ojbk.exif to javafx.fxml;
    exports plus.ojbk.exif;
}
