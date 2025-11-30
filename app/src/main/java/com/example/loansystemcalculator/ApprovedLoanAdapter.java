package com.example.loansystemcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ApprovedLoanAdapter extends RecyclerView.Adapter<ApprovedLoanAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<DisplayLoan> loanList;

    public ApprovedLoanAdapter(Context context, ArrayList<DisplayLoan> loanList) {
        this.context = context;
        this.loanList = loanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_approved_loan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DisplayLoan loan = loanList.get(position);

        holder.txtApplicationID.setText("Application ID: " + loan.getApplicationID());
        holder.txtEmail.setText("Email: " + loan.getEmail());
        holder.txtLoanType.setText("Loan Type: " + loan.getLoanType());
        holder.txtLoanAmount.setText("Amount: ₱" + loan.getLoanAmount());
        holder.txtDateApproved.setText("Approved Date: " + loan.getDateApproved());
        holder.txtStatus.setText("Status: APPROVED");
        holder.txtStatus.setTextColor(context.getColor(R.color.green));
    }

    @Override
    public int getItemCount() {
        return loanList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtApplicationID, txtEmail, txtLoanType, txtLoanAmount, txtDateApproved, txtStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtApplicationID = itemView.findViewById(R.id.txtApplicationID);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtLoanType = itemView.findViewById(R.id.txtLoanType);
            txtLoanAmount = itemView.findViewById(R.id.txtLoanAmount);
            txtDateApproved = itemView.findViewById(R.id.txtDateApproved);
            txtStatus = itemView.findViewById(R.id.txtStatus);
        }
    }
}
