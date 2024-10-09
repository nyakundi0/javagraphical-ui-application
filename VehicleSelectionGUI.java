import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleSelectionGUI extends JFrame {
    private JCheckBox carCheckBox;
    private JCheckBox truckCheckBox;

    public VehicleSelectionGUI() {
        setTitle("Vehicle Selection");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        carCheckBox = new JCheckBox("Car");
        truckCheckBox = new JCheckBox("Truck");

        add(carCheckBox);
        add(truckCheckBox);

        ButtonGroup group = new ButtonGroup();
        group.add(carCheckBox);
        group.add(truckCheckBox);

        JButton openButton = new JButton("Open");
        add(openButton);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carCheckBox.isSelected()) {
                    new CarInputGUI();
                } else if (truckCheckBox.isSelected()) {
                    new TruckInputGUI();
                } else {
                    JOptionPane.showMessageDialog(VehicleSelectionGUI.this, 
                        "Please select a vehicle type.", "Selection Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VehicleSelectionGUI());
    }
}