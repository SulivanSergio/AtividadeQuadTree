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
	
	Arvore arvore;
	int profundidade = 0;
	
	public Main()
	{
		
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		g2 = super.getGraphics();
		g2.clearRect(0, 0, 500, 500);
		particulas = new Particulas[MAX];
		/*
		for(int i = 0; i < MAX; i++ )
		{
			Color c = color[random.nextInt(0,3)];
			int d = dir[random.nextInt(0,2)];
			int d2 = dir[random.nextInt(0,2)];
			particulas[i] = new Particulas(g2,new Rectangle.Float(random.nextFloat(60f,getSize().width - 60f),random.nextFloat(60f,getSize().height -60f),10,10),c,this,new Point(1,1),new Point(d,d2));
		}
		*/
		
		for(int i = 0; i < 3; i++)
		{
			System.out.println("Criando a arvore");
			if(profundidade == 0)
			{
				arvore = Inserir(arvore,i,1);
			}
			else {
				for(int j = 1; j < 5; j++)
				{
					
					arvore = Inserir(arvore,j,i);
					//g2.fillRect(50, 50, 50, 50);
				}
			}
		}
		
		
		Start();
	}
	
	
	public static void main(String[] args) {
		
		
		
		Main m = new Main();
		
		
		
		
	}
	
	
	public Arvore Inserir(Arvore arvore,int item, int id)
	{
		
		if(arvore == null)
		{
			profundidade = id;
			
			Arvore aux = new Arvore();
			aux.item = item;
			aux.rect = new Rectangle(0,0,0,0);
			//g2.clearRect(0, 0, getSize().height,getSize().width);
			//g2.fillRect(aux.rect.x, aux.rect.y, aux.rect.width, aux.rect.height);
			aux.noroeste = null;
			aux.nordeste = null;
			aux.sudoeste = null;
			aux.sudeste = null;
			
			
			aux.rect.width = getSize().width;
			aux.rect.height = getSize().height;
			aux.rect.x = 0;
			aux.rect.y = 0;
		
			for(int i = 0; i < profundidade; i++) {
				
				if(item == 1)
				{
					aux.rect.width /= 2;
					aux.rect.height /=2;
					aux.rect.x = 0;
					aux.rect.y = 0;
				}
				
				if(item == 2)
				{
					
					if(aux.rect.x == 0 && aux.rect.y == 0)
					{
						aux.rect.x = aux.rect.width/2;
						aux.rect.y = 0;
						
						aux.rect.height /= 2;
						
					}else {
						aux.rect.x += aux.rect.x / 2;
						aux.rect.y = 0;
						aux.rect.width /= 2;
						aux.rect.height /= 2;
					}
					
				}
				if(item == 3)
				{
					if(aux.rect.x == 0 && aux.rect.y == 0)
					{
						aux.rect.x = 0;
						aux.rect.y = aux.rect.height/2;
						aux.rect.width /= 2;
						
						
					}else {
						aux.rect.y /= 2;
						aux.rect.width /= 2;
						aux.rect.height /= 2;
					}
					
				}
				
				if(item == 4)
				{
					if(aux.rect.x == 0 && aux.rect.y == 0)
					{
						aux.rect.x = aux.rect.width;
						aux.rect.y = aux.rect.height;
						aux.rect.width /= 2;
						aux.rect.height /= 2;
						
					}else {
						aux.rect.x += aux.rect.x /2;
						aux.rect.y += aux.rect.y /2;
						aux.rect.width /= 2;
						aux.rect.height /= 2;
					}
					
				}
				
				System.out.println("Criou rect do item: " + item+ " X: " + aux.rect.x + " Y: " + aux.rect.y + " width: " + aux.rect.width + " height: " + aux.rect.height + "Profundidade: " + profundidade);
				
				g2.drawRect(aux.rect.x, aux.rect.y, aux.rect.width, aux.rect.height);
			}
			
			
			return aux;
		}
		else
		{
			
			if(item == 1)
			{
				arvore.noroeste = Inserir(arvore.noroeste,1,id);
				System.out.println("Criou a noroeste");
			}
			if(item == 2)
			{
				arvore.nordeste = Inserir(arvore.nordeste,2,id);
				System.out.println("Criou a nordeste");
			}
			if(item == 3)
			{
				arvore.sudoeste = Inserir(arvore.sudoeste,3,id);
				System.out.println("Criou a sudoeste");
			}
			if(item == 4)
			{
				arvore.sudeste = Inserir(arvore.sudeste,4,id);
				System.out.println("Criou a sudeste");
			}
			
		}
		
		return arvore;
	}
	
	public void paint(Graphics g)
	{
		
	}
	
	public void Render() {
		/*
		if(contador > 1f)
		{
			particulas[0].Limpa();
			contador = 0;
		}
		
		for(int i = 0; i < MAX; i++ )
		{
			particulas[i].Desenha();
		}
		*/
		
	}
	
	public void Update(float deltaTime) {
		
		
		
		
		/*
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
					break;//tirar o break
				}
				
			}
		}
		contador += 10f * deltaTime;
		*/
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
