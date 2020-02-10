import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Project2{

    private JFrame frame = new JFrame("Automobile Sales Tax Calculator");
    private JPanel panel1 = new JPanel();
    private JPanel makeandModelLblPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
    private JPanel salesPriceLblPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
    private JPanel makeandModelTextPanel = new JPanel();
    private JPanel salesPricesTextPanel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel mPGPanel = new JPanel();
    private JPanel weightPanel = new JPanel();
    private JPanel panel3 = new JPanel();
    private JLabel makeModelLbl = new JLabel("Make and Model");
    private JLabel salesPricesLbl = new JLabel("Sales Price");
    private JLabel milesPerGallon = new JLabel("Miles per Gallon");
    private JLabel weight = new JLabel("Weight in Pounds");
    private JButton computeSalesTaxBtn = new JButton("Compute Sales Tax");
    private JButton clearFieldsBtn = new JButton("Clear Fields");
    private JButton displayReportBtn = new JButton("Display Report");
    private JRadioButton hybridRadioButton = new JRadioButton("Hybrid");
    private JRadioButton electricRadioButton = new JRadioButton("Electric");
    private JRadioButton otherRadioButton = new JRadioButton("Other");
    private ButtonGroup buttonGroup;
    private JTextField showSalesTax = new JTextField();
    private JTextField makeModelText = new JTextField(12);
    private JTextField salesPriceText = new JTextField(12);
    private JTextField mPGTextField = new JTextField(10);
    private JTextField weightTextField = new JTextField(10);

    List<Automobile> garage = new ArrayList<Automobile>();

    public Project2() {

        /** the necessities including an overall layout with and layouts within the panels(trying to make
           this as close to picture as possible) will be doing a lot of messing around here */
    
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /** Panels begin */
        panel1.setLayout(new GridLayout(2,2, 5, 5));
        panel1.setBorder(BorderFactory.createEmptyBorder(5, 40, 5, 40));
        panel2.setLayout(new GridLayout(3, 3, 5, 5));
        panel2.setBorder(BorderFactory.createTitledBorder("Automobile Type"));
        panel3.setLayout(new GridLayout(2,2, 5, 5));
        panel3.setBorder(BorderFactory.createEmptyBorder(5, 25, 5, 25));
        /** Panels end */

        //add them to the frame then adding to panels
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);


        /**  Panel 1 */
        panel1.add(makeandModelLblPanel);
        makeandModelLblPanel.add(makeModelLbl);
        panel1.add(makeandModelTextPanel);
        makeandModelTextPanel.add(makeModelText);
        panel1.add(salesPriceLblPanel);
        salesPriceLblPanel.add(salesPricesLbl);
        panel1.add(salesPricesTextPanel);
        salesPricesTextPanel.add(salesPriceText);
        
        /**  Panel 2 */
        buttonGroup = new ButtonGroup();
        buttonGroup.add(hybridRadioButton);
        buttonGroup.add(electricRadioButton);
        buttonGroup.add(otherRadioButton);
        panel2.add(hybridRadioButton);
        panel2.add(milesPerGallon);
        panel2.add(mPGPanel);
        mPGPanel.add(mPGTextField);
        panel2.add(electricRadioButton);
        panel2.add(weight);
        weightPanel.add(weightTextField);
        panel2.add(weightPanel);
        panel2.add(otherRadioButton);



        otherRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                weightTextField.setEditable(false);
                weightTextField.setVisible(false);
                mPGTextField.setEditable(false);
                mPGTextField.setVisible(false);

            }
        });
        hybridRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                weightTextField.setEditable(false);
                weightTextField.setVisible(false);
                mPGTextField.setEditable(true);
                mPGTextField.setVisible(true);

            }
        });
        electricRadioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                weightTextField.setEditable(true);
                weightTextField.setVisible(true);
                mPGTextField.setEditable(false);
                mPGTextField.setVisible(false);
            }
        });
        
        /**  Panel 3 */
        panel3.add(computeSalesTaxBtn);
        // TODO everytime shows garage at capacity
        computeSalesTaxBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    String tempMakeModel = makeModelText.getText();
                    int tempSalesPrice = Integer.parseInt(salesPriceText.getText());

                    if (hybridRadioButton.isSelected() && garage.size() <= 5) {
                        int tempMPG = Integer.parseInt(mPGTextField.getText());
                        Hybrid tempHybrid = new Hybrid(tempMakeModel, tempSalesPrice, tempMPG);
                        float computedSalesTax = tempHybrid.salesTax();
                        showSalesTax.setText(String.format("%.02f", computedSalesTax));
                        garage.add(tempHybrid);

                    } if (electricRadioButton.isSelected() && garage.size() <= 5){
                        int tempWeight = Integer.parseInt(weightTextField.getText());
                        Electric tempElectric = new Electric(tempMakeModel, tempSalesPrice, tempWeight);
                        float computedSalesTax = tempElectric.salesTax();
                        showSalesTax.setText(String.format("%.02f", computedSalesTax));
                        garage.add(tempElectric);
                        
                    } if (otherRadioButton.isSelected() && garage.size() <= 5){
                        Automobile tempAutomobile = new Automobile(tempMakeModel, tempSalesPrice);
                        float computedSalesTax = tempAutomobile.salesTax();
                        showSalesTax.setText(String.format("%.02f", computedSalesTax));
                        garage.add(tempAutomobile);
    
                    } else {
                            JOptionPane.showMessageDialog(frame, "Garage at max capacity (5)", "Warning", JOptionPane.WARNING_MESSAGE);
                        }  
                    
                    System.out.println(tempMakeModel);
                    System.out.println(tempSalesPrice);
                } catch (NullPointerException npex) {
                    JOptionPane.showMessageDialog(frame, "Pointing to null", "Error", JOptionPane.WARNING_MESSAGE);
                } catch (NumberFormatException nfex) {
                    JOptionPane.showMessageDialog(frame, "Sales Price must be an Integer", "Error", JOptionPane.WARNING_MESSAGE);
                }  
            }
        });
        
        
        panel3.add(showSalesTax);
        showSalesTax.setEditable(false);
        panel3.add(clearFieldsBtn);
        clearFieldsBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                makeModelText.setText("");
                salesPriceText.setText("");
                showSalesTax.setText("");
                mPGTextField.setText("");
                weightTextField.setText("");
            }
        });
        panel3.add(displayReportBtn);
        displayReportBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for (Automobile a : garage) {
                    System.out.println(a.toString());
                    
                }
                System.out.println("Display report");
            }
        });
    }
    //make a run method to be cool
    public void run(){
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Project2 GUI = new Project2();
        GUI.run();
    }
}