package com.application.livrago.ui.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import com.application.livrago.R;

public class ListDeliveryFragment extends Fragment {
    private List<Livreur> livreurList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_delivery,
                container, false);

        // Créez la liste des livreurs

        livreurList = new ArrayList<>();
        livreurList.add(new Livreur("Albert", 26,
                "Moto", "Homme"));
        livreurList.add(new Livreur("Brigitte", 30,
                "Voiture", "Femme"));
        livreurList.add(new Livreur("Charles", 22,
                "Vélo", "Homme"));

        ListView listView = view.findViewById(R.id.delivery_list);
        ArrayAdapter<Livreur> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, livreurList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Livreur selectedLivreur = livreurList.get(position);
                ((MainPayment) getActivity()).navigateToOrderDetails(selectedLivreur);
            }
        });

        return view;
    }
}
