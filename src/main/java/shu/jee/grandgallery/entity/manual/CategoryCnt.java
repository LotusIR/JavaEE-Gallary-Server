package shu.jee.grandgallery.entity.manual;

public class CategoryCnt {
    private String categoryName;
    private Integer weight;

    public CategoryCnt(String categoryName, Integer weight) {
        this.categoryName = categoryName;
        this.weight = weight;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
