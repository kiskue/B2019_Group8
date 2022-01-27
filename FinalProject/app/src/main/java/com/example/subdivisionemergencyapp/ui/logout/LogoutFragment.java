package com.example.subdivisionemergencyapp.ui.logout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.subdivisionemergencyapp.R;
import com.example.subdivisionemergencyapp.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class LogoutFragment extends Fragment{
    private FirebaseUser user;
    private DatabaseReference RootRef;
    private String currentUserID;
    private LogoutViewModel logoutViewModel;
    private FragmentHomeBinding binding;
    SharedPreferences sp;
    private FirebaseAuth mAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logout, container, false);

        TextView startdate = (TextView) view.findViewById(R.id.startdate);
        TextView stopdate = (TextView) view.findViewById(R.id.stopdate);

        //firebase server time value are in this format: 1639463051791
        //you simply, have to get the firebase server timevalue
        //=========================================================================
             mAuth = FirebaseAuth.getInstance();
             currentUserID = mAuth.getCurrentUser().getUid();
             RootRef = FirebaseDatabase.getInstance().getReference();





        RootRef.child("timestart").setValue(ServerValue.TIMESTAMP);
        RootRef.child("timestart").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {



                Long timestamp = (Long) snapshot.getValue();
                String startDate = getTimeDate(timestamp);
                String stopDate = getTimeDate(timestamp);
                //Overwrite text using .setText
                startdate.setText("Start Date: \n"+startDate);
                stopdate.setText("End Date: \n"+stopDate);

                //customized date format
                SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
                Date d1 = null;
                Date d2 = null;
                try {
                    d1 = format.parse(startDate);
                    d2 = format.parse(stopDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long diff = d2.getTime() - d1.getTime();

                //total duration in the respective measurements (e.g. seconds)
                long diffTotalSeconds = diff / 1000;
                long diffTotalMinutes = diff / (60 * 1000);
                long diffTotalHours = diff / (60 * 60 * 1000);

                //breakdown of total duration
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000) % 60;

                TextView secondsduration = (TextView) view.findViewById(R.id.secondsduration);
                TextView minutesduration = (TextView) view.findViewById(R.id.minutesduration);
                TextView hoursduration = (TextView) view.findViewById(R.id.hoursduration);
                TextView timedifference = (TextView) view.findViewById(R.id.timedifference);

                //Overwrite text using .setText
                minutesduration.setText("Total Duration in Minutes: \n" +diffTotalMinutes + " minutes");
                secondsduration.setText("Total Duration in Seconds: \n" +diffTotalSeconds + " seconds");
                hoursduration.setText("Total Duration in Hours: \n" +diffTotalHours + " hours");

                timedifference.setText("Total Duration: \n"+diffHours+" hours, "+diffMinutes+" minutes, "+diffSeconds+" seconds.");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        return view;
    }


    //converter
    public static String getTimeDate(long timestart) {
        try {
            Date netDate = (new Date(timestart));
            SimpleDateFormat sfd = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss", Locale.getDefault());
            return sfd.format(netDate);
        } catch (Exception e) {
            return "date";
        }



    }
}