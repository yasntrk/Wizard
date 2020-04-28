//Turkce karakter kullanmayiniz sonra programi baska bilgisayara atinca harfler karisiyor
import java.util.stream.IntStream;
import java.lang.Math;
import acm.program.ConsoleProgram;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import acm.program.*;
import javax.swing.*;
public class Sihirbaz extends GraphicsProgram{
	double dx = 1;double dy = 1;//Kart ve metinler icin konum vektorleri
	private int random = 1;//Rastgele kart dagitimi icin tanimlanan tam sayi
	private int kontrolDegiskeni = 0;//Kullanicinin ana menude olup olmadigini kontrol eder
	private int hakkindaAcKapa =0;//Ana menudeki cikis ve hakkinda butonu icin degisken
	private int dizilisDegiskeni = -1;//Kosulllari kontrol etmek icin degiskenler
	private int besliKartKontrol = 0;//Bes kartin oldugu ekran kosullarini kontrol etmek icin
	private int besliDegisken = 0;//Besli kart sorusuna evet derse degisken bir olur
	int k1=0;int k2=0;int k3=0;int k4=0;//Dortlu kartlarin toplanma kosulunu kontrol eder
	int l1=0; int l2=0;int l3=0;int l4=0;//Son kalan dortlu gruptaki karlari secme kosulunu kontrol eder
	int v1=0;int v2=0;//Besli kartlarin hiz vektorleri
	int v3=0;int v4=0;double v5=0;double v6=0;//Dortlu kartlardaki ilk grubun toplanmasi icin hiz vektorleri
	int v7=0;int v8=0;double v9=0;double v10=0;//Dortlu kartlardaki ikinci grubun toplanmasi icin hiz vektorleri
	int v11=0;int v12=0;double v13=0;double v14=0;//Dortlu kartlardaki ucuncu grubun toplanmasi icin hiz vektorleri
	int v15=0;int v16=0;double v17=0;double v18=0;//Dortlu kartlardaki dorduncu grubun toplanmasi icin hiz vektorleri
	int v19=0;int v20=0;int v21=0; int v22=0;//Son kalan grubun kartlarini tek tek gondermek icin hiz vektorleri
	int f=0;//Tuttugu kartin ekrana gelebilmesi icin kosul
	boolean kosul = true;//Run komutu icindeki donguyu kontrol etmek icin kosul
	GLabel tuttuguKart;//Kullanicinin tuttugu kart icin tanimlanan metin
	GLabel CikisButonu = new GLabel("Cikis");//Cikis Butonu
	GLabel SondakiCikis = new GLabel("Cikis"); // Sondaki Cikis Butonu
	GLabel SondakiAnaMenu = new GLabel("Ana Menu");//Sondaki anamenu
	GRect arkaPlan = new GRect(100000,100000);//Arka plani olusturur
	private RandomGenerator rg = new RandomGenerator();//Rastgelelik metodu
	//Dortlu kart kismindaki aciklamalar
	GLabel aciklamaa = new GLabel("Uc Defa Grup Sec");
	GLabel aciklamab = new GLabel("Uc Defa Kart Sec");
	//Kartlarin uzerindeki yazilar icin metinler olusturur ve tanimlar
	GLabel metin21= new GLabel (sayiSec());GLabel metin16= new GLabel (sayiSec());GLabel metin4 = new GLabel (sayiSec());GLabel metin7 = new GLabel (sayiSec());GLabel metin19= new GLabel (sayiSec());
	GLabel metin17= new GLabel (sayiSec());GLabel metin2 = new GLabel (sayiSec());GLabel metin3 = new GLabel (sayiSec());GLabel metin20= new GLabel (sayiSec());GLabel metin9 = new GLabel (sayiSec());
	GLabel metin6 = new GLabel (sayiSec());GLabel metin11= new GLabel (sayiSec());GLabel metin14= new GLabel (sayiSec());GLabel metin10= new GLabel (sayiSec());GLabel metin15= new GLabel (sayiSec());
	GLabel metin1 = new GLabel (sayiSec());GLabel metin12= new GLabel (sayiSec());GLabel metin8 = new GLabel (sayiSec());GLabel metin18= new GLabel (sayiSec());
	GLabel metin13= new GLabel (sayiSec());GLabel metin5= new GLabel (sayiSec());
	//Yan yana dizilen bes karti tanimlar
	GRect beslikart = new GRect(150,175);
	GRect beslikart1 = new GRect(150,175);
	GRect beslikart2 = new GRect(150,175);
	GRect beslikart3 = new GRect(150,175);
	GRect beslikart4 = new GRect(150,175);	
	//Yan yana dizilen bes adet kartin metinlerini olusturur
	GLabel besliMetin1 = metin8;GLabel besliMetin2 =metin11 ;GLabel besliMetin3 = metin12;GLabel besliMetin4 = metin17;GLabel besliMetin5 = metin18;
	GLabel besliMetin6 = metin3;GLabel besliMetin7 = metin4 ;GLabel besliMetin8 = metin15;GLabel besliMetin9 = metin16;GLabel besliMetin10 = metin19;
	GLabel besliMetin11 = metin1;GLabel besliMetin12 = metin2 ;GLabel besliMetin13 = metin7;GLabel besliMetin14 = metin10; GLabel besliMetin15= metin13;
	//Dortlu kart dizilisi icin kart tanimlar
	GRect kart1=new GRect(90,115);GRect kart2=new GRect(90,115);GRect kart3=new GRect(90,115);GRect kart4=new GRect(90,115);
	GRect kart5=new GRect(90,115);GRect kart6=new GRect(90,115);GRect kart7=new GRect(90,115);GRect kart8=new GRect(90,115);
	GRect kart9=new GRect(90,115);GRect kart10=new GRect(90,115);GRect kart11=new GRect(90,115);GRect kart12=new GRect(90,115);
	GRect kart13=new GRect(90,115);GRect kart14=new GRect(90,115);GRect kart15=new GRect(90,115);GRect kart16=new GRect(90,115);
	//Dortlu kart dizilisindeki kartlarin desenlerini tanimlar
	GLabel tersKart1 = new GLabel("#");GLabel tersKart2 = new GLabel("#");GLabel tersKart3 = new GLabel("#");GLabel tersKart4 = new GLabel("#");
	GLabel tersKart5 = new GLabel("#");GLabel tersKart6 = new GLabel("#");GLabel tersKart7 = new GLabel("#");GLabel tersKart8 = new GLabel("#");
	GLabel tersKart9 = new GLabel("#");GLabel tersKart10 = new GLabel("#");GLabel tersKart11 = new GLabel("#");GLabel tersKart12 = new GLabel("#");
	GLabel tersKart13 = new GLabel("#");GLabel tersKart14 = new GLabel("#");GLabel tersKart15 = new GLabel("#");GLabel tersKart16 = new GLabel("#");

	public void init() { 
		if(kontrolDegiskeni==0) {
			anaMenu();
		} 
	}
	public void run() {
		setSize(1350,900);
		anaMenuSes();
		addMouseListeners();
		while(true) {

			while(kosul) {
				//Besli kartlari hareket ettirmek icin yazilan komut
				beslikart.move(-v2,v1);beslikart.rotate(v1);besliMetin1.move(-v2,v1);besliMetin1.rotate(v1);besliMetin6.move(-v2,v1);besliMetin6.rotate(v1);besliMetin11.move(-v2,v1);besliMetin11.rotate(v1);
				beslikart1.move(-v1,v2);beslikart1.rotate(v1);besliMetin2.move(-v1,v2);besliMetin2.rotate(v1);besliMetin7.move(-v1,v2);besliMetin7.rotate(v1);besliMetin12.move(-v1,v2);besliMetin12.rotate(v1);
				beslikart2.move(0,v2);beslikart2.rotate(v1);besliMetin3.move(0,v2);besliMetin3.rotate(v1);besliMetin8.move(0,v2);besliMetin8.rotate(v1);besliMetin13.move(0,v2);besliMetin13.rotate(v1);
				beslikart3.move(v1,v2);beslikart3.rotate(v1);besliMetin4.move(v1,v2);besliMetin4.rotate(v1);besliMetin9.move(v1,v2);besliMetin9.rotate(v1);besliMetin14.move(v1,v2);besliMetin14.rotate(v1);
				beslikart4.move(v2,v1);beslikart4.rotate(v1);besliMetin5.move(v2,v1);besliMetin5.rotate(v1);besliMetin10.move(v2,v1);besliMetin10.rotate(v1);besliMetin15.move(v2,v1);besliMetin15.rotate(v1);
				pause(1.5);
				//Besli kart animasyonunu durdurmak icin yazilan kosul
				if(beslikart4.getX()>2359) {
					beslikart4.setLocation(0,0);beslikart4.sendToBack();
					dortluKart();
					v1=0;v2=0;
					kosul=false;
				}
				//Dortlu kart ekraninda gruplari toplamak icin yazilan komutlar
				if(dizilisDegiskeni>=14 && dizilisDegiskeni<=16) {
					kart4.move(-v3, 0);tersKart4.move(-v3, 0);kart1.move(-v4,v5);tersKart1.move(-v4,v5);kart3.move(-v4,-v6);tersKart3.move(-v4,-v6);
					kart6.move(v7,0);tersKart6.move(v7,0);kart5.move(v8, v9);tersKart5.move(v8,v9);kart7.move(v8, -v10);tersKart7.move(v8,-v10);
					kart9.move(-v12,v13);tersKart9.move(-v12, v13);kart11.move(-v12,-v14);tersKart11.move(-v12, -v14);kart12.move(-v11, 0);tersKart12.move(-v11, 0);
					kart13.move(v16, v17);tersKart13.move(v16, v17);kart14.move(v15, 0);tersKart14.move(v15, 0);kart15.move(v16, -v18);tersKart15.move(v16, -v18);
				}
				//Dortlu grubun oldugu ekranda toplanan grubu gondermek ve animasyonu bitirmek icin yazilan kosullar
				//Ilk dortlu grup grup animasyonu
				if(kart2.getX()==kart4.getX() && k1==1) {
					v3=0;v4=0;v5=0;v6=0;
					kart4.sendToBack();tersKart4.sendToBack();kart3.sendToBack();tersKart3.sendToBack();kart1.sendToBack();tersKart1.sendToBack();
					pause(10);
					while(kart2.getX()>=-100) {
						kart2.move(-1,-1);tersKart2.move(-1, -1);pause(1);
					}
					k1=2;dizilisDegiskeni++;kart2.sendToBack();tersKart2.sendToBack();kart2.setLocation(0,0);
					kosul=false;
				}
				//Ikinci dortlu grup animasyonu
				if(kart8.getX()==kart6.getX() && k2==1) {
					v7=0;v8=0;v9=0;v10=0;
					kart5.sendToBack();tersKart5.sendToBack();kart6.sendToBack();tersKart6.sendToBack();kart7.sendToBack();tersKart7.sendToBack();pause(10);
					while(kart8.getX()<=2200) {
						kart8.move(1,-1);tersKart8.move(1,-1);pause(1);
					}
					k2=2;dizilisDegiskeni++;kart8.sendToBack();tersKart8.sendToBack();kart8.setLocation(0,0);
					kosul=false;
				}
				//Ucuncu dortlu grup animasyonu
				if(kart10.getX()==kart12.getX() && k3==1) {
					v11=0;v12=0;v13=0;v14=0;
					kart9.sendToBack();tersKart9.sendToBack();kart11.sendToBack();tersKart11.sendToBack();kart12.sendToBack();tersKart12.sendToBack();pause(10);
					while(kart10.getX()>=-100) {
						kart10.move(-1,1);tersKart10.move(-1,1);pause(1);
					}
					k3=2;dizilisDegiskeni++;kart10.sendToBack();tersKart10.sendToBack();kart10.setLocation(0,0);
					kosul=false;
				}
				//Son dortlu grup animasyonu
				if(kart14.getX()==kart16.getX() && k4==1) {
					v15=0;v16=0;v17=0;v18=0;
					kart13.sendToBack();tersKart13.sendToBack();kart14.sendToBack();tersKart14.sendToBack();kart15.sendToBack();tersKart15.sendToBack();pause(10);
					while(kart16.getX()<=2200) {
						kart16.move(1,1);tersKart16.move(1,1);pause(1);
					}
					k4=2;dizilisDegiskeni++;kart16.sendToBack();tersKart16.sendToBack();kart16.setLocation(0,0);
					kosul=false;
				}
				//Sonkalan dortlu grubu orta konuma getirmek icin yazilan komutlar
				if(dizilisDegiskeni==17) {
					dizilisDegiskeni=18; 
					aciklamaa.sendToBack();add(aciklamab,475,120);
					while(kart1.getX()<565 || kart1.getY()<240) {
						kart1.move(2.37, 1);kart2.move(2.37, 1);kart3.move(2.37, 1);kart4.move(2.37, 1);tersKart1.move(2.37, 1);tersKart2.move(2.37, 1);tersKart3.move(2.37, 1);tersKart4.move(2.37, 1);
						pause(3);
					}while(kart5.getX()>565 || kart5.getY()<240) {
						kart5.move(-2.37, 1);kart6.move(-2.37, 1);kart7.move(-2.37, 1);kart8.move(-2.37, 1);tersKart5.move(-2.37, 1);tersKart6.move(-2.37, 1);tersKart7.move(-2.37, 1);tersKart8.move(-2.37, 1);
						pause(3);
					}while(kart9.getX()<565 || kart9.getY()>240) {
						kart9.move(2.37,-1);kart10.move(2.37,-1);kart11.move(2.37,-1);kart12.move(2.37,-1);tersKart9.move(2.37,-1);tersKart10.move(2.37,-1);tersKart11.move(2.37,-1);tersKart12.move(2.37,-1);
						pause(3);
					}while(kart13.getX()>565 || kart13.getY()>240) {
						kart13.move(-2.37, -1);kart14.move(-2.37, -1);kart15.move(-2.37, -1);kart16.move(-2.37, -1);tersKart13.move(-2.37, -1);tersKart14.move(-2.37, -1);tersKart15.move(-2.37, -1);tersKart16.move(-2.37, -1);
						pause(3);
					}
				}
				//Dortlu kart ekraninda son kalan grup icin kartlari tek tek gondermek icin yazilan komutlar
				if(dizilisDegiskeni>=18) {
					kart1.move(0,-v19);kart2.move(-v20, 0);kart4.move(v21, 0);kart3.move(0, v22);tersKart1.move(0, -v19);tersKart2.move(-v20,0);tersKart4.move(v21, 0);tersKart3.move(0, v22);
					kart5.move(0,-v19);kart6.move(-v20, 0);kart8.move(v21, 0);kart7.move(0, v22);tersKart5.move(0, -v19);tersKart6.move(-v20,0);tersKart8.move(v21, 0);tersKart7.move(0, v22);
					kart9.move(0,-v19);kart10.move(-v20, 0);kart12.move(v21, 0);kart11.move(0, v22);tersKart9.move(0, -v19);tersKart10.move(-v20,0);tersKart12.move(v21, 0);tersKart11.move(0, v22);
					kart13.move(0,-v19);kart14.move(-v20, 0);kart16.move(v21, 0);kart15.move(0, v22);tersKart13.move(0, -v19);tersKart14.move(-v20,0);tersKart16.move(v21, 0);tersKart15.move(0, v22);
				}
				//Son kalan dortlu grupta ust taraftaki karti durdurmak icin yazilan kosul
				if((kart1.getY()<=-130 || kart5.getY()<=-130 || kart9.getY()<=-130 || kart13.getY()<=-130) && dizilisDegiskeni>=18) {
					kart1.sendToBack();kart5.sendToBack();kart9.sendToBack();kart13.sendToBack();
					kart1.setLocation(0,0);kart5.setLocation(0,0);kart9.setLocation(0,0);kart13.setLocation(0,0);
					v19=0;f=f+1;
				}
				//Son kalan dortlu grupta sol taraftaki karti durdurmak icin yazilan kosul
				if((kart2.getX()<=-100 || kart6.getX()<=-100 || kart10.getX()<=-100 || kart14.getX()<=-100) && dizilisDegiskeni>=18) {
					kart2.sendToBack();kart6.sendToBack();kart10.sendToBack();kart14.sendToBack();
					kart2.setLocation(0, 0);kart6.setLocation(0, 0);kart10.setLocation(0, 0);kart14.setLocation(0, 0);
					v20=0;f=f+1;
				}
				//Son kalan dortlu grupta alt taraftaki karti durdurmak icin yazilan kosul
				if((kart3.getY()>=1080 || kart7.getY()>=1080 || kart11.getY()>=1080 || kart15.getY()>=1080) && dizilisDegiskeni>=18) {
					kart3.sendToBack();kart7.sendToBack();kart11.sendToBack();kart15.sendToBack();
					kart3.setLocation(0,0);kart7.setLocation(0,0);kart11.setLocation(0,0);kart15.setLocation(0,0);
					v22=0;f=f+1;
				}
				//Son kalan dortlu grupta sol taraftaki karti durdurmak icin yazilan kosul
				if((kart4.getX()>=2120 || kart8.getX()>=2120 || kart12.getX()>=2120 || kart16.getX()>=2120) && dizilisDegiskeni>=18) {
					kart4.sendToBack();kart8.sendToBack();kart12.sendToBack();kart16.sendToBack();
					kart4.setLocation(0, 0);kart8.setLocation(0, 0);kart12.setLocation(0, 0);kart16.setLocation(0, 0);
					v21=0;f=f+1;
				}
				if(f==3) {
					pause(300);
					buldum();
				}
			}
			kosul=true;
		}
	}
	//Kullanici secimlerini okur
	public void mouseClicked(MouseEvent e) { 
		//Besli karttaki Ana Menu
		if(e.getX()>=370 && e.getX()<=500 && e.getY()>=400 && e.getY()<=500 && besliDegisken == 1) {
			anaMenu();
		}
		//Besli karttaki Cikis
		if(e.getX()>=670 && e.getX()<=790 && e.getY()>=400 && e.getY()<=500 && besliDegisken == 1) {
			System.exit(0);
		}
		//Sondaki Cikis
		if(e.getX()>=680 && e.getX()<=785 && e.getY()>=700 && e.getY()<=750 && f == 4) {
			System.exit(0);
		}
		//Sondaki Ana Menuye Don
		if(e.getX()>=310 && e.getX()<=450 && e.getY()>=700 && e.getY()<=750 && f == 4) {
			anaMenu();
		}
		//Tek kart sormada alt kart
		if(e.getX()>=565 && e.getX()<=655 && e.getY()>=360 && e.getY()<=470 && dizilisDegiskeni>=18 && dizilisDegiskeni<=21 && l4==0) {
			v22=2;
			dizilisDegiskeni++;l4=1;
		}
		//Tek kart sormada sag kart
		if(e.getX()>=660 && e.getX()<=750 && e.getY()>=298 && e.getY()<=413 && dizilisDegiskeni>=18 && dizilisDegiskeni<=21 && l3==0) {
			v21=2;
			dizilisDegiskeni++;l3=1;
		}
		//Tek kart sormada sol kart
		if(e.getX()>=470 && e.getX()<=560 && e.getY()>=298 && e.getY()<=413 && dizilisDegiskeni>=18 && dizilisDegiskeni<=21 && l2==0) {
			v20=2;
			dizilisDegiskeni++;l2=1;
		}
		//Tek kart sormada ust kart
		if(e.getX()>=565 && e.getX()<=655 && e.getY()>=240 && e.getY()<=355 && dizilisDegiskeni>=18 && dizilisDegiskeni<=21 && l1==0) {
			v19=2;
			dizilisDegiskeni++;l1=1;
		}
		//Cikis butonuna koordinat verir
		if(e.getX()>=50 && e.getX()<=200 && e.getY()>=285 && e.getY()<=320 && kontrolDegiskeni==0 && hakkindaAcKapa==0) {
			//Buraya System Exit 
			System.exit(0);
		}
		//Kullanivi birinci dortlu grubu secer ise hiz vektorlerini degistiren komut
		if(e.getX()>=115 && e.getX()<=395 && e.getY()>=90 && e.getY()<=325 && k1==0 && dizilisDegiskeni>=14 && dizilisDegiskeni<=16) {
			v3=2;v4=1;v5=0.61;v6=0.65;
			k1=1;
		}
		//Kullanivi ikinci dortlu grubu secer ise hiz vektorlerini degistiren komut
		if(e.getX()>=825 && e.getX()<=1130 && e.getY()>=90 && e.getY()<=325 && k2==0 && dizilisDegiskeni>=14 && dizilisDegiskeni<=16) {
			v7=2;v8=1;v9=0.61;v10=0.65;
			k2=1;
		}
		//Kullanivi ucuncu dortlu grubu secer ise hiz vektorlerini degistiren komut
		if(e.getX()>=115 && e.getX()<=395 && e.getY()>=390 && e.getY()<=625 && k3==0 && dizilisDegiskeni>=14 && dizilisDegiskeni<=16) {
			v11=2;v12=1;v13=0.61;v14=0.65;
			k3=1;
		}
		//Kullanivi dorduncu dortlu grubu secer ise hiz vektorlerini degistiren komut
		if(e.getX()>=825 && e.getX()<=1130 && e.getY()>=390 && e.getY()<=625 && k4==0 && dizilisDegiskeni>=14 && dizilisDegiskeni<=16) {
			v15=2;v16=1;v17=0.61;v18=0.65;
			k4=1;
		}
		//Kullanici besli kart sorusuna "Hayir" cevabi verirse bu komut calisir
		if(e.getX()>=755 && e.getX()<=900 && e.getY()>=500 && e.getY()<=600 && dizilisDegiskeni==13) {
			v1=1;v2=2;

		}else if(e.getX()>=385 && e.getX()<=450 && e.getY()>=500 && e.getY()<=600 && dizilisDegiskeni==13) {
			//Kullanici besli kart sorusuna "Evet" cevabi verirse bu komut calisir
			bulamadim();
		}
		//Ilk secimde ucuncu grubu ikinci secimde ucunucu grubu secen ve ucuncu secimde ucuncu grubu secenin tuttugu kart
		if(e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==12) {
			tuttuguKart = metin21;
			besliKart();
		}
		//Ilk secimde ucuncu grubu ikinci secimde ucunucu grubu secen ve ucuncu secimde ikinci grubu secenin tuttugu kart
		if(e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==12) {
			tuttuguKart = metin12;
			besliKart();
		}
		//Ilk secimde ucuncu grubu ikinci secimde ucuncu grubu secen ve ucuncu secimde birinci grubu secenin tuttugu kart
		if(e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==12) {
			tuttuguKart = metin3;
			besliKart();
		}
		//Ilk secimde ucuncu grubu secen ikinci secimde ucuncu grubu secer ise bu dizilis kullanilir
		if (e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==9){
			dy = 80;dx = 200;
			metin1.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin10.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin19.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin8.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin6.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin15.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin4.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin13.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin2.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin11.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin20.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin9.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin18.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin7.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin16.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin5.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin14.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin3.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin12.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin21.setLocation(dx-120,dy-30);
			dizilisDegiskeni=12;
		}

		//Ilk secimde ucuncu grubu ikinci secimde ikinci grubu secen ve ucuncu secimde ucuncu grubu secenin tuttugu kart
		if(e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==11) {
			tuttuguKart = metin18;
			besliKart();
		}
		//Ilk secimde ucuncu grubu ikinci secimde ikinci grubu secen ve ucuncu secimde ikinci grubu secenin tuttugu kart
		if(e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==11) {
			tuttuguKart = metin9;
			besliKart();
		}
		//Ilk secimde ucuncu grubu ikinci secimde ikinci grubu secen ve ucuncu secimde birinci grubu secen kullanici icin
		if (e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==11){
			bulamadim();
		}
		//Ilk secimde ucuncu grubu secen ikinci secimde ikinci grubu secer ise bu dizilis kullanilir
		if (e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==9){
			dy = 80;dx = 200;
			metin1.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin10.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin19.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin8.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin6.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin15.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin7.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin16.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin5.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin14.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin3.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin12.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin21.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin4.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin13.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin2.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin11.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin20.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin9.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin18.setLocation(dx-120,dy-30);
			dizilisDegiskeni=11;
		}
		//Ilk secimde ucuncu grubu ikinci secimde birinci grubu secen ve ucuncu secimde ucuncu grubu secenin tuttugu kart
		if(e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==10) {
			tuttuguKart = metin15;
			besliKart();
		}
		//Ilk secimde ucuncu grubu ikinci secimde birinci grubu secen ve ucuncu secimde ikinci grubu secenin tuttugu kart
		if(e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==10) {
			tuttuguKart = metin6;
			besliKart();
		}
		//Ilk secimde ucuncu grubu ikinci secimde birinci grubu secen ve ucuncu secimde birinci grubu secen kullanici icin
		if (e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==10){
			bulamadim();
		}
		//Ilk secimde ucuncu grubu secen ikinci secimde birinci grubu secer ise bu dizilis kullanilir
		if (e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==9){
			dy = 80;dx = 200;
			metin4.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin13.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin2.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin11.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin20.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin9.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin18.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin7.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin16.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin5.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin14.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin3.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin12.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin21.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin1.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin10.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin19.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin8.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin6.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin15.setLocation(dx-120,dy-30);
			dizilisDegiskeni=10;
		}
		//Ilk secimde ucuncu grubu secer ise bu dizilis kullanilir
		if (e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==0 ){
			dy = 80;dx = 200;
			metin1.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin4.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin7.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin10.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin13.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin16.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin19.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin2.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin5.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin8.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin11.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin14.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin20.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin3.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin6.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin9.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin12.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin15.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin18.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin21.setLocation(dx-120,dy-30);
			dizilisDegiskeni=9;besliKartKontrol=3;
		}
		//Ilk secimde ikinci grubu ikinci secimde ucunucu grubu secen ve ucuncu secimde ucuncu grubu secenin tuttugu kart
		if(e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==8) {
			tuttuguKart = metin20;
			besliKart();
		}
		//Ilk secimde ikinci grubu ikinci secimde ucunucu grubu secen ve ucuncu secimde ikinci grubu secenin tuttugu kart
		if(e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==8) {
			tuttuguKart = metin11;
			besliKart();
		}
		//Ilk secimde ikinci grubu ikinci secimde ucuncu grubu secen ve ucuncu secimde birinci grubu secenin tuttugu kart
		if(e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==8) {
			tuttuguKart = metin2;
			besliKart();
		}
		//Ilk secimde ikinci grubu secen ikinci secimde ucuncu grubu secer ise bu dizilis kullanilir
		if (e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==5){
			dy = 80;dx = 200;
			metin1.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin10.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin19.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin9.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin18.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin5.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin14.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin4.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin13.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin3.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin12.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin21.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin8.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin7.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin16.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin6.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin15.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin2.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin11.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin20.setLocation(dx-120,dy-30);
			dizilisDegiskeni=8;
		}
		//Ilk secimde ikinci grubu ikinci secimde ikinci grubu secen ve ucuncu secimde ucuncu grubu secenin tuttugu kart
		if(e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==7) {
			tuttuguKart = metin17;
			besliKart();
		}
		//Ilk secimde ikinci grubu ikinci secimde ikinci grubu secen ve ucuncu secimde ikinci grubu secenin tuttugu kart
		if(e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==7) {
			tuttuguKart = metin8;
			besliKart();
		}
		//Ilk secimde ikinci grubu ikinci secimde ikinci grubu secen ve ucuncu secimde birinci grubu secen icin
		if (e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==7){
			bulamadim();
		}
		//Ilk secimde ikinci grubu secen ikinci secimde ikinci grubu secer ise bu dizilis kullanilir
		if (e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==5){
			dy = 80;dx = 200;
			metin1.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin10.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin19.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin9.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin18.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin5.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin14.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin7.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin16.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin6.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin15.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin2.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin11.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin20.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin4.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin13.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin3.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin12.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin21.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin8.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin17.setLocation(dx-120,dy-30);
			dizilisDegiskeni=7;
		}
		//Ilk secimde ikinci grubu ikinci secimde birinci grubu secen ve ucuncu secimde ucuncu grubu secenin tuttugu kart
		if(e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==6) {
			tuttuguKart = metin14;
			besliKart();
		}
		//Ilk secimde ikinci grubu ikinci secimde birinci grubu secen ve ucuncu secimde ikinci grubu secenin tuttugu kart
		if(e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==6) {
			tuttuguKart = metin5;
			besliKart();
		}
		//Ilk secimde ikinci grubu ikinci secimde birinci grubu secen ve ucuncu secimde birinci grubu secen icin
		if (e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==6){
			bulamadim();
		}
		//Ilk secimde ikinci grubu secen ikinci secimde birinci grubu secer ise bu dizilis kullanilir
		if (e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==5){
			dy = 80;dx = 200;
			metin4.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin13.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin3.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin12.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin21.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin8.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin7.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin16.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin6.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin15.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin2.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin11.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin20.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin1.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin10.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin19.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin9.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin18.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin5.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin14.setLocation(dx-120,dy-30);
			dizilisDegiskeni=6;
		}
		//Ilk secimde ikinci grubu secer ise bu dizilis kullanilir
		if (e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==0 ){
			dy = 80;dx = 200;
			metin1.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin4.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin7.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin10.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin13.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin16.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin19.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin3.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin6.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin9.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin12.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin15.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin18.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin21.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin2.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin5.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin8.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin11.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin14.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin20.setLocation(dx-120,dy-30);
			dizilisDegiskeni=5;besliKartKontrol=2;
		}
		//Ilk secimde birinci grubu ikinci secimde ucunucu grubu secen ve ucuncu secimde ucuncu grubu secenin tuttugu kart
		if(e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==4) {
			tuttuguKart = metin19;
			besliKart();
		}
		//Ilk secimde birinci grubu ikinci secimde ucunucu grubu secen ve ucuncu secimde ikinci grubu secenin tuttugu kart
		if(e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==4) {
			tuttuguKart = metin10;
			besliKart();
		}
		//Ilk secimde birinci grubu ikinci secimde ucuncu grubu secen ve ucuncu secimde birinci grubu secenin tuttugu kart
		if(e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==4) {
			tuttuguKart = metin1;
			besliKart();
		}
		//Ilk secimde birinci grubu secen ikinci secimde ucuncu grubu secer ise bu dizilis kullanilir
		if (e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==1){
			dy = 80;dx = 200;
			metin3.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin12.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin21.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin8.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin4.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin13.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin6.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin15.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin2.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin11.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin20.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin7.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin16.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin9.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin18.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin5.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin14.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin1.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin10.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin19.setLocation(dx-120,dy-30);
			dizilisDegiskeni=4;
		}
		//Ilk secimde birinci grubu ikinci secimde ikinici grubu secen ve ucuncu secimde ucuncu grubu secenin tuttugu kart
		if(e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==3) {
			tuttuguKart = metin16;
			besliKart();
		}
		//Ilk secimde birinci grubu ikinci secimde ikinci grubu secen ve ucuncu secimde ikinci grubu secenin tuttugu kart
		if(e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==3) {
			tuttuguKart = metin7;
			besliKart();
		}
		//Ilk secimde birinci grubu ikinci secimde ikinci grubu secen ve ucuncu secimde birinci grubu secen kullanici icin 
		if (e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==3){
			bulamadim();
		}
		//Ilk secimde birinci grubu secen ikinci secimde ikinci grubu secer ise bu dizilis kullanilir
		if (e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==1){
			dy = 80;dx = 200;
			metin3.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin12.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin21.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin8.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin4.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin13.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin9.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin18.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin5.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin14.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin1.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin10.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin19.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin6.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin15.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin2.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin11.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin20.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin7.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin16.setLocation(dx-120,dy-30);
			dizilisDegiskeni=3;
		}
		//Ilk secimde birinci grubu ikinci secimde birinci grubu secen ve ucuncu secimde ucuncu grubu secenin tuttugu kart
		if(e.getX()>=475 && e.getX()<=625 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==2) {
			tuttuguKart = metin13;
			besliKart();
		}
		//Ilk secimde birinci grubu ikinci secimde birinci grubu secen ve ucuncu secimde ikinci grubu secenin tuttugu kart
		if(e.getX()>=275 && e.getX()<=425 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==2) {
			tuttuguKart = metin4;
			besliKart();
		}
		//Ilk secimde birinci grubu ikinci secimde birinci grubu secen ve ucuncu secimde birinci grubu secen kullanici icin 
		if (e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==2){
			bulamadim();
		}
		//Ilk secimde birinci grubu secen ikinci secimde birinci grubu secer ise bu dizilis kullanilir
		if (e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==1){
			dy = 80;dx = 200;
			metin9.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin18.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin5.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin14.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin1.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin10.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin19.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin6.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin15.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin2.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin11.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin20.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin7.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin16.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin3.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin12.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin21.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin8.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin4.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin13.setLocation(dx-120,dy-30);
			dizilisDegiskeni=2;
		}
		//Ilk secimde birinci grubu secer ise bu dizilis kullanilir
		if (e.getX()>=75 && e.getX()<=225 && e.getY()>=15 && e.getY()<=675 && dizilisDegiskeni==0 ){
			dy = 80;dx = 200;
			metin3.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin6.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin9.setLocation(dx-120,dy-30);
			dy = 80*2;dx = 200;
			metin12.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin15.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin18.setLocation(dx-120,dy-30);
			dy = 80*3;dx = 200;
			metin21.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin2.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin5.setLocation(dx-120,dy-30);
			dy = 80*4;dx = 200;
			metin8.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin11.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin14.setLocation(dx-120,dy-30);
			dy = 80*5;dx = 200;
			metin17.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin20.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin1.setLocation(dx-120,dy-30);
			dy = 80*6;dx = 200;
			metin4.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin7.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin10.setLocation(dx-120,dy-30);
			dy = 80*7;dx = 200;
			metin13.setLocation(dx-120,dy-30);
			dx = 200*2;
			metin16.setLocation(dx-120,dy-30);
			dx = 200*3;
			metin19.setLocation(dx-120,dy-30);
			dizilisDegiskeni=1;besliKartKontrol = 1;
		}
		//Kullanicinin ana menu butonuna basmasini kontrol eden kosul
		if(e.getX()<=52 && e.getY()<=30 && kontrolDegiskeni!=0) {
			anaMenu();
		}
		//Kullanicinin "Basla" butonuna basmasini kontrol eden kosul
		if(e.getX()>=50 && e.getX()<=150 && e.getY()>=140 && e.getY()<=200 && kontrolDegiskeni==0){
			oyunaBasla();
			kontrolDegiskeni=1;
			dizilisDegiskeni=0;
		}
		//Kullanicinin "Hakkinda" butonunu calistirmasini kontrol eden kosul
		if(e.getX()>=50 && e.getX()<=200 && e.getY()>=220 && e.getY()<=265 && kontrolDegiskeni==0 && hakkindaAcKapa==0 ) {
			CikisButonu.sendToBack();
			hakkindaButonu();
			hakkindaAcKapa=1;
		}else if(e.getX()>=50 && e.getX()<=200 && e.getY()>=220 && e.getY()<=265 && kontrolDegiskeni==0 && hakkindaAcKapa==1 ) {
			//Kullanicin "Hakkinda" butonunu kapatmasini kontrol eden kosul
			anaMenu();
			hakkindaAcKapa=0;
			CikisButonu.sendToFront();
		}
	}
	private void oyunaBasla() {

		//Arka plani kisilestirir ve ekler
		arkaPlan.setFilled(true);arkaPlan.setColor(Color.darkGray);
		add(arkaPlan);
		anaMenuButonu();
		//Asagidaki iki adet dongu x-ekseninde 3, y-ekseninde 7 defa tekrarlar 
		for(int i=1; i<8; i++) {
			for(int j=1; j<4; j++) {
				dy = 80*i;
				//Kartlari metinsiz tanimlar ve ekler
				GRect kartlar = new GRect(150,175);
				kartlar.setFilled(true);
				kartlar.setColor(Color.gray);
				kartlar.setFillColor(Color.BLACK);
				dx = 200*j;
				add(kartlar,dx-125,dy-65);
				//Arka plani kisilestirir ve ekler
				GLabel aciklama = new GLabel("Hadi oyuna baslayalim !");
				GLabel aciklama1 = new GLabel("Ilk once aklindan bir kart tut...");
				GLabel aciklama2 = new GLabel("Tuttugun kartin bulundugu sutuna bas.");
				GLabel aciklama4 = new GLabel("Sutun 1");
				GLabel aciklama5 = new GLabel("Sutun 2");
				GLabel aciklama6 = new GLabel("Sutun 3");
				aciklama.setFont("CHILLER-55");
				aciklama1.setFont("CHILLER-55");
				aciklama2.setFont("CHILLER-55");
				aciklama4.setFont("CHILLER-55");
				aciklama5.setFont("CHILLER-55");
				aciklama6.setFont("CHILLER-55");
				aciklama.setColor(Color.cyan);
				aciklama1.setColor(Color.cyan);
				aciklama2.setColor(Color.cyan);
				aciklama4.setColor(Color.cyan);
				aciklama5.setColor(Color.cyan);
				aciklama6.setColor(Color.cyan);
				add(aciklama,700,100);
				add(aciklama1,700,200);
				add(aciklama2,700,300);
				add(aciklama4,75,750);
				add(aciklama5,280,750);
				add(aciklama6,485,750);
				anaMenuButonu();
			}
		}
		//Kartlara metin ekler
		dy = 80;dx = 200;
		metin1.setColor(Color.white);metin1.setFont("times new roman-35");
		add(metin1,dx-120,dy-30);
		dx = 200*2;
		metin2.setColor(Color.white);metin2.setFont("times new roman-35");
		add(metin2,dx-120,dy-30);
		dx = 200*3;
		metin3.setColor(Color.white);metin3.setFont("times new roman-35");
		add(metin3,dx-120,dy-30);
		dy = 80*2;dx = 200;
		metin4.setColor(Color.white);metin4.setFont("times new roman-35");
		add(metin4,dx-120,dy-30);
		dx = 200*2;
		metin5.setColor(Color.white);metin5.setFont("times new roman-35");
		add(metin5,dx-120,dy-30);
		dx = 200*3;
		metin6.setColor(Color.white);metin6.setFont("times new roman-35");
		add(metin6,dx-120,dy-30);
		dy = 80*3;dx = 200;
		metin7.setColor(Color.white);metin7.setFont("times new roman-35");
		add(metin7,dx-120,dy-30);
		dx = 200*2;
		metin8.setColor(Color.white);metin8.setFont("times new roman-35");
		add(metin8,dx-120,dy-30);
		dx = 200*3;
		metin9.setColor(Color.white);metin9.setFont("times new roman-35");
		add(metin9,dx-120,dy-30);
		dy = 80*4;dx = 200;
		metin10.setColor(Color.white);metin10.setFont("times new roman-35");
		add(metin10,dx-120,dy-30);
		dx = 200*2;
		metin11.setColor(Color.white);metin11.setFont("times new roman-35");
		add(metin11,dx-120,dy-30);
		dx = 200*3;
		metin12.setColor(Color.white);metin12.setFont("times new roman-35");
		add(metin12,dx-120,dy-30);
		dy = 80*5;dx = 200;
		metin13.setColor(Color.white);metin13.setFont("times new roman-35");
		add(metin13,dx-120,dy-30);
		dx=200*2;
		metin14.setColor(Color.white);metin14.setFont("times new roman-35");
		add(metin14,dx-120,dy-30);
		dx =200*3;
		metin15.setColor(Color.white);metin15.setFont("times new roman-35");
		add(metin15,dx-120,dy-30);
		dy = 80*6;dx = 200;
		metin16.setColor(Color.white);metin16.setFont("times new roman-35");
		add(metin16,dx-120,dy-30);
		dx = 200*2;
		metin17.setColor(Color.white);metin17.setFont("times new roman-35");
		add(metin17,dx-120,dy-30);
		dx = 200*3;
		metin18.setColor(Color.white);metin18.setFont("times new roman-35");
		add(metin18,dx-120,dy-30);
		dy = 80*7;dx = 200;
		metin19.setColor(Color.white);metin19.setFont("times new roman-35");
		add(metin19,dx-120,dy-30);
		dx = 200*2;
		metin20.setColor(Color.white);metin20.setFont("times new roman-35");
		add(metin20,dx-120,dy-30);
		dx = 200*3;
		metin21.setColor(Color.white);metin21.setFont("times new roman-35");
		add(metin21,dx-120,dy-30);

	}
	private void hakkindaButonu() {
		GLabel HakkindaAciklamasi = new GLabel("Bu Sihirbaz size desteden verilen kartlardan");
		GLabel HakkindaAciklamasi2 = new GLabel(" tuttugunuz karti bulmaya calisir");
		HakkindaAciklamasi2.setColor(Color.green);
		HakkindaAciklamasi2.setFont("CHILLER-30");
		HakkindaAciklamasi.setColor(Color.green);
		HakkindaAciklamasi.setFont("CHILLER-30");
		add(HakkindaAciklamasi,50,300);
		add(HakkindaAciklamasi2,50,325);
		GLabel emegiGecenler = new GLabel("EMEGI GECENLER");
		GLabel isimler1 = new GLabel("Emre Kayan");
		GLabel isimler2 = new GLabel("Yasin Turk");
		GLabel isimler3 = new GLabel("Ahmet Berke Kut");
		emegiGecenler.setColor(Color.blue);
		isimler1.setColor(Color.blue);
		isimler2.setColor(Color.blue);
		isimler3.setColor(Color.blue);
		isimler4.setColor(Color.blue);
		emegiGecenler.setFont("CHILLER-40");
		isimler1.setFont("CHILLER-30");
		isimler2.setFont("CHILLER-30");
		isimler3.setFont("CHILLER-30");
		isimler4.setFont("CHILLER-30");
		add(emegiGecenler,50,370);
		add(isimler1,50,405);
		add(isimler2,50,440);
		add(isimler3,50,475);
		add(isimler4,50,510);
	}
	private void anaMenu() {
		GRect menuArkaPlan = new GRect(2000,2000);
		menuArkaPlan.setFilled(true);
		menuArkaPlan.setFillColor(Color.black);
		add(menuArkaPlan,0,0);
		for(int i=0; i<40; i++) {
			GLabel metin = new GLabel (menuTasarimi());
			GLabel metin1 = new GLabel (menuTasarimi());
			metin.setColor(rg.nextColor());metin.setFont("arial-75");
			add(metin,rg.nextInt(300,2000),rg.nextInt(0,1300));
			metin1.setColor(rg.nextColor());metin1.setFont("TIMES NEW ROMAN-40");
			add(metin1,rg.nextInt(300,2000),rg.nextInt(0,1300));
		}
		GLabel baslik = new GLabel("SIHIRBAZ");
		baslik.setColor(Color.BLUE);baslik.setFont("CHILLER-80");
		add(baslik,40,110);
		GLabel Basla = new GLabel("Basla");
		Basla.setColor(Color.green);Basla.setFont("CHILLER-60");
		add(Basla,50,200);
		GLabel Hakkinda = new GLabel("Hakkinda");
		Hakkinda.setColor(Color.green);
		Hakkinda.setFont("CHILLER-60");
		add(Hakkinda,50,260);
		//Cikis Butonunu Ayarlar
		CikisButonu.setFont("CHILLER-60");
		CikisButonu.setColor(Color.green);
		add(CikisButonu,50,320);
		kontrolDegiskeni=0;dizilisDegiskeni=-1;k1=k2=k3=k4=l1=l2=l3=l4=f=0;
		besliKartKontrol=0;besliDegisken=0;

	}
	private void anaMenuButonu() {
		GRect menuButon = new GRect(50,27);
		menuButon.setFilled(true);menuButon.setColor(Color.GREEN);menuButon.setFillColor(Color.gray);add(menuButon,4,4);
		GLabel menu = new GLabel("MENUYE");GLabel don = new GLabel("DON");
		menu.setFont("comic sans ms-10");menu.setColor(Color.BLUE);don.setFont("comic sans ms-17");don.setColor(Color.BLUE);
		add(menu,8,15);add(don,8,29);
	}
	private void besliKart() {
		//arkaplan ekler
		GRect arkaPlan = new GRect(100000,100000);
		arkaPlan.setFilled(true);arkaPlan.setColor(Color.darkGray);
		add(arkaPlan);
		anaMenuButonu();
		//soru sorar
		GLabel sorucumlesi=new GLabel("KARTIN BURADA VAR MI?");
		sorucumlesi.setColor(Color.blue);sorucumlesi.setFont("Comic sans ms-60");
		add(sorucumlesi,280,200);
		//bes kart tanimlar ve yerlestirir
		beslikart.setFilled(true);beslikart.setColor(Color.gray);beslikart.setFillColor(Color.BLACK);
		add(beslikart,280,270);
		beslikart1.setFilled(true);beslikart1.setColor(Color.gray);beslikart1.setFillColor(Color.BLACK);
		add(beslikart1,440,270);
		beslikart2.setFilled(true);beslikart2.setColor(Color.gray);beslikart2.setFillColor(Color.BLACK);
		add(beslikart2,600,270);
		beslikart3.setFilled(true);beslikart3.setColor(Color.gray);beslikart3.setFillColor(Color.BLACK);
		add(beslikart3,760,270);
		beslikart4.setFilled(true);beslikart4.setColor(Color.gray);beslikart4.setFillColor(Color.BLACK);
		add(beslikart4,920,270);
		//evet hayir sorularini  sorar
		GLabel evet = new GLabel("EVET");
		evet.setColor(Color.RED);evet.setFont("Comic sans ms-50");
		add(evet,390,600);	
		GLabel hayir = new GLabel("HAYIR");
		hayir.setColor(Color.RED);hayir.setFont("Comic sans ms-50");
		add(hayir,760,600);
		dizilisDegiskeni=13;
		if(besliKartKontrol==1) {
			besliMetin1.setColor(Color.white);besliMetin1.setFont("times new roman-37");add(besliMetin1,290,310);
			besliMetin2.setColor(Color.white);besliMetin2.setFont("times new roman-37");add(besliMetin2,450,310);
			besliMetin3.setColor(Color.white);besliMetin3.setFont("times new roman-37");add(besliMetin3,610,310);
			besliMetin4.setColor(Color.white);besliMetin4.setFont("times new roman-37");add(besliMetin4,770,310);
			besliMetin5.setColor(Color.white);besliMetin5.setFont("times new roman-37");add(besliMetin5,930,310);
		}else if(besliKartKontrol==2) {
			besliMetin6.setColor(Color.white);besliMetin6.setFont("times new roman-37");add(besliMetin6,290,310);
			besliMetin7.setColor(Color.white);besliMetin7.setFont("times new roman-37");add(besliMetin7,450,310);
			besliMetin8.setColor(Color.white);besliMetin8.setFont("times new roman-37");add(besliMetin8,610,310);
			besliMetin9.setColor(Color.white);besliMetin9.setFont("times new roman-37");add(besliMetin9,770,310);
			besliMetin10.setColor(Color.white);besliMetin10.setFont("times new roman-37");add(besliMetin10,930,310);
		}else if(besliKartKontrol==3) {
			besliMetin11.setColor(Color.white);besliMetin11.setFont("times new roman-37");add(besliMetin11,290,310);
			besliMetin12.setColor(Color.white);besliMetin12.setFont("times new roman-37");add(besliMetin12,450,310);
			besliMetin13.setColor(Color.white);besliMetin13.setFont("times new roman-37");add(besliMetin13,610,310);
			besliMetin14.setColor(Color.white);besliMetin14.setFont("times new roman-37");add(besliMetin14,770,310);
			besliMetin15.setColor(Color.white);besliMetin15.setFont("times new roman-37");add(besliMetin15,930,310);
		}
	}
	private void bulamadim() {
		add(arkaPlan);dizilisDegiskeni=0;besliDegisken=1;
		GLabel bulamadim1 = new GLabel("Maalesef bulamadim.");GLabel bulamadim2 = new GLabel("Tekrar deneyebilirsin...");
		bulamadim1.setColor(Color.ORANGE);bulamadim1.setFont("Gabriola-100");add(bulamadim1,290,230);
		bulamadim2.setColor(Color.ORANGE);bulamadim2.setFont("Gabriola-100");add(bulamadim2,290,330);
		SondakiAnaMenu.setColor(Color.RED);SondakiAnaMenu.setFont("Gabriola-60");SondakiCikis.setColor(Color.RED);SondakiCikis.setFont("Gabriola-60");
		add(SondakiAnaMenu,370,500);add(SondakiCikis,670,500);
	}	
	//Kartlari dortlu grup olarak dizme metodu
	private void dortluKart() {
		arkaPlan.setFilled(true);arkaPlan.setColor(Color.darkGray);
		add(arkaPlan);
		anaMenuButonu();
		aciklamaa.setColor(Color.cyan); aciklamaa.setFont("Chiller-45");
		aciklamab.setColor(Color.magenta); aciklamab.setFont("CHILLER-45");
		add(aciklamaa,475,120);
		kart1.setFilled(true);kart1.setColor(Color.BLACK);kart1.setFillColor(Color.BLACK);
		kart2.setFilled(true);kart2.setColor(Color.BLACK);kart2.setFillColor(Color.BLACK);
		kart3.setFilled(true);kart3.setColor(Color.BLACK);kart3.setFillColor(Color.BLACK);
		kart4.setFilled(true);kart4.setColor(Color.BLACK);kart4.setFillColor(Color.BLACK);
		kart5.setFilled(true);kart5.setColor(Color.BLACK);kart5.setFillColor(Color.BLACK);
		kart6.setFilled(true);kart6.setColor(Color.BLACK);kart6.setFillColor(Color.BLACK);
		kart7.setFilled(true);kart7.setColor(Color.BLACK);kart7.setFillColor(Color.BLACK);
		kart8.setFilled(true);kart8.setColor(Color.BLACK);kart8.setFillColor(Color.BLACK);
		kart9.setFilled(true);kart9.setColor(Color.BLACK);kart9.setFillColor(Color.BLACK);
		kart10.setFilled(true);kart10.setColor(Color.BLACK);kart10.setFillColor(Color.BLACK);
		kart11.setFilled(true);kart11.setColor(Color.BLACK);kart11.setFillColor(Color.BLACK);
		kart12.setFilled(true);kart12.setColor(Color.BLACK);kart12.setFillColor(Color.BLACK);
		kart13.setFilled(true);kart13.setColor(Color.BLACK);kart13.setFillColor(Color.BLACK);
		kart14.setFilled(true);kart14.setColor(Color.BLACK);kart14.setFillColor(Color.BLACK);
		kart15.setFilled(true);kart15.setColor(Color.BLACK);kart15.setFillColor(Color.BLACK);
		kart16.setFilled(true);kart16.setColor(Color.BLACK);kart16.setFillColor(Color.BLACK);
		add (kart1,210,90);//ilk dortludeki  ust
		add (kart2,115,148);//ilk dortludeki sol	
		add (kart3,210,210);//ilk dortludeki 	alt
		add (kart4,305,148);//ilk dortludeki sag

		add (kart5,920,90);//ikinci 4ludeki  ust
		add (kart6,825,148);//ikinci dortludeki sol	
		add (kart7,920,210);//ikinci dortludeki 	alt
		add (kart8,1015,148);//ikinci dortludeki sag

		add (kart9,210,390);//ucumcu 4ludeki  ust
		add (kart10,115,448);//ucuncu dortludeki sol	
		add (kart11,210,510);//ucuncu dortludeki 	alt
		add (kart12,305,448);//ucuncu dortludeki sag

		add (kart13,920,390);//son 4ludeki  ust
		add (kart14,825,448);//son dortludeki sol	
		add (kart15,920,510);//son dortludeki 	alt
		add (kart16,1015,448);//son dortludeki sag
		tersKart1.setFont("Bradley Hand ITC-120");tersKart1.setColor(Color.WHITE);
		add(tersKart1,218,172);
		tersKart2.setFont("Bradley Hand ITC-120");tersKart2.setColor(Color.WHITE);
		add(tersKart2,123,229.5);
		tersKart3.setFont("Bradley Hand ITC-120");tersKart3.setColor(Color.WHITE);
		add(tersKart3,218,292);
		tersKart4.setFont("Bradley Hand ITC-120");tersKart4.setColor(Color.WHITE);
		add(tersKart4,313,229.5);
		tersKart5.setFont("Bradley Hand ITC-120");tersKart5.setColor(Color.WHITE);
		add(tersKart5,928,172);
		tersKart6.setFont("Bradley Hand ITC-120");tersKart6.setColor(Color.WHITE);
		add(tersKart6,833,229.5);
		tersKart7.setFont("Bradley Hand ITC-120");tersKart7.setColor(Color.WHITE);
		add(tersKart7,928,292);
		tersKart8.setFont("Bradley Hand ITC-120");tersKart8.setColor(Color.WHITE);
		add(tersKart8,1023,229.5);
		tersKart9.setFont("Bradley Hand ITC-120");tersKart9.setColor(Color.WHITE);
		add(tersKart9,218,472);
		tersKart10.setFont("Bradley Hand ITC-120");tersKart10.setColor(Color.WHITE);
		add(tersKart10,123,529.5);
		tersKart11.setFont("Bradley Hand ITC-120");tersKart11.setColor(Color.WHITE);
		add(tersKart11,218,592);
		tersKart12.setFont("Bradley Hand ITC-120");tersKart12.setColor(Color.WHITE);
		add(tersKart12,313,529.5);
		tersKart13.setFont("Bradley Hand ITC-120");tersKart13.setColor(Color.WHITE);
		add(tersKart13,928,472);
		tersKart14.setFont("Bradley Hand ITC-120");tersKart14.setColor(Color.WHITE);
		add(tersKart14,833,529.5);
		tersKart15.setFont("Bradley Hand ITC-120");tersKart15.setColor(Color.WHITE);
		add(tersKart15,928,592);
		tersKart16.setFont("Bradley Hand ITC-120");tersKart16.setColor(Color.WHITE);
		add(tersKart16,1023,529.5);
		dizilisDegiskeni=14;
	}
	//Kullanicinin sectigi karti tanimlar
	private void buldum() {
		GLabel kartAcma = new GLabel ("KARTINI ACIYORUM...");kartAcma.setColor(Color.BLACK);kartAcma.setFont("Jokerman-80");
		arkaPlan.setFilled(true);add(arkaPlan,0,0);add(kartAcma,200,250);
		for(int i=0; i<3;i++) {
			arkaPlan.setColor(rg.nextColor());
			pause(750);
			for(int j=0; j<10;j++) {
				arkaPlan.setColor(rg.nextColor());
				pause(30);
			}
		}
		arkaPlan.setColor(Color.DARK_GRAY);arkaPlan.sendToFront();
		GLabel kartin = new GLabel("Kartin");kartin.setFont("Jokerman-100");kartin.setColor(Color.WHITE);add(kartin,455,180);
		GRect kullaniciKarti = new GRect(300,370);kullaniciKarti.setFilled(true);kullaniciKarti.setColor(Color.BLACK);add(kullaniciKarti,450,260);
		tuttuguKart.setFont("Times new roman-80");tuttuguKart.setColor(Color.WHITE);add(tuttuguKart,460,330);
		f=4;
		SondakiAnaMenu.setFont("Jokerman-50");SondakiAnaMenu.setColor(Color.LIGHT_GRAY);SondakiCikis.setFont("Jokerman-50");SondakiCikis.setColor(Color.LIGHT_GRAY);
		add(SondakiAnaMenu,310,750);add(SondakiCikis,680,750);
	}
	//Oyuna ses ekler
	public static void anaMenuSes(){
		AudioPlayer MGP = AudioPlayer.player;
		AudioStream BGM;
		AudioData MD;
		ContinuousAudioDataStream loop = null;
		try{
			BGM = new AudioStream(new FileInputStream("anaMenuMuzik.wav"));
			MD = BGM.getData();
			loop = new ContinuousAudioDataStream(MD);

		}catch(IOException e){
			System.out.println("Dosyayi bulamadim");
		}
		MGP.start(loop);
	}
	//Rastgele kart dagilimi yapar
	private String sayiSec() {
		int secim = rg.nextInt(random+=1,random+=1);
		switch(secim%52) {
		case 1: 
			return"♥         A";
		case 2:
			return"♥         2";
		case 3:
			return"♥         3";
		case 4:
			return"♥         4";
		case 5:
			return"♥         5";
		case 6: 
			return"♥         6";
		case 7:
			return"♥         7";
		case 8:
			return"♥         8";
		case 9:
			return"♥         9";
		case 10:
			return"♥        10";
		case 11:
			return"♥         J";
		case 12:
			return"♥         Q";
		case 13:
			return"♥         K";
		case 14:
			return"♦         A";
		case 15:
			return"♦         2";
		case 16:
			return"♦         3";
		case 17:
			return"♦         4";
		case 18:
			return"♦         5";
		case 19:
			return"♦         6";
		case 20:
			return"♦         7";
		case 21:
			return"♦         8";
		case 22:
			return"♦         9";
		case 23:
			return"♦        10";
		case 24:
			return"♦         J";
		case 25:
			return"♦         Q";
		case 26:
			return"♦         K";
		case 27:
			return"♣         A";
		case 28:
			return"♣         2";
		case 29:
			return"♣         3";
		case 30:
			return"♣         4";
		case 31:
			return"♣         5";
		case 32:
			return"♣         6";
		case 33:
			return"♣         7";
		case 34:
			return"♣         8";
		case 35:
			return"♣         9";
		case 36:
			return"♣        10";
		case 37:
			return"♣         J";
		case 38:
			return"♣         Q";
		case 39:
			return"♣         K";
		case 40:
			return"♠         A";
		case 41:
			return"♠         2";
		case 42:
			return"♠         3";
		case 43:
			return"♠         4";
		case 44:
			return"♠         5";
		case 45:
			return"♠         6";
		case 46:
			return"♠         7";
		case 47:
			return"♠         8";
		case 48:
			return"♠         9";
		case 49:
			return"♠        10";
		case 50:
			return"♠         J";
		case 51:
			return"♠         Q";
		case 0:
			return"♠         K";
		default:
			return "Tanimsiz";
		}
	}
	//Menu tasarimi yapar
	private String menuTasarimi() {
		int secim = rg.nextInt(1,4);
		switch(secim) {
		case 1:
			return"♥";
		case 2:
			return"♦";
		case 3:
			return"♣";
		case 4:
			return"♠";
		default:
			return "Tanimsiz";
		}
	}
}