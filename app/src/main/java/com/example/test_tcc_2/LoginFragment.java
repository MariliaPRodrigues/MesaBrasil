package com.example.test_tcc_2;


import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView errorTextView;
    private ImageView passwordToggleIcon;

    private boolean isPasswordVisible = false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        usernameEditText = view.findViewById(R.id.usernameEditText);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        loginButton = view.findViewById(R.id.loginButton);
        errorTextView = view.findViewById(R.id.errorTextView);
        passwordToggleIcon = view.findViewById(R.id.passwordToggleIcon);
        passwordToggleIcon.setOnClickListener(v -> togglePasswordVisibility());

        Button novoUsuarioButton = view.findViewById(R.id.newUserButton);
        novoUsuarioButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NovoUsuarioActivity.class);
            startActivity(intent);
        });

        View forgotPasswordTextView = view.findViewById(R.id.forgotPasswordTextView);
        forgotPasswordTextView.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), RecuperarSenhaActivity.class);
            startActivity(intent);
        });

        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                errorTextView.setText("Campos obrigatórios.");
            } else if (username.equals("teste@gmail.com") && password.equals("1")) {
                // Credenciais iniciar HomeActivity
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            } else if (username.equals("teste@doador.com") && password.equals("1")) {
                // Credenciais iniciar UsuarioDoador

                Intent intent = new Intent(getActivity(), UsuarioDoadorActivity.class);
                startActivity(intent);
            } else if (username.equals("motorista@motorista") && password.equals("1")) {
                // Credenciais iniciar Motorista
                Intent intent = new Intent(getActivity(), MotoristaActivity.class);
                startActivity(intent);
            } else {
                errorTextView.setText("Email ou Senha Incorreto! Por favor, tente novamente.");
            }
        });

        return view;
    }

    // Mostra ou oculta a senha aqui
    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            passwordToggleIcon.setImageResource(R.drawable.ic_visibility_off);
        } else {
            passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            passwordToggleIcon.setImageResource(R.drawable.ic_visibility);
        }
        isPasswordVisible = !isPasswordVisible;
        passwordEditText.setSelection(passwordEditText.length());
    }
}
