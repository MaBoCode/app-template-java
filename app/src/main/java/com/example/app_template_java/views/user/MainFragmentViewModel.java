package com.example.app_template_java.views.user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.example.app_template_java.core.user.User;
import com.example.app_template_java.core.user.UserRepository;
import com.example.app_template_java.injects.base.BaseViewModel;
import com.example.app_template_java.utils.Logs;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class MainFragmentViewModel extends BaseViewModel {

    @Inject
    protected UserRepository userRepository;

    protected MutableLiveData<List<User>> _usersLiveData = new MutableLiveData<>();
    public LiveData<List<User>> usersLiveData = _usersLiveData;

    @Inject
    public MainFragmentViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;
    }

    public void getUsers() {
        userRepository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnSubscribe(disposable -> _loadingLiveData.postValue(LoadingStatus.LOADING))
                .doFinally(() -> _loadingLiveData.postValue(LoadingStatus.NOT_LOADING))
                .subscribe(users -> _usersLiveData.postValue(users), new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        Logs.error(this, throwable.getMessage());
                    }
                });
    }

}
