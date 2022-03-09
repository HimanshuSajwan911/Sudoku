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


public class Rules extends javax.swing.JFrame {

    int posX,posY;
    
    
    public Rules() {
        
        initComponents();
        
    }
    
   
    public Rules(int coordX, int coordY) {
        
        initComponents();
        
        posX = coordX;
        posY = coordY;
        
        setLocation();
        
        
    }
    
    private void setLocation(){
        this.setLocation(posX, posY);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        DragLabel = new javax.swing.JLabel();
        ScrollPane = new javax.swing.JScrollPane();
        RulesPanel = new javax.swing.JPanel();
        HeadingLabel = new javax.swing.JLabel();
        HintLabel = new javax.swing.JLabel();
        ColumnRuleLabel = new javax.swing.JLabel();
        RowRuleLabel = new javax.swing.JLabel();
        BoxRuleLabel = new javax.swing.JLabel();
        PuzzleLabel = new javax.swing.JLabel();
        RowImageLabel = new javax.swing.JLabel();
        ColumnImageLabel = new javax.swing.JLabel();
        BoxImageLabel = new javax.swing.JLabel();
        StartingBoardLabel = new javax.swing.JLabel();
        RuleLabel1 = new javax.swing.JLabel();
        RuleLabel2 = new javax.swing.JLabel();
        RuleLabel3 = new javax.swing.JLabel();
        RuleLabel4 = new javax.swing.JLabel();
        RuleLabel5 = new javax.swing.JLabel();
        RuleLabel6 = new javax.swing.JLabel();
        RuleLabel7 = new javax.swing.JLabel();
        BackgroundImage = new javax.swing.JLabel();
        CloseLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });

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

        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        RulesPanel.setPreferredSize(new java.awt.Dimension(400, 1500));
        RulesPanel.setLayout(null);

        HeadingLabel.setFont(new java.awt.Font("Tahoma", 0, 35)); // NOI18N
        HeadingLabel.setForeground(new java.awt.Color(255, 0, 0));
        HeadingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeadingLabel.setText("How to Play");
        RulesPanel.add(HeadingLabel);
        HeadingLabel.setBounds(0, 10, 380, 50);

        HintLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        HintLabel.setForeground(new java.awt.Color(255, 255, 255));
        HintLabel.setText("The grid must be filled using only logic. No guessing!");
        RulesPanel.add(HintLabel);
        HintLabel.setBounds(20, 1150, 370, 40);

        ColumnRuleLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        ColumnRuleLabel.setForeground(new java.awt.Color(255, 255, 255));
        ColumnRuleLabel.setText("<html>\n2: The numbers 1 to 6 must occur only once in each column.\n</html>");
        RulesPanel.add(ColumnRuleLabel);
        ColumnRuleLabel.setBounds(10, 370, 370, 30);

        RowRuleLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        RowRuleLabel.setForeground(new java.awt.Color(255, 255, 255));
        RowRuleLabel.setText("<html> 1: The numbers 1 to 6 must occur only once in each row. </html>");
        RulesPanel.add(RowRuleLabel);
        RowRuleLabel.setBounds(10, 100, 370, 40);

        BoxRuleLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        BoxRuleLabel.setForeground(new java.awt.Color(255, 255, 255));
        BoxRuleLabel.setText("<html>\n3: The numbers 1 to 6 must occur only once in each block of 2x3.\n<html>");
        RulesPanel.add(BoxRuleLabel);
        BoxRuleLabel.setBounds(20, 610, 370, 40);

        PuzzleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/Sudoku_Starting_Borad.JPG"))); // NOI18N
        PuzzleLabel.setText("jLabel6");
        RulesPanel.add(PuzzleLabel);
        PuzzleLabel.setBounds(50, 920, 200, 200);

        RowImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/Sudoku_Answer_Row.JPG"))); // NOI18N
        RowImageLabel.setText("jLabel6");
        RulesPanel.add(RowImageLabel);
        RowImageLabel.setBounds(60, 150, 200, 200);

        ColumnImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/Sudoku_Answer_Column.JPG"))); // NOI18N
        ColumnImageLabel.setText("jLabel6");
        RulesPanel.add(ColumnImageLabel);
        ColumnImageLabel.setBounds(60, 400, 200, 200);

        BoxImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/Sudoku_Answer_Box.JPG"))); // NOI18N
        BoxImageLabel.setText("jLabel6");
        RulesPanel.add(BoxImageLabel);
        BoxImageLabel.setBounds(50, 650, 200, 200);

        StartingBoardLabel.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        StartingBoardLabel.setForeground(new java.awt.Color(255, 255, 255));
        StartingBoardLabel.setText("<html> \n\nThe clues allocated at the beginning of the\n puzzle cannot be changed or deleted. \n\n</html>");
        RulesPanel.add(StartingBoardLabel);
        StartingBoardLabel.setBounds(20, 870, 370, 50);

        RuleLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        RuleLabel1.setForeground(new java.awt.Color(255, 255, 255));
        RuleLabel1.setText("You will get 3 Minutes to solve the puzzle.");
        RulesPanel.add(RuleLabel1);
        RuleLabel1.setBounds(20, 1190, 350, 40);

        RuleLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        RuleLabel2.setForeground(new java.awt.Color(255, 255, 255));
        RuleLabel2.setText("The clock will start count down from 3 min.");
        RulesPanel.add(RuleLabel2);
        RuleLabel2.setBounds(20, 1230, 350, 40);

        RuleLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        RuleLabel3.setForeground(new java.awt.Color(255, 255, 255));
        RuleLabel3.setText("<html>\nafter 3 minutes are over, clock will start counting upwards.\n</html>");
        RulesPanel.add(RuleLabel3);
        RuleLabel3.setBounds(20, 1280, 350, 40);

        RuleLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        RuleLabel4.setForeground(new java.awt.Color(255, 255, 255));
        RuleLabel4.setText("<html>\nsubmiting correct solution within 2 minutes will give +5 bonus points.\n</html>");
        RulesPanel.add(RuleLabel4);
        RuleLabel4.setBounds(20, 1330, 350, 40);

        RuleLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        RuleLabel5.setForeground(new java.awt.Color(255, 255, 255));
        RuleLabel5.setText("<html>\n submiting correct solution after 3 minutes will result in decrease of 1 point per 2 seconds.\n</html>");
        RulesPanel.add(RuleLabel5);
        RuleLabel5.setBounds(20, 1380, 350, 40);

        RuleLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        RuleLabel6.setForeground(new java.awt.Color(255, 255, 255));
        RuleLabel6.setText("\n submiting incorrect solution will result in 0 score.\n");
        RulesPanel.add(RuleLabel6);
        RuleLabel6.setBounds(20, 1420, 350, 40);

        RuleLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        RuleLabel7.setForeground(new java.awt.Color(255, 255, 255));
        RuleLabel7.setText("After submitting you cannot edit the puzzle.");
        RulesPanel.add(RuleLabel7);
        RuleLabel7.setBounds(20, 1460, 350, 30);

        BackgroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/Rules_Background_Image.jpg"))); // NOI18N
        RulesPanel.add(BackgroundImage);
        BackgroundImage.setBounds(0, 0, 400, 1500);

        ScrollPane.setViewportView(RulesPanel);

        CloseLabel.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        CloseLabel.setForeground(new java.awt.Color(255, 0, 0));
        CloseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CloseLabel.setText("X");
        CloseLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CloseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DragLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CloseLabel)
                    .addComponent(DragLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(400, 641));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DragLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DragLabelMousePressed

        posX = evt.getX();
        posY = evt.getY();

    }//GEN-LAST:event_DragLabelMousePressed

    private void DragLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DragLabelMouseDragged

        int CoordinateX = evt.getXOnScreen();
        int CoordinateY = evt.getYOnScreen();
        this.setLocation(CoordinateX - posX,CoordinateY - posY);

    }//GEN-LAST:event_DragLabelMouseDragged

    private void CloseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseClicked
       
        this.dispose();
        
    }//GEN-LAST:event_CloseLabelMouseClicked

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        
        this.dispose();
        
    }//GEN-LAST:event_formWindowLostFocus

    public static void main(String args[]) {
      
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rules.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rules().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundImage;
    private javax.swing.JLabel BoxImageLabel;
    private javax.swing.JLabel BoxRuleLabel;
    private javax.swing.JLabel CloseLabel;
    private javax.swing.JLabel ColumnImageLabel;
    private javax.swing.JLabel ColumnRuleLabel;
    private javax.swing.JLabel DragLabel;
    private javax.swing.JLabel HeadingLabel;
    private javax.swing.JLabel HintLabel;
    private javax.swing.JLabel PuzzleLabel;
    private javax.swing.JLabel RowImageLabel;
    private javax.swing.JLabel RowRuleLabel;
    private javax.swing.JLabel RuleLabel1;
    private javax.swing.JLabel RuleLabel2;
    private javax.swing.JLabel RuleLabel3;
    private javax.swing.JLabel RuleLabel4;
    private javax.swing.JLabel RuleLabel5;
    private javax.swing.JLabel RuleLabel6;
    private javax.swing.JLabel RuleLabel7;
    private javax.swing.JPanel RulesPanel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JLabel StartingBoardLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
