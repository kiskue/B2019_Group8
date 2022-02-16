package com.example.subdivisionemergencyapp.ui.dos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DosViewModel extends ViewModel{
        private MutableLiveData<String> mText;

        public DosViewModel() {

        }

        public LiveData<String> getText() {
            return mText;
        }
}