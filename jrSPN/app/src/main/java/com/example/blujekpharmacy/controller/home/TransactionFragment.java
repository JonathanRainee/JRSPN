package com.example.blujekpharmacy.controller.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.blujekpharmacy.R;
import com.example.blujekpharmacy.adapter.TransAdapter;
import com.example.blujekpharmacy.controller.Login;
import com.example.blujekpharmacy.model.Transaction;
import com.example.blujekpharmacy.model.User;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransactionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransactionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView rvTrans;
    TransAdapter transAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TransactionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TransactionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TransactionFragment newInstance(String param1, String param2) {
        TransactionFragment fragment = new TransactionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getTransDB();
        buildRV();
    }



    @Override
    public void onResume() {
        super.onResume();
        getTransDB();
        buildRV();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction, container, false);
    }

    public void buildRV(){
        rvTrans = getView().findViewById(R.id.rvTrans);
        rvTrans.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        transAdapter = new TransAdapter(Login.transactionList);
        rvTrans.setAdapter(transAdapter);
    }

    public static void getTransDB(){
//        if(Login.transactionList != null){
//            Login.transactionList.clear();
//        }
        Log.d("userID", User.curr.getID()+" "+User.curr.getName());
        Login.transactionList = Transaction.getTrans(User.curr.getID());
        if(Login.transactionList.size() <= 0){
            Log.d("status", "empty");
        }else{
            Log.d("status", "not empty");
        }
    }
}