package com.happn.techtest.parsers;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.happn.techtest.entities.POI;
import com.happn.techtest.entities.POIsOfFile;
import com.univocity.parsers.common.ParsingContext;
import com.univocity.parsers.common.processor.ObjectRowProcessor;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

@Configuration
public class FileParser {
	@Value("classpath:datas/data.tsv")
	Resource resourceFile;

	private final String WHITE_SPACE_DELIMITER = "\\s+";
	private final String FILE_ENCODAGE = "UTF-8";

	@PostConstruct
	public void init() {
		TsvParserSettings settings = new TsvParserSettings();
		settings.setHeaderExtractionEnabled(true);
		ObjectRowProcessor rowProcessor = new ObjectRowProcessor()
		{
			@Override
			public void rowProcessed(Object[] row, ParsingContext parsingContext)
			{
				String[] strArray = row[0].toString().split(WHITE_SPACE_DELIMITER);
				POIsOfFile.add(strArray[0], new POI(Float.parseFloat(strArray[1]), Float.parseFloat(strArray[2])));
			}
		};

		settings.setRowProcessor(rowProcessor);
		TsvParser parser = new TsvParser(settings);
		
		try {
			parser.parseAll(resourceFile.getInputStream(), FILE_ENCODAGE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
