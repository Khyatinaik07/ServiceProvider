package adapter.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.RowbanneractivityBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.myview> {

    Context context;
    ArrayList<Integer> list1;

    public BannerAdapter(Context context, ArrayList<Integer> list1) {
        this.context=context;
        this.list1=list1;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowbanneractivity,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        Picasso.with(context).load(list1.get(position)).into(holder.binding.img);
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class myview extends RecyclerView.ViewHolder{

        RowbanneractivityBinding binding;

        public myview(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
