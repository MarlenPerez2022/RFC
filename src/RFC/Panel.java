/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package RFC;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Len
 */
public class Panel extends javax.swing.JPanel {
    private String nombre,primerapellido,segundoapellido,dia,mes,ano,fechaNacimiento,contenido;
    private int diaN,mesN,anoN;
    private String RFC = "";
    /**
     * Creates new form Panel
     */
    public Panel() {
        initComponents();
        nombre = txtNombre.getText();
        primerapellido = txtPrimerApellido.getName();
        segundoapellido = txtSegundoApellido.getName();
        dia = cboDia.getSelectedItem().toString();
        mes = cboMes.getSelectedItem().toString();
        ano = cboAnio.getSelectedItem().toString();
        fechaNacimiento = dia + "/" + mes + "/" + ano;
        contenido = nombre + "," + primerapellido + "," + segundoapellido + "," + fechaNacimiento + "\n"; 
    }
    public String generarRFC(String nombre, String primerApellido, String segundoApellido,
                                    int dia, int mes, int ano) {
        // Convertir nombres y apellidos a mayúsculas y remover espacios en blanco
        nombre = nombre.toUpperCase().replace(" ", "");
        primerApellido = primerApellido.toUpperCase().replace(" ", "");
        segundoApellido = segundoApellido.toUpperCase().replace(" ", "");

        // Tomar las primeras dos letras del primer apellido
        StringBuilder rfc = new StringBuilder(primerApellido.substring(0, 2));

        // Si el segundo apellido está presente, tomar la primera letra
        if (!segundoApellido.isEmpty()) {
            rfc.append(segundoApellido.charAt(0));
        } else {
            // Si no hay segundo apellido, agregar un "X"
            rfc.append('X');
        }

        // Tomar la primera letra del nombre
        rfc.append(nombre.charAt(0));

        // Agregar los últimos dos dígitos del año
        rfc.append(String.valueOf(ano).substring(2));

        // Agregar el mes y día en formato de dos dígitos
        rfc.append(String.format("%02d", mes));
        rfc.append(String.format("%02d", dia));

        // Agregar el estado en formato de dos letras
        //rfc.append(estado.toUpperCase()); - no necesario para el RFC,
        
        
       //Agregar linea de separacion a la homoclave 
       rfc.append('-');

        // Agregar la homoclave (tres caracteres aleatorios)
        StringBuilder homoclave = new StringBuilder();
        Random random = new Random();
        String caracteresPermitidos = "0123456789ABCDEFGHIJKLMNPQRSTUVWXYZ";
        for (int i = 0; i < 2; i++) {
            homoclave.append(caracteresPermitidos.charAt(random.nextInt(caracteresPermitidos.length())));
        }
        rfc.append(homoclave);

        // Agregar el dígito verificador
        rfc.append(calcularDigitoVerificador(rfc.toString()));

        return rfc.toString();
    }

    private static char calcularDigitoVerificador(String rfc) {
        String diccionarioRFC = "0123456789ABCDEFGHIJKLMN&OPQRSTUVWXYZ Ñ";
        int suma = 0;
        for (int i = 0; i < 13; i++) {
            suma += diccionarioRFC.indexOf(rfc.charAt(i)) * (13 - i);
        }
        int residuo = suma % 11;
        if (residuo == 0) {
            return '0';
        } else {
            return Character.forDigit(11 - residuo, 10);
        }
    }


    public String getRFC() {
        RFC = this.generarRFC(getNombre(), getPrimerapellido(), getSegundoapellido(), getDiaN(), getMesN(), getAnoN());
        
        return RFC;
    }

   public int getDiaN(){ 
       diaN=Integer.parseInt(this.getDia());
       return diaN;
   }
  
   
    public int getMesN(){ 
       mesN=Integer.parseInt(this.getMes());
       return mesN;
   }
     public int getAnoN(){ 
       anoN=Integer.parseInt(this.getAno());
       return anoN;
   }
    public String getContenido() {
        contenido = getNombre() + "," + getPrimerapellido() + "," + getSegundoapellido() + "," + getFechaNacimiento() + "\n" ; 
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechaNacimiento() {
         fechaNacimiento = getDia() + "/" + getMes() + "/" + getAno();
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        nombre = txtNombre.getText();
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerapellido() {
        primerapellido = txtPrimerApellido.getText();
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        segundoapellido = txtSegundoApellido.getText();
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public String getDia() {
        dia = cboDia.getSelectedItem().toString();
        return dia;
    }

    public void setDia(String dia) {        
        this.dia = dia;
    }

    public String getMes() {
         mes = cboMes.getSelectedItem().toString();
        return mes;
    }

    public void setMes(String mes) {   
        this.mes = mes;
    }

    public String getAno() {
        ano = cboAnio.getSelectedItem().toString();
        return ano;
    }

    public void setAno(String ano) {        
        this.ano = ano;
    }

 
    
    public void requerimiento(){
     if(txtNombre.getText().isEmpty()){
           btnAceptar.setEnabled(false);}
       else{
         if(txtPrimerApellido.getText().isEmpty()){ 
             btnAceptar.setEnabled(false);}
         else{
             
            if(txtSegundoApellido.getText().isEmpty()){
            btnAceptar.setEnabled(false);
            }else{btnAceptar.setEnabled(true);} 
         } 
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrimerApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSegundoApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cboDia = new javax.swing.JComboBox<>();
        cboMes = new javax.swing.JComboBox<>();
        cboAnio = new javax.swing.JComboBox<>();
        btnAceptar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Solucitud de RFC");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Ingrese sus Datos Personales");

        jLabel3.setText("Nombre(s): ");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel4.setText("Primer Apellido:");

        txtPrimerApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrimerApellidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrimerApellidoFocusLost(evt);
            }
        });
        txtPrimerApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrimerApellidoActionPerformed(evt);
            }
        });

        jLabel5.setText("Segundo Apellido:");

        txtSegundoApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSegundoApellidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSegundoApellidoFocusLost(evt);
            }
        });
        txtSegundoApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSegundoApellidoActionPerformed(evt);
            }
        });

        jLabel6.setText("Dia ");

        jLabel7.setText("Mes ");

        jLabel9.setText("Año");

        cboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cboDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDiaActionPerformed(evt);
            }
        });

        cboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMesActionPerformed(evt);
            }
        });

        cboAnio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100", " " }));
        cboAnio.setSelectedIndex(124);
        cboAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAnioActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel8.setText("Fecha de nacimiento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel8))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addGap(90, 90, 90)
                .addComponent(jLabel7)
                .addGap(85, 85, 85)
                .addComponent(jLabel9))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(btnAceptar)
                .addGap(8, 8, 8)
                .addComponent(btnLimpiar)
                .addGap(8, 8, 8)
                .addComponent(btnCerrar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAceptar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCerrar)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSegundoApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSegundoApellidoActionPerformed
         requerimiento();        // TODO add your handling code here:
    }//GEN-LAST:event_txtSegundoApellidoActionPerformed

    private void cboDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDiaActionPerformed
          // TODO add your handling code here:

    }//GEN-LAST:event_cboDiaActionPerformed

    private void cboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMesActionPerformed
          // TODO add your handling code here:

    }//GEN-LAST:event_cboMesActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
    // Obtener el contenido y el RFC
    String contenido = this.getContenido();
    String rfc = this.getRFC();
    
    // Obtener la ruta del archivo
    String ruta = "C:\\Users\\Len\\Documents\\RFC\\src\\RFC";
    String nombreArchivo = "datos.txt";
    
    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(ruta + "\\" + nombreArchivo, true));
        writer.write(contenido + ", " + rfc); // Escribir el contenido y el RFC en el archivo
        writer.newLine(); // Agregar una nueva línea después de cada registro
        writer.close();
        
        JOptionPane.showMessageDialog(this, "Datos guardados correctamente en el archivo.");
    } catch (IOException e) {
        System.err.println("Error al escribir en el archivo: " + e.getMessage());
    }        
    
    //System.out.print(contenido); // Esto es solo para comprobación
    //System.out.print(rfc);        
    
    System.out.print(this.getContenido());
    System.out.print(getRFC());
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
      System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtNombre.setText("");
        txtPrimerApellido.setText("");
        txtSegundoApellido.setText("");
        
        cboDia.setSelectedItem("01");
        cboMes.setSelectedItem("01");
        cboAnio.setSelectedItem("2005");        
        requerimiento();  
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
     // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtPrimerApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrimerApellidoActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_txtPrimerApellidoActionPerformed

    private void cboAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAnioActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_cboAnioActionPerformed

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
      requerimiento();        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
    requerimiento();        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtPrimerApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrimerApellidoFocusLost
    requerimiento();          // TODO add your handling code here:
    }//GEN-LAST:event_txtPrimerApellidoFocusLost

    private void txtPrimerApellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrimerApellidoFocusGained
requerimiento();          // TODO add your handling code here:
    }//GEN-LAST:event_txtPrimerApellidoFocusGained

    private void txtSegundoApellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSegundoApellidoFocusGained
requerimiento();          // TODO add your handling code here:
    }//GEN-LAST:event_txtSegundoApellidoFocusGained

    private void txtSegundoApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSegundoApellidoFocusLost
requerimiento();          // TODO add your handling code here:
    }//GEN-LAST:event_txtSegundoApellidoFocusLost

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
          
     // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboAnio;
    private javax.swing.JComboBox<String> cboDia;
    private javax.swing.JComboBox<String> cboMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtSegundoApellido;
    // End of variables declaration//GEN-END:variables

   
}
