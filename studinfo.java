import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



class Gui implements ActionListener
{
    String Id;
    String Name;
    String Course;
    JButton btnAdd, btnCancel;
    JLabel lblId, lblName, lblCourse;
    JTextField txtId, txtName, txtCourse;
    JOptionPane pane;
    Connection con;
    PreparedStatement ps;
    public Gui()
    {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        lblId = new JLabel("ID N.O: ");
        lblName = new JLabel("NAME: ");
        lblCourse = new JLabel("COURSE: ");
        
        txtId = new JTextField(Id);
        txtName = new JTextField(Name);
        txtCourse = new JTextField(Course);
        
        btnAdd = new JButton("Add info");
        btnCancel = new JButton("Cancel");
        
        panel.setLayout(null);
        panel.setLayout(new GridLayout(4,2));
        
        panel.add(lblId);
        panel.add(txtId);
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblCourse);
        panel.add(txtCourse);
        panel.add(btnAdd);
        panel.add(btnCancel);
        
        frame.add(panel);
        frame.setTitle("STUDENT INFROMATION MANAGEMENT");
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnAdd.addActionListener(this);
        btnCancel.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        if(e.getSource()== btnAdd)
        {
              String id1 =txtId.getText();
              String name1 =txtName.getText();
              String course1 =txtCourse.getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","root");
            ps = con.prepareStatement("insert into studreg values(?,?,?)");
            ps.setString(1,id1);
            ps.setString(2,name1);
            ps.setString(3,course1);
            ps.executeUpdate();
            System.out.println("Changes Recorded Siuccessfully");
            
            txtId.setText("");
            txtName.setText("");
            txtCourse.setText("");
           

            } 
        catch (ClassNotFoundException | SQLException ex) 
            {
            System.out.println("The sqlException is: "+ex);
            }       
        }
        if(e.getSource()==btnCancel)
        {
            txtId.setText(" ");
            txtName.setText(" ");
            txtCourse.setText(" ");
            System.out.println("The data has been cleared");
        }

    }
    
    
}



public class StudDetails 
{
    public static void main(String[] args)
    {
        Gui obj = new Gui();
    }
}
