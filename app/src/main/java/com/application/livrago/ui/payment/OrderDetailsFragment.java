package com.application.livrago.ui.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.application.livrago.R;
import androidx.fragment.app.Fragment;

public class OrderDetailsFragment extends Fragment {
    private static final String ARG_LIVREUR = "livreur";

    private Livreur livreur;

    public static OrderDetailsFragment newInstance(Livreur livreur) {
        OrderDetailsFragment fragment = new OrderDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_LIVREUR, livreur);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_details,
                container, false);

        if (getArguments() != null) {
            livreur = (Livreur) getArguments().getSerializable(ARG_LIVREUR);
        }

        TextView orderDetailsTextView = view.findViewById(R.id.order_details);
        TextView deliveryPriceTextView = view.findViewById(R.id.delivery_price);

        if (livreur != null) {
            orderDetailsTextView.setText("Nom: " + livreur.getName() + "\nAge: " +
                    livreur.getAge() + " ans\nVéhicule: " + livreur.getVehicle() +
                    "\nGenre: " + livreur.getGender());

            // Simulez une distance pour l'exemple
            double distance = 10.0; // Distance en kilomètres
            double price = calculateDeliveryPrice(distance);
            deliveryPriceTextView.setText("Prix de la livraison : " + price + " FCFA");
        }

        Button paymentButton = view.findViewById(R.id.payment_button);
        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainPayment) getActivity()).navigateToPayment();
            }
        });

        return view;
    }

    private double calculateDeliveryPrice(double distance) {
        double pricePerKm = 100; // Prix de base par kilomètre
        return distance * pricePerKm;
    }
}
