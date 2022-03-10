
import java.awt.Image;
import java.awt.image.BufferedImage;


public class Player {
      
    private String kullanici;
    private int toplam_adim_sayisi;
    private int harcanan_altin_miktari;
    private int kasadaki_altin_miktari;
    private int toplanan_altin_miktari;
    private int x;
    private int y;
    private Image image;


    public Player(String kullanici, int toplam_adim_sayisi, int harcanan_altin_miktari, int kasadaki_altin_miktari, int toplanan_altin_miktari,int x,int y,Image image) {
        this.kullanici = kullanici;
        this.toplam_adim_sayisi = toplam_adim_sayisi;
        this.harcanan_altin_miktari = harcanan_altin_miktari;
        this.kasadaki_altin_miktari = kasadaki_altin_miktari;
        this.toplanan_altin_miktari = toplanan_altin_miktari;
        this.x=x;
        this.y=y;
        this.image=image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * @return the kullanici
     */
    public String getKullanici() {
        return kullanici;
    }

    /**
     * @param kullanici the kullanici to set
     */
    public void setKullanici(String kullanici) {
        this.kullanici = kullanici;
    }

    /**
     * @return the toplam_adim_sayisi
     */
    public int getToplam_adim_sayisi() {
        return toplam_adim_sayisi;
    }

    /**
     * @param toplam_adim_sayisi the toplam_adim_sayisi to set
     */
    public void setToplam_adim_sayisi(int toplam_adim_sayisi) {
        this.toplam_adim_sayisi = toplam_adim_sayisi;
    }

    /**
     * @return the harcanan_altin_miktari
     */
    public int getHarcanan_altin_miktari() {
        return harcanan_altin_miktari;
    }

    /**
     * @param harcanan_altin_miktari the harcanan_altin_miktari to set
     */
    public void setHarcanan_altin_miktari(int harcanan_altin_miktari) {
        this.harcanan_altin_miktari = harcanan_altin_miktari;
    }

    /**
     * @return the kasadaki_altin_miktari
     */
    public int getKasadaki_altin_miktari() {
        return kasadaki_altin_miktari;
    }

    /**
     * @param kasadaki_altin_miktari the kasadaki_altin_miktari to set
     */
    public void setKasadaki_altin_miktari(int kasadaki_altin_miktari) {
        this.kasadaki_altin_miktari = kasadaki_altin_miktari;
    }

    /**
     * @return the toplanan_altin_miktari
     */
    public int getToplanan_altin_miktari() {
        return toplanan_altin_miktari;
    }

    /**
     * @param toplanan_altin_miktari the toplanan_altin_miktari to set
     */
    public void setToplanan_altin_miktari(int toplanan_altin_miktari) {
        this.toplanan_altin_miktari = toplanan_altin_miktari;
    }


    

    
}
