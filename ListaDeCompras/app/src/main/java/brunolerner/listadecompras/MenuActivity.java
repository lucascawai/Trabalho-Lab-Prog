package brunolerner.listadecompras;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import brunolerner.listadecompras.dominio.CompraIniciadaActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    public void compra(View v){
        try{
            Intent intent = new Intent(this, CompraIniciadaActivity.class);
         startActivity(intent);
         }
        catch (Exception e) {
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show();
        }
    }
    }


/*    public void Compra(View view){

        MenuActivity menuActivity = this;
        View container = LayoutInflater.from(this).inflate(R.layout.comprainiciada,null);
        DatePicker datePicker = (DatePicker) container.findViewById(R.id.datePicker);
        EditText mercado = (EditText)container.findViewById(R.id.mercado);

        new AlertDialog.Builder(this)
                .setTitle("Certeza que deseja iniciar sua compra ?")
                .setView(container)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            Toast.makeText(menuActivity,datePicker.getYear()+"-"+datePicker.getMonth()+"-"+datePicker.getDayOfMonth(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(menuActivity, "Adicionado: "+mercado.getText().toString(), Toast.LENGTH_SHORT).show();
                            /Intent intent = new Intent(this, CompraActivity.class);/**
                            intent.putExtra("mercado", mercado.getText().toString());
                            intent.putExtra("date", datePicker.getYear()+"-"+(datePicker.getMonth()+1)+"-"+datePicker.getDayOfMonth());

                            startActivity(intent);
                        }catch (Exception e){
                            Toast.makeText(menuActivity, "Erro", Toast.LENGTH_SHORT).show();
                        }

                    }
                }).show();
    }
*/
