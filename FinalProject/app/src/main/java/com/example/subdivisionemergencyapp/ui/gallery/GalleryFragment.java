package com.example.subdivisionemergencyapp.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.subdivisionemergencyapp.MainActivity;
import com.example.subdivisionemergencyapp.R;
import com.example.subdivisionemergencyapp.databinding.FragmentGalleryBinding;


public class GalleryFragment extends Fragment {
  //  private FirebaseUser user;
 //   private DatabaseReference reference;
    private String userID;
    private Button button;
    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.fragment_gallery, container, false);
      Button button = (Button) view.findViewById(R.id.btnlogout);
      button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          //  FirebaseAuth.getInstance().signOut();
          Intent intent = new Intent(getActivity(), MainActivity.class);
          startActivity(intent);
          finish();
        }

        private void finish() {
        }
      });
      return view;
    }
}
/*
        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReferenc`e("Users");
        userID = user.getUid();

        final TextView nametextview = (TextView) view.findViewById(R.id.textname);
        final TextView emailtextview = (TextView) view.findViewById(R.id.textemail);
        final TextView agetextview = (TextView) view.findViewById(R.id.textage);
        final TextView phonetextview = (TextView) view.findViewById(R.id.textphone);
        final TextView addresstextview = (TextView) view.findViewById(R.id.textaddress);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                profile userprofile = snapshot.getValue(profile.class);


                if (userprofile != null){
                    String fullname = userprofile.fullName;
                    String email = userprofile.email;
                    String age = userprofile.age;
                    String phone = userprofile.phone;
                    String address = userprofile.address;

                    nametextview.setText(fullname);
                    emailtextview.setText(email);
                    agetextview.setText(age);
                    phonetextview.setText(phone);
                    addresstextview.setText(address);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Something went wrong try again!", Toast.LENGTH_SHORT).show();
            }
        });
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textaddress;

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;*/
