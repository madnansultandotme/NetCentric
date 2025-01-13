import java.io.*;
import java.util.zip.*;

public class FileOperations {
    public static void main(String[] args) {
        try {
            String smallFile = "smallFile.txt";
            String heavyFile = "heavyFile.txt";
            String smallFileCopy = "smallFileCopy.txt";
            String heavyFileCopy = "heavyFileCopy.txt";

            System.out.println("Copying small file without BufferedStream...");
            long start = System.nanoTime();
            copyWithoutBufferedStream(smallFile, smallFileCopy);
            long end = System.nanoTime();
            System.out.println("Time without BufferedStream: " + (end - start) / 1e6 + " ms");

            System.out.println("Copying small file with BufferedStream...");
            start = System.nanoTime();
            copyWithBufferedStream(smallFile, smallFileCopy);
            end = System.nanoTime();
            System.out.println("Time with BufferedStream: " + (end - start) / 1e6 + " ms");

            System.out.println("Copying heavy file without BufferedStream...");
            start = System.nanoTime();
            copyWithoutBufferedStream(heavyFile, heavyFileCopy);
            end = System.nanoTime();
            System.out.println("Time without BufferedStream: " + (end - start) / 1e6 + " ms");

            System.out.println("Copying heavy file with BufferedStream...");
            start = System.nanoTime();
            copyWithBufferedStream(heavyFile, heavyFileCopy);
            end = System.nanoTime();
            System.out.println("Time with BufferedStream: " + (end - start) / 1e6 + " ms");

            String zipFile = "Downloads.zip";
            String specificFile = "File1 (2).txt";
            String outputFolder = "output/";
            String extractedFilePath = extractFileFromZip(zipFile, specificFile, outputFolder);

            System.out.println("\nContents of extracted file:");
            try (BufferedReader br = new BufferedReader(new FileReader(extractedFilePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void copyWithoutBufferedStream(String source, String destination) throws IOException {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
        }
    }

    public static void copyWithBufferedStream(String source, String destination) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }
    public static String extractFileFromZip(String zipFilePath, String fileName, String outputFolder) throws IOException {
        File dir = new File(outputFolder);
        if (!dir.exists()) dir.mkdirs();

        String extractedFilePath = null;

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().equals(fileName)) {
                    extractedFilePath = outputFolder + fileName;
                    try (FileOutputStream fos = new FileOutputStream(extractedFilePath)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                    break;
                }
                zis.closeEntry();
            }
        }

        if (extractedFilePath == null) {
            throw new FileNotFoundException("File " + fileName + " not found in zip archive.");
        }

        return extractedFilePath;
    }
}
