package serviceCallback;


import model.BaseModel;



public interface DataCallback<T extends BaseModel> {
    public void onSuccess(T data);

    public void onFail(String error);
}
