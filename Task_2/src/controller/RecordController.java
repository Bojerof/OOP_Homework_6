package controller;

import model.Record;
import model.Repository;

import java.util.List;

public class RecordController {
    private final Repository repository;
    public RecordController(Repository repository){
        this.repository = repository;
    }
    public void saveRecord(Record record){
        repository.createRecord(record);
    }
    public Record readRecord(String recordId) throws Exception{
        List<Record> records = repository.getAllRecord();
        for (Record item : records){
            if (item.getId().equals(recordId))
                return item;
        }
        throw new Exception("Not Found!");
    }
    public void deleteRecord(Record deleteRecord){
        repository.deleteRecord(deleteRecord);
    }
    public void updateRecord(Record updateRecord){repository.updateRecord(updateRecord);}

    public List<Record> getRecords(){return repository.getAllRecord();}
}

