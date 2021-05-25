package shu.jee.grandgallery.mapper.params;

public class PictureParams {
    private String category;
    private Integer startIndex;
    private Integer endIndex;
    private String orderBy;
    private String order;

    public PictureParams(String category, Integer startIndex, Integer endIndex, String orderBy, String order) {
        this.category = category;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.orderBy = orderBy;
        this.order = order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }
}
