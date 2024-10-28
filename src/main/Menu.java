package main;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.SpringLayout;
import javax.swing.JButton;


import javax.swing.JLabel;

import java.io.File;


public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;

	public Menu() {
		// Configura o painel principal
		setBackground(new Color(0, 0, 0));
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Define o layout do painel
		SpringLayout sl_contentPane = new SpringLayout();
		setLayout(sl_contentPane);
		
		
		JLabel lblNewLabel = new JLabel("CATA-FRUTAS");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -400, SpringLayout.EAST, this);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 70));
		lblNewLabel.setForeground(Color.WHITE);
		add(lblNewLabel);

		
		JButton btnIniciarJogo = new JButton("INICIAR JOGO");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -110, SpringLayout.NORTH, btnIniciarJogo);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnIniciarJogo, 317, SpringLayout.NORTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnIniciarJogo, 382, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnIniciarJogo, -362, SpringLayout.EAST, this);
		btnIniciarJogo.setBackground(new Color(51, 153, 102));
		btnIniciarJogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnIniciarJogo.setBorderPainted(false);
		add(btnIniciarJogo);
		
		btnIniciarJogo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
		        removeAll();
		        
		        // Adiciona o painel Teste ao painel principal
		        Submenu painelTeste = new Submenu();
		        setLayout(new BorderLayout());  // Define um layout apropriado
		        
		        add(painelTeste, BorderLayout.CENTER);  // Adiciona o novo painel
		        
		        // Atualiza a interface
		        revalidate();
		        repaint();

			}
		});
		
		
		JButton btnCriadorDeTerreno = new JButton("CRIADOR DE TERRENO");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnIniciarJogo, -24, SpringLayout.NORTH, btnCriadorDeTerreno);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnCriadorDeTerreno, -189, SpringLayout.SOUTH, this);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCriadorDeTerreno, 382, SpringLayout.WEST, this);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnCriadorDeTerreno, -362, SpringLayout.EAST, this);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCriadorDeTerreno, 413, SpringLayout.NORTH, this);
		btnCriadorDeTerreno.setBackground(new Color(51, 153, 102));
		btnCriadorDeTerreno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		add(btnCriadorDeTerreno);
		
		btnCriadorDeTerreno.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Limpa o painel principal
		        removeAll();
		        
		        // Adiciona o CriadorDeTerreno ao painel principal
		        CriadorDeTerreno criadorDeTerreno = new CriadorDeTerreno();
		        setLayout(new BorderLayout());  // Define um layout apropriado

		        add(criadorDeTerreno, BorderLayout.CENTER);  // Adiciona o novo painel ao centro
		        
		        // Atualiza a interface
		        revalidate();
		        repaint();
		    }
		});

	}
	
}
