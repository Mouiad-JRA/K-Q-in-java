import java.util.ArrayList;

import javafx.scene.control.TextField;

public class Sovle {

	static String[][] map = new String[4][4];
	static int Rows;
	static int Colmun;
	static boolean check;
	static String Y="";
	static TextField txt;
	static boolean vis[][] = new boolean[ 4 ][ 4 ];
	static ArrayList<Integer> choosenRow = new ArrayList<>();
	static ArrayList<Integer> choosenCol = new ArrayList<>();
	
	public static void solve( int numofVar ) {
		init();
		switch( numofVar ) {
		case 2: Kmap2(); break;
		case 3: Kmap3(); break;
		case 4: Kmap4();break;
		}
	}
	
	private static void Kmap2() {
		txt.setText("Y = ");
		check = true;
		for (int i = 0; i < Rows; ++i) {
			for (int j = 0; j < Colmun; ++j) {
				if (map[i][j].equals( "0" )  || (map[i][j].equals( "X" ) )) {
					check = false;
					break;
				}
			}
			if (!check)
				break;
		}
		if ( check ) {
			txt.appendText("1");
			return;
		}
		
		// checking all combinations of groups of 2
		
					//HORIZONTAL
					
      if(map[0][0] .equals( "1" )&& map[0][1].equals( "1" )) 
	  {
    	  if ( (map[1][0].equals( "0" ) || map[1][0].equals( "X" ) ) && (map[1][1].equals( "0" ) || map[1][1].equals( "X" ) ) ) 
    	  	{
		  Y="B'";
    	  	}
	  }
	  else if(map[1][0] .equals( "1" )&& map[1][1].equals( "1" )) 
    	  {
		  if ( (map[0][0].equals( "0" ) || map[0][0].equals( "X" ) ) && (map[0][1].equals( "0" ) || map[0][1].equals( "X" ) ) )
		  		{
			  Y="B";
		  		}
    	  }
      
    //VERTICAL
      
      if(map[0][0] .equals( "1" )&& map[1][0].equals( "1" )) 
    	  {
    	  if ( (map[0][1].equals( "0" ) || map[0][1].equals( "X" ) ) && (map[1][1].equals( "0" ) || map[1][1].equals( "X" ) ) ) 
    	  		{
    		  Y="A'";
    	       }
    	  }
      
    	  else if(map[0][1] .equals( "1" )&& map[1][1].equals( "1" )) 
        	  {
    		  if ( (map[0][0].equals( "0" ) || map[0][0].equals( "X" ) ) && (map[1][0].equals( "0" ) || map[1][0].equals( "X" ) ) ) {
    		  	
        		  Y="A";
    		  		}
        	  }
      
      //Check for diameter
      
      if(map[0][0] .equals( "1" )&& map[1][1].equals( "1" )) 
	  {
	  if ( (map[0][1].equals( "0" ) || map[0][1].equals( "X" ) ) && (map[1][0].equals( "0" ) || map[1][0].equals( "X" ) ) ) 
	  		{
		  Y="A'B'+AB";
	       }
	  }
  
	  else if(map[0][1] .equals( "1" )&& map[1][0].equals( "1" )) 
    	  {
		  if ( (map[0][0].equals( "0" ) || map[0][0].equals( "X" ) ) && (map[1][1].equals( "0" ) || map[1][1].equals( "X" ) ) ) {
		  	
    		  Y="AB'+A'B";
		  		}
    	  }
      String a[]=new String[4];
     
    	  a[0]=map[0][0];
    	  a[1]=map[0][1];
    	  a[2]=map[1][0];
    	  a[3]=map[1][1];
    	  
    	// checking if single points are left out
    	  
      if (a[0].equals( "1" )&& !a[1].equals( "1" )&& !a[2].equals( "1" ) &&!a[3].equals( "1" ) )
    	  
    			  Y="A'B'";
      
      else if (a[1].equals( "1" ) && !a[0].equals( "1" )&& !a[2].equals( "1" ) &&!a[3].equals( "1" ) )
    	  
			  Y="AB'";
      
      else if (a[2].equals( "1" ) && !a[0].equals( "1" )&& !a[1].equals( "1" ) &&!a[3].equals( "1" ) )
    	  
			  Y="A'B";
      
      else if (a[3].equals( "1" )&& !a[0].equals( "1" )&& !a[1].equals( "1" ) &&!a[2].equals( "1" ) )
	 
			  Y="AB";
      
   
      
   // checking if There are three Point
      
      if ( (a[0].equals( "0" ) || a[0].equals( "X" ) ) && a[1].equals( "1" )&& a[2].equals( "1" ) && a[3].equals( "1" ) )
    	  Y="A+B";
      
      else if ( (a[1].equals( "0" ) || a[1].equals( "X" ) ) && a[0].equals( "1" )&& a[2].equals( "1" ) && a[3].equals( "1" ) )
    	  Y="A'+B";
      
      else if ( (a[2].equals( "0" ) || a[2].equals( "X" ) ) && a[1].equals( "1" )&& a[0].equals( "1" ) && a[3].equals( "1" ) )
    	  Y="A+B'";
      
      else if ( (a[3].equals( "0" ) || a[3].equals( "X" ) ) && a[1].equals( "1" )&& a[2].equals( "1" ) && a[0].equals( "1" ) )
    	  Y="A'+B'";
    
  	txt.appendText(Y);
  	Y="";
  
	  }
	
	private  static void Kmap3() {
		txt.setText("Y = ");
		
		// groups of 8
		check = true;
		for (int i = 0; i < Rows; ++i) {
			for (int j = 0; j < Colmun; ++j) {
				//initVis();
				if (map[i][j].equals( "0" )  || (map[i][j].equals( "X" ) ) ) {
					check = false;
					break;
				}
			}
			if (!check)
				break;
		}
		if ( check ) {
			txt.appendText("1");
			return;
		}
		
		// groups of 4

		// 2x2 groups
		for ( int j = 0; j < 4; ++j ) {
			if ( map[ 0 ][ j ].equals( "1" ) && map[ 0 ][ ( j + 1 ) % 4 ].equals( "1" ) && map[ 1 ][ j ].equals( "1" ) && map[ 1 ][ ( j + 1 ) % 4 ].equals("1" ) && !vis[ 0 ][ j ] && !vis[ 0 ][ ( j + 1 ) % 4 ] && !vis[ 1 ][ j ] && vis[ 1 ][ ( j + 1 ) % 4 ] ) {
				choosenRow.add( 0 ); choosenCol.add( j );
				choosenRow.add( 0 ); choosenCol.add( ( j + 1 ) % 4 );
				choosenRow.add( 1 ); choosenCol.add( j );
				choosenRow.add( 1 ); choosenCol.add( ( j + 1 ) % 4 );
				
				Y += ( j % 2 == 0 ? "B" : "A" );
				if ( j == 0 || j == 3 )
					Y += "'";
				Y += "+";
			}
		}
		
		// 1x4 groups
		for ( int i = 0; i < 2; ++i ) {
			if ( map[ i ][ 0 ].equals( "1" ) && map[ i][ 1 ].equals( "1" ) && map[ i ][ 2 ].equals( "1" ) && map[ i ][ 3 ].equals( "1" ) && !vis[ i ][ 0 ] && !vis[ i ][ 1 ] && !vis[ i ][ 2 ] && !vis[ i ][ 3 ] ) {
				choosenRow.add( i ); choosenCol.add( 0 );
				choosenRow.add( i ); choosenCol.add( 1 );
				choosenRow.add( i ); choosenCol.add( 2 );
				choosenRow.add( i ); choosenCol.add( 3 );
				Y += "C";
				if ( i == 0 )
					Y += "'";
				Y += "+";
			}
		}
		mark(); // Zuckberg hhhhh :)
		
		// Groups of 2
		//HORIZONTAL
		for(int i=0;i<2;i++){
			for(int j=0;j<4;j++){
				if (map[i][j].equals("1") && map [i][(j+1)%4].equals("1") && !vis[i][j] && !vis[i][(j+1)%4]) {
					choosenRow.add( i ); choosenCol.add( j );
					choosenRow.add( i ); choosenCol.add( ((j+1)%4) );

					Y += ( j % 2 == 0 ? "B" : "A" );
					if( j==0 || j==3 )
						Y += "'";
					
					Y += "C";
					if( i == 0 )
						Y += "'";
					Y += "+";
				}
			}
		}
		
		//VERTICAL
		for(int j=0;j<4;j++){
			if(map[0][j].equals("1") && map[1][j].equals("1") && !vis[0][j] && !vis[1][j]){
				choosenRow.add( 0); choosenCol.add( j);
				choosenRow.add( 1); choosenCol.add( j );
				Y += "A";
				if(j==0 || j==3)
					Y += "'";
				Y += "B";
				if(j==0 || j==1)
					Y += "'";
				Y += "+";
			}
		}
		mark();
		
		// checking for single points 
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Colmun;j++)
			{
				if(map[i][j].equals("1") && !vis[i][j])
				{
					if ( map[(i+1)%2][j].equals("1") ){ // Up or Down (Vertical)
						choosenRow.add( i); choosenCol.add( j);
						Y += "A";
						if(j==0 || j==3)
							Y += "'";
						Y += "B";
						if(j==0 || j==1)
							Y += "'";
						Y += "+";
					}
					
					else if ( map[ i ][ ( j + 1 ) % 2 ].equals( "1" ) || map[ i ][ ( j + 3 ) % 4 ].equals( "1" ) ) { // Right
						choosenRow.add( i); choosenCol.add( j);
						Y += ( j % 2 == 0 ? "B" : "A" );
						if( j==0 || j==3 )
							Y += "'";
						
						Y += "C";
						if( i == 0 )
							Y += "'";
						Y += "+";
					}
					
					
				}
			}
		}
		mark();
		// If still single points could not group to anyone
		for(int i=0;i<Rows;i++)
		{
			for(int j=0;j<Colmun;j++)
			{
				if(map[i][j] .equals("1")&& !vis[i][j]){
					choosenRow.add( i); choosenCol.add( j);
					Y += "A";
					if(j==0 || j==3)
						Y += "'";
					Y += "B";
					if(j==0 || j==1)
						Y += "'";
					Y += "C";
					if(i==0)
						Y += "'";
					Y += "+";
				}
			}
		}
		mark();
		if ( Y != "" && Y.charAt( Y.length() - 1 ) == '+' )
			Y = Y.substring(0, Y.length() - 1);
		txt.appendText(Y);
		Y = "";
	}
	
	private static void Kmap4() {
		txt.setText("Y = ");
		check = true;
		for (int i = 0; i < Rows; ++i) {
			for (int j = 0; j < Colmun; ++j) {
				if (map[i][j].equals( "0" )  || (map[i][j].equals( "X" ) )) {
					check = false;
					break;
				}
			}
			if (!check)
				break;
		}
		if ( check ) {
			txt.appendText("1");
			return;
		}
		
		// checking  groups of 8
		
			//HORIZONTAL
		
		for(int j=0;j<4;j++)
		{ 
		  if ( map[0][j].equals("1")&& map[1][(j+1)%4].equals("1") && map[1][(j+1)%4].equals("1") && map[2][j].equals("1")  && map[2][(j+1)%4].equals("1")  && map[3][j].equals("1") 
			  && map[3][(j+1)%4].equals("1") && !vis[0][j] && !vis[0][(j+1)%4] && !vis[1][j] && !vis[1][(j+1)%4] && !vis[2][j]  && !vis[2][(j+1)%4]  && !vis[3][j] && !vis[3][(j+1)%4] ) {
			  choosenRow.add( 0 ); choosenCol.add( j );
			  choosenRow.add( 0 ); choosenCol.add( (j+1)%4 );
			  choosenRow.add( 1 ); choosenCol.add( j );
			  choosenRow.add( 1 ); choosenCol.add( (j+1)%4 );
			  choosenRow.add( 2 ); choosenCol.add( j );
			  choosenRow.add( 2 ); choosenCol.add( (j+1)%4 );
			  choosenRow.add( 3 ); choosenCol.add( j );
			  choosenRow.add( 3 ); choosenCol.add( (j+1)%4 );
			  if(j%2!=0)
				  Y += "A";
				else
					Y += "B";
				if(j==0 || j==3)
					Y += "'";
				Y += "+";
			  
		  }
		}
		
		//VERTICAL
		for(int i=0;i<4;i++){
			if( map[i][0].equals("1") && map[i][1].equals("1") && map[i][2].equals("1") && map[i][3].equals("1")&& map[(i+1)%4][0].equals("1") && map[(i+1)%4][1].equals("1") && map[(i+1)%4][2].equals("1") 
				&& map[(i+1)%4][3].equals("1") && !vis[i][0] && !vis[i][1] && !vis[i][2] && !vis[i][3] && !vis[(i+1)%4][0] && !vis[(i+1)%4][1] && !vis[(i+1)%4][2] && !vis[(i+1)%4][3] ){
				  choosenRow.add( i ); choosenCol.add( 0 );
				  choosenRow.add( i ); choosenCol.add( 1 );
				  choosenRow.add( i ); choosenCol.add( 2 );
				  choosenRow.add( i ); choosenCol.add( 3 );
				  choosenRow.add( (i+1)%4 ); choosenCol.add( 0 );
				  choosenRow.add( (i+1)%4 ); choosenCol.add( 1 );
				  choosenRow.add( (i+1)%4 ); choosenCol.add( 2 );
				  choosenRow.add( (i+1)%4 ); choosenCol.add( 3 );
				if(i%2!=0)
					 Y += "C";
				else
					 Y += "D";
				if(i==0 || i==3)
					 Y += "'";
				 Y += "+";
			}
		}
		mark();
		
		// checking  groups of 4
		//squers	
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				if( map[i][j].equals("1") && map[(i+1)%4][j].equals("1") && map[i][(j+1)%4].equals("1") && map[(i+1)%4][(j+1)%4].equals("1") && !vis[i][j] && !vis[(i+1)%4][j] && !vis[i][(j+1)%4]
						&& !vis[(i+1)%4][(j+1)%4] )
				{
					 
					  choosenRow.add( i ); 		 choosenCol.add( j );
					  choosenRow.add( (i+1)%4 ); choosenCol.add( j );
					  choosenRow.add( i ); 		 choosenCol.add( (j+1)%4 );
					  choosenRow.add( (i+1)%4 ); choosenCol.add((j+1)%4);
					  System.out.println("momo1");
					  if(j%2!=0)
							Y += "A";
						else
							Y += "B";
						if(j==0 || j==3)
							Y += "'";
					if(i%2!=0)
						 Y += "C";
					else
						 Y += "D";
					if(i==0 || i==3)
						 Y += "'";
					Y += "+";
				}
			}
		}
		
		//HORIZONTAL
		
		for(int i=0;i<4;i++){
			if(map[i][0].equals("1") && map[i][1].equals("1") && map[i][2].equals("1") && map[i][3].equals("1") && !vis[i][0] && !vis[i][1] && !vis[i][2] && !vis[i][3]){
				  choosenRow.add( i ); choosenCol.add(0);
				  choosenRow.add( i ); choosenCol.add(1);
				  choosenRow.add( i ); choosenCol.add(2);
				  choosenRow.add( i ); choosenCol.add(3);
				  System.out.println("momo");
				Y += "C";
				if(i==0 || i==3)
					Y += "'";
				Y += "D";
				if(i==0 || i==1)
					Y += "'";
				Y += "+";
			}
		}
		
		//VERTICAL
		for(int j=0;j<4;j++){
			if(map[0][j].equals("1") && map[1][j].equals("1") && map[2][j].equals("1") && map[3][j].equals("1") && !vis[0][j] && !vis[1][j] && !vis[2][j] && !vis[3][j]){
				  choosenRow.add( 0 ); choosenCol.add(j);
				  choosenRow.add( 1 ); choosenCol.add(j);
				  choosenRow.add( 2 ); choosenCol.add(j);
				  choosenRow.add( 3 ); choosenCol.add(j);
				  System.out.println("mhm");
				  Y += "A";
					if(j==0 || j==3)
						Y += "'";
					Y += "B";
					if(j==0 || j==1)
						Y += "'";
					Y += "+";
			}
		}
		mark();
		
		// checking  groups of 2
					//HORIZONTAL
					for(int i=0;i<4;i++){
						for(int j=0;j<4;j++){
							if(map[i][j].equals("1") && map[i][(j+1)%4].equals("1") && !vis[i][j] && !vis[i][(j+1)%4]){
								choosenRow.add( i ); choosenCol.add(j);
								choosenRow.add( i ); choosenCol.add((j+1)%4);
								
								if(j%2!=0)
									Y += "A";
								else
									Y += "B";
								if(j==0 || j==3)
									 Y += "'";
								 Y += "C";
								if(i==0 || i==3)
									 Y += "'";
								 Y += "D";
								if(i==0 || i==1)
									 Y += "'";
								 Y += "+";
							}
						}
					}
					
					//VERTICAL
					
					for(int j=0;j<4;j++){
						for(int i=0;i<4;i++){
							if(map[i][j].equals("1") && map[(i+1)%4][j].equals("1") && !vis[i][j] && !vis[(i+1)%4][j]){
								
								choosenRow.add( i ); 	   choosenCol.add(j);
								choosenRow.add( (i+1)%4 ); choosenCol.add(j);
								
								Y += "A";
								if(j==0 || j==3)
									Y += "'";
								Y += "B";
								if(j==0 || j==1)
									Y += "'";
								if(i%2!=0)
									Y += "C";
								else
									Y += "D";
								if(i==0 || i==1)
									Y += "'";
								Y += "+";	
							}
						}
					}
			mark();
			
			// checking for single points 
			
			for(int i=0;i<Rows;i++)
			{
				for(int j=0;j<Colmun;j++)
								if(map[i][j].equals("1") && !vis[i][j]){
									if(map[i][(j+1)%4].equals("1")){
										
										vis[i][j] = true;
										if(j%2!=0)
											Y += "A";
										else
											Y += "B";
										if(j==0 || j==3)
											Y += "'";
										Y += "C";
										if(i==0 || i==3)
											Y += "'";
										Y += "D";
										if(i==0 || i==1)
											Y += "'";	
										Y += "+";	
									}else if(map[i][(j-1+4)%4].equals("1")){
										
										vis[i][j] = true;
										j = (j-1+4)%4;
										if(j%2!=0)
											Y += "A";
										else
											Y += "B";
										if(j==0 || j==3)
											Y += "'";
										Y += "C";
										if(i==0 || i==3)
											Y += "'";
										Y += "D";
										if(i==0 || i==1)
											Y += "'";
										Y += "+";
									}else if(map[(i+1)%4][j].equals("1")){
									
										vis[i][j] = true;
										Y += "A";
										if(j==0 || j==3)
											Y += "'";
										Y += "B";
										if(j==0 || j==1)
											Y += "'";
										if(i%2!=0)
											Y += "C";
										else
											Y += "D";
										if(i==0 || i==3)
											Y += "'";
										Y += "+";
									}else if(map[(i-1+4)%4][j].equals("1")){
										
										vis[i][j] = true;
										i = (i-1+4)%4 ;
										Y += "A";
										if(j==0 || j==3)
											Y += "'";
										Y += "B";
										if(j==0 || j==1)
											Y += "'";
										if(i%2!=0)
											Y += "C";
										else
											Y += "D";
										if(i==0 || i==1)
											Y += "'";
										Y += "+";
									}
									
								}
							}
			mark();
			// cheek single points could not add to any group 
			for(int i=0;i<Rows;i++)
			{
				for(int j=0;j<Colmun;j++)
								if(map[i][j].equals("1") && !vis[i][j]){
									vis[i][j] = true;
									Y += "A";
									if(j==0 || j==3)
										Y += "'";
									Y += "B";
									if(j==0 || j==1)
										Y += "'";
									Y += "C";
									if(i==0 || i==3)
										Y += "'";
									Y += "D";
									if(i==0 || i==1)
										Y += "'";
									Y += "+";
								}
							}
			
						
			mark();
		if ( Y != "" && Y.charAt( Y.length() - 1 ) == '+' )
		Y = Y.substring(0, Y.length() - 1);
		txt.appendText(Y);
		Y = "";
	}
	private static void mark() {
		for ( int i = 0; i < choosenRow.size(); ++i )
			vis[ choosenRow.get( i ) ][ choosenCol.get( i ) ] = true;
	}

	private static void init() {
		for ( int i = 0; i < 4; ++i )
			for ( int j = 0; j < 4; ++j )
				vis[ i ][ j ] = false;
		choosenRow.clear();
		choosenCol.clear();
		
	}
}