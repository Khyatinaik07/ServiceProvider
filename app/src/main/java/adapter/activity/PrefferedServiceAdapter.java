package adapter.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.RowprefferedserviceBinding;

import java.util.ArrayList;

import activity.home.ServicePackageActivity;
import classes.PrefferedServiceClass;

public class PrefferedServiceAdapter extends RecyclerView.Adapter<PrefferedServiceAdapter.myview> {

    Context context;
    ArrayList<PrefferedServiceClass> list;
    String i;

    public PrefferedServiceAdapter(Context context, ArrayList<PrefferedServiceClass> list,String i) {
        this.context=context;
        this.list=list;
        this.i=i;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowprefferedservice,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myview holder, int position) {
        holder.binding.txt.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myview extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        RowprefferedserviceBinding binding;
        public myview(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, ServicePackageActivity.class);
            intent.putExtra("name",binding.txt.getText().toString());
            context.startActivity(intent);
        }
    }
}
