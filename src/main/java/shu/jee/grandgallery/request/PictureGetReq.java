package shu.jee.grandgallery.request;

import shu.jee.grandgallery.entity.data.PictureInfo;

public class PictureGetReq {
    private PictureInfo info;
    private String orderBy;
    private String order;

    public PictureInfo getInfo() {
        return info;
    }

    public void setInfo(PictureInfo info) {
        this.info = info;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
