import java.util.*;
class chainreaction
{
public static void main(String at[])throws Exception
{
//welcome screen

for(int th=1;th<=18;th++)
{
System.out.println(" ");
}
System.out.println("       ");
Thread.sleep(76);
System.out.println("       #              #  ######  #       ###### ###### ##     ##  ######  ");
Thread.sleep(76);                     
System.out.println("        #            #   #       #       #      #    # #  # #  #  #       ");
Thread.sleep(76);
System.out.println("         #    #     #    ####    #       #      #    # #   #   #  ####    ");
Thread.sleep(76);
System.out.println("          #  #  #  #     #       #       #      #    # #       #  #       ");
Thread.sleep(76);             
System.out.println("           #      #      ######  ####### ###### ###### #       #  ######  ");
Thread.sleep(76);
System.out.println("       ");

Thread.sleep(400);
for(int ij=1;ij<=10;ij++)
{
Thread.sleep(100);
System.out.println(" ");     
System.out.println();
if(ij==5)
System.out.println("                                       TO");
System.out.println();    
Thread.sleep(80);
}
Thread.sleep(100);
System.out.println("               __ _        ___        _   __       __ _ _ ___ ___     ");
System.out.println("              |   |_|  /\\   |  |\\ |  |_| |_   /\\  |    |   |  | | |\\ | ");
System.out.println("              |__ | | /  \\ _|_ | \\|  |\\  |__ /  \\ |__  |  _|_ |_| | \\| ");
Thread.sleep(800);
for(int ij=1;ij<=8;ij++)
{
System.out.println(" ");
Thread.sleep(75);
}
System.out.println("                        ALL SET TO EXPLODE<<<<<<<<<"+"\n");
Thread.sleep(1000);
System.out.println(" ");
for(int ij=1;ij<=8;ij++)
{
System.out.println(" ");
Thread.sleep(75);
}
Thread.sleep(400);

System.out.println("Rules And Regulations--");
System.out.println("1. There are two bombs red and green and you have to choose any one of them.");
System.out.println("2. You can choose the grid size and have to enter position where you want your bomb to be placed.");
System.out.println("3. At corners if there are two bombs of same colour they explode to adjacent sides.");
System.out.println("4. Bombs in the corners explode in 3 grids and other sides they explode in 4 grids.");
System.out.println("5. You cannot put bombs on the grids already having opponent's bombs.");
System.out.println("6. If you have all kinds of colour bombs in the grid you win!!!!");
System.out.println();
System.out.println("Game Loading  ");
System.out.println();
for(int m1=1;m1<15;m1++)
{
Thread.sleep(400);
System.out.print("*"+" ");
}
System.out.println();
System.out.println("Game running");
Thread.sleep(800);
Scanner sc=new Scanner(System.in);
int n,slic;
char c3=' ';
System.out.println("Enter dimension of the square grid");
n=sc.nextInt();
String ar[][]=new String[n][n];
for(int y=0;y<n;y++)
{
for(int h=0;h<n;h++)
ar[y][h]="";
}
int st[][]=new int[n][n];
int a[][]=new int[n][n];
int c=1;
slic=0;
try
{
while(true)
{
slic++;
print(ar);
if(c%2==0)
System.out.println("Green's Chance: Enter bomb position");
else
System.out.println("Red's Chance: Enter bomb position");
int p1,p2;
p1=sc.nextInt();
p2=sc.nextInt();
if(ar[p1][p2].equals("")==false)
{
if(c%2==0 && ar[p1][p2].charAt(0)=='R')
continue;
if(c%2!=0 && ar[p1][p2].charAt(0)=='G')
continue;
}
if(c%2!=0)
ar[p1][p2]=ar[p1][p2]+"R";
else
ar[p1][p2]=ar[p1][p2]+"G";
a[p1][p2]++;
if(c%2==0)
c3='G';
else
c3='R';
int co=1;
boolean b=false;
while(true)
{
b=false;
ab:for(int w=0;w<n;w++)
{
for(int e=0;e<n;e++)
{
p1=w;p2=e;
if((p1==0 || p1==n-1) && (p2==0 || p2==n-1) && ar[p1][p2].length()>1)
{
b=true;
st[p1][p2]=1;
}
else if(((p1==0 || p2==0) || (p1==n-1 || p2==n-1)) && ar[p1][p2].length()>2)
{
b=true;
st[p1][p2]=1;
}
else if(ar[p1][p2].length()>3)
{
b=true;
st[p1][p2]=1;
}
}
}
for(p1=0;p1<n;p1++)
{
for(p2=0;p2<n;p2++)
{
if(st[p1][p2]==1)
{
if(p1-1>=0 )
ar[p1-1][p2]=change(ar[p1-1][p2],c3);
if(p2+1<n)
ar[p1][p2+1]=change(ar[p1][p2+1],c3);
if(p1+1<n )
ar[p1+1][p2]=change(ar[p1+1][p2],c3);
if(p2-1>=0)
ar[p1][p2-1]=change(ar[p1][p2-1],c3);
ar[p1][p2]="";
}
}
}
st=new int[n][n];
if(b==false || slic>(n*100))
break;
}
int cog=0,cor=0;
for(int y=0;y<n;y++)
{
for(int h=0;h<n;h++)
{
if(  ar[y][h]!="" && ar[y][h].charAt(0)=='G' )
cog++;
if(ar[y][h]!="" && ar[y][h].charAt(0)=='R')
cor++;
}
}
if(cog==0 && c!=1){
System.out.println("Red wins!!!");
print(ar);
break;
}
if(cor==0) {
System.out.println("Green Wins!!!");
print(ar);
break;
}
c++;
}
}
catch(Exception T)
{
System.out.println("Game terminated because of invalid input");
System.exit(0);
}
}
static String change(String a,char c)
{
String m="";
for(int x=0;x<a.length()+1;x++)
m=m+c;
return m;
}
static void print(String ar[][])throws Exception
{
for(int y=0;y<ar.length;y++)
{
for(int h=0;h<ar[0].length;h++)
{
Thread.sleep(5);
if(ar[y][h]=="")
System.out.printf("%5s","!");
else
System.out.printf("%5s",ar[y][h]);
}
System.out.println();
}
}                      //End of main method
}                      //End of class




                   

