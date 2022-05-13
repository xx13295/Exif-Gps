package plus.ojbk.exif.service;

import plus.ojbk.exif.domain.Location;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author wxm
 * @version 1.0
 * @since 2022/5/9 17:19
 */
public class ExifProcess {

    private static String logPath = System.getProperty("user.dir");

    public static void exec(Location location) throws Exception {
        try {
            builderCommand(location);
        } catch (Exception e) {
            Path path = getPath();
            writeLog(path, e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }

    public static void builderCommand(Location location) throws Exception {
        BufferedReader br = null;
        try {
            Path path = getPath();
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("exiftool.exe" + location.toString());
            boolean flag = process.waitFor(5000L, TimeUnit.MILLISECONDS);
            //Process process = runtime.exec("exiftool.exe" + " -GPSLongitude=\"-84.683333\"  -GPSLatitude=\"10.502117\"  -GPSLongitudeRef=\"West\" -GPSLatitudeRef=\"North\" -GPSAltitudeRef=\"1\" -GPSAltitude=\"41\" -City=\"ojbk\" -Sub-location=\"location\" -Country-PrimaryLocationName=\"country\" -Province-State=\"666\" D:\\ffmpeg\\bin\\ded\\demo.jpg");
            InputStream in = process.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));

            String line = br.readLine();
            while (line != null) {
                System.err.println(line);
                writeLog(path, line);
                line = br.readLine();
            }
            if (!flag && line == null) {
                writeLog(path, "cmd maybe timeout");
            }
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getLogs(String text) {
        LocalDateTime now = LocalDateTime.now();
        String formatStr = "[%s]: %s \n";
        return String.format(formatStr, now, text);
    }

    private static void writeLog(Path path, String text) throws Exception {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write(getLogs(text));
        }
    }

    private static Path getPath() throws Exception {
        Path path = Paths.get(logPath, "log", "ExifGps.log");
        if (!Files.exists(path)) {
            Path dir = Paths.get(logPath, "log");
            if (!Files.exists(dir)) {
                Files.createDirectories(dir);
            }
            Files.createFile(path);
        }
        return path;
    }

}
