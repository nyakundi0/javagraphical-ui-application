import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TruckInputGUI extends JFrame {
    private JTextField makeField, modelField, yearField, doorsField, fuelCapacityField, drivingRangeField, 
                      towingCapacityField, payloadCapacityField, extraLoadField;
    private JButton calculateMPGButton, calculateMPGWithLoadButton;
    private JLabel resultLabel;

    public TruckInputGUI() {
        setTitle("Truck Information");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(11, 2));

        add(new JLabel("Make:"));
        makeField = new JTextField();
        add(makeField);

        add(new JLabel("Model:"));
        modelField = new JTextField();
        add(modelField);

        add(new JLabel("Year:"));
        yearField = new JTextField();
        add(yearField);

        add(new JLabel("Number of Doors:"));
        doorsField = new JTextField();
        add(doorsField);

        add(new JLabel("Fuel Tank Capacity:"));
        fuelCapacityField = new JTextField();
        add(fuelCapacityField);

        add(new JLabel("Driving Range:"));
        drivingRangeField = new JTextField();
        add(drivingRangeField);

        add(new JLabel("Towing Capacity:"));
        towingCapacityField = new JTextField();
        add(towingCapacityField);

        add(new JLabel("Payload Capacity:"));
        payloadCapacityField = new JTextField();
        add(payloadCapacityField);

        add(new JLabel("Extra Load:"));
        extraLoadField = new JTextField("100");
        add(extraLoadField);

        calculateMPGButton = new JButton("Calculate MPG");
        add(calculateMPGButton);

        calculateMPGWithLoadButton = new JButton("Calculate MPG with Load");
        add(calculateMPGWithLoadButton);

        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        calculateMPGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMPG(false);
            }
        });

        calculateMPGWithLoadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateMPG(true);
            }
        });

        setVisible(true);
    }

    private void calculateMPG(boolean withLoad) {
        try {
            String make = validateStringInput(makeField, "Make");
            String model = validateStringInput(modelField, "Model");
            int year = validateIntInput(yearField, "Year", 1886, 2100);
            int doors = validateIntInput(doorsField, "Number of Doors", 1, 6);
            double fuelCapacity = validateDoubleInput(fuelCapacityField, "Fuel Tank Capacity", 0, 1000);
            int drivingRange = validateIntInput(drivingRangeField, "Driving Range", 0, 10000);
            int towingCapacity = validateIntInput(towingCapacityField, "Towing Capacity", 0, 50000);
            int payloadCapacity = validateIntInput(payloadCapacityField, "Payload Capacity", 0, 10000);
            int extraLoad = validateIntInput(extraLoadField, "Extra Load", 0, 1000);

            Truck truck = new Truck(make, model, year, doors, fuelCapacity, drivingRange, towingCapacity, payloadCapacity);
            double mpg = withLoad ? truck.calcMPG(extraLoad) : truck.calcMPG();

            resultLabel.setText(String.format("Result: %.2f MPG", mpg));
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String validateStringInput(JTextField field, String fieldName) {
        String value = field.getText().trim();
        if (value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
        return value;
    }

    private int validateIntInput(JTextField field, String fieldName, int min, int max) {
        try {
            int value = Integer.parseInt(field.getText().trim());
            if (value < min || value > max) {
                throw new IllegalArgumentException(fieldName + " must be between " + min + " and " + max + ".");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid integer.");
        }
    }

    private double validateDoubleInput(JTextField field, String fieldName, double min, double max) {
        try {
            double value = Double.parseDouble(field.getText().trim());
            if (value < min || value > max) {
                throw new IllegalArgumentException(fieldName + " must be between " + min + " and " + max + ".");
            }
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " must be a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TruckInputGUI());
    }
}