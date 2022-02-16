package com.example.subdivisionemergencyapp.ui.hotline;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.subdivisionemergencyapp.LoginRegister;
import com.example.subdivisionemergencyapp.R;

public class HotlineFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.fragment_hotline, container, false);
      Button button = (Button) view.findViewById(R.id.btnlogout);
      button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent(getActivity(), LoginRegister.class);
          startActivity(intent);
          finish();
        }
        private void finish() {
        }
      });
      return view;
    }
}
