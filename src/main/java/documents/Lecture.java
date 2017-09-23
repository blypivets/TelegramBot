package documents;

/**
 * Created by user on 23.09.17.
 */
public class Lecture implements DocumentInterface {

    private String [] lectureLinks;
    private String telegraphTaskLink;
    private String VileoLink;

    public String[] getLectureLinks() {
        return lectureLinks;
    }

    public String getTelegraphTaskLink() {
        return telegraphTaskLink;
    }

    public String getVileoLink() {
        return VileoLink;
    }

    public void setTelegraphTaskLink(String telegraphTaskLink) {
        this.telegraphTaskLink = telegraphTaskLink;
    }

    public void setLectureLinks(String[] lectureLinks) {
        this.lectureLinks = lectureLinks;
    }

    public void setVileoLink(String vileoLink) {
        VileoLink = vileoLink;
    }
}
