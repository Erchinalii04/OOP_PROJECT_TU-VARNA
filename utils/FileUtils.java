package utils;

import interfaces.FileHandler;
import models.GameMap;
import java.io.*;
import java.util.*;

public class FileUtils implements FileHandler {
    @Override
    public GameMap open(String path) throws Exception {
        List<char[]> rows = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = r.readLine()) != null) rows.add(line.toCharArray());
        }
        return new GameMap(rows.toArray(new char[0][]));
    }

    @Override
    public void save(String path, GameMap map) throws Exception {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (int i = 0; i < map.getHeight(); i++) {
                for (int j = 0; j < map.getWidth(); j++) pw.print(map.getAt(i, j));
                pw.println();
            }
        }
    }
}