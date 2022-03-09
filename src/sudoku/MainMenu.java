/*

    Project: Sudoku(6x6) Game.

    Name: Himanshu Sajwan
    Admission No: 2014402
    Enrollment No: GE-192014402
    Course: B.Tech C.S.E.

    Section: E
    Roll No: 30

    Starting date: 22-October-2020.
    Compeletion date: 28-October-2020.

*/
package sudoku;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.JOptionPane;



// This class works as Main Menu to start game.
public class MainMenu extends javax.swing.JFrame {

    int posX,posY;
    Font NameFont,AboutFont,HowToPlayFont;
    
    public MainMenu() {
        
        makeFont(); //Initialising custom font.
        initComponents();
            
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();
        PlayButton = new javax.swing.JButton();
        AboutButton = new javax.swing.JButton();
        DragLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BackgroundImageLable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        MainPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        MainPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        MainPanel.setLayout(null);

        ExitButton.setBackground(new java.awt.Color(240, 143, 37));
        ExitButton.setFont(NameFont);
        ExitButton.setText("EXIT");
        ExitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        MainPanel.add(ExitButton);
        ExitButton.setBounds(90, 310, 220, 70);

        PlayButton.setBackground(new java.awt.Color(240, 143, 37));
        PlayButton.setFont(NameFont);
        PlayButton.setText("PLAY");
        PlayButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButtonActionPerformed(evt);
            }
        });
        MainPanel.add(PlayButton);
        PlayButton.setBounds(90, 200, 220, 70);

        AboutButton.setBackground(new java.awt.Color(204, 255, 204));
        AboutButton.setFont(AboutFont);
        AboutButton.setText("About");
        AboutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutButtonActionPerformed(evt);
            }
        });
        MainPanel.add(AboutButton);
        AboutButton.setBounds(140, 410, 120, 50);

        DragLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        DragLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                DragLabelMouseDragged(evt);
            }
        });
        DragLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DragLabelMousePressed(evt);
            }
        });
        MainPanel.add(DragLabel);
        DragLabel.setBounds(0, 0, 400, 30);

        NameLabel.setForeground(new java.awt.Color(255, 0, 0));
        NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/Simple_Sudoku_Image.png"))); // NOI18N
        MainPanel.add(NameLabel);
        NameLabel.setBounds(0, 30, 400, 130);

        jButton1.setFont(HowToPlayFont);
        jButton1.setText("How To Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        MainPanel.add(jButton1);
        jButton1.setBounds(120, 490, 160, 30);

        BackgroundImageLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/Sudoku_Board_Image.jpg"))); // NOI18N
        MainPanel.add(BackgroundImageLable);
        BackgroundImageLable.setBounds(5, 5, 390, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(400, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     final void makeFont(){
         
        try {
            NameFont = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/data/font/Main_Menu_Arcade_Font.ttf")).deriveFont(40f);
            AboutFont = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/data/font/Main_Menu_Arcade_Font.ttf")).deriveFont(18f);
            HowToPlayFont=Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/data/font/Main_Menu_Arcade_Font.ttf")).deriveFont(15f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(NameFont);  
            ge.registerFont(AboutFont);
            ge.registerFont(HowToPlayFont);
            
        } 
        catch (IOException | FontFormatException e) {
            JOptionPane.showMessageDialog(this,e);
        }
        
    }
    
    
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed

        System.exit(0);
       
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void PlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayButtonActionPerformed
       
        new Game().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_PlayButtonActionPerformed

    private void AboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutButtonActionPerformed

        new About(getX(), getY() + 90).setVisible(true);
      
    }//GEN-LAST:event_AboutButtonActionPerformed

    private void DragLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DragLabelMouseDragged

       int CoordinateX = evt.getXOnScreen();
       int CoordinateY = evt.getYOnScreen();
       this.setLocation(CoordinateX - posX,CoordinateY - posY);
        
    }//GEN-LAST:event_DragLabelMouseDragged

    private void DragLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DragLabelMousePressed
       
        posX = evt.getX();
        posY = evt.getY();
        
    }//GEN-LAST:event_DragLabelMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       new Rules(getX(),getY()).setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutButton;
    private javax.swing.JLabel BackgroundImageLable;
    private javax.swing.JLabel DragLabel;
    private javax.swing.JButton ExitButton;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton PlayButton;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
