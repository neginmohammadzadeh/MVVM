package com.example.test.viewmodel;

import android.content.Context;
import android.widget.LinearLayout;

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

//baseobservable az class haye databinding mibashad
public class UserViewModel extends BaseObservable {
    // baraye meghdar dehi bayad az 'setvalue()' dar thread asli ya 'postvalue()' dar masaln async ha estefade kard
//    private MutableLiveData<String> liveData=new MutableLiveData<>();
    private MutableLiveData<ArrayList<UserViewModel>> liveData = new MutableLiveData<>();
    ArrayList<UserViewModel> userViewModelArrayList = new ArrayList<>();
    private String name;
    private String LName;

    private Context context;

    public UserViewModel(User user) {
        this.name = user.getName();
        this.LName = user.getLName();


    }

    public UserViewModel(Context context) {
        this.context = context;

        //        this.liveData.setValue("Negin");

        //connect to server API
        for (int i = 0; i < 5; i++) {
            User user = new User("number: " + i, "Negin");
            UserViewModel userViewModel = new UserViewModel(user);
            userViewModelArrayList.add(userViewModel);
        }
        liveData.setValue(userViewModelArrayList);
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


    public MutableLiveData<ArrayList<UserViewModel>> getLiveData() {
        return liveData;
    }

    public ArrayList<UserViewModel> getUserViewModelArrayList() {
        return userViewModelArrayList;
    }

    @BindingAdapter("bind:recyclerUser")
    public static void recyclerBinder(final RecyclerView recyclerView, MutableLiveData<ArrayList<UserViewModel>> arrayListMutableLiveData) {

        arrayListMutableLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<ArrayList<UserViewModel>>() {
            @Override
            public void onChanged(ArrayList<UserViewModel> arrayList) {
                UserAdapter userAdapter = new UserAdapter(arrayList);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
                recyclerView.setAdapter(userAdapter);
            }
        });

    }
}
