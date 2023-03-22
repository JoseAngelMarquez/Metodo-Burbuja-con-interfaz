
/**************************************
 * Autor: Màrquez Espina Josè Àngel   *
 * Fecha Creación: 19/03/23           *
 * Fecha Actualización:	20/03/23	  *
 * Descripción: Método Burbuja        *
 **************************************/
package Ventana;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Ventana extends JFrame implements ActionListener {

	//Declaración de atributos
	private JLabel etiqueta;
	private JButton btnOrdenar;
	private JPanel panel;
	private JTextField valX;
	private JTextField valY;


	//Constructores

	//Constructor vacío

	public Ventana() {
	
		panel=new JPanel();

		panel.setBounds(10, 10, 380, 38);
	
		//Se agrega el color de la Ventana
		panel.setBackground(new Color(22,222,110));
		panel.setLayout(null);
		add(panel);
	
	//En todo este bloque se comienzan agregando los mensajes que apareceràn en la Ventana 
	
	//Se colocan los mensajes que se quiera aparecer en pantalla
	//Mensaje del tìtulo del programa sobre el mètodo utilizado
	etiqueta = new JLabel("Mètodo Burbuja");
	etiqueta.setBounds(120, 20, 200, 30);
	panel.add(etiqueta);
	
	//Mensaje de lo que el usuario debe introducir
	etiqueta = new JLabel("Ingresa la cantidad de numeros a ordenar: ");
	etiqueta.setBounds(20, 50, 400, 20);
	panel.add(etiqueta);

	//Se crea un espacio para que el usuario introduzca la cantidad de numeros
	valX = new JTextField();
	valX.setBounds(325,50,50,20);
	panel.add(valX);

	//Mensaje para digitar todos los numeros a leer 
	etiqueta = new JLabel("Numeros a leer: ");
	etiqueta.setBounds(20, 75, 200, 20);
	panel.add(etiqueta);
	
	//Espacio para introducir los numeros, cada numero que se digite debe estar separado por un espacio
	//El programa solo leera hasta la cantidad de numeros que el usuario haya introducido en el arreglo
	valY = new JTextField();
	valY.setBounds(20,100,200,20);
	panel.add(valY);
	//Se crea el botòn ordenar para que al hacer click nos vote los numeros ya ordenados de forma creciente
	panel.add(etiqueta);
	btnOrdenar=new JButton("Ordenar");
	btnOrdenar.setBounds(50,300, 300, 40);
	btnOrdenar.addActionListener(this);
	panel.add(btnOrdenar);

	//Se crea la ventana y se centra la ventana
	setSize(400, 400);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int centerX = (int) screenSize.getWidth() / 2;
	int centerY = (int) screenSize.getHeight() / 2;
	int windowX = centerX - getWidth() / 2;
	int windowY = centerY - getHeight() / 2;
	
	setLocation(windowX, windowY);

}

//Implementaciiòn del mètodo Burbuja
private int[] ordenarArreglo(int[] arr) {
	int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j+1]) {
                // intercambia arr[j] y arr[j+1]
                int aux = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = aux;
            }
        }
    }
    return arr;
}
//Permitirà ejecutar el programa y mostrar la ventana
public static void main(String[] args) {
	new Ventana();
}

	@Override
public void actionPerformed(ActionEvent e) {
//Aqui se reciben los eventos del mouse o del teclado
		
	    if (e.getSource() == btnOrdenar) {
	        int n = Integer.parseInt(valX.getText());
	        int[] arr = new int[n];
	        //Cada numero ingresado debera estar seguido de un guion
	        String[] numeros = valY.getText().split("-");
	        for (int i = 0; i < n; i++) {
	            arr[i] = Integer.parseInt(numeros[i]);
	        }
	        arr = ordenarArreglo(arr);
	        String mensaje = "El arreglo ordenado es:\n";
	        for (int i = 0; i < n; i++) {
	            mensaje += arr[i] + " ";
	        }
	        JOptionPane.showMessageDialog(null, mensaje, "Arreglo ordenado", JOptionPane.INFORMATION_MESSAGE);
	    }
	}




}