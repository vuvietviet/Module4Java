package service;

import model.Catergory;

import java.util.ArrayList;
import java.util.List;

public class CatergoryService implements ICatergoryService{

    public static final List<Catergory> catergoryList = new ArrayList<>();
    static {
        catergoryList.add(new Catergory(1,"VIP"));
        catergoryList.add(new Catergory(2,"NORMAL"));
    }
    @Override
    public Catergory findById(int id) {
        return catergoryList.get(id);
    }
}
