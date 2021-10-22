package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

import java.util.List;

public class C03_WebTableClassHomeWork {

    QAConcortPage qaConcortPage;
    @Test (priority = -1)
    public void login(){
        QAConcortPage qaConcortPage=new QAConcortPage();
        //● Bir class oluşturun : D18_WebTables
        //● login() metodun oluşturun ve oturum açın.
        //● https://qa-environment.concorthotel.com/ /admin/HotelRoomAdmin adresine gidin
        //○ Username : manager ○ Password : Manager2!

        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelRoomsButonu.click();
    }
    @Test (dependsOnMethods = "login")
    public void table(){
        //● table() metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        qaConcortPage=new QAConcortPage();
        qaConcortPage.basliklarListesi.stream().forEach(t-> System.out.println(t.getText()));
        System.out.println("baslik adedi : "+qaConcortPage.basliklarListesi.size());

    }
    @Test(dependsOnMethods = "login")
    public void printRows(){
        //● printRows() metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        qaConcortPage=new QAConcortPage();
        System.out.println("satir adedi : "+qaConcortPage.satirlarListesi.size());
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        qaConcortPage.satirlarListesi.stream().forEach(t-> System.out.println(t.getText()));
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        qaConcortPage.dorduncuSutunListesi.stream().forEach(t-> System.out.println(t.getText()));
    }
    @Test(dependsOnMethods = "login")
    public void printCells(){
        qaConcortPage=new QAConcortPage();
        //● printCells() metodu oluşturun //td
        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        System.out.println("tum hucreler sayisi : "+qaConcortPage.tumHucrelerListesi.size());
        // ○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        qaConcortPage.tBodyTumu.stream().forEach(t-> System.out.println(t));
    }
    @Test(dependsOnMethods = "login")
    public void printColumns() {
        //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        int columnNumberInTableBody = Driver.getDriver().findElements(By.xpath("//tbody//tr[1]//td")).size();
        System.out.println("Column number in table body is: " + columnNumberInTableBody);
        System.out.println("-------------------------------------------------------------------------");
        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        for (int i = 1; i < columnNumberInTableBody + 1; i++) {
            List<WebElement> eachColumnElements = Driver.getDriver().findElements(By.xpath("//tbody//td[" + i + "]"));
            System.out.println(i + ". Column's Elemnts are: ");
            System.out.println("---------------------------");
            eachColumnElements.stream().forEach(t -> System.out.println(t.getText()));
            System.out.println();
        }
    }

}
