package com.job.util;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileProcessor {

    private final String uploadDirectory;

    public FileProcessor(String uploadDirectory) {
        this.uploadDirectory = uploadDirectory;
    }

    public String processFile(Part filePart) {
        try {
            // 处理文件项
            String fileName = getSubmittedFileName(filePart);
            String filePath = uploadDirectory + File.separator + fileName;

            // 将文件保存到指定路径
            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    // 从 Part 中获取上传的文件名
    private String getSubmittedFileName(Part part) {
        String header = part.getHeader("content-disposition");
        for (String token : header.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "unknown";
    }
}



