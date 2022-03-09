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

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.JOptionPane;

// This class shows Report of currently played game.
public final class Report extends javax.swing.JFrame {
    int min,sec,Emin,Esec,Score,Bonus,posX,posY;
    String NAME;
    boolean Status;
    Font HeadingFont,DataFont;
       
    
    public Report(){
        makeFont();
        initComponents();
        invisible();
        
    }
    
    
    public Report(String name, int bonus, int score, boolean status, int total_time_taken, int extra_time_taken, int posx, int posy){
       
        makeFont(); //Initialising custom font.
        initComponents();
        invisible(); //Hiding JFrame texture, only showing Report_Image_Scroll.png image.
        posX = posx;
        posY = posy;
        while(total_time_taken >= 60){
            total_time_taken -= 60;
            min++;
        }
        sec = total_time_taken;
        
        while(extra_time_taken >= 60){
            extra_time_taken -= 60;
            Emin++;
        }
        Esec = extra_time_taken;
        
        NAME = name;
        Bonus = bonus;
        Score = score;
        Status = status;
        
        message(); //Printing win or lose message.
        print(); //Printing player information.
        setLocation(); //Setting location relative to Game.java
        
    }

    void makeFont(){ //Function to initialise custom fonts.
        
        try {
            DataFont = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/data/font/Game_Report_Data_Font.ttf")).deriveFont(20f);
            HeadingFont=Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/data/font/Game_Report_Heading_Font.ttf")).deriveFont(40f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(DataFont);
            ge.registerFont(HeadingFont);
        }
        catch (IOException | FontFormatException e) {
            JOptionPane.showMessageDialog(this,e);
        }
    }
    
    private void setLocation(){ // function to set Reort.java location relative to Game.java
        setLocation(posX,posY);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        GameReportLabel = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton();
        NAMEABEL = new javax.swing.JLabel();
        SCORELABEL = new javax.swing.JLabel();
        TIMETAKENLABEL = new javax.swing.JLabel();
        EXTRATIMETAKENLABEL = new javax.swing.JLabel();
        BONUSLABEL = new javax.swing.JLabel();
        BonusLabel = new javax.swing.JLabel();
        ScoreLabel = new javax.swing.JLabel();
        ExtraTimeTakenLabel = new javax.swing.JLabel();
        TimeTakenLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        STATUSLABEL = new javax.swing.JLabel();
        StatusLabel = new javax.swing.JLabel();
        DragLabel = new javax.swing.JLabel();
        BackgroundImageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

        MainPanel.setOpaque(false);
        MainPanel.setLayout(null);

        GameReportLabel.setFont(HeadingFont);
        GameReportLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GameReportLabel.setText("Game  Report ");
        MainPanel.add(GameReportLabel);
        GameReportLabel.setBounds(40, 100, 320, 50);

        OKButton.setBackground(new java.awt.Color(204, 153, 0));
        OKButton.setFont(DataFont);
        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });
        MainPanel.add(OKButton);
        OKButton.setBounds(300, 400, 50, 30);

        NAMEABEL.setFont(DataFont);
        NAMEABEL.setText("Name                                  :-");
        MainPanel.add(NAMEABEL);
        NAMEABEL.setBounds(70, 170, 150, 30);

        SCORELABEL.setFont(DataFont);
        SCORELABEL.setText("Score                               :-");
        MainPanel.add(SCORELABEL);
        SCORELABEL.setBounds(70, 250, 150, 30);

        TIMETAKENLABEL.setFont(DataFont);
        TIMETAKENLABEL.setText("Total Time Taken   :-");
        MainPanel.add(TIMETAKENLABEL);
        TIMETAKENLABEL.setBounds(70, 380, 150, 30);

        EXTRATIMETAKENLABEL.setFont(DataFont);
        EXTRATIMETAKENLABEL.setText("Extra Time Taken   :-");
        MainPanel.add(EXTRATIMETAKENLABEL);
        EXTRATIMETAKENLABEL.setBounds(70, 340, 150, 30);

        BONUSLABEL.setFont(DataFont);
        BONUSLABEL.setText("Bonus                              :-");
        MainPanel.add(BONUSLABEL);
        BONUSLABEL.setBounds(70, 210, 150, 30);

        BonusLabel.setFont(DataFont);
        BonusLabel.setText("5");
        MainPanel.add(BonusLabel);
        BonusLabel.setBounds(230, 210, 140, 30);

        ScoreLabel.setFont(DataFont);
        ScoreLabel.setText("55");
        MainPanel.add(ScoreLabel);
        ScoreLabel.setBounds(230, 250, 140, 30);

        ExtraTimeTakenLabel.setFont(DataFont);
        ExtraTimeTakenLabel.setText("00 : 00");
        MainPanel.add(ExtraTimeTakenLabel);
        ExtraTimeTakenLabel.setBounds(230, 340, 140, 30);

        TimeTakenLabel.setFont(DataFont);
        TimeTakenLabel.setText("01 : 20");
        MainPanel.add(TimeTakenLabel);
        TimeTakenLabel.setBounds(230, 380, 140, 30);

        NameLabel.setFont(DataFont);
        NameLabel.setText("Himanshu Sajwan");
        MainPanel.add(NameLabel);
        NameLabel.setBounds(230, 170, 140, 30);

        STATUSLABEL.setFont(DataFont);
        STATUSLABEL.setText("Status                              :-");
        MainPanel.add(STATUSLABEL);
        STATUSLABEL.setBounds(70, 300, 150, 30);

        StatusLabel.setFont(DataFont);
        StatusLabel.setForeground(new java.awt.Color(0, 130, 45));
        StatusLabel.setText("WON");
        MainPanel.add(StatusLabel);
        StatusLabel.setBounds(230, 300, 140, 30);

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
        DragLabel.setBounds(0, 0, 410, 80);

        BackgroundImageLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        BackgroundImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/Report_Image_Scroll.png"))); // NOI18N
        MainPanel.add(BackgroundImageLabel);
        BackgroundImageLabel.setBounds(0, 0, 410, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void invisible(){
        this.setBackground(new Color(0,0,0,0));
        MainPanel.setBackground(new Color(0,0,0,0));
    }
    
    // Function to print Player information.
    private void print(){
        
        NameLabel.setText(NAME);
        
        if(Bonus > 0){
            BonusLabel.setText("+" + Bonus);
        }
        else{
            BonusLabel.setText("" + Bonus);
        }
        ScoreLabel.setText("" + (Score + Bonus));
        
        // checking win or lose.
        if(Status){
            StatusLabel.setText("WON");
            StatusLabel.setForeground(new Color(0, 130, 45));
        }
        else{
            StatusLabel.setText("LOST");
            StatusLabel.setForeground(Color.RED);
        }
        
        if(Esec < 10){ 
            ExtraTimeTakenLabel.setText("0" + Emin + " : 0" + Esec);
        }
        else{
            ExtraTimeTakenLabel.setText("0" + Emin + " : " + Esec);
        }
        
        if(sec < 10){
            TimeTakenLabel.setText("0" + min + " : 0" + sec);
        }
        else{
            TimeTakenLabel.setText("0" + min + " : " + sec);
        }
        
    }
    
    private void message(){
        
        if(Status){
            JOptionPane.showMessageDialog(this,"Congratulations You WON.","Game Result",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this,"    You Lost\n    Try Again.","Game Result",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed

       this.dispose(); 
       
    }//GEN-LAST:event_OKButtonActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

       this.dispose();
        
    }//GEN-LAST:event_formWindowLostFocus

    private void DragLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DragLabelMouseDragged

       int CoordinateX = evt.getXOnScreen();
       int CoordinateY = evt.getYOnScreen();
       this.setLocation(CoordinateX - posX, CoordinateY - posY);
        
    }//GEN-LAST:event_DragLabelMouseDragged

    private void DragLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DragLabelMousePressed

        posX = evt.getX();
        posY = evt.getY();
        
    }//GEN-LAST:event_DragLabelMousePressed

   
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BONUSLABEL;
    private javax.swing.JLabel BackgroundImageLabel;
    private javax.swing.JLabel BonusLabel;
    private javax.swing.JLabel DragLabel;
    private javax.swing.JLabel EXTRATIMETAKENLABEL;
    private javax.swing.JLabel ExtraTimeTakenLabel;
    private javax.swing.JLabel GameReportLabel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel NAMEABEL;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel SCORELABEL;
    private javax.swing.JLabel STATUSLABEL;
    private javax.swing.JLabel ScoreLabel;
    private javax.swing.JLabel StatusLabel;
    private javax.swing.JLabel TIMETAKENLABEL;
    private javax.swing.JLabel TimeTakenLabel;
    // End of variables declaration//GEN-END:variables
}