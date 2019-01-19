package com.paulojuniore.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        // Intenção explicíta, quando é passado uma atividade específica de destino.
        // Intent intent = new Intent(this, ReceiveMessageActivity.class);
        // intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);

        /* Intenção implícita, já que o programador informa o tipo de ação que deseja executar e o Android mostra uma caixa de diálogo seletora
        com as atividades que podem realizar aquela tarefa. */
        Intent intent = new Intent(Intent.ACTION_SEND); // atividade de ação que aceita textos ou imagens.
        intent.setType("text/plain"); // para manipular dados com o tipo MIME.
        intent.putExtra(Intent.EXTRA_TEXT, messageText); // especifica o corpo da mensagem.
        intent.putExtra(Intent.EXTRA_SUBJECT, "Dúvida"); // especifica o assunto da mensagem, caso o app use essa info.

        // Usando createChooser para evitar que uma atividade padrão seja escolhida.
        String choserTitle = getString(R.string.choser);
        Intent chosenIntent = Intent.createChooser(intent, choserTitle); // Permite escolher uma atividade específica a cada vez que selecionar o botão.
        startActivity(chosenIntent);
    }

}
