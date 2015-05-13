package programming.art;

import java.util.Scanner;  
   
/** 
 * 01�������� 
 * @author honest 
 * 
 */ 
public class ZeroOnePack {  
    public static void main(String[] args) {  
        int N;  //������Ŀ  
        int[] weight; //������Ʒ����  
        int[] value; //������Ʒ��ֵ  
        int[][] values ; //��ż�ֵ  
        int maxValue;  //����ֵ  
        Scanner in=new Scanner(System.in);  
        maxValue=in.nextInt();  
        N=in.nextInt();  
        weight=new int[N+1];  
        value=new int[N+1];  
        values=new int[N+1][maxValue+1];  
        for(int i=1;i<=N;i++){  
            weight[i]=in.nextInt();  
            value[i]=in.nextInt();  
        }  
   
        for(int i=0;i<=N;i++)  
            values[i][0]=0;  
        for(int i=0;i<=maxValue;i++)  
            values[0][i]=0;  
   
        for ( int i = 1; i <= N; i++){  
            for ( int j = 1; j<=maxValue; j++){  
                if(weight[i]>j){  
                    values[i][j]=values[i-1][j];  
                }else {  
                    values[i][j]=Math.max(values[i-1][j-weight[i]]+value[i], values[i-1][j]);  
                }  
            }  
        }  
   
        //�����ҳ�ѡ���ı���  
        int j=maxValue;  
        for(int i=N;i>0;i--){  
            if(values[i][j]>values[i-1][j]){  
                System.out.print(i+"  ");  
                j=j-value[i];  
                if(j<0) break;  
            }  
        }  
   
        in.close();  
   
    }  
}  
 

 

