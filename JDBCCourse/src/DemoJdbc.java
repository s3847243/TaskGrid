import java.sql.*;


public class DemoJdbc {
    public static void main(String[] args) {
        // import package
        // load and register
        // create connection - use DriverManager.getConnection
        // crete statement/
        // excecute sttaeme
        // process reuslt
        // close
        String url = "jdbc:postgresql://localhost:5432/test";
        String uname = "postgres";
        String pass = "admin";
        String query = "select * from person WHERE gender = 'Male' ";
        String sql = "insert into car (id, make, model, price) values (1001, 'Hyundai', 'Elantra', '76325.61')";
        // use prepared statement usually which helps you put in values from the user
        /*String sql = "insert into student values (?,?,?)";


        Connection con = DriverManager.getConnection(url, uname, pass);
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, marks);
        st.execute();*/
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,uname,pass);
            System.out.println("Connection Established");

            Statement st  = con.createStatement();
            // this for inserting
           /* boolean status= st.execute(sql); // works for update as well
            System.out.println(status);*/

            /*
            ResultSet rs = st.executeQuery(query);

            //System.out.println(rs.next());
            // READ DATA
            while(rs.next()){
                System.out.print(rs.getInt(1)+ " - ");
                System.out.print(rs.getString(2)+ " - ");
                System.out.println(rs.getString(3)+ " - ");
            }*/
            con.close();
            System.out.println("Connection Closed");
        }catch(Exception e){

        }
    }
}
