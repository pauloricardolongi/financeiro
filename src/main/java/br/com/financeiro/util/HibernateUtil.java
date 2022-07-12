package br.com.financeiro.util;

import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static  SessionFactory fabricaDeSessoes =  criarFabricaDeSessoes();
    public static SessionFactory getFabricaDeSessoes(){
    	return fabricaDeSessoes;
    }

    private static SessionFactory criarFabricaDeSessoes(){
        try {
            
        	Configuration configuracao = new Configuration();
        	configuracao.configure();
        	
        	ServiceRegistry servicoRegistro = new StandardServiceRegistryBuilder().
        			applySettings(configuracao.getProperties()).build();
        	
        	SessionFactory sessionFactory = configuracao.buildSessionFactory(servicoRegistro);
        	return sessionFactory;
        	

        }
        catch (Throwable ex) {
            // Mensagem de erro ao conectar
            System.err.println("A fábrica de sessões não pode ser criada." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}