package com.example.test.viewmodel;

import android.content.Context;

import com.example.test.BR;
import com.example.test.model.User;
import com.example.test.view.adapter.UserAdapter;

import java.util.ArrayList;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewModel1 extends BaseObservable {
    // baraye meghdar dehi bayad az 'setvalue()' dar thread asli ya 'postvalue()' dar masaln async ha estefade kard
//    private MutableLiveData<String> liveData=new MutableLiveData<>();
    private ArrayList<UserViewModel> arrayList = new ArrayList<>();

    private String name;
    private String LName;

    private Context context;

    public UserViewModel1(User user) {
        this.name = user.getName();
        this.LName = user.getLName();


    }

    public UserViewModel1(Context context) {
        this.context = context;

        //        this.liveData.setValue("Negin");

        //connect to server API
        for (int i = 0; i < 5; i++) {
            User user = new User("number: " + i, "Negin");
            UserViewModel userViewModel = new UserViewModel(user);
            arrayList.add(userViewModel);
        }

    }

    @Bindable
    public String getName() {
        return name;

    }

    @Bindable
    public String getLName() {
        return LName;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setLName(String lName) {
        this.LName = lName;
        notifyPropertyChanged(BR.lName);
    }

    @Bindable
    public ArrayList<UserViewModel> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<UserViewModel> arrayList) {
        this.arrayList = arrayList;
        notifyPropertyChanged(BR.arrayList);
    }

    @BindingAdapter("bind:recyclerUser")
    public static void recyclerBinder(final RecyclerView recyclerView, ArrayList<UserViewModel> arrayListMutableLiveData) {


                UserAdapter userAdapter = new UserAdapter(arrayListMutableLiveData);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
                recyclerView.setAdapter(userAdapter);



    }
}
