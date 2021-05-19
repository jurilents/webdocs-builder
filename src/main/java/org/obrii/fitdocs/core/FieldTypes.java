package org.obrii.fitdocs.core;

public enum FieldTypes {
    Text((short) 1),
//    Number((short) 2),
    Date((short) 3),
    DateTime((short) 4),
    Select((short) 5);

    private short value;

    public short getValue() {
        return this.value;
    }

    FieldTypes(short value) {
        this.value = value;
    }
}
