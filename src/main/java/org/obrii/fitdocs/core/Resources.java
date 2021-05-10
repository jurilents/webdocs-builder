package org.obrii.fitdocs.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Resources {

    public static FileInputStream readFileStream(String resourcePath) throws FileNotFoundException {
        return new FileInputStream(Resources.getAbsolutePath(resourcePath));
    }

    public static File getFile(String resourcePath) {
        ClassLoader classLoader = Resources.class.getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(resourcePath)).getFile());
    }

    public static String getAbsolutePath(String resourcePath) {
        Path resourceDirectory = Paths.get("src", "main", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        return String.format("%s/%s", absolutePath, resourcePath);
    }
}
