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
import com.example.onlineserviceportal.databinding.RowsubtypeBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import activity.home.PrefferedServiceActivity;
import classes.SubTypeServiceClass;

public class SubTypeServiceAdapter extends RecyclerView.Adapter<SubTypeServiceAdapter.myview> {

    Context context;
    ArrayList<SubTypeServiceClass> txtlist;

    public SubTypeServiceAdapter(Context context, ArrayList<SubTypeServiceClass> txtlist) {
        this.context=context;
        this.txtlist=txtlist;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowsubtype,parent,false);
        return new myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myview holder, int position) {
        Picasso.with(context).load(txtlist.get(position).getImg()).into(holder.binding.img);
        holder.binding.txt.setText(txtlist.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return txtlist.size();
    }

    public class myview extends RecyclerView.ViewHolder implements View.OnClickListener{

        RowsubtypeBinding binding;

        public myview(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(context, PrefferedServiceActivity.class);
            i.putExtra("name",binding.txt.getText().toString());
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }

}
