
public class ElLaberinto{
    public boolean puedoSalir(int n, String[] maze){
        boolean res = false;
        char [][] lab = new char [n][n];
        int aux1 = 0;
        int aux2 = 0;
        lab = convertir(maze,n,aux1,aux2,lab);
        int xL = encontrarX(maze,n,0,0,'P');
        int yL = encontrarY(maze,n,0,0,'P');
        int xR = encontrarX(maze,n,0,0,'F');
        int yR = encontrarY(maze,n,0,0,'F');
        res = puedoSalir(lab,n,xL,yL,xR,yR,res);
        return res;
    }
    
    private boolean puedoSalir(char [][] lab,int n,int x,int y, int xR, int yR,boolean res){
        if(valida(x,y,n)){
            if(lab[x][y] == '*'|| lab[x][y] =='P' || lab[x][y] == 'F'){
                if(x == xR && y == yR){
                    res = true;
                }else{ 
                    lab[x][y] = '-';
                    res = puedoSalir(lab,n,x-1,y,xR,yR,res);
                    if(!res){
                        res = puedoSalir(lab,n,x,y+1,xR,yR,res);
                        if(!res){
                            res = puedoSalir(lab,n,x+1,y,xR,yR,res);
                            if(!res){
                                res = puedoSalir(lab,n,x,y-1,xR,yR,res);
                            }
                        }
                    }
                    lab[x][y] = '*';
                }
            }
        }
        return res;
    }
    
    private boolean valida(int x,int y,int n){
        boolean resul;
        if(x < n && x >= 0 && y < n && y >= 0){
            resul = true;
        }else{
            resul = false;
        }  
        return resul;
    }
    
    private int encontrarX(String [] maze,int n,int aux1,int aux2,char x){
        int res= 0;
        if(aux1 < n){
            if(aux2 < n){
                if(maze[aux1].charAt(aux2) == x){
                    res = aux1;
                }else{
                    res = encontrarX(maze,n,aux1,aux2+1,x);
                }
            }else{
                aux2 = 0;
                res = encontrarX(maze,n,aux1+1,aux2,x);
            }
        }
        return res;
    }
    
    private int encontrarY(String [] maze,int n,int aux1,int aux2,char x){
        int res = 0;
        if(aux1 < n){
            if(aux2 < n){
                if(maze[aux1].charAt(aux2) == x){
                    res = aux2;
                }else{
                    res = encontrarY(maze,n,aux1,aux2+1,x);
                }
            }else{
                aux2 = 0;
                res = encontrarY(maze,n,aux1+1,aux2,x);
            }
        }
        return res;
    }
    
    private char [][] convertir(String [] maze, int n, int aux1, int aux2, char[][] lab){
        if(aux1 < n){
            if(aux2 < n){
                lab[aux1][aux2] = maze[aux1].charAt(aux2);
                lab = convertir(maze,n,aux1,aux2+1,lab);
            }else{
                aux2 = 0;
                lab = convertir(maze,n,aux1+1,aux2,lab);
            }
        }
        return lab;
    }
}
