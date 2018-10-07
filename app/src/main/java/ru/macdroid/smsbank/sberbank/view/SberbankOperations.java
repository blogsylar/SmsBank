package ru.macdroid.smsbank.sberbank.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


import ru.macdroid.smsbank.R;

public class SberbankOperations extends AppCompatActivity implements View.OnClickListener {

    Button moneyTransfer, infoCard, balance, spasibo, paidPhone, cardOperations;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sberbank_operations);

        initUI();
        initObjects();
    }


    private void initUI() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Выберите операцию");
        setSupportActionBar(toolbar);

        moneyTransfer = findViewById(R.id.moneyTransfer);
        moneyTransfer.setOnClickListener(this);

        infoCard = findViewById(R.id.infoCard);
        infoCard.setOnClickListener(this);

        balance = findViewById(R.id.balance);
        balance.setOnClickListener(this);

        spasibo = findViewById(R.id.spasibo);
        spasibo.setOnClickListener(this);

        paidPhone = findViewById(R.id.paidPhone);
        paidPhone.setOnClickListener(this);

        cardOperations = findViewById(R.id.cardOperations);
        cardOperations.setOnClickListener(this);

    }

    private void initObjects() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.moneyTransfer:
                startActivity(new Intent(this, SberMoneyTransferToPerson.class));
                break;
        }

    }
}
