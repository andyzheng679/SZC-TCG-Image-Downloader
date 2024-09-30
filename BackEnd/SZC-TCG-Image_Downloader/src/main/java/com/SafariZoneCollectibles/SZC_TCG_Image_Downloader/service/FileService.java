package com.SafariZoneCollectibles.SZC_TCG_Image_Downloader.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileService {

    public Path createTempDirectory(String setID) throws IOException{
        return Files.createTempDirectory(setID);
    }

    public void saveImgToFile(URL imageURL, Path file) throws IOException{
        Files.copy(imageURL.openStream(), file);
    }

    public void saveImagesSetName(String cardName, String rarity, String imageURL, Path tempDirectory) throws IOException {
        String cardFileName = cardName + "-" + rarity + ".jpg";
        URL cardImage = new URL(imageURL);
        Path file = tempDirectory.resolve(cardFileName);
        System.out.println("Saving image: " + cardFileName);  // Add this log
        saveImgToFile(cardImage, file);
        System.out.println("Saved image: " + cardFileName);  // Log after saving
    }


    public void createZipFile(Path tempDirectory, Path zipFile) throws IOException {
        System.out.println("Starting to create zip file...");
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile.toFile()))) {
            Files.walk(tempDirectory).filter(path -> !Files.isDirectory(path)).forEach(filePath -> {
                ZipEntry zipEntry = new ZipEntry(tempDirectory.relativize(filePath).toString());
                try {
                    zipOut.putNextEntry(zipEntry);
                    Files.copy(filePath, zipOut);
                    zipOut.closeEntry();
                    System.out.println("Added file to zip: " + filePath);  // Log each file added
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Finished creating zip file");
    }


    public void deleteTempDirectory(Path tempDir) throws IOException {
        Files.walk(tempDir)
                .sorted(Comparator.reverseOrder())  // Ensures files are deleted before directories
                .map(Path::toFile)
                .forEach(File::delete);
    }


}
