package br.com.projetoDAO.DAO;

import br.com.projetoDAO.Conexao.Conexao;
import br.com.projetoDAO.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PessoaDAO {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean consulta() {
        String sql = "Select * from pessoa";

        con = Conexao.conectar();

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            System.out.printf("%-5s|%-50s|%-20s\n", "ID", "Nome", "Profissao");
            while (rs.next()) {
                System.out.printf("%-5s|%-50s|%-20s\n", rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível acessar os dados: " + e);
            return false;
        } finally {
            Conexao.desconectar(con);
        }
    }

    public boolean inserir(Pessoa p) {
        String sql = "INSERT INTO pessoa(nome, profissao) VALUES(?,?)";

        con = Conexao.conectar();

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getProfissao());
            int r = pst.executeUpdate();
            if (r > 0) {
                System.out.println("Dados inseridos com sucesso!");
            }
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível inserir os dados!");
            return false;

        }finally{
            Conexao.desconectar(con);
        }

    }
    public boolean update(Pessoa p) {
        String sql = "Update pessoa set nome = ?, profissao = ? where id = ?";
        
        con = Conexao.conectar();
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getProfissao());
            pst.setInt(3, p.getId());
            int u = pst.executeUpdate();
            if (u > 0) {
                System.out.println("Dados atualizados com sucesso!");               
            }
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível atualizar");
            return false;
        }finally{
            Conexao.desconectar(con);
        }
        
    }
    public boolean delete(Pessoa p){
        String sql = "Delete from pessoa where id = ?";
        
        con = Conexao.conectar();
        
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, p.getId());
            int d = pst.executeUpdate();
            if (d > 0 ) {
                System.out.println("Excluído com sucesso!");
                
            }
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível deletar!");
            return false;
        }finally{
            Conexao.desconectar(con);
        }
    }
    
    
    

}