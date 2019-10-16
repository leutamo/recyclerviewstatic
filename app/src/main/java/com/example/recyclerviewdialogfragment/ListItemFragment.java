package com.example.recyclerviewdialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListItemFragment extends DialogFragment {

    RecyclerView recyclerView;
    ArrayList<String> listDatos;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_layout, null);
//        LayoutInflater inflater = getActivity().getLayoutInflater();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        listDatos = new ArrayList<>();
        recyclerView = v.findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarDatos();

        AdapterDatos adapter = new AdapterDatos(listDatos);
        recyclerView.setAdapter(adapter);

        builder.setView(v);
        builder.setMessage("Message!")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Clicked 'Okay'
                    }
                })
                .setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Clicked 'Cancel'
                    }
                });


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
//        builder.setView(inflater.inflate(R.layout.fragment_layout, null))

        return builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout,container);
        listDatos = new ArrayList<>();
        recyclerView = rootView.findViewById(R.id.recycler_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarDatos();

        AdapterDatos adapter = new AdapterDatos(listDatos);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    private void llenarDatos() {

        for (int i= 0; i<50;i++){
            listDatos.add("Dato # " + i + " ");
        }

    }
}
