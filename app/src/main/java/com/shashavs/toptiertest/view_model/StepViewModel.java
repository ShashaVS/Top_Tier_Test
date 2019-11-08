package com.shashavs.toptiertest.view_model;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.shashavs.toptiertest.data.api.ApiService;
import com.shashavs.toptiertest.data.entity.Uiname;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class StepViewModel extends ViewModel {
    private String TAG = "StepViewModel";

    private ApiService apiService;
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<List<Uiname>> resultLiveData = new MutableLiveData<>();

    StepViewModel(ApiService apiService) {
        this.apiService = apiService;
        compositeDisposable = new CompositeDisposable();
        getUinames();
    }

    private void getUinames() {
        apiService.getUinames("3", "male", "age")
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new SingleObserver<Response<List<Uiname>>>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        compositeDisposable.add(disposable);
                    }

                    @Override
                    public void onSuccess(Response<List<Uiname>> uinameResponse) {
                        if (uinameResponse.isSuccessful()) {
                            List<Uiname> uinameList = uinameResponse.body();
                            resultLiveData.postValue(uinameList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "getUinames onError: ", e);
                        resultLiveData.postValue(null);
                    }
                });
    }

    public LiveData<List<Uiname>> getResultLiveData() {
        return resultLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
