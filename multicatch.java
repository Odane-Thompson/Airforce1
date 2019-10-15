class multicatch
{
  public static void main(String args[])
  {
    try
    {
	  int a=args.length;
	  System.out.println("Length of a:"+a);
	  int b=42/a;
      int c[]={1};
      c[42]=99;
    }
	catch(ArithmeticException e)
    {
      System.out.println("Divide by Zero");
    }
     catch(ArrayIndexOutOfBoundsException e)
    {
      System.out.println("ArrayIndexOutOfBoundsException");
    }
    System.out.println("After catch statement..");
  }
}

