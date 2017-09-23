package documents;

/**
 * Created by user on 23.09.17.
 */
public class Practice implements DocumentInterface {

    private String [] taskLinks;
    private String telegraphTaskLink;

    public String[] getTaskLinks() {
        return taskLinks;
    }

    public String getTelegraphTaskLink() {
        return telegraphTaskLink;
    }

    public void setTelegraphTaskLink(String telegraphTaskLink) {
        this.telegraphTaskLink = telegraphTaskLink;
    }

    public void setTaskLinks(String[] taskLinks) {
        this.taskLinks = taskLinks;
    }
}
