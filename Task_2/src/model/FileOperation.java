package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperation implements IFileOperating{
    private String fileName;
    public FileOperation(String fileName){
        this.fileName = fileName;
        try(FileWriter writer = new FileWriter(fileName, true)){
            writer.flush();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public List<String> readAllLines(){
        List<String> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader bufRead = new BufferedReader(fr);
            String line = bufRead.readLine();
            if(line != null)
                list.add(line);
            while (line != null){
                line = bufRead.readLine();
                if(line != null)
                    list.add(line);
            }
            fr.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
    public void saveAll(List<String> lines){
        try (FileWriter fileWriter = new FileWriter(fileName, false)){
            for (String line : lines) {
                fileWriter.write(line);
                fileWriter.write("\n");
            }
            fileWriter.flush();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
