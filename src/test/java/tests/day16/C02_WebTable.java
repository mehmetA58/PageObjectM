package tests.day16;

import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebTable {
    @Test
    public void test() throws InterruptedException {
        //Bir class oluşturun : C02_WebTables
        //● login() metodun oluşturun ve oturum açın.
        //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
        // ○ Username : manager
        // ○ Password : Manager1!
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelRoomsButonu.click();
        Thread.sleep(2000);
        //● table() metodu oluşturun
        // ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        qaConcortPage.basliklarListesi.stream().forEach(t-> System.out.println(t.getText()));
        // ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

        System.out.println(qaConcortPage.tBodyTumu.getText());
        //● printRows() metodu oluşturun //tr
        System.out.println(qaConcortPage.birinciSatir.getText());
        // ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        // ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.

        for (int i = 0; i <qaConcortPage.satirlarListesi.size() ; i++) {

            System.out.println(i+1+".satir : "+qaConcortPage.satirlarListesi.get(i).getText());
        }
        // ○ 4.satirdaki(row) elementleri konsolda yazdırın.

        qaConcortPage.dorduncuSutunListesi.stream().forEach(t-> System.out.println(t.getText()));
    }
}
