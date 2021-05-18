package shu.jee.grandgallery.response;

public class Response {
    Integer code;
    String message;
    Object obj;

    private Response() {
    }

    private Response(Integer code, String message, Object obj) {
        this.code = code;
        this.message = message;
        this.obj = obj;
    }

    static public Response success(String _message, Object _obj){
        return new Response(200,_message,_obj);
    }

    static public Response success(String _message){
        return new Response(200,_message,null);
    }

    static public Response error(String _message){
        return new Response(500,_message,null);
    }

    static public Response respond(Integer _code,String _message,Object _obj) {
        return new Response(_code,_message,_obj);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", obj=" + obj +
                '}';
    }
}
