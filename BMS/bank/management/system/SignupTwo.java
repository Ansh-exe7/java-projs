package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{

    JTextField panTextField, aadhaarTextField ;
    JComboBox religion, category, income, education, occupation;
    JButton next;
    JRadioButton sno, syes, eyes, eno;
    String formno;

    SignupTwo(String formno){

        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        additionalDetails.setBounds(290,65,400,30);
        additionalDetails.setForeground(new Color(95, 158, 160));
        add(additionalDetails);

        JLabel rlg = new JLabel("Religion:");
        rlg.setFont(new Font("Raleway", Font.BOLD, 20));
        rlg.setBounds(100,140,100,30);
        rlg.setForeground(new Color(240, 128, 128));
        add(rlg);

        String valReligion [] = {"Hindu", "Christian", "Sikh", "Muslim", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,300,30);
        add(religion);

        JLabel cat = new JLabel("Category:");
        cat.setFont(new Font("Raleway", Font.BOLD, 20));
        cat.setBounds(100,190,200,30);
        cat.setForeground(new Color(240, 128, 128));
        add(cat);

        String valCategory[] = {"Unchi Jaati", "OBC", "Dalit", "Chamar", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,300,30);
        add(category);

        JLabel inc = new JLabel("Income:");
        inc.setFont(new Font("Raleway", Font.BOLD, 20));
        inc.setBounds(100,240,200,30);
        inc.setForeground(new Color(240, 128, 128));
        add(inc);

        String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300,240,300,30);
        add(income);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100,300,200,30);
        edu.setForeground(new Color(240, 128, 128));
        add(edu);

        JLabel qal= new JLabel("Qualification:");
        qal.setFont(new Font("Raleway", Font.BOLD, 20));
        qal.setBounds(100,330,200,30);
        qal.setForeground(new Color(240, 128, 128));
        add(qal);

        String valEducation[] = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other"};
        education = new JComboBox(valEducation);
        education.setBounds(300,320,300,30);
        add(education);

        JLabel occ = new JLabel("Occupation:");
        occ.setFont(new Font("Raleway", Font.BOLD, 20));
        occ.setBounds(100,390,200,30);
        occ.setForeground(new Color(240, 128, 128));
        add(occ);

        String valOccupation[] = {"Salaried", "Self-Employed", "Post-Graduate", "Business", "Student", "Retired","Other"};
        occupation = new JComboBox(valOccupation);
        occupation.setBounds(300,390,300,30);
        add(occupation);


        JLabel pan= new JLabel("PAN No:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100,440,200,30);
        pan.setForeground(new Color(240, 128, 128));
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300,440,300,30);
        add(panTextField);

        JLabel aadhaar = new JLabel("Aadhaar No:");
        aadhaar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhaar.setBounds(100,490,200,30);
        aadhaar.setForeground(new Color(240, 128, 128));
        add(aadhaar);

        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhaarTextField.setBounds(300,490,300,30);
        add(aadhaarTextField);

        JLabel sc= new JLabel("Senior Citizen:");
        sc.setFont(new Font("Raleway", Font.BOLD, 20));
        sc.setBounds( 100,540,200,30);
        sc.setForeground(new Color(240, 128, 128));
        add(sc);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,70,30);
        syes.setBackground(new Color(173, 216, 230));
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(425,540,70,30);
        sno.setBackground(new Color(173, 216, 230));
        add(sno);

        ButtonGroup yn = new ButtonGroup();
        yn.add(syes);
        yn.add(sno);

        JLabel ec = new JLabel("Existing Customer:");
        ec.setFont(new Font("Raleway", Font.BOLD, 20));
        ec.setBounds(100,590,200,30);
        ec.setForeground(new Color(240, 128, 128));
        add(ec);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,70,30);
        eyes.setBackground(new Color(173, 216, 230));
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(425,590,70,30);
        eno.setBackground(new Color(173, 216, 230));
        add(eno);

        ButtonGroup yn1 = new ButtonGroup();
        yn1.add(eyes);
        yn1.add(eno);

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

        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String pan =panTextField.getText();
        String aadhaar = aadhaarTextField.getText();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected()){
            seniorcitizen = "YES";
        }else if (sno.isSelected()){
            seniorcitizen = "NO";
        }

        String existingcustomer = null;
        if (eyes.isSelected()){
            existingcustomer = "YES";
        }else if (eno.isSelected()){
            existingcustomer = "NO";
        }

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', +'"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"','"+pan+"', '"+ aadhaar +"', '"+existingcustomer+"', '"+seniorcitizen+"')";
            c.s.executeUpdate(query);
        }catch (Exception e){
            System.out.println(e);
        }

    }



    public static void main(String[] args) {
        new SignupTwo("");
    }
}

