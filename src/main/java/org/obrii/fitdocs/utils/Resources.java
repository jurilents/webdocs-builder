package org.obrii.fitdocs.utils;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Resources {

    public static FileInputStream readFileStream(String resourcePath, boolean decodeUrl) throws FileNotFoundException {
        return new FileInputStream(Resources.getAbsolutePath(resourcePath, decodeUrl));
    }

    public static FileInputStream readFileStream(String resourcePath) throws FileNotFoundException {
        return new FileInputStream(Resources.getAbsolutePath(resourcePath));
    }

    public static File getFile(String resourcePath) {
        ClassLoader classLoader = Resources.class.getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(resourcePath)).getFile());
    }

    @SneakyThrows
    public static byte[] getFileBinary(String resourcePath) {
        ClassLoader classLoader = Resources.class.getClassLoader();
        return Objects.requireNonNull(classLoader.getResourceAsStream(resourcePath)).readAllBytes();
    }

    public static String getAbsolutePath(String resourcePath, boolean decodeUrl) {
        if (decodeUrl) {
            try {
                resourcePath = URLDecoder.decode(resourcePath, StandardCharsets.UTF_8.toString());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return Resources.getAbsolutePath(resourcePath);
    }

    public static String getAbsolutePath(String resourcePath) {
        Path resourceDirectory = Paths.get("src", "main", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        String resultPath = String.format("%s\\%s", absolutePath, resourcePath);
        System.out.println("absolute path: " + resultPath);
        return resultPath;
    }
}
