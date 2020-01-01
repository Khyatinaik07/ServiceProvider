package fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.ActivityMyProfileFragmentBinding;

import activity.home.EditProfileActivity;
import activity.home.HomePageTabActivity;

public class MyProfileFragment extends Fragment {

    ActivityMyProfileFragmentBinding binding;
    Activity context;

    public MyProfileFragment(Context context) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        context=(HomePageTabActivity)getActivity();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_my_profile_fragment,container,false);
        click();
        return binding.getRoot();
    }

    private void click()
    {
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, EditProfileActivity.class);
                context.startActivity(i);
            }
        });
    }
}
