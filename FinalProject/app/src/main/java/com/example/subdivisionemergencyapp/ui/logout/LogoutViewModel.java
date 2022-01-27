package com.example.subdivisionemergencyapp.ui.logout;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LogoutViewModel extends ViewModel{
        private MutableLiveData<String> mText;

        public LogoutViewModel() {

        }

        public LiveData<String> getText() {
            return mText;
        }
}