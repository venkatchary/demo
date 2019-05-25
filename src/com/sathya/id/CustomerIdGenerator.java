package com.sathya.id;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomerIdGenerator implements IdentifierGenerator 
{
	public Serializable generate(SessionImplementor impl, Object entity) throws HibernateException {
		Connection  con=null;
		Statement   stmt=null;
		String  id="";
		try {
			con = impl.connection();
			stmt = con.createStatement();
			String  query="select  customer_sequence.nextval  from  dual";
			ResultSet  rs = stmt.executeQuery(query);
			rs.next();
			int  i =rs.getInt(1);
			rs.close();
			if(i <= 9) {
				id="C00"+i;
			}
			else if(i >9 && i<=99) {
				id="C0"+i;
			}
			else {
				id="C"+i;
			}
			
		}catch(Exception  e) {
			System.out.println(e);
		}finally {
			try {
				stmt.close();
				//con.close();
			}catch(Exception  e) {
				System.out.println(e);
			}
		}
		return id;
	}
}
