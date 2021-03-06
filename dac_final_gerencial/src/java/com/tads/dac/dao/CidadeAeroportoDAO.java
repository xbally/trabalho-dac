package com.tads.dac.dao;

import com.tads.dac.beans.CidadeAeroporto;
import com.tads.dac.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CidadeAeroportoDAO {
    public static int insertCidadeAeroporto(CidadeAeroporto cidade){
        try{
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();

            Serializable id = s.save(cidade);
            t.commit();
            
            s.close();

            return Integer.parseInt(id.toString());
        }
        catch(Exception ex){
            throw new RuntimeException(
                "Erro ao inserir cidade aeroporto: " + ex.getMessage());
        }
    }
    
    public static CidadeAeroporto getCidadeAeroportoById(int id){
        try{
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            
            CidadeAeroporto c = (CidadeAeroporto) s.get(CidadeAeroporto.class, id);
            
            if (c != null)
                return c;
            else throw new RuntimeException(
                "Erro: Cidade aeroporto não foi encontrada!");
        }
        catch(Exception ex){
            throw new RuntimeException(
                "Erro ao buscar cidade aeroporto: " + ex.getMessage());
        }
    }
    
    public static List<CidadeAeroporto> listCidadeAeroportos(){
        try{
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            Query q = s.createQuery("from CidadeAeroporto");
            
            List<CidadeAeroporto> lista = q.list();
            
            if (lista != null)
                return lista;
            else throw new RuntimeException(
                "Erro: Nenhuma cidade aeroporto encontrada!");
        }
        catch(Exception ex){
            throw new RuntimeException(
                "Erro ao listar cidades aeroporto: " + ex.getMessage());
        }
    }
    
    public static boolean updateCidadeAeroporto(CidadeAeroporto cidade){
        try{
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            
            s.update(cidade);
            
            t.commit();
            s.close();
            
            return true;
        }
        catch(Exception ex){
            throw new RuntimeException(
                "Erro ao atualizar cidade aeroporto: " + ex.getMessage());
        }
    }
    
    public static boolean deleteCidadeAeroporto(int id){
        try{
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction t = s.beginTransaction();
            
            CidadeAeroporto c = (CidadeAeroporto) s.get(CidadeAeroporto.class, id);
            
            s.delete(c);
            
            t.commit();
            s.close();
            
            return true;
        }
        catch(Exception ex){
            throw new RuntimeException(
                "Erro ao deletar cidade aeroporto: " + ex.getMessage());
        }
    }
}
