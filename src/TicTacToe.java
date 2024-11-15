import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {

    JButton[] buttons = new JButton[9];
    JButton restart = new JButton();
    JFrame frame = new JFrame();
    JLabel textfield = new JLabel();
    JPanel title_panel = new JPanel();
    JPanel button_Panel = new JPanel();
    ImageIcon image = new ImageIcon("src/letöltés.png");
    boolean player1_turn = firstTurn();


    TicTacToe() {

        //frame settings
        frame.setTitle("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setIconImage(image.getImage());

        //restart button settings
        restart.setLayout(new BorderLayout());
        restart.setText("Restart");
        restart.setFont(new Font("Bold", Font.BOLD, 75));
        restart.setFocusable(false);
        restart.setBackground(Color.BLACK);
        restart.setForeground(Color.WHITE);
        restart.addActionListener(this::onRestart);

        //textfield settings
        textfield.setFont(new Font("Bold", Font.BOLD, 75));
        textfield.setBackground(Color.BLACK);
        textfield.setForeground(Color.WHITE);
        textfield.setOpaque(true);
        textfield.setHorizontalAlignment(JLabel.CENTER);

        //panel setting
        button_Panel.setLayout(new GridLayout(3, 3));


        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        //button settings
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_Panel.add(buttons[i]);
            buttons[i].setFont(new Font("Bold", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        firstTurn();
        firstTurn(player1_turn);
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_Panel);
        frame.add(restart, BorderLayout.SOUTH);

    }

    private void onRestart(ActionEvent actionEvent) {
        for (JButton button : buttons) {
            button.setText("");
            button.setBackground(Color.WHITE);
            button.setForeground(Color.BLACK);
        }
        for (JButton button : buttons) {
            button.setEnabled(true);
        }
        player1_turn = firstTurn();
        firstTurn(player1_turn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn){
                    if (buttons[i].getText().isEmpty()) {
                        textfield.setText("X's turn");
                        buttons[i].setText("O");
                        buttons[i].setBackground(Color.BLACK);
                        buttons[i].setForeground(Color.CYAN);
                        player1_turn = false;
                        check();
                    }
                }
                else {
                    if (buttons[i].getText().isEmpty()) {
                        textfield.setText("O's turn");
                        buttons[i].setText("X");
                        buttons[i].setBackground(Color.BLACK);
                        buttons[i].setForeground(Color.BLUE);
                        player1_turn = true;
                        check();
                    }
                }

            }
        }
    }
    public boolean firstTurn() {
        Random random = new Random();
        return random.nextBoolean();
    }
    public void firstTurn(boolean x){
        if (x){
            textfield.setText("O's turn");
        }else {
            textfield.setText("X's turn");
        }
    }
    public void check(){
        if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[1].getText().equals("O")) &&
                        (buttons[2].getText().equals("O"))
        ) {
            oWins(0,1,2);
        } else
        if(
                (buttons[3].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[5].getText().equals("O"))
        ) {
            oWins(3,4,5);
        } else
        if(
                (buttons[6].getText().equals("O")) &&
                        (buttons[7].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(6,7,8);
        } else
        if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[3].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(0,3,6);
        } else
        if(
                (buttons[1].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[7].getText().equals("O"))
        ) {
            oWins(1,4,7);
        } else
        if(
                (buttons[2].getText().equals("O")) &&
                        (buttons[5].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(2,5,8);
        } else
        if(
                (buttons[0].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(0,4,8);
        } else
        if(
                (buttons[2].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(2,4,6);
        } else
        if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[1].getText().equals("X")) &&
                        (buttons[2].getText().equals("X"))
        ) {
            xWins(0,1,2);
        } else
        if(
                (buttons[3].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[5].getText().equals("X"))
        ) {
            xWins(3,4,5);
        } else
        if(
                (buttons[6].getText().equals("X")) &&
                        (buttons[7].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(6,7,8);
        } else
        if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[3].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(0,3,6);
        } else
        if(
                (buttons[1].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[7].getText().equals("X"))
        ) {
            xWins(1,4,7);
        } else
        if(
                (buttons[2].getText().equals("X")) &&
                        (buttons[5].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(2,5,8);
        } else
        if(
                (buttons[0].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(0,4,8);

        } else
        if(
                (buttons[2].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(2,4,6);
        } else {
            if (checkFull()) {
                textfield.setText("It's a draw");
                for (int i = 0; i < 9; i++) {
                    buttons[i].setEnabled(false);
                }
            }
        }
    }

    private boolean checkFull() {
        for(int i=0;i<9;i++) {
            if(buttons[i].getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public void xWins(int x, int y, int z) {
        buttons[x].setBackground(Color.green);
        buttons[y].setBackground(Color.green);
        buttons[z].setBackground(Color.green);

        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X wins");
    }
    public void oWins(int x, int y, int z) {
        buttons[x].setBackground(Color.green);
        buttons[y].setBackground(Color.green);
        buttons[z].setBackground(Color.green);

        for (int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins");
    }
}