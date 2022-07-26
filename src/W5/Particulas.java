package W5;
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class Particulas {
	
	private float x;
	private float y;
	public Point dir = new Point();
	
	private Point size;
	private Color color;
	
	private Rectangle.Float rect;
	private Graphics g;
	
	private Main main;
	
	public Particulas(Graphics g, Rectangle.Float rect, Color color, Main main, Point size, Point dir)
	{
		
		this.g = g;
		this.rect = rect;
		this.color = color;
		this.main = main;
		this.size = size;
		this.dir = dir;
		
		this.x = rect.x;
		this.y = rect.y;
		
		g.drawImage(null, (int)rect.x,(int)rect.y, (int)rect.height, (int)rect.width,null);
		Desenha();
		
		
	}
	
	public void Desenha()
	{
		g.clearRect(0, 0, main.getSize().height, main.getSize().width);
		this.rect.x = this.x;
		this.rect.y = this.y;
		this.rect.width *= size.x;
		this.rect.height *= size.y;
		g.setColor(this.color);
		g.fillRect((int)rect.x,(int)rect.y, (int)rect.height, (int)rect.width);
		
	}
	
	public void SetDirection(Point dir)
	{
		this.dir = dir;
	}
	public void Update(float deltaTime)
	{
		
		this.x += 10f * deltaTime * this.dir.x;
		this.y += 10f * deltaTime * this.dir.y;
		
	}
	
	
	public boolean Collision(Rectangle rect,Rectangle[] rect2 )
	{
		for(int i = 0; i< rect2.length; i++)
		{
			if(rect != rect2[i])
			{
				if(rect.intersects(rect2[i]))
				{
					return true;
				}else 
				{
					return false;
				}
			}
		}
		return false;
	}

}
