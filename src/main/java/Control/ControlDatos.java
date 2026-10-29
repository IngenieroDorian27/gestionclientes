
package Control;

/**
 *
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class ControlDatos {
    
    public int leerEntero(String mensaje){
        int x = 0;
        boolean bandera = false;
        Scanner entry = new Scanner(System.in);
        
        do{
            System.out.println(mensaje);
            try{
                x = entry.nextInt();
                bandera = true;
            }
            catch(InputMismatchException ex){
                System.out.println("Error: se esperaba un numero entero");
                bandera = false;
                entry.nextLine();
            }
        }while(!bandera);
        return x;
    }
    
    public double leerReal(String mensaje){
        double x = 0;
        boolean bandera = false;
        Scanner entry = new Scanner(System.in);
        
        do{
            System.out.println(mensaje);
            try{
                x = entry.nextDouble();
                bandera = true;
            }
            catch(InputMismatchException ex){
                System.out.println("Error: se esperaba un numero real");
                bandera = false;
                entry.nextLine();
            }
        }while(!bandera);
        return x;
        
    }
    
    public char leerLetra(String msj, char a, char b){
        char x = ' ';
        boolean bandera = false;
        Scanner entry = new Scanner(System.in);
        
        do{
            System.out.println(msj);
            try{
                x = entry.nextLine().trim().charAt(0);
                if(Character.toUpperCase(x)==a||Character.toUpperCase(x)==b){
                    bandera = true;
                }
                else{
                    bandera = false;
                }
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("Error: se esperaba al menos una letra.");
                bandera = false;
            }
        }while(!bandera);
        return x;
        
    }
    
}
