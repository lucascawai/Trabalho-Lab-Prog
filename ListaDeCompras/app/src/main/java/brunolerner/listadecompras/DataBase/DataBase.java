package brunolerner.listadecompras.DataBase;

/**
 * Created by brunolerner1 on 27/11/16.
 */

import android.database.sqlite.*;
import android.content.Context;


public class DataBase extends SQLiteOpenHelper{

    public DataBase(Context context){
        super(context,"ListaDeCompras", null,1);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(ScriptSQL.getCreateContato());
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion , int newVersion){

    }
}
