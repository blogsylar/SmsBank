package ru.macdroid.smsbank;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.macdroid.smsbank.sberbank.view.SberbankOperations;


public class BanksListAdapter  extends RecyclerView.Adapter<BanksListAdapter.BanksViewHolder> {

    ArrayList<BanksListModel> banksListArray;
    BanksListModel banksListModel;
    LayoutInflater inflater;
    String bankId;


    public static final String TAG = "happy";

    public BanksListAdapter(Context context, ArrayList<BanksListModel> banksListArray) {

        this.banksListArray = banksListArray;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public BanksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.banks_list_adapter, viewGroup, false);
        return new BanksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BanksViewHolder banksViewHolder, final int position) {

        banksListModel = banksListArray.get(position);

        banksViewHolder.banksListBankName.setText(banksListModel.getBankName());
        banksViewHolder.banksId.setText(banksListModel.getBankId());
        banksViewHolder.banksListLogo.setImageResource(banksListModel.getBankPhotoId());

        banksViewHolder.cardBanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bankId = banksViewHolder.banksId.getText().toString();

                if (bankId == Constants.sberbankID) {
                    view.getContext().startActivity(new Intent(view.getContext(), SberbankOperations.class));
                }

                else if (bankId == Constants.alfabankID) {
                    Log.d(TAG, "alfabankID will be there");
                }

                else if (bankId == Constants.rusStandartID) {
                    Log.d(TAG, "Russkiy standart will be there");
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return banksListArray.size();
    }


    public class BanksViewHolder extends RecyclerView.ViewHolder {

        TextView banksListBankName, banksId;
        ImageView banksListLogo;
        CardView cardBanks;

        public BanksViewHolder(@NonNull View itemView) {
            super(itemView);

            banksListBankName = (TextView) itemView.findViewById(R.id.banksListBankName);
            banksId = (TextView) itemView.findViewById(R.id.banksId);
            banksListLogo = (ImageView) itemView.findViewById(R.id.banksListLogo);
            cardBanks = (CardView) itemView.findViewById(R.id.cardBanks);
        }

    }

}
