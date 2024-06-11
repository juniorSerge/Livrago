package com.application.livrago.ui.payment;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.application.livrago.R;

public class MainPayment extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ListDeliveryFragment())
                    .commit();
        }
    }

    public void navigateToOrderDetails(Livreur livreur) {
        OrderDetailsFragment orderDetailsFragment = OrderDetailsFragment.newInstance(livreur);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, orderDetailsFragment)
                .addToBackStack(null)
                .commit();
    }

    public void navigateToPayment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new PaymentFragment())
                .addToBackStack(null)
                .commit();
    }
}
