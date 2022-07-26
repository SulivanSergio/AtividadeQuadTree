package W5;
import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class Main extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	static final int MAX = 10;
	float x = 0;
	float y = 0;
	Random random = new Random();
	private int[] dir = {-1,1};
	Color color[] = {Color.blue,Color.black,Color.red};
	
	Particulas[] particulas = new Particulas[MAX];
	
	
	public Main()
	{
		
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		
		
		particulas = new Particulas[MAX];
		for(int i = 0; i < MAX; i++ )
		{
			Color c = color[random.nextInt(0,3)];
			int d = dir[random.nextInt(0,2)];
			particulas[i] = new Particulas(super.getGraphics(),new Rectangle.Float(250,250,10,10),c,this,new Point(1,1),new Point(d,d));
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
		
		
		for(int i = 0; i < MAX; i++ )
		{
			particulas[i].Desenha();
		}
		
		/*
		g2.clearRect(0, 0, getSize().height, getSize().width);
		//g3.clearRect(0, 0, getSize().height, getSize().width);
		
		g2.fillRect((int)rect.x,(int)rect.y,(int)rect.height,(int)rect.width);
		g2.setColor(Color.red);
		g3.fillRect((int)rect2.x,(int)rect2.y,(int)rect2.height,(int)rect2.width);
		
		rect.x = position;
		rect2.y = position;
		
		if(rect.intersects(rect2))
		{
			g2.setColor(Color.blue);
		}
		System.out.println(position);
		
		*/
	}
	
	public void Update(float deltaTime) {
		
		for(int i = 0; i < MAX; i++ )
		{
			particulas[i].Update(deltaTime);
		}
		
		
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
