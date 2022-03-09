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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


//This class will be used to make JTextField which will take only one value as input.
class JTextFieldLimit extends PlainDocument {
    private final int limit;
    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }
   
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}


// This class is main Game class having Game logic and components.
public class Game extends javax.swing.JFrame {
    
    int[][] PlayerGrid = new int[6][6]; //6x6 2D int array to store player entered numbers.
    
    int[][] ClueGrid = new int[6][6]; //6x6 2D int array to store generated clues only.
    
    int[][] GeneratedGrid = new int[6][6]; //6x6 2D int array to store generated sudoku grid.
    
    int[] ReferenceDigitArray={ 1, 2, 3, 4, 5, 6 }; // int array to take digits as refence to make sudoku.
    
    int Scores; // Variable to store score.
    
    int posX,posY; // Variables to store x and y coordinate value of this frame.
    
    boolean UpTimer_Running = false; // Varialbe to check if countUpTimer function ran atleast one time(if true) or not.
    
    int StartingClues; // Number of starting clues in game.
    
    int minute,second,ExtraTimeTaken,TotalTimeTaken;
    
    int TimeLeft; // Stores time left on submitting the game to calculate bonus submittion.
    
    Timer CountdownTimer,CountUPTimer; 

    String NAME; // variable to store name of a player.
    
    Font DataFont,DataFont2; // Variables to store custom font.
    
    public final int GridSize = 6; // Number os rows and columns in sudoku.                              
    public final Font FONT_NUMBERS = new Font("Consolas", Font.PLAIN, 30); // font for QuestionTextFieldCells array.
    private final JTextField[][] QuestionTextFieldCells = new JTextField[GridSize][GridSize]; // 2D JTextField array to show clues only.
    private final JTextField[][] AnswerTextFieldCells= new JTextField[GridSize][GridSize]; // 2D JTextField array to show sudoku answer.
    
    
    public Game() {
        
        makeFont(); //Initialising custom font.
        
        initComponents(); // Initialising JFrame and its components.
        
        SubmitButton.setEnabled(false); // Making SubmitButton unclickable because of first time in game.
        
        GiveUPButton.setEnabled(false); // Making GiveUPButton unclickable because of first time in game.
        
        ResetButton.setEnabled(false); // Making ResetButton unclickable because of first time in game.
 
        TimeLeft=180; //Starting time(3 minutes).
        TotalTimeTaken=0; // Total time taken to submit game.
        StartingClues=17; //Number of starting clues.
        
        resetGrid(); // Setting PlayerGrid,ClueGrid, GeneratedGrid values to 0 and changing TextField array's color.
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        GridPanel = new javax.swing.JPanel();
        StartButton = new javax.swing.JButton();
        SubmitButton = new javax.swing.JButton();
        AnswerGridPanel = new javax.swing.JPanel();
        GiveUPButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        TimerPanel = new javax.swing.JPanel();
        MinuteLabel = new javax.swing.JLabel();
        ColonLabel = new javax.swing.JLabel();
        SecondLabel = new javax.swing.JLabel();
        TimerButton = new javax.swing.JButton();
        TimerLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        DragLabel = new javax.swing.JLabel();
        CloseLabel = new javax.swing.JLabel();
        MinimizeLabel = new javax.swing.JLabel();
        GameBackgroundImageLable = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 800));
        setUndecorated(true);

        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MainPanel.setMaximumSize(new java.awt.Dimension(800, 800));
        MainPanel.setPreferredSize(new java.awt.Dimension(800, 800));
        MainPanel.setLayout(null);

        GridPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        GridPanel.setLayout(new java.awt.GridLayout(6, 6, 1, 1));
        MainPanel.add(GridPanel);
        GridPanel.setBounds(80, 90, 380, 380);
        // Making 6x6 2D array of JTextField to take input from player.
        for (int row = 0; row < GridSize; row++) {
            for (int col = 0; col < GridSize; col++) {
                QuestionTextFieldCells[row][col] = new JTextField(); // storing new JTextField in QuestionTextFieldCells 2D array.
                GridPanel.add(QuestionTextFieldCells[row][col]); //adding newly made JTextField to JPanel GridPanel.
                QuestionTextFieldCells[row][col].setHorizontalAlignment(JTextField.CENTER); // entered value will be in center.
                QuestionTextFieldCells[row][col].setFont(FONT_NUMBERS); // setting custom font to JTextField.
                QuestionTextFieldCells[row][col].setDocument(new JTextFieldLimit(1)); // making JTextField to accept only one value.

                /*
                This key listner will only allow number keys from 1-6 and
                Back Space key and Delete key.
                */
                QuestionTextFieldCells[row][col].addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        char c=evt.getKeyChar();
                        if(!((c>='1'&&c<='6')||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE)){
                            evt.consume(); // consuming(removing key effect of) other keys.
                            getToolkit().beep(); // making beep sound for wrong keys.
                        }
                    }
                });
            }
        }

        StartButton.setBackground(new java.awt.Color(102, 51, 0));
        StartButton.setFont(DataFont2);
        StartButton.setText("Start");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });
        MainPanel.add(StartButton);
        StartButton.setBounds(610, 180, 140, 50);

        SubmitButton.setBackground(new java.awt.Color(102, 51, 0));
        SubmitButton.setFont(DataFont);
        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });
        MainPanel.add(SubmitButton);
        SubmitButton.setBounds(610, 260, 140, 50);

        AnswerGridPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Solution", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Consolas", 0, 20))); // NOI18N
        AnswerGridPanel.setLayout(new java.awt.GridLayout(6, 6, 1, 1));
        MainPanel.add(AnswerGridPanel);
        AnswerGridPanel.setBounds(130, 500, 280, 270);
        // Making 6x6 2D JTextField array for showing answers to player.
        for (int row = 0; row < GridSize; row++) {
            for (int col = 0; col < GridSize; col++) {
                AnswerTextFieldCells[row][col] = new JTextField(); // making new JTextField.
                AnswerGridPanel.add(AnswerTextFieldCells[row][col]); // adding JTextField to JPanel AnswerGridPanel.
                AnswerTextFieldCells[row][col].setHorizontalAlignment(JTextField.CENTER); // entered value will be in center.
                AnswerTextFieldCells[row][col].setFont(new Font("Consolas", Font.PLAIN, 20));
                AnswerTextFieldCells[row][col].setEditable(false); // making JTextField uneditable.
            }
        }

        GiveUPButton.setBackground(new java.awt.Color(102, 51, 0));
        GiveUPButton.setFont(DataFont);
        GiveUPButton.setText("Give UP!");
        GiveUPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GiveUPButtonActionPerformed(evt);
            }
        });
        MainPanel.add(GiveUPButton);
        GiveUPButton.setBounds(610, 340, 140, 50);

        ResetButton.setBackground(new java.awt.Color(102, 51, 0));
        ResetButton.setFont(DataFont);
        ResetButton.setText("Reset");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });
        MainPanel.add(ResetButton);
        ResetButton.setBounds(610, 420, 140, 50);

        TimerPanel.setOpaque(false);
        TimerPanel.setLayout(null);

        MinuteLabel.setFont(new java.awt.Font("Tahoma", 1, 31)); // NOI18N
        MinuteLabel.setForeground(new java.awt.Color(0, 51, 255));
        MinuteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinuteLabel.setText("03");
        TimerPanel.add(MinuteLabel);
        MinuteLabel.setBounds(30, 40, 60, 50);

        ColonLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        ColonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ColonLabel.setText(":");
        TimerPanel.add(ColonLabel);
        ColonLabel.setBounds(80, 40, 20, 50);

        SecondLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        SecondLabel.setForeground(new java.awt.Color(0, 51, 255));
        SecondLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SecondLabel.setText("00");
        TimerPanel.add(SecondLabel);
        SecondLabel.setBounds(90, 40, 60, 50);

        TimerButton.setBackground(new java.awt.Color(204, 255, 255));
        TimerPanel.add(TimerButton);
        TimerButton.setBounds(20, 40, 140, 50);

        TimerLabel.setFont(new java.awt.Font("Consolas", 0, 22)); // NOI18N
        TimerLabel.setForeground(new java.awt.Color(255, 255, 255));
        TimerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TimerLabel.setText("Start Time");
        TimerPanel.add(TimerLabel);
        TimerLabel.setBounds(20, 10, 140, 30);

        MainPanel.add(TimerPanel);
        TimerPanel.setBounds(590, 50, 180, 110);

        jButton1.setForeground(new java.awt.Color(255, 217, 84));
        jButton1.setText("Time -1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        MainPanel.add(jButton1);
        jButton1.setBounds(630, 570, 80, 23);

        jButton2.setText("sec -5");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        MainPanel.add(jButton2);
        jButton2.setBounds(720, 570, 70, 23);

        jButton3.setText("ET +1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        MainPanel.add(jButton3);
        jButton3.setBounds(630, 610, 80, 23);

        jButton4.setText("ES +5");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        MainPanel.add(jButton4);
        jButton4.setBounds(720, 610, 61, 23);

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
        DragLabel.setBounds(10, 0, 710, 30);

        CloseLabel.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        CloseLabel.setForeground(new java.awt.Color(255, 0, 0));
        CloseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CloseLabel.setText("X");
        CloseLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CloseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseLabelMouseClicked(evt);
            }
        });
        MainPanel.add(CloseLabel);
        CloseLabel.setBounds(770, 0, 30, 30);

        MinimizeLabel.setFont(new java.awt.Font("Tahoma", 0, 50)); // NOI18N
        MinimizeLabel.setForeground(new java.awt.Color(255, 255, 255));
        MinimizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinimizeLabel.setText("-");
        MinimizeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MinimizeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizeLabelMouseClicked(evt);
            }
        });
        MainPanel.add(MinimizeLabel);
        MinimizeLabel.setBounds(730, 0, 30, 30);

        GameBackgroundImageLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/images/Game_Form_Image.jpg"))); // NOI18N
        MainPanel.add(GameBackgroundImageLable);
        GameBackgroundImageLable.setBounds(0, 0, 800, 800);
        AnswerGridPanel.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Function to make custom font.
    private void makeFont(){
        
        try {
            DataFont = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/data/font/Game_Form_Font.ttf")).deriveFont(20f);
            DataFont2 = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("/data/font/Game_Form_Font.ttf")).deriveFont(28f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            
            ge.registerFont(DataFont);
            ge.registerFont(DataFont2);
            
        } 
        catch (IOException | FontFormatException e) {
            JOptionPane.showMessageDialog(this,e);
        }
        
    }
        
    
    // Start Button.
    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
 
        NAME=JOptionPane.showInputDialog(this,"Enter your name","Name",JOptionPane.INFORMATION_MESSAGE);
        if(NAME != null && NAME.length() > 0){
            
            this.setAlwaysOnTop(true); // Make this frame to be on top of other windows.
            
            makeGrid(); // Generating valid sudoku grid and storing it in GeneratedGrid 2D int array.
            
            removeRandomDigits(); // Setting digits value to 0 in random position in ClueGrid array, so that it only have non-zero digits equal to StartingClues.
            
            filledCellsStyle(); // Setting clues cells with different color and making them uneditable. 
            
            countdownTimer(); // Starting Count Down Timer.
            
            StartButton.setEnabled(false); // Making Start button unclickable.
            SubmitButton.setEnabled(true); // Making Submit button clickable.
            GiveUPButton.setEnabled(true); // Making Give up button clickable.
            ResetButton.setEnabled(true); // Making Reset button clickable.
            
        }
        
    }//GEN-LAST:event_StartButtonActionPerformed

    
    // Submit Button.
    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        
        updatePlayerGrid(); // Update PlayerGrid array with QuestionTextFieldCells array values.
        
        if( isPlayerGridFull() ){ // Checking if Player filled the grid completely.
            
            CountdownTimer.stop(); // Stoping count down timer.
            if(UpTimer_Running){ // Checking if count up timer is running or not.
                
                CountUPTimer.stop(); // Stoping count up timer.
                
            }
            
            int X = getX(); // Store current X coordinate position of Game.java Jframe
            int Y = getY(); // Store current Y coordinate position of Game.java Jframe
            
            // Making QuestionTextFieldCells all cell uneditable.
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 6; j++){
                    QuestionTextFieldCells[i][j].setEditable(false);
                }
            }
            
            this.setAlwaysOnTop(false);
            
            // Checking if Player solution is correct or not.
            if( isPlayerCorrect() ){ // correct answer.
                
                GiveUPButton.setEnabled(false); // making GiveUPButton unclickable.
                
                //GiveUPButton.setEnabled(false); // Making Give up Button unclickable.
                Scores = 50;
                if(TimeLeft > 60){ // Bonus submission.
                    
                    new Report(NAME, 5, Scores, true, TotalTimeTaken, ExtraTimeTaken, X+200, Y+200).setVisible(true);
                    
                }
                
                else if(TimeLeft < 60 && ExtraTimeTaken == 0){ // normal submission.
                    
                    new Report(NAME, 0, Scores, true, TotalTimeTaken, ExtraTimeTaken, X+200, Y+200).setVisible(true);
                    
                }   
                
                else{
                    
                    // decreasing 1 point for every 2 extra seconds taken.
                    Scores -= (ExtraTimeTaken/2); // late submission.
                    
                    new Report(NAME, 0, Scores, true, TotalTimeTaken, ExtraTimeTaken, X+200, Y+200).setVisible(true);
                    
                }
            }
            else{ // Incorrect answer.
                
                Scores = 0;
               new Report(NAME, 0, Scores, false, TotalTimeTaken, ExtraTimeTaken, X+200, Y+200).setVisible(true);
               
            }
            
        }
        else{ // Grid is not filled completely.
            
           JOptionPane.showMessageDialog(this,"Fill all cells.");
           
        }
       
    }//GEN-LAST:event_SubmitButtonActionPerformed

    // Give up Button.
    private void GiveUPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GiveUPButtonActionPerformed
       
        // asking player if sure to give up current game.
        int sure=JOptionPane.showConfirmDialog(this,"Sure to Give UP ??","Game",JOptionPane.YES_NO_OPTION);
        
        if( sure == 0 ){ // yes.
            
            CountdownTimer.stop(); // stoping count down timer.
            
            if(UpTimer_Running){
                
                CountUPTimer.stop(); // stoping count up timer.
                
            }
            
            giveUp(); // This function will show answer grid to player.
            
        }
        
    }//GEN-LAST:event_GiveUPButtonActionPerformed

    // Reset Button.
    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        
        // asking player if sure to reset current game status.
        int reset = JOptionPane.showConfirmDialog(this,"Sure to reset ??","Reset",JOptionPane.YES_NO_OPTION);
        
        if( reset == 0 ){ // yes.
            
            resetGame(); // Resetting game components to initial state.
            
            this.setAlwaysOnTop(false);
            
        }
        
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void DragLabelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DragLabelMouseDragged

      int CoordinateX = evt.getXOnScreen();
      int CoordinateY = evt.getYOnScreen();
      this.setLocation(CoordinateX - posX,CoordinateY - posY);
        
    }//GEN-LAST:event_DragLabelMouseDragged

    private void DragLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DragLabelMousePressed
       
        posX = evt.getX();
        posY = evt.getY();
        
    }//GEN-LAST:event_DragLabelMousePressed

    private void CloseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseClicked
        
        new MainMenu().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_CloseLabelMouseClicked

    private void MinimizeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizeLabelMouseClicked

        this.setState(Game.ICONIFIED);
        
    }//GEN-LAST:event_MinimizeLabelMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        second +=5;
        ExtraTimeTaken+=5;
        TotalTimeTaken+=5;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        minute-=1;
        TimeLeft-=60;
        TotalTimeTaken+=60;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TimeLeft-=5;
        second-=5;
        TotalTimeTaken+=5;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        minute += 1;
        ExtraTimeTaken += 60;
        TotalTimeTaken += 60;
    }//GEN-LAST:event_jButton3ActionPerformed

    
    // This function will show current sudoku answer.
    private void giveUp(){
        
        updatePlayerGrid(); // Update PlayerGrid array with QuestionTextFieldCells array values.
        AnswerGridPanel.setVisible(true); // Make AnswerGridPanel visible.
        
        // loop to set different color for clues, empty cells, correct answer and incorrect answer.
        for(int i = 0; i < 6; i++){ // loop for rows.
            
            for(int j = 0; j < 6; j++){ // loop for columns.
                
                if(ClueGrid[i][j] != 0){ // Clue exists
                    
                    // setting text color as blue to cells containing clue.
                    AnswerTextFieldCells[i][j].setForeground(Color.BLUE);
                    
                    // setting background color as orange to cells containing clue.
                    AnswerTextFieldCells[i][j].setBackground(Color.ORANGE); 
                    
                }
                
                else if(PlayerGrid[i][j] == GeneratedGrid[i][j]){ // Answer matched.
                    
                    // setting green color for correct answer.
                    AnswerTextFieldCells[i][j].setForeground(Color.GREEN); 
                    
                }
                
                else if(PlayerGrid[i][j] == 0){ // Empty cell in QuestionTextFieldCells array.
                    
                    // setting black color for empty cell.
                    AnswerTextFieldCells[i][j].setForeground(Color.BLACK); 
                    
                }
                
                else if(PlayerGrid[i][j] != GeneratedGrid[i][j]){ // Wrong answer.
                    
                    // setting red color for incorrect answer.
                    AnswerTextFieldCells[i][j].setForeground(Color.RED); 
                    
                }
                
                // making AnswerTextFieldCells uneditable.
                AnswerTextFieldCells[i][j].setEditable(false); 
                
                // making QuestionTextFieldCells uneditable.
                QuestionTextFieldCells[i][j].setEditable(false); 
                
                // displaying answers to player.
                AnswerTextFieldCells[i][j].setText(""+GeneratedGrid[i][j]); 
                
            }
            
        } 
        
    }
    
   
    
    /*-------------------------SUDOKU VALIDATOR CODE STARTS HERE:-------------------------*/
    
     // This function will check is player's answer is correct or not.
    private boolean isPlayerCorrect(){
        
        boolean safe; // stores true or false returned from safeCheck function.
        
        // Looping for all values in PlayerGrid array.
        for(int i = 0; i < 6; i++){
            
            for(int j = 0; j < 6; j++){
                
                safe=safeCheck( i, j, PlayerGrid[i][j] );
                
                if( ! safe ){ // Duplicate or missing digit in PlayerGrid array.
                    return false;
                }
            }
            
        }
        
        return true;
        
    }
    
    // This function checks if a number is found only one time in row, column and 2x3 box or not.
    private boolean safeCheck(int row, int col, int num){
        
        if( rowCheck(row, num) && columnCheck(col, num) && boxCheck(row-row%2, col-col%3, num) ){
            
            //safe (found only one time in row, column and 2x3 box).
            return true; 
        }
        
        //not safe (found more than one time in row or column or 2x3 box).
        return false; 
        
    }
    
    // This function checks if given number is found only one time in given row or not. 
    private boolean rowCheck(int row, int num){
        
        int Appered_In_ROW = 0;
        
        for(int j = 0; j < 6; j++){
            
            if(PlayerGrid[row][j] == num){
                Appered_In_ROW++; //number is found in given row.
            }  
            
        }
        
        if(Appered_In_ROW == 1){
            return true; // number appered only one time in given row.
        }
        
        return false; // number appered either more than one time or not at all in given row.
        
    }   
    
    // This function checks if given number is found only one time in given column or not. 
    private boolean columnCheck(int col, int num){
        
        int Appered_In_COLUMN = 0;
        
        for(int i = 0 ; i < 6; i++){
            
            if(PlayerGrid[i][col] == num){ 
                Appered_In_COLUMN++; //number is found in given column.
            }
            
        }
        
        if(Appered_In_COLUMN == 1){
            return true; // number appered only one time in given column.
        }
        
        return false; // number appered either more than one time or not at all in given column.
        
    }
    
    // This function checks if given number is found only one time in given 2x3 box or not.
    private boolean boxCheck(int StartRow, int StartCol, int num){
        
        int Appered_In_BOX = 0;
        
        for(int row = 0; row < 2; row++){
            
            for(int col = 0; col < 3; col++){
                if(PlayerGrid[row+StartRow][col+StartCol] == num){ 
                    Appered_In_BOX++; // number is found in box.
                }
            }
            
        }
        
        if(Appered_In_BOX == 1){
            return true; // number appered only one time in given 2x3 box.
        }
        
        return false; // number appered either more than one time or not at all in given 2x3 box.
        
    }
    
    /*-------------------------SUDOKU VALIDATOR CODE ENDS HERE:---------------------------*/
    
    
   
    /*-------------------------SUDOKU GENERATOR CODE STARTS HERE:-------------------------*/

    
    // This function will call sudokuGenerator till a valid sudoku grid is formed.
    public void makeGrid(){
        
        while( ! isGeneratedGridFull() ){ // GeneratedGrid array is empty.
            
            sudokuGenerator(); // calling sudokuGenerator function.
            
        }
        
        
    }
    
    
    // Function to generate a valid sudoku grid.
    public void sudokuGenerator(){
        
        int limit=0; // if limit value is greater than 6 that means current sudoku is invalid.
        int SafeDigit; // to store safe digit.
        boolean safe; // to store true or false for SafeDigit.
        int ArrayIndex = 0; // Starting ArrayIndex from random position(0-5). 
       
        for(int i = 0; i < 6; i++){
            
           shuffleReferenceDigitArray(); // to shuffle ReferenceDigitArray.
           
            for(int j = 0; j < 6; ){
                
                // taking a random value from ReferenceDigitArray.
                SafeDigit = ReferenceDigitArray[ArrayIndex];
                
                // checking if SafeDigit is actually safe for current position.
                safe = isSafePosition(i, j, SafeDigit);
                
                if(safe){ // the value does not exists in GeneratedGrid array.
                    
                    GeneratedGrid[i][j] = SafeDigit; // storing safe digit.
                    ClueGrid[i][j] = SafeDigit; // storing safe digit.
                    QuestionTextFieldCells[i][j].setText("" + SafeDigit); // showing safe digit.
                    
                    j++; // Moving to next colunm.
                    limit = 0; // current SafeDigit was safe for current position.

                }
                else{
                    
                    limit++; // current SafeDigit was invalid for current position.
                    
                    if(limit > 6){ // all 6 SafeDigits were invalid for current position, means current sudoku grid was invalid.
                       
                        resetGrid(); // resetting grid values to 0.
                        
                        return ; // Returning to caller function:  makeGrid() function.
                    }
                    
                }
                
                ArrayIndex++; // moving to next index;
                
                if(ArrayIndex > 5){ // Index out of bound.
                    ArrayIndex = 0; // Resetting index value to 0.
                }
            }
        }
        
    }
    
    boolean isGeneratedGridFull(){
        
        for(int i = 0; i < 6; i++){
            
            for(int j = 0; j < 6; j++){
                
                if(GeneratedGrid[i][j] == 0){
                    return false; // not full.
                }
                
            }
        }
        
        return true; // full.
    }
    
    // This function checks if a number is safe to be placed in given row, column and 2x3 box or not.
    private boolean isSafePosition(int row, int column, int num){
        
        if(isSafeRow(row, num) && isSafeColumn(column, num) && isSafeBox(row-row%2, column-column%3, num)){
            return true; // safe (given number does not exists in given row, column and 2x3 box).
        }
        
        return false; // not safe (given number already exists in either given row or column or 2x3 box).
        
    }
    
    // This function checks if a number is safe to be placed in given row or not.
    private boolean isSafeRow(int row, int num){
        
        for(int j = 0; j < 6; j++){
            
            if(GeneratedGrid[row][j] == num){
                return false; // not safe in give row.
            }
            
        }
        
        return true; // safe in given row.
        
    }
    
    // This function cheks if a number is safe to be placed in given column or not.
    private boolean isSafeColumn(int col, int num){
        
        for(int i = 0; i < 6; i++){
            
            if(GeneratedGrid[i][col] == num){
                return false; // not safe in given columm.
            }
            
        }
        
        return true; // safe in given column.
        
    }
    
    // This function checks if a number is safe to be placed in given 2x3 box or not.
    private boolean isSafeBox(int StartRow, int StartCol, int num){
        
        for(int row = 0; row < 2; row++){
            
            for(int col = 0; col < 3; col++){
                
                if(GeneratedGrid[row+StartRow][col+StartCol] == num){
                    return false; // not safe in given 2x3 box.
                }
                
            }
            
        }
 
        return true; // safe in given 2x3 box.
        
    }
    
    /*-------------------------SUDOKU GENERATOR CODE ENDS HERE:-------------------------*/
    
    
    // This function checks if PlayerGrid array is completely filled or not.
    private boolean isPlayerGridFull(){
        
        for(int i = 0; i < 6; i++){
            
            for(int j = 0; j < 6; j++){
                
                if(PlayerGrid[i][j] == 0){
                    return false; // not filled completely.
                }
            }
            
        }
        
        return true; // filled completely.
        
    }
    
    /*
        This function removes digits(makes their value 0) 
        from random position so that total number of non-zero digits is equal to StartingClues.
    */
    public void removeRandomDigits(){
        
        int removeRandomDigits_Number = 36  -StartingClues; // number of digits to be removed to make question.
        
	while(removeRandomDigits_Number != 0){
            
            int row = randomGenerator(0, 5); // selecting random number[0-5] for row. 
            int column = randomGenerator(0, 5); // selecting random number[0-5] for column.
            
            
            if (ClueGrid[row][column] != 0){ // non-zero digit exists.
                
		removeRandomDigits_Number--; // decreasing number to be removed.
                ClueGrid[row][column] = 0; // removing digit (making its value 0).
                QuestionTextFieldCells[row][column].setText(""); // Printing for player.
                
            }
            
	}
        
    }
    
    // This function gives different color to JTextField cells having clue and making them uneditable.
    private void filledCellsStyle(){
        
        for(int i = 0; i < 6; i++){
            
            for(int j = 0; j < 6; j++){
                
                if(ClueGrid[i][j] != 0){ // a clue exists.
                    
                    // setting that JTextField cell's text color to Blue.
                    QuestionTextFieldCells[i][j].setForeground(Color.BLUE); 
                    
                    // setting that JTextField cell's Background color to Orange shade.
                    QuestionTextFieldCells[i][j].setBackground(new Color(255, 217, 84));
                    
                    // making that JTextField cell uneditable.
                    QuestionTextFieldCells[i][j].setEditable(false); 
                    
                }
                
            }
            
        }
        
    }
    
    // This function updates PlayerGrid array with QuestionTextFieldCells array values entered by Player.
    private void updatePlayerGrid(){
        
        String num; // variable to store digit retrived from QuestionTextFieldCells array in string format.
        
        for(int i = 0; i < 6; i++){
            
            for(int j = 0; j < 6; j++){
                
                // getting value from QuestionTextFieldCells array.
                num = (QuestionTextFieldCells[i][j].getText());
                
                if(num.isEmpty( )== false){ //if cell is not empty.
                    PlayerGrid[i][j] = Integer.parseInt(num); //converting string to integer.
                }
                else{
                    PlayerGrid[i][j] = 0; //if cell is empty.
                }
                
            }
            
        }
        
    }
    
    // Function to generate random number from [lowerlimit to upperlimit].
    public int randomGenerator(int lowerlimit, int upperlimit){
        return (int) Math.floor( (Math.random()* (upperlimit + 1 ) + lowerlimit) );
    }
    
    // function to randomaly shuffle "ReferenceDigitArray" integer array.
    void shuffleReferenceDigitArray(){
        
        for(int i = 5; i > 0; i--){
            
            int j = randomGenerator(0, 5);
            int temp = ReferenceDigitArray[i];
            ReferenceDigitArray[i] = ReferenceDigitArray[j];
            ReferenceDigitArray[j] = temp;
            
        }
        
    }
    
    // Function to count from 03:00 minute to 00:00 minute
    public void countdownTimer(){
        
        TimerLabel.setText("Time Left");
        minute=Integer.parseInt(MinuteLabel.getText());
        second=Integer.parseInt(SecondLabel.getText());
        
        CountdownTimer=new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(second <= 0 && minute > 0){
                    second = 60;
                    minute--;
                }
                second--;
                TimeLeft--;
                TotalTimeTaken++;
                
                if(second > 9){ // double digit number.
                    SecondLabel.setText("" + second);
                }
                else{ // single digit number.
                    SecondLabel.setText("0" + second);
                }
                if(minute > 9){ // double digit number.
                    MinuteLabel.setText("" + minute);
                }
                else{ // single digit number.
                    MinuteLabel.setText("0" + minute);
                }
                
                if(minute == 0){
                    if(second > 30){
                        SecondLabel.setForeground(new Color(255, 198, 21));
                    }
                    
                    // changes color and text size of clock to warn player about last 7 seconds.
                    switch (second) {
                        case 7: TimerButton.setBackground(Color.YELLOW);
                                break;
                        case 6: SecondLabel.setForeground(Color.RED);
                                break;
                        case 5: TimerButton.setBackground(new Color(255, 153, 0));
                                SecondLabel.setFont(new java.awt.Font("Tahoma", 1, 35));
                                break;
                        case 4: TimerButton.setBackground(Color.YELLOW);
                                SecondLabel.setFont(new java.awt.Font("Tahoma", 1, 43));
                                break;
                        case 3: TimerButton.setBackground(new Color(255,153,0));
                                SecondLabel.setFont(new java.awt.Font("Tahoma", 1,35));
                                break;
                        case 2: TimerButton.setBackground(Color.YELLOW);
                                SecondLabel.setFont(new java.awt.Font("Tahoma", 1, 43));
                                break;
                        case 1: TimerButton.setBackground(new Color(255,153,0));
                                SecondLabel.setFont(new java.awt.Font("Tahoma", 1, 35));
                                break;
                        case 0: TimerButton.setBackground(Color.BLACK);
                                SecondLabel.setFont(new java.awt.Font("Tahoma", 1, 30));
                                SecondLabel.setForeground(Color.BLUE);
                                CountdownTimer.stop(); // stoping count down timer.
                                
                                countUpTimer();  // staring count up timer because player was not able to submit within time limit.
                                UpTimer_Running=true; // player was not able to submit within time limit.
                    }
                }
            }
        });
        CountdownTimer.start(); // starting count down timer.
        
    }
    
    // Function to count up from 00:00 minute.
    public void countUpTimer(){
        
        TimerLabel.setText("Extra Time");
        MinuteLabel.setFont(new java.awt.Font("Tahoma", 1, 31));
        SecondLabel.setFont(new java.awt.Font("Tahoma", 1, 30));
        TimerButton.setBackground(new Color(204, 255, 255));
        minute = 0;
        second = 0;
        CountUPTimer=new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                second++;
                ExtraTimeTaken++;
                TotalTimeTaken++;
                if(second == 60){
                    second = 0;
                    minute++;
                }
                if(second > 9){ // double digit number.
                    SecondLabel.setText("" + second);
                }
                else{ // single digit number.
                    SecondLabel.setText("0" + second);
                }
                if(minute > 9){ // double digit number.
                    MinuteLabel.setText("" + minute);
                }
                else{ // single digit number.
                    MinuteLabel.setText("0" + minute);
                }
            }
        });
        CountUPTimer.start(); // starts count up timer.
        
    }
    
    // Resets clock and its components.
    private void resetTimer(){
        
        CountdownTimer.stop(); // stoping count down timer.
        if(UpTimer_Running){
            CountUPTimer.stop(); // stoping count up timer.
        }
        TimerLabel.setText("Start Time");
        TimerButton.setBackground(new Color(204, 255, 255));
        MinuteLabel.setFont(new java.awt.Font("Tahoma", 1, 31));
        SecondLabel.setFont(new java.awt.Font("Tahoma", 1, 30));
        minute = 3;
        second = 0;
        MinuteLabel.setText("0" + minute); // printing minute's value on MinuteLabel.
        SecondLabel.setText("0" + second); // printing second's value on MinuteLabel.
        
    }
   
    // This function reset game's components.
    public void resetGame(){
        
        resetTimer();
        AnswerGridPanel.setVisible(false); // hiding answer panel.
        SubmitButton.setEnabled(false); // making SubmitButton unclickable.
        GiveUPButton.setEnabled(false); // making GiveUPButton unclickable. 
        ResetButton.setEnabled(false); // making ResetButton unclickable.
        StartButton.setEnabled(true); // making StartButton clickable.
        SecondLabel.setForeground(new Color(0, 51, 255));
        TimeLeft = 180; // 3 minutes.
        TotalTimeTaken = 0;
        ExtraTimeTaken = 0;
        resetGrid();
        
    }
    
    /* 
        This function resets GeneratedGrid, PlayerGrid, ClueGrid values to 0 and 
        changes QuestionTextFieldCells color to default. 
    */
    private void resetGrid(){
        
        for(int i = 0; i < 6; i++){
            
            for(int j = 0; j < 6; j++){
                GeneratedGrid[i][j] = 0; // resetting GeneratedGrid.
                PlayerGrid[i][j] = 0; // resetting PlayerGrid.
                ClueGrid[i][j] = 0; // resetting ClueGrid.
                QuestionTextFieldCells[i][j].setText(""); // Making QuestionTextFieldCells empty.
                QuestionTextFieldCells[i][j].setEditable(true); // Making QuestionTextFieldCells editable.
                QuestionTextFieldCells[i][j].setForeground(Color.BLACK);
                QuestionTextFieldCells[i][j].setBackground(new Color(204, 204, 204, 0));
                AnswerTextFieldCells[i][j].setBackground(Color.LIGHT_GRAY);
            }
            
        }
        
    }
    
    
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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AnswerGridPanel;
    private javax.swing.JLabel CloseLabel;
    private javax.swing.JLabel ColonLabel;
    private javax.swing.JLabel DragLabel;
    private javax.swing.JLabel GameBackgroundImageLable;
    private javax.swing.JButton GiveUPButton;
    private javax.swing.JPanel GridPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel MinimizeLabel;
    private javax.swing.JLabel MinuteLabel;
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel SecondLabel;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JButton TimerButton;
    private javax.swing.JLabel TimerLabel;
    private javax.swing.JPanel TimerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables

}
