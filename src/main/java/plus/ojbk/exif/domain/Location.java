package plus.ojbk.exif.domain;

import plus.ojbk.exif.constant.Exif;


/**
 * @author wxm
 * @version 1.0
 * @since 2022/5/7 18:05
 */
public class Location {

    private String longitude;
    private String latitude;
    private String longitudeRef;
    private String latitudeRef;

    private String altitude;
    private String altitudeRef;


    private String location;
    private String country;
    private String province;
    private String city;

    private String path;


    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitudeRef() {
        return longitudeRef;
    }

    public void setLongitudeRef(String longitudeRef) {
        this.longitudeRef = longitudeRef;
    }

    public String getLatitudeRef() {
        return latitudeRef;
    }

    public void setLatitudeRef(String latitudeRef) {
        this.latitudeRef = latitudeRef;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getAltitudeRef() {
        return altitudeRef;
    }

    public void setAltitudeRef(String altitudeRef) {
        this.altitudeRef = altitudeRef;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Location() {
    }

    public Location(String longitude, String latitude, String longitudeRef, String latitudeRef, String altitude, String altitudeRef, String location, String country, String province, String city, String path) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.longitudeRef = longitudeRef;
        this.latitudeRef = latitudeRef;
        this.altitude = altitude;
        this.altitudeRef = altitudeRef;
        this.location = location;
        this.country = country;
        this.province = province;
        this.city = city;
        this.path = path;
    }

    /**
     * https://exiftool.org/faq.html#Q10
     *
     * https://exiftool.org/exiftool_pod.html#WINDOWS-UNICODE-FILE-NAMES
     */
    @Override
    public String toString() {
        String gt = "=\"";
        final StringBuffer sb = new StringBuffer(" -codedcharacterset=utf8 -v");
        //final StringBuffer sb = new StringBuffer(" -charset filename=utf8 -codedcharacterset=utf8 -v");
        if (!Exif.isEmpty(longitude)) {
            sb.append(" ").append(Exif.longitude).append(gt).append(longitude).append('\"');
        }
        if (!Exif.isEmpty(latitude)) {
            sb.append(" ").append(Exif.latitude).append(gt).append(latitude).append('\"');
        }
        if (!Exif.isEmpty(latitudeRef)) {
            sb.append(" ").append(Exif.latitudeRef).append(gt).append(latitudeRef).append('\"');
        }
        if (!Exif.isEmpty(longitudeRef)) {
            sb.append(" ").append(Exif.longitudeRef).append(gt).append(longitudeRef).append('\"');
        }
        if (!Exif.isEmpty(altitude)) {
            sb.append(" ").append(Exif.altitude).append(gt).append(altitude).append('\"');
        }
        if (!Exif.isEmpty(altitudeRef)) {
            sb.append(" ").append(Exif.altitudeRef).append(gt).append(altitudeRef).append('\"');
        }
        if (!Exif.isEmpty(location)) {
            sb.append(" ").append(Exif.location).append(gt).append(location).append('\"');
        }
        if (!Exif.isEmpty(country)) {
            sb.append(" ").append(Exif.country).append(gt).append(country).append('\"');
        }
        if (!Exif.isEmpty(province)) {
            sb.append(" ").append(Exif.province).append(gt).append(province).append('\"');
        }
        if (!Exif.isEmpty(city)) {
            sb.append(" ").append(Exif.city).append(gt).append(city).append('\"');
        }
        if (!Exif.isEmpty(path)) {
            sb.append(" ").append(path);
        }
        return sb.toString();
        //可能能解决中文乱码问题，如果效果不好还是别使用2333  一般情况默认的就是对的。
        //return new String(sb.toString().getBytes(StandardCharsets.UTF_8), Charset.forName("GBK"));
    }

}
