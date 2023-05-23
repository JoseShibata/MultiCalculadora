package com.example.calculadorav2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        // Cria o AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Define o layout do AlertDialog
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_modalarea, null);
        FrameLayout container = view.findViewById(R.id.container);

        // Cria a Intent para a Activity que será adicionada ao AlertDialog
        Intent intent = new Intent(getActivity(), TesteFragment.class);

        // Adiciona a Activity ao FrameLayout
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(container.getId(), TesteFragment.newInstance(null, null))
                .commit();

        // Define o layout do AlertDialog
        builder.setView(view);

        // Cria e retorna o AlertDialog
        return builder.create();
    }
}

