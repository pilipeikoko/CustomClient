package org.bsuir.util;

import java.io.Serializable;

public enum RequestType implements Serializable {
    DELETE_BY_FULL_NAME_OR_ADDRESS,
    DELETE_BY_BIRTHDAY,
    DELETE_BY_DOCTORS_NAME_OR_DATE,
    SEARCH_BY_FULL_NAME_OR_ADDRESS,
    SEARCH_BY_BIRTHDAY,
    SEARCH_BY_DOCTORS_NAME_OR_DATE,
    ADD,
    SAVE_TO_FILE,
    READ_FROM_FILE,
    FIND_PAGE,
    GET_AMOUNT_OF_PATIENTS,
    FIND_PAGE_BY_LIST
}
