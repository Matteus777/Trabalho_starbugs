package dao;


import model.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 181710180
 */
public class CategoriaDAO {

    public static boolean inserir(Categoria categoria) {
        String sql = "INSERT INTO categorias "
                + " ( nome ) VALUES "
                + " ( '" + categoria.getNome() + "' );";
        return Conexao.executar(sql);
    }

    public static List<Categoria> getCategorias() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categorias ORDER BY nome";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    Categoria cat = new Categoria();
                    cat.setCodigo(rs.getInt(1));
                    cat.setNome(rs.getString(2));
                    lista.add(cat);

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }

        return lista;
    }
public static boolean editar(Categoria categoria){
        String sql = "UPDATE categorias SET "
            + " nome =  '" + categoria.getNome() + "' "
            + " WHERE codigo = " + categoria.getCodigo();
        return Conexao.executar(sql);
    }
    
      public static boolean excluir(Categoria categoria){
        String sql = "DELETE FROM  categorias  "
            + " WHERE codigo = " + categoria.getCodigo();
        return Conexao.executar(sql);


}
}