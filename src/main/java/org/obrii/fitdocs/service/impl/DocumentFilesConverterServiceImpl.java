package org.obrii.fitdocs.service.impl;

import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.obrii.fitdocs.core.DocType;
import org.obrii.fitdocs.core.Resources;
import org.obrii.fitdocs.entities.FieldValue;
import org.obrii.fitdocs.service.DocumentFilesConverterService;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class DocumentFilesConverterServiceImpl implements DocumentFilesConverterService {

    @Override
    public void fillTemplate(String sourcePath, String destinationPath, FieldValue[] values) throws IOException {
        this.fillTemplate(sourcePath, destinationPath, values, DocType.Word);
    }

    @Override
    public void fillTemplate(String sourcePath, String destinationPath, FieldValue[] values, DocType docType) throws IOException {
        XWPFDocument template = new XWPFDocument(Resources.readFileStream(sourcePath));

        for (XWPFParagraph paragraph : template.getParagraphs()) {
            this.replaceParagraph(paragraph, values);
        }

        template.write(new FileOutputStream(destinationPath));
    }

    private void replaceParagraph(XWPFParagraph paragraph, FieldValue[] values) throws POIXMLException {
        String find, text, runsText;
        XWPFRun run, nextRun;

        for (FieldValue value : values) {

            String keyName = value.getKey().getText();
            text = paragraph.getText();
            if (!text.contains("${")) return;

            find = "${" + keyName + "}";
            if (!text.contains(find)) continue;

            List<XWPFRun> runs = paragraph.getRuns();
            for (int i = 0; i < runs.size(); i++) {
                run = runs.get(i);
                runsText = run.getText(0);

                if (runsText.contains("${") || (runsText.contains("$") && runs.get(i + 1).getText(0).charAt(0) == '{')) {

                    //As the next run may has a closed tag and an open tag at
                    //the same time, we have to be sure that our building string
                    //has a fully completed tags
                    while (!this.openTagCountIsEqualCloseTagCount(runsText)) {
                        nextRun = runs.get(i + 1);
                        runsText = runsText + nextRun.getText(0);
                        paragraph.removeRun(i + 1);
                    }
                    run.setText(runsText.contains(find)
                            ? runsText.replace(find, value.getText())
                            : runsText, 0);
                }
            }
        }
    }

    private boolean openTagCountIsEqualCloseTagCount(String runText) {
        int openTagCount = runText.split("\\$\\{", -1).length - 1;
        int closeTagCount = runText.split("}", -1).length - 1;
        return openTagCount == closeTagCount;
    }
}
