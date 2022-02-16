package com.example.subdivisionemergencyapp.ui.dos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.subdivisionemergencyapp.R;
import com.example.subdivisionemergencyapp.databinding.FragmentHomeBinding;


public class DosFragment extends Fragment{

    private DosViewModel logoutViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dos, container, false);
        return view;
    }}



