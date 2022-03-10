
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Oyun extends JPanel implements ActionListener{
    Timer timer = new Timer(500,this);
    Image image_5 = new ImageIcon(Oyun.class.getResource("5.jpeg")).getImage();
    Image image_10 = new ImageIcon(Oyun.class.getResource("10.jpeg")).getImage();
    Image image_15 = new ImageIcon(Oyun.class.getResource("15.jpeg")).getImage();
    Image image_20 = new ImageIcon(Oyun.class.getResource("20.jpeg")).getImage();
    Image image_g5 = new ImageIcon(Oyun.class.getResource("g5.jpeg")).getImage();
    Image image_g10 = new ImageIcon(Oyun.class.getResource("g10.jpeg")).getImage();
    Image image_g15 = new ImageIcon(Oyun.class.getResource("g15.jpeg")).getImage();
    Image image_g20 = new ImageIcon(Oyun.class.getResource("g20.jpeg")).getImage();
    Image back_ground = new ImageIcon(Oyun.class.getResource("sekil.png")).getImage();
    Player player1 = new Player("Player1", 0, 0, 200, 0,0,0, new ImageIcon(Oyun.class.getResource("1.png")).getImage());
    Player player2 = new Player("Player2", 0, 0, 200, 0,0,380,new ImageIcon(Oyun.class.getResource("2.png")).getImage());
    Player player3 = new Player("Player3", 0, 0, 200, 0,380,0,new ImageIcon(Oyun.class.getResource("3.png")).getImage());
    Player player4 = new Player("Player4", 0, 0, 200, 0,380,380,new ImageIcon(Oyun.class.getResource("4.png")).getImage());
    int kordin[][];
    int komsuluk_matrisi[];
    int komsuluk_matrisi2[][];
    ArrayList<Integer> altinlar;
    ArrayList<Integer> gizli_altinlar;
    ArrayList<Integer> rastgele_kordinatlar;
    ArrayList<Integer> sekiz_kordinat;
    ArrayList<Integer> iki_kordinat;
    ArrayList<Integer> kirmizi_kordinatlar=new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> array;
    ArrayList<ArrayList<Integer>> b_array;
    ArrayList<ArrayList<Integer>> c_array;
    ArrayList<ArrayList<Integer>> d_array;
    ArrayList<Integer> ikikere;
    ArrayList<Integer> izin;
    boolean x_boolean;
    ArrayList<Integer> uzakliklar;
    int yesil_izin;
    int adim;
    int devam;
    int i,j;
    int sayac;
    int tut;
    int a;
    int tut_t;
    int b2_tut;
    int b_tut_t;
    int c_tut_t;
    int d_tut_t;
    int d_tut;
    int d_adim;
    int d;
    int d_devam;
    int sari_izin;
    int b_adim;
    int b_devam;
    int b_tut;
    int b;
    int utm;
    int utm_c;
    int c_adim;
    int c_devam;
    int mavi_izin;
    int c_tut;
    int c;
    int kirmizi_izin;
    int a_tut;
    int isaret;
    int kirmizi_tut;
    int sari_tut;
    int sari_tut_tut;
    boolean y_boolean;
    boolean z_boolean;
    int bayrak_tut;
    int mavi_tut;
    int mavi_tut_tut;
    int yesil_tut;
    ArrayList<Integer> enbuyuk_kordin;
    int flag;
    public static int[] komsuluk(int kordin[][],int komsuluk_matrisi[],int src) {
        
        int i,j;
        for(i=0;i<400;i++){
            if(src!=i && Math.abs(kordin[i][0]-kordin[src][0])*Math.abs(kordin[i][0]-kordin[src][0])+
                    Math.abs(kordin[i][1]-kordin[src][1])*Math.abs(kordin[i][1]-kordin[src][1])<=400){
               komsuluk_matrisi[i]=400;
            }
            else{
                komsuluk_matrisi[i]=0;
            }
        }
        
        
        return komsuluk_matrisi;
        
    }
    void printSolution(int dist[]) 
    { 
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i <400 ; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    }
    public static int minDistance(int dist[], Boolean sptSet[]) 
    { 
        // Initialize min value _
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < 400; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    }
    public static ArrayList dijkstra2(int graph[][], int src) 
    { 
        int dist[] = new int[400];
        Boolean sptSet[] = new Boolean[400]; 
        int i,j;
        for (i = 0; i < 400; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
        int k=0;
        dist[src] = 0; 
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        for(i=0;i<400;i++){
            array.add(new ArrayList());
            array.get(i).add(0);
        }
        for (int count = 0; count < 400 - 1; count++) { 
            int u = minDistance(dist, sptSet); 
            sptSet[u] = true; 
  
            for (int v = 0; v < 400; v++) {
  
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                       dist[v] = dist[u] + graph[u][v];
                       for(k=0;k<array.get(u).size();k++){
                           if(array.get(u).get(k)!=0){
                           array.get(v).add(array.get(u).get(k));
                           }
                        }
                       array.get(v).add(v);
                }
            }
        }
        for(i=0;i<400;i++){
            array.get(i).remove(0);
        }
        //printSolution(dist); 
        return array;
    
    }
    public Oyun(){
        kordin = new int[][]{
            {0,0},{0,20},{0,40},{0,60},{0,80},{0,100},{0,120},{0,140},{0,160},{0,180},{0,200},
            {0,220},{0,240},{0,260},{0,280},{0,300},{0,320},{0,340},{0,360},{0,380},
            {20,0},{20,20},{20,40},{20,60},{20,80},{20,100},{20,120},{20,140},{20,160},{20,180},{20,200},
            {20,220},{20,240},{20,260},{20,280},{20,300},{20,320},{20,340},{20,360},{20,380},
            {40,0},{40,20},{40,40},{40,60},{40,80},{40,100},{40,120},{40,140},{40,160},{40,180},{40,200},
            {40,220},{40,240},{40,260},{40,280},{40,300},{40,320},{40,340},{40,360},{40,380},
            {60,0},{60,20},{60,40},{60,60},{60,80},{60,100},{60,120},{60,140},{60,160},{60,180},{60,200},
            {60,220},{60,240},{60,260},{60,280},{60,300},{60,320},{60,340},{60,360},{60,380},
            {80,0},{80,20},{80,40},{80,60},{80,80},{80,100},{80,120},{80,140},{80,160},{80,180},{80,200},
            {80,220},{80,240},{80,260},{80,280},{80,300},{80,320},{80,340},{80,360},{80,380},
            {100,0},{100,20},{100,40},{100,60},{100,80},{100,100},{100,120},{100,140},{100,160},{100,180},{100,200},
            {100,220},{100,240},{100,260},{100,280},{100,300},{100,320},{100,340},{100,360},{100,380},
            {120,0},{120,20},{120,40},{120,60},{120,80},{120,100},{120,120},{120,140},{120,160},{120,180},{120,200},
            {120,220},{120,240},{120,260},{120,280},{120,300},{120,320},{120,340},{120,360},{120,380},
            {140,0},{140,20},{140,40},{140,60},{140,80},{140,100},{140,120},{140,140},{140,160},{140,180},{140,200},
            {140,220},{140,240},{140,260},{140,280},{140,300},{140,320},{140,340},{140,360},{140,380},
            {160,0},{160,20},{160,40},{160,60},{160,80},{160,100},{160,120},{160,140},{160,160},{160,180},{160,200},
            {160,220},{160,240},{160,260},{160,280},{160,300},{160,320},{160,340},{160,360},{160,380},
            {180,0},{180,20},{180,40},{180,60},{180,80},{180,100},{180,120},{180,140},{180,160},{180,180},{180,200},
            {180,220},{180,240},{180,260},{180,280},{180,300},{180,320},{180,340},{180,360},{180,380},
            {200,0},{200,20},{200,40},{200,60},{200,80},{200,100},{200,120},{200,140},{200,160},{200,180},{200,200},
            {200,220},{200,240},{200,260},{200,280},{200,300},{200,320},{200,340},{200,360},{200,380},
            {220,0},{220,20},{220,40},{220,60},{220,80},{220,100},{220,120},{220,140},{220,160},{220,180},{220,200},
            {220,220},{220,240},{220,260},{220,280},{220,300},{220,320},{220,340},{220,360},{220,380},
            {240,0},{240,20},{240,40},{240,60},{240,80},{240,100},{240,120},{240,140},{240,160},{240,180},{240,200},
            {240,220},{240,240},{240,260},{240,280},{240,300},{240,320},{240,340},{240,360},{240,380},
            {260,0},{260,20},{260,40},{260,60},{260,80},{260,100},{260,120},{260,140},{260,160},{260,180},{260,200},
            {260,220},{260,240},{260,260},{260,280},{260,300},{260,320},{260,340},{260,360},{260,380},
            {280,0},{280,20},{280,40},{280,60},{280,80},{280,100},{280,120},{280,140},{280,160},{280,180},{280,200},
            {280,220},{280,240},{280,260},{280,280},{280,300},{280,320},{280,340},{280,360},{280,380},
            {300,0},{300,20},{300,40},{300,60},{300,80},{300,100},{300,120},{300,140},{300,160},{300,180},{300,200},
            {300,220},{300,240},{300,260},{300,280},{300,300},{300,320},{300,340},{300,360},{300,380},
            {320,0},{320,20},{320,40},{320,60},{320,80},{320,100},{320,120},{320,140},{320,160},{320,180},{320,200},
            {320,220},{320,240},{320,260},{320,280},{320,300},{320,320},{320,340},{320,360},{320,380},
            {340,0},{340,20},{340,40},{340,60},{340,80},{340,100},{340,120},{340,140},{340,160},{340,180},{340,200},
            {340,220},{340,240},{340,260},{340,280},{340,300},{340,320},{340,340},{340,360},{340,380},
            {360,0},{360,20},{360,40},{360,60},{360,80},{360,100},{360,120},{360,140},{360,160},{360,180},{360,200},
            {360,220},{360,240},{360,260},{360,280},{360,300},{360,320},{360,340},{360,360},{360,380},
            {380,0},{380,20},{380,40},{380,60},{380,80},{380,100},{380,120},{380,140},{380,160},{380,180},{380,200},
            {380,220},{380,240},{380,260},{380,280},{380,300},{380,320},{380,340},{380,360},{380,380}
        };
        komsuluk_matrisi2 = new int[400][400];
        array=new ArrayList<ArrayList<Integer>>();
        b_array=new ArrayList<ArrayList<Integer>>();
        c_array=new ArrayList<ArrayList<Integer>>();
        d_array=new ArrayList<ArrayList<Integer>>();
        ikikere=new ArrayList<Integer>();
        uzakliklar = new ArrayList<Integer>();
        int i=0,j;
        int src=0;
        bayrak_tut=0;
        yesil_izin=0;
        sayac=0;
        adim=0;
        b2_tut=0;
        devam=1;
        yesil_tut=0;
        tut=0;
        iki_kordinat = new ArrayList<Integer>();
        sekiz_kordinat = new ArrayList<Integer>();
        a=0;
        b_adim=0;
        b_devam=1;
        x_boolean=true;
        y_boolean=true;
        z_boolean=true;
        d_adim=0;
        kirmizi_tut=0;
        d_devam=1;
        d=0;
        d_tut=0;
        d_tut_t=0;
        sari_izin=0;
        b_tut=0;
        b=0;
        kirmizi_izin=0;
        c_adim=0;
        c_devam=1;
        c_tut=0;
        mavi_tut_tut=0;
        c=0;
        flag=0;
        a_tut=0;
        mavi_izin=0;
        mavi_tut=0;
        int c;
        int c_adim;
        int c_devam;
        enbuyuk_kordin=new ArrayList<Integer>();
        altinlar=new ArrayList<Integer>();
        gizli_altinlar=new ArrayList<Integer>();
        rastgele_kordinatlar=new ArrayList<Integer>();
        kirmizi_kordinatlar=new ArrayList<Integer>();
        izin = new ArrayList<Integer>();
        Random random_sayi = new Random();
        int mavi_maden;
        isaret=0;
        mavi_maden = random_sayi.nextInt(375)+1;
        rastgele_kordinatlar.add(mavi_maden);
        int y=0;
        while(i!=72){
            y=0;
            mavi_maden = random_sayi.nextInt(375)+1;
            for(j=1;j<rastgele_kordinatlar.size();j++){
                if(rastgele_kordinatlar.get(j)==mavi_maden){
                    y=1;
                    break;
                }
            }
            if(y==0){
                rastgele_kordinatlar.add(mavi_maden);
                i++;
            }
        }
        for(i=0;i<8;i++){
            ikikere.add(1);
        }
        for(i=0;i<72;i++){
            mavi_maden =(random_sayi.nextInt(4)+1)*5;
            altinlar.add(mavi_maden);
        }
        for(i=0;i<8;i++){
            mavi_maden =(random_sayi.nextInt(4)+1)*5;
            gizli_altinlar.add(mavi_maden);
        }
        for(i=0;i<8;i++){
            altinlar.add(-1);
        }
        for(i=0;i<8;i++){
            kirmizi_kordinatlar.add(rastgele_kordinatlar.get(i));
        }
        for(i=0;i<400;i++){
            for(j=0;j<400;j++){
            komsuluk_matrisi2[i][j]=0;
            }
        }
        for(i=0;i<400;i++){
            komsuluk_matrisi = new int[400];
            for(int temp5=0;temp5<400;temp5++){
                komsuluk_matrisi[temp5]=0;
            }
            komsuluk(kordin, komsuluk_matrisi, src);
            for(j=0;j<400;j++){
                komsuluk_matrisi2[src][j]=komsuluk_matrisi[j];
            }
            src++;
        }
        tut_t=0;
        b_tut_t=0;
        c_tut_t=0;
        d_tut_t=0;
        utm=0;
        utm_c=0;
        for(i=0;i<8;i++){
            izin.add(-1);
        }
        izin.size();
        for(i=0;i<8;i++){
            izin.set(i, -1);
        }
            timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        for(i=0;i<rastgele_kordinatlar.size();i++){
            if(altinlar.size()!=i){
            if(rastgele_kordinatlar.get(i)!=-1 && altinlar.get(i)==5){
            g.drawImage(image_5, kordin[rastgele_kordinatlar.get(i)][0],kordin[rastgele_kordinatlar.get(i)][1], image_5.getWidth(this), image_5.getHeight(this), this);        
            }
            }
            if(altinlar.size()!=i){
            if(rastgele_kordinatlar.get(i)!=-1 && altinlar.get(i)==10){
            g.drawImage(image_10, kordin[rastgele_kordinatlar.get(i)][0],kordin[rastgele_kordinatlar.get(i)][1], image_10.getWidth(this), image_10.getHeight(this), this);        
            }
            }
            if(altinlar.size()!=i){
            if(rastgele_kordinatlar.get(i)!=-1 && altinlar.get(i)==15){
            g.drawImage(image_15, kordin[rastgele_kordinatlar.get(i)][0],kordin[rastgele_kordinatlar.get(i)][1], image_15.getWidth(this), image_15.getHeight(this), this);        
            }
            }
            if(altinlar.size()!=i){
            if(rastgele_kordinatlar.get(i)!=-1 && altinlar.get(i)==20){
            g.drawImage(image_20, kordin[rastgele_kordinatlar.get(i)][0],kordin[rastgele_kordinatlar.get(i)][1], image_20.getWidth(this), image_20.getHeight(this), this);        
            }
            }
            }
            for(i=0;i<8;i++){
                if(izin.get(i)!=-1 && ikikere.get(i)==1){
            if(gizli_altinlar.get(i)==5 ){
            g.drawImage(image_g5, kordin[kirmizi_kordinatlar.get(i)][0]+7,kordin[kirmizi_kordinatlar.get(i)][1]+7, image_g5.getWidth(this), image_g5.getHeight(this), this);
            }
                }
               if(izin.get(i)!=-1 && ikikere.get(i)==1){
            if(gizli_altinlar.get(i)==10){
            g.drawImage(image_g10, kordin[kirmizi_kordinatlar.get(i)][0]+7,kordin[kirmizi_kordinatlar.get(i)][1]+7, image_g10.getWidth(this), image_g10.getHeight(this), this);
            }
               }
              if(izin.get(i)!=-1 && ikikere.get(i)==1){
            if(gizli_altinlar.get(i)==15){
            g.drawImage(image_g15, kordin[kirmizi_kordinatlar.get(i)][0]+7,kordin[kirmizi_kordinatlar.get(i)][1]+7, image_g15.getWidth(this), image_g15.getHeight(this), this);
            }
              }
               if(izin.get(i)!=-1 && ikikere.get(i)==1){
            if(gizli_altinlar.get(i)==20){
            g.drawImage(image_g20, kordin[kirmizi_kordinatlar.get(i)][0]+7,kordin[kirmizi_kordinatlar.get(i)][1]+7, image_g20.getWidth(this), image_g20.getHeight(this), this);
            }
               }
        }
        g.drawImage(back_ground, 0, 0, back_ground.getWidth(this), back_ground.getHeight(this), this);
        g.drawImage(player1.getImage(), player1.getX(), player1.getY(), player1.getImage().getWidth(this), player1.getImage().getHeight(this), this);
        g.drawImage(player2.getImage(), player2.getX(), player2.getY(), player2.getImage().getWidth(this), player2.getImage().getHeight(this), this);
        g.drawImage(player3.getImage(), player3.getX(), player3.getY(), player3.getImage().getWidth(this), player3.getImage().getHeight(this), this);
        g.drawImage(player4.getImage(), player4.getX(), player4.getY(), player4.getImage().getWidth(this), player4.getImage().getHeight(this), this);
        
    
    
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        int temp10;
        int enyakin=9999999;
        int enyakin2=9999999;
        flag=0;
        isaret=0;
        int isaret2=0;
        if(rastgele_kordinatlar.size()>0 && sayac==0 && player1.getKasadaki_altin_miktari()>=10){
            if(a==0 && devam==1){
               for(i=0;i<izin.size();i++){
                if(izin.get(i)!=-1 && ikikere.get(i)==1){
                temp10=Math.abs((kordin[izin.get(i)][1]-player1.getY())*(kordin[izin.get(i)][1]-player1.getY()))
                +Math.abs((kordin[izin.get(i)][0]-player1.getX())*(kordin[izin.get(i)][0]-player1.getX()));
         
                if(temp10<enyakin){
                    enyakin=temp10;
                    tut=izin.get(i);
                    kirmizi_tut=tut;
        }
            }
              }
                for(i=0;i<rastgele_kordinatlar.size();i++){
                if(rastgele_kordinatlar.get(i)!=-1){
                temp10=Math.abs((kordin[rastgele_kordinatlar.get(i)][1]-player1.getY())*(kordin[rastgele_kordinatlar.get(i)][1]-player1.getY()))
                +Math.abs((kordin[rastgele_kordinatlar.get(i)][0]-player1.getX())*(kordin[rastgele_kordinatlar.get(i)][0]-player1.getX()));
         
                if(temp10<enyakin){
                    enyakin=temp10;
                    tut=rastgele_kordinatlar.get(i);
        }
            }
              }
            player1.setKasadaki_altin_miktari(player1.getKasadaki_altin_miktari()-10);
                array=dijkstra2(komsuluk_matrisi2, player1.getX()+(player1.getY()/20));
                player1.setHarcanan_altin_miktari(player1.getHarcanan_altin_miktari()+10);
            
            }
            
            try{
            
            for(i=0;i<8;i++){
                if(izin.get(i)!=-1){
                if(player1.getX()==kordin[izin.get(i)][0] && player1.getY()==kordin[izin.get(i)][1] && ikikere.get(i)==1){
                    isaret=1;
                }
                }
            }
            if(isaret==1 && kirmizi_izin==0){
                sayac=1;
                   devam=1;
                   a=0;
                   adim=0; 
                for(i=0;i<izin.size();i++){
                       if(izin.get(i)==tut && izin.get(i)!=-1){
                           int temp9=player1.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player1.setKasadaki_altin_miktari(temp9);
                           int temp8=player1.getToplanan_altin_miktari()+ altinlar.get(i);
                           player1.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==tut){
                           if(altinlar.size()!=i){
                           int temp9=player1.getKasadaki_altin_miktari() + altinlar.get(i);
                           player1.setKasadaki_altin_miktari(temp9);
                           int temp8=player1.getToplanan_altin_miktari()+ altinlar.get(i);
                           player1.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
            }
            else if(array.get(tut).size()==0){
                sayac=1;
                   devam=1;
                   adim=0;
                   a=0;
//                   for(i=0;i<rastgele_kordinatlar.size();i++){
//                       if(rastgele_kordinatlar.get(i)==b_tut){
//                           if(altinlar.size()!=i){
//                           int temp9=player2.getKasadaki_altin_miktari() + altinlar.get(i);
//                           player2.setKasadaki_altin_miktari(temp9);
//                           }
//                           rastgele_kordinatlar.set(i, -1);
//                           altinlar.set(i, -1);
//                           break;
//                           
//                       }
//                   }
                   
                    
                }
             else if(kirmizi_izin==0 && player1.getX()==kordin[array.get(tut).get(array.get(tut).size()-1)][0] && player1.getY()==kordin[array.get(tut).get(array.get(tut).size()-1)][1] && kirmizi_tut==tut){
                   sayac=1;
                   devam=1;
                   adim=0;
                   a=0;
                   for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==tut){
                           if(altinlar.size()!=i){
                           int temp9=player1.getKasadaki_altin_miktari() + altinlar.get(i);
                           player1.setKasadaki_altin_miktari(temp9);
                           int temp8=player1.getToplanan_altin_miktari()+ altinlar.get(i);
                           player1.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
           for(i=0;i<izin.size();i++){
                       if(izin.get(i)==tut && ikikere.get(i)!=-1){
                           int temp9=player1.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player1.setKasadaki_altin_miktari(temp9);
                           int temp8=player1.getToplanan_altin_miktari()+ altinlar.get(i);
                           player1.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                   }        
                   bayrak_tut=tut;
                   
                   
                    
                }
            else if(player1.getX()==kordin[array.get(tut).get(array.get(tut).size()-1)][0] && player1.getY()==kordin[array.get(tut).get(array.get(tut).size()-1)][1] && kirmizi_tut!=tut){
                   sayac=1;
                   devam=1;
                   adim=0;
                   a=0;
                   for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==tut){
                           if(altinlar.size()!=i){
                           int temp9=player1.getKasadaki_altin_miktari() + altinlar.get(i);
                           player1.setKasadaki_altin_miktari(temp9);
                           int temp8=player1.getToplanan_altin_miktari()+ altinlar.get(i);
                           player1.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                   kirmizi_izin=1;
                   
                   
                    
                }
            
            else if(a==3){
                sayac=1;
                devam=0;
                a=0;
                player1.setX(kordin[array.get(tut).get(adim)][0]);
                player1.setY(kordin[array.get(tut).get(adim)][1]);
            
                player1.setToplam_adim_sayisi(player1.getKasadaki_altin_miktari()-5);
                player1.setHarcanan_altin_miktari(player1.getHarcanan_altin_miktari()+5);
            }
            
            else{
            if(kirmizi_izin==1){
            int bayrak=0;
                    for(i=0;i<izin.size();i++){
                            if(izin.get(i)==tut){
                                    bayrak=1;
                                    break;
                    }
                    }
                    for(i=0;i<8;i++){
                            if(kirmizi_kordinatlar.get(i)==player1.getX()+(player1.getY()/20) && bayrak==0 && ikikere.get(i)==1){
                                      izin.set(i, kirmizi_kordinatlar.get(i));
                   }
           }        
                   bayrak_tut=tut;
                   kirmizi_izin=0;
            }    
                player1.setX(kordin[array.get(tut).get(adim)][0]);
                player1.setY(kordin[array.get(tut).get(adim)][1]);
                
                player1.setToplam_adim_sayisi(player1.getToplam_adim_sayisi()+1);
                adim++; 
                a++;
            }
            }
            catch(IndexOutOfBoundsException exception){
                System.out.println("Exception");
            }
            repaint();
        }
        
        else if(rastgele_kordinatlar.size()>0 && sayac==1 && player2.getKasadaki_altin_miktari()>=10){
            
            int enbuyuk_altin=0;
            if(b==0 && b_devam==1){
                
                
                for(i=0;i<gizli_altinlar.size();i++){
                    if(enbuyuk_altin==gizli_altinlar.get(i)+altinlar.get(i) && izin.get(i)!=-1 && ikikere.get(i)==1){
                        enbuyuk_kordin.add(kirmizi_kordinatlar.get(i));
                        utm=1;
                        System.out.println("Enbuyukkordin mavi icin");
                    }
                }
                for(i=0;i<gizli_altinlar.size();i++){
                    if(izin.get(i)!=-1 && ikikere.get(i)==1){
                    if(enbuyuk_altin<=gizli_altinlar.get(i)){
                        enbuyuk_altin=gizli_altinlar.get(i);
                    }
                    }
                }
                for(i=0;i<altinlar.size();i++){
                    if(enbuyuk_altin<=altinlar.get(i)){
                        enbuyuk_altin=altinlar.get(i);
                    }
                }
                for(i=0;i<altinlar.size();i++){
                    if(enbuyuk_altin==altinlar.get(i)){
                        enbuyuk_kordin.add(rastgele_kordinatlar.get(i));
                    }
                }
               
                for(i=0;i<gizli_altinlar.size();i++){
                    if(izin.get(i)!=-1 && ikikere.get(i)==1 && rastgele_kordinatlar.get(i)!=-1 ){
                    if(enbuyuk_altin<=gizli_altinlar.get(i)+altinlar.get(i)){
                        enbuyuk_altin=gizli_altinlar.get(i)+altinlar.get(i);
                    }
                    }
                }
                
                for(i=0;i<gizli_altinlar.size();i++){
                    if(enbuyuk_altin==gizli_altinlar.get(i) && izin.get(i)!=-1 && ikikere.get(i)==1){
                        enbuyuk_kordin.add(kirmizi_kordinatlar.get(i));
                    }
                }
                for(i=0;i<rastgele_kordinatlar.size();i++){
                    if(rastgele_kordinatlar.get(i)!=-1){
                temp10=Math.abs((kordin[rastgele_kordinatlar.get(i)][1]-player2.getY())*(kordin[rastgele_kordinatlar.get(i)][1]-player2.getY()))
                +Math.abs((kordin[rastgele_kordinatlar.get(i)][0]-player2.getX())*(kordin[rastgele_kordinatlar.get(i)][0]-player2.getX()));
                for(j=0;j<enbuyuk_kordin.size();j++){
                    if(rastgele_kordinatlar.get(i)==enbuyuk_kordin.get(j) && temp10<enyakin){
                        b2_tut=b_tut;
                        enyakin=temp10;
                        b_tut=rastgele_kordinatlar.get(i);
                    }
                }
            }
                
                }
              for(i=0;i<izin.size();i++){
                if(izin.get(i)!=-1 && ikikere.get(i)==1){
                temp10=Math.abs((kordin[izin.get(i)][1]-player2.getY())*(kordin[izin.get(i)][1]-player2.getY()))
                +Math.abs((kordin[izin.get(i)][0]-player2.getX())*(kordin[izin.get(i)][0]-player2.getX()));
         
                for(j=0;j<enbuyuk_kordin.size();j++){
                    if(izin.get(i)==enbuyuk_kordin.get(j) && temp10<enyakin){
                     b2_tut=b_tut;
                        enyakin=temp10;
                      b_tut=izin.get(i);
                      mavi_tut=b_tut;
                    }
                }
            }
               
                }
                    for(i=0;i<izin.size();i++){
                if(izin.get(i)!=-1 && ikikere.get(i)==1){
                temp10=Math.abs((kordin[izin.get(i)][1]-player2.getY())*(kordin[izin.get(i)][1]-player2.getY()))
                +Math.abs((kordin[izin.get(i)][0]-player2.getX())*(kordin[izin.get(i)][0]-player2.getX()));
         
                for(j=0;j<enbuyuk_kordin.size();j++){
                    if(izin.get(i)==enbuyuk_kordin.get(j) && temp10<enyakin){
                      b2_tut=b_tut;
                        enyakin=temp10;
                      b_tut=izin.get(i);
                      mavi_tut_tut=b_tut;
                    }
               }
            }
               }
               
                player2.setKasadaki_altin_miktari(player2.getKasadaki_altin_miktari()-10);
                b_array=dijkstra2(komsuluk_matrisi2, player2.getX()+(player2.getY()/20));
                player2.setHarcanan_altin_miktari(player2.getHarcanan_altin_miktari()+10);
//                if(mavi_izin==1){
//                    int bayrak=0;
//                   for(i=0;i<izin.size();i++){
//                            if(izin.get(i)==player2.getX()+(player2.getY()/20)){
//                                    bayrak=1;
//                                    break;
//                    }
//                    }
//                   for(i=0;i<8;i++){
//                        if(kirmizi_kordinatlar.get(i)==player2.getX()+(player2.getY()/20) && bayrak==0 && ikikere.get(i)==1){
//                                    izin.set(i,kirmizi_kordinatlar.get(i));
//                                    }
//                               }
//                   
//                }
            }
            
            try{
            
            for(i=0;i<8;i++){
                if(izin.get(i)!=-1){
                if(player2.getX()==kordin[kirmizi_kordinatlar.get(i)][0] && player2.getY()==kordin[kirmizi_kordinatlar.get(i)][1] && ikikere.get(i)==1){
                    isaret=1;
                }
                }
            }
            if(player2.getX() + (player2.getY()/20)==b_tut  && mavi_tut==b_tut){
                sayac=2;
                   b_devam=1;
                   b_adim=0;
                   b=0;
                   for(i=0;i<izin.size();i++){
                       if(izin.get(i)==b_tut){
                           int temp9=player2.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player2.setKasadaki_altin_miktari(temp9);
                           int temp8=player2.getToplanan_altin_miktari()+ altinlar.get(i);
                           player2.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                   for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==b_tut){
                           if(altinlar.size()!=i){
                           int temp9=player2.getKasadaki_altin_miktari() + altinlar.get(i);
                           player2.setKasadaki_altin_miktari(temp9);
                           int temp8=player2.getToplanan_altin_miktari()+ altinlar.get(i);
                           player2.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   x_boolean=true;
                   }
                
                utm=0;
                
            }
            if(player2.getX() + (player2.getY()/20)==b_tut  && mavi_tut==b_tut){
                    
                   b_tut=b2_tut;
                   sayac=2;
                   b_devam=1;
                   b_adim=0;
                   b=0;
                   for(i=0;i<izin.size();i++){
                       if(izin.get(i)==b_tut){
                           int temp9=player2.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player2.setKasadaki_altin_miktari(temp9);
                           int temp8=player2.getToplanan_altin_miktari()+ altinlar.get(i);
                           player2.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                   for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==b_tut){
                           if(altinlar.size()!=i){
                           int temp9=player2.getKasadaki_altin_miktari() + altinlar.get(i);
                           player2.setKasadaki_altin_miktari(temp9);
                           int temp8=player2.getToplanan_altin_miktari()+ altinlar.get(i);
                           player2.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   x_boolean=true;
                   }
                
                utm=0;
                
            }
            else if(player2.getX() + (player2.getY()/20)==b_tut  && mavi_tut_tut==b_tut){
                sayac=2;
                   b_devam=1;
                   b_adim=0;
                   b=0;
                   for(i=0;i<izin.size();i++){
                       if(izin.get(i)==b_tut){
                           int temp9=player2.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player2.setKasadaki_altin_miktari(temp9);
                           int temp8=player2.getToplanan_altin_miktari()+ altinlar.get(i);
                           player2.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                   for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==b_tut){
                           if(altinlar.size()!=i){
                           int temp9=player2.getKasadaki_altin_miktari() + altinlar.get(i);
                           player2.setKasadaki_altin_miktari(temp9);
                           int temp8=player2.getToplanan_altin_miktari()+ altinlar.get(i);
                           player2.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                utm=0;
                
            }
            
            else if(isaret==1 && x_boolean==true){
                sayac=2;
                   b_devam=1;
                   b=0;
                   b_adim=0; 
                for(i=0;i<izin.size();i++){
                       if(izin.get(i)==b_tut){
                           int temp9=player2.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player2.setKasadaki_altin_miktari(temp9);
                           int temp8=player2.getToplanan_altin_miktari()+ altinlar.get(i);
                           player2.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                }
                       
                
                for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==b_tut){
                           if(altinlar.size()!=i){
                           int temp9=player2.getKasadaki_altin_miktari() + altinlar.get(i);
                           player2.setKasadaki_altin_miktari(temp9);
                           int temp8=player2.getToplanan_altin_miktari()+ altinlar.get(i);
                           player2.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                    x_boolean=false;
                   isaret=0;
                utm=0;
            }
            else if(b_array.get(b_tut).size()==0){
                sayac=2;
                   b_devam=1;
                   b_adim=0;
                   b=0;
//                   for(i=0;i<rastgele_kordinatlar.size();i++){
//                       if(rastgele_kordinatlar.get(i)==b_tut){
//                           if(altinlar.size()!=i){
//                           int temp9=player2.getKasadaki_altin_miktari() + altinlar.get(i);
//                           player2.setKasadaki_altin_miktari(temp9);
//                           }
//                           rastgele_kordinatlar.set(i, -1);
//                           altinlar.set(i, -1);
//                           break;
//                           
//                       }
//                   }
                   
                    utm=0;
                }
            else if(player2.getX()==kordin[b_array.get(b_tut).get(b_array.get(b_tut).size()-1)][0] && player2.getY()==kordin[b_array.get(b_tut).get(b_array.get(b_tut).size()-1)][1] && mavi_tut!=b_tut){
                 
                 sayac=2;
                   b_devam=1;
                   b_adim=0;
                   b=0;
                 for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==b_tut){
                           if(altinlar.size()!=i){
                           int temp9=player2.getKasadaki_altin_miktari() + altinlar.get(i);
                           player2.setKasadaki_altin_miktari(temp9);
                           int temp8=player2.getToplanan_altin_miktari()+ altinlar.get(i);
                           player2.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                 x_boolean=true;
                 System.out.println(player2.getKasadaki_altin_miktari());
                   
                }
            else if(player2.getX()==kordin[b_array.get(b_tut).get(b_array.get(b_tut).size()-1)][0] && player2.getY()==kordin[b_array.get(b_tut).get(b_array.get(b_tut).size()-1)][1] && mavi_tut!=b_tut ){
                   sayac=2;
                   b_devam=1;
                   b_adim=0;
                   b=0;
                 for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==b_tut){
                           if(altinlar.size()!=i){
                           int temp9=player2.getKasadaki_altin_miktari() + altinlar.get(i);
                           player2.setKasadaki_altin_miktari(temp9);
                           int temp8=player2.getToplanan_altin_miktari()+ altinlar.get(i);
                           player2.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                 x_boolean=true;
                 System.out.println(player2.getKasadaki_altin_miktari());
                }
             
                else if(b==3){
                        sayac=2;
                        b_devam=0;
                        b=0;
                        int bayrak=0;
                        for(i=0;i<izin.size();i++){
                            if(izin.get(i)==player2.getX()+(player2.getY()/20)){
                            bayrak=1;
                        break;
                    }
                    }
                    for(i=0;i<8;i++){
                        if(kirmizi_kordinatlar.get(i)==player2.getX()+(player2.getY()/20) && bayrak==0 && ikikere.get(i)==1){
                        izin.set(i,kirmizi_kordinatlar.get(i));
                    }
                }
                    mavi_izin=1;
                        player2.setX(kordin[b_array.get(b_tut).get(b_adim)][0]);
                        player2.setY(kordin[b_array.get(b_tut).get(b_adim)][1]);
                        utm=0;
                player2.setToplam_adim_sayisi(player2.getKasadaki_altin_miktari()-5);
                player2.setHarcanan_altin_miktari(player2.getHarcanan_altin_miktari()+5);
                x_boolean=true;
                        }
            else{
                
                if(mavi_izin==1){
                    int bayrak=0;
                   for(i=0;i<izin.size();i++){
                            if(izin.get(i)==player2.getX()+(player2.getY()/20)){
                                    bayrak=1;
                                    break;
                    }
                    }
                   for(i=0;i<8;i++){
                        if(kirmizi_kordinatlar.get(i)==player2.getX()+(player2.getY()/20) && bayrak==0 && ikikere.get(i)==1){
                                    izin.set(i,kirmizi_kordinatlar.get(i));
                                    }
                               }
                   
                }
                player2.setX(kordin[b_array.get(b_tut).get(b_adim)][0]);
                player2.setY(kordin[b_array.get(b_tut).get(b_adim)][1]);
                
                player2.setToplam_adim_sayisi(player2.getToplam_adim_sayisi()+1);
                x_boolean=true;
                b_adim++;
                b++;
            }
            }
            catch (Exception e) {
                b=0;
                b_adim=0;
                b_devam=1;
                sayac=2;
    }
             
            repaint();
        }
        
        else if(rastgele_kordinatlar.size()>0 && sayac==2 && player3.getKasadaki_altin_miktari()>=10){
        
            int enbuyuk_altin=0;
            if(c==0 && c_devam==1){
                
                for(i=0;i<kirmizi_kordinatlar.size();i++){
                    if(kirmizi_kordinatlar.get(i)!=-1){
                temp10=Math.abs((kordin[kirmizi_kordinatlar.get(i)][1]-player3.getY())*(kordin[kirmizi_kordinatlar.get(i)][1]-player3.getY()))
                +Math.abs((kordin[kirmizi_kordinatlar.get(i)][0]-player3.getX())*(kordin[kirmizi_kordinatlar.get(i)][0]-player3.getX()));
                
                    if(izin.get(i)==-1){
                      uzakliklar.add(temp10);
                    
                }
                    else{
                        uzakliklar.add(-1);
                    }
                    }
                }
                int z=9999999;
                int c=0;
                int c2=0;
                for(i=0;i<uzakliklar.size();i++){
                    if(uzakliklar.get(i)<z && uzakliklar.get(i)!=-1){
                        z=uzakliklar.get(i);
                        c=i;
                    }
                }
                uzakliklar.set(c, 999999);
                z=9999999;
                for(i=0;i<uzakliklar.size();i++){
                    if(uzakliklar.get(i)<z && uzakliklar.get(i)!=-1){
                        z=uzakliklar.get(i);
                        c2=i;
                    }
                }
                uzakliklar.set(c2, 999999);
                if(uzakliklar.get(c)==999999){
                iki_kordinat.add(kirmizi_kordinatlar.get(c));
                }
                if(uzakliklar.get(c2)==999999){
                iki_kordinat.add(kirmizi_kordinatlar.get(c2));
                }
                uzakliklar.clear();
                int bayrak2=0;
                   for(i=0;i<8;i++){
                       for(j=0;j<iki_kordinat.size();j++){
                            if(izin.get(i)==iki_kordinat.get(j)){
                                    bayrak2=1;
                                    break;
                            }
                    }
                    }
                   for(i=0;i<8;i++){
                       for(j=0;j<iki_kordinat.size();j++){
                        if(kirmizi_kordinatlar.get(i)==iki_kordinat.get(j) && bayrak2==0 && ikikere.get(i)==1){
                                    izin.set(i,kirmizi_kordinatlar.get(i));
                                    }
                               }
                   }
                for(i=0;i<altinlar.size();i++){
                    if(enbuyuk_altin<=altinlar.get(i)){
                        enbuyuk_altin=altinlar.get(i);
                    }
                }
                for(i=0;i<altinlar.size();i++){
                    if(enbuyuk_altin==altinlar.get(i)){
                        enbuyuk_kordin.add(rastgele_kordinatlar.get(i));
                    }
                }
                for(i=0;i<gizli_altinlar.size();i++){
                    if(izin.get(i)!=-1 && ikikere.get(i)==1 && rastgele_kordinatlar.get(i)!=-1){
                    if(enbuyuk_altin<=gizli_altinlar.get(i)+altinlar.get(i)){
                        enbuyuk_altin=gizli_altinlar.get(i)+altinlar.get(i);
                    }
                    }
                }
                for(i=0;i<gizli_altinlar.size();i++){
                    if(enbuyuk_altin==gizli_altinlar.get(i)+altinlar.get(i) && izin.get(i)!=-1 && ikikere.get(i)==1){
                        enbuyuk_kordin.add(izin.get(i));
                    }
                }
                for(i=0;i<gizli_altinlar.size();i++){
                    if(izin.get(i)!=-1 && ikikere.get(i)==1){
                    if(enbuyuk_altin<=gizli_altinlar.get(i)){
                        enbuyuk_altin=gizli_altinlar.get(i);
                    }
                    }
                }
                for(i=0;i<gizli_altinlar.size();i++){
                    if(enbuyuk_altin==gizli_altinlar.get(i) && izin.get(i)!=-1 && ikikere.get(i)==1){
                        enbuyuk_kordin.add(izin.get(i));
                    }
                }
               
                
                for(i=0;i<rastgele_kordinatlar.size();i++){
                    if(rastgele_kordinatlar.get(i)!=-1){
                temp10=Math.abs((kordin[rastgele_kordinatlar.get(i)][1]-player3.getY())*(kordin[rastgele_kordinatlar.get(i)][1]-player3.getY()))
                +Math.abs((kordin[rastgele_kordinatlar.get(i)][0]-player3.getX())*(kordin[rastgele_kordinatlar.get(i)][0]-player3.getX()));
                for(j=0;j<enbuyuk_kordin.size();j++){
                    if(rastgele_kordinatlar.get(i)==enbuyuk_kordin.get(j) && temp10<enyakin){
                      enyakin=temp10;
                      c_tut=rastgele_kordinatlar.get(i);
                    }
                }
            }
                }
                
                
              for(i=0;i<izin.size();i++){
                if(izin.get(i)!=-1 && ikikere.get(i)==1){
                temp10=Math.abs((kordin[izin.get(i)][1]-player3.getY())*(kordin[izin.get(i)][1]-player3.getY()))
                +Math.abs((kordin[izin.get(i)][0]-player3.getX())*(kordin[izin.get(i)][0]-player3.getX()));
         
                for(j=0;j<enbuyuk_kordin.size();j++){
                    if(izin.get(i)==enbuyuk_kordin.get(j) && temp10<enyakin){
                      enyakin=temp10;
                      c_tut=izin.get(i);
                      yesil_tut=c_tut;
                    }
                }
            }
               }
               
                player3.setKasadaki_altin_miktari(player3.getKasadaki_altin_miktari()-10);
                c_array=dijkstra2(komsuluk_matrisi2, player3.getX()+(player3.getY()/20));
                player3.setHarcanan_altin_miktari(player3.getHarcanan_altin_miktari()+10);
                if(yesil_izin==1){
                    int bayrak=0;
                   for(i=0;i<izin.size();i++){
                            if(izin.get(i)==player3.getX()+(player3.getY()/20)){
                                    bayrak=1;
                                    break;
                    }
                    }
                   for(i=0;i<8;i++){
                        if(kirmizi_kordinatlar.get(i)==player3.getX()+(player3.getY()/20) && bayrak==0 && ikikere.get(i)==1){
                                    izin.set(i,kirmizi_kordinatlar.get(i));
                                    }
                               }
                   
                                    yesil_izin=0;
                }
            }
            
            
            try{
            
            yesil_izin=0;
            for(i=0;i<8;i++){
                if(izin.get(i)!=-1){
                if(player3.getX()==kordin[izin.get(i)][0] && player3.getY()==kordin[izin.get(i)][1] && ikikere.get(i)==1){
                    isaret=1;
                }
                }
            }
            if(player3.getX() + (player3.getY()/20)==c_tut  && yesil_tut==c_tut){
                sayac=3;
                   c_devam=1;
                   c_adim=0;
                   c=0;
                   for(i=0;i<izin.size();i++){
                       if(izin.get(i)==c_tut){
                           int temp9=player3.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player3.setKasadaki_altin_miktari(temp9);
                           int temp8=player3.getToplanan_altin_miktari()+ altinlar.get(i);
                           player3.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                   for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==c_tut){
                           if(altinlar.size()!=i){
                           int temp9=player3.getKasadaki_altin_miktari() + altinlar.get(i);
                           player3.setKasadaki_altin_miktari(temp9);
                           int temp8=player3.getToplanan_altin_miktari()+ altinlar.get(i);
                           player3.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                
                
                
            }
            
            else if(isaret==1){
                sayac=3;
                   c_devam=1;
                   c=0;
                   c_adim=0; 
                for(i=0;i<izin.size();i++){
                       if(izin.get(i)==c_tut){
                           int temp9=player3.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player3.setKasadaki_altin_miktari(temp9);
                           int temp8=player3.getToplanan_altin_miktari()+ altinlar.get(i);
                           player3.setToplanan_altin_miktari(temp8);
                           for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==c_tut){
                           if(altinlar.size()!=i){
                           int temp9=player3.getKasadaki_altin_miktari() + altinlar.get(i);
                           player3.setKasadaki_altin_miktari(temp9);
                           int temp8=player3.getToplanan_altin_miktari()+ altinlar.get(i);
                           player3.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
            }
            else if(c_array.get(c_tut).size()==0){
                sayac=3;
                   c_devam=1;
                   c_adim=0;
                   c=0;
//                   for(i=0;i<rastgele_kordinatlar.size();i++){
//                       if(rastgele_kordinatlar.get(i)==b_tut){
//                           if(altinlar.size()!=i){
//                           int temp9=player2.getKasadaki_altin_miktari() + altinlar.get(i);
//                           player2.setKasadaki_altin_miktari(temp9);
//                           }
//                           rastgele_kordinatlar.set(i, -1);
//                           altinlar.set(i, -1);
//                           break;
//                           
//                       }
//                   }
                   
                    
                }
            
            else if(player3.getX()==kordin[c_array.get(c_tut).get(c_array.get(c_tut).size()-1)][0] && player3.getY()==kordin[c_array.get(c_tut).get(c_array.get(c_tut).size()-1)][1] && yesil_tut!=c_tut){
                   sayac=3;
                   c_devam=1;
                   c_adim=0;
                   c=0;
                 for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==c_tut){
                           if(altinlar.size()!=i){
                           int temp9=player3.getKasadaki_altin_miktari() + altinlar.get(i);
                           player3.setKasadaki_altin_miktari(temp9);
                           int temp8=player3.getToplanan_altin_miktari()+ altinlar.get(i);
                           player3.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                   yesil_izin=1;
                }
                    else if(c==3){
                        sayac=3;
                        c_devam=0;
                        c=0;
                        int bayrak=0;
                        for(i=0;i<izin.size();i++){
                            if(izin.get(i)==player3.getX()+(player3.getY()/20)){
                            bayrak=1;
                        break;
                    }
                    }
                    for(i=0;i<8;i++){
                    if(kirmizi_kordinatlar.get(i)==player3.getX()+(player3.getY()/20) && bayrak==0 && ikikere.get(i)==1){
                    izin.set(i,kirmizi_kordinatlar.get(i));
                    }
                }
                        player3.setX(kordin[c_array.get(c_tut).get(c_adim)][0]);
                        player3.setY(kordin[c_array.get(c_tut).get(c_adim)][1]);
                        
                        
                player3.setHarcanan_altin_miktari(player3.getHarcanan_altin_miktari()+5);
                player3.setToplam_adim_sayisi(player3.getKasadaki_altin_miktari()-5);
                player3.setHarcanan_altin_miktari(player3.getHarcanan_altin_miktari()+5);
            }
            else{
                        int bayrak=0;
        for(i=0;i<izin.size();i++){
            	if(izin.get(i)==player3.getX()+(player3.getY()/20)){
		bayrak=1;
		break;
        }
        }
        for(i=0;i<8;i++){
	if(kirmizi_kordinatlar.get(i)==player3.getX()+(player3.getY()/20) && bayrak==0 && ikikere.get(i)==1){
                   izin.set(i,kirmizi_kordinatlar.get(i));
                   }
           }
                player3.setX(kordin[c_array.get(c_tut).get(c_adim)][0]);
                player3.setY(kordin[c_array.get(c_tut).get(c_adim)][1]);
                player3.setToplam_adim_sayisi(player3.getToplam_adim_sayisi()+1);
                
                c_adim++;
                c++;
            }
            }
            catch (Exception e) {
                c=0;
                c_adim=0;
                c_devam=1;
                sayac=3;
      System.out.println("Something went wrong.");
    }
            repaint();
            
        }
        
        else if(sayac==3){
            
            
            
            int enbuyuk_altin=0;
            if(d==0 && d_devam==1){
                
                
                for(i=0;i<gizli_altinlar.size();i++){
                    if(enbuyuk_altin==gizli_altinlar.get(i)+altinlar.get(i) && izin.get(i)!=-1 && ikikere.get(i)==1){
                        enbuyuk_kordin.add(kirmizi_kordinatlar.get(i));
                        utm=1;
                        System.out.println("Enbuyukkordin mavi icin");
                    }
                }
                for(i=0;i<gizli_altinlar.size();i++){
                    if(izin.get(i)!=-1 && ikikere.get(i)==1){
                    if(enbuyuk_altin<=gizli_altinlar.get(i)){
                        enbuyuk_altin=gizli_altinlar.get(i);
                    }
                    }
                }
                for(i=0;i<altinlar.size();i++){
                    if(enbuyuk_altin<=altinlar.get(i)){
                        enbuyuk_altin=altinlar.get(i);
                    }
                }
                for(i=0;i<altinlar.size();i++){
                    if(enbuyuk_altin==altinlar.get(i)){
                        enbuyuk_kordin.add(rastgele_kordinatlar.get(i));
                    }
                }
               
                for(i=0;i<gizli_altinlar.size();i++){
                    if(izin.get(i)!=-1 && ikikere.get(i)==1 && rastgele_kordinatlar.get(i)!=-1 ){
                    if(enbuyuk_altin<=gizli_altinlar.get(i)+altinlar.get(i)){
                        enbuyuk_altin=gizli_altinlar.get(i)+altinlar.get(i);
                    }
                    }
                }
                
                for(i=0;i<gizli_altinlar.size();i++){
                    if(enbuyuk_altin==gizli_altinlar.get(i) && izin.get(i)!=-1 && ikikere.get(i)==1){
                        enbuyuk_kordin.add(kirmizi_kordinatlar.get(i));
                    }
                }
                for(i=0;i<rastgele_kordinatlar.size();i++){
                    if(rastgele_kordinatlar.get(i)!=-1){
                temp10=Math.abs((kordin[rastgele_kordinatlar.get(i)][1]-player4.getY())*(kordin[rastgele_kordinatlar.get(i)][1]-player4.getY()))
                +Math.abs((kordin[rastgele_kordinatlar.get(i)][0]-player4.getX())*(kordin[rastgele_kordinatlar.get(i)][0]-player4.getX()));
                for(j=0;j<enbuyuk_kordin.size();j++){
                    if(rastgele_kordinatlar.get(i)==enbuyuk_kordin.get(j) && temp10<enyakin){
                    
                        enyakin=temp10;
                        d_tut=rastgele_kordinatlar.get(i);
                    }
                }
            }
                
                }
              for(i=0;i<izin.size();i++){
                if(izin.get(i)!=-1 && ikikere.get(i)==1){
                temp10=Math.abs((kordin[izin.get(i)][1]-player4.getY())*(kordin[izin.get(i)][1]-player4.getY()))
                +Math.abs((kordin[izin.get(i)][0]-player4.getX())*(kordin[izin.get(i)][0]-player4.getX()));
         
                for(j=0;j<enbuyuk_kordin.size();j++){
                    if(izin.get(i)==enbuyuk_kordin.get(j) && temp10<enyakin){
                        enyakin=temp10;
                      d_tut=izin.get(i);
                      sari_tut=d_tut;
                    }
                }
            }
               
                }
                    for(i=0;i<izin.size();i++){
                if(izin.get(i)!=-1 && ikikere.get(i)==1){
                temp10=Math.abs((kordin[izin.get(i)][1]-player4.getY())*(kordin[izin.get(i)][1]-player4.getY()))
                +Math.abs((kordin[izin.get(i)][0]-player4.getX())*(kordin[izin.get(i)][0]-player4.getX()));
         
                for(j=0;j<enbuyuk_kordin.size();j++){
                    if(izin.get(i)==enbuyuk_kordin.get(j) && temp10<enyakin){
                      
                        enyakin=temp10;
                      d_tut=izin.get(i);
                      sari_tut_tut=d_tut;
                    }
               }
            }
               }
               
                player4.setKasadaki_altin_miktari(player4.getKasadaki_altin_miktari()-10);
                d_array=dijkstra2(komsuluk_matrisi2, player4.getX()+(player4.getY()/20));
                player4.setHarcanan_altin_miktari(player4.getHarcanan_altin_miktari()+20);
//                if(mavi_izin==1){
//                    int bayrak=0;
//                   for(i=0;i<izin.size();i++){
//                            if(izin.get(i)==player2.getX()+(player2.getY()/20)){
//                                    bayrak=1;
//                                    break;
//                    }
//                    }
//                   for(i=0;i<8;i++){
//                        if(kirmizi_kordinatlar.get(i)==player2.getX()+(player2.getY()/20) && bayrak==0 && ikikere.get(i)==1){
//                                    izin.set(i,kirmizi_kordinatlar.get(i));
//                                    }
//                               }
//                   
//                }
            }
            
            try{
            
            for(i=0;i<8;i++){
                if(izin.get(i)!=-1){
                if(player4.getX()==kordin[kirmizi_kordinatlar.get(i)][0] && player4.getY()==kordin[kirmizi_kordinatlar.get(i)][1] && ikikere.get(i)==1){
                    isaret2=1;
                }
                }
            }
            if(player4.getX() + (player4.getY()/20)==d_tut  && sari_tut==d_tut){
                sayac=4;
                   d_devam=1;
                   d_adim=0;
                   d=0;
                   for(i=0;i<izin.size();i++){
                       if(izin.get(i)==d_tut){
                           int temp9=player4.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player4.setKasadaki_altin_miktari(temp9);
                           int temp8=player4.getToplanan_altin_miktari()+ altinlar.get(i);
                           player4.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                   for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==d_tut){
                           if(altinlar.size()!=i){
                           int temp9=player4.getKasadaki_altin_miktari() + altinlar.get(i);
                           player4.setKasadaki_altin_miktari(temp9);
                           int temp8=player4.getToplanan_altin_miktari()+ altinlar.get(i);
                           player4.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   y_boolean=true;
                   }
                
                player4.setHarcanan_altin_miktari(player4.getHarcanan_altin_miktari()+5);
                player4.setKasadaki_altin_miktari(player4.getKasadaki_altin_miktari()-5);
                utm=0;
                
            }
            if(player4.getX() + (player4.getY()/20)==d_tut  && sari_tut==d_tut){
                    
                   sayac=4;
                   d_devam=1;
                   d_adim=0;
                   d=0;
                   for(i=0;i<izin.size();i++){
                       if(izin.get(i)==d_tut){
                           int temp9=player4.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player4.setKasadaki_altin_miktari(temp9);
                           int temp8=player4.getToplanan_altin_miktari()+ altinlar.get(i);
                           player4.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                   for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==d_tut){
                           if(altinlar.size()!=i){
                           int temp9=player4.getKasadaki_altin_miktari() + altinlar.get(i);
                           player4.setKasadaki_altin_miktari(temp9);
                           int temp8=player4.getToplanan_altin_miktari()+ altinlar.get(i);
                           player4.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   y_boolean=true;
                   }
                
                player4.setHarcanan_altin_miktari(player4.getHarcanan_altin_miktari()+5);
                player4.setKasadaki_altin_miktari(player4.getKasadaki_altin_miktari()-5);
                utm=0;
                
            }
            else if(player4.getX() + (player4.getY()/20)==d_tut  && sari_tut_tut==d_tut){
                sayac=4;
                   d_devam=1;
                   d_adim=0;
                   d=0;
                   for(i=0;i<izin.size();i++){
                       if(izin.get(i)==d_tut){
                           int temp9=player4.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player4.setKasadaki_altin_miktari(temp9);
                           int temp8=player4.getToplanan_altin_miktari()+ altinlar.get(i);
                           player4.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                   for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==d_tut){
                           if(altinlar.size()!=i){
                           int temp9=player4.getKasadaki_altin_miktari() + altinlar.get(i);
                           player4.setKasadaki_altin_miktari(temp9);
                           int temp8=player4.getToplanan_altin_miktari()+ altinlar.get(i);
                           player4.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                utm=0;
                
             player4.setKasadaki_altin_miktari(player4.getKasadaki_altin_miktari()-5);
                player4.setHarcanan_altin_miktari(player4.getHarcanan_altin_miktari()+5);  
            }
            
            else if(isaret2==1 && y_boolean==true){
                sayac=4;
                   d_devam=1;
                   d=0;
                   d_adim=0; 
                for(i=0;i<izin.size();i++){
                       if(izin.get(i)==d_tut){
                           int temp9=player4.getKasadaki_altin_miktari() + gizli_altinlar.get(i);
                           player4.setKasadaki_altin_miktari(temp9);
                           int temp8=player4.getToplanan_altin_miktari()+ altinlar.get(i);
                           player4.setToplanan_altin_miktari(temp8);
                          for(j=0;j<iki_kordinat.size();j++){
                               if(iki_kordinat.get(j)==izin.get(i)){
                                   iki_kordinat.remove(j);
                               }
                           }
                           izin.set(i, -1);
                           ikikere.set(i, -1);
                           gizli_altinlar.set(i, -1);
                           break;
                           
                       }
                }
                       
                
                for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==d_tut){
                           if(altinlar.size()!=i){
                           int temp9=player4.getKasadaki_altin_miktari() + altinlar.get(i);
                           player4.setKasadaki_altin_miktari(temp9);
                           int temp8=player4.getToplanan_altin_miktari()+ altinlar.get(i);
                           player4.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                    y_boolean=true;
                   isaret2=0;
                   player4.setKasadaki_altin_miktari(player4.getKasadaki_altin_miktari()-5);
                player4.setHarcanan_altin_miktari(player4.getHarcanan_altin_miktari()+5);
                utm=0;
            }
            else if(d_array.get(d_tut).size()==0){
                sayac=4;
                   d_devam=1;
                   d_adim=0;
                   d=0;
//                   for(i=0;i<rastgele_kordinatlar.size();i++){
//                       if(rastgele_kordinatlar.get(i)==b_tut){
//                           if(altinlar.size()!=i){
//                           int temp9=player2.getKasadaki_altin_miktari() + altinlar.get(i);
//                           player2.setKasadaki_altin_miktari(temp9);
//                           }
//                           rastgele_kordinatlar.set(i, -1);
//                           altinlar.set(i, -1);
//                           break;
//                           
//                       }
//                   }
                   
                    utm=0;
                }
            
            else if(player4.getX()==kordin[d_array.get(d_tut).get(d_array.get(d_tut).size()-1)][0] && player4.getY()==kordin[d_array.get(d_tut).get(d_array.get(d_tut).size()-1)][1] && sari_tut!=d_tut){
                   sayac=4;
                   d_devam=1;
                   d_adim=0;
                   d=0;
                 for(i=0;i<rastgele_kordinatlar.size();i++){
                       if(rastgele_kordinatlar.get(i)==d_tut){
                           if(altinlar.size()!=i){
                           int temp9=player4.getKasadaki_altin_miktari() + altinlar.get(i);
                           player4.setKasadaki_altin_miktari(temp9);
                           int temp8=player4.getToplanan_altin_miktari()+ altinlar.get(i);
                           player4.setToplanan_altin_miktari(temp8);
                           }
                           rastgele_kordinatlar.set(i, -1);
                           altinlar.set(i, -1);
                           break;
                           
                       }
                   }
                 y_boolean=false;
                 player4.setKasadaki_altin_miktari(player4.getKasadaki_altin_miktari()-5);
                player4.setHarcanan_altin_miktari(player4.getHarcanan_altin_miktari()+5);
                }
             
                else if(d==3){
                        sayac=0;
                        d_devam=0;
                        d=0;
                        int bayrak=0;
                        for(i=0;i<izin.size();i++){
                            if(izin.get(i)==player4.getX()+(player4.getY()/20)){
                            bayrak=1;
                        break;
                    }
                    }
                    for(i=0;i<8;i++){
                        if(kirmizi_kordinatlar.get(i)==player4.getX()+(player4.getY()/20) && bayrak==0 && ikikere.get(i)==1){
                        izin.set(i,kirmizi_kordinatlar.get(i));
                    }
                }
                    sari_izin=1;
                        player4.setX(kordin[d_array.get(d_tut).get(d_adim)][0]);
                        player4.setY(kordin[d_array.get(d_tut).get(d_adim)][1]);
                        utm=0;
                        
                        player4.setKasadaki_altin_miktari(player4.getKasadaki_altin_miktari()-5);
                player4.setHarcanan_altin_miktari(player4.getHarcanan_altin_miktari()+5);
                
                y_boolean=true;
                        }
            else{
                
                if(sari_izin==1){
                    int bayrak=0;
                   for(i=0;i<izin.size();i++){
                            if(izin.get(i)==player4.getX()+(player4.getY()/20)){
                                    bayrak=1;
                                    break;
                    }
                    }
                   for(i=0;i<8;i++){
                        if(kirmizi_kordinatlar.get(i)==player4.getX()+(player4.getY()/20) && bayrak==0 && ikikere.get(i)==1){
                                    izin.set(i,kirmizi_kordinatlar.get(i));
                                    }
                               }
                   
                }
                player4.setX(kordin[d_array.get(d_tut).get(d_adim)][0]);
                player4.setY(kordin[d_array.get(d_tut).get(d_adim)][1]);
               
                player4.setToplam_adim_sayisi(player4.getToplam_adim_sayisi()+1);
                y_boolean=true;
                d_adim++;
                d++;
            }
            }
            catch (Exception e) {
                d=0;
                d_adim=0;
                d_devam=1;
                sayac=0;
            }
            
            repaint();
    }
           else if(sayac==4){
            
            int bayrak5=0;
            for(i=0;i<72;i++){
                if(rastgele_kordinatlar.get(i)>=0){
                    bayrak5=1;
                    break;
                }
            }
            for(i=0;i<8;i++){
                if(izin.get(i)>=0){
                    bayrak5=1;
                    break;
                }
            }
            if(bayrak5==0){
                Sonuc sonuc = new Sonuc(player1, player2, player3, player4);
                sonuc.setVisible(true);
                sayac=5;
                setVisible(false);
                
            }
            if(sayac==5){
             sayac=5;   
            }
            else{
            sayac=0;
            }
        }
        
        
    }
             
        
        
    
        
    
}


