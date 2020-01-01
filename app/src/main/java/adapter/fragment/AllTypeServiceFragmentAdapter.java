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
import com.example.onlineserviceportal.databinding.RowsubtypeallfragmentBinding;

import java.util.ArrayList;

import activity.home.PrefferedServiceActivity;
import classes.SubTypeAllServiceClass;

public class AllTypeServiceFragmentAdapter extends RecyclerView.Adapter<AllTypeServiceFragmentAdapter.myview> {

    Context context;
    ArrayList<SubTypeAllServiceClass> list;

    public AllTypeServiceFragmentAdapter(Context activity, ArrayList<SubTypeAllServiceClass> list) {
        this.context=activity;
        this.list=list;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowsubtypeallfragment,parent,false);
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

    public class myview extends RecyclerView.ViewHolder implements View.OnClickListener{

        RowsubtypeallfragmentBinding binding;

        public myview(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(context, PrefferedServiceActivity.class);
            i.putExtra("name",binding.txt.getText());
            context.startActivity(i);
        }
    }

}
