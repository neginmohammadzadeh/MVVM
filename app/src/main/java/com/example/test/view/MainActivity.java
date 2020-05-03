package com.example.test.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.test.R;
import com.example.test.databinding.ActivityMainBinding;
import com.example.test.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);


        ActivityMainBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserViewModel userViewModel= new UserViewModel(this);
        //setUser User NAME moarefi shode dar tag variable layout mibashad
        binding.setUser(userViewModel);

        
    }
}
