/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Produto;

/**
 *
 * @author 181710180
 */
public class ListCategorias extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListCategorias
     */
    public ListCategorias() {
        initComponents();
        carregarTabela();
    }
private void carregarTabela(){
    String[]colunas = {"Código","Nome"};
    List<Categoria> listaCategorias = CategoriaDAO.getCategorias();
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.setColumnIdentifiers(colunas);
    for (Categoria cat:listaCategorias){
        Object[] obj= {
        cat.getCodigo(),
        cat.getNome()
    };
    modelo.addRow(obj);
    }
    tabelaCategorias.setModel(modelo);
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCategorias = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Lista de categorias");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 600));

        tabelaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaCategorias.setPreferredSize(new java.awt.Dimension(800, 600));
        jScrollPane1.setViewportView(tabelaCategorias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCategorias;
    // End of variables declaration//GEN-END:variables
}
