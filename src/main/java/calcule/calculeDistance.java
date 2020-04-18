package calcule;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculDistance")
public class calculeDistance extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private double distance;
    private double distance(double lat1, double lon1, double lat2, double lon2) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            this.distance = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            this.distance = Math.acos(this.distance);
            this.distance = Math.toDegrees(this.distance);
            this.distance = this.distance * 60 * 1.1515;
            this.distance = this.distance * 1.609344;
            return (this.distance);
        }
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double lat1 = Double.parseDouble(request.getParameter("latitude1"));
        double lon1 = Double.parseDouble(request.getParameter("longitude2"));
        double lat2 = Double.parseDouble(request.getParameter("latitude2"));
        double lon2 = Double.parseDouble(request.getParameter("longitude2"));
        double result = distance(lat1,lon1,lat2,lon2);
        //out.println("from billing");
        out.println(result);


    }
}
