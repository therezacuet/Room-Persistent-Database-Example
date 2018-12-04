package com.thereza.roompersistencedbexample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.thereza.roompersistencedbexample.R;
import com.thereza.roompersistencedbexample.data.entity.UserDbModel;
import com.thereza.roompersistencedbexample.listener.ItemClickListener;

import java.util.ArrayList;

/**
 * Created by theReza on 7/4/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;

    private ItemClickListener itemClickListener;
    private ArrayList<UserDbModel> arrayList;

    public UserAdapter(Context context, ArrayList<UserDbModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageButton btnDelete;
        private TextView tvName, tvPhoneEmail, tvAddress;

        public ViewHolder(View view) {
            super(view);

            tvName = (TextView) view.findViewById(R.id.tvName);
            tvPhoneEmail = (TextView) view.findViewById(R.id.tvPhoneEmail);
            tvAddress = (TextView) view.findViewById(R.id.tvAddress);
            btnDelete = (ImageButton) view.findViewById(R.id.btnDelete);

            btnDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(getAdapterPosition(), view);
            }
        }
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tvName.setText(arrayList.get(position).getName());
        holder.tvPhoneEmail.setText(arrayList.get(position).getPhone() + " | "+arrayList.get(position).getEmail());
        holder.tvAddress.setText(arrayList.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}