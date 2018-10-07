package ru.macdroid.smsbank.sberbank.view;

import android.Manifest;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;

import ru.macdroid.smsbank.R;
import ru.macdroid.smsbank.sberbank.adapter.ContactAdapter;
import ru.macdroid.smsbank.sberbank.model.ModelContacts;

public class Tab1Contacts extends Fragment {

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    private View v;
    private RecyclerView recyclerContacts;
    private ContactAdapter contactAdapter;
    View rootView;
    LinearLayoutManager linearLayoutManager;
    RecyclerView.LayoutManager layoutManager;


    public Tab1Contacts() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.sber_money_transfer_tab1_contacts, container, false);
        recyclerContacts = (RecyclerView) rootView.findViewById(R.id.recyclerContacts);
        showContacts();
        return rootView;
    }



    private void showContacts() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && getContext().checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);

        } else {
            adapter();
        }
    }

    private void adapter() {
        linearLayoutManager = new LinearLayoutManager(getContext());
        layoutManager = linearLayoutManager;
        recyclerContacts.setLayoutManager(linearLayoutManager);
        contactAdapter = new ContactAdapter(getContext(), getContacts());
        recyclerContacts.setAdapter(contactAdapter);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                showContacts();
            } else {
                Toast.makeText(getContext(), "Until you grant the permission, we canot display the names", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private ArrayList<ModelContacts> getContacts() {
        ArrayList<ModelContacts> sberbankArrayContacts= new ArrayList<>();
        Cursor cursor = getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");
        if ( cursor != null && cursor.moveToFirst() ){
            do {
                sberbankArrayContacts.add(new ModelContacts(
                        cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                        cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                ));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return sberbankArrayContacts;
    }

}