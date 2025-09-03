/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Ator;
import util.PersistenceUtil;

/**
 *
 * @author Duda
 */
public class AtorDAO {
    
    public static int incluirAtor(String nome){
        if((nome == null) || nome.equals("")){
            return 1;
        }
        
        Ator ator = new Ator();
        ator.setNome(nome);
        
        Session s = PersistenceUtil.getSession();
        Transaction t = null;
        
        try {
		
			t = s.beginTransaction();
			
			s.save(nome);
			
			t.commit();
			
			return 0;
			
		}catch(Exception e) {
			
			t.rollback();
			System.out.println(e.getMessage());
			e.printStackTrace();

			return 2;
			
		}finally {
			
			//s.close();
		}
        
    }
}