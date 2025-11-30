package com.example.loansystemcalculator;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdminApprovedLoansFragment extends Fragment {

    private RecyclerView recyclerApprovedLoans;
    private ApprovedLoanAdapter adapter;
    private ArrayList<DisplayLoan> loanList;
    private DataBaseHelper db;

    public AdminApprovedLoansFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_admin_approved_loans, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerApprovedLoans = view.findViewById(R.id.recyclerApprovedLoans);
        recyclerApprovedLoans.setLayoutManager(new LinearLayoutManager(getContext()));

        loanList = new ArrayList<>();
        db = new DataBaseHelper(getContext());

        loadApprovedLoans();
    }

    private void loadApprovedLoans() {
        loanList.clear();

        Cursor cursor = db.getApprovedLoans();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String appId = cursor.getString(cursor.getColumnIndexOrThrow("applicationID"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                String loanType = cursor.getString(cursor.getColumnIndexOrThrow("loanType"));
                String amount = cursor.getString(cursor.getColumnIndexOrThrow("loanAmount"));
                String dateApproved = cursor.getString(cursor.getColumnIndexOrThrow("dateApproved"));
                String status = cursor.getString(cursor.getColumnIndexOrThrow("status"));

                loanList.add(new DisplayLoan(appId, email, loanType, amount, dateApproved, status));
            }
            cursor.close();
        }
        adapter = new ApprovedLoanAdapter(getContext(), loanList);
        recyclerApprovedLoans.setAdapter(adapter);
    }
}
