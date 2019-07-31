package com.example.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databinding.databinding.ExampleItemBinding;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;

    private onItemClickListener mListener;


    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListner(onItemClickListener listener) {
        mListener = listener;

    }


    public ExampleAdapter(Context mContext, ArrayList<ExampleItem> mExampleList) {
        this.mContext = mContext;
        this.mExampleList = mExampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ExampleItemBinding exampleItemBinding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.example_item, viewGroup, false);
        return new ExampleViewHolder(exampleItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        ExampleItem currentItem = mExampleList.get(i);
        exampleViewHolder.itemBinding.setItem(currentItem);
    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        ExampleItemBinding itemBinding;

        public ExampleViewHolder(@NonNull ExampleItemBinding itemView) {
            super(itemView.getRoot());

            itemBinding = itemView;

            itemView.getRoot()
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mListener != null) {
                                int position = getAdapterPosition();
                                if (position != RecyclerView.NO_POSITION) {
                                    mListener.onItemClick(position);
                                }
                            }
                        }
                    });
        }
    }
}
