package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinCTextField;
    JButton next;
    JRadioButton male, female, married, single, other;
    JDateChooser dateChooser;

    SignupOne(){

        setLayout(null);

        Random ran  = new Random();
        long random = Math.abs(ran.nextLong() % 9000L + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO: " + random);
        formno.setFont(new Font("Serif", Font.BOLD, 38));
        formno.setBounds(135,20,600,40);
        formno.setForeground(new Color(70, 130, 180));
        add(formno);

        JLabel personalDetails = new JLabel("Page 1 : Personal Details ");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(290,65,400,30);
        personalDetails.setForeground(new Color(95, 158, 160));
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        name.setForeground(new Color(240, 128, 128));
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300,140,300,30);
        add(nameTextField);

        JLabel fname= new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        fname.setForeground(new Color(240, 128, 128));
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300,190,300,30);
        add(fnameTextField);

        JLabel dob= new JLabel("DoB:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        dob.setForeground(new Color(240, 128, 128));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,300,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        gender.setForeground(new Color(240, 128, 128));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(new Color(173, 216, 230));
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,70,30);
        female.setBackground(new Color(173, 216, 230));
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel eMail= new JLabel("Email address:");
        eMail.setFont(new Font("Raleway", Font.BOLD, 20));
        eMail.setBounds(100,340,200,30);
        eMail.setForeground(new Color(240, 128, 128));
        add(eMail);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300,340,300,30);
        add(emailTextField);

        JLabel marStatus = new JLabel("Marital Status:");
        marStatus.setFont(new Font("Raleway", Font.BOLD, 20));
        marStatus.setBounds(100,390,200,30);
        marStatus.setForeground(new Color(240, 128, 128));
        add(marStatus);

        married = new JRadioButton("Married");
        married.setBounds(300,390,70,30);
        married.setBackground(new Color(173, 216, 230));
        add(married);

        single = new JRadioButton("Single");
        single.setBounds(425,390,70,30);
        single.setBackground(new Color(173, 216, 230));
        add(single);

        other = new JRadioButton("Other");
        other.setBounds(540,390,70,30);
        other.setBackground(new Color(173, 216, 230));
        add(other);

        ButtonGroup margroup = new ButtonGroup();
        margroup.add(married);
        margroup.add(single);
        margroup.add(other);

        JLabel address= new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        address.setForeground(new Color(240, 128, 128));
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300,440,300,30);
        add(addressTextField);

        JLabel city= new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        city.setForeground(new Color(240, 128, 128));
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300,490,300,30);
        add(cityTextField);

        JLabel state= new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds( 100,540,200,30);
        state.setForeground(new Color(240, 128, 128));
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300,540,300,30);
        add(stateTextField);

        JLabel pinCode= new JLabel("Pin Code:");
        pinCode.setFont(new Font("Raleway", Font.BOLD, 20));
        pinCode.setBounds(100,590,200,30);
        pinCode.setForeground(new Color(240, 128, 128));
        add(pinCode);

        pinCTextField = new JTextField();
        pinCTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinCTextField.setBounds(300,590,300,30);
        add(pinCTextField);

        next = new JButton("NEXT");
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBackground(Color.PINK);
        next.setForeground(Color.WHITE);
        next.setBounds(300,650,300,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(173, 216, 230));

        setSize(850,800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pinCode = pinCTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";
        }

        String maritalStatus = null;
        if (married.isSelected()){
            maritalStatus = "Married";
        }else if (single.isSelected()){
            maritalStatus = "Single";
        }else if (other.isSelected()){
            maritalStatus = "Other";
        }

        try {
            if (name.isEmpty()){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else {
                Conn c = new Conn();
                String query = "insert into chakwa values('"+formno+"', +'"+name+"', '"+fname+"', '"+dob+"', '"+gender+"','"+email+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+pinCode+"', '"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }



    public static void main(String[] args) {
        new SignupOne();
    }
}

