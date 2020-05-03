package com.example.test.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.test.R;
import com.example.test.databinding.ActivityListBinding;
import com.example.test.viewmodel.UserViewModel;
import com.example.test.viewmodel.UserViewModel1;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityListBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_list);

        UserViewModel1 userViewModel= new UserViewModel1(this);
        //setUser User NAME moarefi shode dar tag variable layout mibashad
        binding.setUser(userViewModel);
    }
}
