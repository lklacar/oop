package com.lukaklacar.oop.util;

import com.lukaklacar.oop.exceptions.CannotReadFileException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUtil {
    public static void overrideFile(File file, List<String> lines) {
        try {
            FileUtils.writeLines(file, lines);
        } catch (IOException e) {
            throw new CannotWriteToFileException(e);
        }
    }

    public static List<String> getFileLines(File file) {
        try {
            return FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            throw new CannotReadFileException(e);
        }
    }
}
