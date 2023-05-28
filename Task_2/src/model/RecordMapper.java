package model;

public class RecordMapper {
    public String map(Record record){
        return String.format("%s;%s;%s", record.getId(), record.getToc(), record.getContent());
    }
    public Record map(String line){
        String[] lines = line.split(";");
        return new Record(lines[0], lines[1], lines[2]);
    }
}
