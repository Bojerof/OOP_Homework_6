package model;

import java.util.List;

public interface IFileOperating {
    public List<String> readAllLines();
    public void saveAll(List<String> lines);
}
