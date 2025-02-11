package Figuras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaCilindro extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel radio, altura, volumen, superficie;
    private JTextField campoRadio, campoAltura;
    private JButton calcular;

    public VentanaCilindro() {
        inicio();
        setTitle("Cilindro"); 
        setSize(280, 210);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        radio = new JLabel("Radio (cms):");
        radio.setBounds(20, 20, 135, 23);
        campoRadio = new JTextField();
        campoRadio.setBounds(100, 20, 135, 23);

        altura = new JLabel("Altura (cms):");
        altura.setBounds(20, 50, 135, 23);
        campoAltura = new JTextField();
        campoAltura.setBounds(100, 50, 135, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(100, 80, 135, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm3):");
        volumen.setBounds(20, 110, 135, 23);

        superficie = new JLabel("Superficie (cm2):");
        superficie.setBounds(20, 140, 135, 23);

        contenedor.add(radio);
        contenedor.add(campoRadio);
        contenedor.add(altura);
        contenedor.add(campoAltura);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        boolean error = false;
        double radio = 0, altura = 0;
        try {
            radio = Double.parseDouble(campoRadio.getText());
            altura = Double.parseDouble(campoAltura.getText());

            Cilindro cilindro = new Cilindro(radio, altura);
            volumen.setText("Volumen (cm3): " + String.format("%.2f", cilindro.calcularVolumen()));
            superficie.setText("Superficie (cm2): " + String.format("%.2f", cilindro.calcularSuperficie()));

        } catch (Exception e) {
            error = true;
        } finally {
            if (error) {
                JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new VentanaCilindro().setVisible(true);
    }
}