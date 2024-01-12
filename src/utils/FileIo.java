package utils;

import java.io.*;
import java.util.ArrayList;

public class FileIo {

    private String path;
    private boolean append;

    public FileIo(String path) {
        this.path = path;

    }

    public void write(String str, boolean append) {
        File file = new File(path);
        try {
            file.createNewFile();
            System.out.println("File created !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,append);
        BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(str);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("File IO error .");
        }

    }
    public void writeList(ArrayList<String> strList, boolean append) {
        File file = new File(path);
        try {
            file.createNewFile();
            System.out.println("File created !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file,append);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (String str : strList) {
            bw.write(str);
            bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("File IO error .");
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
            br.close();

        } catch (IOException e) {
            System.out.println("File IO error");
        }
        return result;
    }
}
