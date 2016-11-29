package brunolerner.listadecompras.DataBase;

/**
 * Created by brunolerner1 on 27/11/16.
 */
public class ScriptSQL {

    public static String getCreateContato(){

        StringBuilder sqlbuilder = new StringBuilder();

        sqlbuilder.append("create table categorias( ");
        sqlbuilder.append("	_id integer not null, ");
        sqlbuilder.append("	nome varchar(100), ");
        sqlbuilder.append("	constraint categorias_id primary key (_id)); ");

        sqlbuilder.append("create table produtos( ");
        sqlbuilder.append("	_id integer not null, ");
        sqlbuilder.append("	nome varchar(255), ");
        sqlbuilder.append("	categoria_id integer, ");
        sqlbuilder.append("	constraint produtos_categorias foreign key (categoria_id) references categorias (_id), ");
        sqlbuilder.append("	constraint produtos_id primary key (_id)); ");

        sqlbuilder.append("create table compras( ");
        sqlbuilder.append("	_id integer not null, ");
        sqlbuilder.append("	preco float, ");
        sqlbuilder.append("	quantidade integer, ");
        sqlbuilder.append("	mercado varchar(255), ");
        sqlbuilder.append("	data date, ");
        sqlbuilder.append("	produto_id integer, ");
        sqlbuilder.append("	usuario_id integer, ");
        sqlbuilder.append("	constraint compras_id primary key (_id), ");
        sqlbuilder.append("	constraint compras_produtos foreign key (produto_id) references produtos (_id), ");
        sqlbuilder.append("	constraint compras_usuarios foreign key (usuario_id) references usuarios (_id)); ");

        return String.valueOf(sqlbuilder);
    }
}
