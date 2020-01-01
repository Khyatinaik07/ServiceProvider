package activity.home;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.ActivityPrefferedServiceBinding;

import java.io.Serializable;
import java.util.ArrayList;

import activity.basic.BaseApp;
import adapter.activity.PrefferedServicRelatedWorkAdapter;
import adapter.activity.PrefferedServiceAdapter;
import classes.PrefferedRelatedWorkClass;
import classes.PrefferedServiceClass;

public class PrefferedServiceActivity extends BaseApp {

    ActivityPrefferedServiceBinding binding;
    ArrayList<PrefferedServiceClass> list = new ArrayList<>();
    PrefferedServiceClass prefferedServiceClass;
    PrefferedServiceAdapter adapter;
    ArrayList<PrefferedRelatedWorkClass> list2 = new ArrayList<>();
    PrefferedRelatedWorkClass prefferedRelatedWorkClass;
    PrefferedServicRelatedWorkAdapter prefferedServicRelatedWorkAdapter;
    Serializable i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_preffered_service);
        setSupportActionBar(binding.toolbar);

        clearLightStatusBar(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        i = getIntent().getSerializableExtra("name");
        if (i.toString().equalsIgnoreCase("event photographer"))
        {
            binding.img.setImageResource(R.drawable.photographer);
            getSupportActionBar().setTitle(i.toString());

            setEvent();
            setAdapter();
        }
        else if (i.toString().equalsIgnoreCase("make up at home"))
        {
            binding.img.setImageResource(R.drawable.makeup);
            getSupportActionBar().setTitle(i.toString());

            setAdapter();
            getImage();
        }
        else if (i.toString().equalsIgnoreCase("party decoration"))
        {
            binding.img.setImageResource(R.drawable.decoration);
            getSupportActionBar().setTitle(i.toString());

            setParty();
            setAdapter();
        }
    }

    private void clearLightStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = activity.getWindow().getDecorView().getSystemUiVisibility(); // get current flag
            flags = flags ^ View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR; // use XOR here for remove LIGHT_STATUS_BAR from flags
            activity.getWindow().getDecorView().setSystemUiVisibility(flags);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void setParty()
    {
        prefferedServiceClass = new PrefferedServiceClass();
        prefferedServiceClass.setName("Basic Decoration");
        list.add(prefferedServiceClass);

        prefferedServiceClass = new PrefferedServiceClass();
        prefferedServiceClass.setName("Premium Decoration");
        list.add(prefferedServiceClass);

        prefferedServiceClass = new PrefferedServiceClass();
        prefferedServiceClass.setName("Only Game Coordinator");
        list.add(prefferedServiceClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.decor);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.decor);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.decor);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.decor);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.decor);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.decor);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.decor);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.decor);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.decor);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.decor);
        list2.add(prefferedRelatedWorkClass);

    }

    private void setEvent()
    {
        prefferedServiceClass = new PrefferedServiceClass();
        prefferedServiceClass.setName("Birthday Party");
        list.add(prefferedServiceClass);
        prefferedServiceClass = new PrefferedServiceClass();
        prefferedServiceClass.setName("Anniversary Party");
        list.add(prefferedServiceClass);
        prefferedServiceClass = new PrefferedServiceClass();
        prefferedServiceClass.setName("House Party");
        list.add(prefferedServiceClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.event);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.event);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.event);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.event);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.event);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.event);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.event);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.event);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.event);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.event);
        list2.add(prefferedRelatedWorkClass);

    }

    private void getImage()
    {
        prefferedServiceClass = new PrefferedServiceClass();
        prefferedServiceClass.setName("Makeup And Hairstyle both");
        list.add(prefferedServiceClass);

        prefferedServiceClass = new PrefferedServiceClass();
        prefferedServiceClass.setName("Only Makeup");
        list.add(prefferedServiceClass);

        prefferedServiceClass = new PrefferedServiceClass();
        prefferedServiceClass.setName("Only Hairstyle");
        list.add(prefferedServiceClass);


        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.brauty);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.brauty);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.brauty);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.brauty);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.brauty);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.brauty);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.brauty);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.brauty);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.brauty);
        list2.add(prefferedRelatedWorkClass);

        prefferedRelatedWorkClass = new PrefferedRelatedWorkClass();
        prefferedRelatedWorkClass.setImg(R.drawable.brauty);
        list2.add(prefferedRelatedWorkClass);
    }

    private void setAdapter()
    {
        LinearLayoutManager l = new LinearLayoutManager(this);
        l.setOrientation(RecyclerView.HORIZONTAL);
        binding.prefer.imgrv.setLayoutManager(l);
        prefferedServicRelatedWorkAdapter = new PrefferedServicRelatedWorkAdapter(this,list2);
        binding.prefer.imgrv.setAdapter(prefferedServicRelatedWorkAdapter);

        LinearLayoutManager l2 = new LinearLayoutManager(this);
        binding.prefer.rv.setLayoutManager(l2);
        adapter = new PrefferedServiceAdapter(this,list,i.toString());
        binding.prefer.rv.setAdapter(adapter);
    }
}
