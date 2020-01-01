package activity.home;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.ActivitySubTypeServiceBinding;

import java.io.Serializable;
import java.util.ArrayList;

import activity.basic.BaseApp;
import adapter.activity.SubTypeServiceAdapter;
import classes.SubTypeServiceClass;

public class SubTypeServiceActivity extends BaseApp {

    ActivitySubTypeServiceBinding binding;
    ArrayList<SubTypeServiceClass> list = new ArrayList<>();
    SubTypeServiceAdapter adapter;
    SubTypeServiceClass subTypeServiceClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub_type_service);
        setSupportActionBar(binding.toolbar);

        Serializable i = getIntent().getSerializableExtra("name");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        getSupportActionBar().setTitle(i.toString());

        setAdapter();
        setData();
    }

    private void setAdapter()
    {
        LinearLayoutManager l = new LinearLayoutManager(this);
        binding.sub.rv.setLayoutManager(l);
        adapter = new SubTypeServiceAdapter(getApplicationContext(),list);
        binding.sub.rv.setAdapter(adapter);
    }

    public void setData()
    {
        subTypeServiceClass = new SubTypeServiceClass();
        subTypeServiceClass.setImg(R.drawable.photographer);
        subTypeServiceClass.setName("Event Photographer");
        list.add(subTypeServiceClass);

        subTypeServiceClass = new SubTypeServiceClass();
        subTypeServiceClass.setImg(R.drawable.makeup);
        subTypeServiceClass.setName("Make up At home");
        list.add(subTypeServiceClass);

        subTypeServiceClass = new SubTypeServiceClass();
        subTypeServiceClass.setImg(R.drawable.decoration);
        subTypeServiceClass.setName("Party Decoration");
        list.add(subTypeServiceClass);
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
}