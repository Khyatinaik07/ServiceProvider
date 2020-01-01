package activity.home;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.ActivityHomePageTabBinding;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;

import activity.basic.BaseApp;
import adapter.activity.TabAdapter;

public class HomePageTabActivity extends BaseApp {

    ActivityHomePageTabBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_home_page_tab);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home_page_tab);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(binding.toolbar);
        binding.home.equalNavigationBar.setVerticalFadingEdgeEnabled(true);
        getSupportActionBar().hide();

        binding.home.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.home.equalNavigationBar.setCurrentActiveItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        binding.home.equalNavigationBar.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                binding.home.viewPager.setCurrentItem(position, true);
            }
        });

        final TabAdapter adapter =new TabAdapter(this,getSupportFragmentManager(),binding.home.equalNavigationBar.getChildCount());
        //Log.w("count child", String.valueOf(binding.home.equalNavigationBar.getChildCount()));
        binding.home.viewPager.setAdapter(adapter);

    }

}
