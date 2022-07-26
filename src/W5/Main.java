package W5;
import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class Main extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	
	float contador = 0;
	
	static final int MAX = 50;
	float x = 0;
	float y = 0;
	Random random = new Random();
	private int[] dir = {-1,1};
	Color color[] = {Color.blue,Color.black,Color.red};
	Graphics g2;
	Particulas[] particulas = new Particulas[MAX];
	
	public class Arvore{
		
		
		Arvore noroeste;//1
		Arvore nordeste;//2
		Arvore sudoeste;//3
		Arvore sudeste;//4
		
		
	}
	
	
	public Main()
	{
		
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		g2 = super.getGraphics();
		
		particulas = new Particulas[MAX];
		for(int i = 0; i < MAX; i++ )
		{
			Color c = color[random.nextInt(0,3)];
			int d = dir[random.nextInt(0,2)];
			int d2 = dir[random.nextInt(0,2)];
			particulas[i] = new Particulas(g2,new Rectangle.Float(random.nextFloat(60f,getSize().width - 60f),random.nextFloat(60f,getSize().height -60f),10,10),c,this,new Point(1,1),new Point(d,d2));
		}
		
		
		Start();
	}
	
	
	public static void main(String[] args) {
		
		
		
		Main m = new Main();
		
		
		
	}
	
	public void paint(Graphics g)
	{
		
	}
	
	public void Render() {
		
		if(contador > 1f)
		{
			particulas[0].Limpa();
			contador = 0;
		}
		
		for(int i = 0; i < MAX; i++ )
		{
			//particulas[i].Desenha();
		}
		
		
	}
	
	public void Update(float deltaTime) {
		
		for(int i = 0; i < MAX; i++ )
		{
			particulas[i].Update(deltaTime);
			particulas[i].CollisionBorder();
		}
		
		for(int i = 0; i < MAX; i++ )
		{
			for(int j = 0; j < MAX; j++ )
			{
				if(particulas[i].Collision(particulas[i].rect, particulas[j].rect) == true)
				{
					
					particulas[i].DistanciaX();
					particulas[i].DistanciaY();
					
					particulas[j].DistanciaX();
					particulas[j].DistanciaY();
					
					particulas[i].InvertDirection(particulas[i].dir);
					particulas[j].InvertDirection(particulas[j].dir);
					break;
				}
				
			}
		}
		contador += 10f * deltaTime;
		
	}

	public void Start() {
		
		float deltaTime = 0;
		
		
		
		while(true)
		{
			long start = System.currentTimeMillis();
			
			Update(deltaTime);
			Render();
			
			long end = System.currentTimeMillis();
			
			deltaTime = (float)(end - start)/ 1000.0f;
			
		}
		
		
		
		
		
		
	}


}
