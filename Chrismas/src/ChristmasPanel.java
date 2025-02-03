import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ChristmasPanel extends JPanel implements ActionListener {

    private Image background;
    private Image weihnachtmann;
    private Image schatten;
    private Clip jingleClip; // Audio-Clip für den Jingle
    private int x = 0; // Position des Weihnachtsmanns

    public ChristmasPanel() throws RuntimeException {
        try {
            // Hintergrundbild laden
            background = ImageIO.read(new File("dortmund.png"));
        } catch (IOException e) {
            System.out.println("Hintergrundbild (dortmund.png) nicht gefunden.");
            throw new RuntimeException(e);
        }

        try {
            // Weihnachtsmann-Bild laden
            weihnachtmann = ImageIO.read(new File("weih.png"));
        } catch (IOException e) {
            System.out.println("Weihnachtsmann-Bild (weih.png) nicht gefunden.");
            throw new RuntimeException(e);
        }

        try {
            // Schatten-Bild laden
            schatten = ImageIO.read(new File("schatten.png"));
        } catch (IOException e) {
            System.out.println("Schatten-Bild (schatten.png) nicht gefunden.");
            throw new RuntimeException(e);
        }

        try {
            // Jingle laden und abspielen
            File audioFile = new File("jingle.mid"); // Pfad zur Audio-Datei
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            jingleClip = AudioSystem.getClip();
            jingleClip.open(audioStream);
            jingleClip.loop(Clip.LOOP_CONTINUOUSLY); // Jingle in Endlosschleife abspielen
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Audio-Datei (jingle.wav) konnte nicht geladen werden.");
        }

        // Timer für Animation
        Timer timer = new Timer(70, this); // Alle 50 ms wird actionPerformed aufgerufen
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Hintergrundbild zeichnen
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(Color.RED);
            g.drawString("Hintergrundbild konnte nicht geladen werden.", 10, 20);
        }

        // Weihnachtsmann-Bild zeichnen
        if (weihnachtmann != null) {
            g.drawImage(weihnachtmann, x, 50, 100, 100, this); // Weihnachtsmann
        } else {
            g.setColor(Color.RED);
            g.drawString("Weihnachtsmann-Bild konnte nicht geladen werden.", 10, 40);
        }

        // Schatten zeichnen
        if (schatten != null) {
            g.drawImage(schatten, x, 350, 100, 100, this); // Schatten leicht versetzt
        } else {
            g.setColor(Color.RED);
            g.drawString("Schatten-Bild konnte nicht geladen werden.", 10, 60);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Bewegung des Weihnachtsmanns
        x += 2; // Bewegung nach rechts
        if (x > getWidth()) {
            x = -100; // Zurücksetzen, wenn er aus dem Bildschirm verschwindet
        }
        repaint(); // Bildschirm neu zeichnen
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Christmas Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new ChristmasPanel());
        frame.setVisible(true);
    }
}
