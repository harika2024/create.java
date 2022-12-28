import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.sql.Time;
import java.sql.*;
import javax.sql.*;
//url is login
public class login extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        try{
            res.setContentType("text/html");
            PrintWriter output=res.getWriter();
            String id=req.getParameter("username");
            String pswrd=req.getParameter("pass");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "harika", "harika");
            PreparedStatement st=con.prepareStatement("select pass from internal where name=?");
            st.setString(1, id);
            ResultSet rs=st.executeQuery();
            String pas=null;
            while(rs.next()){
                pas=rs.getString(1);
            }
            if(pas.equals(pswrd)){
            //     HttpSession hs=req.getSession();
            //    Time t=new Time(hs.getCreationTime());
            //    hs.setAttribute("time",t);
            //    hs.setAttribute("username",id);
            //    hs.setAttribute("password",pswrd);
            //    hs.setMaxInactiveInterval(100);
            //  res.sendRedirect("welcome");
            output.print("djfhsjh");
            }
            else{
                output.println("please enter valid creadentials");
                RequestDispatcher rd=req.getRequestDispatcher("login.html");
                rd.forward(req,res);
              
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
}
}