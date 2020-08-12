package biletomat;

import java.util.Scanner;


public class Biletomat {

    
    public static void main(String[] args) {
        Scanner skan = new Scanner(System.in);
        
        Bilet bilet1 = new Bilet();
        
        System.out.println("BILETOMAT");
        System.out.println("Wybierz numer biletu: 1, 2 lub 3");
        System.out.println("1. Bilet 20 min (3.50pln)");
        System.out.println("2. Bilet 40 min (5.40pln)");
        System.out.println("3. Bilet 1h. (6.60pln)");
        
        int rodzajBiletu = skan.nextInt();   // WPISANIE NUMERU BILETU
        
        bilet1.setBilet(rodzajBiletu);   //SPRAWDZENIE BR BILETU I PRZYPISANIE CENY
                       
        System.out.println("Podaj ilosc biletow: "); 
        
        int ilosc = skan.nextInt();  // WPISANIE ILOSCI BILETOW
        
        bilet1.setIloscRodzaj(rodzajBiletu, ilosc);  // set ilosc 
        
        bilet1.setDoZaplaty();
        
        System.out.println("DO ZAPLATY: " + bilet1.doZaplaty);
        
        
        System.out.println("Wrzuc monety:");
        System.out.println("1. 10gr");
        System.out.println("2. 50gr");
        System.out.println("3. 1 zl");
        System.out.println("4. 2 zl");
        System.out.println("5. 5 zl");
        
        do {
        int rodzajMonety = skan.nextInt();
        bilet1.setMonety(rodzajMonety);
        }
        while (bilet1.saldo <= bilet1.doZaplaty);
        
        bilet1.wydrukBiletu();
        
     
    }
    
}

class Bilet{
   int ilosc;
   double cena;
   double saldo = 0;
   int rodzajBiletu;
   double doZaplaty;
   double moneta;
   
   
      
   void setIloscRodzaj(int rodzajBiletu, int ilosc)
   {
      this.rodzajBiletu = rodzajBiletu; 
      this.ilosc = ilosc;
   }
   
   void setDoZaplaty(){
        doZaplaty = (double)cena*ilosc;
   }
   
   void setBilet(int rodzajBiletu){
       switch (rodzajBiletu) {
           case 1:
               this.cena = 3.50;
               break;
           case 2:
               this.cena = 5.40;
               break;
           case 3:
               this.cena =6.60;
               break;
           default:
               System.out.println("Ee chłopie, nie ma takiego biletu");
               
       }    
    
    }
   
   void setMonety(int rodzajMonety){
         
     switch (rodzajMonety){
         case 1:
             this.saldo += 0.1;
             break;
         case 2:
             this.saldo +=0.5;
             break;
         case 3:
             this.saldo +=1;
             break;
         case 4:
             this.saldo +=2;
             break;
         case 5:
             this.saldo +=5;
             break;
         default:
             System.out.println("Panie, co mi tu wrzucasz?");     
        }
     System.out.println("DO ZAPLATY: " + (doZaplaty- saldo));
     System.out.println("WPLACONO:   " + saldo);   
     }
   
   void wydrukBiletu(){
       if (saldo>=doZaplaty)
       {
           System.out.println("---------------------");
           System.out.println("BIP BIP WYDRUK BILETU");
           System.out.println("---------------------");
           System.out.println( "RESZTA: " + (saldo- doZaplaty));
       }
       else {
           System.out.println("BLAD");
           System.out.println("ZWROT: " + saldo);
        }
   }
  
}

        

