## 第一个javafx应用

    自定义修改 Exif 里面的GPS信息。

    右边Releases 下载打好包的文件就完事了
      
    下载带包好的ExifGPS.7z压缩包
    解压后 进入 bin 目录
    找到 自定义GPS.exe 启动即可


### 代码启动的话idea 右边 maven 工具
    javafx:run


###  手动

java --module-path "D:\Program Files\Java\javafx-sdk-17.0.2\lib" --add-modules=javafx.controls,javafx.fxml,javafx.base,javafx.media,javafx.web,javafx.swing -jar demo.jar
