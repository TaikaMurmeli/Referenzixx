package referenzixx.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jbibtex.BibTeXEntry;
import org.jbibtex.Key;
import referenzixx.database.DatabaseUtils;

/**
 *
 * @author Johannes
 */
public class MainUI extends javax.swing.JFrame {

    private DatabaseUtils dbutils;
    private String filters;

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        this.dbutils = new DatabaseUtils();
        this.filters = "";

        initComponents();
        initListeners();
        refresh();
    }

    public DatabaseUtils getDBUtils() {
        return this.dbutils;
    }

    /**
     * Refreshes the reference table to match the list in DatabaseUtils.
     */
    public final void refresh() {
        List<BibTeXEntry> references;
        if (filters.isEmpty()) {
            references = dbutils.getReferences();
        } else {
            references = dbutils.getReferences(filters);
        }

        DefaultTableModel tableModel = (DefaultTableModel) referenceTable.getModel();
        tableModel.setRowCount(0); // Clear the table
        tableModel.setRowCount(references.size());

        int row = 0;
        for (BibTeXEntry reference : references) {
            displayReference(reference, row++);
        }
    }

    private void displayReference(BibTeXEntry entry, int row) {
        TableModel tableModel = referenceTable.getModel();
        tableModel.setValueAt(entry.getKey().toString(), row, 0);
        tableModel.setValueAt(entry.getField(new Key("author")).toUserString(), row, 1);
        tableModel.setValueAt(entry.getField(new Key("title")).toUserString(), row, 2);
        tableModel.setValueAt(entry.getField(new Key("year")).toUserString(), row, 3);
    }

    private void refreshFilters() {

        this.filters = authorTextField.getText();

        refresh();
    }

    private void initListeners() {
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                refreshFilters();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                refreshFilters();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                refreshFilters();
            }
        };
        
        referenceTextField.getDocument().addDocumentListener(documentListener);
        authorTextField.getDocument().addDocumentListener(documentListener);
        titleTextField.getDocument().addDocumentListener(documentListener);
        yearTextField.getDocument().addDocumentListener(documentListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addReferenceButton = new javax.swing.JButton();
        copyButton = new javax.swing.JButton();
        readButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        referenceTable = new javax.swing.JTable();
        delReferenceButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        referenceTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        authorTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        yearTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        addReferenceButton.setText("Lisää");
        addReferenceButton.setToolTipText("Lisää uusi artikkeli");
        addReferenceButton.setName("addButton"); // NOI18N
        addReferenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReferenceButtonActionPerformed(evt);
            }
        });

        copyButton.setText("Kopioi leikepöydälle");
        copyButton.setToolTipText("Kopioi BibTex-tiedoston leikepöydälle");
        copyButton.setName("copyButton"); // NOI18N
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });

        readButton.setText("Valitse tiedosto");
        readButton.setName("selectButton"); // NOI18N
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        referenceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", ""},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Viite", "Kirjoittaja", "Otsikko", "Vuosi"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(referenceTable);

        delReferenceButton.setText("Poista");
        delReferenceButton.setName("delButton"); // NOI18N
        delReferenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delReferenceButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Hae viitteitä");

        jLabel2.setText("Viite");

        referenceTextField.setToolTipText("");
        referenceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                referenceTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Otsikko");

        titleTextField.setToolTipText("Viitteen otsikko");
        titleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Kirjoittaja");

        authorTextField.setToolTipText("Viitteen kirjoittaja");
        authorTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Vuosi");

        yearTextField.setToolTipText("Viitteen julkaisuvuosi");
        yearTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addReferenceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delReferenceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(readButton)
                        .addGap(18, 18, 18)
                        .addComponent(copyButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titleTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(referenceTextField))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(37, 37, 37)
                                        .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(referenceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(copyButton)
                        .addComponent(readButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addReferenceButton)
                        .addComponent(delReferenceButton)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        dbutils.copyToClipboard();
    }//GEN-LAST:event_copyButtonActionPerformed

    private void addReferenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReferenceButtonActionPerformed
        new NewReferenceDialog(this, true).setVisible(true);
    }//GEN-LAST:event_addReferenceButtonActionPerformed

    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            dbutils.selectFile(chooser.getSelectedFile());
            refresh();
        }
    }//GEN-LAST:event_readButtonActionPerformed

    private void delReferenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delReferenceButtonActionPerformed
        List<BibTeXEntry> references = dbutils.getReferences();
        int selectedRow = referenceTable.getSelectedRow();
        if (selectedRow != -1) {
            dbutils.delEntry(references.get(selectedRow));
        }
        refresh();
    }//GEN-LAST:event_delReferenceButtonActionPerformed

    private void referenceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_referenceTextFieldActionPerformed
        System.out.println("asdf");
        refreshFilters();
    }//GEN-LAST:event_referenceTextFieldActionPerformed

    private void titleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleTextFieldActionPerformed
        refreshFilters();
    }//GEN-LAST:event_titleTextFieldActionPerformed

    private void authorTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorTextFieldActionPerformed
        refreshFilters();
    }//GEN-LAST:event_authorTextFieldActionPerformed

    private void yearTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTextFieldActionPerformed
        refreshFilters();
    }//GEN-LAST:event_yearTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addReferenceButton;
    private javax.swing.JTextField authorTextField;
    private javax.swing.JButton copyButton;
    private javax.swing.JButton delReferenceButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton readButton;
    private javax.swing.JTable referenceTable;
    private javax.swing.JTextField referenceTextField;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}
