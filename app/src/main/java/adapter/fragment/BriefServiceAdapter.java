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
import com.example.onlineserviceportal.databinding.RowbreifservicelayoutBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import activity.home.SubTypeServiceActivity;
import classes.BreifServiceClass;

public class BriefServiceAdapter extends RecyclerView.Adapter<BriefServiceAdapter.myview> {

    Context context;
    ArrayList<BreifServiceClass> list3;

    public BriefServiceAdapter(Context context, ArrayList<BreifServiceClass> list3) {
        this.context=context;
        this.list3=list3;
    }


    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowbreifservicelayout,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myview holder, int position) {
        Picasso.with(context).load(list3.get(position).getImg()).into(holder.binding.img);
        holder.binding.txt1.setText(list3.get(position).getName());
        holder.binding.txt2.setText(list3.get(position).getDes());
    }

    @Override
    public int getItemCount() {
        return list3.size();
    }

    public class myview extends RecyclerView.ViewHolder implements View.OnClickListener{

        RowbreifservicelayoutBinding binding;

        public myview(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                    Intent i = new Intent(context, SubTypeServiceActivity.class);
                    i.putExtra("name",binding.txt1.getText().toString());
                    context.startActivity(i);
        }
    }

}
