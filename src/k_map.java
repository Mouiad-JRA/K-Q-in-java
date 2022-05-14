
import javafx.beans.property.SimpleStringProperty;

public class k_map {
	SimpleStringProperty a1,a2,a3,a4,a5;
	
	public k_map( String a1, int a2, int a3, int a4, int a5 ) {
		this.a1 = new SimpleStringProperty( a1 );
		this.a2 = new SimpleStringProperty( getValue( a2 ) );
		this.a3 = new SimpleStringProperty( getValue( a3 ) );
		this.a4 = new SimpleStringProperty( getValue( a4 ) );
		this.a5 = new SimpleStringProperty( getValue( a5 ) );
	}
	
	private String getValue( int n ) {
		return n == -1 ? "X" : "" + n;
	}
	
	public void setA1(String a1)
	{
		this.a1 = new SimpleStringProperty(a1);
	}
	public String getA1()
	{
		return a1.getValue();
	}
	
	public void setA2(String a2)
	{
		this.a2 = new SimpleStringProperty(a2);
	}
	public String getA2()
	{
		return a2.getValue();
	}
	
	public void set3(String a3)
	{
		this.a3 = new SimpleStringProperty(a3);
	}
	public String getA3()
	{
		return a3.getValue();
	}
	
	public void setA4(String a4)
	{
		this.a4 = new SimpleStringProperty(a4);
	}
	public String getA4()
	{
		return a4.getValue();
	}
	
	public void setA5(String a5)
	{
		this.a5 = new SimpleStringProperty(a5);
	}
	public String getA5()
	{
		return a5.getValue();
	}
	
}
