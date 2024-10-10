package main;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CriadorDeTerreno extends JPanel {
	
	private JPanel painelForm;
	private JTextField dimensaoInput;
	private JTextField quantPedrasInput;
	private JTextField chanceBichadaInput;
	private JTextField capacidadeMochilaInput;
    
	private JTextField maracujasNoJogoInput;
    private JTextField maracujasNoChaoInput;
    private JTextField laranjeirasNoJogoInput;
    private JTextField laranjasNoChaoInput;
    private JTextField abacateirasNoJogoInput;
    private JTextField abacatesNoChaoInput;
    private JTextField coqueirosNoJogoInput;
    private JTextField cocosNoChaoInput;
    private JTextField aceroleirasNoJogoInput;
    private JTextField acerolasNoChaoInput;
    private JTextField amoreirasNoJogoInput;
    private JTextField amorasNoChaoInput;
    private JTextField goiabeirasNoJogoInput;
    private JTextField goiabasNoChaoInput;
    
    // Construtor da classe
    public CriadorDeTerreno() {
     
        painelForm = new JPanel(new GridLayout(12, 3, 10, 0)); 
        
        dimensaoInput = new JTextField();
        quantPedrasInput = new JTextField();
        chanceBichadaInput = new JTextField();
        capacidadeMochilaInput = new JTextField();
        
		maracujasNoJogoInput = new JTextField();
		maracujasNoChaoInput = new JTextField();
		laranjeirasNoJogoInput = new JTextField();
		laranjasNoChaoInput = new JTextField();
		abacateirasNoJogoInput = new JTextField();
		abacatesNoChaoInput = new JTextField();
		coqueirosNoJogoInput = new JTextField();
		cocosNoChaoInput = new JTextField();
		aceroleirasNoJogoInput = new JTextField();
		acerolasNoChaoInput = new JTextField();
		amoreirasNoJogoInput = new JTextField();
		amorasNoChaoInput = new JTextField();
		goiabeirasNoJogoInput = new JTextField();
		goiabasNoChaoInput = new JTextField();
        
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        painelForm.add(new JLabel("   CONFIGURAÇÕES:"));
        painelForm.add(new JLabel(" "));
        painelForm.add(new JLabel(" "));
        painelForm.add(new JLabel(" "));
        
        criarCampo(new JLabel("Dimensão: "), dimensaoInput);
        criarCampo(new JLabel("Quantidade de Pedras: "), quantPedrasInput);
        painelForm.add(new JLabel(" "));
        criarCampo(new JLabel("Chance de bichadas: "), chanceBichadaInput);
        criarCampo(new JLabel("Capacidade da Mochila: "), capacidadeMochilaInput);
        
        painelForm.add(new JLabel("    FRUTAS: "));
        painelForm.add(new JLabel(" "));
        painelForm.add(new JLabel(" "));
        
        painelForm.add(new JLabel(" "));
        painelForm.add(new JLabel("Quantidade de Árvores: "));
        painelForm.add(new JLabel("Quantidade no Chão: "));
        
        painelForm.add(new JLabel(" - Maracujá"));
        criarCampo(new JLabel(" "), maracujasNoJogoInput);
        criarCampo(new JLabel(" "), maracujasNoChaoInput);
        
        
        painelForm.add(new JLabel(" - Laranja"));
        criarCampo(new JLabel(" "), laranjeirasNoJogoInput);
        criarCampo(new JLabel(" "), laranjasNoChaoInput);
        
        painelForm.add(new JLabel(" - Abacate"));
        criarCampo(new JLabel(" "), abacateirasNoJogoInput);
        criarCampo(new JLabel(" "), abacatesNoChaoInput);
        
        painelForm.add(new JLabel(" - Coco"));
        criarCampo(new JLabel(" "), coqueirosNoJogoInput);
        criarCampo(new JLabel(" "), cocosNoChaoInput);
        
        painelForm.add(new JLabel(" - Acerola"));
        criarCampo(new JLabel(" "), aceroleirasNoJogoInput);
        criarCampo(new JLabel(" "), acerolasNoChaoInput);
        
        painelForm.add(new JLabel(" - Amora"));
        criarCampo(new JLabel(" "), amoreirasNoJogoInput);
        criarCampo(new JLabel(" "), amorasNoChaoInput);
        
        painelForm.add(new JLabel(" - Goiaba"));
        criarCampo(new JLabel(" "), goiabeirasNoJogoInput);
        criarCampo(new JLabel(" "), goiabasNoChaoInput);
        
        
        JButton importarTerrenoBtn = new JButton("Importar Terreno");
        JButton exportarTerrenoBtn = new JButton("Exportar Terreno");
        JButton testarTerrenoBtn = new JButton("Testar Terreno");

        painelBotoes.add(importarTerrenoBtn);
        painelBotoes.add(exportarTerrenoBtn);
        painelBotoes.add(testarTerrenoBtn);
        
        importarTerrenoBtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		JFileChooser fileChooser = new JFileChooser();
        		int resultado = fileChooser.showOpenDialog(null);
        		if(resultado == JFileChooser.APPROVE_OPTION) {
        			File arquivoTerreno = fileChooser.getSelectedFile();
        			importarTerreno(arquivoTerreno);
        		}
        		

        	}
        });
        
        exportarTerrenoBtn.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		if(verificarInputs()) {
        			String nomeTerreno = JOptionPane.showInputDialog("Digite o nome do terreno:");
        			if (nomeTerreno.trim().isEmpty()) {
        				JOptionPane.showMessageDialog(null, "Insira algum nome para o terreno!");
        			} else {
        				exportarTerreno(nomeTerreno);
        			}        			
        		}
      
            }
        });
        
        testarTerrenoBtn.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if(verificarInputs()) {
        			int dimensao = Integer.parseInt(dimensaoInput.getText());
        			int quantDePedras = Integer.parseInt(quantPedrasInput.getText());
        			double chanceBichada = Double.parseDouble(chanceBichadaInput.getText());
        			int capacidadeMochila = Integer.parseInt(capacidadeMochilaInput.getText());
        			
        			int maracujasNoJogo = Integer.parseInt(maracujasNoJogoInput.getText());
        			int maracujasNoChao = Integer.parseInt(maracujasNoChaoInput.getText());
        			int laranjeirasNoJogo = Integer.parseInt(laranjeirasNoJogoInput.getText());
        			int laranjasNoChao = Integer.parseInt(laranjasNoChaoInput.getText());
        			int abacateirasNoJogo = Integer.parseInt(abacateirasNoJogoInput.getText());
        			int abacatesNoChao = Integer.parseInt(abacatesNoChaoInput.getText());
        			int coqueirosNoJogo = Integer.parseInt(coqueirosNoJogoInput.getText());
        			int cocosNoChao = Integer.parseInt(cocosNoChaoInput.getText());
        			int aceroleirasNoJogo = Integer.parseInt(aceroleirasNoJogoInput.getText());
        			int acerolasNoChao = Integer.parseInt(acerolasNoChaoInput.getText());
        			int amoreirasNoJogo = Integer.parseInt(amoreirasNoJogoInput.getText());
        			int amorasNoChao = Integer.parseInt(amorasNoChaoInput.getText());
        			int goiabeirasNoJogo = Integer.parseInt(goiabeirasNoJogoInput.getText());
        			int goiabasNoChao = Integer.parseInt(goiabasNoChaoInput.getText());
        			
        			ConfiguracaoJogo configuracaoJogo = new ConfiguracaoJogo(dimensao, quantDePedras, chanceBichada, capacidadeMochila, maracujasNoJogo, maracujasNoChao, laranjeirasNoJogo, laranjasNoChao, abacateirasNoJogo, abacatesNoChao, coqueirosNoJogo, cocosNoChao, aceroleirasNoJogo, acerolasNoChao, amoreirasNoJogo, amorasNoChao, goiabeirasNoJogo, goiabasNoChao);
        			
        			new Jogo(configuracaoJogo);
        		}
        	}
        });

        // Configurando o layout geral deste painel como BorderLayout
        setLayout(new BorderLayout());

        // Adicionando o painel de formulários na parte central
        add(painelForm, BorderLayout.CENTER);

        // Adicionando o painel de botões na parte inferior (sul)
        add(painelBotoes, BorderLayout.SOUTH);
    }
    
    private void criarCampo(JLabel label, JTextField input) {
    	JPanel painelCampo = new JPanel();
        painelCampo.setLayout(new BoxLayout(painelCampo, BoxLayout.Y_AXIS)); // Disposição vertical (label em cima e campo embaixo)

        // Adicionando o label e o campo de texto ao painel vertical
        painelCampo.add(label);
        painelCampo.add(input);

        // Adicionando o painel do campo ao painel principal (GridLayout)
        painelForm.add(painelCampo);
    }
    
    private void importarTerreno(File arquivo) {
    	try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
    		String linha;
    		while((linha = br.readLine()) != null) {
    			String dados[] = linha.split(" ");
    			switch(dados[0]) {
    			case "dimensao":
    				dimensaoInput.setText(dados[1]);
    				break;
    			case "pedras":
    				quantPedrasInput.setText(dados[1]);
    				break;
    			case "maracuja":
    				maracujasNoJogoInput.setText(dados[1]);
    				maracujasNoChaoInput.setText(dados[2]);
    				break;
    			case "laranja":
    				laranjeirasNoJogoInput.setText(dados[1]);
    				laranjasNoChaoInput.setText(dados[2]);
    				break;
    			case "abacate":
    				abacateirasNoJogoInput.setText(dados[1]);
    				abacatesNoChaoInput.setText(dados[2]);
    				break;
    			case "coco":
    				coqueirosNoJogoInput.setText(dados[1]);
    				cocosNoChaoInput.setText(dados[2]);
    				break;
    			case "acerola":
    				aceroleirasNoJogoInput.setText(dados[1]);
    				acerolasNoChaoInput.setText(dados[2]);
    				break;
    			case "amora":
    				amoreirasNoJogoInput.setText(dados[1]);
    				amorasNoChaoInput.setText(dados[2]);
    				break;
    			case "goiaba":
    				goiabeirasNoJogoInput.setText(dados[1]);
    				goiabasNoChaoInput.setText(dados[2]);
    				break;
    			case "bichadas":
    				chanceBichadaInput.setText(dados[1]);
    				break;
    			case "mochila":
    				capacidadeMochilaInput.setText(dados[1]);
    				break;
    			}
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void exportarTerreno(String nomeTerreno) {
    	String dimensao = dimensaoInput.getText();
    	String quantDePedras = quantPedrasInput.getText();
    	String chanceDeBichada = chanceBichadaInput.getText();
    	String capacidadeMochila = capacidadeMochilaInput.getText();
    	
    	String maracujasNoJogo = maracujasNoJogoInput.getText();
    	String maracujasNoChao = maracujasNoChaoInput.getText();
    	String laranjeirasNoJogo = laranjeirasNoJogoInput.getText();
    	String laranjasNoChao = laranjasNoChaoInput.getText();
    	String abacateirasNoJogo = abacateirasNoJogoInput.getText();
    	String abacatesNoChao = abacatesNoChaoInput.getText();
    	String coqueirosNoJogo = coqueirosNoJogoInput.getText();
    	String cocosNoChao = cocosNoChaoInput.getText();
    	String aceroleirasNoJogo = aceroleirasNoJogoInput.getText();
    	String acerolasNoChao = acerolasNoChaoInput.getText();
    	String amoreirasNoJogo = amoreirasNoJogoInput.getText();
    	String amorasNoChao = amorasNoChaoInput.getText();
    	String goiabeirasNoJogo = goiabeirasNoJogoInput.getText();
    	String goiabasNoChao = goiabasNoChaoInput.getText();
    	
    	JFileChooser fileChooser = new JFileChooser();
    	fileChooser.setDialogTitle("Escolha onde deseja salvar o terreno");
    	fileChooser.setSelectedFile(new File(nomeTerreno + ".txt"));
    	
    	int userSelection = fileChooser.showSaveDialog(this);
    	
    	 if (userSelection == JFileChooser.APPROVE_OPTION) {
    	        File fileToSave = fileChooser.getSelectedFile();
		    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave, false))){
		    		writer.write("dimensao " + dimensao);
		    		writer.newLine();
		    		writer.write("pedras " + quantDePedras);
		    		writer.newLine();
		    		writer.write("maracuja " + maracujasNoJogo + " " + maracujasNoChao);
		    		writer.newLine();
		    		writer.write("laranja " + laranjeirasNoJogo + " " + laranjasNoChao);
		    		writer.newLine();	
		    		writer.write("abacate " + abacateirasNoJogo + " " + abacatesNoChao);
		    		writer.newLine();
		    		writer.write("coco " + coqueirosNoJogo + " " + cocosNoChao);
		    		writer.newLine();
		    		writer.write("acerola " + aceroleirasNoJogo + " " + acerolasNoChao);
		    		writer.newLine();
		    		writer.write("amora " + amoreirasNoJogo + " " + amorasNoChao);
		    		writer.newLine();
		    		writer.write("goiaba " + goiabeirasNoJogo + " " + goiabasNoChao);
		    		writer.newLine();
		    		writer.write("bichadas " + chanceDeBichada);
		    		writer.newLine();
		    		writer.write("mochila " + capacidadeMochila);
		    		JOptionPane.showMessageDialog(this, "Terreno exportado com sucesso!");
		    	} catch (IOException ex) {
		    		JOptionPane.showMessageDialog(this, "Erro ao salvar terreno: " + ex.getMessage());
		    	}
    	 }
    }
    
    public boolean verificarInputs() {
        int dimensao, quantDePedras, chanceDeBichada, capacidadeMochila;
        int maracujasNoJogo, maracujasNoChao, laranjeirasNoJogo, laranjasNoChao, abacateirasNoJogo, abacatesNoChao, coqueirosNoJogo, cocosNoChao, aceroleirasNoJogo, acerolasNoChao, amoreirasNoJogo, amorasNoChao, goiabeirasNoJogo, goiabasNoChao;
        
        int totalDeElementos;

        try {
            dimensao = Integer.parseInt(dimensaoInput.getText().trim());
            quantDePedras = Integer.parseInt(quantPedrasInput.getText().trim());
            chanceDeBichada = Integer.parseInt(chanceBichadaInput.getText().trim());
            capacidadeMochila = Integer.parseInt(capacidadeMochilaInput.getText().trim());
            
            maracujasNoJogo = Integer.parseInt(maracujasNoJogoInput.getText().trim());
            maracujasNoChao = Integer.parseInt(maracujasNoChaoInput.getText().trim());
            laranjeirasNoJogo = Integer.parseInt(laranjeirasNoJogoInput.getText().trim());
            laranjasNoChao = Integer.parseInt(laranjasNoChaoInput.getText().trim());
            abacateirasNoJogo = Integer.parseInt(abacateirasNoJogoInput.getText().trim());
            abacatesNoChao = Integer.parseInt(abacatesNoChaoInput.getText().trim());
            coqueirosNoJogo = Integer.parseInt(coqueirosNoJogoInput.getText().trim());
            cocosNoChao = Integer.parseInt(cocosNoChaoInput.getText().trim());
            aceroleirasNoJogo = Integer.parseInt(aceroleirasNoJogoInput.getText().trim());
            acerolasNoChao = Integer.parseInt(acerolasNoChaoInput.getText().trim());
            amoreirasNoJogo = Integer.parseInt(amoreirasNoJogoInput.getText().trim());
            amorasNoChao = Integer.parseInt(amorasNoChaoInput.getText().trim());
            goiabeirasNoJogo = Integer.parseInt(goiabeirasNoJogoInput.getText().trim());
            goiabasNoChao = Integer.parseInt(goiabasNoChaoInput.getText().trim());
            
            totalDeElementos = quantDePedras + maracujasNoChao + laranjeirasNoJogo + laranjasNoChao + abacateirasNoJogo + abacatesNoChao + coqueirosNoJogo + cocosNoChao + aceroleirasNoJogo + acerolasNoChao + amoreirasNoJogo + amorasNoChao + goiabeirasNoJogo + goiabasNoChao;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preencha os campos com números e certifique-se de não deixar opções em branco!");
            return false;
        }

        // Verificação de campos numéricos dentro do intervalo correto
        if (dimensao > 14 || dimensao < 3) {
            JOptionPane.showMessageDialog(this, "A dimensão do terreno está limitada entre 3 e 14!");
            return false;
        }
        
        if(dimensao < 0 || quantDePedras < 0 || chanceDeBichada < 0 || capacidadeMochila < 0 || maracujasNoJogo < 0 || maracujasNoChao < 0 || laranjeirasNoJogo < 0 || laranjasNoChao < 0 || abacateirasNoJogo < 0 || abacatesNoChao < 0 || coqueirosNoJogo < 0 || cocosNoChao < 0 || aceroleirasNoJogo < 0 || acerolasNoChao < 0 || amoreirasNoJogo < 0 || amorasNoChao < 0 || goiabeirasNoJogo < 0 || goiabasNoChao < 0) {
        	JOptionPane.showMessageDialog(this, "Não são permitidos valores negativos!");
        	return false;
        }
        
        if(totalDeElementos > dimensao*dimensao) {
        	JOptionPane.showMessageDialog(this, "A quantidade de elementos é superior à dimensão do terreno! Por favor, reduza a quantidade.");
        	return false;
        }

        return true;
    }

}
