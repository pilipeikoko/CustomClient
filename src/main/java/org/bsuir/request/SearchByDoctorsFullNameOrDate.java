package org.bsuir.request;

import org.bsuir.util.CustomDate;
import org.bsuir.util.RequestType;

public class SearchByDoctorsFullNameOrDate extends ServerRequest {
    private CustomDate birthday;
    private String doctorsFullName;

    public SearchByDoctorsFullNameOrDate() {
        super();
    }

    public SearchByDoctorsFullNameOrDate(String doctorsFullName, CustomDate birthday) {
        this.birthday = birthday;
        this.doctorsFullName = doctorsFullName;
        this.requestType = RequestType.SEARCH_BY_DOCTORS_NAME_OR_DATE;
    }

    public CustomDate getBirthday() {
        return birthday;
    }

    public String getDoctorsFullName() {
        return doctorsFullName;
    }
}
