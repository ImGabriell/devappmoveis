package br.com.up.projetosexta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity
{

    private TextInputLayout inputLayoutNum;
    private TextInputLayout inputLayoutMsg;

    private TextInputEditText inputEditNum;
    private TextInputEditText inputEditMsg;

    private Button botaoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayoutNum = findViewById(R.id.input_layout_num);
        inputLayoutMsg = findViewById(R.id.input_layout_msg);

        inputEditNum = findViewById(R.id.input_text_num);
        inputEditMsg = findViewById(R.id.input_text_msg);

        botaoEnviar = findViewById(R.id.button);
        botaoEnviar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){openLink();}
        });
    }

        private void openLink()
            {
                String mensagem = inputEditMsg.getText().toString();
                String telefone = inputEditNum.getText().toString();


                Uri webpage = Uri.parse("https://wa.me/" + telefone + "?text=" + mensagem);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                startActivity(webIntent);
            }
};

