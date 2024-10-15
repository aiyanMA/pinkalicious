import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HardestGame extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private int playerX = 50, playerY = 50;
    private int playerSize = 20;
    private int goalX = 300, goalY = 300, goalSize = 20;
    private int[][] obstacles = {
        {100, 100, 10, 100},
        {200, 200, 100, 10},
        {150, 50, 10, 150}
    };
    
    public HardestGame() {
        timer = new Timer(20, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(playerX, playerY, playerSize, playerSize);

        g.setColor(Color.RED);
        g.fillRect(goalX, goalY, goalSize, goalSize);

        g.setColor(Color.BLACK);
        for (int[] obstacle : obstacles) {
            g.fillRect(obstacle[0], obstacle[1], obstacle[2], obstacle[3]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                playerY -= 5;
                break;
            case KeyEvent.VK_DOWN:
                playerY += 5;
                break;
            case KeyEvent.VK_LEFT:
                playerX -= 5;
                break;
            case KeyEvent.VK_RIGHT:
                playerX += 5;
                break;
        }
        checkCollision();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    private void checkCollision() {
        // Check for collision with goal
        if (playerX < goalX + goalSize && playerX + playerSize > goalX &&
            playerY < goalY + goalSize && playerY + playerSize > goalY) {
            JOptionPane.showMessageDialog(this, "You reached the goal!");
            System.exit(0);
        }

        // Check for collision with obstacles
        for (int[] obstacle : obstacles) {
            if (playerX < obstacle[0] + obstacle[2] && playerX + playerSize > obstacle[0] &&
                playerY < obstacle[1] + obstacle[3] && playerY + playerSize > obstacle[1]) {
                JOptionPane.showMessageDialog(this, "You hit an obstacle!");
                resetGame();
            }
        }
    }

    private void resetGame() {
        playerX = 50;
        playerY = 50;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("The World's Hardest Game");
        HardestGame game = new HardestGame();
        frame.add(game);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
