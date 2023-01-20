package com.vCare.malviyanagarjaipurswm.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.vCare.malviyanagarjaipurswm.Adapter.ComplainAdapter;
import com.vCare.malviyanagarjaipurswm.Adapter.PaymentHistoryAdapter;
import com.vCare.malviyanagarjaipurswm.R;

import java.util.ArrayList;

public class PaymentHistory extends Fragment {

    PaymentHistoryAdapter adapter;
    RecyclerView paymentHistoryRcy;
    String hType;
    double tAmt;
    TextView tv_tamt;
    SharedPreferences preferences;
    DatabaseReference ref;
    ArrayList<String> dateList = new ArrayList<>();
    ArrayList<String> amtList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.payment_history_page_layout, container, false);
        getDataBase();
        setInit(view);
        showPaymentHistory();
        return view;
    }

    private void setInit(View view){
        paymentHistoryRcy = view.findViewById(R.id.paymentHisRcy);
        tv_tamt = view.findViewById(R.id.att_tamount);
        hType = preferences.getString("houseType","");
    }
    private void getDataBase() {
        preferences = getActivity().getSharedPreferences("CITIZEN APP", Context.MODE_PRIVATE);
        ref = FirebaseDatabase.getInstance(preferences.getString("PATH", "")).getReference();
    }

    private void showPaymentHistory() {

        dateList.clear();
        amtList.clear();
        tAmt = 0;
        dateList.add("Oct-2022");
        dateList.add("Nov-2022");
        dateList.add("Dec-2022");
        if (hType.equals("1")){
            amtList.add("50");
            amtList.add("50");
            amtList.add("50");
        }
        for (int i=0;i<amtList.size();i++){
            tAmt = tAmt + Double.parseDouble(amtList.get(i));
        }
        tv_tamt.setText("₹"+tAmt);
        adapter = new PaymentHistoryAdapter(getActivity(), dateList,amtList);
        paymentHistoryRcy.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
