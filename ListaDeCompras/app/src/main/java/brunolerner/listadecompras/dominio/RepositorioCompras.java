package brunolerner.listadecompras.dominio;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.database.*;
import android.database.sqlite.*;

import brunolerner.listadecompras.dominio.Entidades.Compras;
import brunolerner.listadecompras.dominio.Entidades.Produtos;

/**
 * Created by brunolerner1 on 27/11/16.
 */
public class RepositorioCompras {

    private SQLiteDatabase conn;

    public RepositorioCompras (SQLiteDatabase conn)
    {
        this.conn = conn;
    }

    public void InserirCategorias(){
        ContentValues values = new ContentValues();
        values.put("_id", 1);
        values.put("nome", "alimentos");
        conn.insertOrThrow("categorias",null, values);

    }


    public void InserirProdutos(){
        ContentValues values = new ContentValues();
        values.put("_id", 1);
        values.put("nome", "manteiga");
        values.put("categoria_id", 1);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 2);
        values.put("nome", "molho de tomate");
        values.put("categoria_id", 1);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 3);
        values.put("nome", "feijao");
        values.put("categoria_id", 1);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 4);
        values.put("nome", "sabonete");
        values.put("categoria_id", 4);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 5);
        values.put("nome", "amaciante");
        values.put("categoria_id", 5);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 6);
        values.put("nome", "pinga");
        values.put("categoria_id", 2);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 7);
        values.put("nome", "suco");
        values.put("categoria_id", 2);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 8);
        values.put("nome", "pipoca");
        values.put("categoria_id", 3);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 9);
        values.put("nome", "leite");
        values.put("categoria_id", 2);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 10);
        values.put("nome", "acucar");
        values.put("categoria_id", 1);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 11);
        values.put("nome", "shampoo");
        values.put("categoria_id", 4);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 12);
        values.put("nome", "creme dental");
        values.put("categoria_id", 4);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 13);
        values.put("nome", "detergente");
        values.put("categoria_id", 5);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 14);
        values.put("nome", "condicionador");
        values.put("categoria_id", 4);
        conn.insertOrThrow("produtos",null, values);
        values.clear();

        values.put("_id", 15);
        values.put("nome", "oregano");
        values.put("categoria_id", 3);
        conn.insertOrThrow("produtos",null, values);

        System.out.print("Produtos inseridos no banco");
    }

    public void InserirProdutos(Produtos produto){
        ContentValues values = new ContentValues();
        values.put("_id", produto.id);
        values.put("nome", produto.nome);
        values.put("categoria_id",produto.categoria_id);

        conn.insertOrThrow("produtos",null, values);
    }

    public void Inserir(Compras compra){
        ContentValues values = new ContentValues();

        values.put("_id", compra._id);
        values.put("preco", compra.preco);
        values.put("quantidade", compra.quantidade);
        values.put("mercado", compra.mercado);
        values.put("produto_id",compra.produto_id);
        conn.insertOrThrow("compras",null, values);

    }

    public ArrayAdapter<String> buscaCompras(Context context)
    {
        ArrayAdapter<String> adpProdutos = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);

        Cursor cursor = conn.query("produtos", new String[]{"nome"},null, null, null, null,null);

        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();

            do {

                String nome = cursor.getString(1);
                adpProdutos.add(nome);
            } while(cursor.moveToNext());
        }
        return adpProdutos;
    }
}
