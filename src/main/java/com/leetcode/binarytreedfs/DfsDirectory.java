package com.leetcode.binarytreedfs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DfsDirectory {
    void main() {
        String filePath = "/Users/kgnine/Documents/Invoice";
        File startingFolder = new File(filePath);
        performDFS(filePath);
        IO.println("Old Way...");
        traverse(startingFolder);
    }

    // New Way
    void performDFS(String filePath) {
        try(Stream<Path> paths = Files.walk(Paths.get(filePath))) {
            paths.filter(Files::isRegularFile)
                    .forEach(path -> IO.println("File: " + path.toAbsolutePath()));
        }
        catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }

    // Old Way
    void traverse(File directory) {

        File[] files = directory.listFiles();

        if(null == files) return;

        for(File file: files) {
            if(file.isDirectory())
                traverse(file);
            else{
                IO.println("File: " + file.getName());
            }
        }
    }
}
