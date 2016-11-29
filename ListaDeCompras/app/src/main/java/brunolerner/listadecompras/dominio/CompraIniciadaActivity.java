package brunolerner.listadecompras.dominio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import brunolerner.listadecompras.CompraActivity;
import brunolerner.listadecompras.R;

public class CompraIniciadaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comprainiciada_activity);
    }

    public void compra2(View v) {
        try {
            Intent intent = new Intent(this, CompraActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show();
        }
    }
}
