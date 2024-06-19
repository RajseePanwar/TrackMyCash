package com.example.trackmycash.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackmycash.R;
import com.example.trackmycash.databinding.RowAccountBinding;
import com.example.trackmycash.models.Account;

import java.util.ArrayList;

public class AccountsAdapter extends RecyclerView.Adapter<AccountsAdapter.AccountsViewHolder> {
    
    Context context;
    ArrayList<Account> accountArrayList;

    public interface AccountsCLickListener {
        void onAccountSelected(Account account);
    }

    AccountsCLickListener accountsCLickListener;

    public AccountsAdapter(Context context, ArrayList<Account> accountArrayList, AccountsCLickListener accountsCLickListener) {
        this.context = context;
        this.accountArrayList = accountArrayList;
        this.accountsCLickListener = accountsCLickListener;
    }

    @NonNull
    @Override
    public AccountsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AccountsViewHolder(LayoutInflater.from(context).inflate(R.layout.row_account, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AccountsViewHolder holder, int position) {
        Account account = accountArrayList.get(position);
        holder.binding.accountName.setText(account.getAccountName());
        holder.itemView.setOnClickListener( c-> {
            accountsCLickListener.onAccountSelected(account);
        });
    }

    @Override
    public int getItemCount() {

        return accountArrayList.size();
    }

    public class AccountsViewHolder extends RecyclerView.ViewHolder {

        RowAccountBinding binding;

        public AccountsViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RowAccountBinding.bind(itemView);
        }
    }

}
