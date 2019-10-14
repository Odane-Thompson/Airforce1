import java.io.*;

public class ObjectDemo
{
	public static void main(String args[])
	{
	try{
	FileOutputStream FObject=new FileOutputStream("ObjectTest.txt");
	ObjectOutputStream objectoutput=new ObjectOutputStream(FObject);
	TestClass1 t1=new TestClass1(true,9,'A',0.00001,"Java");
	TestClass2 t2=new TestClass2();
	String t3="This is a test";
	objectoutput.writeObject(t1);
	objectoutput.writeObject(t2);
	objectoutput.close();
	FObject.close();
	FileInputStream	FInput=new FileInputStream("ObjectTest.txt");
	ObjectInputStream objectinputstream=new ObjectInputStream(FInput);
	TestClass1 temp1=(TestClass1)objectinputstream.readObject();
	TestClass2 temp2=(TestClass2)objectinputstream.readObject();
	temp1.showData();
	temp2.showData();
	objectinputstream.close();
	FInput.close();
	}
	catch(Exception e){System.out.println(e);}
	}
}

class TestClass1 implements Serializable
{
	boolean b;
	int i;
	char c;
	double d;
	String s;
	TestClass1(boolean b,int i,char c,double d,String s)
	{
		this.b=b;
		this.i=i;
		this.c=c;
		this.d=d;
		this.s=s;
	}
		public void showData()
		{
			String r=String.valueOf(b)  + "     ";
			r+=String.valueOf(i)+"     ";
			r+=String.valueOf(c)+"     ";
			r+=String.valueOf(d)+"     ";
			r+=String.valueOf(s)+"     ";
			r+="\n";
			System.out.println( r);
		}
}

	class TestClass2 implements Serializable
	{
		int i;
		TestClass1 tc1;
		TestClass1   tc2;
		TestClass2()
		{
		i=0;
		tc1=new TestClass1(true,2,'j',1.234,"Java");
		tc2=new TestClass1(false,7,'J',2.468,"JAVA");
		}
		public void showData()
		{
			String r=String.valueOf(i)+"    ";
			//r+=tc1.toString()+"     ";
			//r+=tc2.toString()+"     ";
			//r+="\n";
			tc1.showData();
			tc2.showData();
		}
	}



