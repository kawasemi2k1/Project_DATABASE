package GUI;



import javax.mail.PasswordAuthentication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.security.auth.kerberos.ServicePermission;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Product_hethan_Guimail extends javax.swing.JPanel {
    DefaultTableModel tbn = new DefaultTableModel();
    
    public Product_hethan_Guimail() {
        initComponents();
        loadData();
         
    }
     public void sendmail(String mail) {
        try {
            Email email = new SimpleEmail();

            // Cấu hình thông tin Email Server
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("hellomoinguinhe@gmail.com", "hello135792468")); //Nhớ nhập đúng với tài khoản thật nhé :))

            // Với gmail cái này là bắt buộc.
            email.setSSLOnConnect(true);

            // Người gửi
            email.setFrom("hellomoinguinhe@gmail.com", "Công chúa phép thuật");

            // Tiêu đề
            email.setSubject("Ta sẽ trùng trị ngươi"); //Tiêu đề khi gửi email

            // Nội dung email
            //String covert = String.valueOf(rand);
            email.setMsg("Hãy xem đây, biến hình Winx\\n EN CHAN TÍT\\n"); //Nội dung email bạn muốn gửi.
            // Người nhận
            email.addTo(mail); //Đia chỉ email người nhận
            email.send(); //Thực hiện gửi.
            System.err.println("Gửi email thành công ! Vui lòng kiểm tra email !");
            System.out.println("\n");
        } catch (Exception e) {
            System.out.println("Gửi không thành công !");
            System.out.println("");
        }
    }
     
     
      public void loadData() {
        try {
            Connect a = new Connect();
            Connection conn = a.getConnectDB();
            int number;
            Vector row,column;
            column = new Vector();
            Statement st =conn.createStatement();
            String sql_hetdate = "Select SG.product_id,PPRO.product_name ,PPRO.price, "
                    + "SG.good_till,SG.discount from sales.goods as SG inner join production.products as PPRO "
                    + "on SG.product_id = PPRO.product_id where( DATEDIFF(day,getdate(),SG.good_till) between 0 and 30)";
            ResultSet rs =st.executeQuery(sql_hetdate);
            ResultSetMetaData metadata =rs.getMetaData();
            number = metadata.getColumnCount();
            
            for(int i=1;i<=number;i++){
                column.add(metadata.getColumnName(i));
            }
            tbn.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<=number;i++){    
                    row.addElement(rs.getString(i));      
                }
                tbn.addRow(row);
                jTable1.setModel(tbn);  
            } 
            jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
             //nap du lieu tu jtable len textfield
               public void valueChanged (ListSelectionEvent e){
                   if(jTable1.getSelectedRow()>= 0){
                       txtproduct_id.setText(jTable1.getValueAt(jTable1.getSelectedRow(),0)+ "");
                       txtproduct_name.setText(jTable1.getValueAt(jTable1.getSelectedRow(),1)+ "");
                       txtprice.setText(jTable1.getValueAt(jTable1.getSelectedRow(),2)+ "");
                       txt_date.setText(jTable1.getValueAt(jTable1.getSelectedRow(),3)+ "");
                       txt_discount.setText(jTable1.getValueAt(jTable1.getSelectedRow(),4)+ "");                 
                       
                   } 
                }
           });
           
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        TKbancham = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnsend = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtproduct_id = new javax.swing.JTextField();
        txtproduct_name = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txt_date = new javax.swing.JTextField();
        txt_discount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_suadiscout = new javax.swing.JButton();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bgtksp.png"))); // NOI18N

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setLayout(null);

        TKbancham.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        TKbancham.setForeground(new java.awt.Color(0, 0, 153));
        TKbancham.setText("THỐNG KÊ MẶT HÀNG SẮP HẾT HẠN");
        add(TKbancham);
        TKbancham.setBounds(130, 20, 670, 100);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(70, 300, 760, 402);

        btnsend.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsend.setText("Send");
        btnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendActionPerformed(evt);
            }
        });
        add(btnsend);
        btnsend.setBounds(740, 160, 73, 25);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Gửi Email");
        add(jLabel5);
        jLabel5.setBounds(610, 160, 100, 30);

        txtproduct_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproduct_idActionPerformed(evt);
            }
        });
        add(txtproduct_id);
        txtproduct_id.setBounds(190, 120, 90, 22);

        txtproduct_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproduct_nameActionPerformed(evt);
            }
        });
        add(txtproduct_name);
        txtproduct_name.setBounds(190, 170, 90, 22);

        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        add(txtprice);
        txtprice.setBounds(440, 120, 110, 22);

        txt_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dateActionPerformed(evt);
            }
        });
        add(txt_date);
        txt_date.setBounds(440, 170, 110, 22);

        txt_discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_discountActionPerformed(evt);
            }
        });
        add(txt_discount);
        txt_discount.setBounds(440, 210, 110, 22);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Mã Sản Phẩm");
        add(jLabel3);
        jLabel3.setBounds(80, 120, 90, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Tên Sản Phẩm");
        add(jLabel4);
        jLabel4.setBounds(84, 170, 90, 17);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Giá");
        add(jLabel6);
        jLabel6.setBounds(330, 120, 30, 17);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Hạn sử dụng");
        add(jLabel7);
        jLabel7.setBounds(330, 170, 80, 17);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Khuyến mãi");
        add(jLabel8);
        jLabel8.setBounds(330, 210, 80, 17);

        btn_suadiscout.setText("Sửa");
        btn_suadiscout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suadiscoutActionPerformed(evt);
            }
        });
        add(btn_suadiscout);
        btn_suadiscout.setBounds(610, 120, 110, 25);
    }// </editor-fold>//GEN-END:initComponents

    
 
    private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendActionPerformed
        // TODO add your handling code here:
     try{
        Connect a = new Connect();
        Connection conn =a.getConnectDB();
        String sql_mail = "Select email from vRealCustomer";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql_mail);
        while ( rs.next()){         
                sendmail(rs.getString("email"));   
        }
     }catch( Exception ex){
         System.out.println(ex.toString());
     }
                            
    }//GEN-LAST:event_btnsendActionPerformed

    private void txt_discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_discountActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void txt_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dateActionPerformed

    private void txtproduct_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproduct_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproduct_idActionPerformed

    private void txtproduct_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproduct_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproduct_nameActionPerformed

    private void btn_suadiscoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suadiscoutActionPerformed
        // TODO add your handling code here:
        try{
            Connect a = new Connect();
            Connection conn =a.getConnectDB(); 
            PreparedStatement comm =conn.prepareStatement(" Update sales.goods set discount=? where product_id=?");
            
            comm.setString(2,txtproduct_id.getText());
            comm.setString(1, txt_discount.getText());
            comm.executeUpdate();
            tbn.setRowCount(0);
            loadData();
            JOptionPane.showMessageDialog(this, "Sửa thành công ");
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
        
    }//GEN-LAST:event_btn_suadiscoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TKbancham;
    private javax.swing.JButton btn_suadiscout;
    private javax.swing.JButton btnsend;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_discount;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtproduct_id;
    private javax.swing.JTextField txtproduct_name;
    // End of variables declaration//GEN-END:variables
}
