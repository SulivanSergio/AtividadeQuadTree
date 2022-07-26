package W5;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.*;

public class Particulas {
	
	private float x;
	private float y;
	public Point dir = new Point();
	
	private Point size;
	private Color color;
	
	public Rectangle.Float rect;
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
	public void Limpa()
	{
		g.clearRect(0, 0, main.getSize().height, main.getSize().width);
	}
	
	public boolean Collision(Rectangle2D rect,Rectangle2D rect2 )
	{
		
		if(rect != rect2)
		{
			if(rect.intersects(rect2))
			{
				return true;
			}else 
			{
				return false;
			}
		}
		
		return false;
	}
	
	public void CollisionBorder()
	{
		
		if(this.x >= main.getSize().width - 50 || this.x <= 50)
		{
			DistanciaX();
			this.dir.x *= -1;
		}
		if(this.y >= main.getSize().height - 50 || this.y <= 50)
		{
			DistanciaY();
			this.dir.y *= -1;
		}
		
		
	}
	
	public void InvertDirection(Point dir)
	{
		this.dir.x *= -1;
		this.dir.y *= -1;
	}
	
	public void DistanciaX()
	{
		if(this.dir.x == 1)
		{
			this.x -= 2;
		}
		else 
		{
			this.x += 2;
		}
	}
	public void DistanciaY()
	{
		if(this.dir.y == 1)
		{
			this.y -= 2;
		}
		else 
		{
			this.y += 2;
		}
	}
	
}
