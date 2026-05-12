package com.shoesmandu.util;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class ImageUtil {

    // Extract file name
    public String getImageNameFromPart(Part part) {

        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        String imageName = null;

        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                imageName = s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }

        if (imageName == null || imageName.isEmpty()) {
            imageName = "download.png";
        }

        return imageName;
    }

    // Upload image
    public boolean uploadImage(Part part, String rootPath, String saveFolder) {

        String savePath = getSavePath(rootPath, saveFolder);
        File fileSaveDir = new File(savePath);

        if (!fileSaveDir.exists()) {
            if (!fileSaveDir.mkdirs()) {
                return false;
            }
        }

        try {
            String imageName = getImageNameFromPart(part);
            String filePath = savePath + File.separator + imageName;

            part.write(filePath);

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Build full save path
    public String getSavePath(String rootPath, String saveFolder) {
        return rootPath + File.separator + saveFolder;
    }
}