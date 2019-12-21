package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Sale;
import arkham.knight.gamestop.repositories.SaleRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServices {

    @Autowired
    private SaleRepository saleRepository;


    public void exportReport(String reportFormat) throws FileNotFoundException, JRException {

        String path = "C:\\Reports";

        List<Sale> salesToShowInTheReport = saleRepository.findAll();


        File fileForTheReport = ResourceUtils.getFile("classpath:sales.jrxml");

        JasperReport saleReport = JasperCompileManager.compileReport(fileForTheReport.getAbsolutePath());

        JRBeanCollectionDataSource reportDataSource = new JRBeanCollectionDataSource(salesToShowInTheReport);

        Map<String, Object> parameters = new HashMap<>();

        parameters.put("createdby","ArkhamKnight");

        JasperPrint jasperPrint = JasperFillManager.fillReport(saleReport,parameters, reportDataSource);


        if (reportFormat.equalsIgnoreCase("pdf")){

            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\sales.pdf");
        }
    }
}
