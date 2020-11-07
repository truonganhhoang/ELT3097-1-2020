package serviceCallback;

import java.util.List;

import model.BaseModel;



public interface ListDataCallback<T extends BaseModel> {
    public void onSuccess(List<T> data);

    public void onFail(String error);
}