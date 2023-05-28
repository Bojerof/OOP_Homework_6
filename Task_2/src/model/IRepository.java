package model;

import java.util.List;

public interface IRepository {
    List<Record> getAllRecord();
    void deleteRecord(Record deleteRecord);
    void updateRecord(Record updateRecord);
    String createRecord(Record record);
}
