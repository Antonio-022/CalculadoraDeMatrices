/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.Color;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author fanboy022
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {

        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        Inicio();
        BorrarHeader();
    }
//variables de almacenamiento de filas y columnas de la matriz
    public int m1;
    public int m2;
    public int n1;
    public int n2;
    public int BanderaA;
    public int BanderaB;
    public String signo;
    public int BanderaC;
    //variable de almacenamiento de las matrices
    public int[][] MatrizB;
    public int[][] MatrizA;
    public int[][] Matriz1;
    public int[][] MatrizE1;
    public int p;
    
    //metodo que se ejecuta al inicion del programa ocultando los elementos del miso
    //excepto el cuadro de operaciones matriciales
    public void Inicio() {
        Signo.setText("");
        Signo1.setText("");
        PText.setText("");
        PText.setVisible(false);
        Trazatxt.setVisible(false);
        Calculo.setVisible(false);
        CEB.setVisible(false);
        EXP.setVisible(false);
        SignoB.setVisible(false);
        M2.setVisible(false);
        N2.setVisible(false);
        labelB.setVisible(false);
        CEA.setVisible(false);
        M1.setVisible(false);
        N1.setVisible(false);
        SignoA.setVisible(false);
        labelA.setVisible(false);
        Accep.setVisible(false);
        Borrar.setVisible(false);
        Info.setVisible(false);
        CA.setVisible(false);
        CB.setVisible(false);
        CResultado.setVisible(false);
        igual.setVisible(false);
        Signo.setVisible(false);
        Signo1.setVisible(false);
    }
    //metodo que elimina la barra de las tablas de los jtable
    public void BorrarHeader() {
        MA2.getTableHeader().setUI(null);
        MA.getTableHeader().setUI(null);
        MB.getTableHeader().setUI(null);
        MA1.getTableHeader().setUI(null);
        MR.getTableHeader().setUI(null);
    }
    //funcion que muestra y oculta los elementos del programa dependiendo de las operaciones
    public void MOfield(String M) {
        switch (M) {
            case "producto":
            case "suma":
            case "opuestaAB":
                BtnBorrar();
                Calculo.setVisible(false);
                CEB.setVisible(true);
                Accep.setVisible(true);
                PText.setVisible(false);
                EXP.setVisible(false);
                SignoB.setVisible(true);
                M2.setVisible(true);
                N2.setVisible(true);
                labelB.setVisible(true);
                CEA.setVisible(true);
                M1.setVisible(true);
                N1.setVisible(true);
                SignoA.setVisible(true);
                labelA.setVisible(true);
                Info.setVisible(true);
                M1.setText("");
                N1.setText("");
                M2.setText("");
                N2.setText("");
                PText.setText("");
                Borrar.setVisible(false);
                break;
            case "traza":
            case "transpuesta":
            case "opuesta":
                BtnBorrar();
                Calculo.setVisible(false);
                CEB.setVisible(false);
                Accep.setVisible(true);
                PText.setVisible(false);
                EXP.setVisible(false);
                SignoB.setVisible(false);
                M2.setVisible(false);
                N2.setVisible(false);
                labelB.setVisible(false);
                CEA.setVisible(true);
                M1.setVisible(true);
                N1.setVisible(true);
                SignoA.setVisible(true);
                labelA.setVisible(true);
                Info.setVisible(true);
                M1.setText("");
                N1.setText("");
                M2.setText("");
                N2.setText("");
                PText.setText("");
                Borrar.setVisible(false);
                break;
            case "potencia":
                BtnBorrar();
                Calculo.setVisible(false);
                CEB.setVisible(false);
                Accep.setVisible(true);
                PText.setVisible(true);
                EXP.setVisible(true);
                SignoB.setVisible(false);
                M2.setVisible(false);
                N2.setVisible(false);
                labelB.setVisible(false);
                CEA.setVisible(true);
                M1.setVisible(true);
                N1.setVisible(true);
                SignoA.setVisible(true);
                labelA.setVisible(true);
                Info.setVisible(true);
                M1.setText("");
                N1.setText("");
                M2.setText("");
                N2.setText("");
                PText.setText("");
                Borrar.setVisible(false);
                break;
            default:
                break;
        }
    }
    
    public void cuadraVerif() {
        m1 = Integer.parseInt(this.M1.getText());
        n1 = Integer.parseInt(this.N1.getText());
        m2 = Integer.parseInt(this.M2.getText());
        n2 = Integer.parseInt(this.N2.getText());
        if (m1 == n1 && m2 == n2 && m1 == m2 && n1 == n2) {
            try {
                m1 = Integer.parseInt(this.M1.getText());
                n1 = Integer.parseInt(this.N1.getText());
                m2 = Integer.parseInt(this.M2.getText());
                n2 = Integer.parseInt(this.N2.getText());
                DefaultTableModel model1 = (DefaultTableModel) MA.getModel();
                model1.setColumnCount(n1);
                model1.setRowCount(m1);
                DefaultTableModel model = (DefaultTableModel) MA2.getModel();
                model.setColumnCount(n2);
                model.setRowCount(m2);
                BanderaA = 1;
                Calculo.setVisible(true);
                Accep.setVisible(false);
                Borrar.setVisible(true);
                OcultarIngreso();
            } catch (Exception E) {
                JOptionPane.showMessageDialog(this, "la dimenciones ingresadas no son validas");
            }
        } else {
            JOptionPane.showMessageDialog(this, "no es una matriz cuadrada");
            BtnBorrar();
            M1.setText("");
            N1.setText("");
            M2.setText("");
            N2.setText("");
            Signo.setVisible(false);
        }
    }

    public void ConformVerif() {
        n1 = Integer.parseInt(this.N1.getText());
        m2 = Integer.parseInt(this.M2.getText());
        if (n1 == m2) {
            try {
                m1 = Integer.parseInt(this.M1.getText());
                n1 = Integer.parseInt(this.N1.getText());
                DefaultTableModel model1 = (DefaultTableModel) MA.getModel();
                model1.setColumnCount(n1);
                model1.setRowCount(m1);
                m2 = Integer.parseInt(this.M2.getText());
                n2 = Integer.parseInt(this.N2.getText());
                DefaultTableModel model = (DefaultTableModel) MA2.getModel();
                model.setColumnCount(n2);
                model.setRowCount(m2);
                Calculo.setVisible(true);
                Accep.setVisible(false);
                Borrar.setVisible(true);
                BanderaA = 1;
                OcultarIngreso();
            } catch (Exception E) {
                JOptionPane.showMessageDialog(this, "la dimenciones ingresadas no son validas");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Lamatriz A no es conforme a la matriz B");
            BtnBorrar();
            M1.setText("");
            N1.setText("");
            M2.setText("");
            N2.setText("");
            Signo.setVisible(false);
        }
    }

    public void CuadraVerifA() {
        m1 = Integer.parseInt(this.M1.getText());
        n1 = Integer.parseInt(this.N1.getText());
        if (m1 == n1) {
            try {
                AccesoDatos();
            } catch (Exception E) {
                JOptionPane.showMessageDialog(this, "la dimenciones ingresadas no son validas");
            }
        } else {
            JOptionPane.showMessageDialog(this, "no es una matriz cuadrada");
            BtnBorrar();
            M1.setText("");
            N1.setText("");
            M2.setText("");
            N2.setText("");
            Signo.setVisible(false);
            if (BanderaB == 6) {
                EXP.setVisible(true);
                PText.setVisible(true);
            }
        }
    }

    public void AccesoDatos() {
        m1 = Integer.parseInt(this.M1.getText());
        n1 = Integer.parseInt(this.N1.getText());
        DefaultTableModel model1 = (DefaultTableModel) MA.getModel();
        model1.setColumnCount(n1);
        model1.setRowCount(m1);
        Calculo.setVisible(true);
        Accep.setVisible(false);
        Borrar.setVisible(true);
        BanderaA = 2;
        OcultarIngreso();
    }
    //metodo que verifica si los cuadros de ingreso de texto de las dimensiones son validos o no

    public void BtnAceptar() {

        if ((!(M1.getText().isEmpty()) && !(N1.getText().isEmpty())) && (!(M2.getText().isEmpty()) && !(N2.getText().isEmpty()))) {

            switch (BanderaB) {
                case 1:
                    cuadraVerif();
                    break;
                case 7:
                    cuadraVerif();
                    break;
                case 4:
                    cuadraVerif();
                    break;
                case 2:
                    ConformVerif();
                    break;
                default:
                    break;
            }
        } else if (M1.getText().isEmpty() && N1.getText().isEmpty() && M2.getText().isEmpty() && N2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "error algunas casillas de estan vacias");
        } else if ((!(M1.getText().isEmpty()) && !(N1.getText().isEmpty())) && ((M2.getText().isEmpty()) && (N2.getText().isEmpty()))) {
            switch (BanderaB) {
                case 4:
                    CuadraVerifA();
                    break;
                case 6:
                    CuadraVerifA();
                    break;
                case 3:
                    AccesoDatos();
                    break;
                case 5:
                    AccesoDatos();
                    break;
                default:
                    break;
            }
        } else if (M1.getText().isEmpty() || N1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "error algunas casillas de estan vacias");
        } else if (((M1.getText().isEmpty()) && (N1.getText().isEmpty())) && (!(M2.getText().isEmpty()) && !(N2.getText().isEmpty()))) {
        } else if (M2.getText().isEmpty() || N2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "error algunas casillas de estan vacias");
        }

    }
    //metodo que muestra una breve informacion de cada una de las operaciones

    public void Infos(String E) {
        switch (E) {
            case " + ":
                JOptionPane.showMessageDialog(this, "“Para realizar una suma de matriz \n"
                        + "se verifica que ambas matrices son de la misma dimensión para luego proceder a\n "
                        + "realizar la suma de cada uno de los n elementos de la matriz primera con\n "
                        + "los de la segunda matriz, respetando las posiciones.” ");
                break;
            case " - ":
                JOptionPane.showMessageDialog(this, "“Una matriz opuesta se define \n"
                        + "como aquella matriz que se compone de sustituir cada uno \n"
                        + "de los elementos de una matriz dada por su opuesto.  \n"
                        + "De tal manera que sí tenemos una matriz dada a la opuesta \n"
                        + "de hacer la matriz -A, la cual se forma a partir de sustituir \n"
                        + "cada uno de los elementos de A multiplicado por -1, para formar \n"
                        + "su opuesto.” ");
                break;
            case " A^t ":
                JOptionPane.showMessageDialog(this, "“La transpuesta de una matriz A es \n"
                        + "una matriz que tiene los mismos elementos que A, pero que se coloca\n"
                        + " en una posición diferente. Se obtiene transportando cuidadosamente \n"
                        + "los elementos de las filas desde A a las columnas de transposición.” ");
                break;
            case " Tr ":
                JOptionPane.showMessageDialog(this, "“La traza (tr) de una matriz A se obtiene al \n"
                        + "sumar los elementos de la diagonal principal de la matriz A, para ello, \n"
                        + "es necesario que la matriz A sea cuadrada, de orden nxn, es decir, que \n"
                        + "la matriz A debe tener un número de renglones igual al número de columnas.” \n");
                break;
            case " * ":
                JOptionPane.showMessageDialog(this, "“la multiplicación de dos matrices es unificar \n"
                        + "las matrices en una sola matriz mediante la multiplicación y suma de los\n"
                        + " elementos de las filas y columnas de las matrices origen teniendo en cuenta\n"
                        + " el orden de los factores, La Matriz A debe ser conforme a B” ");
                break;
            case " -1 ":
                JOptionPane.showMessageDialog(this, "“Una matriz opuesta se define \n"
                        + "como aquella matriz que se compone de sustituir cada uno \n"
                        + "de los elementos de una matriz dada por su opuesto.  \n"
                        + "De tal manera que sí tenemos una matriz dada a la opuesta \n"
                        + "de hacer la matriz -A, la cual se forma a partir de sustituir \n"
                        + "cada uno de los elementos de A multiplicado por -1, para formar \n"
                        + "su opuesto.” ");
                break;
            case " A^n ":
                JOptionPane.showMessageDialog(this, "“Sólo podemos calcular potencias de matrices\n"
                        + " cuadradas. Por ejemplo, la potencia A2 es el producto de matrices A·A,\n"
                        + " lo que exige que A tiene que ser cuadrada..” ");
                break;
            default:
                break;
        }
    }
    
    //funcion qeu verifica si el usuario dejo de ingresar datos a la matris o a los cuadro de texto 
    public void VerificacionDatos(String D) {
        if (MA.isEditing() && MA2.isEditing()) {
            if (BanderaA == 1) {

                MA.getCellEditor().stopCellEditing();
                MA2.getCellEditor().stopCellEditing();

                switch (D) {
                    case "suma":
                        Cuadrada();
                        break;
                    case "producto":
                        Conforme();
                        break;
                    case "potencia":
                        CuadradaA();
                        break;
                    case "opuesta":
                        Opuesta();
                        Signo1.setVisible(true);
                        Signo.setVisible(false);
                        break;
                    case "opuestaAB":
                        Cuadrada();
                        break;
                    case "transpuesta":
                        TranspuestaA();
                        Signo.setVisible(true);
                        Signo1.setVisible(false);
                        break;
                    case "traza":
                        CuadradaA();
                        break;
                    default:
                        break;
                }
            }
        } else if (MA.isEditing()) {
            if (BanderaA == 2) {
                MA.getCellEditor().stopCellEditing();
                switch (D) {
                    case "suma":
                        Cuadrada();
                        break;
                    case "producto":
                        Conforme();
                        break;
                    case "potencia":
                        CuadradaA();
                        break;
                    case "opuesta":
                        Opuesta();
                        Signo1.setVisible(true);
                        Signo.setVisible(false);
                        break;
                    case "opuestaAB":
                        Cuadrada();
                        break;
                    case "transpuesta":
                        TranspuestaA();
                        Signo.setVisible(true);
                        Signo1.setVisible(false);
                        break;
                    case "traza":
                        CuadradaA();
                        break;
                    default:
                        break;
                }
            }
        }
        if (MA2.isEditing()) {
            if (BanderaA == 1) {
                MA2.getCellEditor().stopCellEditing();
                switch (D) {
                    case "suma":
                        Cuadrada();
                        break;
                    case "producto":
                        Conforme();
                        break;
                    case "potencia":
                        CuadradaA();
                        break;
                    case "opuesta":
                        Opuesta();
                        Signo1.setVisible(true);
                        Signo.setVisible(false);
                        break;
                    case "opuestaAB":
                        Cuadrada();
                        ;
                        break;
                    case "transpuesta":
                        TranspuestaA();
                        Signo.setVisible(true);
                        Signo1.setVisible(false);
                        break;
                    case "traza":
                        CuadradaA();
                        break;
                    default:
                        break;
                }
            }
        } 
    }
    //metodo que verifica si la matriz es conforme antes de calcular
    public void Conforme() {
        n1 = Integer.parseInt(this.N1.getText());
        m2 = Integer.parseInt(this.M2.getText());
        if (n1 == m2) {
            //JOptionPane.showMessageDialog(this, "yes");
            switch (BanderaB) {
                case 2:
                    Producto();
                    Signo1.setVisible(false);
                    Signo.setVisible(true);
                    break;
                default:
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "La matriz A no es conforme a B");
            BtnBorrar();
        }
    }

    public void CuadradaA() {
        m1 = Integer.parseInt(this.M1.getText());
        n1 = Integer.parseInt(this.N1.getText());
        if (m1 == n1) {
            switch (BanderaB) {

                case 6:
                    PotenciaA();
                    Signo1.setVisible(false);
                    Signo.setVisible(true);
                    break;
                case 4:
                    TrazaA();
                    Signo1.setVisible(false);
                    Signo.setVisible(true);
                    break;
                default:
                    break;
            }

        } else {
            JOptionPane.showMessageDialog(this, "no es una matriz cuadrada");
            BtnBorrar();
            Signo.setVisible(false);
        }
    }

    //metodo que verifica antes de calcular si la matriz es cuadrada
    public void Cuadrada() {
        m1 = Integer.parseInt(this.M1.getText());
        n1 = Integer.parseInt(this.N1.getText());
        m2 = Integer.parseInt(this.M2.getText());
        n2 = Integer.parseInt(this.N2.getText());
        if (m1 == n1 && m2 == n2 && m1 == m2 && n1 == n2) {
            switch (BanderaB) {
                case 1:
                    suma();
                    Signo1.setVisible(false);
                    Signo.setVisible(true);
                    break;
                case 7:
                    OPuestaAB();
                    Signo1.setVisible(false);
                    Signo.setVisible(true);
                    break;
                case 4:
                    TrazaA();
                    Signo1.setVisible(false);
                    Signo.setVisible(true);
                    break;
                default:
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "no es una matriz cuadrada");
            BtnBorrar();
            Signo.setVisible(false);
        }
    }

    //metodo que vacia las matrices A y B para operaciones como : suma,opuestaAyB ,producto
    public void BorrarA_B() {
        DefaultTableModel model2 = (DefaultTableModel) MA1.getModel();
        DefaultTableModel model3 = (DefaultTableModel) MB.getModel();
        DefaultTableModel model4 = (DefaultTableModel) MR.getModel();
        int numDatos = model2.getRowCount();
        int numDatos1 = model3.getRowCount();
        int numDatos2 = model4.getRowCount();
        for (int i = 0; i < numDatos; i++) {
            model2.removeRow(0);
        }
        for (int i = 0; i < numDatos1; i++) {

            model3.removeRow(0);
        }
        for (int i = 0; i < numDatos2; i++) {

            model4.removeRow(0);
        }
    }
    //metodo que vacia la matriz A para operaciones como: opuesta, transpuesta, potencia, traza

    public void BorrarAB() {
        DefaultTableModel model2 = (DefaultTableModel) MA1.getModel();
        DefaultTableModel model4 = (DefaultTableModel) MR.getModel();
        int numDatos = model2.getRowCount();
        for (int i = 0; i < numDatos; i++) {
            model2.removeRow(0);
        }
        int numDatos1 = model4.getRowCount();
        for (int i = 0; i < numDatos1; i++) {
            model4.removeRow(0);
        }
    }
    
    //metodo que vacia las casillas de las matrices y cuadro de igreso de texto
    public void BtnBorrar() {
        switch (BanderaB) {
            case 2:
            case 1:
            case 7:
                DefaultTableModel model = (DefaultTableModel) MA.getModel();
                DefaultTableModel model1 = (DefaultTableModel) MA2.getModel();
                int numDatos = model.getRowCount();
                int numDatos1 = model1.getRowCount();
                for (int i = 0; i < numDatos; i++) {
                    model.removeRow(0);
                }
                for (int i = 0; i < numDatos1; i++) {
                    model1.removeRow(0);
                }
                BorrarA_B();
                Hide_basic();
                PText.setVisible(false);
                EXP.setVisible(false);
                break;
            case 3:
            case 4:
            case 5:
                DefaultTableModel model2 = (DefaultTableModel) MA.getModel();
                int numDatos2 = model2.getRowCount();
                for (int i = 0; i < numDatos2; i++) {
                    model2.removeRow(0);
                }
                BorrarAB();
                Hide_basic();
                PText.setVisible(false);
                EXP.setVisible(false);
                break;
            case 6:
                DefaultTableModel model3 = (DefaultTableModel) MA.getModel();
                int numDatos3 = model3.getRowCount();
                for (int i = 0; i < numDatos3; i++) {
                    model3.removeRow(0);
                }
                BorrarAB();
                Hide_basic();
                PText.setVisible(false);
                EXP.setVisible(false);
                break;
            default:
                break;
        }
    }
    
    //metodo que oculta elementos del programa
    public void Hide_basic() {
        CA.setVisible(false);
        CB.setVisible(false);
        CResultado.setVisible(false);
        Signo.setVisible(false);
        Signo1.setVisible(false);
        Trazatxt.setVisible(false);
        igual.setVisible(false);
        PText.setText("");
    }
    
    //metodo que permite enviar los datos ingresados por usuario
    public void EventoCalcular(int C) {
        switch (C) {
            case 1:
                if (M1.getText().isEmpty() || N1.getText().isEmpty() || M2.getText().isEmpty() || N2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "error algunas casillas estan vacias");
                } else {
                    VerificacionDatos("suma");
                    OcultarIngreso();
                }
                break;
            case 2:
                if (M1.getText().isEmpty() || N1.getText().isEmpty() || M2.getText().isEmpty() || N2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "error algunas casillas estan vacias");
                } else {
                    VerificacionDatos("producto");
                    OcultarIngreso();
                }
                break;
            case 3:
                if (M1.getText().isEmpty() || N1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "error algunas casillas estan vacias");
                } else {
                    VerificacionDatos("opuesta");
                    OcultarIngreso();
                }
                break;
            case 4:
                if (M1.getText().isEmpty() || N1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "error algunas casillas estan vacias");
                } else {
                    VerificacionDatos("traza");
                    OcultarIngreso();
                }
                break;
            case 5:
                if (M1.getText().isEmpty() || N1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "error algunas casillas estan vacias");
                } else {
                    VerificacionDatos("transpuesta");
                    OcultarIngreso();
                }
                break;
            case 6:
                if (PText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "casilla exponente vacia");
                } else if (M1.getText().isEmpty() || N1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "error algunas casillas estan vacias");
                } else {
                    VerificacionDatos("potencia");
                    OcultarIngreso();
                }
                break;
            case 7:
                if (M1.getText().isEmpty() || N1.getText().isEmpty() || M2.getText().isEmpty() || N2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "error algunas casillas estan vacias");
                } else {
                    VerificacionDatos("opuestaAB");
                    OcultarIngreso();
                }

                break;
            default:
                break;
        }
    }
    
    //metodo que oculta elementos de entrada y etiquetas del programa 
    public void OcultarIngreso() {
        SignoB.setVisible(false);
        M2.setVisible(false);
        N2.setVisible(false);
        labelB.setVisible(false);
        M1.setVisible(false);
        N1.setVisible(false);
        SignoA.setVisible(false);
        labelA.setVisible(false);

    }
    
    //metodo que oculta y elementos del programa
    public void Hide_Show(int A) {
        switch (BanderaC) {
            case 1:
            case 2:
            case 7:
                Trazatxt.setVisible(false);
                CResultado.setVisible(true);
                CB.setVisible(true);
                CA.setVisible(true);
                igual.setVisible(true);
                PText.setVisible(false);
                EXP.setVisible(false);
                Signo.setVisible(false);
                Signo1.setVisible(false);
                break;
            case 4:
                Trazatxt.setVisible(true);
                CResultado.setVisible(false);
                CB.setVisible(false);
                CA.setVisible(true);
                igual.setVisible(true);
                PText.setVisible(false);
                EXP.setVisible(false);
                Signo.setVisible(false);
                Signo1.setVisible(false);
                break;
            case 6:
            case 3:
            case 5:
                Trazatxt.setVisible(false);
                CResultado.setVisible(true);
                CB.setVisible(false);
                CA.setVisible(true);
                igual.setVisible(true);
                Signo.setVisible(false);
                PText.setVisible(false);
                Signo1.setVisible(false);
                EXP.setVisible(false);
                break;
            default:
                break;
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

        Trazatxt = new javax.swing.JTextField();
        CResultado = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        MR = new javax.swing.JTable();
        SignoA = new javax.swing.JLabel();
        SignoB = new javax.swing.JLabel();
        M2 = new javax.swing.JTextField();
        Accep = new javax.swing.JButton();
        N2 = new javax.swing.JTextField();
        igual = new javax.swing.JLabel();
        M1 = new javax.swing.JTextField();
        Signo = new javax.swing.JLabel();
        N1 = new javax.swing.JTextField();
        Borrar = new javax.swing.JButton();
        labelB = new javax.swing.JLabel();
        labelA = new javax.swing.JLabel();
        Info = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Suma = new javax.swing.JButton();
        Transpuesta = new javax.swing.JButton();
        Traza = new javax.swing.JButton();
        Producto = new javax.swing.JButton();
        Opuesta = new javax.swing.JButton();
        Potencia = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        OpuestaAB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Exit = new javax.swing.JButton();
        CEA = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MA = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        CEB = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        MA2 = new javax.swing.JTable();
        Calculo = new javax.swing.JButton();
        PText = new javax.swing.JTextField();
        EXP = new javax.swing.JLabel();
        CA = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        MA1 = new javax.swing.JTable();
        CB = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        MB = new javax.swing.JTable();
        Creditos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Signo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Trazatxt.setEditable(false);
        Trazatxt.setAutoscrolls(false);
        Trazatxt.setDoubleBuffered(true);

        CResultado.setBackground(new java.awt.Color(255, 255, 255));

        MR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51)));
        MR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        MR.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        MR.setDoubleBuffered(true);
        MR.setEditingColumn(1);
        MR.setEditingRow(1);
        MR.setEnabled(false);
        MR.setFillsViewportHeight(true);
        MR.setGridColor(new java.awt.Color(204, 0, 51));
        MR.setInheritsPopupMenu(true);
        MR.setRequestFocusEnabled(false);
        MR.setRowHeight(23);
        MR.setSelectionBackground(new java.awt.Color(255, 255, 255));
        MR.setShowGrid(true);
        jScrollPane2.setViewportView(MR);

        javax.swing.GroupLayout CResultadoLayout = new javax.swing.GroupLayout(CResultado);
        CResultado.setLayout(CResultadoLayout);
        CResultadoLayout.setHorizontalGroup(
            CResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CResultadoLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        CResultadoLayout.setVerticalGroup(
            CResultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );

        SignoA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SignoA.setText(" X");

        SignoB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SignoB.setText(" X");

        M2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        Accep.setBackground(new java.awt.Color(0, 153, 153));
        Accep.setForeground(new java.awt.Color(255, 255, 255));
        Accep.setText("Aceptar");
        Accep.setDoubleBuffered(true);
        Accep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccepActionPerformed(evt);
            }
        });

        N2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        igual.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        igual.setText(" = ");

        M1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        Signo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Signo.setText("2");

        N1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        Borrar.setBackground(new java.awt.Color(204, 51, 0));
        Borrar.setForeground(new java.awt.Color(255, 255, 255));
        Borrar.setText("Borrar");
        Borrar.setDoubleBuffered(true);
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });

        labelB.setText("Matriz B");

        labelA.setText("Matriz A");

        Info.setBackground(new java.awt.Color(102, 102, 255));
        Info.setForeground(new java.awt.Color(255, 255, 255));
        Info.setText("Info");
        Info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        Suma.setBackground(new java.awt.Color(0, 51, 51));
        Suma.setForeground(new java.awt.Color(255, 255, 255));
        Suma.setText("A + B");
        Suma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SumaActionPerformed(evt);
            }
        });

        Transpuesta.setBackground(new java.awt.Color(255, 102, 51));
        Transpuesta.setForeground(new java.awt.Color(255, 255, 255));
        Transpuesta.setText("Transpuesta A");
        Transpuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TranspuestaActionPerformed(evt);
            }
        });

        Traza.setBackground(new java.awt.Color(0, 0, 102));
        Traza.setForeground(new java.awt.Color(255, 255, 255));
        Traza.setText("Traza");
        Traza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrazaActionPerformed(evt);
            }
        });

        Producto.setBackground(new java.awt.Color(153, 0, 0));
        Producto.setForeground(new java.awt.Color(255, 255, 255));
        Producto.setText("A * B");
        Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductoActionPerformed(evt);
            }
        });

        Opuesta.setBackground(new java.awt.Color(102, 0, 255));
        Opuesta.setForeground(new java.awt.Color(255, 255, 255));
        Opuesta.setText("- A");
        Opuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpuestaActionPerformed(evt);
            }
        });

        Potencia.setBackground(new java.awt.Color(255, 51, 102));
        Potencia.setForeground(new java.awt.Color(255, 255, 255));
        Potencia.setText("Potencia");
        Potencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PotenciaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Calligraphy", 2, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Operaciones");

        OpuestaAB.setBackground(new java.awt.Color(255, 51, 102));
        OpuestaAB.setForeground(new java.awt.Color(255, 255, 255));
        OpuestaAB.setText("A - B");
        OpuestaAB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpuestaABActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Suma, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Opuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Traza, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Transpuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Potencia, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(OpuestaAB)))))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Producto)
                    .addComponent(Suma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Opuesta)
                    .addComponent(Traza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Transpuesta)
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Potencia)
                    .addComponent(OpuestaAB))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        jLabel3.setFont(new java.awt.Font("Poor Richard", 2, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Calculadora De Operaciones Matriciales");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(jLabel3)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        Exit.setBackground(new java.awt.Color(204, 0, 51));
        Exit.setForeground(new java.awt.Color(255, 255, 255));
        Exit.setText("Salir");
        Exit.setContentAreaFilled(false);
        Exit.setOpaque(true);
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit)
                .addContainerGap())
        );

        CEA.setBackground(new java.awt.Color(255, 255, 255));

        MA.setAutoCreateRowSorter(true);
        MA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        MA.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        MA.setCellSelectionEnabled(true);
        MA.setDoubleBuffered(true);
        MA.setEditingColumn(1);
        MA.setEditingRow(1);
        MA.setFillsViewportHeight(true);
        MA.setGridColor(new java.awt.Color(0, 51, 204));
        MA.setInheritsPopupMenu(true);
        MA.setRowHeight(30);
        MA.setRowMargin(10);
        MA.setSelectionBackground(new java.awt.Color(255, 255, 255));
        MA.setSelectionForeground(new java.awt.Color(0, 0, 0));
        MA.setShowGrid(true);
        MA.setSurrendersFocusOnKeystroke(true);
        MA.getTableHeader().setResizingAllowed(false);
        MA.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(MA);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("A");

        javax.swing.GroupLayout CEALayout = new javax.swing.GroupLayout(CEA);
        CEA.setLayout(CEALayout);
        CEALayout.setHorizontalGroup(
            CEALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CEALayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel4)
                .addContainerGap(96, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        CEALayout.setVerticalGroup(
            CEALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CEALayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        CEB.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("B");

        MA2.setAutoCreateRowSorter(true);
        MA2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        MA2.setDoubleBuffered(true);
        MA2.setEditingColumn(1);
        MA2.setEditingRow(1);
        MA2.setFillsViewportHeight(true);
        MA2.setGridColor(new java.awt.Color(0, 102, 204));
        MA2.setInheritsPopupMenu(true);
        MA2.setRowHeight(30);
        MA2.setRowMargin(10);
        MA2.setRowSelectionAllowed(false);
        MA2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        MA2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        MA2.setShowGrid(true);
        MA2.setSurrendersFocusOnKeystroke(true);
        MA2.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(MA2);

        javax.swing.GroupLayout CEBLayout = new javax.swing.GroupLayout(CEB);
        CEB.setLayout(CEBLayout);
        CEBLayout.setHorizontalGroup(
            CEBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CEBLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(CEBLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CEBLayout.setVerticalGroup(
            CEBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CEBLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        Calculo.setBackground(new java.awt.Color(0, 153, 153));
        Calculo.setForeground(new java.awt.Color(255, 255, 255));
        Calculo.setText("Calcular");
        Calculo.setDoubleBuffered(true);
        Calculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculoActionPerformed(evt);
            }
        });

        PText.setText("jTextField1");

        EXP.setText("Expontente :");

        MA1.setAutoCreateRowSorter(true);
        MA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MA1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        MA1.setDoubleBuffered(true);
        MA1.setEditingColumn(1);
        MA1.setEditingRow(1);
        MA1.setEnabled(false);
        MA1.setFillsViewportHeight(true);
        MA1.setFocusable(false);
        MA1.setGridColor(new java.awt.Color(0, 0, 0));
        MA1.setInheritsPopupMenu(true);
        MA1.setRowHeight(23);
        MA1.setRowSelectionAllowed(false);
        MA1.setShowGrid(true);
        jScrollPane4.setViewportView(MA1);

        javax.swing.GroupLayout CALayout = new javax.swing.GroupLayout(CA);
        CA.setLayout(CALayout);
        CALayout.setHorizontalGroup(
            CALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CALayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CALayout.setVerticalGroup(
            CALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );

        MB.setAutoCreateRowSorter(true);
        MB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        MB.setDoubleBuffered(true);
        MB.setEditingColumn(1);
        MB.setEditingRow(1);
        MB.setEnabled(false);
        MB.setFillsViewportHeight(true);
        MB.setGridColor(new java.awt.Color(0, 0, 0));
        MB.setInheritsPopupMenu(true);
        MB.setRowHeight(23);
        MB.setShowGrid(true);
        jScrollPane3.setViewportView(MB);

        javax.swing.GroupLayout CBLayout = new javax.swing.GroupLayout(CB);
        CB.setLayout(CBLayout);
        CBLayout.setHorizontalGroup(
            CBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CBLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CBLayout.setVerticalGroup(
            CBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
        );

        Creditos.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Programmer : Antonio Arauz");

        jLabel2.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Materia : Algebra Lineal");

        javax.swing.GroupLayout CreditosLayout = new javax.swing.GroupLayout(Creditos);
        Creditos.setLayout(CreditosLayout);
        CreditosLayout.setHorizontalGroup(
            CreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreditosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(CreditosLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)))
                .addGap(313, 313, 313))
        );
        CreditosLayout.setVerticalGroup(
            CreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CreditosLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Pristina", 1, 14)); // NOI18N
        jLabel6.setText("PROGRAM");

        jLabel7.setFont(new java.awt.Font("Pristina", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Signo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Signo1.setText("2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Signo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(CA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Signo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(igual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Trazatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CEA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CEB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(EXP)
                                    .addComponent(PText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(labelA))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(M1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(SignoA, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(N1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(M2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(SignoB, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(N2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(labelB))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Calculo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Accep, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Borrar)
                                .addGap(18, 18, 18)
                                .addComponent(Info)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))))
            .addComponent(Creditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CEB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CEA, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(EXP)
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Accep)
                                        .addComponent(Calculo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(N1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SignoA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(M1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(labelB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(N2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(SignoB)
                                            .addComponent(M2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(34, 34, 34)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Borrar)
                            .addComponent(Info)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(Creditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(Signo))
                                    .addComponent(CResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(igual)
                                            .addComponent(Trazatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(CB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(Signo1)))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 614, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AccepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccepActionPerformed
        BtnAceptar();
    }//GEN-LAST:event_AccepActionPerformed

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        BtnBorrar();
        BtnAceptar();
    }//GEN-LAST:event_BorrarActionPerformed

    private void InfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoActionPerformed
        Infos(signo);
    }//GEN-LAST:event_InfoActionPerformed

    private void SumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SumaActionPerformed
        MOfield("suma");
        BanderaB = 1;
        signo = " + ";
        BanderaC = 1;
        Signo.setText(" + ");
    }//GEN-LAST:event_SumaActionPerformed

    private void TranspuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TranspuestaActionPerformed
        MOfield("transpuesta");
        BanderaB = 5;
        signo = " A^t ";
        BanderaC = 5;
        Signo.setText(" A^t ");
    }//GEN-LAST:event_TranspuestaActionPerformed

    private void TrazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TrazaActionPerformed
        MOfield("traza");
        BanderaB = 4;
        signo = " Tr ";
        BanderaC = 4;
        Signo.setText(" Tr ");
    }//GEN-LAST:event_TrazaActionPerformed

    private void ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductoActionPerformed
        MOfield("producto");
        BanderaB = 2;
        signo = " * ";
        BanderaC = 2;
        Signo.setText(" * ");
    }//GEN-LAST:event_ProductoActionPerformed

    private void OpuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpuestaActionPerformed
        MOfield("opuesta");
        BanderaB = 3;
        signo = " - ";
        BanderaC = 3;
        Signo1.setText(" -1 *  ");
    }//GEN-LAST:event_OpuestaActionPerformed

    private void PotenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PotenciaActionPerformed
        MOfield("potencia");
        BanderaB = 6;
        signo = " A^n ";
        BanderaC = 3;
        Signo.setText(" A^n ");
    }//GEN-LAST:event_PotenciaActionPerformed

    private void OpuestaABActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpuestaABActionPerformed
        MOfield("opuestaAB");
        BanderaB = 7;
        signo = " -1 ";
        BanderaC = 7;
        Signo.setText(" - ");
    }//GEN-LAST:event_OpuestaABActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void CalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculoActionPerformed
        EventoCalcular(BanderaB);
    }//GEN-LAST:event_CalculoActionPerformed

    //metodo que resuelve la operacion de suma A + B
    public void suma() {
        //EL TRY-CATCH ES UNA DECLARACION QUE CUMPLE CON LA FINALIDAD DE HACER UN EVENTO SI
        //ES QUE QUE QUE LA OPERACION LLEGASE A FALLAR POR X MOTIVOS
        try {
            //SE LLAMÁ A LA METODO ,EL CUAL OCULTA ELEMENTOS ESPECIFICOS DE LA INTERFAZ
            Hide_Show(BanderaC);
            //DECLARACION DE VARIABLES TIPO ENTERO LAS CUALES ALMACENAN LOS DATOS INGRESADOS , LOS CUALES
            //SERIAN LAS DIMENSIONES M X N Y N X P
            m1 = Integer.parseInt(this.M1.getText());
            n1 = Integer.parseInt(this.N1.getText());
            m2 = Integer.parseInt(this.M2.getText());
            n2 = Integer.parseInt(this.N2.getText());
            //DECLARACION DE LOS ARREGLOS BIDIMENSIONALES TIPO ENTERO QUE ALAMACENAN LOS DATOS DE
            // LA MATRIZ A , B Y LA MATRIZ RESULTANTE
            MatrizA = new int[m1][n1];
            MatrizB = new int[m2][n2];
            int[][] matrizR = new int[m2][n2];
            //DECLARACIONES QUE PERMITEN HACER MODIFICACIONES A LA TABLAS GRAFICAS DEL PROGRAMA
            //AQUI SE DAN LAS DIMENSIONES YA OBTENIDAS ARRIBA
            DefaultTableModel EmatrizA = (DefaultTableModel) MA.getModel();
            EmatrizA.setColumnCount(n1);
            EmatrizA.setRowCount(m1);
            DefaultTableModel EmatrizB = (DefaultTableModel) MA2.getModel();
            EmatrizB.setColumnCount(n1);
            EmatrizB.setRowCount(m1);
            DefaultTableModel matrizA = (DefaultTableModel) MA1.getModel();
            matrizA.setColumnCount(n1);
            matrizA.setRowCount(m1);
            DefaultTableModel matrizB = (DefaultTableModel) MB.getModel();
            matrizB.setColumnCount(n1);
            matrizB.setRowCount(m1);
            DefaultTableModel MatrizR = (DefaultTableModel) MR.getModel();
            MatrizR.setColumnCount(n1);
            MatrizR.setRowCount(m1);
            //BUCLE QUE NOS PERMITIRA LLENAR LA MATRIZA CON LOS DATOS DE LAS TABLAS
            // GRAFICAS
            for (int i = 0; i < MatrizA.length; i++) {
                for (int j = 0; j < MatrizA[i].length; j++) {
                    MatrizA[i][j] = Integer.parseInt((String) EmatrizA.getValueAt(i, j));
                    matrizA.setValueAt(MatrizA[i][j], i, j);
                }
            }
            //BUCLE QUE NOS PERMITIRA LLENAR LA MATRIZB CON LOS DATOS DE LAS TABLAS
            // GRAFICAS
            for (int i = 0; i < MatrizB.length; i++) {
                for (int j = 0; j < MatrizB[i].length; j++) {
                    MatrizB[i][j] = Integer.parseInt((String) EmatrizB.getValueAt(i, j));
                    matrizB.setValueAt(MatrizB[i][j], i, j);
                }
            }
            //BUCLE QUE REALIZARA LA OPERACION SUMA DE LA MATRIZ A Y B
            // Y PROCEDE A LLENAR LA MATRIZ GRAFICA DE RESULTADO
            for (int i = 0; i < matrizR.length; i++) {
                for (int j = 0; j < matrizR[i].length; j++) {
                    matrizR[i][j] = MatrizA[i][j] + MatrizB[i][j];
                    MatrizR.setValueAt(matrizR[i][j], i, j);
                }
            }
            //SENTENCIA EN LA CUAL SE EJECUTA UNA SERIE DE DECLARACIONES Y EVENTOS
            //SI DURANTE LA OPERACION DIERA UN ERROR
        } catch (Exception E) {
            //DECLARACIONES QUE OCULTARAN LAS TABLAS YA QUE ESTARAN VACIAS Y SERA INNECESARIAS MOSTRARLAS,SE OCULTAN
            // TAMBIEN SUS RESPECTIVOS SIGNOS
            CA.setVisible(false);
            CB.setVisible(false);
            CResultado.setVisible(false);
            igual.setVisible(false);
            Signo.setVisible(false);
            //CLASE QUE NOS PERMITIRA MOSTRAR UN MENSAJE EN PANTALLA SI OCURRIERA UN ERROR EN LA OPERACION 
            JOptionPane.showMessageDialog(this, "Algunas casillas en las matrices estan vacias o contienen caracteres invalidos");
        }
    }
    //FIN DEL METODO
    
    //metodo que resuelve la operacion de Opuesta de A
    public void Opuesta() {
        //EL TRY-CATCH ES UNA DECLARACION QUE CUMPLE CON LA FINALIDAD DE HACER UN EVENTO SI
        //ES QUE QUE QUE LA OPERACION LLEGASE A FALLAR POR X MOTIVOS
        try { 
    //SE LLAMÁ A LA METODO ,EL CUAL OCULTA ELEMENTOS ESPECIFICOS DE LA INTERFAZ
            Hide_Show(BanderaC);
            //DECLARACION DE VARIABLES TIPO ENTERO LAS CUALES ALMACENAN LOS DATOS INGRESADOS , LOS CUALES
            //SERIAN LAS DIMENSIONES M X N 
            m1 = Integer.parseInt(this.M1.getText());
            n1 = Integer.parseInt(this.N1.getText());
            //DECLARACION DE LOS ARREGLOS BIDIMENSIONALES TIPO ENTERO QUE ALAMACENAN LOS DATOS DE
            // LA MATRIZ A Y LA MATRIZ RESULTANTE
            int[][] matrizR = new int[m1][n1];
            MatrizA = new int[m1][n1];
            //DECLARACIONES QUE PERMITEN HACER MODIFICACIONES A LA TABLAS GRAFICAS DEL PROGRAMA
            //AQUI SE DAN LAS DIMENSIONES YA OBTENIDAS ARRIBA
            DefaultTableModel EmatrizA = (DefaultTableModel) MA.getModel();
            EmatrizA.setColumnCount(n1);
                EmatrizA.setRowCount(m1);
                DefaultTableModel matrizA = (DefaultTableModel) MA1.getModel();
                matrizA.setColumnCount(n1);
                matrizA.setRowCount(m1);
            DefaultTableModel MatrizR = (DefaultTableModel) MR.getModel();
            MatrizR.setColumnCount(n1);
            MatrizR.setRowCount(m1);
            //BUCLE QUE NOS PERMITIRA LLENAR LA MATRIZA CON LOS DATOS DE LAS TABLAS
            // GRAFICAS
            for (int i = 0; i < MatrizA.length; i++) {
                for (int j = 0; j < MatrizA[i].length; j++) {
                    MatrizA[i][j] = Integer.parseInt((String) EmatrizA.getValueAt(i, j));
                    matrizA.setValueAt(MatrizA[i][j], i, j);
                }
            }
            //BUCLE QUE REALIZARA LA OPERACION OPUESTA DE LA MATRIZ CAMBAINDO LOS SIGNOS DE LA MATRIZ A
            // Y PROCEDE A LLENAR LA MATRIZ GRAFICA DE RESULTADO
            for (int i = 0; i < matrizR.length; i++) {
                for (int j = 0; j < matrizR[i].length; j++) {
                    matrizR[i][j] = -(MatrizA[i][j]);
                    MatrizR.setValueAt(matrizR[i][j], i, j);
                }
            }
            //SENTENCIA EN LA CUAL SE EJECUTA UNA SERIE DE DECLARACIONES Y EVENTOS
            //SI DURANTE LA OPERACION DIERA UN ERROR
        } catch (Exception E) {
            //DECLARACIONES QUE OCULTARAN LAS TABLAS YA QUE ESTARAN VACIAS Y SERA INNECESARIAS MOSTRARLAS,SE OCULTAN
            // TAMBIEN SUS RESPECTIVOS SIGNOS 
            igual.setVisible(false);
            Signo.setVisible(false);
            //CLASE QUE NOS PERMITIRA MOSTRAR UN MENSAJE EN PANTALLA SI OCURRIERA UN ERROR EN LA OPERACION 
            JOptionPane.showMessageDialog(this, "Algunas casillas en la matrices estan vacias o contienen caracteres invalidos");
        }
    }
    //FIN DEL METODO
    
    //metodo que resuelve la operacion de opuesta A - B
    public void OPuestaAB() {
        //EL TRY-CATCH ES UNA DECLARACION QUE CUMPLE CON LA FINALIDAD DE HACER UN EVENTO SI
        //ES QUE QUE QUE LA OPERACION LLEGASE A FALLAR POR X MOTIVOS
        try {
            //SE LLAMÁ A LA METODO ,EL CUAL OCULTA ELEMENTOS ESPECIFICOS DE LA INTERFAZ
            Hide_Show(BanderaC);
            //DECLARACION DE VARIABLES TIPO ENTERO LAS CUALES ALMACENAN LOS DATOS INGRESADOS , LOS CUALES
            //SERIAN LAS DIMENSIONES M X N
            m1 = Integer.parseInt(this.M1.getText());
            n1 = Integer.parseInt(this.N1.getText());
            m2 = Integer.parseInt(this.M2.getText());
            n2 = Integer.parseInt(this.N2.getText());
            //DECLARACION DE LOS ARREGLOS BIDIMENSIONALES TIPO ENTERO QUE ALAMACENAN LOS DATOS DE
            // LA MATRIZ A , B Y LA MATRIZ RESULTANTE
            MatrizA = new int[m1][n1];
            MatrizB = new int[m2][n2];
            int[][] matrizR = new int[m2][n2];
            //DECLARACIONES QUE PERMITEN HACER MODIFICACIONES A LA TABLAS GRAFICAS DEL PROGRAMA
            //AQUI SE DAN LAS DIMENSIONES YA OBTENIDAS ARRIBA
            DefaultTableModel EmatrizA = (DefaultTableModel) MA.getModel();
            EmatrizA.setColumnCount(n1);
            EmatrizA.setRowCount(m1);
            DefaultTableModel EmatrizB = (DefaultTableModel) MA2.getModel();
            EmatrizB.setColumnCount(n1);
            EmatrizB.setRowCount(m1);
            DefaultTableModel matrizA = (DefaultTableModel) MA1.getModel();
            matrizA.setColumnCount(n1);
            matrizA.setRowCount(m1);
            DefaultTableModel matrizB = (DefaultTableModel) MB.getModel();
            matrizB.setColumnCount(n1);
            matrizB.setRowCount(m1);
            DefaultTableModel MatrizR = (DefaultTableModel) MR.getModel();
            MatrizR.setColumnCount(n1);
            MatrizR.setRowCount(m1);
            //BUCLE QUE NOS PERMITIRA LLENAR LA MATRIZA CON LOS DATOS DE LAS TABLAS
            // GRAFICAS
            for (int i = 0; i < MatrizA.length; i++) {
                for (int j = 0; j < MatrizA[i].length; j++) {
                    MatrizA[i][j] = Integer.parseInt((String) EmatrizA.getValueAt(i, j));
                    matrizA.setValueAt(MatrizA[i][j], i, j);
                }
            }
            //BUCLE QUE NOS PERMITIRA LLENAR LA MATRIZB CON LOS DATOS DE LAS TABLAS
            // GRAFICAS
            for (int i = 0; i < MatrizB.length; i++) {
                for (int j = 0; j < MatrizB[i].length; j++) {
                    MatrizB[i][j] = Integer.parseInt((String) EmatrizB.getValueAt(i, j));
                    matrizB.setValueAt(MatrizB[i][j], i, j);
                }
            }
            //BUCLE QUE REALIZARA LA OPERACION OPUESTA DE LA MATRIZ A - B , A LA MATRIZ A LE RESTAMOS LA MASTRIZ B
            //LO CUAL DARIA EL MISMO RESULTADO HACIENDO PRIMERO LA OPUESTA DE B Y SUMANDOLA A MATRIZ A
            // Y PROCEDE A LLENAR LA MATRIZ GRAFICA DE RESULTADO
            for (int i = 0; i < matrizR.length; i++) {
                for (int j = 0; j < matrizR[i].length; j++) {
                    matrizR[i][j] = MatrizA[i][j] - MatrizB[i][j];
                    MatrizR.setValueAt(matrizR[i][j], i, j);
                }
            }
            //SENTENCIA EN LA CUAL SE EJECUTA UNA SERIE DE DECLARACIONES Y EVENTOS
            //SI DURANTE LA OPERACION DIERA UN ERROR
        } catch (Exception E) {
            //DECLARACIONES QUE OCULTARAN LAS TABLAS YA QUE ESTARAN VACIAS Y SERA INNECESARIAS MOSTRARLAS,SE OCULTAN
            // TAMBIEN SUS RESPECTIVOS SIGNOS
            CA.setVisible(false);
            CB.setVisible(false);
            CResultado.setVisible(false);
            igual.setVisible(false);
            Signo.setVisible(false);
            //CLASE QUE NOS PERMITIRA MOSTRAR UN MENSAJE EN PANTALLA SI OCURRIERA UN ERROR EN LA OPERACION 
            JOptionPane.showMessageDialog(this, "Algunas casillas en las matrices estan vacias o contienen caracteres invalidos");
        }
    }
    //FIN DEL METODO
    
    //metodo que resuelve la operacion de transpuesta de A
    public void TranspuestaA() {
        try {
            //SE LLAMÁ A LA METODO ,EL CUAL OCULTA ELEMENTOS ESPECIFICOS DE LA INTERFAZ
            Hide_Show(BanderaC);
            //DECLARACION DE VARIABLES TIPO ENTERO LAS CUALES ALMACENAN LOS DATOS INGRESADOS , LOS CUALES
            //SERIAN LAS DIMENSIONES M X N 
            m1 = Integer.parseInt(this.M1.getText());
            n1 = Integer.parseInt(this.N1.getText());
            //DECLARACION DEL ARREGLO BIDIMENSIONAL TIPO ENTERO QUE ALAMACENAN LOS DATOS DE
            // LA MATRIZ A 
            MatrizA = new int[m1][n1];
            //ESTA DECLARACION DEL ARREGLO BIDIMENSIONAL TIPO ENTERO QUE ALAMACENAN LOS DATOS DE LA MATRIZ REULTANTE
            //OBTENDRA LA FILA DE A COMO COLUMNA Y LA COLUMNA COMO FILA 
            int[][] matrizR = new int[n1][m1];
            //DECLARACIONES QUE PERMITEN HACER MODIFICACIONES A LA TABLAS GRAFICAS DEL PROGRAMA
            //AQUI SE DAN LAS DIMENSIONES YA OBTENIDAS ARRIBA
            DefaultTableModel EmatrizA = (DefaultTableModel) MA.getModel();
            EmatrizA.setColumnCount(n1);
            EmatrizA.setRowCount(m1);
            DefaultTableModel matrizA = (DefaultTableModel) MA1.getModel();
            matrizA.setColumnCount(n1);
            matrizA.setRowCount(m1);
            DefaultTableModel MatrizR = (DefaultTableModel) MR.getModel();
            MatrizR.setColumnCount(m1);
            MatrizR.setRowCount(n1);
            //BUCLE QUE NOS PERMITIRA LLENAR LA MATRIZA CON LOS DATOS DE LAS TABLAS
            // GRAFICAS
            for (int i = 0; i < MatrizA.length; i++) {
                for (int j = 0; j < MatrizA[i].length; j++) {
                    MatrizA[i][j] = Integer.parseInt((String) EmatrizA.getValueAt(i, j));
                    matrizA.setValueAt(MatrizA[i][j], i, j);
                }
            }
            //BUCLE QUE REALIZARA LA OPERACION TRANSPUESTA DE LA MATRIZ A
            // Y PROCEDE A LLENAR LA MATRIZ GRAFICA DE RESULTADO
            for (int i = 0; i < matrizR.length; i++) {
                for (int j = 0; j < matrizR[i].length; j++) {
                    matrizR[i][j] = MatrizA[j][i];
                    MatrizR.setValueAt(matrizR[i][j], i, j);
                }
            }
            //SENTENCIA EN LA CUAL SE EJECUTA UNA SERIE DE DECLARACIONES Y EVENTOS
            //SI DURANTE LA OPERACION DIERA UN ERROR
        } catch (Exception E) {
            //DECLARACIONES QUE OCULTARAN LAS TABLAS YA QUE ESTARAN VACIAS Y SERA INNECESARIAS MOSTRARLAS,SE OCULTAN
            // TAMBIEN SUS RESPECTIVOS SIGNOS
            CA.setVisible(false);
            CB.setVisible(false);
            CResultado.setVisible(false);
            igual.setVisible(false);
            Signo.setVisible(false);
            //CLASE QUE NOS PERMITIRA MOSTRAR UN MENSAJE EN PANTALLA SI OCURRIERA UN ERROR EN LA OPERACION 
            JOptionPane.showMessageDialog(this, "Algunas casillas en la matrices estan vacias o contienen caracteres invalidos");
        }
    }
    //FIN DEL METODO
    
    //metodo que resuelve la operacion de traza A
    public void TrazaA() {
        try {
            //SE LLAMÁ A LA METODO ,EL CUAL OCULTA ELEMENTOS ESPECIFICOS DE LA INTERFAZ
            Hide_Show(BanderaC);
            //DECLARACION DE VARIABLES ENTERO LAS CUALES ALMACENAN LOS DATOS INGRESADOS , LOS CUALES
            //SERIAN LAS DIMENSIONES M X N 
            m1 = Integer.parseInt(this.M1.getText());
            n1 = Integer.parseInt(this.N1.getText());
            //DEACLARACION DEL ARREGLO BIDIMENSIONAL DE TIPO ENTERO QUE ALAMACENAN LOS DATOS DE
            // LA MATRIZ A 
            MatrizA = new int[m1][n1];
            //ESTA DECLARACION DE VARIABLE ENTERO ALAMACENARA EL RESULTADO DE LA TRAZ DE A 
            int traza = 0;
            //DECLARACIONES QUE PERMITEN HACER MODIFICACIONES A LA TABLAS GRAFICAS DEL PROGRAMA
            //AQUI SE DAN LAS DIMENSIONES YA OBTENIDAS ARRIBA
            DefaultTableModel EmatrizA = (DefaultTableModel) MA.getModel();
            EmatrizA.setColumnCount(n1);
            EmatrizA.setRowCount(m1);
            DefaultTableModel matrizA = (DefaultTableModel) MA1.getModel();
            matrizA.setColumnCount(n1);
            matrizA.setRowCount(m1);
            DefaultTableModel MatrizR = (DefaultTableModel) MR.getModel();
            MatrizR.setColumnCount(m1);
            MatrizR.setRowCount(n1);
            //BUCLE QUE NOS PERMITIRA LLENAR LA MATRIZA CON LOS DATOS DE LAS TABLAS
            // GRAFICAS
            for (int i = 0; i < MatrizA.length; i++) {
                for (int j = 0; j < MatrizA[i].length; j++) {
                    MatrizA[i][j] = Integer.parseInt((String) EmatrizA.getValueAt(i, j));
                    matrizA.setValueAt(MatrizA[i][j], i, j);
                }
            }
            //BUCLE QUE REALIZARA LA OPERACION TRAZA DE LA MATRIZ A
            //SUMANDO TODOS LOS ELEMENTOS DE LA DIAGONAL PRINCIPAL
            // Y PROCEDE A LLENAR LA MATRIZ GRAFICA DE RESULTADO
            for (int i = 0; i < m1 && i < n1; i++) {
                traza += MatrizA[i][i];
            }
            //SE ENVIA EL RESULTADO DE LA SUMA AL CUADRO DE RESULTADO
            Trazatxt.setText("" + traza);
            //SENTENCIA EN LA CUAL SE EJECUTA UNA SERIE DE DECLARACIONES Y EVENTOS
            //SI DURANTE LA OPERACION DIERA UN ERROR
        } catch (Exception E) {
            //DECLARACIONES QUE OCULTARAN LAS TABLAS YA QUE ESTARAN VACIAS Y SERA INNECESARIAS MOSTRARLAS,SE OCULTAN
            // TAMBIEN SUS RESPECTIVOS SIGNOS
            CA.setVisible(false);
            CB.setVisible(false);
            CResultado.setVisible(false);
            igual.setVisible(false);
            Signo.setVisible(false);
            //CLASE QUE NOS PERMITIRA MOSTRAR UN MENSAJE EN PANTALLA SI OCURRIERA UN ERROR EN LA OPERACION 
            JOptionPane.showMessageDialog(this, "Algunas casillas en la matrices estan vacias o contienen caracteres invalidos");
        }
    }
    //FIN DEL METODO
    
    //metodo que resuelve la operacion de Producto A * B
    public void Producto() {
        try {
            //SE LLAMÁ A LA METODO ,EL CUAL OCULTA ELEMENTOS ESPECIFICOS DE LA INTERFAZ
            Hide_Show(BanderaC);
            //DECLARACION DE VARIABLES TIPO ENTERO LAS CUALES ALMACENAN LOS DATOS INGRESADOS , LOS CUALES
            //SERIAN LAS DIMENSIONES M X N 
            m1 = Integer.parseInt(this.M1.getText());
            n1 = Integer.parseInt(this.N1.getText());
            m2 = Integer.parseInt(this.M2.getText());
            n2 = Integer.parseInt(this.N2.getText());
            //DEACLARACION DE LOS ARREGLOS BIDIMENSIONALES TIPO ENTERO QUE ALAMACENAN LOS DATOS DE
            // LA MATRIZ A , B Y LA MATRIZ RESULTANTE
            MatrizA = new int[m1][n1];
            MatrizB = new int[m2][n2];
            int[][] ProductoAB = new int[m1][n2];
            //DECLARACIONES QUE PERMITEN HACER MODIFICACIONES A LA TABLAS GRAFICAS DEL PROGRAMA
            //AQUI SE DAN LAS DIMENSIONES YA OBTENIDAS ARRIBA
            DefaultTableModel EmatrizA = (DefaultTableModel) MA.getModel();
            EmatrizA.setColumnCount(n1);
            EmatrizA.setRowCount(m1);
            DefaultTableModel EmatrizB = (DefaultTableModel) MA2.getModel();
            EmatrizB.setColumnCount(n2);
            EmatrizB.setRowCount(m2);
            DefaultTableModel matrizA = (DefaultTableModel) MA1.getModel();
            matrizA.setColumnCount(n1);
            matrizA.setRowCount(m1);
            DefaultTableModel matrizB = (DefaultTableModel) MB.getModel();
            matrizB.setColumnCount(n2);
            matrizB.setRowCount(m2);
            DefaultTableModel MatrizR = (DefaultTableModel) MR.getModel();
            MatrizR.setColumnCount(n2);
            MatrizR.setRowCount(m1);
            //BUCLE QUE NOS PERMITIRA LLENAR LA MATRIZA CON LOS DATOS DE LAS TABLAS
            // GRAFICAS
            for (int i = 0; i < MatrizA.length; i++) {
                for (int j = 0; j < MatrizA[i].length; j++) {
                    MatrizA[i][j] = Integer.parseInt((String) EmatrizA.getValueAt(i, j));
                    matrizA.setValueAt(MatrizA[i][j], i, j);
                }
            }
            //BUCLE QUE NOS PERMITIRA LLENAR LA MATRIZB CON LOS DATOS DE LAS TABLAS
            // GRAFICAS
            for (int i = 0; i < MatrizB.length; i++) {
                for (int j = 0; j < MatrizB[i].length; j++) {
                    MatrizB[i][j] = Integer.parseInt((String) EmatrizB.getValueAt(i, j));
                    matrizB.setValueAt(MatrizB[i][j], i, j);
                }
            }
            //BUCLE QUE REALIZARA LA OPERACION PRODUCTO DE LA MATRIZ A - B
            //PRIMERO SE RECORRE EL NUMERO DE FILAS DE LA MATRIZ DE A POSICION[N], LUEGO EL NUMERO DE COLUMNAS DE B[N], SE PROCEDE A 
            //INICIAR NUESTRA MATRIZ RESULTANTE EN 0, LUEGO SE RECORRE EL NUMERO DE FILAS DE LA MATRIZ B[N] ,
            //SE PROCEDE A LA OPERACION LA MATRIZ PRODUCTO(MATRIZ RESULTANTE) OBTENDRA LA SUMA DE LAS MULTIPLICACIONES
            //DE LAS FILAS DE LA MATRIZA POR LAS COLUMNAS DE LA MATRIZB
            //Y REPITE HASTA RECORRER AMBAS MATRIZ
            // Y SE PROCEDE A LLENAR LA MATRIZ GRAFICA DE RESULTADO
            for (int i = 0; i < m1; i++) {
                for (int j = 0; j < n2; j++) {
                    ProductoAB[i][j] = 0;
                    for (int y = 0; y < m2; y++) {
                        ProductoAB[i][j] += MatrizA[i][y] * MatrizB[y][j];
                    }
                    MatrizR.setValueAt(ProductoAB[i][j], i, j);
                }
            }
            //SENTENCIA EN LA CUAL SE EJECUTA UNA SERIE DE DECLARACIONES Y EVENTOS
            //SI DURANTE LA OPERACION DIERA UN ERROR
        } catch (Exception E) {
            //DECLARACIONES QUE OCULTARAN LAS TABLAS YA QUE ESTARAN VACIAS Y SERA INNECESARIAS MOSTRARLAS,SE OCULTAN
            // TAMBIEN SUS RESPECTIVOS SIGNOS
            CA.setVisible(false);
            CB.setVisible(false);
            CResultado.setVisible(false);
            igual.setVisible(false);
            Signo.setVisible(false);
            //CLASE QUE NOS PERMITIRA MOSTRAR UN MENSAJE EN PANTALLA SI OCURRIERA UN ERROR EN LA OPERACION 
            JOptionPane.showMessageDialog(this, "Algunas casillas en las matrices estan vacias o contienen caracteres invalidos");
        }
    }
    //FIN DEL METODO
    
    //metodo que resuelve la operacion de potencia A
    public void PotenciaA() {
        try {
            //SE LLAMÁ A LA METODO ,EL CUAL OCULTA ELEMENTOS ESPECIFICOS DE LA INTERFAZ
            Hide_Show(BanderaC);
            //DECLARACION DE VARIABLES TIPO ENTERO LAS CUALES ALMACENAN LOS DATOS INGRESADOS , LOS CUALES
            //SERIAN LAS DIMENSIONES M X N Y EL EXPONENTE
            p = Integer.parseInt(this.PText.getText());
            m1 = Integer.parseInt(this.M1.getText());
            n1 = Integer.parseInt(this.N1.getText());
            //DEACLARACION DE LOS ARREGLOS BIDIMENSIONALES TIPO ENTERO QUE ALAMACENAN LOS DATOS DE
            // LA MATRIZ A , B Y LA MATRIZ RESULTANTE
            Matriz1 = new int[m1][n1];
            MatrizE1 = new int[m1][n1];
            //DECLARACIONES QUE PERMITEN HACER MODIFICACIONES A LA TABLAS GRAFICAS DEL PROGRAMA
            //AQUI SE DAN LAS DIMENSIONES YA OBTENIDAS ARRIBA
            DefaultTableModel EmatrizA = (DefaultTableModel) MA.getModel();
            EmatrizA.setColumnCount(n1);
            EmatrizA.setRowCount(m1);
            DefaultTableModel matrizA = (DefaultTableModel) MA1.getModel();
            matrizA.setColumnCount(n1);
            matrizA.setRowCount(m1);
            DefaultTableModel MatrizR = (DefaultTableModel) MR.getModel();
            MatrizR.setColumnCount(n1);
            MatrizR.setRowCount(m1);
            //BUCLE QUE NOS PERMITIRA LLENAR LA MATRIZA CON LOS DATOS DE LAS TABLAS
            // GRAFICAS
            for (int i = 0; i < Matriz1.length; i++) {
                for (int j = 0; j < Matriz1[i].length; j++) {
                    Matriz1[i][j] = Integer.parseInt((String) EmatrizA.getValueAt(i, j));
                    matrizA.setValueAt(Matriz1[i][j], i, j);
                }
            }
            //ESTE ARREGLO BIDIMENSIONAL ALMACENARA EL RESULTADO QUE RETORNE LA FUNCION POTENCIAA
            //SE LE ENVIA LA MATRIZ , EL EXPONENTE Y LA DIMENSION
            MatrizE1 = PotenciA(Matriz1, p, m1);
            //BUCLE QUE REALIZARA LA OPERACION OPUESTA DE LA MATRIZ A - B
            // Y PROCEDE A LLENAR LA MATRIZ GRAFICA DE RESULTADO
            for (int i = 0; i < MatrizE1.length; i++) {
                for (int j = 0; j < MatrizE1[i].length; j++) {
                    MatrizR.setValueAt(MatrizE1[i][j], i, j);
                }
            }
            //SENTENCIA EN LA CUAL SE EJECUTA UNA SERIE DE DECLARACIONES Y EVENTOS
            //SI DURANTE LA OPERACION DIERA UN ERROR
        } catch (Exception E) {
            //DECLARACIONES QUE OCULTARAN LAS TABLAS YA QUE ESTARAN VACIAS Y SERA INNECESARIAS MOSTRARLAS,SE OCULTAN
            // TAMBIEN SUS RESPECTIVOS SIGNOS
            CA.setVisible(false);
            CB.setVisible(false);
            CResultado.setVisible(false);
            igual.setVisible(false);
            Signo.setVisible(false);
            //CLASE QUE NOS PERMITIRA MOSTRAR UN MENSAJE EN PANTALLA SI OCURRIERA UN ERROR EN LA OPERACION 
            JOptionPane.showMessageDialog(this, "Algunas casillas en la matrices estan vacias o contienen caracteres invalidos");
        }
    }
    //FIN DEL METODO
    
    //funcion recursiva que realiza la operacion de la potencia y devuelve el resultado final 
    //FUNCION RECURSIVA QUE PERMITIRA REALIZAR LA OPERACION DE POTENCIA MAS OPTIMA
    //RECIBE UNA MATRIZ , UN EXPONENTE Y UNA DIMENSION
    public int[][] PotenciA(int[][] Matriz, int p, int m) {
        //VERIFICAMOS SI EL EXPONENTE ES UN NUMERO MAYOR QUE 0 SI ES VERDADERO
        //SE PROCEDE CON LA OPERACION SOLICITADA
        if (p > 0) {
            //DECLACARION DE VARIABLE  TIPO ENTERO QUE NOS PERMITIRA CONTROLAS LAS VECES 
            //QUE SE REPETIRA EL PRODUCTO DE LA MATRIZ
            int i = 1;
            //DECLARACION DE ARREGLO BIDIMENSIONAL TIPO ENTERO QUE ALMACENARA TEMPORALMENTE EL RESULTADO 
            //DE LA OPERACION
            int[][] MatrizP = new int[m][m];
            //CONDICION QUE NOS PERIMITIRA CONTROLAR LAS VECES 
            //QUE SE REPETIRA EL PRODUCTO DE LA MATRIZ
            if (i < p) {
                //BUCLE QUE REALIZARA LA OPERACION PRODUCTO DE LA MATRIZ A - B
                //PRIMERO SE RECORRE EL NUMERO DE FILAS DE LA MATRIZ DE A POSICION[N], LUEGO EL NUMERO DE COLUMNAS DE B[N], SE PROCEDE A 
                //INICIAR NUESTRA MATRIZ RESULTANTE EN 0, LUEGO SE RECORRE EL NUMERO DE FILAS DE LA MATRIZ B[N] ,
                //SE PROCEDE A LA OPERACION LA MATRIZ PRODUCTO(MATRIZ RESULTANTE) OBTENDRA LA SUMA DE LAS MULTIPLICACIONES
                //DE LAS FILAS DE LA MATRIZA POR LAS COLUMNAS DE LA MATRIZB
                //Y REPITE HASTA RECORRER AMBAS MATRIZ
                for (int j = 0; j < Matriz.length; j++) {
                    for (int k = 0; k < Matriz[j].length; k++) {
                        MatrizP[j][k] = 0;
                        for (int l = 0; l < Matriz.length; l++) {
                            MatrizP[j][k] += Matriz[j][l] * Matriz1[l][k];
                        }
                    }
                }
                //SENTENCIA QUE VOLVERA A LLAMAR A ESTA MISMA FUNCIN ENVIANDOLE LA MATRIZ TEMPORAL
                //RESULTANTE , EL EXPONENTE RESTADO EN 1 Y SE VUELVE A ENVIAR LA MISMA DIMENSION DE LA MATRIZ
                //SE REALIZARA ESTO HASTA QUE EL EXPONENTE SEA 0
                return PotenciA(MatrizP, p - 1, m);
            }
            //SENTENCIA QUE PERMITE ENVIAR LA MATRIZ RESULTANTE FINAL SOLICITADA
            return Matriz;
            // SI EL EXPONENTE RESULTA SER IGUAL A 0 SE PROCEDE A REALIZAR UNA MATRIZ IDENTIDAD
            //DE DIMENSIONES INGRESADAS 
        } else if (p == 0) {
            for (int i = 0; i < Matriz.length; i++) {
                for (int j = 0; j < Matriz[i].length; j++) {
                    if (i == j && j == i) {
                        Matriz[i][j] = 1;
                    } else {
                        Matriz[i][j] = 0;
                    }
                }
            }
            //SENTENCIA QUE PERMITE ENVIAR LA MATRIZ RESULTANTE FINAL SOLICITADA
            return Matriz;
            // SI EL EXPONENTE RESULTA SER MENOR A 0 SE PROCEDE A REALIZAR UNA MATRIZ IDENTIDAD
            //DE DIMENSIONES INGRESADAS 
        } else {
            //DECLARACIONES QUE OCULTARAN LAS TABLAS YA QUE ESTARAN VACIAS Y SERA INNECESARIAS MOSTRARLAS,SE OCULTAN
            // TAMBIEN SUS RESPECTIVOS SIGNOS
            CA.setVisible(false);
            CB.setVisible(false);
            CResultado.setVisible(false);
            igual.setVisible(false);
            Signo.setVisible(false);
            //CLASE QUE NOS PERMITIRA MOSTRAR UN MENSAJE EN PANTALLA EL CUAL IDICARA QUE EL RESULTADO ES NULO
            //YA QUE QUE SE TENDRIA QUE REALIZAR LA INVERSA Y SERIA OTRO METODO FUERA DEL TEMA
            JOptionPane.showMessageDialog(this, "el resultado de la potencia es 0");
        }
        //SENTENCIA QUE PERMITE ENVIAR LA MATRIZ RESULTANTE FINAL SOLICITADA
        return Matriz;
    }
    //FIN DE LA FUNCION RECURSIVA
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accep;
    private javax.swing.JButton Borrar;
    private javax.swing.JPanel CA;
    private javax.swing.JPanel CB;
    private javax.swing.JPanel CEA;
    private javax.swing.JPanel CEB;
    private javax.swing.JPanel CResultado;
    private javax.swing.JButton Calculo;
    private javax.swing.JPanel Creditos;
    private javax.swing.JLabel EXP;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Info;
    private javax.swing.JTextField M1;
    private javax.swing.JTextField M2;
    private javax.swing.JTable MA;
    private javax.swing.JTable MA1;
    private javax.swing.JTable MA2;
    private javax.swing.JTable MB;
    private javax.swing.JTable MR;
    private javax.swing.JTextField N1;
    private javax.swing.JTextField N2;
    private javax.swing.JButton Opuesta;
    private javax.swing.JButton OpuestaAB;
    private javax.swing.JTextField PText;
    private javax.swing.JButton Potencia;
    private javax.swing.JButton Producto;
    private javax.swing.JLabel Signo;
    private javax.swing.JLabel Signo1;
    private javax.swing.JLabel SignoA;
    private javax.swing.JLabel SignoB;
    private javax.swing.JButton Suma;
    private javax.swing.JButton Transpuesta;
    private javax.swing.JButton Traza;
    private javax.swing.JTextField Trazatxt;
    private javax.swing.JLabel igual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelA;
    private javax.swing.JLabel labelB;
    // End of variables declaration//GEN-END:variables
}
