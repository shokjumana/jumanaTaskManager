package shk.jumana.jumanataskmanager.Data.data;

/**
 * فئة تصف مهمة بادارة المهمات
 */


public class Mahame
{

    /**
     * رقم مميز للمهمة يتم انتاجه من قبل خادم
     */

    private String key;
    //المزهي لكل المهمات-رقم مميز -رقم هوية -id
    /**
     * رقم مميز للمستعمل
     */
    private String title;
    private String subject;
    private int importance;  //for the seek bar
    private String owners;

    public Mahame()
    {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    @Override
    public String toString() {
        return "Mahame{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", importance=" + importance +
                ", owners='" + owners + '\'' +
                '}';
    }
}
