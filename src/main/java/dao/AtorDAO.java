/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Ator;
import util.HibernateUtil;
import util.PersistenceUtil;

/**
 *
 * @author Duda
 */
public class AtorDAO {

    public void inserirAtor(Ator ator) {
        System.out.println("Inicio de secao do ator: " + ator);
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ator);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Ator> listarAtores() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Ator", Ator.class).list();
        } catch (Exception e) {
            System.err.println("Erro ao listar atores: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Ator listarAtorId(Long id) {
        Transaction transaction = null;
        Session session = null;
        Ator ator = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            ator = session.get(Ator.class, id);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return ator;
    }

    public void alterarAtor(Long id, String nome) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Ator ator = session.get(Ator.class, id);
            if (ator != null) {
                ator.setNome(nome);
                session.update(ator);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void excluirAtor(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Ator ator = session.get(Ator.class, id);
            if (ator != null) {
                System.out.println("Deletando ator: " + ator.getNome());
                session.delete(ator);
            } else {
                System.out.println("Ator não encontrado para deletar!");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

}
