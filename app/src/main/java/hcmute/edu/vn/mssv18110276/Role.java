package hcmute.edu.vn.mssv18110276;

public class Role {
    private int iID;
    private String sName;

    public int getiID() {
        return iID;
    }
    public void setiID(int id) {
        this.iID = id;
    }

    public String getsName() {
        return sName;
    }
    public void setsName(String name) {
        this.sName = name;
    }

    public Role(int id, String Name){
        this.iID = id;
        this.sName = Name;
    }

    public Role(){}

    public void insertRole(DatabaseHandler db){
        try {
            db.insertRole(new Role(1, "Admin"));
            db.insertRole(new Role(2, "User"));
        }
        catch (Exception e){

        }
    }
}
