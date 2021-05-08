package org.obrii.fitdocs.entities;

import org.attoparser.dom.Text;

public class FieldValues {



    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int fieldId;

    public int getfieldId() {
        return fieldId;
    }

    public void setfieldId(int fieldId) {
        this.fieldId = fieldId;
    }



    public int groupId;

    public int getgroupId() {
        return groupId;
    }

    public void setgroupId(int groupId) {
        this.groupId = groupId;
    }



    public int docId;

    public int getdocId() {
        return docId;
    }

    public void setdocId(int docId) {
        this.docId = docId;
    }



    public Text value;

    public Text getvalue() {
        return value;
    }

    public void setdocId(Text value) {
        this.value = value;
    }
}
