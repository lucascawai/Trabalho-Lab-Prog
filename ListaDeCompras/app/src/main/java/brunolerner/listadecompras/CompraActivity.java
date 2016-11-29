package brunolerner.listadecompras;


import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import android.database.sqlite.*;
import android.database.*;
import org.json.JSONArray;
import brunolerner.listadecompras.DataBase.DataBase;
import brunolerner.listadecompras.dominio.Entidades.Compras;
import brunolerner.listadecompras.dominio.Entidades.Produtos;
import brunolerner.listadecompras.dominio.RepositorioCompras;
import brunolerner.listadecompras.DataBase.DataBase;
import brunolerner.listadecompras.dominio.RepositorioCompras;

public class CompraActivity extends AppCompatActivity {
    private ArrayList<JSONObject> carrinho_compra;
    TextView soma;
    String mercado;
    String date;


    private DataBase database;
    private SQLiteDatabase conn;
    private ListView lstprodutos;
    private ArrayAdapter<String> adpProdutos;
    private RepositorioCompras repositorioCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        carrinho_compra = new ArrayList<JSONObject>();
        soma = (TextView)findViewById(R.id.soma);
        lstprodutos = (ListView) findViewById(R.id.output);

        try {

            database = new DataBase(this);
            conn = database.getWritableDatabase();

            repositorioCompras = new RepositorioCompras(conn);
            //repositorioCompras.InserirCategorias();
            //repositorioCompras.InserirProdutos();
            Produtos p1,p2,p3,p4,p5;
            p1 = new Produtos(1,"manteiga",1);
            p2 = new Produtos(2,"pipoca",1);
            p3 = new Produtos(3,"chocolate",1);
            p4 = new Produtos(4,"macarrao",1);
            p5 = new Produtos(5,"alface",1);
            repositorioCompras.InserirProdutos(p1);
            repositorioCompras.InserirProdutos(p2);
            repositorioCompras.InserirProdutos(p3);
            repositorioCompras.InserirProdutos(p4);
            repositorioCompras.InserirProdutos(p5);


            adpProdutos = repositorioCompras.buscaCompras(this);
            lstprodutos.setAdapter(adpProdutos);

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão com o banco criada com sucesso");
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }
        catch (SQLException ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro na conexão com o BD " + ex.getMessage());
            dlg.setNeutralButton("OK",null);
            dlg.show();
        }

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                mercado = null;
                date = null;
            } else {
                mercado = extras.getString("mercado");
                date = extras.getString("date");
            }
        } else {
            mercado = (String) savedInstanceState.getSerializable("mercado");
            date = (String) savedInstanceState.getSerializable("date");
        }

        CompraActivity activity = this;
        lstprodutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View container = LayoutInflater.from(activity).inflate(R.layout.descricao,null);
                EditText priceInput = (EditText)container.findViewById(R.id.price);
                EditText quantityInput = (EditText)container.findViewById(R.id.quantity);
                new AlertDialog.Builder(activity)
                        .setTitle("Confirmação de compra")
                        .setView(container)
                        .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                            Compras compra = new Compras();
                                            compra.preco = Float.parseFloat(priceInput.getText().toString());
                                            compra.quantidade = Integer.parseInt(quantityInput.getText().toString());
                                            compra.mercado=mercado;
                                            compra.produto_id= 3;

                                            repositorioCompras.Inserir(compra);
                                            computePrice();
                                            Toast.makeText(activity, "Adicionado", Toast.LENGTH_SHORT).show();
                                        }catch (Exception e){
                                            Toast.makeText(activity, "Erro", Toast.LENGTH_SHORT).show();
                                        }

                                    }
                                }).show();
                    }
                });

    }



    private float computePrice(){
        float sum=0;
        for(JSONObject obj : carrinho_compra){
            try {
                sum += obj.getLong("quantidade") * obj.getLong("preco");
            }catch (JSONException e){}
        }
        soma.setText("Total: R$"+sum);
        return sum;
    }

    public void finishList(View v) {
        Toast.makeText(this, "Finalizado com sucesso", Toast.LENGTH_SHORT).show();
        finish();

    }

    public void addItem(View v){
        EditText quantityEditText = (EditText)findViewById(R.id.quantity);
        EditText priceEditText = (EditText)findViewById(R.id.price);

        float price = Float.parseFloat(priceEditText.getText().toString());
        float quantity = Float.parseFloat(quantityEditText.getText().toString());

        Toast.makeText(this, (price*quantity)+"", Toast.LENGTH_SHORT).show();
    }
}
