package util;

//classe para tratamento de erros na interface
public class MyException extends Throwable {
    public MyException(String msg){
        super(msg);
    }
}
