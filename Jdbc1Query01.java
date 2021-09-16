package techproed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.)ilgili driver i yukle

		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.)baglanti olustur

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		// 3.) SQL komutlari icin bir alan Statement nesnesi olustur (alan olusturduk)

		Statement st = con.createStatement();

		// 4.)SQL ifadeleri yazabilir ve calistirabiliriz.
		// personel tablosundaki personel_id si 7369 olan personel adini , maasini
		// sorgula

		ResultSet isim = st.executeQuery("SELECT personel_isim, maas FROM personel WHERE personel_id=7369");
	
	   //5.) sonuclari aldik ve isledik 
		
		while(isim.next()) {
			
		System.out.println("Personel isim " + isim.getString("personel_isim") +" Maas : "+isim.getInt("maas"));	
		}          //direkt bu numaralarla da cagirabilrim kolon sira numarasiyla                                               //1                                    2
		//6.) Olusturulan nesneleri bellekten kaldiralim
		con.close();
		st.close();
		isim.close();

	}

}
