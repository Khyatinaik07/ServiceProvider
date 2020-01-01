package fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.ActivityHomePageFragmentBinding;

import java.util.ArrayList;

import activity.home.HomePageTabActivity;
import adapter.fragment.BannerAdapter;
import adapter.fragment.BriefServiceAdapter;
import adapter.fragment.ServiceAdapter;
import classes.BreifServiceClass;
import classes.ServiceClass;

public class HomePageFragment extends Fragment {

    private ActivityHomePageFragmentBinding binding;
    private Activity context;
    ArrayList<Integer> list1 = new ArrayList<>();
    BannerAdapter adapter;

    ArrayList<ServiceClass> list2 = new ArrayList<>();
    ServiceAdapter serviceAdapter;
    ServiceClass serviceClass;

    ArrayList<BreifServiceClass> txt1list3 = new ArrayList<>();
    BriefServiceAdapter briefServiceAdapter;
    BreifServiceClass breifServiceClass;


    public HomePageFragment(Context context)
    {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_home_page_fragment,container,false);
        setList1();
        setAdapter();
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        context = (HomePageTabActivity)getActivity();

        super.onCreate(savedInstanceState);
    }

    private void setAdapter()
    {
        ViewCompat.setNestedScrollingEnabled(binding.homeFragment.rv,false);
        ViewCompat.setNestedScrollingEnabled(binding.homeFragment.rv2,false);
        ViewCompat.setNestedScrollingEnabled(binding.homeFragment.rv3,false);
        LinearLayoutManager l = new LinearLayoutManager(context);
        l.setOrientation(RecyclerView.HORIZONTAL);
        binding.homeFragment.rv.setLayoutManager(l);
        adapter = new BannerAdapter(context,list1);
        binding.homeFragment.rv.setAdapter(adapter);

        //our service
        binding.homeFragment.rv2.setLayoutManager(new GridLayoutManager(context,3));
        serviceAdapter = new ServiceAdapter(context,list2);
        binding.homeFragment.rv2.setAdapter(serviceAdapter);

        //service
        LinearLayoutManager l3 = new LinearLayoutManager(context);
        binding.homeFragment.rv3.setLayoutManager(l3);
        briefServiceAdapter = new BriefServiceAdapter(context,txt1list3);
        binding.homeFragment.rv3.setAdapter(briefServiceAdapter);

    }

    private void setList1()
    {
        list1.clear();
        list2.clear();
        txt1list3.clear();
        list1.add(R.drawable.banne1);
        list1.add(R.drawable.banne2);

        //our service
        serviceClass = new ServiceClass();
        serviceClass.setImg(R.drawable.decor);
        serviceClass.setName("Home Decor");
        list2.add(serviceClass);

        serviceClass = new ServiceClass();
        serviceClass.setImg(R.drawable.ac);
        serviceClass.setName("AC Repair");
        list2.add(serviceClass);

        serviceClass = new ServiceClass();
        serviceClass.setImg(R.drawable.brauty);
        serviceClass.setName("Beauty");
        list2.add(serviceClass);

        serviceClass = new ServiceClass();
        serviceClass.setImg(R.drawable.clining);
        serviceClass.setName("Cleaning");
        list2.add(serviceClass);

        serviceClass = new ServiceClass();
        serviceClass.setImg(R.drawable.event);
        serviceClass.setName("Event");
        list2.add(serviceClass);

        serviceClass = new ServiceClass();
        serviceClass.setImg(R.drawable.yoga);
        serviceClass.setName("Fitness");
        list2.add(serviceClass);

        //service
        breifServiceClass = new BreifServiceClass();
        breifServiceClass.setImg(R.drawable.decor);
        breifServiceClass.setName("Home Decoration Service at Home");
        breifServiceClass.setDes("House Paint | Interior Design | Movers Packers");
        txt1list3.add(breifServiceClass);

        breifServiceClass = new BreifServiceClass();
        breifServiceClass.setImg(R.drawable.ac);
        breifServiceClass.setName("AC Service");
        breifServiceClass.setDes("AC Service | AC installation");
        txt1list3.add(breifServiceClass);

        breifServiceClass = new BreifServiceClass();
        breifServiceClass.setImg(R.drawable.brauty);
        breifServiceClass.setName("Makeup and Beauty Service at home");
        breifServiceClass.setDes("Bridal Makeup | Beautician | Salon");
        txt1list3.add(breifServiceClass);

        breifServiceClass = new BreifServiceClass();
        breifServiceClass.setImg(R.drawable.clining);
        breifServiceClass.setName("Cleaning Services");
        breifServiceClass.setDes("House | Bathroom | Car | Sofa");
        txt1list3.add(breifServiceClass);

        breifServiceClass = new BreifServiceClass();
        breifServiceClass.setImg(R.drawable.event);
        breifServiceClass.setName("Party Decoration Service");
        breifServiceClass.setDes("Party Decoration | Photographer");
        txt1list3.add(breifServiceClass);

        breifServiceClass = new BreifServiceClass();
        breifServiceClass.setImg(R.drawable.yoga);
        breifServiceClass.setName("Fitness and Yoga Trainers at home");
        breifServiceClass.setDes("Fitness Trainer | Yoga Trainer | Dietitian");
        txt1list3.add(breifServiceClass);

    }
}
