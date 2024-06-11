package com.application.livrago.ui.payment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.application.livrago.R;

public class PaymentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment,
                container, false);

        RadioGroup paymentOptions = view.findViewById(R.id.payment_options);
        Button confirmPaymentButton = view.findViewById(R.id.confirm_payment_button);

        confirmPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = paymentOptions.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton selectedRadioButton = view.findViewById(selectedId);
                    String paymentMethod = selectedRadioButton.getText().toString();
                    navigateToPaymentMethod(paymentMethod);
                } else {
                    Toast.makeText(getContext(),
                            "Veuillez sélectionner une méthode de paiement",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void navigateToPaymentMethod(String paymentMethod) {
        Fragment paymentFragment;
        switch (paymentMethod) {
            case "Mobile Money":
                paymentFragment = new MobileMoneyFragment();
                break;
            case "Orange Money":
                paymentFragment = new OrangeMoneyFragment();
                break;
            case "Carte bancaire":
                paymentFragment = new CardPaymentFragment();
                break;
            default:
                throw new IllegalArgumentException("Méthode de paiement non reconnue : " +
                        paymentMethod);
        }

        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, paymentFragment)
                .addToBackStack(null)
                .commit();
    }
}



