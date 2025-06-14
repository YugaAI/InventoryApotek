/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

/**
 *
 * @author User
 */
import config.DatabaseConfig;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;



import java.util.List;
import ui.ReportManagementGUI;
import model.LogStock;
import model.suppliers;
import model.transaction;
import repository.transactionsDetailRepo;
import repository.stocksRepo;
import repository.LogStockRepo;
import repository.supplierRepo;
import repository.transactionsRepo;
import repository.brandsRepo;
import usecase.logStockUc;
import usecase.supplierUc;
import usecase.transactionUc;

public class preview extends javax.swing.JFrame {

    /**
     * Creates new form preview
     */
    private String kategori;
    private int periode;
    private String search;

    public preview() {
        initComponents();
    }

    public preview(String kategori, int periode, List<?> data) {
        initComponents();
        
        this.kategori = kategori;
        this.periode = periode;
        this.search=search;
        
        lblKategori.setText("Kategori: " + kategori);
        lblPeriode.setText("Periode: " + periode);

        // Misalnya tampilkan data di JTable
        if (kategori.equals("STOCK MASUK") || kategori.equals("STOCK KELUAR")) {
            tampilkanDataStock((List<LogStock>) data);
        } else if (kategori.equals("MASTER SUPPLIER")) {
            tampilkanDataSupplier((List<suppliers>) data);
        } else if (kategori.equals("DATA TRANSAKSI")) {
            tampilkanDataTransaksi((List<transaction>) data);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblKategori = new javax.swing.JLabel();
        lblPeriode = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePreview = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        lblKategori.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblKategori.setText("Kategori");

        lblPeriode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPeriode.setText("Periode");

        btnExport.setBackground(new java.awt.Color(0, 255, 51));
        btnExport.setText("EXPORT");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        tablePreview.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablePreview);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblKategori)
                        .addContainerGap(755, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPeriode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExport)
                        .addGap(18, 18, 18))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblKategori)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeriode)
                    .addComponent(btnExport))
                .addContainerGap(392, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addGap(18, 18, 18)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        String search = ""; 
        int periode;


    Connection conn = DatabaseConfig.connect();
    
    LogStockRepo logStockRepo = new LogStockRepo(conn);
    supplierRepo supplierRepo = new supplierRepo(conn);
    brandsRepo brandsRepo = new brandsRepo(conn);
    transactionsRepo transactionsRepo = new transactionsRepo(conn);
    transactionsDetailRepo transactionsDetailRepo = new transactionsDetailRepo(conn);
    stocksRepo stocksRepo = new stocksRepo(conn);
    
    logStockUc logStockUc = new logStockUc(logStockRepo);
    supplierUc supplierUc = new supplierUc(supplierRepo, brandsRepo);
    transactionUc transactionUc = new transactionUc(transactionsRepo, transactionsDetailRepo, stocksRepo, logStockRepo);

    boolean result = false;

    try {
        switch (kategori) {
            case "STOCK MASUK":
                result = logStockUc.exportLogStock("stock_in", 0);
                break;
            case "STOCK KELUAR":
                result = logStockUc.exportLogStock("stock_out", 0);
                break;

            case "MASTER SUPPLIER":
                result = supplierUc.exportSupplierList(search, 0);
                break;

            case "DATA TRANSAKSI":
                result = transactionUc.exportTransactionList(0);
                break;

            default:
                JOptionPane.showMessageDialog(this, "Pilih kategori yang valid!");
                return;
        }

        if (result) {
            JOptionPane.showMessageDialog(this, "Export berhasil disimpan.");
        } else {
            JOptionPane.showMessageDialog(this, "Export gagal. Coba periksa kembali.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat export: " + e.getMessage());
    }
    }//GEN-LAST:event_btnExportActionPerformed

    /**
     * @param args the command line arguments
     */
    private void tampilkanDataStock(List<LogStock> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID Stock", "Activity Name", "Nama Barang", "Jumlah", "Username", "Tanggal"});

        for (LogStock log : data) {
        model.addRow(new Object[]{
            log.getId(), log.getActivityName(), log.getItemName(), log.getQty(), log.getUsername(), log.getCreatedAt()});
        }
        tablePreview.setModel(model);
    }
    private void tampilkanDataSupplier(List<suppliers> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID Supplier", "Nama Supplier", "Alamat", "Telepon","Status"});

        for (suppliers s : data) {
            model.addRow(new Object[]{s.getId(), s.getSupplierName(), s.getAddress(), s.getPhone(), s.getStatus()});
        }
        tablePreview.setModel(model);
    }
    private void tampilkanDataTransaksi(List<transaction> data) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID Transaksi", "Total Harga", "Total Item", "Username"});

        for (transaction t : data) {
            model.addRow(new Object[]{t.getId(), t.getGrandTotal(), t.getTotalItem(), t.getUsername()});
        }
        tablePreview.setModel(model);
    }
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
            java.util.logging.Logger.getLogger(preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(preview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new preview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExport;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblPeriode;
    private javax.swing.JTable tablePreview;
    // End of variables declaration//GEN-END:variables
}
