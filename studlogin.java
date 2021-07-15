import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class demo implements ActionListener
{
    JFrame frame;
    JPanel panel;
    JLabel lblTitle,lblid, lblname,lblcourse, lbldor;
    JTextField txtid, txtname, txtdor;
    JButton btnAdd, btnCancel;
    JComboBox <String> cmb;
    public demo()
    {
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(null);

        lblTitle = new JLabel("STUDENT MANAGEMENT SYSTEM");
        lblTitle.setBounds(150,20,200,30);
        

        lblid = new JLabel("STUDENT ID");
        lblid.setBounds(100,100,70,30);

        lblname = new JLabel("STUDENT NAME");
        lblname.setBounds(100,100+30,100,30);

        String s1[] = {"C","C++","JAVA","PYTHON","JAVASCRIPT","PHP","HTML","CSS","SQL","NONE"};
        cmb =new JComboBox<String>(s1);
        cmb.setBounds(250,100+90,100,30);

        lblcourse = new JLabel("COURSES REGISTERED");
        lblcourse.setBounds(100,100+90,200,30);

        lbldor = new JLabel("DATE OF REGISTRATION");
        lbldor.setBounds(100,100+60,150,30);

        txtid = new JTextField(100);
        txtid.setBounds(250,100,100,30);

        txtname= new JTextField(100);
        txtname.setBounds(250,100+30,100,30);

        txtdor = new JTextField(100);
        txtdor.setBounds(250,100+60,150,30);

        btnAdd = new JButton("SUBMIT");
        btnAdd.setBounds(100, 100+180,100,30);
        btnAdd.addActionListener(this);

        btnCancel = new JButton("CLEAR");
        btnCancel.setBounds(200, 100+180,100,30);
        btnCancel.addActionListener(this);


        panel.add(lblTitle);
        panel.add(lblid);
        panel.add(lblname);
        panel.add(lbldor);
        panel.add(txtid);
        panel.add(txtname);
        panel.add(txtdor);
        panel.add(lblcourse);
        panel.add(cmb);
        panel.add(btnAdd);
        panel.add(btnCancel);

        frame.add(panel);


        
        frame.setTitle("STUDENT MANAGEMENT SYSTEM");
        frame.setSize(600,400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        





    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAdd)
        {
            int id = Integer.parseInt(txtid.getText().trim());
            String name = txtname.getText();
            String date =txtdor.getText().trim();
            Object comb = cmb.getSelectedItem();
            System.out.println("STUDENT ID = "+id+"\n"+"STUDENT NAME ="+name+"\n"+"DATE OF JOINING ="+date+"\n"+"COURSES REGISTERED ="+comb);

        }
        if(e.getSource()==btnCancel)
        {
            txtid.setText(" ");
            txtname.setText(" ");
            txtdor.setText(" ");
            cmb.setSelectedItem("NONE");
        }
        
    } 
}
public class studlogin
{
    public static void main(String args[])
    {
        demo obj = new demo();
    }
}