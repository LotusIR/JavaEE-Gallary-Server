package shu.jee.grandgallery.request;

public class UserPictureReq extends UserRequest {
    private Integer pictureId;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }
}
