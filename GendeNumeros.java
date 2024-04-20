
public class GendeNumeros{
    public boolean puedoGenerar(String [] a,String x){
        String [] z = new String[x.length()];
        int aux = 0;
        z = rellenar(z,x,aux);
        boolean res = false;
        int aux1 = 0;
        int aux2 = 0;
        res = puedoGenerar(a,z,res,aux1,aux2);
        return res;
    }
    
    private boolean puedoGenerar(String [] a,String [] z,boolean res,int aux1,int aux2){
        if(aux1 < a.length){
            if(a[aux1].length() < 2){
                if(a[aux1].equals(z[aux2])){
                    if(z[aux2].equals(z[z.length-1])){
                        res = true;
                    }else{
                        res = puedoGenerar(a,z,res,aux1+1,aux2+1);
                    }
                }else{
                    res = puedoGenerar(a,z,res,aux1+1,aux2);
                }
            }else{
                String [] c = new String[a[aux1].length()];
                c = rellenar(c,a[aux1],0);
                int aux = 0;
                boolean bandera = flag(c,z,aux,aux2);
                if(bandera == true){
                    aux2 = aux2 + c.length;
                }
                if(aux2 == z.length){
                    res = true;
                }else{
                    res = puedoGenerar(a,z,res,aux1+1,aux2);
                }   
            } 
        }
        return res;
    }
    
    private boolean flag(String [] c, String [] z, int aux1, int aux2){
        boolean res = false;
        if(aux1 < c.length){
            if(c[aux1].equals(z[aux2])){
                if(c[aux1].equals(c[c.length-1])){
                    res = true;
                }else{
                    res = flag(c,z,aux1+1,aux2+1);
                }
            }else{
                res = false;
            }
        }
        return res;
    }
      
    private String[] rellenar(String [] z, String x, int aux){
        if(aux < z.length){
            z[aux] = Character.toString(x.charAt(aux));
            rellenar(z,x,aux+1);
        }
        return z;
    }
}
