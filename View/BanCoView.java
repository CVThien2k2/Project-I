package View;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.OCO;

public class BanCoView extends JFrame {
	private static final int N = 7;
	private static final int M = 7;
	private Image imgX;
	private Image imgO;
	private OCO [][] matrix = new OCO[N][M];
	private String CT = "O";
	Image img ;
	private OCO ClickEnd;
	public BanCoView() {
		for( int i = 0;i< N; i++) {
			for ( int j = 0;j< M; j++) {
				OCO oco = new OCO();
				matrix[i][j] = oco;
			}
		}
		init();
		
		addMouseListener(new MouseListener() {
			
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				 int x = e.getX();
				 int y = e.getY();
				 int i = x/100;
				 int j = y/100;
				 ClickEnd = matrix[i][j];
				 if(matrix[i][j].getValue()==""&&CT.equals("O")) {
				 matrix[i][j].setValue("X");
				 CT = "X";
				 }
				 else if(matrix[i][j].getValue()==""&&CT.equals("X")){
				 matrix[i][j].setValue("O");
				 CT = "O";
				 }
				 repaint();
			  
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		try {
			imgO = ImageIO.read(getClass().getResource("O.png"));
			imgX = ImageIO.read(getClass().getResource("X.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void init() {
		this.setSize(700,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
@Override
public void paint(Graphics g) {
	int W = getWidth()/M;
	int H = getHeight()/N;
	int count = 0;
	for(int i = 0; i < N ;i++) {
		
		for (int j = 0; j< M ; j++) {
			OCO oco = matrix[i][j];
			oco.setW(W);
			oco.setH(H);
			oco.setX(i);
			oco.setY(j);
			if(count % 2 == 0) {
				g.setColor(Color.white);
			}
			else
			{
				g.setColor(Color.GREEN);
			}
			g.fillRect(W*i,H*j,W,H);
			count ++;
			if(oco.getValue().equals("X")){
				g.drawImage(imgX,i*W,j*H, W, H, this);
			}
			else if(oco.getValue().equals("O"))
				g.drawImage(imgO,i*W,j*H, W, H, this);
			
		}
		
	
	 }
	}
}
