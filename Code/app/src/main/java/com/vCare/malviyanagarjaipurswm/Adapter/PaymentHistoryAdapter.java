package com.vCare.malviyanagarjaipurswm.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.vCare.malviyanagarjaipurswm.Model.ComplainModel;
import com.vCare.malviyanagarjaipurswm.R;

import java.util.ArrayList;

public class PaymentHistoryAdapter extends RecyclerView.Adapter<PaymentHistoryAdapter.ViewHolder> {

    Context context;
    ArrayList<String> dateList = new ArrayList<>();
    ArrayList<String> amtList = new ArrayList<>();

    public PaymentHistoryAdapter(FragmentActivity activity, ArrayList<String> dateList, ArrayList<String> amtList) {
        this.amtList = amtList;
        this.dateList = dateList;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.history_rcy_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.att_date.setText(dateList.get(position));
        holder.att_amt.setText("₹"+amtList.get(position));

    }

    @Override
    public int getItemCount() {
        return amtList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView att_date;
        private final TextView att_amt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            att_date = itemView.findViewById(R.id.att_date);
            att_amt = itemView.findViewById(R.id.att_amount);

        }
    }
}
