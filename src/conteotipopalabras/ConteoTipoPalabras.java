package conteotipopalabras;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ConteoTipoPalabras {

    private Map<String, Integer> mapa;
    private Scanner sc;
    
    public ConteoTipoPalabras()
    {
        mapa = new HashMap<String,Integer>();
        sc = new Scanner(System.in);
        crearMap();
        mostrarMap();
    }
    
    private void crearMap()
    {
        System.out.println("Escriba una cadena: ");
        String entrada = sc.nextLine();
        
        StringTokenizer tokenizer = new StringTokenizer(entrada);
        //hola me llamo abraham
        while(tokenizer.hasMoreTokens())
        {
            String palabra = tokenizer.nextToken().toLowerCase();
            
            if(mapa.containsKey(palabra))//esta la palabra en el mapa?
            {
                int cuenta = mapa.get(palabra);//obtiene la cuenta actual
                mapa.put(palabra, cuenta+1);
            }
            else
                mapa.put(palabra, 1); //agrega nueva palabra con una cuenta
                                      //de 1 al mapa
        }
    }
    
    public void mostrarMap()
    {
        Set<String> claves = mapa.keySet(); //obtiene las claves
        //ordena las claves
        TreeSet<String> clavesOrdenadas = new TreeSet<String>(claves);
        
        System.out.println("El mapa contiene:\nClave\t\tValor:");
        
        for(String s:clavesOrdenadas)
            System.out.printf("%-10s%10s\n", s,mapa.get(s));
        
        System.out.printf("\nsize:%d\nisEmpty:%b\n", mapa.size(), mapa.isEmpty());
    }
    
    public static void main(String[] args) {    
       new ConteoTipoPalabras();
    }
    
}
