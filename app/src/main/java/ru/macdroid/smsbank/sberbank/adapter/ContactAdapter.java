package ru.macdroid.smsbank.sberbank.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ru.macdroid.smsbank.R;
import ru.macdroid.smsbank.sberbank.model.ModelContacts;
import ru.macdroid.smsbank.sberbank.view.MoneyTransferNumber;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewholder> {

    LayoutInflater inflater;
    ArrayList<ModelContacts> contacts;
    ModelContacts modelContacts;


    public ContactAdapter(Context context, ArrayList<ModelContacts> contacts) {

        this.inflater = LayoutInflater.from(context);
        this.contacts = contacts;

       // setHasStableIds(true);

    }


    @NonNull
    @Override
    public ContactViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contacts_item, viewGroup, false);

        return new ContactViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ContactViewholder contactViewholder, int position) {

        modelContacts = contacts.get(position);

        contactViewholder.contactName.setText(modelContacts.getName());
        contactViewholder.contactNumber.setText(modelContacts.getNumber());

        contactViewholder.cardContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberToTransfer = contactViewholder.contactNumber.getText().toString();

                Intent intent = new Intent(view.getContext(), MoneyTransferNumber.class);

                intent.putExtra("numberToTransfer", numberToTransfer);

                view.getContext().startActivity(intent);
            }
        });

    }



    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactViewholder extends RecyclerView.ViewHolder {

        TextView contactName, contactNumber;
        CardView cardContact;

        public ContactViewholder(@NonNull View itemView) {
            super(itemView);

            contactName = (TextView)itemView.findViewById(R.id.contactName);
            contactNumber = (TextView)itemView.findViewById(R.id.contactNumber);
            cardContact = (CardView) itemView.findViewById(R.id.cardContact);

        }
    }
}
