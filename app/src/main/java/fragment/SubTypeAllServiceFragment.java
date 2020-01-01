package fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.SubtypeallservicefragmentactivityBinding;

import java.util.ArrayList;

import activity.home.SubServiceAllActivity;
import adapter.fragment.AllTypeServiceFragmentAdapter;
import classes.SubTypeAllServiceClass;

public class SubTypeAllServiceFragment extends Fragment {

    SubtypeallservicefragmentactivityBinding binding;
    Activity context;
    ArrayList<SubTypeAllServiceClass> list = new ArrayList<>();
    AllTypeServiceFragmentAdapter adapter;
    SubTypeAllServiceClass subTypeAllServiceClass;

    public SubTypeAllServiceFragment(Context context)
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.subtypeallservicefragmentactivity,container,false);
        setAdapter();
        setData();
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = (SubServiceAllActivity)getActivity();
    }

    private void setAdapter()
    {
        LinearLayoutManager l =new LinearLayoutManager(context);
        binding.rv.setLayoutManager(l);
        adapter = new AllTypeServiceFragmentAdapter(context,list);
        binding.rv.setAdapter(adapter);
    }

    private void setData()
    {
        list.clear();
        subTypeAllServiceClass = new SubTypeAllServiceClass();
        subTypeAllServiceClass.setName("Event Photographer");
        list.add(subTypeAllServiceClass);

        subTypeAllServiceClass = new SubTypeAllServiceClass();
        subTypeAllServiceClass.setName("Make up At home");
        list.add(subTypeAllServiceClass);

        subTypeAllServiceClass = new SubTypeAllServiceClass();
        subTypeAllServiceClass.setName("Party Decoration");
        list.add(subTypeAllServiceClass);
    }



}
