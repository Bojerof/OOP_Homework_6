package model;

public class Record {
    private String id = "";
    private String toc;
    private String content;

    public Record(String toc, String content) {
        this.toc = toc;
        this.content = content;
    }

    public Record(String id, String toc, String content) {
        this(toc, content);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getToc() {
        return toc;
    }

    public String getContent() {
        return content;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setToc(String toc) {
        this.toc = toc;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return String.format("ID %s, Оглавление - %s, Содержание - %s", id, toc, content);
    }
}
