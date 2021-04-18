package br.com.cariuska.qrcode.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {

    public static String getPathImages() throws IOException {
        // Get the path of images under static
        File directory = new File("src/main/resources/static/images");
        String filePath = directory.getCanonicalPath();
        return filePath;
    }


    public static String pathFormat(String str) {
        // Convert the \\ of the path to // otherwise the log image path in the middle of the subsequent QR code will not be found
        String result = str.replaceAll("\\\\", "/");
        return result;
    }

    public static void main(String[] args) {
        try {
            System.err.println(getPathImages());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
