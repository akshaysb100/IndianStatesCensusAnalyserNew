package com.stateinformation.com;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateAnalyser {

    public int openCSVBuilder(String STATE_CENSUS_DATA_CSV_FILE_PATH) {
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(STATE_CENSUS_DATA_CSV_FILE_PATH));
            CsvToBean<CSVStateCensus> cavToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVStateCensus.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVStateCensus> csvUserIterator = cavToBean.iterator();
            while (csvUserIterator.hasNext()) {
                count++;
                CSVStateCensus csvUser = csvUserIterator.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

}