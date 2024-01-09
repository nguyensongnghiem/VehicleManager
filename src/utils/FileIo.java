package utils;

import java.io.*;
import java.util.ArrayList;

public class FileIo {

    private String path;

    public FileIo(String path) {
        this.path = path;
    }

    public void write(String str) {
        File file = new File(path);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(str);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<String> read() {
        File file = new File(path);
        ArrayList<String> result = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while (!((line = br.readLine()) == null)) {
                result.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
