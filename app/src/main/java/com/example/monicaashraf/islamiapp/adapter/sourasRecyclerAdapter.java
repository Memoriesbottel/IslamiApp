package com.example.monicaashraf.islamiapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.monicaashraf.islamiapp.R;


public class sourasRecyclerAdapter extends RecyclerView.Adapter<sourasRecyclerAdapter.ViewHolder> {

    String names[];

    public sourasRecyclerAdapter(String[] names) {
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_soura,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       final String name=names[position];
       holder.name.setText(name);

       if(itemOnClickListener!=null)//ba3tli callBack
       {
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   //hannady 3la el callBack
                   itemOnClickListener.OnItemClick(position,name);
               }
           });


       }
    }

    @Override
    public int getItemCount() {
        if(names==null) return 0;
        return names.length;
    }

    public void setItemOnClickListener(sourasRecyclerAdapter.itemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    itemOnClickListener itemOnClickListener;
    public interface itemOnClickListener{
        void OnItemClick(int position , String name);

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
        }
    }
}
