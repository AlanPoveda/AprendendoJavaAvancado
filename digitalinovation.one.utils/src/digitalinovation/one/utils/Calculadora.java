package digitalinovation.one.utils;

import digitalinovation.one.utils.internal.DivHelper;
import digitalinovation.one.utils.internal.MultHelper;
import digitalinovation.one.utils.internal.SubHelper;
import digitalinovation.one.utils.internal.SumHelper;

public class Calculadora {

    private DivHelper divHelper;
    private MultHelper multHelper;
    private SumHelper sumHelper;
    private SubHelper subHelper;

    //Instanciar o pessoal
    public Calculadora(){
        divHelper = new DivHelper();
        multHelper = new MultHelper();
        sumHelper = new SumHelper();
        subHelper = new SubHelper();
    }

    //Delegando para outros objetos que sabem fazer o que fazer
    public int sum(int a, int b){
        return sumHelper.execute(a,b);
    }

    public int sub(int a, int b){
        return subHelper.execute(a,b);
    }

    public int multi(int a, int b){
        return multHelper.execute(a,b);
    }

    public int div(int a, int b){
        return divHelper.execute(a,b);
    }


}

