package model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String img;
    private Catergory catergory;
    private boolean status;

    public Product() {
    }

    public Product(int id, String name, int price, String img, Catergory catergory, boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.catergory = catergory;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Catergory getCatergory() {
        return catergory;
    }

    public void setCatergory(Catergory catergory) {
        this.catergory = catergory;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
