package io.product.recommendation.service.impl;

import io.product.recommendation.model.Product;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import io.product.recommendation.dao.ProductDao;
import io.product.recommendation.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;


    @Override
    public void saveProductCSV(String filePath) {
        File productCsvFile = new File(filePath);
        try (BufferedReader fileReader = new BufferedReader(new FileReader(productCsvFile));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);)
             {
                 List<Product> products = new ArrayList<Product>();

                 Iterable<CSVRecord> csvRecords = csvParser.getRecords();

                 for(CSVRecord csvRecord: csvRecords) {
                    if (!csvRecord.get(0).equals("id")  && !csvRecord.get(0).equals("") ) {

                        Product product = new Product(
                                Long.parseLong(csvRecord.get(0)),
                                csvRecord.get(1),
                                csvRecord.get(2),
                                csvRecord.get(3),
                                Long.parseLong(csvRecord.get(4)),
                                Double.parseDouble(csvRecord.get(5)),
                                Double.parseDouble(csvRecord.get(6))
                        );
                        products.add(product);
                    }
                 }
                 logger.info("{saveProductCSV} Parsed Products "+ products.size());
                 productDao.saveAll(products);
             } catch (IOException e) {
            logger.error("{saveProductCSV} Error while parsing: "+ e);
            e.printStackTrace();
        }
    }
}
