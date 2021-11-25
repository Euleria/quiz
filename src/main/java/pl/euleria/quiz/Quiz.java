package pl.euleria.quiz;

import java.util.ArrayList;

public class Quiz {
    private ArrayList<Category> categoryList;

    public Quiz() {
        this.categoryList = new ArrayList<>();
    }

    public void addCategory(Category category){
        categoryList.add(category);
    }

    public ArrayList<Category> getCategoryList() {
        return categoryList;
    }
}


