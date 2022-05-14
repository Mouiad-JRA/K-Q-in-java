import javafx.beans.property.SimpleIntegerProperty;

public class Graytable
{
	
	SimpleIntegerProperty x1,x2,x3,x4,x5;
	
	public void setX1(int x1)
	{
		this.x1 = new SimpleIntegerProperty(x1);
	}
	
	public int getX1()
	{
		return x1.getValue();
	}
	
	public void setX2(Integer x2)
	{
		this.x2 = new SimpleIntegerProperty( x2 );
	}
	
	public Integer getX2()
	{
		return x2.getValue();
	}
	
	public void setX3(Integer x3)
	{
		this.x3 = new SimpleIntegerProperty(x3);
	}
	
	public Integer getX3()
	{
		return x3.getValue();
	}
	
	public void setX4(Integer x4) 
	{
		this.x4 = new SimpleIntegerProperty(x4);
	}
	
	public Integer getX4() 
	{
		return x4.getValue();
	}
	
	public void setX5(Integer x5) 
	{
		this.x5 = new SimpleIntegerProperty(x5);
	}
	
	public Integer getX5()
	{
		return x5.getValue();
	}

	public Graytable( String s , int a )
	{
		if (a==2)
		{
		x1 = new SimpleIntegerProperty( s.charAt( 0) - 48 );
		x2 = new SimpleIntegerProperty( s.charAt( 1) - 48 );
		x3 = new SimpleIntegerProperty(0);
		x4 = new SimpleIntegerProperty(0);
		x5 = new SimpleIntegerProperty(0);
		}
		else if(a==3)
		{
			x1 = new SimpleIntegerProperty( s.charAt( 0) - 48 );
			x2 = new SimpleIntegerProperty( s.charAt( 1) - 48 );
			x3 = new SimpleIntegerProperty(s.charAt( 2) - 48);
			x4 = new SimpleIntegerProperty(0);
			x5 = new SimpleIntegerProperty(0);
		}
		else if(a==4) 
		{
			x1 = new SimpleIntegerProperty( s.charAt( 0) - 48 );
			x2 = new SimpleIntegerProperty( s.charAt( 1) - 48 );
			x3 = new SimpleIntegerProperty(s.charAt( 2) - 48);
			x4 = new SimpleIntegerProperty(s.charAt(3)-48);
			x5 = new SimpleIntegerProperty(0);
		}
		
	}

	 
}
