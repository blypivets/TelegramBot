package documents;

/**
 * Created by user on 23.09.17.
 */

public class Item implements DocumentInterface {

    private String fileName;
    private String fileLink;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
}
