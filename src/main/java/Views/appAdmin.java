/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Database.ConnectionHelper;
import Controller.tataUsahaController;
import Controller.siswaController;
import Interface.siswaInterface;
import Interface.tagihanInterface;
import Interface.tataUsahaInterface;
import Models.siswa;
import Models.tagihan;
import Models.tataUsaha;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class appAdmin extends javax.swing.JFrame {

    Connection a = ConnectionHelper.getConnection();

    List<siswa> record = new ArrayList<siswa>();
    siswaInterface sisServis;
    int row;

    List<tataUsaha> recordTus = new ArrayList<tataUsaha>();
    tataUsahaInterface TusServis;
    int rowTus;

    public appAdmin() {
        initComponents();
        sisServis = new siswaController();
        TusServis = new tataUsahaController();

        dasisTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                row = dasisTable.getSelectedRow();
                if (row != -1) {
                    isiTextSis();
                }
            }
        });
        this.statusAwalSis();

        datraTableTagihan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                row = datraTableTagihan.getSelectedRow();
                if (row != -1) {
                    isiTextTra();
                }
            }
        });
        this.statusAwalTra();

        datusTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                rowTus = datusTable.getSelectedRow();
                if (rowTus != -1) {
                    isiTextTus();
                }
            }
        });
        this.statusAwalTus();
    }

    void isiTabelTra() {
        Object data[][] = new Object[record.size()][6];
        int x = 0;
        for (siswa sis : record) {
            data[x][0] = sis.getNis();
            data[x][1] = sis.getNama();
            data[x][2] = sis.getJurusan();
            data[x][3] = sis.getKelas();
            data[x][4] = sis.getJumlah();
            data[x][5] = sis.getStatus();
            x++;
        }
        String judul[] = {"NIS", "NAMA", "JURUSAN", "KELAS", "JUMLAH", "STATUS"};
        datraTableTagihan.setModel(new DefaultTableModel(data, judul));
        datraScrollPaneTagihan.setViewportView(datraTableTagihan);
    }

    void isiTextTra() {
        siswa sis = record.get(row);
        datraNisField.setText(sis.getNis());
        datraNamaField.setText(sis.getNama());
        datraJurusanField.setText(sis.getJurusan());
        datraKelasField.setText(sis.getKelas());
        datraTagihanField.setText(sis.getJumlah());
        datraStatusField.setText(sis.getStatus());
    }

    void loadDataTra() {
        try {
            record = sisServis.getAlls();
        } catch (SQLException ex) {
            Logger.getLogger(appAdmin.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    void kosongkanTextTra() {
        datraNisField.setText("");
        datraNamaField.setText("");
        datraJurusanField.setText("");
        datraKelasField.setText("");
        datraTagihanField.setText("");
        datraStatusField.setText("");
    }

    void statusAwalTra() {
        kosongkanTextTra();
        loadDataTra();
        isiTabelTra();
    }

//    SISWA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    SISWA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    SISWA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    SISWA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    void isiTabelSis() {
        Object data[][] = new Object[record.size()][4];
        int x = 0;
        for (siswa sis : record) {
            data[x][0] = sis.getNis();
            data[x][1] = sis.getNama();
            data[x][2] = sis.getJurusan();
            data[x][3] = sis.getKelas();
            x++;
        }
        String judul[] = {"NIS", "NAMA", "JURUSAN", "KELAS"};
        dasisTable.setModel(new DefaultTableModel(data, judul));
        dasisScrollPane.setViewportView(dasisTable);
    }

    void loadDataSis() {
        try {
            record = sisServis.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(appAdmin.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    void isiTextSis() {
        siswa sis = record.get(row);
        dasisNisField.setText(sis.getNis());
        dasisNamaField.setText(sis.getNama());
        dasisJurusanField.setText(sis.getJurusan());
        dasisKelasField.setText(sis.getKelas());
    }

    void kosongkanTextSis() {
        dasisNisField.setText("");
        dasisNamaField.setText("");
        dasisJurusanField.setText("");
        dasisKelasField.setText("");
    }

    void statusAwalSis() {
        kosongkanTextSis();
        loadDataSis();
        isiTabelSis();
    }

//    TATA USAHA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    TATA USAHA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    TATA USAHA ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    void loadDataTus() {
        try {
            recordTus = TusServis.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(appAdmin.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    void isiTabelTus() {
        Object data[][] = new Object[recordTus.size()][4];
        int x = 0;
        for (tataUsaha Tus : recordTus) {
            data[x][0] = Tus.getIdTu();
            data[x][1] = Tus.getNama();
            data[x][2] = Tus.getUsia();
            data[x][3] = Tus.getPendidikan();
            x++;
        }
        String judul[] = {"idTu", "Nama", "Usia", "Pendidikan"};
        datusTable.setModel(new DefaultTableModel(data, judul));
        datusScrollPane.setViewportView(datusTable);
    }

    void isiTextTus() {
        tataUsaha Tus = recordTus.get(rowTus);
        datusIdTuField.setText(Tus.getIdTu());
        datusNamaField.setText(Tus.getNama());
        datusUsiaField.setText(Tus.getUsia());
        datusPendidikanField.setText(Tus.getPendidikan());
    }

    void kosongkanTextTus() {
        datusIdTuField.setText("");
        datusNamaField.setText("");
        datusUsiaField.setText("");
        datusPendidikanField.setText("");
    }

    void statusAwalTus() {
        kosongkanTextTus();
        loadDataTus();
        isiTabelTus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        dasisPanel = new javax.swing.JPanel();
        dasisScrollPane = new javax.swing.JScrollPane();
        dasisTable = new javax.swing.JTable();
        dasisNisLabel = new javax.swing.JLabel();
        dasisNamaLabel = new javax.swing.JLabel();
        dasisJurusanLabel = new javax.swing.JLabel();
        dasisKelasLabel = new javax.swing.JLabel();
        dasisUbahBtn = new javax.swing.JButton();
        dasisTambahBtn = new javax.swing.JButton();
        dasisHapusBtn = new javax.swing.JButton();
        dasisNisField = new javax.swing.JTextField();
        dasisNamaField = new javax.swing.JTextField();
        dasisJurusanField = new javax.swing.JTextField();
        dasisKelasField = new javax.swing.JTextField();
        datusPanel = new javax.swing.JPanel();
        datusScrollPane = new javax.swing.JScrollPane();
        datusTable = new javax.swing.JTable();
        datusIdTuLabel = new javax.swing.JLabel();
        datusNamaLabel = new javax.swing.JLabel();
        datusUsiaLabel = new javax.swing.JLabel();
        datusPendidikanLabel = new javax.swing.JLabel();
        datusUbahBtn = new javax.swing.JButton();
        datusTambahBtn = new javax.swing.JButton();
        datusHapusBtn = new javax.swing.JButton();
        datusIdTuField = new javax.swing.JTextField();
        datusNamaField = new javax.swing.JTextField();
        datusUsiaField = new javax.swing.JTextField();
        datusPendidikanField = new javax.swing.JTextField();
        datraPanel = new javax.swing.JPanel();
        datraScrollPaneTagihan = new javax.swing.JScrollPane();
        datraTableTagihan = new javax.swing.JTable();
        NotLUNASunchangeLabel = new javax.swing.JLabel();
        datraNisLabel = new javax.swing.JLabel();
        datraNamaLabel = new javax.swing.JLabel();
        datraJurusanLabel = new javax.swing.JLabel();
        datraKelasLabel = new javax.swing.JLabel();
        datraTagihanLabel = new javax.swing.JLabel();
        datraStatusLabel = new javax.swing.JLabel();
        lunasBtn = new javax.swing.JButton();
        datraNisField = new javax.swing.JTextField();
        datraNamaField = new javax.swing.JTextField();
        datraJurusanField = new javax.swing.JTextField();
        datraKelasField = new javax.swing.JTextField();
        datraTagihanField = new javax.swing.JTextField();
        datraStatusField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dasisTable.setModel(new javax.swing.table.DefaultTableModel(
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
        dasisTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dasisTableMouseClicked(evt);
            }
        });
        dasisScrollPane.setViewportView(dasisTable);

        dasisNisLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dasisNisLabel.setText("NIS");

        dasisNamaLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dasisNamaLabel.setText("NAMA");
        dasisNamaLabel.setToolTipText("");

        dasisJurusanLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dasisJurusanLabel.setText("JURUSAN");

        dasisKelasLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dasisKelasLabel.setText("KELAS");

        dasisUbahBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dasisUbahBtn.setText("UBAH");
        dasisUbahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dasisUbahBtnActionPerformed(evt);
            }
        });

        dasisTambahBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dasisTambahBtn.setText("TAMBAH");
        dasisTambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dasisTambahBtnActionPerformed(evt);
            }
        });

        dasisHapusBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dasisHapusBtn.setText("HAPUS");
        dasisHapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dasisHapusBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dasisPanelLayout = new javax.swing.GroupLayout(dasisPanel);
        dasisPanel.setLayout(dasisPanelLayout);
        dasisPanelLayout.setHorizontalGroup(
            dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dasisPanelLayout.createSequentialGroup()
                .addGroup(dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dasisPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dasisScrollPane))
                    .addGroup(dasisPanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dasisPanelLayout.createSequentialGroup()
                                .addComponent(dasisTambahBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(dasisUbahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dasisHapusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dasisPanelLayout.createSequentialGroup()
                                .addGroup(dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dasisJurusanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dasisNamaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dasisNisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dasisKelasLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dasisKelasField)
                                    .addComponent(dasisJurusanField)
                                    .addComponent(dasisNamaField)
                                    .addComponent(dasisNisField))))
                        .addGap(28, 28, 28)))
                .addContainerGap())
        );
        dasisPanelLayout.setVerticalGroup(
            dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dasisPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dasisNisLabel)
                    .addComponent(dasisNisField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dasisNamaLabel)
                    .addComponent(dasisNamaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dasisJurusanLabel)
                    .addComponent(dasisJurusanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dasisKelasLabel)
                    .addComponent(dasisKelasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(dasisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dasisUbahBtn)
                    .addComponent(dasisTambahBtn)
                    .addComponent(dasisHapusBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dasisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("DATA SISWA", dasisPanel);

        datusTable.setModel(new javax.swing.table.DefaultTableModel(
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
        datusScrollPane.setViewportView(datusTable);

        datusIdTuLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        datusIdTuLabel.setText("ID Tata Usaha");

        datusNamaLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        datusNamaLabel.setText("Nama");
        datusNamaLabel.setToolTipText("");

        datusUsiaLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        datusUsiaLabel.setText("Usia");

        datusPendidikanLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        datusPendidikanLabel.setText("Pendidikan");

        datusUbahBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        datusUbahBtn.setText("UBAH");
        datusUbahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datusUbahBtnActionPerformed(evt);
            }
        });

        datusTambahBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        datusTambahBtn.setText("TAMBAH");
        datusTambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datusTambahBtnActionPerformed(evt);
            }
        });

        datusHapusBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        datusHapusBtn.setText("HAPUS");
        datusHapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datusHapusBtnActionPerformed(evt);
            }
        });

        datusIdTuField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datusIdTuFieldActionPerformed(evt);
            }
        });

        datusNamaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datusNamaFieldActionPerformed(evt);
            }
        });

        datusUsiaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datusUsiaFieldActionPerformed(evt);
            }
        });

        datusPendidikanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datusPendidikanFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datusPanelLayout = new javax.swing.GroupLayout(datusPanel);
        datusPanel.setLayout(datusPanelLayout);
        datusPanelLayout.setHorizontalGroup(
            datusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datusPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(datusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(datusPanelLayout.createSequentialGroup()
                        .addComponent(datusTambahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(datusUbahBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(datusHapusBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                    .addGroup(datusPanelLayout.createSequentialGroup()
                        .addGroup(datusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(datusUsiaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datusNamaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datusIdTuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(datusPendidikanLabel))
                        .addGap(18, 18, 18)
                        .addGroup(datusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(datusUsiaField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                            .addComponent(datusNamaField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datusIdTuField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datusPendidikanField))))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(datusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datusScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                .addContainerGap())
        );
        datusPanelLayout.setVerticalGroup(
            datusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datusPanelLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(datusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datusIdTuLabel)
                    .addComponent(datusIdTuField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datusNamaLabel)
                    .addComponent(datusNamaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datusUsiaLabel)
                    .addComponent(datusUsiaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datusPendidikanLabel)
                    .addComponent(datusPendidikanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(datusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datusUbahBtn)
                    .addComponent(datusTambahBtn)
                    .addComponent(datusHapusBtn))
                .addGap(18, 18, 18)
                .addComponent(datusScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("DATA TATA USAHA", datusPanel);

        datraTableTagihan.setModel(new javax.swing.table.DefaultTableModel(
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
        datraScrollPaneTagihan.setViewportView(datraTableTagihan);

        NotLUNASunchangeLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NotLUNASunchangeLabel.setText("DATA PEMBAYARAN SPP");

        datraNisLabel.setText("NIS");

        datraNamaLabel.setText("NAMA");

        datraJurusanLabel.setText("JURUSAN");

        datraKelasLabel.setText("KELAS");

        datraTagihanLabel.setText("Jumlah Tagihan");

        datraStatusLabel.setText("Status Bayar");

        lunasBtn.setText("Update");
        lunasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lunasBtnActionPerformed(evt);
            }
        });

        datraNisField.setActionCommand("<Not Set>");
        datraNisField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datraNisFieldActionPerformed(evt);
            }
        });

        datraNamaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datraNamaFieldActionPerformed(evt);
            }
        });

        datraJurusanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datraJurusanFieldActionPerformed(evt);
            }
        });

        datraKelasField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datraKelasFieldActionPerformed(evt);
            }
        });

        datraTagihanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datraTagihanFieldActionPerformed(evt);
            }
        });

        datraStatusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datraStatusFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout datraPanelLayout = new javax.swing.GroupLayout(datraPanel);
        datraPanel.setLayout(datraPanelLayout);
        datraPanelLayout.setHorizontalGroup(
            datraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datraScrollPaneTagihan)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datraPanelLayout.createSequentialGroup()
                .addGroup(datraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(datraPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lunasBtn))
                    .addGroup(datraPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(datraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datraPanelLayout.createSequentialGroup()
                                .addGroup(datraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(datraNamaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datraNisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(datraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(datraNamaField)
                                    .addComponent(datraNisField)))
                            .addGroup(datraPanelLayout.createSequentialGroup()
                                .addComponent(datraJurusanLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datraJurusanField, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(datraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(datraPanelLayout.createSequentialGroup()
                                .addComponent(datraKelasLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(datraKelasField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(datraPanelLayout.createSequentialGroup()
                                .addComponent(datraTagihanLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datraTagihanField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, datraPanelLayout.createSequentialGroup()
                                .addComponent(datraStatusLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(datraStatusField, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(63, 63, 63))
            .addGroup(datraPanelLayout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(NotLUNASunchangeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datraPanelLayout.setVerticalGroup(
            datraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, datraPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(datraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datraNisLabel)
                    .addComponent(datraNisField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datraKelasLabel)
                    .addComponent(datraKelasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datraNamaLabel)
                    .addComponent(datraNamaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datraTagihanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datraTagihanLabel))
                .addGap(18, 18, 18)
                .addGroup(datraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datraJurusanLabel)
                    .addComponent(datraJurusanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datraStatusLabel)
                    .addComponent(datraStatusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(lunasBtn)
                .addGap(4, 4, 4)
                .addComponent(NotLUNASunchangeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datraScrollPaneTagihan, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("DATA TRANKSAKSI", datraPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dasisUbahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dasisUbahBtnActionPerformed
        String nis = dasisNisField.getText().toString().trim();
        String nama = dasisNamaField.getText().toString().trim();
        String jurusan = dasisJurusanField.getText().toString().trim();
        String kelas = dasisKelasField.getText().toString().trim();

        if (nis.equals("") || nama.equals("") || jurusan.equals("") || kelas.equals("")) {
            JOptionPane.showMessageDialog(null, "Tolong semua data diisi");
        } else if (dasisTable.getSelectedRowCount() == 1) {
            try {
                siswa sis = new siswa(null, null, null, null, null, null);
                nis = dasisNisField.getText();
                sisServis.delete(nis);
                isiTabelSis();

                sis.setNis(dasisNisField.getText());
                sis.setNama(dasisNamaField.getText());
                sis.setJurusan(dasisJurusanField.getText());
                sis.setKelas(dasisKelasField.getText());
                sis.setJumlah("250.000");
                sis.setStatus("Belum Lunas");
                sisServis.insert(sis);
                this.statusAwalSis();
                this.statusAwalTra();
                JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            } catch (SQLException ex) {
                Logger.getLogger(appAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (dasisTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table Kosong . . .");
            } else {
                JOptionPane.showMessageDialog(null, "Tolong pilih data yang mau diupdate");
            }
        }

//        if (nis.equals("") || nama.equals("") || jurusan.equals("") || kelas.equals("")) {
//            JOptionPane.showMessageDialog(null, "Tolong semua data diisi");
//        } else if (dasisTable.getSelectedRowCount() == 1) {
//            try {
//                siswa sis = new siswa(null, null, null, null, null, null);
//                sis.setNis(dasisNisField.getText());
//                sis.setNama(dasisNamaField.getText());
//                sis.setJurusan(dasisJurusanField.getText());
//                sis.setKelas(dasisKelasField.getText());
//                sisServis.update(sis);
//                this.statusAwalSis();
//                JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
//            } catch (SQLException ex) {
//                Logger.getLogger(appAdmin.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            if (dasisTable.getRowCount() == 0) {
//                JOptionPane.showMessageDialog(null, "Table Kosong . . .");
//            } else {
//                JOptionPane.showMessageDialog(null, "Tolong pilih data yang mau diupdate");
//            }
//        }

    }//GEN-LAST:event_dasisUbahBtnActionPerformed

    private void dasisTambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dasisTambahBtnActionPerformed
        String nis = dasisNisField.getText().toString().trim();
        String nama = dasisNamaField.getText().toString().trim();
        String jurusan = dasisJurusanField.getText().toString().trim();
        String kelas = dasisKelasField.getText().toString().trim();

        if (nis.equals("") || nama.equals("") || jurusan.equals("") || kelas.equals("")) {
            JOptionPane.showMessageDialog(null, "Tolong semua data diisi");
        } else {
            try {
                siswa sis = new siswa(null, null, null, null, null, null);
                sis.setNis(dasisNisField.getText());
                sis.setNama(dasisNamaField.getText());
                sis.setJurusan(dasisJurusanField.getText());
                sis.setKelas(dasisKelasField.getText());
                sis.setJumlah("250.000");
                sis.setStatus("Belum Lunas");
                sisServis.insert(sis);
                this.statusAwalSis();
                this.statusAwalTra();
                JOptionPane.showMessageDialog(this, "Data Tersimpan");
            } catch (SQLException ex) {
                Logger.getLogger(appAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_dasisTambahBtnActionPerformed

    private void dasisHapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dasisHapusBtnActionPerformed
        String nis = dasisNisField.getText().toString().trim();
        String nama = dasisNamaField.getText().toString().trim();
        String jurusan = dasisJurusanField.getText().toString().trim();
        String kelas = dasisKelasField.getText().toString().trim();

        if (nis.equals("") || nama.equals("") || jurusan.equals("") || kelas.equals("")) {
            JOptionPane.showMessageDialog(null, "Tolong pilih data yang ingin dihapus");
        } else {
            try {

                nis = dasisNisField.getText();
                sisServis.delete(nis);
                this.statusAwalSis();
                this.statusAwalTra();
                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");

            } catch (SQLException ex) {
                Logger.getLogger(appAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_dasisHapusBtnActionPerformed

    private void dasisTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dasisTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dasisTableMouseClicked

    private void datusUbahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datusUbahBtnActionPerformed
        String idtu = datusIdTuField.getText().toString().trim();
        String nama = datusNamaField.getText().toString().trim();
        String usia = datusUsiaField.getText().toString().trim();
        String pendidikan = datusPendidikanField.getText().toString().trim();

        if (idtu.equals("") || nama.equals("") || usia.equals("") || pendidikan.equals("")) {
            JOptionPane.showMessageDialog(null, "Tolong semua data diisi");
        } else if (datusTable.getSelectedRowCount() == 1) {
            try {
                tataUsaha Tus = new tataUsaha(null, null, null, null);
                idtu = datusIdTuField.getText();
                TusServis.delete(idtu);
                isiTabelTus();
                Tus.setIdTu(datusIdTuField.getText());
                Tus.setNama(datusNamaField.getText());
                Tus.setUsia(datusUsiaField.getText());
                Tus.setPendidikan(datusPendidikanField.getText());
                TusServis.insert(Tus);
                this.statusAwalTus();
                JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            } catch (SQLException ex) {
                Logger.getLogger(appAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (datusTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table Kosong . . .");
            } else {
                JOptionPane.showMessageDialog(null, "Tolong pilih data yang mau diupdate");
            }
        }
    }//GEN-LAST:event_datusUbahBtnActionPerformed

    private void datusTambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datusTambahBtnActionPerformed
        String idtu = datusIdTuField.getText().toString().trim();
        String nama = datusNamaField.getText().toString().trim();
        String usia = datusUsiaField.getText().toString().trim();
        String pendidikan = datusPendidikanField.getText().toString().trim();

        if (idtu.equals("") || nama.equals("") || usia.equals("") || pendidikan.equals("")) {
            JOptionPane.showMessageDialog(null, "Tolong semua data diisi");
        } else {
            try {
                tataUsaha Tus = new tataUsaha(null, null, null, null);
                Tus.setIdTu(datusIdTuField.getText());
                Tus.setNama(datusNamaField.getText());
                Tus.setUsia(datusUsiaField.getText());
                Tus.setPendidikan(datusPendidikanField.getText());
                TusServis.insert(Tus);
                this.statusAwalTus();
                JOptionPane.showMessageDialog(this, "Data Tersimpan");
            } catch (SQLException ex) {
                Logger.getLogger(appAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_datusTambahBtnActionPerformed

    private void datusHapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datusHapusBtnActionPerformed
        String idtu = datusIdTuField.getText().toString().trim();
        String nama = datusNamaField.getText().toString().trim();
        String usia = datusUsiaField.getText().toString().trim();
        String pendidikan = datusPendidikanField.getText().toString().trim();

        if (idtu.equals("") || nama.equals("") || usia.equals("") || pendidikan.equals("")) {
            JOptionPane.showMessageDialog(null, "Tolong semua data diisi");
        } else {
            try {

                idtu = datusIdTuField.getText();
                TusServis.delete(idtu);
                this.statusAwalTus();
                JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");

            } catch (SQLException ex) {
                Logger.getLogger(appAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_datusHapusBtnActionPerformed

    private void datusIdTuFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datusIdTuFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datusIdTuFieldActionPerformed

    private void datusNamaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datusNamaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datusNamaFieldActionPerformed

    private void datusUsiaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datusUsiaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datusUsiaFieldActionPerformed

    private void datusPendidikanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datusPendidikanFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datusPendidikanFieldActionPerformed

    private void datraNisFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datraNisFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datraNisFieldActionPerformed

    private void datraNamaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datraNamaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datraNamaFieldActionPerformed

    private void datraJurusanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datraJurusanFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datraJurusanFieldActionPerformed

    private void datraKelasFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datraKelasFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datraKelasFieldActionPerformed

    private void datraTagihanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datraTagihanFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datraTagihanFieldActionPerformed

    private void datraStatusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datraStatusFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datraStatusFieldActionPerformed

    private void lunasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lunasBtnActionPerformed
        String nis = datraNisField.getText().toString().trim();
        String nama = datraNamaField.getText().toString().trim();
        String jurusan = datraJurusanField.getText().toString().trim();
        String kelas = datraKelasField.getText().toString().trim();
        String jumlah = datraTagihanField.getText().toString().trim();
        String status = datraStatusField.getText().toString().trim();

        try {
            siswa sis = new siswa(null, null, null, null, null, null);

            nis = datraNisField.getText();
            sisServis.delete(nis);

            sis.setNis(datraNisField.getText());
            sis.setNama(datraNamaField.getText());
            sis.setJurusan(datraJurusanField.getText());
            sis.setKelas(datraKelasField.getText());
            sis.setJumlah(datraTagihanField.getText());
            sis.setStatus(datraStatusField.getText());
            sisServis.insertTra(sis);
            this.statusAwalTra();
            this.statusAwalSis();
            JOptionPane.showMessageDialog(this, "Data " + datraNamaField.getText() + " Telah diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(appAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_lunasBtnActionPerformed

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
            java.util.logging.Logger.getLogger(appAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(appAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(appAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(appAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new appAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NotLUNASunchangeLabel;
    private javax.swing.JButton dasisHapusBtn;
    private javax.swing.JTextField dasisJurusanField;
    private javax.swing.JLabel dasisJurusanLabel;
    private javax.swing.JTextField dasisKelasField;
    private javax.swing.JLabel dasisKelasLabel;
    private javax.swing.JTextField dasisNamaField;
    private javax.swing.JLabel dasisNamaLabel;
    private javax.swing.JTextField dasisNisField;
    private javax.swing.JLabel dasisNisLabel;
    private javax.swing.JPanel dasisPanel;
    private javax.swing.JScrollPane dasisScrollPane;
    private javax.swing.JTable dasisTable;
    private javax.swing.JButton dasisTambahBtn;
    private javax.swing.JButton dasisUbahBtn;
    private javax.swing.JTextField datraJurusanField;
    private javax.swing.JLabel datraJurusanLabel;
    private javax.swing.JTextField datraKelasField;
    private javax.swing.JLabel datraKelasLabel;
    private javax.swing.JTextField datraNamaField;
    private javax.swing.JLabel datraNamaLabel;
    private javax.swing.JTextField datraNisField;
    private javax.swing.JLabel datraNisLabel;
    private javax.swing.JPanel datraPanel;
    private javax.swing.JScrollPane datraScrollPaneTagihan;
    private javax.swing.JTextField datraStatusField;
    private javax.swing.JLabel datraStatusLabel;
    private javax.swing.JTable datraTableTagihan;
    private javax.swing.JTextField datraTagihanField;
    private javax.swing.JLabel datraTagihanLabel;
    private javax.swing.JButton datusHapusBtn;
    private javax.swing.JTextField datusIdTuField;
    private javax.swing.JLabel datusIdTuLabel;
    private javax.swing.JTextField datusNamaField;
    private javax.swing.JLabel datusNamaLabel;
    private javax.swing.JPanel datusPanel;
    private javax.swing.JTextField datusPendidikanField;
    private javax.swing.JLabel datusPendidikanLabel;
    private javax.swing.JScrollPane datusScrollPane;
    private javax.swing.JTable datusTable;
    private javax.swing.JButton datusTambahBtn;
    private javax.swing.JButton datusUbahBtn;
    private javax.swing.JTextField datusUsiaField;
    private javax.swing.JLabel datusUsiaLabel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lunasBtn;
    // End of variables declaration//GEN-END:variables
}
