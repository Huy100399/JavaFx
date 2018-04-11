package sample;

import java.util.Stack;

public class Funcion {

    public static final double e = Math.E;
    public static final double p=Math.PI;
    public static final String []erro = new String[]{"",".+[\\\\+\\-\\\\*//]{2,}.+", "[\\\\+\\-\\\\*//]{1,}.*", ".*[\\\\+\\-\\\\*//]{1,}"};



    // ham tra ve sinx
    public static double sinx(String x)
    {
        if(x.matches("(sin\\d+\\.*\\d+)||(sin\\d+)"))
        {
            return Math.sin(Math.toRadians(Double.valueOf(x.substring(3)))); // ep kieu double cho substring de chuyen doi sang dang so double
            // sin123 thi substring(3)="123"
        }
        return 0;
    }
    // ham tra ve cosx
    public static double cosx(String x)
    {
        if(x.matches("(cos\\d+\\.*\\d+)||(cos\\d+)"))
        {
            return Math.cos(Math.toRadians(Double.valueOf(x.substring(3))));
        }
        return 0;
    }
    //ham tra ve tanx
    public static double tanx(String x)
    {
        if(x.matches("(tan\\d+\\.*\\d+)||(tan\\d+)"))
        {
            return Math.tan(Math.toRadians(Double.valueOf(x.substring(3))));        }
        return 0;
    }

    //ham tra ve cotx
    public static double cotx(String x)
    {
        if(x.matches("(cot\\d+\\.*\\d+)||(cot\\d+)"))
        {
            return 1./Math.tan(Math.toRadians(Double.valueOf(x.substring(3))));
        }
        return 0;
    }

    // tra ve mang string tu bieu thuc dau vao (infix) cac phan tu cua mang hoac la so , hoac la toan hang hoac la cac ham luong giac
    public static String[] getarrayinfix(String infix)
    {
        String []resulttemp= new String[100];
        int j=0,i=0;
        while(infix.length()>i) {
            char c = infix.charAt(i);
            if (c == '+' || c == '-' || c == '/' || c == '*' || c == '^' || c == '(' || c == ')' || c=='%') {
               // neu c la toan tu thi luu luon lam 1 phan tu cua mang resulttemp
                resulttemp[j] = String.valueOf(c);
                j++;
                i++;
            } else { // neu c k p toan tu thi lay phan so sau tu c luu vao mang resulttemp
                // vd 123+3 , dau tien c=1 l 1 toan hang nen ta chay vong la va lay 123 luu vao lam 1 phan tu cua mang resulttemp
                int k;
                for (k = i; k < infix.length(); k++) {
                    char c1 = infix.charAt(k);
                    if (c1 == '+' || c1 == '-' || c1 == '/' || c1 == '*' || c1 == '^' || c1 == '(' || c1 == ')' || c1=='%') {
                        break;
                    }
                }
                resulttemp[j] = infix.substring(i, k);
                i = k;
                j++;
            }
        }

        int lenght=0,index=0;
        for(String s : resulttemp)
        {
            if(s!=null) lenght++;
        }
        String []result= new String[lenght];

        for(String s : resulttemp)
        {
            if(s!=null) result[index++]=s;
        }
       return result ;
    }

    // ham tra ve muc do uu tien cua cac toan tu
    public  static int getpiority(char c)
    {
        if(c=='+' || c=='-') return 1;
        if(c=='*' || c=='/' || c=='%') return 2;
        if(c=='^') return 3;
        return 0;
    }

    // ham tra ve mang String dai dien cho bieu thuc hau so dc chuyen tu infix , aaoo dung cho nhieu so
    public static String[] getpostifixmultipledigit(String []infix)
    {
        String []result= new String[100];
        Stack<String> stack= new Stack<>();
        int index=0;
        for(int i=0;i<infix.length;i++)
        {
            String s=infix[i];
            if(s.matches("(\\d+\\.*\\d+)||(\\d+)")) // neu s la so thi lau vao lam 1 phan tu cua mang result
            {
                result[index++]=s;
            }
            if(s.equals("(")) stack.push(s); // neu la '(' thi push vao stack
            if(s.matches("(sin((\\d+\\.*\\d+)||(\\d+)))||(cos((\\d+\\.*\\d+)||(\\d+)))||(tan((\\d+\\.*\\d+)||(\\d+)))||(cot((\\d+\\.*\\d+)||(\\d+)))")) result[index++]=s; // neu la cac ham luong giac thi luu vao lam 1 phan tu cua mang result
            if(s.equals(")"))
            {       // neu la ')' thi kiem tra
                    // .....

                   while (stack.isEmpty()==false&&stack.peek().equals("(")==false)
                   {
                       result[index++]=stack.pop();
                   }
                   if(stack.peek().equals("(")) stack.pop();

            }
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("^") || s.equals("%"))
            {
                if(stack.isEmpty()==true) stack.push(s);
                else
                {
                    if(getpiority(s.charAt(0))>getpiority(stack.peek().charAt(0)))
                    {
                        stack.push(s);
                    }
                    else
                    {
                        while(stack.isEmpty()==false&&getpiority(stack.peek().charAt(0))>=getpiority(s.charAt(0)))
                        {
                            result[index++]=stack.pop();
                        }
                        stack.push(s);
                    }
                }

            }
        }

        while (stack.isEmpty()==false)
        {
            result[index++]=stack.pop();
        }

        return result;
    }


    /// ham tinh toan bieu thuc hau to o dang mang String

    public static double computepostifixMultipleDigit(String[] postifix)
    {
        double result=0;
        Stack<String> stack= new Stack<>();

        for(int i=0;i<postifix.length;i++)
        {
            String s= postifix[i];
            if(s==null) break;
            else
            {
                if(s.matches("(\\d+\\.*\\d+)||(\\d+)") ) // neu s la so
                {
                    stack.push(s); //push vao stack
                }

                if(s.matches("sin((\\d+\\.*\\d+)||(\\d+))"))stack.push(String.valueOf(sinx(s))); // neu la cac ham luon giac thi chuyen doi tu chuoi chu sang gia tri so va luu push vao stack o dang chuoi
                if(s.matches("cos((\\d+\\.*\\d+)||(\\d+))"))stack.push(String.valueOf(cosx(s)));// vd s ="sin23" thi goi ham sinx() viet o ben tren de chuyen sin23 ve gia tri so 0.39 su do chuyen 0.39 sang string de lush vao stack
                if(s.matches("tan((\\d+\\.*\\d+)||(\\d+))"))stack.push(String.valueOf(tanx(s)));
                if(s.matches("cot((\\d+\\.*\\d+)||(\\d+))"))stack.push(String.valueOf(cotx(s)));


                else
                { // neu s la cac toan tu thi thuc hien tinh toan
                    switch (s)
                    {
                        case "+":
                        {
                            stack.push(String.valueOf((Double.valueOf(stack.pop())+Double.valueOf(stack.pop()))));
                            break;
                        }
                        case "-":
                        {
                            stack.push(String.valueOf((-Double.valueOf(stack.pop())+Double.valueOf(stack.pop()))));
                            break;
                        }
                        case "*":
                        {
                            stack.push(String.valueOf((Double.valueOf(stack.pop())*Double.valueOf(stack.pop()))));
                            break;
                        }
                        case "/":
                        {
                            double a1=Double.valueOf(stack.pop());
                            double a2=Double.valueOf(stack.pop());
                            stack.push(String.valueOf(a2/a1));
                            break;
                        }
                        case "^":
                        {
                            double a1=Double.valueOf(stack.pop());
                            double a2=Double.valueOf(stack.pop());
                            stack.push(String.valueOf(Math.pow(a2,a1)));
                            break;
                        }
                        case "%":
                        {
                            double a1=Double.valueOf(stack.pop());
                            double a2=Double.valueOf(stack.pop());
                            stack.push(String.valueOf(a2%a1));
                            break;
                        }

                    }
                }
            }
        }

       if(stack.isEmpty()==false) result=Double.valueOf(stack.pop());

        return result;
    }





    // get bieu thuc hau to tu bieu thuc trung to , ap dung cho bieu thuc cac so nguyen co 1 chu so
     public static StringBuffer getpostifix(String infix)
    {
        StringBuffer postifix= new StringBuffer();
        Stack<Character> stack= new Stack<>();

        for(int i=0;i<infix.length();i++)
        {
            char c= infix.charAt(i);
            if(Character.isDigit(c)==true || c=='e' || c=='p')
            {
                postifix.append(c);
            }

            if(c=='(') stack.push(c);

            if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^'||c=='%')
            {
                if(stack.isEmpty()==true) stack.push(c);
                else
                {
                    if(getpiority(c)>getpiority(stack.peek())) stack.push(c);
                    else
                    {
                        while(stack.isEmpty()==false && getpiority(stack.peek())>=getpiority(c))
                        {
                            postifix.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
            }

            if(c==')')
            {
                while(stack.isEmpty()==false && stack.peek()!='(')
                {
                    postifix.append(stack.pop());
                }
                if(stack.peek()=='(') stack.pop();
            }
        }
        while (stack.isEmpty()==false)
        {
            postifix.append(stack.pop());
        }

        return postifix;
    }

    // tinh toan bieu thuc hau to , ap dung cho bieu thuc so nguyen va moi so nguyen co 1 chu so

    public static double computepostifix(StringBuffer postifix)
    {
        double result=0;
        Stack<Double> stack= new Stack<>();

        for(int i=0;i<postifix.length();i++)
        {
            char c= postifix.charAt(i);
            if(Character.isDigit(c)==true) {
                stack.push((double) Character.getNumericValue(c));
            }
            else if(c=='p') stack.push(p);
            else if(c=='e') stack.push(e);

            else
            {
                switch (c)
                {
                    case '+' :
                    {
                        stack.push(stack.pop()+stack.pop());
                        break;
                    }
                    case '-':
                    {
                        stack.push(-stack.pop()+stack.pop());
                        break;
                    }
                    case '*':
                    {
                        stack.push(stack.pop()*stack.pop());
                        break;
                    }
                    case '/':
                    {
                        double a1= stack.pop();
                        double a2= stack.pop();
                        stack.push(a2/a1);
                        break;
                    }
                    case '^':
                    {
                        double a1= stack.pop();
                        double a2= stack.pop();
                        stack.push(Math.pow(a2,a1));
                        break;
                    }
                    case '%':
                    {
                        double a1= stack.pop();
                        double a2= stack.pop();
                        stack.push(a2%a1);
                        break;
                    }
                }
            }
        }

        result=stack.pop();

        return result;
    }

}
