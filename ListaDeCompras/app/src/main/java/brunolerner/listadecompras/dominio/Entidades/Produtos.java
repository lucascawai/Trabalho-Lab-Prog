package brunolerner.listadecompras.dominio.Entidades;

/**
 * Created by brunolerner1 on 27/11/16.
 */
public class Produtos {

    public long id;
    public String nome;
    public long categoria_id ;

    public Produtos(long id,String nome, long categoria_id){
        this.id = id;
        this.nome = nome;
        this.categoria_id = categoria_id;
    }
}
