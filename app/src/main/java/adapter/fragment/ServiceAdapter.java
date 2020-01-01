package adapter.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.RowserviceactivityBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import activity.home.SubServiceAllActivity;
import classes.ServiceClass;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.myview>{

    Context context;
    ArrayList<ServiceClass> txtlist2;

    public ServiceAdapter(Context context,ArrayList<ServiceClass> txtlist2) {
        this.context=context;
        this.txtlist2=txtlist2;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowserviceactivity,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myview holder, final int position) {
        Picasso.with(context).load(txtlist2.get(position).getImg()).into(holder.binding.img);
        holder.binding.txt.setText(txtlist2.get(position).getName());

        holder.binding.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SubServiceAllActivity.class);
                i.putExtra("tbcount",position);
                context.startActivity(i);
            }
        });
        holder.binding.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SubServiceAllActivity.class);
                i.putExtra("tbcount",position);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return txtlist2.size();
    }

    public class myview extends RecyclerView.ViewHolder{

        RowserviceactivityBinding binding;

        public myview(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
