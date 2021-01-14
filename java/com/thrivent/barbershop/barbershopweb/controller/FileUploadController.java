package com.thrivent.barbershop.barbershopweb.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {
  
    @GetMapping("/fileupload")
    public String listUploadedFiles(Model model) throws IOException {

        return "uploadForm";
    }

    @PostMapping("/fileupload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
            RedirectAttributes redirectAttributes) {
    	
    	byte[] byteArr = null;
		try {
			byteArr = file.getBytes();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	InputStream inputStream = new ByteArrayInputStream(byteArr);
    	
    	Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet sheet = null;
		try {
			sheet = workbook.getSheetAt(0);
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	 
    	Map<Integer, List<String>> data = new HashMap<>();
    	int i = 0;
    	for (Row row : sheet) {
    	    data.put(i, new ArrayList<String>());
    	    for (Cell cell : row) {
    	        switch (cell.getCellTypeEnum()) {
    	            case STRING: data.get(new Integer(i)).add(cell.getRichStringCellValue().getString());
    	            break;
    	            case NUMERIC: if (DateUtil.isCellDateFormatted(cell)) {
    	                data.get(i).add(cell.getDateCellValue() + "");
    	            } else {
    	                data.get(i).add(cell.getNumericCellValue() + "");
    	            } break;
    	            case BOOLEAN: data.get(i).add(cell.getBooleanCellValue() + "");
    	            break;
    	            case FORMULA: data.get(i).add(cell.getCellFormula() + "");
    	            break;
    	            default: data.get(new Integer(i)).add(" ");
    	        }
    	    }
    	    i++;
    	}
    	
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }
}
