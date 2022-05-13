package plus.ojbk.exif.constant;

/**
 * @author wxm
 * @version 1.0
 * @since 2022/5/7 18:13
 */
public class Exif {

    public static String longitude = "-GPSLongitude";
    public static String latitude = "-GPSLatitude";
    public static String longitudeRef = "-GPSLongitudeRef";
    public static String latitudeRef = "-GPSLatitudeRef";

    public static String altitude = "-GPSAltitude";
    public static String altitudeRef = "-GPSAltitudeRef";

    public static String location = "-Sub-location";
    public static String country = "-Country-PrimaryLocationName";
    public static String province = "-Province-State";
    public static String city = "-City";


    public static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
}
