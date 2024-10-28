package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Submenu extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField jogadorUmInput;
    private JTextField jogadorDoisInput;

    public Submenu() {
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnVoltar.setBounds(10, 10, 90, 40);
        btnVoltar.setBackground(Color.RED);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.setBorderPainted(false);
        add(btnVoltar);
        
        JLabel lblNewLabel_1 = new JLabel("Escolha os nomes dos jogadores");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(386, 49, 469, 37);
        add(lblNewLabel_1);

        JLabel jogadorUmLabel = new JLabel("Jogador 1");
        jogadorUmLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jogadorUmLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jogadorUmLabel.setForeground(Color.WHITE);
        jogadorUmLabel.setBounds(537, 140, 182, 37);
        add(jogadorUmLabel);

        jogadorUmInput = new JTextField();
        jogadorUmInput.setBounds(508, 180, 240, 30);
        add(jogadorUmInput);
        jogadorUmInput.setColumns(10);

        JLabel jogadorDoisLabel = new JLabel("Jogador 2");
        jogadorDoisLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jogadorDoisLabel.setForeground(Color.WHITE);
        jogadorDoisLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        jogadorDoisLabel.setBounds(537, 236, 182, 37);
        add(jogadorDoisLabel);

        jogadorDoisInput = new JTextField();
        jogadorDoisInput.setColumns(10);
        jogadorDoisInput.setBounds(508, 276, 240, 30);
        add(jogadorDoisInput);

        JButton btnImportar = new JButton("IMPORTAR TERRENO");
        btnImportar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnImportar.setBounds(508, 388, 240, 68);
        btnImportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(btnImportar);
        
        btnImportar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
        		int resultado = fileChooser.showOpenDialog(null);
        		
        		int dimensao = 0;
    			int quantDePedras = 0;
    			double chanceBichada = 0;
    			int capacidadeMochila = 0;
    			
    			int maracujasNoJogo = 0;
    			int maracujasNoChao = 0;
    			int laranjeirasNoJogo = 0;
    			int laranjasNoChao = 0;
    			int abacateirasNoJogo = 0;
    			int abacatesNoChao = 0;
    			int coqueirosNoJogo = 0;
    			int cocosNoChao = 0;
    			int aceroleirasNoJogo = 0;
    			int acerolasNoChao = 0;
    			int amoreirasNoJogo = 0;
    			int amorasNoChao = 0;
    			int goiabeirasNoJogo = 0;
    			int goiabasNoChao = 0;
    			
        		if(resultado == JFileChooser.APPROVE_OPTION) {
        			File arquivoTerreno = fileChooser.getSelectedFile();
        			try(BufferedReader br = new BufferedReader(new FileReader(arquivoTerreno))){
        	    		String linha;
        	    		while((linha = br.readLine()) != null) {
        	    			String dados[] = linha.split(" ");
        	    			switch(dados[0]) {
        	    			case "dimensao":
        	    				dimensao = Integer.parseInt(dados[1]);
        	    				break;
        	    			case "pedras":
        	    				quantDePedras = Integer.parseInt(dados[1]);
        	    				break;
        	    			case "maracuja":
        	    				maracujasNoJogo = Integer.parseInt(dados[1]);
        	    				maracujasNoChao = Integer.parseInt(dados[2]);
        	    				break;
        	    			case "laranja":
        	    				laranjeirasNoJogo = Integer.parseInt(dados[1]);
        	    				laranjasNoChao = Integer.parseInt(dados[2]);
        	    				break;
        	    			case "abacate":
        	    				abacateirasNoJogo = Integer.parseInt(dados[1]);
        	    				abacatesNoChao = Integer.parseInt(dados[2]);
        	    				break;
        	    			case "coco":
        	    				coqueirosNoJogo = Integer.parseInt(dados[1]);
        	    				cocosNoChao = Integer.parseInt(dados[2]);
        	    				break;
        	    			case "acerola":
        	    				aceroleirasNoJogo = Integer.parseInt(dados[1]);
        	    				acerolasNoChao = Integer.parseInt(dados[2]);
        	    				break;
        	    			case "amora":
        	    				amoreirasNoJogo = Integer.parseInt(dados[1]);
        	    				amorasNoChao = Integer.parseInt(dados[2]);
        	    				break;
        	    			case "goiaba":
        	    				goiabeirasNoJogo = Integer.parseInt(dados[1]);
        	    				goiabasNoChao = Integer.parseInt(dados[2]);
        	    				break;
        	    			case "bichadas":
        	    				chanceBichada = Double.parseDouble(dados[1]);
        	    				break;
        	    			case "mochila":
        	    				capacidadeMochila = Integer.parseInt(dados[1]);
        	    				break;
        	    			}
        	    		}
        	    		
        	    		ConfiguracaoJogo configuracaoJogo = new ConfiguracaoJogo(dimensao, quantDePedras, chanceBichada, capacidadeMochila, maracujasNoJogo, maracujasNoChao, laranjeirasNoJogo, laranjasNoChao, abacateirasNoJogo, abacatesNoChao, coqueirosNoJogo, cocosNoChao, aceroleirasNoJogo, acerolasNoChao, amoreirasNoJogo, amorasNoChao, goiabeirasNoJogo, goiabasNoChao);
        	    		
        	    		configuracaoJogo.setNomeJogadorUm(jogadorUmInput.getText());
        	    		configuracaoJogo.setNomeJogadorDois(jogadorDoisInput.getText());
            			
            			new Jogo(configuracaoJogo);
        	    	} catch (IOException er) {
        	    		er.printStackTrace();
        	    	}
        		}
        		

			}
		});
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                JPanel parent = (JPanel) getParent();
                parent.removeAll();

                // Adiciona o painel do menu novamente
                Menu menu = new Menu();
                parent.add(menu);

                // Atualiza a interface
                parent.revalidate();
                parent.repaint();
        	}
        });
        
    }
}
