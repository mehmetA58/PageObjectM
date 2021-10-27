package tests.day17_ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01_ReadExcel {

    @Test
    public void test() throws IOException {
        //. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        //11. Worksheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(4);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell= row.getCell(1);

        System.out.println(cell);
    }
    @Test
    public void test2() throws IOException {
        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Cell cell=workbook.getSheet("Sayfa1").getRow(5).getCell(3);
        System.out.println(cell);

        Assert.assertEquals(cell.getStringCellValue(),"Luanda","beklenmeyen sonuc");

      //3.satir 2.sütün büyük harfle
       Cell cell1=workbook.getSheet("Sayfa1").getRow(3).getCell(2);

        System.out.println(cell1.getStringCellValue().toUpperCase());//CEZAYİR

        System.out.println( workbook.getSheet("Sayfa1").getLastRowNum());//190
        System.out.println(workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());//191

        System.out.println( workbook.getSheet("Sayfa2").getLastRowNum());
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());
    }

    @Test
    public void test3() throws IOException {
        //tablodaki 2.sutun'u bir liste olaarak yazdirin

        List<String> ikinciSutun=new ArrayList<>();

        String dosyaYolu="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        for (int i = 0; i <=workbook.getSheet("Sayfa1").getLastRowNum() ; i++) {
          ikinciSutun.add(workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString());

        }
        System.out.println(ikinciSutun);

        //A ile başlayan
        List<String>aIleBaslayanSehirler=new ArrayList<>();

//        for (String each:ikinciSutun) {
//            if (each.startsWith("A")){
//                aIleBaslayanSehirler.add(each);
//            }
//        } System.out.println(aIleBaslayanSehirler);

        ikinciSutun.stream().filter(t->t.startsWith("A")).forEach(t->aIleBaslayanSehirler.add(t));
        System.out.println(aIleBaslayanSehirler);


        //eger tum datayi java'dakullanilabilir bir collection'a cevirmek istesek
        //en uygun yapi map olur
        //map icin uniqe degerlere sahip bir sutun key
        //geriye kalan tum sutunlari ise virgulle ayrilan string'ler olarak value yapmaliyiz
        //key=Turkey value=Ankara,Turkiye,Ankara
        Map<String,String> ulkelerMap=new HashMap<>();
        String key="";
        String value="";

        for (int i = 0; i <=workbook.getSheet("Sayfa1").getLastRowNum() ; i++) {
            key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).getStringCellValue();
            value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).getStringCellValue()+","+
            workbook.getSheet("Sayfa1").getRow(i).getCell(1).getStringCellValue()+","+
            workbook.getSheet("Sayfa1").getRow(i).getCell(1).getStringCellValue();
            ulkelerMap.put(key,value);
        }
        System.out.println("ulkelerMap = " + ulkelerMap);

        //Biz java method'larini ve collections'i kullnarak excel'deki datalari manipule edebileceğimiz
        //java ortamina alabiliriz
    }
}
