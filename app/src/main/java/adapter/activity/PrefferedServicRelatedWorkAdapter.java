package adapter.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlineserviceportal.R;
import com.example.onlineserviceportal.databinding.RowrelatedworkBinding;
import com.mostafaaryan.transitionalimageview.model.TransitionalImage;

import java.util.ArrayList;

import classes.PrefferedRelatedWorkClass;

public class PrefferedServicRelatedWorkAdapter extends RecyclerView.Adapter<PrefferedServicRelatedWorkAdapter.myview> {

    Context context;
    ArrayList<PrefferedRelatedWorkClass> list2;

    public PrefferedServicRelatedWorkAdapter(Context context, ArrayList<PrefferedRelatedWorkClass> list2) {
        this.context=context;
        this.list2=list2;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowrelatedwork,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {

       // Picasso.with(context).load(list2.get(position).getImg()).into(holder.binding.img);

        TransitionalImage img =new TransitionalImage.Builder()
                .duration(500)
                .image(list2.get(position).getImg())
                .create();
        holder.binding.img.setTransitionalImage(img);


    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class myview extends RecyclerView.ViewHolder{

        RowrelatedworkBinding binding;

        public myview(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
