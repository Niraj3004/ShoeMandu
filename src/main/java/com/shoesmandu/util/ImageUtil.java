package com.shoesmandu.util;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.Part;

/**
 * ImageUtil provides helper methods for
 * handling image upload functionality in
 * the Shoesmandu system.
 * 
 * It supports:
 * 1. Extracting file name from multipart request
 * 2. Uploading image to server directory
 * 3. Building file save paths
 */
public class ImageUtil {

    /**
     * Extracts the image file name from multipart Part.
     * 
     * If no file is selected, returns default image name.
     * 
     * @param part uploaded file part
     * @return image file name
     */
    public String getImageNameFromPart(Part part) {

        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        String imageName = null;

        for (String s : items) {

            if (s.trim().startsWith("filename")) {

                imageName = s.substring(
                        s.indexOf("=") + 2,
                        s.length() - 1
                );
            }
        }

        // DEFAULT IMAGE IF NONE SELECTED
        if (imageName == null || imageName.isEmpty()) {
            imageName = "download.png";
        }

        return imageName;
    }

    /**
     * Uploads image file to server directory.
     * 
     * @param part uploaded file
     * @param rootPath application root path
     * @param saveFolder folder name to save image
     * @return true if upload successful
     */
    public boolean uploadImage(Part part, String rootPath, String saveFolder) {

        String savePath = getSavePath(rootPath, saveFolder);

        File fileSaveDir = new File(savePath);

        // CREATE DIRECTORY IF NOT EXISTS
        if (!fileSaveDir.exists()) {

            if (!fileSaveDir.mkdirs()) {
                return false;
            }
        }

        try {

            String imageName = getImageNameFromPart(part);
            String filePath = savePath + File.separator + imageName;

            // SAVE FILE
            part.write(filePath);

            return true;

        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }
    }

    /**
     * Builds full file save path.
     * 
     * @param rootPath application root path
     * @param saveFolder folder name
     * @return full directory path
     */
    public String getSavePath(String rootPath, String saveFolder) {

        return rootPath + File.separator + saveFolder;
    }
}