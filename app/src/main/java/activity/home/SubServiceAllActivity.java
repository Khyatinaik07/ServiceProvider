package activity.home;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.ActivitySubServiceAllBinding;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;

import activity.basic.BaseApp;
import adapter.activity.AllServiceAdapter;

public class SubServiceAllActivity extends BaseApp {

    ArrayList<String> list = new ArrayList<>();
    ActivitySubServiceAllBinding binding;
    AllServiceAdapter adapter;
    Integer position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub_service_all);
        setSupportActionBar(binding.toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("All Services");

        Serializable i = getIntent().getSerializableExtra("tbcount");
        Log.w("position",String.valueOf(i));
        position = Integer.valueOf(i.toString());

        binding.sub.tabLayout.addTab(binding.sub.tabLayout.newTab().setText("Home Decor"));
        binding.sub.tabLayout.addTab(binding.sub.tabLayout.newTab().setText("AC Repair"));
        binding.sub.tabLayout.addTab(binding.sub.tabLayout.newTab().setText("Beauty"));
        binding.sub.tabLayout.addTab(binding.sub.tabLayout.newTab().setText("Cleaning"));
        binding.sub.tabLayout.addTab(binding.sub.tabLayout.newTab().setText("Event"));
        binding.sub.tabLayout.addTab(binding.sub.tabLayout.newTab().setText("Fitness"));

        binding.sub.tabLayout.setScrollPosition(position,0,true);

        final AllServiceAdapter adapter = new AllServiceAdapter(this,getSupportFragmentManager(),binding.sub.tabLayout.getTabCount());
        binding.sub.viewPager.setAdapter(adapter);
        binding.sub.viewPager.setCurrentItem(position);

        binding.sub.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(binding.sub.tabLayout));


        binding.sub.tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.sub.viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
