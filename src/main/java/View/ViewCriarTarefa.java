package View;

import DAO.CategoriaDAO;
import DAO.TarefaDAO;
import Exception.CampoVazioException;
import Model.Anexo;
import Model.ManipularImagem;
import Model.Categoria;
import Model.Status;
import Model.Tarefa;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import interfaces.TarefaInterface;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import interfaces.TarefaInterface;
import java.text.DateFormat;
import interfaces.CategoriaInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCriarTarefa extends javax.swing.JFrame {
    BufferedImage imagem;
    static int numerotarefa;
    static int numeracao;
    private boolean entrou = false;
            
    
    public ViewCriarTarefa() {
        initComponents();
        
        CategoriaInterface repositorioCategoria = new CategoriaDAO();

        for (Categoria categoria : repositorioCategoria.buscarTodosCategorias()) {
            this.ComboCategoria.addItem((Categoria) categoria);
        }
   
        //aqui implementei em ordem errada pra ordenar com .sort - tobias
        Status naoConcluido = new Status(2,"Não Concluido");
        Status concluido = new Status(1,"Concluido");
        
        List<Status> listaStatus = new ArrayList();
        
        listaStatus.add(concluido);
        listaStatus.add(naoConcluido);
        
        Collections.sort(listaStatus);   

        for(Status status : listaStatus){
            comboStatus.addItem(status.getNome());
        }
        
        Map<String, String> prioridadeCombo = new HashMap<String, String>();
        
       
        prioridadeCombo.put("Baixa","Baixa");
        prioridadeCombo.put("Media","Média");
        prioridadeCombo.put("Alta","Alta");
        prioridadeCombo.put("Critico","Crítico");
        
        for(String key : prioridadeCombo.keySet()){
            comboPrioridade.addItem(prioridadeCombo.get(key));
        }
        
        btnConfirmar.addActionListener((e) -> {
            
           
            TarefaInterface repositorio = new TarefaDAO();
            
           
            try{
                numerotarefa++;         
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
                Date date = new Date(); 
                String datahoracriacao = dateFormat.format(date); 
                String titulo = txtTitulo.getText();
                
                String dataconclusao = dataConclusao.getText();
                String prioridade = (String) comboPrioridade.getSelectedItem();
                String status = (String) comboStatus.getSelectedItem();
                String descricao = txtDescricao.getText();
                Categoria categoria = (Categoria) ComboCategoria.getSelectedItem();
                enviarImagem();
                String anexo = txtNomeArquivo.getText();
                Tarefa tarefa = new Tarefa(numerotarefa, datahoracriacao, titulo, dataconclusao, prioridade, status, descricao, categoria);
                tarefa.setTitulo(titulo);
                tarefa.setDataconclusao(dataconclusao);
                if(!anexo.isEmpty()){
                    tarefa.setAnexo(anexo);
                }
                
                repositorio.gravar(tarefa);
            
                JOptionPane.showMessageDialog(null,"Tarefa: "+tarefa.getTitulo() + ", criada com Sucesso!");
                System.out.println(tarefa);

                txtTitulo.setText("");
                txtDescricao.setText("");
                dataConclusao.setText("");
            } catch (CampoVazioException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Título e Conclusão não podem ser vazios!");
            }
        });
    }
      
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboPrioridade = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        btnConfirmar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ComboCategoria = new javax.swing.JComboBox<>();
        dataConclusao = new javax.swing.JFormattedTextField();
        btnImagem = new javax.swing.JButton();
        txtNomeArquivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Título");

        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Conclusão");

        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        jLabel5.setText("Descrição");

        jLabel3.setText("Prioridade");

        comboPrioridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPrioridadeActionPerformed(evt);
            }
        });

        jLabel4.setText("Status");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane1.setViewportView(txtDescricao);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cadastrar Tarefa");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setText("Categoria");

        ComboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCategoriaActionPerformed(evt);
            }
        });

        try {
            dataConclusao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataConclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataConclusaoActionPerformed(evt);
            }
        });

        btnImagem.setText("Imagem");
        btnImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagemActionPerformed(evt);
            }
        });

        txtNomeArquivo.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnImagem)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataConclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnImagem)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
    }//GEN-LAST:event_btnConfirmarActionPerformed

    
    public void enviarImagem(){
        if(entrou ==  true){
            
        
        numeracao++;
        String tipo = ".jpeg";
        String nome = "imagem" + Integer.toString(numeracao)+ tipo;
        
        
        try {
             // TODO add your handling code here:
             
             //String caminho = getClass().getResource("/imagens/").toString();
             String caminho = "/Users/tobiaskiefer/NetBeansProjects/trabalhoprog2/src/main/java/imagens/";
             //String caminho = "/Users/tobiaskiefer/NetBeansProjects/trabalhoprog2/";
             //String caminho = "C:/Users/João Pedro Parro/OneDrive - Delsoft Sistemas/Área de Trabalho/PROG2/New Folder/trabalhoprog2/trabalhoprog2/trabalhoprog2/Trabalho/trabalhoprog2/New Folder/trabalhoprog2/src/main/java/imagens/";
             File outputfile = new File(caminho+nome);  
             txtNomeArquivo.setText(nome);
             ImageIO.write(imagem, "jpg", outputfile);
             JOptionPane.showMessageDialog(rootPane, "Imagem enviada com sucesso");
             
         } catch (IOException ex) {
             //Logger.getLogger(nome);
             
         }
        }
    }
    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void comboPrioridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPrioridadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPrioridadeActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   
    }//GEN-LAST:event_formWindowOpened

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStatusActionPerformed
   
    
    private void dataConclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataConclusaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataConclusaoActionPerformed

    private void ComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCategoriaActionPerformed

    private void btnImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagemActionPerformed
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 600, 600);

            } catch (Exception ex) {
               // System.out.println(ex.printStackTrace().toString());
            }
            entrou = true;
        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");

            entrou = false;
        }
    }//GEN-LAST:event_btnImagemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewCriarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCriarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCriarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCriarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCriarTarefa().setVisible(true);
                
               
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Categoria> ComboCategoria;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnImagem;
    private javax.swing.JComboBox<String> comboPrioridade;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JFormattedTextField dataConclusao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JLabel txtNomeArquivo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

   

  
}
