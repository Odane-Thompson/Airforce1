// Program with caught exception
class basicexception
{
  public static void main(String s[])
  {
    int d,a;
    try
    {
      d = 0;
      a = 42/d;
      System.out.println("This will not be printed..");
    }
    catch(ArithmeticException e)
    {
      System.out.println("Division by zero..");
    }
    System.out.println("After catch statement..");
  }
}

