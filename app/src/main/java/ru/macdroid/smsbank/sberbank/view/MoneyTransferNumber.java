package ru.macdroid.smsbank.sberbank.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.macdroid.smsbank.Constants;
import ru.macdroid.smsbank.R;

public class MoneyTransferNumber extends AppCompatActivity implements View.OnClickListener {

    private TextView number, cash, message;
    private Button btn;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_transfer);

        phoneNumber = getIntent().getExtras().getString("numberToTransfer").replace("-", "").replace("+", "");

        number = (TextView) findViewById(R.id.number);
        cash = (EditText) findViewById(R.id.cash);
        message = (EditText) findViewById(R.id.message);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

        number.setText(phoneNumber);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:

                String sberNumber = "smsto: " + Constants.sberNumber;
                String money = cash.getText().toString();
                //String messageInSms = message.getText().toString();
                String messageText = "ПЕРЕВОД " + phoneNumber + " " + money;

                Intent sms = new Intent(Intent.ACTION_SENDTO, Uri.parse(sberNumber));
                    sms.putExtra("sms_body", messageText);
                    startActivity(sms);

                break;
        }
    }
}
