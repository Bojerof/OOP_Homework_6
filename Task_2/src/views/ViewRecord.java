package views;

import controller.RecordController;
import model.Record;

import java.util.List;
import java.util.Scanner;

public class ViewRecord {
    private RecordController recordController;
    public ViewRecord(RecordController recordController){this.recordController = recordController;}
    public void run(){
        Commands com = Commands.NONE;
        while (true){
            try{
                String command = print("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;;
                switch (com){
                    case CREATE:
                        create();
                        break;
                    case DELETE:
                        delete();
                        break;
                    case UPDATE:
                        update();
                        break;
                    case LIST:
                        printAll();
                        break;
                    case READ:
                        System.out.println(read());
                        break;

                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void update() {
        Record record = read();
        String id = record.getId();
        Record newRecord = input();
        newRecord.setId(id);
        recordController.updateRecord(newRecord);
    }

    private void create(){
        recordController.saveRecord(input());
    }
    private Record input(){
        String toc = print("Введите оглавление: ");
        String content = print("Введите текст: ");
        return new Record(toc, content);
    }
    private Record read(){
        String id = print("Введите индетификатор: ");
        try{
            Record record = recordController.readRecord(id);
            return record;
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }
    private void delete(){
        Record record = read();
        recordController.deleteRecord(record);
    }
    private void printAll(){
        List<Record> list = recordController.getRecords();
        for (Record item : list)
            System.out.println(item);
    }

    private String print(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }
}
