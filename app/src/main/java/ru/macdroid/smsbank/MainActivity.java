package ru.macdroid.smsbank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView banksList;
    ArrayList<BanksListModel> banksListArray;
    BanksListAdapter banksListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Выберите банк");
        setSupportActionBar(toolbar);

        //startActivity(new Intent(this, SberMoneyTransferToPerson.class));


        initUI();
        initObjects();
        banksAdapter();
    }

    private void initUI() {
        banksList = (RecyclerView) findViewById(R.id.banksList);
    }

    private void initObjects() {

        banksListArray = new ArrayList<BanksListModel>();

        banksListArray.add(new BanksListModel(getString(R.string.Sberbank), R.drawable.sber_round, Constants.sberbankID));
        banksListArray.add(new BanksListModel(getString(R.string.AlfaBank), R.drawable.alfa_round, Constants.alfabankID));
        banksListArray.add(new BanksListModel(getString(R.string.RusStandart), R.drawable.rst_round, Constants.rusStandartID));

    }

    private void banksAdapter() {
        banksList.setLayoutManager(new LinearLayoutManager(this));
        banksListAdapter = new BanksListAdapter(this, banksListArray);
        banksList.setAdapter(banksListAdapter);
        banksListAdapter.notifyDataSetChanged();
    }

}
