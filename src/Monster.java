public class Monster {
    private int mId;
    private String mName;
    private String mDescription;
    private int location;
    private int mHp;
    private String attack1Des;
    private int attack1damage;
    private String attack2Des;
    private int attack2damage;
    private String attack3Des;
    private int attack3damage;
    private String attack4Des;
    private int attack4damage;

    public Monster(int mId, String mName, String mDescription, int location, int mHp, String attack1Des, int attack1damage, String attack2Des,
                   int attack2damage, String attack3Des, int attack3damage, String attack4Des, int attack4damage) {
        this.mId = mId;
        this.mName = mName;
        this.mDescription = mDescription;
        this.location = location;
        this.mHp = mHp;
        this.attack1Des = attack1Des;
        this.attack1damage = attack1damage;
        this.attack2Des = attack2Des;
        this.attack2damage = attack2damage;
        this.attack3Des = attack3Des;
        this.attack3damage = attack3damage;
        this.attack4Des = attack4Des;
        this.attack4damage = attack4damage;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getmHp() {
        return mHp;
    }

    public void setmHp(int mHp) {
        this.mHp = mHp;
    }

    public String getAttack1Des() {
        return attack1Des;
    }

    public void setAttack1Des(String attack1Des) {
        this.attack1Des = attack1Des;
    }

    public int getAttack1damage() {
        return attack1damage;
    }

    public void setAttack1damage(int attack1damage) {
        this.attack1damage = attack1damage;
    }

    public String getAttack2Des() {
        return attack2Des;
    }

    public void setAttack2Des(String attack2Des) {
        this.attack2Des = attack2Des;
    }

    public int getAttack2damage() {
        return attack2damage;
    }

    public void setAttack2damage(int attack2damage) {
        this.attack2damage = attack2damage;
    }

    public String getAttack3Des() {
        return attack3Des;
    }

    public void setAttack3Des(String attack3Des) {
        this.attack3Des = attack3Des;
    }

    public int getAttack3damage() {
        return attack3damage;
    }

    public void setAttack3damage(int attack3damage) {
        this.attack3damage = attack3damage;
    }

    public String getAttack4Des() {
        return attack4Des;
    }

    public void setAttack4Des(String attack4Des) {
        this.attack4Des = attack4Des;
    }

    public int getAttack4damage() {
        return attack4damage;
    }

    public void setAttack4damage(int attack4damage) {
        this.attack4damage = attack4damage;
    }
}
