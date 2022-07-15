package model;


public class Catergory {
    private int idC;
    private String nameC;

    public Catergory() {
    }

    public Catergory(int idC, String nameC) {
        this.idC = idC;
        this.nameC = nameC;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }
}
