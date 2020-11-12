/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoDAO.DAO;

import br.com.projetoDAO.model.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 55319
 */
public class PessoaDAOTest {
    Pessoa p, p1, p2, p3;
    public PessoaDAOTest() {
         p = new Pessoa("Pedro", "Programador");
         p1 = new Pessoa("Maria", "Analista");
         p2 = new Pessoa(1,"João", "Testador");
         p2 = new Pessoa(2,"Mário", "ScrumMaster");
         
    }
    
    @BeforeClass
    public static void setUpClass() {
          System.out.println("Antes da classe");
    }
    
    @AfterClass
    public static void tearDownClass() {
          System.out.println("Depois da classe");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consulta method, of class PessoaDAO.
     */
    @Test
    public void testConsulta() {
        System.out.println("consulta");
        PessoaDAO instance = new PessoaDAO();
        if(instance.consulta())
            System.out.println("Teste ok");
        else
       fail("Erro no teste de consulta");
        assertTrue(instance.consulta());
    }

    /**
     * Test of inserir method, of class PessoaDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        PessoaDAO pd = new PessoaDAO();
        assertTrue(pd.inserir(p));
        assertTrue(pd.inserir(p1));
        
    }

    /**
     * Test of update method, of class PessoaDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("atualizar");
      PessoaDAO pd = new PessoaDAO();
       assertTrue(pd.update(p2));
    }

    /**
     * Test of delete method, of class PessoaDAO.
     */
    @Test
    public void testDelete() {
         System.out.println("deletar");
        PessoaDAO pd = new PessoaDAO();
        assertTrue(pd.delete(p1));
    }
    
}
