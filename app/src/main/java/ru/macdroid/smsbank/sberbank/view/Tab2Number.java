package ru.macdroid.smsbank.sberbank.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;
import ru.macdroid.smsbank.R;

public class Tab2Number  extends Fragment implements View.OnClickListener {

    EditText number;
    Button btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.sber_money_transfer_tab2_number, container, false);

        number = (EditText) rootView.findViewById(R.id.number);
        btn = (Button) rootView.findViewById(R.id.btn);

        btn.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:

                String numberToTransfer = number.getText().toString();

                Intent intent = new Intent(getActivity(), MoneyTransferNumber.class);

                intent.putExtra("numberToTransfer", numberToTransfer);

                startActivity(intent);

                break;
        }
    }
}
