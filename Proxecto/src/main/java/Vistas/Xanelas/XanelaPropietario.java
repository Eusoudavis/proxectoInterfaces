/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Xanelas;

import com.formdev.flatlaf.FlatLightLaf;
import modelo.Loxica.*;
import modelo.dao.implementacion.cartaDAO.CartaDAO;
import modelo.dao.implementacion.concelloDAO.ConcelloDAO;
import modelo.vo.Carta.Carta;
import modelo.vo.Carta.CartaLocal;
import modelo.vo.Concello.Concello;
import modelo.vo.EstacionAno;
import modelo.vo.Local.Local;
import modelo.vo.Local.LocalTipoLocal;
import modelo.vo.Local.TipoLocal;
import modelo.vo.LocalPropietario;
import modelo.vo.Produto.*;
import modelo.vo.Usuario.Propietario;
import modelo.vo.Usuario.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa XanelaPropietario na aplicaciï¿½n
 *
 * @author david
 */
public class XanelaPropietario extends javax.swing.JFrame {

    /**
     * Atributos de clase, declaraciï¿½ns e instanciaciï¿½ns
     */
    public int xMouse, yMouse;
    String idPropietario = System.getProperty("idPropietario");
    LoxicaPrato loxicaPrato = new LoxicaPrato();
    LoxicaIngredientePrato loxicaIngredientePrato = new LoxicaIngredientePrato();
    LoxicaIngrediente loxicaIngrediente = new LoxicaIngrediente();
    LoxicaUsuario loxicaUsuario = new LoxicaUsuario();
    LoxicaPropietario loxicaPropietario = new LoxicaPropietario();
    LoxicaCliente loxicaCliente = new LoxicaCliente();
    LoxicaTipoLocal loxicaTipoLocal = new LoxicaTipoLocal();
    LoxicaCarta loxicaCarta = new LoxicaCarta();
    LoxicaTipoBebida loxicaTipoBebida = new LoxicaTipoBebida();
    LoxicaProducto loxicaProducto = new LoxicaProducto();
    LoxicaBebida loxicaBebida = new LoxicaBebida();
    LoxicaLocal loxicaLocal = new LoxicaLocal();
    LoxicaLocalPropietario loxicaLocalPropietario = new LoxicaLocalPropietario();
    LoxicaLocalTipoLocal loxicaLocalTipoLocal = new LoxicaLocalTipoLocal();
    LoxicaConcello loxicaConcello = new LoxicaConcello();
    LoxicaCartaLocal loxicaCartaLocal = new LoxicaCartaLocal();
    List<Produto> produtos;
    List<TipoBebida> tipoBebidas;
    List<Carta> cartas;
    List<Concello> concellos;
    List<TipoLocal> tipoLocalList;
    List<IngredientePrato> ingredientesPrato;
    List<Prato> pratos;
    List<Ingrediente> ingredientes;

    /**
     * Creates new form XanelaCliente
     */
    public XanelaPropietario() {
        initComponents();

        //ComboRol.addItem("");
        //ComboRol.addItem("Cliente");
        //ComboRol.addItem("Propietario");

        ComboConcello.addItem("");
        ConcelloDAO concelloDAO = new ConcelloDAO();
        List<Concello> concellos = concelloDAO.read();
        for (Concello council : concellos
        ) {
            ComboConcello.addItem(String.valueOf(council.getNomeConcello()));
        }

        ComboConcelloLocal.removeAllItems();
        ComboConcelloLocal.addItem("");
        concellos = loxicaConcello.validarRead();
        for (Concello concello : concellos
        ) {
            ComboConcelloLocal.addItem(String.valueOf(concello.getNomeConcello()));
        }

        putTipoLocal();
        putIngredientCombo();
        putTipoBebidaCombo();
        putEncargo();
        putEspecialidade();

        ComboEspecialidadeLocal.removeAllItems();
        ComboEspecialidadeLocal.addItem("");
        ComboEspecialidadeLocal.addItem("Carne");
        ComboEspecialidadeLocal.addItem("Pescado");
        ComboEspecialidadeLocal.addItem("Veggie");
        ComboEspecialidadeLocal.addItem("Marisco");
        ComboEspecialidadeLocal.addItem("Tradicional");
        ComboEspecialidadeLocal.addItem("Copas");
        ComboEspecialidadeLocal.addItem("Si");
        ComboEspecialidadeLocal.addItem("Non");

        ComboEstacion.addItem("");
        ComboEstacion.addItem(String.valueOf(EstacionAno.anual));
        ComboEstacion.addItem(String.valueOf(EstacionAno.primaveira));
        ComboEstacion.addItem(String.valueOf(EstacionAno.inverno));
        ComboEstacion.addItem(String.valueOf(EstacionAno.veran));
        ComboEstacion.addItem(String.valueOf(EstacionAno.outono));

        ComboCarta.addItem("");
        CartaDAO cartaDAO = new CartaDAO();
        List<Carta> cartas = cartaDAO.read();
        for (Carta card : cartas
        ) {
            ComboCarta.addItem(String.valueOf(card.getIdCarta()));
        }
    }

    private void putTipoLocal() {
        ComboTipoLocal.removeAllItems();
        ComboTipoLocal.addItem("");
        tipoLocalList = loxicaTipoLocal.validarRead();
        for (TipoLocal tipoLocal : tipoLocalList
        ) {
            ComboTipoLocal.addItem(String.valueOf(tipoLocal.getNomeTipo()));
        }
    }

    private void putEspecialidade() {
        ComboEspecialidade.removeAllItems();
        ComboEspecialidade.addItem("");
        ComboEspecialidade.addItem("Si");
        ComboEspecialidade.addItem("Non");
    }

    private void putEncargo() {

        ComboEncargo.addItem("");
        ComboEncargo.addItem("Si");
        ComboEncargo.addItem("Non");
    }

    private void putTipoBebidaCombo() {
        ComboTipoBebidas.removeAllItems();
        ComboTipoBebidas.addItem("");

        tipoBebidas = loxicaTipoBebida.validarRead();
        if (!tipoBebidas.isEmpty()) {
            for (TipoBebida bebidaTipo : tipoBebidas
            ) {
                ComboTipoBebidas.addItem(String.valueOf(bebidaTipo.getNomeTipoBebida()));
            }
        }
    }

    private void putIngredientCombo() {
        ComboIngrediente.removeAllItems();
        ComboIngrediente.addItem("");
        ingredientes = loxicaIngrediente.validarRead();
        for (Ingrediente ingre : ingredientes
        ) {
            ComboIngrediente.addItem(String.valueOf(ingre.getNomeIngrediente()));
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

        BgPropietario = new javax.swing.JPanel();
        PanelLateralPro = new javax.swing.JPanel();
        labelconectado = new javax.swing.JLabel();
        labelIconoConec = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        PanelFixoInicio = new javax.swing.JPanel();
        PanelInicioLocal = new javax.swing.JLabel();
        PanelDatosLocal = new javax.swing.JPanel();
        LabelDatosLocal = new javax.swing.JLabel();
        PanelEngadeLocal = new javax.swing.JPanel();
        LabeLEngadeLocal = new javax.swing.JLabel();
        PanelDatosPro = new javax.swing.JPanel();
        LabelDatosPro = new javax.swing.JLabel();
        PanelMarchoPro = new javax.swing.JPanel();
        LabelMarchoPro = new javax.swing.JLabel();
        botonHelpPro = new javax.swing.JButton();
        PanelSuperiorPro = new javax.swing.JPanel();
        LabelSuperiorPro = new javax.swing.JLabel();
        btnSaida = new java.awt.Label();
        btnMinimiza = new java.awt.Label();
        TabInicialPro = new javax.swing.JTabbedPane();
        PanelPri = new javax.swing.JPanel();
        PanelPriPro = new javax.swing.JPanel();
        PanelPriDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        textPaBu = new javax.swing.JLabel();
        PanelPriEngadir = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        PanelPriDatosPro = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        PanelChau = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        PanelSeg = new javax.swing.JPanel();
        PanelInfoLo = new javax.swing.JPanel();
        PanelInfoCarta = new javax.swing.JPanel();
        LabelInfoCarta = new javax.swing.JLabel();
        BotonBuscarCarta = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        ComboEstacion = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        LabelInfoCalCarta = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ComboTipoBebidas = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ComboIngrediente = new javax.swing.JComboBox<>();
        ComboPrato = new javax.swing.JComboBox<>();
        BotonSaveCartPro = new javax.swing.JButton();
        ComboCarta = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        TextIdLocalCarta = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TextCarta = new javax.swing.JTextField();
        BuscaBebida = new javax.swing.JButton();
        ComboProdutoBebidas = new javax.swing.JComboBox<>();
        BotonGardarCarta = new javax.swing.JButton();
        ComboMarcas = new javax.swing.JComboBox<>();
        BotonBuscarMarca = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        TextIdPrezoVenda = new javax.swing.JTextField();
        ComboEspecialidade = new javax.swing.JComboBox<>();
        ComboEncargo = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        BuscaPrato = new javax.swing.JButton();
        PanelTer = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        TextNomeLocal = new javax.swing.JTextField();
        TextRuaLocal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        TextTelfLocal = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        TextNumLocal = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TextEmailLocal = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        ComboConcelloLocal = new javax.swing.JComboBox<>();
        ComboTipoLocal = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        BotonGardarLocal = new javax.swing.JButton();
        BotonActualizarLocal = new javax.swing.JButton();
        BotonBuscar = new javax.swing.JButton();
        BotonEliminarLocal = new javax.swing.JButton();
        ComboEspecialidadeLocal = new javax.swing.JComboBox<>();
        TextPropietario = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        PanelCuar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        TextEmail = new javax.swing.JTextField();
        TextTelf = new javax.swing.JTextField();
        TextNum = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        ComboConcello = new javax.swing.JComboBox<>();
        TextRua = new javax.swing.JTextField();
        TextApelido2 = new javax.swing.JTextField();
        TextApelido = new javax.swing.JTextField();
        TextNome = new javax.swing.JTextField();
        BotonLimpar = new javax.swing.JButton();
        BotonActualizar1 = new javax.swing.JButton();
        BotonBorrar = new javax.swing.JButton();
        BotonBuscar1 = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        PanelCin = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BgPropietario.setBackground(new java.awt.Color(201, 219, 255));
        BgPropietario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelLateralPro.setBackground(new java.awt.Color(219, 243, 255));
        PanelLateralPro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelconectado.setText("CONECTADO");
        PanelLateralPro.add(labelconectado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 87, -1));

        labelIconoConec.setText("jLabel3");
        PanelLateralPro.add(labelIconoConec, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 30, 20));
        PanelLateralPro.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 260, 10));

        PanelFixoInicio.setBackground(new java.awt.Color(255, 255, 255));
        PanelFixoInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelFixoInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelFixoInicioMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelFixoInicioMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelFixoInicioMouseExited(evt);
            }
        });

        PanelInicioLocal.setBackground(new java.awt.Color(0, 72, 193));
        PanelInicioLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PanelInicioLocal.setForeground(new java.awt.Color(0, 72, 193));
        PanelInicioLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PanelInicioLocal.setText("INICIO");
        PanelInicioLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelInicioLocalMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelInicioLocalMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelInicioLocalMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelFixoInicioLayout = new javax.swing.GroupLayout(PanelFixoInicio);
        PanelFixoInicio.setLayout(PanelFixoInicioLayout);
        PanelFixoInicioLayout.setHorizontalGroup(
                PanelFixoInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelFixoInicioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PanelInicioLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addContainerGap())
        );
        PanelFixoInicioLayout.setVerticalGroup(
                PanelFixoInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelFixoInicioLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PanelInicioLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                .addContainerGap())
        );

        PanelLateralPro.add(PanelFixoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 240, 60));

        PanelDatosLocal.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatosLocal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelDatosLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelDatosLocalMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelDatosLocalMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelDatosLocalMouseExited(evt);
            }
        });

        LabelDatosLocal.setBackground(new java.awt.Color(0, 72, 193));
        LabelDatosLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelDatosLocal.setForeground(new java.awt.Color(0, 72, 193));
        LabelDatosLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDatosLocal.setText("CREAR CARTA");
        LabelDatosLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelDatosLocalMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelDatosLocalMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabelDatosLocalMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelDatosLocalLayout = new javax.swing.GroupLayout(PanelDatosLocal);
        PanelDatosLocal.setLayout(PanelDatosLocalLayout);
        PanelDatosLocalLayout.setHorizontalGroup(
                PanelDatosLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosLocalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelDatosLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        );
        PanelDatosLocalLayout.setVerticalGroup(
                PanelDatosLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelDatosLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        PanelLateralPro.add(PanelDatosLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 240, 60));

        PanelEngadeLocal.setBackground(new java.awt.Color(255, 255, 255));
        PanelEngadeLocal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelEngadeLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelEngadeLocalMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelEngadeLocalMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelEngadeLocalMouseExited(evt);
            }
        });

        LabeLEngadeLocal.setBackground(new java.awt.Color(0, 72, 193));
        LabeLEngadeLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabeLEngadeLocal.setForeground(new java.awt.Color(0, 72, 193));
        LabeLEngadeLocal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabeLEngadeLocal.setText("ENGADIR LOCAL");
        LabeLEngadeLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabeLEngadeLocalMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabeLEngadeLocalMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabeLEngadeLocalMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelEngadeLocalLayout = new javax.swing.GroupLayout(PanelEngadeLocal);
        PanelEngadeLocal.setLayout(PanelEngadeLocalLayout);
        PanelEngadeLocalLayout.setHorizontalGroup(
                PanelEngadeLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEngadeLocalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabeLEngadeLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addContainerGap())
        );
        PanelEngadeLocalLayout.setVerticalGroup(
                PanelEngadeLocalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabeLEngadeLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        PanelLateralPro.add(PanelEngadeLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 240, 60));

        PanelDatosPro.setBackground(new java.awt.Color(255, 255, 255));
        PanelDatosPro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelDatosPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelDatosProMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelDatosProMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelDatosProMouseExited(evt);
            }
        });

        LabelDatosPro.setBackground(new java.awt.Color(0, 72, 193));
        LabelDatosPro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelDatosPro.setForeground(new java.awt.Color(0, 72, 193));
        LabelDatosPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelDatosPro.setText("OS MEUS DATOS");
        LabelDatosPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelDatosProMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelDatosProMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabelDatosProMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelDatosProLayout = new javax.swing.GroupLayout(PanelDatosPro);
        PanelDatosPro.setLayout(PanelDatosProLayout);
        PanelDatosProLayout.setHorizontalGroup(
                PanelDatosProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDatosProLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelDatosPro, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addContainerGap())
        );
        PanelDatosProLayout.setVerticalGroup(
                PanelDatosProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelDatosPro, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        PanelLateralPro.add(PanelDatosPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 240, 60));

        PanelMarchoPro.setBackground(new java.awt.Color(255, 255, 255));
        PanelMarchoPro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelMarchoPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelMarchoProMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanelMarchoProMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanelMarchoProMouseExited(evt);
            }
        });

        LabelMarchoPro.setBackground(new java.awt.Color(0, 72, 193));
        LabelMarchoPro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LabelMarchoPro.setForeground(new java.awt.Color(0, 72, 193));
        LabelMarchoPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelMarchoPro.setText("VENHA, MARCHO");

        javax.swing.GroupLayout PanelMarchoProLayout = new javax.swing.GroupLayout(PanelMarchoPro);
        PanelMarchoPro.setLayout(PanelMarchoProLayout);
        PanelMarchoProLayout.setHorizontalGroup(
                PanelMarchoProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMarchoProLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelMarchoPro, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addContainerGap())
        );
        PanelMarchoProLayout.setVerticalGroup(
                PanelMarchoProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelMarchoPro, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        PanelLateralPro.add(PanelMarchoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 610, 240, -1));

        botonHelpPro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botonHelpPro.setForeground(new java.awt.Color(0, 72, 193));
        botonHelpPro.setText("Axuda");
        botonHelpPro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonHelpPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHelpProActionPerformed(evt);
            }
        });
        PanelLateralPro.add(botonHelpPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 120, 45));

        BgPropietario.add(PanelLateralPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, 270, 690));

        PanelSuperiorPro.setBackground(new java.awt.Color(0, 72, 193));
        PanelSuperiorPro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        PanelSuperiorPro.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelSuperiorProMouseDragged(evt);
            }
        });
        PanelSuperiorPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanelSuperiorProMousePressed(evt);
            }
        });

        LabelSuperiorPro.setBackground(new java.awt.Color(0, 72, 193));
        LabelSuperiorPro.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabelSuperiorPro.setForeground(new java.awt.Color(255, 255, 255));
        LabelSuperiorPro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelSuperiorPro.setText("O MEU LOCAL");

        btnSaida.setAlignment(java.awt.Label.CENTER);
        btnSaida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaida.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnSaida.setForeground(new java.awt.Color(204, 255, 255));
        btnSaida.setText("X");
        btnSaida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaidaMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaidaMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaidaMouseExited(evt);
            }
        });

        btnMinimiza.setAlignment(java.awt.Label.CENTER);
        btnMinimiza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimiza.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnMinimiza.setForeground(new java.awt.Color(204, 255, 255));
        btnMinimiza.setText("-");
        btnMinimiza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizaMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizaMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelSuperiorProLayout = new javax.swing.GroupLayout(PanelSuperiorPro);
        PanelSuperiorPro.setLayout(PanelSuperiorProLayout);
        PanelSuperiorProLayout.setHorizontalGroup(
                PanelSuperiorProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelSuperiorProLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMinimiza, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(LabelSuperiorPro, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(784, Short.MAX_VALUE))
        );
        PanelSuperiorProLayout.setVerticalGroup(
                PanelSuperiorProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelSuperiorProLayout.createSequentialGroup()
                                .addGroup(PanelSuperiorProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelSuperiorProLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(PanelSuperiorProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnMinimiza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(PanelSuperiorProLayout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(LabelSuperiorPro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(37, Short.MAX_VALUE))
        );

        BgPropietario.add(PanelSuperiorPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 110));

        PanelPri.setBackground(new java.awt.Color(255, 255, 255));

        PanelPriPro.setBackground(new java.awt.Color(219, 243, 255));

        PanelPriDatos.setBackground(new java.awt.Color(255, 255, 255));
        PanelPriDatos.setPreferredSize(new java.awt.Dimension(320, 275));

        jLabel1.setText("jLabel1");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 72, 193));
        jButton4.setText("CARTA");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        textPaBu.setText("jLabel2");

        javax.swing.GroupLayout PanelPriDatosLayout = new javax.swing.GroupLayout(PanelPriDatos);
        PanelPriDatos.setLayout(PanelPriDatosLayout);
        PanelPriDatosLayout.setHorizontalGroup(
                PanelPriDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPriDatosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addGroup(PanelPriDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelPriDatosLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelPriDatosLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(textPaBu, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        PanelPriDatosLayout.setVerticalGroup(
                PanelPriDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPriDatosLayout.createSequentialGroup()
                                .addGroup(PanelPriDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(PanelPriDatosLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(PanelPriDatosLayout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(textPaBu, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );

        PanelPriEngadir.setBackground(new java.awt.Color(255, 255, 255));
        PanelPriEngadir.setPreferredSize(new java.awt.Dimension(320, 275));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 72, 193));
        jButton1.setText("O MEU");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPriEngadirLayout = new javax.swing.GroupLayout(PanelPriEngadir);
        PanelPriEngadir.setLayout(PanelPriEngadirLayout);
        PanelPriEngadirLayout.setHorizontalGroup(
                PanelPriEngadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPriEngadirLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        PanelPriEngadirLayout.setVerticalGroup(
                PanelPriEngadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPriEngadirLayout.createSequentialGroup()
                                .addContainerGap(244, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        PanelPriDatosPro.setBackground(new java.awt.Color(255, 255, 255));
        PanelPriDatosPro.setPreferredSize(new java.awt.Dimension(320, 275));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 72, 193));
        jButton3.setText("LOCAL");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPriDatosProLayout = new javax.swing.GroupLayout(PanelPriDatosPro);
        PanelPriDatosPro.setLayout(PanelPriDatosProLayout);
        PanelPriDatosProLayout.setHorizontalGroup(
                PanelPriDatosProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPriDatosProLayout.createSequentialGroup()
                                .addContainerGap(220, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        PanelPriDatosProLayout.setVerticalGroup(
                PanelPriDatosProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPriDatosProLayout.createSequentialGroup()
                                .addContainerGap(264, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        PanelChau.setBackground(new java.awt.Color(255, 255, 255));
        PanelChau.setPreferredSize(new java.awt.Dimension(320, 275));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 72, 193));
        jButton2.setText("IR INDO");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelChauLayout = new javax.swing.GroupLayout(PanelChau);
        PanelChau.setLayout(PanelChauLayout);
        PanelChauLayout.setHorizontalGroup(
                PanelChauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelChauLayout.createSequentialGroup()
                                .addContainerGap(220, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        PanelChauLayout.setVerticalGroup(
                PanelChauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelChauLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout PanelPriProLayout = new javax.swing.GroupLayout(PanelPriPro);
        PanelPriPro.setLayout(PanelPriProLayout);
        PanelPriProLayout.setHorizontalGroup(
                PanelPriProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPriProLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(PanelPriProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PanelPriDatosPro, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PanelPriDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                                .addGroup(PanelPriProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PanelChau, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                        .addComponent(PanelPriEngadir, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                                .addGap(73, 73, 73))
        );
        PanelPriProLayout.setVerticalGroup(
                PanelPriProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPriProLayout.createSequentialGroup()
                                .addContainerGap(30, Short.MAX_VALUE)
                                .addGroup(PanelPriProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PanelPriEngadir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PanelPriDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelPriProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PanelPriDatosPro, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                        .addComponent(PanelChau, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout PanelPriLayout = new javax.swing.GroupLayout(PanelPri);
        PanelPri.setLayout(PanelPriLayout);
        PanelPriLayout.setHorizontalGroup(
                PanelPriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPriLayout.createSequentialGroup()
                                .addComponent(PanelPriPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelPriLayout.setVerticalGroup(
                PanelPriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPriLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(PanelPriPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabInicialPro.addTab("tab1", PanelPri);

        PanelSeg.setBackground(new java.awt.Color(255, 255, 255));
        PanelSeg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PanelInfoLoLayout = new javax.swing.GroupLayout(PanelInfoLo);
        PanelInfoLo.setLayout(PanelInfoLoLayout);
        PanelInfoLoLayout.setHorizontalGroup(
                PanelInfoLoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        PanelInfoLoLayout.setVerticalGroup(
                PanelInfoLoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        PanelSeg.add(PanelInfoLo, new org.netbeans.lib.awtextra.AbsoluteConstraints(928, 149, -1, 553));

        LabelInfoCarta.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        LabelInfoCarta.setForeground(new java.awt.Color(0, 72, 193));
        LabelInfoCarta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelInfoCarta.setText("<html> <body> AGORA PROBA ISTO  <br> CREA UNHA CARTA, DE COMIDAS OU BEBIDAS <br> E DESPOIS ENGÁDELLE OS PRODUCTOS </body ></html>");
        LabelInfoCarta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        javax.swing.GroupLayout PanelInfoCartaLayout = new javax.swing.GroupLayout(PanelInfoCarta);
        PanelInfoCarta.setLayout(PanelInfoCartaLayout);
        PanelInfoCartaLayout.setHorizontalGroup(
                PanelInfoCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelInfoCartaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelInfoCarta, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addContainerGap())
        );
        PanelInfoCartaLayout.setVerticalGroup(
                PanelInfoCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelInfoCartaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelInfoCarta, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addContainerGap())
        );

        PanelSeg.add(PanelInfoCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 280, 70));

        BotonBuscarCarta.setText("BUSCAR");
        BotonBuscarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarCartaActionPerformed(evt);
            }
        });
        PanelSeg.add(BotonBuscarCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 70, 130, 30));
        PanelSeg.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        PanelSeg.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 860, 0));
        PanelSeg.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 152, 860, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 72, 193));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ID LOCAL");
        jLabel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));
        PanelSeg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 190, 30));

        ComboEstacion.setBackground(new java.awt.Color(0, 72, 193));
        ComboEstacion.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEstacionActionPerformed(evt);
            }
        });
        PanelSeg.add(ComboEstacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 210, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        PanelSeg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        LabelInfoCalCarta.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        LabelInfoCalCarta.setForeground(new java.awt.Color(0, 72, 193));
        LabelInfoCalCarta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelInfoCalCarta.setText("<html>\n<body>\nVALE, AGORA ISTO VAI IR ASÍ\n <br>\nELIXE UNHA DAS CARTAS QUE CREACHES\n<br>\nENGADE OS PRODUCTOS, LISTO\n</body\n></html>");
        LabelInfoCalCarta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelInfoCalCarta, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LabelInfoCalCarta, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                .addContainerGap())
        );

        PanelSeg.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 280, 70));

        jLabel7.setText("PRODUCTO");
        PanelSeg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 70, 20));
        PanelSeg.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));
        PanelSeg.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 80, 10));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 72, 193));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CAL CARTA ");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));
        PanelSeg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 190, 30));

        jLabel10.setText("TIPO DE BEBIDA");
        PanelSeg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 360, 90, 30));

        ComboTipoBebidas.setBackground(new java.awt.Color(0, 72, 193));
        ComboTipoBebidas.setForeground(new java.awt.Color(219, 243, 255));
        PanelSeg.add(ComboTipoBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 310, 30));

        jButton7.setText("BORRAR");
        PanelSeg.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 600, 110, 30));

        jLabel11.setText("PREZO VENDA");
        PanelSeg.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 110, 20));

        jLabel12.setText("FILTRAR POR INGREDIENTE");
        PanelSeg.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 150, 20));

        ComboIngrediente.setBackground(new java.awt.Color(0, 72, 193));
        ComboIngrediente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ComboIngrediente.setForeground(new java.awt.Color(219, 243, 255));
        ComboIngrediente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        PanelSeg.add(ComboIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 300, 30));

        ComboPrato.setBackground(new java.awt.Color(0, 72, 193));
        ComboPrato.setForeground(new java.awt.Color(219, 243, 255));
        PanelSeg.add(ComboPrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 300, 30));

        BotonSaveCartPro.setText("GARDAR");
        BotonSaveCartPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSaveCartProActionPerformed(evt);
            }
        });
        PanelSeg.add(BotonSaveCartPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 130, 30));

        ComboCarta.setBackground(new java.awt.Color(0, 72, 193));
        ComboCarta.setForeground(new java.awt.Color(255, 255, 255));
        ComboCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCartaActionPerformed(evt);
            }
        });
        PanelSeg.add(ComboCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 210, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 72, 193));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("ESTACION ");
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));
        PanelSeg.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 190, 30));

        TextIdLocalCarta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextIdLocalCarta.setForeground(new java.awt.Color(0, 72, 193));
        TextIdLocalCarta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextIdLocalCarta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));
        PanelSeg.add(TextIdLocalCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 210, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 72, 193));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("NOME CARTA");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));
        PanelSeg.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 190, 30));

        TextCarta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextCarta.setForeground(new java.awt.Color(0, 72, 193));
        TextCarta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextCarta.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));
        PanelSeg.add(TextCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 210, 30));

        BuscaBebida.setBackground(new java.awt.Color(255, 255, 255));
        BuscaBebida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BuscaBebida.setForeground(new java.awt.Color(0, 72, 193));
        BuscaBebida.setText("BUSCA BEBIDA");
        BuscaBebida.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));
        BuscaBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaBebidaActionPerformed(evt);
            }
        });
        PanelSeg.add(BuscaBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 120, 30));

        ComboProdutoBebidas.setBackground(new java.awt.Color(0, 72, 193));
        ComboProdutoBebidas.setForeground(new java.awt.Color(219, 243, 255));
        PanelSeg.add(ComboProdutoBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 310, 30));

        BotonGardarCarta.setText("GARDAR");
        BotonGardarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGardarCartaActionPerformed(evt);
            }
        });
        PanelSeg.add(BotonGardarCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 130, 30));

        ComboMarcas.setBackground(new java.awt.Color(0, 72, 193));
        ComboMarcas.setForeground(new java.awt.Color(219, 243, 255));
        PanelSeg.add(ComboMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 310, 30));

        BotonBuscarMarca.setBackground(new java.awt.Color(255, 255, 255));
        BotonBuscarMarca.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonBuscarMarca.setForeground(new java.awt.Color(0, 72, 193));
        BotonBuscarMarca.setText("BUSCA MARCA");
        BotonBuscarMarca.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));
        BotonBuscarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarMarcaActionPerformed(evt);
            }
        });
        PanelSeg.add(BotonBuscarMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 330, 120, 30));

        jLabel27.setText("ESPECIALIDADE");
        PanelSeg.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 120, 20));

        TextIdPrezoVenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextIdPrezoVenda.setForeground(new java.awt.Color(0, 72, 193));
        TextIdPrezoVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextIdPrezoVenda.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));
        PanelSeg.add(TextIdPrezoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 90, 30));

        ComboEspecialidade.setBackground(new java.awt.Color(0, 72, 193));
        ComboEspecialidade.setForeground(new java.awt.Color(219, 243, 255));
        ComboEspecialidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        PanelSeg.add(ComboEspecialidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 130, 30));

        ComboEncargo.setBackground(new java.awt.Color(0, 72, 193));
        ComboEncargo.setForeground(new java.awt.Color(219, 243, 255));
        PanelSeg.add(ComboEncargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 130, 30));

        jLabel28.setText("BUSCAR MARCA");
        PanelSeg.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 510, 130, 20));

        jLabel29.setText("ENCARGO");
        PanelSeg.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 510, 90, 20));

        jLabel30.setText("BUSCAR PRATO");
        PanelSeg.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 140, 20));

        jLabel31.setText("BUSCAR BEBIDA");
        PanelSeg.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 140, 20));

        BuscaPrato.setBackground(new java.awt.Color(255, 255, 255));
        BuscaPrato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BuscaPrato.setForeground(new java.awt.Color(0, 72, 193));
        BuscaPrato.setText("PRATO");
        BuscaPrato.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));
        BuscaPrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaPratoActionPerformed(evt);
            }
        });
        PanelSeg.add(BuscaPrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 300, 30));

        TabInicialPro.addTab("tab2", PanelSeg);

        PanelTer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 72, 193));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("NOME LOCAL");
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextNomeLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextNomeLocal.setForeground(new java.awt.Color(0, 72, 193));
        TextNomeLocal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextNomeLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextRuaLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextRuaLocal.setForeground(new java.awt.Color(0, 72, 193));
        TextRuaLocal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextRuaLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 72, 193));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("RUA");
        jLabel20.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 72, 193));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("CONCELLO");
        jLabel21.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextTelfLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextTelfLocal.setForeground(new java.awt.Color(0, 72, 193));
        TextTelfLocal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextTelfLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 72, 193));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("TELEFONO");
        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 72, 193));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("NUMERO");
        jLabel23.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextNumLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextNumLocal.setForeground(new java.awt.Color(0, 72, 193));
        TextNumLocal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextNumLocal.setAlignmentX(0.0F);
        TextNumLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 72, 193));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("ESPECIALIDADE");
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 72, 193));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("EMAIL");
        jLabel25.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextEmailLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextEmailLocal.setForeground(new java.awt.Color(0, 72, 193));
        TextEmailLocal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextEmailLocal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel2.setText("NOME E DONO");

        jLabel13.setText("DIRECCION E CONTACTO");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 72, 193));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("TIPO LOCAL");
        jLabel26.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        ComboConcelloLocal.setBackground(new java.awt.Color(0, 72, 193));
        ComboConcelloLocal.setForeground(new java.awt.Color(255, 255, 255));

        ComboTipoLocal.setBackground(new java.awt.Color(0, 72, 193));
        ComboTipoLocal.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 72, 193));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("<html>\n<body>\nVAMOS PASIÑO PASENIÑO A PASIÑO PASENIÑO. \n <br>\n PRIMEIRO INTRODUCE OS DATOS BÁSICOS PARA \n<br>\nRELACIONAR O TEU LOCAL CONTGO\n</body\n></html>");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 72, 193));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("<html>\n<body>\nAGORA QUÉ VEN?\n <br>\nPOIS DEIXAR OS DATOS DE CONTACTO E UBICACION\n<br>\nFIXATE BEN XA QUE TAMEN O VERAN NOS RESULTADOS\n<br>\nDAS BUSQUEDAS. TODOS OS CAMPOS SON OBLIGATORIOS\n<br>\nSE O TEU LOCAL TEN ALGUNHA ESPECIALIDADE, ENGADEA.\n</body\n></html>");
        jLabel17.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 72, 193));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("<html> <body>  VEÑA, XA QUEDA POUCO   <br> SIMPLEMENTE ENGADE DE QUE TIPO É O TEU LOCAL E ALE <br> A CORRER <br> SE TES CARTA E A QUERES ENGADIR TAMEN PODES, FAINO </body> </html>");
        jLabel18.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        BotonGardarLocal.setBackground(new java.awt.Color(204, 255, 255));
        BotonGardarLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonGardarLocal.setForeground(new java.awt.Color(0, 72, 193));
        BotonGardarLocal.setText("GARDAR");
        BotonGardarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGardarLocalActionPerformed(evt);
            }
        });

        BotonActualizarLocal.setBackground(new java.awt.Color(204, 255, 255));
        BotonActualizarLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonActualizarLocal.setForeground(new java.awt.Color(0, 72, 193));
        BotonActualizarLocal.setText("ACTUALIZAR");
        BotonActualizarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarLocalActionPerformed(evt);
            }
        });

        BotonBuscar.setBackground(new java.awt.Color(204, 255, 255));
        BotonBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonBuscar.setForeground(new java.awt.Color(0, 72, 193));
        BotonBuscar.setText("BUSCAR");
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });

        BotonEliminarLocal.setBackground(new java.awt.Color(204, 255, 255));
        BotonEliminarLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonEliminarLocal.setForeground(new java.awt.Color(0, 72, 193));
        BotonEliminarLocal.setText("ELIMINAR");
        BotonEliminarLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarLocalActionPerformed(evt);
            }
        });

        ComboEspecialidadeLocal.setBackground(new java.awt.Color(0, 72, 193));
        ComboEspecialidadeLocal.setForeground(new java.awt.Color(255, 255, 255));

        TextPropietario.setEditable(false);
        TextPropietario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextPropietario.setForeground(new java.awt.Color(0, 72, 193));
        TextPropietario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextPropietario.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 72, 193));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("ID LOCAL");
        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        javax.swing.GroupLayout PanelTerLayout = new javax.swing.GroupLayout(PanelTer);
        PanelTer.setLayout(PanelTerLayout);
        PanelTerLayout.setHorizontalGroup(
                PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTerLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(TextNomeLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTerLayout.createSequentialGroup()
                                                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(TextPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelTerLayout.createSequentialGroup()
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                                        .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(TextEmailLocal)
                                                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                                                .addComponent(TextNumLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(TextTelfLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(TextRuaLocal)
                                                                        .addComponent(ComboConcelloLocal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(ComboEspecialidadeLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelTerLayout.createSequentialGroup()
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(BotonGardarLocal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ComboTipoLocal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(BotonActualizarLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(30, 30, 30)
                                                                                .addComponent(BotonEliminarLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(18, 18, 18)
                                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(BotonBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                                                        .addComponent(jLabel18))))
                                .addGap(0, 19, Short.MAX_VALUE))
        );
        PanelTerLayout.setVerticalGroup(
                PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTerLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(TextPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(TextNomeLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(10, 10, 10)
                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                                .addGap(7, 7, 7)
                                                                .addComponent(jLabel13)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(ComboConcelloLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(TextRuaLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(TextNumLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(TextTelfLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(TextEmailLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(ComboEspecialidadeLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                                .addGap(75, 75, 75)
                                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(BotonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelTerLayout.createSequentialGroup()
                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ComboTipoLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(PanelTerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(BotonEliminarLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BotonActualizarLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(BotonGardarLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(105, Short.MAX_VALUE))
        );

        jLabel14.getAccessibleContext().setAccessibleName("VAMOS PASIÑO PASENIÑO A PASIÑO PASENIÑO. \n");

        TabInicialPro.addTab("tab3", PanelTer);

        PanelCuar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 72, 193));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("NOME");
        jLabel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 72, 193));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("APELIDO1");
        jLabel32.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 72, 193));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("APELIDO2");
        jLabel33.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 72, 193));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("RUA");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 72, 193));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("CONCELLO");
        jLabel34.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 72, 193));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("TELEFONO");
        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 72, 193));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("EMAIL");
        jLabel36.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextEmail.setForeground(new java.awt.Color(0, 72, 193));
        TextEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextTelf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextTelf.setForeground(new java.awt.Color(0, 72, 193));
        TextTelf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextTelf.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextNum.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextNum.setForeground(new java.awt.Color(0, 72, 193));
        TextNum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextNum.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 72, 193));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Nº");
        jLabel38.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        ComboConcello.setBackground(new java.awt.Color(0, 72, 193));
        ComboConcello.setForeground(new java.awt.Color(255, 255, 255));

        TextRua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextRua.setForeground(new java.awt.Color(0, 72, 193));
        TextRua.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextRua.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextApelido2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextApelido2.setForeground(new java.awt.Color(0, 72, 193));
        TextApelido2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextApelido2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextApelido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextApelido.setForeground(new java.awt.Color(0, 72, 193));
        TextApelido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextApelido.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        TextNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TextNome.setForeground(new java.awt.Color(0, 72, 193));
        TextNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TextNome.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        BotonLimpar.setBackground(new java.awt.Color(102, 102, 255));
        BotonLimpar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BotonLimpar.setForeground(new java.awt.Color(255, 255, 255));
        BotonLimpar.setText("LIMPAR");
        BotonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLimparActionPerformed(evt);
            }
        });

        BotonActualizar1.setBackground(new java.awt.Color(102, 102, 255));
        BotonActualizar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BotonActualizar1.setForeground(new java.awt.Color(255, 255, 255));
        BotonActualizar1.setText("ACTUALIZAR");
        BotonActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizar1ActionPerformed(evt);
            }
        });

        BotonBorrar.setBackground(new java.awt.Color(102, 102, 255));
        BotonBorrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BotonBorrar.setForeground(new java.awt.Color(255, 255, 255));
        BotonBorrar.setText("BORRAR");
        BotonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarActionPerformed(evt);
            }
        });

        BotonBuscar1.setText("BUSCAR");
        BotonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscar1ActionPerformed(evt);
            }
        });

        jSeparator11.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 72, 193));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("<html>\n<body>\nAGORA QUÉ VEN?\n <br>\nPOIS DEIXAR OS DATOS DE CONTACTO E UBICACION\n<br>\nFIXATE BEN XA QUE TAMEN O VERAN NOS RESULTADOS\n<br>\nDAS BUSQUEDAS. TODOS OS CAMPOS SON OBLIGATORIOS\n<br>\nSE O TEU LOCAL TEN ALGUNHA ESPECIALIDADE, ENGADEA.\n</body\n></html>");
        jLabel39.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 72, 193)));

        javax.swing.GroupLayout PanelCuarLayout = new javax.swing.GroupLayout(PanelCuar);
        PanelCuar.setLayout(PanelCuarLayout);
        PanelCuarLayout.setHorizontalGroup(
                PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                                                .addGap(77, 77, 77)
                                                                .addComponent(BotonBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(ComboConcello, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(TextNum, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(TextTelf, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                                .addComponent(BotonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(BotonActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(BotonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(TextApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(TextApelido2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(TextRua, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34)
                                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                .addGap(33, 33, 33))
        );
        PanelCuarLayout.setVerticalGroup(
                PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelCuarLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(BotonBuscar1)
                                .addGap(27, 27, 27)
                                .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(PanelCuarLayout.createSequentialGroup()
                                                        .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TextApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TextApelido2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TextRua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(ComboConcello, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TextNum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TextTelf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(20, 20, 20)
                                                        .addGroup(PanelCuarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(BotonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(BotonActualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(BotonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(jSeparator11)))
                                .addContainerGap(138, Short.MAX_VALUE))
        );

        TabInicialPro.addTab("tab4", PanelCuar);

        PanelCin.setBackground(new java.awt.Color(102, 51, 255));

        javax.swing.GroupLayout PanelCinLayout = new javax.swing.GroupLayout(PanelCin);
        PanelCin.setLayout(PanelCinLayout);
        PanelCinLayout.setHorizontalGroup(
                PanelCinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 925, Short.MAX_VALUE)
        );
        PanelCinLayout.setVerticalGroup(
                PanelCinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 702, Short.MAX_VALUE)
        );

        TabInicialPro.addTab("tab5", PanelCin);

        BgPropietario.add(TabInicialPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 930, 730));

        getContentPane().add(BgPropietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        TabInicialPro.setSelectedIndex(1);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TabInicialPro.setSelectedIndex(2);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        TabInicialPro.setSelectedIndex(3);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        TabInicialPro.setSelectedIndex(4);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void PanelInicioLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelInicioLocalMouseClicked
        TabInicialPro.setSelectedIndex(0);
    }//GEN-LAST:event_PanelInicioLocalMouseClicked

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void PanelDatosLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDatosLocalMouseClicked
        TabInicialPro.setSelectedIndex(1);
    }//GEN-LAST:event_PanelDatosLocalMouseClicked

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void PanelEngadeLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelEngadeLocalMouseClicked
        TabInicialPro.setSelectedIndex(3);
    }//GEN-LAST:event_PanelEngadeLocalMouseClicked

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void PanelDatosProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDatosProMouseClicked
        TabInicialPro.setSelectedIndex(2);
    }//GEN-LAST:event_PanelDatosProMouseClicked

    /**
     * Mï¿½todo para abrir a Xanela1 e pechar esta
     *
     * @param evt
     */
    private void PanelMarchoProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMarchoProMouseClicked

        Xanela1 xanela1 = new Xanela1();
        xanela1.setVisible(true);
        this.setVisible(false);
        //  TabInicialPro.setSelectedIndex(4);
        //   System.exit(0);
    }//GEN-LAST:event_PanelMarchoProMouseClicked

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void LabelDatosLocalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelDatosLocalMouseEntered
        PanelDatosLocal.setBackground(new Color(0, 72, 193));
        LabelDatosLocal.setForeground(Color.white);
    }//GEN-LAST:event_LabelDatosLocalMouseEntered

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelEngadeLocalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelEngadeLocalMouseEntered
        PanelEngadeLocal.setBackground(new Color(0, 72, 193));
        LabeLEngadeLocal.setForeground(Color.white);
    }//GEN-LAST:event_PanelEngadeLocalMouseEntered

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelDatosProMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDatosProMouseEntered
        PanelDatosPro.setBackground(new Color(0, 72, 193));
        LabelDatosPro.setForeground(Color.white);
    }//GEN-LAST:event_PanelDatosProMouseEntered

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelMarchoProMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMarchoProMouseEntered
        PanelMarchoPro.setBackground(new Color(0, 72, 193));
        LabelMarchoPro.setForeground(Color.white);
    }//GEN-LAST:event_PanelMarchoProMouseEntered

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelFixoInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFixoInicioMouseEntered
        PanelFixoInicio.setBackground(new Color(0, 72, 193));
        PanelInicioLocal.setForeground(Color.white);
    }//GEN-LAST:event_PanelFixoInicioMouseEntered

    private void PanelFixoInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFixoInicioMouseClicked
        TabInicialPro.setSelectedIndex(0);
    }//GEN-LAST:event_PanelFixoInicioMouseClicked

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelFixoInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFixoInicioMouseExited
        PanelInicioLocal.setForeground(new Color(0, 72, 193));
        PanelFixoInicio.setBackground(Color.white);
    }//GEN-LAST:event_PanelFixoInicioMouseExited

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelDatosLocalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDatosLocalMouseExited
        PanelDatosLocal.setBackground(Color.white);
        LabelDatosLocal.setForeground(new Color(0, 72, 193));
    }//GEN-LAST:event_PanelDatosLocalMouseExited

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelDatosLocalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDatosLocalMouseEntered
        PanelDatosLocal.setBackground(new Color(0, 72, 193));
        LabelDatosLocal.setForeground(Color.white);
    }//GEN-LAST:event_PanelDatosLocalMouseEntered

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelEngadeLocalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelEngadeLocalMouseExited
        PanelEngadeLocal.setBackground(Color.white);
        LabeLEngadeLocal.setForeground(new Color(0, 72, 193));
    }//GEN-LAST:event_PanelEngadeLocalMouseExited

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelDatosProMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelDatosProMouseExited
        PanelDatosPro.setBackground(Color.white);
        LabelDatosPro.setForeground(new Color(0, 72, 193));
    }//GEN-LAST:event_PanelDatosProMouseExited

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelMarchoProMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMarchoProMouseExited
        PanelMarchoPro.setBackground(Color.white);
        LabelMarchoPro.setForeground(new Color(0, 72, 193));
    }//GEN-LAST:event_PanelMarchoProMouseExited

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void LabelDatosLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelDatosLocalMouseClicked
        TabInicialPro.setSelectedIndex(1);

    }//GEN-LAST:event_LabelDatosLocalMouseClicked

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void LabeLEngadeLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabeLEngadeLocalMouseClicked
        TabInicialPro.setSelectedIndex(2);
    }//GEN-LAST:event_LabeLEngadeLocalMouseClicked

    /**
     * Mï¿½todo para navegar polos paneles do JFrame
     *
     * @param evt
     */
    private void LabelDatosProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelDatosProMouseClicked
        TabInicialPro.setSelectedIndex(3);
    }//GEN-LAST:event_LabelDatosProMouseClicked

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelInicioLocalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelInicioLocalMouseEntered
        PanelFixoInicio.setBackground(new Color(0, 72, 193));
        PanelInicioLocal.setForeground(Color.white);

    }//GEN-LAST:event_PanelInicioLocalMouseEntered

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void PanelInicioLocalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelInicioLocalMouseExited
        PanelFixoInicio.setBackground(Color.white);
        PanelInicioLocal.setForeground(new Color(0, 72, 193));

    }//GEN-LAST:event_PanelInicioLocalMouseExited

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void LabeLEngadeLocalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabeLEngadeLocalMouseEntered
        PanelEngadeLocal.setBackground(new Color(0, 72, 193));
        LabeLEngadeLocal.setForeground(Color.white);
    }//GEN-LAST:event_LabeLEngadeLocalMouseEntered

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void LabeLEngadeLocalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabeLEngadeLocalMouseExited
        PanelEngadeLocal.setBackground(Color.white);
        LabeLEngadeLocal.setForeground(new Color(0, 72, 193));
    }//GEN-LAST:event_LabeLEngadeLocalMouseExited

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void LabelDatosProMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelDatosProMouseEntered
        PanelDatosPro.setBackground(new Color(0, 72, 193));
        LabelDatosPro.setForeground(Color.white);
    }//GEN-LAST:event_LabelDatosProMouseEntered

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void LabelDatosProMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelDatosProMouseExited
        PanelDatosPro.setBackground(Color.white);
        LabelDatosPro.setForeground(new Color(0, 72, 193));
    }//GEN-LAST:event_LabelDatosProMouseExited

    /**
     * Mï¿½todo para dar cor ao elemento definido
     *
     * @param evt
     */
    private void LabelDatosLocalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelDatosLocalMouseExited
        PanelDatosLocal.setBackground(Color.white);
        LabelDatosLocal.setForeground(new Color(0, 72, 193));
    }//GEN-LAST:event_LabelDatosLocalMouseExited

    private void ComboEstacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEstacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboEstacionActionPerformed

    private void ComboCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCartaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboCartaActionPerformed

    /**
     * Mï¿½todo para buscar carta na bbdd
     *
     * @param evt
     */
    private void BotonBuscarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarCartaActionPerformed

        int idLocal = Integer.parseInt(TextIdLocalCarta.getText());
        Local local = new Local();
        local.setIdLocal(idLocal);
        ComboCarta.removeAllItems();

        cartas = loxicaCarta.validarFindByIdLocal(local);
        if (!cartas.isEmpty()) {
            for (Carta card : cartas
            ) {
                ComboCarta.addItem(String.valueOf(card.getNome()));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario errï¿½neo",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarCartaActionPerformed


    /**
     * Mï¿½todo para buscar bebida por tipo bebida
     *
     * @param evt
     */
    private void BuscaBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaBebidaActionPerformed

        String nomeTipoBebida = String.valueOf(ComboTipoBebidas.getSelectedItem());
        String oTipo = "";
        ComboProdutoBebidas.removeAllItems();
        ComboMarcas.removeAllItems();

        tipoBebidas = loxicaTipoBebida.validarRead();
        if (!tipoBebidas.isEmpty()) {
            for (TipoBebida bebidaTipo : tipoBebidas
            ) {
                oTipo = String.valueOf(bebidaTipo.getNomeTipoBebida());
            }

            if (oTipo.equals(nomeTipoBebida)) ;
            {
                TipoBebida tipoBebida = new TipoBebida();
                tipoBebida.setNomeTipoBebida(nomeTipoBebida);

                produtos = loxicaProducto.validarFindIdTipoProdto(tipoBebida);
                if (!produtos.isEmpty()) {
                    for (Produto product : produtos
                    ) {
                        ComboProdutoBebidas.addItem(String.valueOf(product.getNome()));
                    }
                }
            }
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_BuscaBebidaActionPerformed


    /**
     * Mï¿½todo para control da interface na pantalla
     *
     * @param evt
     */
    private void PanelSuperiorProMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSuperiorProMouseDragged

        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
        // TODO add your handling code here:
    }//GEN-LAST:event_PanelSuperiorProMouseDragged


    /**
     * Botï¿½n para peche da aplicaciï¿½n
     *
     * @param evt
     */
    private void btnSaidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaidaMouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaidaMouseClicked

    /**
     * Mï¿½todo para variar cor dun elemento
     *
     * @param evt
     */
    private void btnSaidaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaidaMouseEntered

        btnSaida.setBackground(Color.red);
        btnSaida.setForeground(Color.WHITE);


        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaidaMouseEntered

    /**
     * Mï¿½todo para variar cor dun elemento
     *
     * @param evt
     */
    private void btnSaidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaidaMouseExited

        btnSaida.setBackground(new Color(0, 72, 193));
        btnSaida.setForeground(Color.WHITE);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaidaMouseExited

    /**
     * Mï¿½todo para control da interface na pantalla
     *
     * @param evt
     */
    private void PanelSuperiorProMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelSuperiorProMousePressed

        xMouse = evt.getX();
        yMouse = evt.getY();

        // TODO add your handling code here:
    }//GEN-LAST:event_PanelSuperiorProMousePressed

    /**
     * Mï¿½todo para gardar carta
     *
     * @param evt
     */
    private void BotonSaveCartProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSaveCartProActionPerformed

        Carta cartaBuscarNome = new Carta();
        cartaBuscarNome.setNome(String.valueOf(ComboCarta.getSelectedItem()));
        cartaBuscarNome.setIdCarta(loxicaCarta.validarBuscarPorNome(cartaBuscarNome).getIdCarta());
        int prezoProd = Integer.parseInt(TextIdPrezoVenda.getText());
        boolean encargoForm = false;
        boolean especialidadeForm = false;
        String nomeProductoComboBebida = String.valueOf(ComboProdutoBebidas.getSelectedItem());
        String nomeProductoComboPrato = String.valueOf(ComboPrato.getSelectedItem());
        String textComboEncargo = String.valueOf(ComboEncargo.getSelectedItem());
        String textComboEspecialidade = String.valueOf(ComboEspecialidade.getSelectedItem());

        if (textComboEncargo.equals("Si")) {
            encargoForm = true;
        } else if (textComboEncargo.isBlank() || textComboEncargo.equals("Non")) {
            encargoForm = false;
        }

        if (textComboEspecialidade.equals("Si")) {
            especialidadeForm = true;
        } else if (textComboEspecialidade.isBlank() || textComboEspecialidade.equals("Non")) {
            especialidadeForm = false;
        }

        Produto produto = new Produto();
        produtos = loxicaProducto.validarRead();
        for (Produto prod : produtos
        ) {
            if (prod.getNome().equals(nomeProductoComboBebida)) {
                produto.setId(prod.getId());
                //  break;
            } else if (prod.getNome().equals(nomeProductoComboPrato)) {
                produto.setId(prod.getId());
                // break;
            }
        }
        ProdutoCarta produtoCarta = new ProdutoCarta();
        produtoCarta.setCarta(cartaBuscarNome);
        produtoCarta.setProduto(produto);
        produtoCarta.setPrezo(prezoProd);
        produtoCarta.setEncargo(encargoForm);
        produtoCarta.setEspecialidade(especialidadeForm);

        LoxicaProdutoCarta loxicaProdutoCarta = new LoxicaProdutoCarta();
        loxicaProdutoCarta.validarCreate(produtoCarta);

        ComboEspecialidade.removeAllItems();
        ComboProdutoBebidas.removeAllItems();
        TextIdPrezoVenda.setText("");
        ComboEncargo.removeAllItems();
        ComboMarcas.removeAllItems();
        ComboPrato.removeAllItems();
        putIngredientCombo();
        putTipoBebidaCombo();
        putEncargo();
        putEspecialidade();
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonSaveCartProActionPerformed

    /**
     * Mï¿½todo para buscar Produtos e Marcas
     *
     * @param evt
     */
    private void BotonBuscarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarMarcaActionPerformed

        String nomeProdutoBebida = String.valueOf(ComboProdutoBebidas.getSelectedItem());
        String oProdutoSeleccionado = "";
        ComboMarcas.removeAllItems();

        produtos = loxicaProducto.validarRead();
        if (!produtos.isEmpty()) {
            for (Produto prodFor : produtos
            ) {
                oProdutoSeleccionado = String.valueOf(prodFor.getNome());
            }
            if (oProdutoSeleccionado.equals(nomeProdutoBebida)) ;
            {
                Produto bebida = new Bebida();
                bebida.setNome(nomeProdutoBebida);

                produtos = loxicaProducto.validarByName(bebida);
                if (!produtos.isEmpty()) {
                    for (Produto product : produtos
                    ) {
                        Bebida bebidabd = new Bebida();
                        bebidabd.setId(product.getId());

                        List<Bebida> bebidaList = new ArrayList<>();
                        bebidaList = loxicaBebida.validarFindByIdBebida(bebidabd);
                        if (!bebidaList.isEmpty()) {
                            for (Bebida bebidaFor : bebidaList) {
                                ComboMarcas.addItem(String.valueOf(bebidaFor.getFabricante()));
                            }
                        }
                    }
                }
            }
        }
    }


    // TODO add your handling code here:
//GEN-LAST:event_BotonBuscarMarcaActionPerformed

    /**
     * Mï¿½todo para limpar cadros de texto
     */
    private void clean() {
        TextPropietario.setText(null);
        TextNomeLocal.setText(null);
        ComboConcelloLocal.setSelectedIndex(0);
        TextRuaLocal.setText(null);
        TextNumLocal.setText(null);
        TextTelfLocal.setText(null);
        TextEmailLocal.setText(null);
    }

    /**
     * Mï¿½todo para limpar cadros de texto
     */
    private void cleanDatos() {
        TextNome.setText(null);
        TextApelido.setText(null);
        TextApelido2.setText(null);
        ComboConcello.setSelectedIndex(0);
        TextRua.setText(null);
        TextNum.setText(null);
        TextTelf.setText(null);
        TextEmail.setText(null);
        //ComboRol.setSelectedIndex(0);
    }

    /**
     * Mï¿½todo para crear un local e gardalo na bbdd
     *
     * @param evt
     */
    private void BotonGardarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGardarLocalActionPerformed
        Propietario usuarioLocal = new Propietario();
        usuarioLocal.setIdUsuario(Integer.parseInt(idPropietario));
        Local local = new Local();
        local.setNomeLocal(TextNomeLocal.getText());
        String concello = String.valueOf(ComboConcelloLocal.getSelectedItem());
        Concello council = new Concello();
        council.setNomeConcello(concello);
        local.setConcello(council);
        String especialidade = String.valueOf(ComboEspecialidadeLocal.getSelectedItem());
        local.setEspecialidade(especialidade);
        local.setRua(TextRuaLocal.getText());
        local.setNumero(Integer.parseInt(TextNumLocal.getText()));
        local.setTelefono(TextTelfLocal.getText());
        local.setEmail(TextEmailLocal.getText());
        loxicaLocal.validarCreate(local);

        LocalPropietario localPropietario = new LocalPropietario();
        localPropietario.setIdLocal(loxicaLocal.validarFindByIdMax(local));
        localPropietario.setIdPropietario(usuarioLocal);
        loxicaLocalPropietario.validarCreate(localPropietario);

        String valorTipoLocal = String.valueOf(ComboTipoLocal.getSelectedItem());
        String tipoLocalSeleccionado = "";
        TipoLocal tipoLocal = new TipoLocal();
        tipoLocal.setNomeTipo(String.valueOf(ComboTipoLocal.getSelectedItem()));
        List<TipoLocal> tipoLocalList = new ArrayList<>();
        tipoLocalList = loxicaTipoLocal.validarRead();
        if (!tipoLocalList.isEmpty()) {
            for (TipoLocal tipLocal : tipoLocalList
            ) {
                tipoLocalSeleccionado = String.valueOf(tipLocal.getNomeTipo());
                if (tipoLocalSeleccionado.equals(valorTipoLocal)) {
                    TipoLocal tipoLocalInsert = new TipoLocal();
                    tipoLocalInsert.setIdTipoLocal(loxicaTipoLocal.validarFindByName(tipLocal).getIdTipoLocal());

                    LocalTipoLocal localTipoLocal = new LocalTipoLocal();
                    localTipoLocal.setTipoLocal(tipoLocalInsert);
                    localTipoLocal.setLocal(loxicaLocal.validarFindByIdMax(local));

                    loxicaLocalTipoLocal.validarCreate(localTipoLocal);
                }
            }
        }

        clean();
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGardarLocalActionPerformed

    /**
     * Mï¿½todo para actualizar local
     *
     * @param evt
     */
    private void BotonActualizarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarLocalActionPerformed
        Local local = new Local();
        local.setNomeLocal(TextNomeLocal.getText());
        local.setRua(TextRuaLocal.getText());
        local.setNumero(Integer.parseInt(TextNumLocal.getText()));
        local.setTelefono(TextTelfLocal.getText());
        local.setEmail(TextEmailLocal.getText());
        loxicaLocal.validarUpdate(local);
        clean();


        // TODO add your handling code here:
    }//GEN-LAST:event_BotonActualizarLocalActionPerformed

    /**
     * Mï¿½todo para borrar local
     *
     * @param evt
     */
    private void BotonEliminarLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarLocalActionPerformed

        Local localBorra = new Local();
        localBorra.setNomeLocal(TextNomeLocal.getText());
        loxicaLocal.validarDelete(localBorra);

        // TODO add your handling code here:
    }//GEN-LAST:event_BotonEliminarLocalActionPerformed

    /**
     * Mï¿½todo para buscar local por nome
     *
     * @param evt
     */
    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed

        Local local = new Local();
        local.setNomeLocal(TextNomeLocal.getText());
        //local.setNomeLocal(loxicaLocal.validarFindByName(local).getNomeLocal());
        local.setRua(loxicaLocal.validarFindByName(local).getRua());
        local.setNumero(loxicaLocal.validarFindByName(local).getNumero());
        local.setTelefono(loxicaLocal.validarFindByName(local).getTelefono());
        local.setEmail(loxicaLocal.validarFindByName(local).getEmail());
        // TextNomeLocal.setText(local.getNomeLocal());
        TextPropietario.setText(String.valueOf(loxicaLocal.validarFindByName(local).getIdLocal()));
        TextRuaLocal.setText(local.getRua());
        TextNumLocal.setText(String.valueOf(local.getNumero()));
        TextTelfLocal.setText(local.getTelefono());
        TextEmailLocal.setText(local.getEmail());


        // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarActionPerformed

    /**
     * Mï¿½todo para realizar a actualizacion de usuario
     *
     * @param evt
     */
    private void BotonActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizar1ActionPerformed

        try {
            Usuario usuarioPro = new Propietario();
            usuarioPro.setIdUsuario(Integer.parseInt(idPropietario));
            usuarioPro.setNome(TextNome.getText());
            usuarioPro.setApelido1(TextApelido.getText());
            usuarioPro.setApelido2(TextApelido2.getText());
            usuarioPro.setRua(TextRua.getText());
            usuarioPro.setNumero(Integer.parseInt(TextNum.getText()));
            usuarioPro.setTelefono(TextTelf.getText());
            usuarioPro.setEmail(TextEmail.getText());
            loxicaUsuario.validarUpdate(usuarioPro);
            clean();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error rexistrando datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_BotonActualizar1ActionPerformed

    /**
     * Mï¿½todo para borrar o usuario segï¿½n rol
     *
     * @param evt
     */
    private void BotonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarActionPerformed

        // if (String.valueOf(ComboRol.getSelectedItem()).equals("Propietario")) {
        Usuario usuario = new Propietario();
        usuario.setIdUsuario(Integer.parseInt(idPropietario));
        loxicaUsuario.validarDelete(usuario);
        Xanela1 xanela1 = new Xanela1();
        xanela1.setVisible(true);
        this.setVisible(false);
        /*} else if (String.valueOf(ComboRol.getSelectedItem()).equals("Cliente")) {
            Usuario usuarioCliente = new Cliente();
            usuarioCliente.setIdUsuario(Integer.parseInt(TextBuscaID.getText()));
            loxicaUsuario.validarDelete(usuarioCliente);
        }*/
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonBorrarActionPerformed

    /**
     * Metodo para buscar os datos de usuario
     *
     * @param evt
     */
    private void BotonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscar1ActionPerformed

        Usuario usuarioPro = new Propietario();
        usuarioPro.setIdUsuario(Integer.parseInt(idPropietario));
        usuarioPro.setNome(loxicaPropietario.validarFindByIdPropietario(usuarioPro).getNome());
        usuarioPro.setApelido1(loxicaPropietario.validarFindByIdPropietario(usuarioPro).getApelido1());
        usuarioPro.setApelido2(loxicaPropietario.validarFindByIdPropietario(usuarioPro).getApelido2());
        usuarioPro.setRua(loxicaPropietario.validarFindByIdPropietario(usuarioPro).getRua());
        usuarioPro.setNumero(loxicaPropietario.validarFindByIdPropietario(usuarioPro).getNumero());
        usuarioPro.setTelefono(loxicaPropietario.validarFindByIdPropietario(usuarioPro).getTelefono());
        usuarioPro.setEmail(loxicaPropietario.validarFindByIdPropietario(usuarioPro).getEmail());
        //  usuarioPro.setRol(loxicaPropietario.validarFindByIdPropietario(usuarioPro).getRol());

        TextNome.setText(usuarioPro.getNome());
        TextApelido.setText(usuarioPro.getApelido1());
        TextApelido2.setText(usuarioPro.getApelido2());
        TextRua.setText(usuarioPro.getRua());
        TextNum.setText(String.valueOf(usuarioPro.getNumero()));
        TextTelf.setText(usuarioPro.getTelefono());
        TextEmail.setText(usuarioPro.getEmail());
        // ComboRol.setSelectedItem(String.valueOf(usuarioPro.getRol()));

        //   }

        // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscar1ActionPerformed

    /**
     * Botï¿½n para limpar os cadros de texto
     *
     * @param evt
     */
    private void BotonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLimparActionPerformed

        cleanDatos();
    }//GEN-LAST:event_BotonLimparActionPerformed

    /**
     * Mï¿½todo para gardar carta en bbdd
     *
     * @param evt
     */
    private void BotonGardarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGardarCartaActionPerformed

        Carta carta = new Carta();
        carta.setNome(TextCarta.getText());
        carta.setEpocaAno(String.valueOf(ComboEstacion.getSelectedItem()));
        loxicaCarta.validarCreate(carta);

        Local local = new Local();
        local.setIdLocal(Integer.parseInt(TextIdLocalCarta.getText()));

        CartaLocal cartaLocal = new CartaLocal();
        cartaLocal.setCarta(loxicaCarta.validarFindIdMax(carta));
        cartaLocal.setLocal(local);

        loxicaCartaLocal.validarCreate(cartaLocal);


        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGardarCartaActionPerformed

    /**
     * Mï¿½todo para minimizar interface
     *
     * @param evt
     */
    private void btnMinimizaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizaMouseClicked

        this.setExtendedState(1);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinimizaMouseClicked

    /**
     * Metodo para cambiar color de elemento
     *
     * @param evt
     */
    private void btnMinimizaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizaMouseEntered

        btnMinimiza.setBackground(Color.red);
        btnMinimiza.setForeground(Color.WHITE);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinimizaMouseEntered

    /**
     * Metodo para cambiar color de elemento
     *
     * @param evt
     */
    private void btnMinimizaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizaMouseExited

        btnMinimiza.setBackground(new Color(0, 72, 193));
        btnMinimiza.setForeground(Color.WHITE);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMinimizaMouseExited

    private void BuscaPratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaPratoActionPerformed

        String nomeIngrediente = String.valueOf(ComboIngrediente.getSelectedItem());
        String oIngrediente = "";
        ComboPrato.removeAllItems();
        Ingrediente ingrediente1 = new Ingrediente();
        ingrediente1.setNomeIngrediente(nomeIngrediente);
        Ingrediente ingrediente = loxicaIngrediente.validarFindByNameIngrediente(ingrediente1);

        ingredientes = loxicaIngrediente.validarRead();
        if (!ingredientes.isEmpty()) {
            for (Ingrediente ingre : ingredientes
            ) {
                oIngrediente = String.valueOf(ingre.getNomeIngrediente());
                if (oIngrediente.equals(nomeIngrediente)) {
                    break;
                }
            }
            if (oIngrediente.equals(nomeIngrediente)) {
                IngredientePrato ingredientePrato = new IngredientePrato();
                ingredientePrato.setIngrediente(ingrediente);

                ingredientesPrato = loxicaIngredientePrato.validarfindByIdIngrediente(ingredientePrato);
                if (!ingredientesPrato.isEmpty()) {
                    for (IngredientePrato ingPrato : ingredientesPrato
                    ) {
                        Prato prato = new Prato();
                        prato.setId(ingPrato.getPrato().getId());
                        produtos = loxicaProducto.validarByIdPrato(prato);
                        for (Produto prod : produtos
                        ) {
                            ComboPrato.addItem(String.valueOf(prod.getNome()));
                        }

                    }
                }
            }
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_BuscaPratoActionPerformed

    private void botonHelpProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHelpProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonHelpProActionPerformed


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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XanelaPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XanelaPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XanelaPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XanelaPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XanelaPropietario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BgPropietario;
    private javax.swing.JButton BotonActualizar1;
    private javax.swing.JButton BotonActualizarLocal;
    private javax.swing.JButton BotonBorrar;
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JButton BotonBuscar1;
    private javax.swing.JButton BotonBuscarCarta;
    private javax.swing.JButton BotonBuscarMarca;
    private javax.swing.JButton BotonEliminarLocal;
    private javax.swing.JButton BotonGardarCarta;
    private javax.swing.JButton BotonGardarLocal;
    private javax.swing.JButton BotonLimpar;
    private javax.swing.JButton BotonSaveCartPro;
    private javax.swing.JButton BuscaBebida;
    private javax.swing.JButton BuscaPrato;
    private javax.swing.JComboBox<String> ComboCarta;
    private javax.swing.JComboBox<String> ComboConcello;
    private javax.swing.JComboBox<String> ComboConcelloLocal;
    private javax.swing.JComboBox<String> ComboEncargo;
    private javax.swing.JComboBox<String> ComboEspecialidade;
    private javax.swing.JComboBox<String> ComboEspecialidadeLocal;
    private javax.swing.JComboBox<String> ComboEstacion;
    private javax.swing.JComboBox<String> ComboIngrediente;
    private javax.swing.JComboBox<String> ComboMarcas;
    private javax.swing.JComboBox<String> ComboPrato;
    private javax.swing.JComboBox<String> ComboProdutoBebidas;
    private javax.swing.JComboBox<String> ComboTipoBebidas;
    private javax.swing.JComboBox<String> ComboTipoLocal;
    private javax.swing.JLabel LabeLEngadeLocal;
    private javax.swing.JLabel LabelDatosLocal;
    private javax.swing.JLabel LabelDatosPro;
    private javax.swing.JLabel LabelInfoCalCarta;
    private javax.swing.JLabel LabelInfoCarta;
    private javax.swing.JLabel LabelMarchoPro;
    private javax.swing.JLabel LabelSuperiorPro;
    private javax.swing.JPanel PanelChau;
    private javax.swing.JPanel PanelCin;
    private javax.swing.JPanel PanelCuar;
    private javax.swing.JPanel PanelDatosLocal;
    private javax.swing.JPanel PanelDatosPro;
    private javax.swing.JPanel PanelEngadeLocal;
    private javax.swing.JPanel PanelFixoInicio;
    private javax.swing.JPanel PanelInfoCarta;
    private javax.swing.JPanel PanelInfoLo;
    private javax.swing.JLabel PanelInicioLocal;
    private javax.swing.JPanel PanelLateralPro;
    private javax.swing.JPanel PanelMarchoPro;
    private javax.swing.JPanel PanelPri;
    private javax.swing.JPanel PanelPriDatos;
    private javax.swing.JPanel PanelPriDatosPro;
    private javax.swing.JPanel PanelPriEngadir;
    private javax.swing.JPanel PanelPriPro;
    private javax.swing.JPanel PanelSeg;
    private javax.swing.JPanel PanelSuperiorPro;
    private javax.swing.JPanel PanelTer;
    private javax.swing.JTabbedPane TabInicialPro;
    private javax.swing.JTextField TextApelido;
    private javax.swing.JTextField TextApelido2;
    private javax.swing.JTextField TextCarta;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextEmailLocal;
    private javax.swing.JTextField TextIdLocalCarta;
    private javax.swing.JTextField TextIdPrezoVenda;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextNomeLocal;
    private javax.swing.JTextField TextNum;
    private javax.swing.JTextField TextNumLocal;
    private javax.swing.JTextField TextPropietario;
    private javax.swing.JTextField TextRua;
    private javax.swing.JTextField TextRuaLocal;
    private javax.swing.JTextField TextTelf;
    private javax.swing.JTextField TextTelfLocal;
    private javax.swing.JButton botonHelpPro;
    private java.awt.Label btnMinimiza;
    private java.awt.Label btnSaida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel labelIconoConec;
    private javax.swing.JLabel labelconectado;
    private javax.swing.JLabel textPaBu;
    // End of variables declaration//GEN-END:variables
}
