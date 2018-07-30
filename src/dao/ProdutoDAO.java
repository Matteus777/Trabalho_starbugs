package dao;


import model.Produto;
import model.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
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
public class ProdutoDAO {
    public static List<Produto> getProdutos(){    
          List<Produto> lista = new ArrayList<>();
          String sql = " SELECT p.codigo, p.nome, p.lote, " 
                  + " DATE_FORMAT(p.validade'%d'),DATE_FORMAT(p.validade'%m'),DATE_FORMAT(p.validade'%Y') p.quantidade "
                  +"DATE_FORMAT(p.fabricacao'%d'),DATE_FORMAT(p.fabricacao'%m'),DATE_FORMAT(p.fabricacao'%Y') c.codigo, c.nome"
                  + " FROM produtos p "
                  + " INNER JOIN categorias c ON p.codCategoria = c.codigo "
                  + " ORDER BY p.nome";
          ResultSet rs = Conexao.consultar(sql);
          
          if (rs != null) {
              try{
                  while (rs.next()){
                      Produto prod = new Produto();
                      prod.setCodigo(rs.getInt(1));
                      prod.setNome(rs .getString(2));
                      prod.setLote(rs .getString(3));
                      int dia =(rs.getInt(4));
                      int mes =(rs.getInt(5));      
                      int ano =(rs.getInt(6));
                      Calendar data = Calendar.getInstance();
                      data.set(ano, mes, dia);
                      prod.setValidade(data);
                      prod.setQuantidade(rs.getInt(7));
                      
                     
                     dia = (rs.getInt(8));
                      mes = (rs.getInt(9));
                      ano = (rs.getInt(10));
                      data.set(ano, mes, dia);
                       prod.setFabricacao(data);
                      Categoria cat = new Categoria();
                      cat.setCodigo(rs .getInt(8));
                      cat.setNome(rs .getString(9));
                      
                      
                      prod.setCategoria(cat);
                      
                      lista.add(prod);
                  
              }
           }catch(Exception e){
                  JOptionPane.showMessageDialog(null, e.toString());
           }
              
         }
          
          
          return lista;
      }

 
    
    
    
    
    
    
    
    
    
    public static boolean excluir(Produto produto){
            String sql = "DELETE FROM produtos "
            + " WHERE  codigo = " + produto.getCodigo();
            return Conexao.executar(sql);
            
        }
    
    
    
    
    
    
    
    
    
    
    
    public static boolean editar (Produto produto){
       String sql = "UPDATE produtos SET "
            + "nome =      '" + produto.getNome() +      "' ," 
            + "lote =  '" +  produto.getLote()+  "' ," 
            + "validade =      '" +  produto.getValidade()+   "' ,  " 
            + "quantidade =  " +   produto.getQuantidade()+ ",    "
            +"codCategoria = "+produto.getCategoria().getCodigo()+","
            +"fabricacao= '"+produto.getFabricacao()+"'";
        return Conexao.executar(sql);
 }
    
    
    
    
    public static boolean inserir(Produto produto){
        String sql = "INSERT INTO produtos "
            + " ( nome, lote, validade, quantidade, codCategoria, fabricacao) VALUES "
            + " ( "
            + " '" + produto.getNome()          + "' , " 
            + " '" +  produto.getLote()           + "' , " 
            + " '" +produto.getValidade()              + "'  "
            + "  " +produto.getQuantidade()+","
            +"   "+produto.getCategoria().getCodigo()+" ,"
                +"'"+produto.getFabricacao()+"'"
                + " );";
        return Conexao.executar(sql);
    }
}
