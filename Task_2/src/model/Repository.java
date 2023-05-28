package model;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{
    private RecordMapper mapper = new RecordMapper();
    private FileOperation operation;

    public Repository (FileOperation operation){this.operation = operation;}

    @Override
    public List<Record> getAllRecord() {
        List<String> lines = operation.readAllLines();
        List<Record> records = new ArrayList<>();
        for (String line : lines){
            records.add(mapper.map(line));
        }
        return records;
    }

    @Override
    public void deleteRecord(Record deleteRecord) {
        List<Record> records = this.getAllRecord();
        List<Record> newRecord = new ArrayList<>();
        int id = 1;
        for (Record item : records){
            if (!item.getId().equals(deleteRecord.getId())) {
                item.setId(String.format("%d", id));
                newRecord.add(item);
                id += 1;
            }
        }
        saveAllRecords(newRecord);
    }

    @Override
    public void updateRecord(Record updateRecord) {
        List<Record> record = this.getAllRecord();
        for (Record item : record){
            if(updateRecord.getId().equals(item.getId())){
                item.setToc(updateRecord.getToc());
                item.setContent(updateRecord.getContent());
            }
        }
        saveAllRecords(record);

    }

    @Override
    public String createRecord(Record record) {
        List<Record> records = this.getAllRecord();
        int max = 0;
        for (Record item : records){
            int id = Integer.parseInt(item.getId());
            if (max < id)
                max = id;
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        record.setId(id);
        records.add(record);
        saveAllRecords(records);
        return id;
    }

    private void saveAllRecords(List<Record> records) {
        List<String> line = new ArrayList<>();
        for (Record item : records){
            line.add(mapper.map(item));
        }
        operation.saveAll(line);
    }
}
